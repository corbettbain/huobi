package com.huobi.service;

import com.huobi.pojo.HuoBiData;

/**
 * @author Created by hasee on 2018/2/1.
 */
public interface Message {
    void send(HuoBiData huoBiData) throws Exception;
}
