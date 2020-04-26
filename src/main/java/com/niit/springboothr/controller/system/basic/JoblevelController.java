package com.niit.springboothr.controller.system.basic;



import com.niit.springboothr.model.Joblevel;
import com.niit.springboothr.model.RespBean;
import com.niit.springboothr.service.system.basic.JoblevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {
    @Resource
    JoblevelService jobLevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }
    @PutMapping("/")
    public RespBean updateJobLevelById(@RequestBody Joblevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
