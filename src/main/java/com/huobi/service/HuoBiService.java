package com.huobi.service;

import com.huobi.pojo.HuoBiData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hasee on 2018/1/31.
 */
public interface HuoBiService {

    public static Map<String,Double> percentage = new ConcurrentHashMap<>();
    public static Map<String,String> symbol = new ConcurrentHashMap<>();
    public static double mine = 0.1;


    List<HuoBiData> get() throws Exception;
    List<HuoBiData> get(String... symbols) throws Exception;
    HuoBiData get(String symbol) throws Exception;
}
