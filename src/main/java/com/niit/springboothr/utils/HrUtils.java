package com.niit.springboothr.utils;

import com.niit.springboothr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : Lenovo
 * @date : 2020/5/23 14：14
 * @description :
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
