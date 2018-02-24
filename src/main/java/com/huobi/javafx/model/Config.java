package com.huobi.javafx.model;

import javafx.beans.property.StringProperty;

/**
 * @author Created by hasee on 2018/2/10.
 */
public class Config {
    private StringProperty symbol;
    private StringProperty heightest;
    private StringProperty normal;
    private StringProperty fluctuation;

    public String getSymbol() {
        return symbol.get();
    }

    public StringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    public String getHeightest() {
        return heightest.get();
    }

    public StringProperty heightestProperty() {
        return heightest;
    }

    public void setHeightest(String heightest) {
        this.heightest.set(heightest);
    }

    public String getNormal() {
        return normal.get();
    }

    public StringProperty normalProperty() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal.set(normal);
    }

    public String getFluctuation() {
        return fluctuation.get();
    }

    public StringProperty fluctuationProperty() {
        return fluctuation;
    }

    public void setFluctuation(String fluctuation) {
        this.fluctuation.set(fluctuation);
    }

    public Config(StringProperty symbol, StringProperty heightest, StringProperty normal, StringProperty fluctuation) {
        this.symbol = symbol;
        this.heightest = heightest;
        this.normal = normal;
        this.fluctuation = fluctuation;
    }
}
