package com.niit.springboothr.model;

import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/5/23 14：56
 * @description :
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
