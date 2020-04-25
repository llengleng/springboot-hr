package com.niit.springboothr.service;

import com.niit.springboothr.mapper.MenuMapper;
import com.niit.springboothr.model.Hr;
import com.niit.springboothr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/24 17：28
 * @description :
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenuByHrId(){
        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

}
