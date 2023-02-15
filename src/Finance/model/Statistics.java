package Finance.model;

import Finance.saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {
    public static double getBalanceCurrency(Currency currency) // баланс всех счетов одной валюты
    {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            if (account.getCurrency().equals(currency)) {
                amount += account.getAmount();
            }
        }
        return amount;
    }
    public static double getBalance(Currency currency) // баланс всех счетов в базовой валюте
    {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    public static HashMap<String, Double> getDataForChartIncomeArticles(){
        return getDataForChartArticle(true);
    }
    public static HashMap<String, Double> getDataForChartExpenseArticles(){
        return getDataForChartArticle(false);
    }
    private static HashMap<String, Double> getDataForChartArticle(boolean income) // данные для графика статистики по статьям
    {
        List<Transactions> transactions = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for(Transactions t : transactions)
        {
            if((income && t.getAmount() > 0) || (!income && t.getAmount() < 0))
            {
                String key = t.getArticle().getTitle();
                double sum = 0;
                double amount = t.getAmount();
                if(!income) amount *= -1;
                if(data.containsKey(key)) sum = data.get(key);

                sum += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(sum));
            }
        }
        return data;
    }



    private static double round(double value){
        return (double) Math.round(value * 100) / 100;
    }

}
