package com.niit.springboothr.service;

import com.niit.springboothr.mapper.HrMapper;
import com.niit.springboothr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : Lenovo
 * @date : 2020/4/18 19：15
 * @description :
 */
@Service
public class HrService implements UserDetailsService {

    @Resource
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loginByUername(s);
        if (hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
