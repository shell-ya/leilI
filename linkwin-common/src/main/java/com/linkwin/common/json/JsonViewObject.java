package com.linkwin.common.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class JsonViewObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String status;
    private String msg;
    private Integer code;
    private Object data;


    public void success(String msg){
        success("success",msg,null);
    }

    public void success(Object data){
        success("success","true",data);
    }

    public void success(String msg,Object data){
        success("success",msg,data);
    }

    public void success(String staus,String msg,Object data){
        success(staus,msg,data,0);
    }
    public void success(String staus,String msg,Object data,Integer code){
        this.status=staus;
        this.msg=msg;
        this.data=(Object) data;
        this.code=code;
    }

    public void fail(String msg){
        fail(msg,"fail");
    }

    public void fail(String msg,Object obj){
        fail(msg,obj,-1);
    }

    public void fail(String msg,Object obj,Integer code){
        this.status="fail";
        this.msg=msg;
        this.data=obj;
        this.code=code;
    }









}
