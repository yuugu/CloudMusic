package com.yuugu.cloud.scaffold.manner;

/**
 * @author: yuugu
 * @date: 2020/7/16
 */
public class NetState {

    private String responseCode;
    private boolean success = true;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}