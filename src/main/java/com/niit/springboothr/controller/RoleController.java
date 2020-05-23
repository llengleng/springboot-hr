package com.niit.springboothr.controller;

import com.niit.springboothr.model.RespBean;
import com.niit.springboothr.model.Role;
import com.niit.springboothr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/5/23 12：56
 * @description :
 */
@RestController
@RequestMapping("/system/basic/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/findAll")
    public RespBean getAllRole() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok("获取成功", roles);
    }

    @PostMapping("/add")
    public RespBean addRole(@RequestBody Role role) {
        if(roleService.addRole(role) == 1 ) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteRole(@PathVariable Integer id) {
        if(roleService.deleteRoleById(id) == 1 ) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
