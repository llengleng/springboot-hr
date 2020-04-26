package com.niit.springboothr.service.system.basic;

import com.niit.springboothr.mapper.JoblevelMapper;
import com.niit.springboothr.model.Joblevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class JoblevelService {
    @Resource
    JoblevelMapper jobLevelMapper;
    public List<Joblevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(Joblevel jobLevel) {
        jobLevel.setEnabled(true);
        jobLevel.setCreateDate(new Date());

        return jobLevelMapper.insert(jobLevel);
    }

    public Integer updateJobLevelById(Joblevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKey(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelsByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelsByIds(ids);
    }
}
