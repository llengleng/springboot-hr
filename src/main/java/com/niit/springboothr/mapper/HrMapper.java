package com.niit.springboothr.mapper;

import com.niit.springboothr.model.Hr;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/18 19：14
 * @description :
 */
public interface HrMapper {

    @Select("select * from hr where username=#{username}")
    Hr loginByUername(String username);
}
