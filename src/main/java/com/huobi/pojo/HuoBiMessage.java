package com.huobi.pojo;

/**
 * @author Created by hasee on 2018/2/1.
 */
public class HuoBiMessage {
    private String curValue;
    private String defalueValue;
    private String defalutPercentage;
    private String curPercentage;
    private String symbol;
    private String smsText;

    public String getCurValue() {
        return curValue;
    }

    public void setCurValue(String curValue) {
        this.curValue = curValue;
    }

    public String getDefalueValue() {
        return defalueValue;
    }

    public void setDefalueValue(String defalueValue) {
        this.defalueValue = defalueValue;
    }

    public String getDefalutPercentage() {
        return defalutPercentage;
    }

    public void setDefalutPercentage(String defalutPercentage) {
        this.defalutPercentage = defalutPercentage;
    }

    public String getCurPercentage() {
        return curPercentage;
    }

    public void setCurPercentage(String curPercentage) {
        this.curPercentage = curPercentage;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public HuoBiMessage() {
    }

    public HuoBiMessage(String curValue, String defalueValue, String defalutPercentage, String curPercentage, String symbol, String smsText) {
        this.curValue = curValue;
        this.defalueValue = defalueValue;
        this.defalutPercentage = defalutPercentage;
        this.curPercentage = curPercentage;
        this.symbol = symbol;
        this.smsText = smsText;
    }

    @Override
    public String toString() {
        return "HuoBIMessage{" +
                "curValue='" + curValue + '\'' +
                ", defalueValue='" + defalueValue + '\'' +
                ", defalutPercentage='" + defalutPercentage + '\'' +
                ", curPercentage='" + curPercentage + '\'' +
                ", symbol='" + symbol + '\'' +
                ", smsText='" + smsText + '\'' +
                '}';
    }
}
