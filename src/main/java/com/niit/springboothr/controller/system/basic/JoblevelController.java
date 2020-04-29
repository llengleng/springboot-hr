package com.niit.springboothr.controller.system.basic;



import com.niit.springboothr.model.Joblevel;
import com.niit.springboothr.model.RespBean;
import com.niit.springboothr.service.system.basic.JoblevelService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/system/basic/joblevel")
@Api(value = "JoblevelController", tags = {"职称管理"})
public class JoblevelController {
    @Resource
    JoblevelService jobLevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    @ApiOperation(value = "新增职位", notes = "根据传入的职位添加一个新职位")
    @ApiImplicitParam(name = "position", value = "position对象", required = true)
    public RespBean addJobLevel(@RequestBody Joblevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @PutMapping("/")
    @ApiOperation(value = "修改职位", notes = "传入职位信息进行更新修改" )
    @ApiResponses({
            @ApiResponse(code = 200, message = "更新成功！"),
            @ApiResponse(code = 500, message = "更新失败！")
    })
    public RespBean updateJobLevelById(@RequestBody Joblevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除职位", notes = "根据 id 删除职位")
    @ApiImplicitParam(name = "id", value = "职位 id", required = true)
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除职位", notes = "根据 id 数组删除职位" )
    @ApiImplicitParam(name = "ids", value = "id数组", required = true)
    public RespBean deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
