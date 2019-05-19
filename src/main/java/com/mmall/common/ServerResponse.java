package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @author Maoxin
 * @date 1/28/2019
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse(int status,String message){
        this.status =status;
        this.msg = message;
    }
    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg =msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }
    public int getStatus(){
        return this.status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<>(ResponseCode.ERROR.getCode());
    }
    public static <T> ServerResponse<T> createByError(String msg){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),msg);
    }
    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<>(errorCode,errorMessage);
    }

}
