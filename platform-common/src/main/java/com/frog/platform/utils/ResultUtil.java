package com.frog.platform.utils;

import java.io.Serializable;

public class ResultUtil implements Serializable{

    private String message;
    private Integer status;
    private boolean success;

    public static ResultUtil ok(){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMessage("ok");
        resultUtil.setStatus(200);
        resultUtil.setSuccess(true);

        return resultUtil;
    }
    public static ResultUtil result(String message,Integer status,boolean success){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setMessage(message);
        resultUtil.setStatus(status);
        resultUtil.setSuccess(success);
        return resultUtil;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
