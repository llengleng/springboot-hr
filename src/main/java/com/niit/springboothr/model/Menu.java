package com.niit.springboothr.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/18 18：46
 * @description :
 */
@Data
public class Menu implements Serializable {
    private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Integer parentId;
    private Boolean enabled;

    private Meta meta;
    private List<Menu> children;
}
