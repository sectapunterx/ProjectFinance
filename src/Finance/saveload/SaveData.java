package Finance.saveload;

import Finance.model.*;

import java.util.ArrayList;
import java.util.List;

public class SaveData {
    private static SaveData instance; // синглтон
    private List<Article> articles = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Transactions> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    private SaveData(){

    }
    public static SaveData getInstance() // синглтон
    {
        if(instance == null){
            instance = new SaveData();
        }
        return instance;
    }

    public List<Article> getArticles() {
        return articles;
    }
    public List<Currency> getCurrencies() {
        return currencies;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public List<Transactions> getTransactions() {
        return transactions;
    }
    public List<Transfer> getTransfers() {
        return transfers;
    }

    public Currency getBaseCurrency() // базовая валюта
    {
        for(Currency c : currencies)
        {
            if(c.isBase()) return c;
            return new Currency();
        }
        return null;
    }



    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
}
