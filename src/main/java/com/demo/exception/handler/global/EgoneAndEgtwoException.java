package com.demo.exception.handler.global;

public class EgoneAndEgtwoException extends Exception{
    private static final long serialVersionUID = 1L;

    //业务类型
    private String bizType;
    //业务代码
    private int bizCode;
    //错误信息
    private String message;

    public EgoneAndEgtwoException(String bizType, int bizCode, String message){
        super(message);
        this.bizType = bizType;
        this.bizCode = bizCode;
        this.message = message;
    }

    public EgoneAndEgtwoException(String message){
        super(message);
        this.bizType = "";
        this.bizCode = -1;
        this.message = message;
    }

    public EgoneAndEgtwoException(String bizType, String message){
        super(message);
        this.bizType = bizType;
        this.bizCode = -1;
        this.message = message;
    }

    public EgoneAndEgtwoException(int bizCode, String message){
        super(message);
        this.bizType = "";
        this.bizCode = bizCode;
        this.message = message;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public int getBizCode() {
        return bizCode;
    }

    public void setBizCode(int bizCode) {
        this.bizCode = bizCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
