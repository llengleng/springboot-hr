package com.niit.springboothr.controller.system.basic;

import com.niit.springboothr.model.*;
import com.niit.springboothr.service.MenuService;
import com.niit.springboothr.service.system.basic.PermissionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/4/28 20：50
 * @description :
 */
@RestController
@RequestMapping("/system/basic/permission")
@Api(value = "PermissionController", tags = {"权限组"})
public class PermissionController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/roles")
    @ApiOperation(value = "获取所有角色", notes = "所有角色信息列表", produces = "application/json")
    public RespBean getAllRoles(){
        List<Role> roles = permissionService.getAllRoles();
        return RespBean.ok("",roles);
    }

    @GetMapping("/menus")
    @ApiOperation(value = "获取所有三级菜单", notes = "所有三级菜单的列表")
    public RespBean getAllMenus(){
        List<Menu> menus = permissionService.getAllMenus();
        return RespBean.ok("",menus);
    }

    @GetMapping("/mid/{rid}")
    @ApiOperation(value = "获取角色对应的菜单id集合", notes = "角色对应的菜单id列表")
    public RespBean getMidByRid(@PathVariable Integer rid){
        List<Integer> rids = menuService.getMidsByRid(rid);
        return RespBean.ok("",rids);
    }


    @PostMapping("/role")
    @ApiOperation(value = "新增角色", notes = "根据传入的职位添加一个新角色")
    @ApiImplicitParam(name = "role", value = "role对象", required = true)
    public RespBean addRole(@RequestBody Role role) {
        if (permissionService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @ApiOperation(value = "修改角色对应的菜单")
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功！"),
            @ApiResponse(code = 500, message = "更新失败！")
    })
    public RespBean updateMenuRole(Integer rid,Integer[] mids) {
        if (menuService.updateMenuRole(rid,mids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/role/{id}")
    @ApiOperation(value = "根据角色id删除角色")
    public RespBean deleteRoleById(@PathVariable Integer id) {
        if (permissionService.deleteRole(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
