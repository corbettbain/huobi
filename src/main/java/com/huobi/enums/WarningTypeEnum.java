package com.huobi.enums;

/**
 * @author Created by hasee on 2018/2/1.
 */
public enum WarningTypeEnum {
    /**
     * 最高和当前相比较
     */
    CUR_HEIGHT("curWithHeightMessage"),
    /**
     * 当前和自定义相比较
     */
    CUR_MINE("curMineMessage"),
    /**
     * 默认值与自定义值相比较
     */
    DEFAULT("defaultMessage"),

    /**
     * 波动较大
     */
    FLUCTUATION("fluctuationMessage"),

    ;

    private String calculateBean;
    private WarningTypeEnum(String calculateBean){
        setCalculateBean(calculateBean);
    }

    public String getCalculateBean() {
        return calculateBean;
    }

    public void setCalculateBean(String calculateBean) {
        this.calculateBean = calculateBean;
    }
}
