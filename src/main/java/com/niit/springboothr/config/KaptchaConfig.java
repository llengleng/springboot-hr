package com.niit.springboothr.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.Properties;

/**
 * @author : Lenovo
 * @date : 2020/5/5 08：59
 * @description :
 */
@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put(Constants.KAPTCHA_BORDER,"no");
        properties.put(Constants.KAPTCHA_IMAGE_WIDTH,"100");
        properties.put(Constants.KAPTCHA_IMAGE_HEIGHT,"40");
        properties.put(Constants.KAPTCHA_SESSION_KEY,"code");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE,"30");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR,"blue");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES,"宋体，楷体，微软雅黑");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH,"4");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE,"6");
        properties.put(Constants.KAPTCHA_NOISE_COLOR,"35,37,38");
        properties.put(Constants.KAPTCHA_NOISE_IMPL,"com.google.code.kaptcha.impl.DefaultNoise");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
