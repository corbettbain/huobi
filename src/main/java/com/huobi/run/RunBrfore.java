package com.huobi.run;

import com.huobi.enums.WarningTypeEnum;
import com.huobi.service.HuoBiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Created by hasee on 2018/2/1.
 */
@Component
@Order(1)
public class RunBrfore implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        HuoBiService.percentage.put(WarningTypeEnum.DEFAULT.name(),-10.0);
        HuoBiService.percentage.put(WarningTypeEnum.CUR_HEIGHT.name(),-3.0);
        HuoBiService.percentage.put(WarningTypeEnum.CUR_MINE.name(),1.0);
        HuoBiService.percentage.put(WarningTypeEnum.FLUCTUATION.name(),5.0);
        HuoBiService.symbol.put("default","iostusdt");
    }
}
