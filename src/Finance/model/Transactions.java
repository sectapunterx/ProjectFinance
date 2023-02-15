package Finance.model;

import Finance.exception.ModelException;

import java.util.Date;

public class Transactions extends Common{
    private Account account; // счет
    private Article article; // статья (з/п, продукты...)
    private double amount; // сумма
    private String notice; // примечание
    private Date date; // дата

    public Transactions() {
    }

    public Transactions(Account account, Article article, double amount, String notice, Date date) throws ModelException {
        if(account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if(article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = notice;
        this.date = date;
    }
    public Transactions(Account account, Article article, double amount, String notice) throws ModelException {
        this(account, article, amount, notice, new Date());
    }
    public Transactions(Account account, Article article, double amount, Date date) throws ModelException {
        this(account, article, amount, "", date);
    }
    public Transactions(Account account, Article article, double amount) throws ModelException {
        this(account, article, amount, "", new Date());
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) throws ModelException {
        if(account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        this.account = account;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) throws ModelException {
        if(article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.article = article;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
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
        return "Transactions{" +
                "account=" + account +
                ", article=" + article +
                ", amount=" + amount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }

}
