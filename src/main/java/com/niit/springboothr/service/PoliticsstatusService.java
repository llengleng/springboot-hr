package com.niit.springboothr.service;

import com.niit.springboothr.mapper.PoliticsstatusMapper;
import com.niit.springboothr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Lenovo
 * @date : 2020/5/23 12：49
 * @description :
 */
@Service
public class PoliticsstatusService {
    @Resource
    PoliticsstatusMapper politicsstatusMapper;
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
