package com.xiangyun.spring_boot.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

/**
 * 消息发送类
 */
public class XiangYunResponse {
    private String responseMessage;

    public XiangYunResponse() {
    }

    public XiangYunResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
