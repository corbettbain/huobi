package com.huobi.service.impl;

import com.huobi.enums.WarningTypeEnum;
import com.huobi.pojo.HuoBiData;
import com.huobi.service.AbstractHuoBiMessage;
import com.huobi.service.HuoBiService;
import com.huobi.utils.HuoBiUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Created by hasee on 2018/2/2.
 */
@Service
public class FluctuationMessage extends AbstractHuoBiMessage {
    public static Double preValue = 0.0;

    @Override
    protected boolean isSms(HuoBiData huoBiData) {

        double p = preValue;
        preValue = huoBiData.getClose().doubleValue();
        if (p != 0.0) {
            double pre = HuoBiUtil.getPercentage(new BigDecimal(p), huoBiData.getClose()).doubleValue();
            if (pre >= HuoBiService.percentage.get(WarningTypeEnum.FLUCTUATION.name())
                    || pre <= -HuoBiService.percentage.get(WarningTypeEnum.FLUCTUATION.name())) {
                super.threadLocal.set("当前" + huoBiData.getSymbol() + "为:" + huoBiData.getClose().doubleValue() + "--相对10秒前的值的增长率为:" +
                        pre + "--您的预期值正常率为:+-" + HuoBiService.percentage.get(WarningTypeEnum.FLUCTUATION.name()));
                return true;
            }
        }
        return false;
    }
}
