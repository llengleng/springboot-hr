package com.niit.springboothr.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lenovo
 * @date : 2020/4/18 19：31
 * @description :
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    public static RespBean ok(String msg){
        return new RespBean(200,msg,null);
    }
    public static RespBean ok(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }
    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }
    public static RespBean error(String msg,Object obj){
        return new RespBean(500,msg,obj);
    }

}
