package com.huobi.service;


import com.corbett.utils.date.DateFormat;
import com.huobi.pojo.HuoBiData;

import java.util.Date;

/**
 * @author Created by hasee on 2018/2/1.
 */
public abstract class AbstractHuoBiMessage implements Message {

    protected ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public void send(HuoBiData huoBiData) throws Exception {
        if (isSms(huoBiData)) {
            System.out.println("【" + DateFormat.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss") + "】" + getMessage());
            send(getMessage());
        }
    }

    protected String getMessage() {
        return threadLocal.get();
    }

    protected abstract boolean isSms(HuoBiData huoBiData);

    private void send(String smsText) {

    }
}
