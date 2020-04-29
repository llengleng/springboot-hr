package com.niit.springboothr.service;

import com.niit.springboothr.mapper.MenuMapper;
import com.niit.springboothr.mapper.MenuRoleMapper;
import com.niit.springboothr.model.Hr;
import com.niit.springboothr.model.Menu;
import com.niit.springboothr.model.MenuRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/24 17：28
 * @description :
 */
@Service
public class MenuService {
    @Resource
    MenuMapper menuMapper;

    @Resource
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenuByHrId(){
        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }


    public List<Integer> getMidsByRid(Integer id){
        return menuMapper.getMidByRid(id);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid,Integer[] mids){
        menuRoleMapper.deleteByRid(rid);
        int num = menuRoleMapper.insertRecode(rid,mids);
        return num == mids.length;
    }

}
