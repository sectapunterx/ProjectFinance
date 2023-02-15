package Finance.model;

import Finance.exception.ModelException;

import java.util.List;
import java.util.Objects;

public class Account extends Common{
    private String title;
    private Currency currency;
    private double startAmount; // начальный остаток
    private double amount; // текущий остаток

    public Account(){}

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if(currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws ModelException {
        if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) throws ModelException {
        if(currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.currency = currency;
    }
    public double getStartAmount() {
        return startAmount;
    }
    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return title.equals(account.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    public String getValueForComboBox() {
        return title;
    }

    public void setAmountFromTransaction(List<Transactions> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transactions transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                this.amount += transaction.getAmount();
            }
        }
        for (Transfer transfer : transfers) {
            if (transfer.getAccountFrom().equals(this)) {
                this.amount -= transfer.getFromAmount();
            }
            if (transfer.getAccountTo().equals(this)) {
                this.amount += transfer.getToAmount();
            }
        }
    }
}
