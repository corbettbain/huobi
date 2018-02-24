package com.huobi.service.impl;

import com.huobi.enums.WarningTypeEnum;
import com.huobi.pojo.HuoBiData;
import com.huobi.service.AbstractHuoBiMessage;
import com.huobi.service.HuoBiService;
import com.huobi.utils.HuoBiUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/** 相对于自身设置的值的百分比
 * @author Created by hasee on 2018/2/2.
 */
@Service
public class CurMineMessage extends AbstractHuoBiMessage{

    @Override
    protected boolean isSms(HuoBiData huoBiData) {
        double pre = HuoBiUtil.getPercentage(new BigDecimal(HuoBiService.mine),huoBiData.getClose()).doubleValue();
        if (pre>=HuoBiService.percentage.get(WarningTypeEnum.CUR_MINE.name())){
            super.threadLocal.set("CurMineMessage:当前" + huoBiData.getSymbol() + "为:"
                    + huoBiData.getClose().doubleValue() + "--相对于自定义值增长率为:" +
                    pre + "--您的自定义值为:" + HuoBiService.mine);
            return true;
        }
        return false;
    }
}
