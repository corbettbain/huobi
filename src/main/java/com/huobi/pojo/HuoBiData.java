package com.huobi.pojo;

import java.math.BigDecimal;

/**
 * Created by hasee on 2018/1/31.
 */
public class HuoBiData {
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal amount;
    private Integer count;
    private BigDecimal vol;
    private String symbol;

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public HuoBiData(){}

    public HuoBiData(BigDecimal open, BigDecimal close, BigDecimal low, BigDecimal high, BigDecimal amount, Integer count, BigDecimal vol, String symbol) {
        this.open = open;
        this.close = close;
        this.low = low;
        this.high = high;
        this.amount = amount;
        this.count = count;
        this.vol = vol;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "HuoBiData{" +
                "open=" + open +
                ", close=" + close +
                ", low=" + low +
                ", height=" + high +
                ", amount=" + amount +
                ", count=" + count +
                ", vol=" + vol +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
