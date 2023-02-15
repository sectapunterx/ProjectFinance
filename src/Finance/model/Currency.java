package Finance.model;

import Finance.exception.ModelException;

import java.util.Objects;

public class Currency extends Common{
    private String title; // название валюты
    private String code; // код валюты
    private double rate; // курс валюты
    private boolean Base; // является ли валюта базовой
    private boolean On; // включена ли валюта в расчеты

    public Currency(){}

    public Currency(String title, String code, double rate, boolean Base, boolean On) throws ModelException {
        if(title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if(code.length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
        if(rate <= 0) throw new ModelException(ModelException.RATE_INCORRECT);
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.Base = Base;
        this.On = On;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isBase() {
        return Base;
    }

    public void setBase(boolean base) {
        Base = base;
    }

    public boolean isOn() {
        return On;
    }

    public void setOn(boolean on) {
        On = on;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", isBase=" + Base +
                ", isOn=" + On +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency currency)) return false;
        return code.equals(currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
    public String getValueForComboBox(){
        return title;
    }
    public double getRateByCurrency(Currency currency){
        return rate / currency.rate;
    }

}
