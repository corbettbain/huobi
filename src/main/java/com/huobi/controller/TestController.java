//package com.huobi.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.huobi.pojo.HuoBiData;
//import com.huobi.service.HuoBiService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by hasee on 2018/1/31.
// */
//@RestController
//public class TestController {
//
//    @Autowired
//    private HuoBiService huoBiService;
//
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//    public JSONObject hello(){
//        try {
//            return JSONObject.parseObject(JSON.toJSONString(huoBiService.get("iostusdt")));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return JSONObject.parseObject(JSON.toJSONString(e));
//        }
//    }
//}
