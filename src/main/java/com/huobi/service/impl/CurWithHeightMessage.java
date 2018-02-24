package com.huobi.service.impl;

import com.huobi.enums.WarningTypeEnum;
import com.huobi.pojo.HuoBiData;
import com.huobi.service.AbstractHuoBiMessage;
import com.huobi.service.HuoBiService;
import com.huobi.utils.HuoBiUtil;
import org.springframework.stereotype.Service;

/**
 * @author Created by hasee on 2018/2/2.
 */
@Service
public class CurWithHeightMessage extends AbstractHuoBiMessage {

    @Override
    protected boolean isSms(HuoBiData huoBiData) {
        double pre = HuoBiUtil.getPercentage(huoBiData.getHigh(), huoBiData.getClose()).doubleValue();
        if (pre
                <= HuoBiService.percentage.get(WarningTypeEnum.CUR_HEIGHT.name())){
            super.threadLocal.set("CurWithHeightMessage:当前" + huoBiData.getSymbol() + "为:"
                    + huoBiData.getClose().doubleValue() + "--相对于最高点增长率为:" +
                    pre + "--您的预期值正常率为:" + HuoBiService.percentage.get(WarningTypeEnum.CUR_HEIGHT.name()));
            return true;
        }
        return false;
    }
}
