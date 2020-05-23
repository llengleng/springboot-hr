package com.niit.springboothr.service;

import com.niit.springboothr.mapper.NationMapper;
import com.niit.springboothr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/5/23 12：41
 * @description :
 */
@Service
public class NationService {
    @Resource
    NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
