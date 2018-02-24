package com.huobi.pojo;

import java.util.List;

/**
 * Created by hasee on 2018/1/31.
 */
public class HuoBiResult {
    private Long ts;
    private String status;
    List<HuoBiData> data;

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<HuoBiData> getData() {
        return data;
    }

    public void setData(List<HuoBiData> data) {
        this.data = data;
    }

    public HuoBiResult(){}

    public HuoBiResult(Long ts, String status, List<HuoBiData> data) {
        this.ts = ts;
        this.status = status;
        this.data = data;
    }

    @Override
    public String toString() {
        return "HuoBiResult{" +
                "ts=" + ts +
                ", status='" + status + '\'' +
                ", datas=" + data +
                '}';
    }
}
