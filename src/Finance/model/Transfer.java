package Finance.model;

import Finance.exception.ModelException;

import java.util.Date;

public class Transfer extends Common {

    private Account accountFrom; // счет списания
    private Account accountTo; // счет зачисления
    private double fromAmount; // ушедшая сумма
    private double toAmount; // пришедшая сумма
    private String notice; // примечание
    private Date date; // дата

    public Transfer() {
    }

    public Transfer(Account accountFrom, Account accountTo, double fromAmount, double toAmount, String notice, Date date) throws ModelException {
        if (accountFrom == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (accountTo == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (fromAmount < 0 || toAmount < 0) throw new ModelException(ModelException.AMOUNT_FORMAT);

        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.notice = notice;
        this.date = date;
    }

    public Transfer(Account accountFrom, Account accountTo, double fromAmount, double toAmount, String notice) throws ModelException {
        this(accountFrom, accountTo, fromAmount, toAmount, notice, new Date());
    }

    public Transfer(Account accountFrom, Account accountTo, double fromAmount, double toAmount, Date date) throws ModelException {
        this(accountFrom, accountTo, fromAmount, toAmount, "", date);
    }

    public Transfer(Account accountFrom, Account accountTo, double fromAmount, double toAmount) throws ModelException {
        this(accountFrom, accountTo, fromAmount, toAmount, "", new Date());
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) throws ModelException {
        if (accountFrom == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        this.accountFrom = accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) throws ModelException {
        if (accountTo == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        this.accountTo = accountTo;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "accountFrom=" + accountFrom +
                ", accountTo=" + accountTo +
                ", fromAmount=" + fromAmount +
                ", toAmount=" + toAmount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }

}
