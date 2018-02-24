package com.huobi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.corbett.enums.RequestMethod;
import com.corbett.exception.CorbettException;
import com.corbett.utils.http.HttpClient;
import com.huobi.pojo.HuoBiData;
import com.huobi.pojo.HuoBiResult;
import com.huobi.service.HuoBiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2018/1/31.
 */
@Service("HuoBiServiceImpl")
public class HuoBiServiceImpl implements HuoBiService{

    private static final String URL = "https://l10n.huobi.cn/market/overview";

    @Override
    public List<HuoBiData> get() throws Exception {
        return getHuobiDatas();
    }

    @Override
    public List<HuoBiData> get(String... symbols) throws Exception {
        List<HuoBiData> huoBiDataList = getAndCheckHuoBiDatas(symbols);
        if (huoBiDataList.size() == 0)
            throw new CorbettException("check symbols");
        return huoBiDataList;
    }

    @Override
    public HuoBiData get(String symbol) throws Exception {
        return getAndCheckHuoBiDatas(symbol).get(0);
    }

    private List<HuoBiData> getAndCheckHuoBiDatas(String...symbols) throws Exception {
        List<HuoBiData> huoBiDataList = new ArrayList<>(symbols.length);
        List<HuoBiData> huoBiDatas = getHuobiDatas();
        huoBiDatas.forEach((k)->{
            for (String symbol : symbols) {
                if (k.getSymbol().equals(symbol)){
                    huoBiDataList.add(k);
                }
            }
        });
        return huoBiDataList;
    }

    private List<HuoBiData> getHuobiDatas() throws Exception {

        String data = HttpClient.getUrlDataWithKeyValue(URL,null, RequestMethod.GET,HttpClient.getRequestHeader());
        HuoBiResult huoBiResult = JSONObject.toJavaObject(JSON.parseObject(data),HuoBiResult.class);
        if (huoBiResult.getStatus().equals("ok")){
            return huoBiResult.getData();
        }
        throw new CorbettException("get fail");
    }
}
