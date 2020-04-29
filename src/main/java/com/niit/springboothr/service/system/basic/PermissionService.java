package com.niit.springboothr.service.system.basic;

import com.niit.springboothr.mapper.PositionMapper;
import com.niit.springboothr.mapper.RoleMapper;
import com.niit.springboothr.model.Menu;
import com.niit.springboothr.model.Position;
import com.niit.springboothr.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/28 20：51
 * @description :
 */
@Service
public class PermissionService {
    @Resource
    RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus(){
        return roleMapper.getAllMenus();
    }

    public Integer addRole(Role record){
        record.setName("");
        record.setNamezh("");
        return roleMapper.insert(record);
    }

    public Integer deleteRole(Integer id){
        return roleMapper.deleteByPrimaryKey(id);
    }

}
