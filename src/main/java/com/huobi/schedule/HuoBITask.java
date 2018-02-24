package com.huobi.schedule;

import com.corbett.utils.date.DateFormat;
import com.corbett.utils.spring.SpringContextUtil;
import com.huobi.enums.WarningTypeEnum;
import com.huobi.javafx.controller.RootController;
import com.huobi.pojo.HuoBiData;
import com.huobi.service.HuoBiService;
import com.huobi.service.Message;
import com.huobi.utils.HuoBiUtil;
import javafx.application.Platform;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Created by hasee on 2018/2/1.
 */
@Component
public class HuoBITask {

    private RootController rootController;

    public void setRootController(RootController rootController) {
        this.rootController = rootController;
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void doit() {
        HuoBiData huoBiData;
        try {

            HuoBiService huoBiService = SpringContextUtil.getBean("HuoBiServiceImpl");
            huoBiData = huoBiService.get(HuoBiService.symbol.containsKey("default") ? HuoBiService.symbol.get("default") : "iostusdt");
            System.out.println("【" + DateFormat.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss") + "】" + huoBiData);
            Platform.runLater(() -> {
                rootController.getSymbol().setText(huoBiData.getSymbol() + ":");
                rootController.getClose().setText(String.valueOf(huoBiData.getClose().doubleValue()));
                rootController.getPreg().setText(
                        String.valueOf(HuoBiUtil.getPercentage(huoBiData.getOpen(),huoBiData.getClose()).doubleValue()));
                rootController.getTime().setText("【" + DateFormat.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss") + "】");
            });
            Message defaultMessage = SpringContextUtil.getBean(WarningTypeEnum.DEFAULT.getCalculateBean());
            Message fluctuationMessage = SpringContextUtil.getBean(WarningTypeEnum.FLUCTUATION.getCalculateBean());
            Message curMineMessage = SpringContextUtil.getBean(WarningTypeEnum.CUR_MINE.getCalculateBean());
            Message curWithHeightMessage = SpringContextUtil.getBean(WarningTypeEnum.CUR_HEIGHT.getCalculateBean());
            defaultMessage.send(huoBiData);
            fluctuationMessage.send(huoBiData);
            curMineMessage.send(huoBiData);
            curWithHeightMessage.send(huoBiData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
