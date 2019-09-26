package com.zzp.app.http.message.converter;

import com.fasterxml.jackson.databind.JavaType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @Description SpringMvc自定义反序列化转换器
 * @Author karyzeng
 * @since 2019.09.24
 **/
public class MappingJackson2HttpMessageConverterExt extends MappingJackson2HttpMessageConverter {


    public MappingJackson2HttpMessageConverterExt() {
        super();
    }

    @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 获取请求headers中的MediaType
        MediaType contentType = inputMessage.getHeaders().getContentType();
        Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
        String content = FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));
        // 获取请求headers中的Content-Type
        String contentTypeStr = contentType.getType() + "/" + contentType.getSubtype();
        if (StringUtils.isNotBlank(contentTypeStr) && contentTypeStr.equals("application/json")) {
            // 如果Content-Type的类型是application/json，则将双引号""转换为null
            content = content.replace("\"\"", "null");
        }
        JavaType javaType = getJavaType(type, contextClass);
        return super.getObjectMapper().readValue(content, javaType);
    }
}
