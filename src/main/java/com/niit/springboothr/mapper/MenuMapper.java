package com.niit.springboothr.mapper;

import com.niit.springboothr.model.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenuByHrId(Integer id);


    @Select("select mid from menu_role where rid=#{id}")
    List<Integer> getMidByRid(Integer id);
}