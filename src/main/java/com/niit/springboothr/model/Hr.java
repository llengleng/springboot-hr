package com.niit.springboothr.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * hr
 * @author 
 */
@Data
@ApiModel(value = "用户实体类", description = "用户基础及登录信息描述")
public class Hr implements UserDetails {
    /**
     * hrID
     */

    @ApiModelProperty(value = "用户id", name = "id", required = true, dataType = "Integer")
    private Integer id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String name;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 住宅电话
     */
    @ApiModelProperty(value = "住宅电话")
    private String telephone;

    /**
     * 联系地址
     */
    @ApiModelProperty(value = "联系地址")
    private String address;

    private Boolean enabled;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "登录用户名", name = "username", required = true, dataType = "query")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "登录密码", name = "password", required = true, dataType = "query")
    private String password;

    @ApiModelProperty(value = "用户头像")
    private String userface;

    private String remark;

    private List<Role> roles;

    private static final long serialVersionUID = 1L;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>(roles.size());
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return authorities;
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}