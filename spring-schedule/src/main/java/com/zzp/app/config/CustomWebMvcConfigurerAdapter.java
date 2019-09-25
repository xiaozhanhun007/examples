package com.zzp.app.config;

import com.zzp.app.http.message.converter.MappingJackson2HttpMessageConverterExt;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @Description 自定义WebMvc配置适配器
 * @Author karyzeng
 * @since 2019.09.25
 **/
@Configuration
@EnableWebMvc
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverterExt convert0 = new MappingJackson2HttpMessageConverterExt();
        converters.add(convert0);

        super.configureMessageConverters(converters);
    }
}
