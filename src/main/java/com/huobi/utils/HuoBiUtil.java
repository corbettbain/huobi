package com.huobi.utils;

import java.math.BigDecimal;

/**
 * @author Created by hasee on 2018/2/1.
 */
public class HuoBiUtil {

    public static BigDecimal getPercentage(BigDecimal main,BigDecimal curr){

        return curr.subtract(main).divide(main,4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100));
    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.055100000000000000);
        BigDecimal b = new BigDecimal(0.065400000000000000);
        System.out.println(getPercentage(a,b).doubleValue());
    }
}
