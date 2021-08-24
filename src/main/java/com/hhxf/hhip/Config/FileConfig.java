package com.hhxf.hhip.Config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class FileConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //上传的单个文件最大值   KB,MB 这里设置为10MB
        DataSize maxSize = DataSize.ofMegabytes(10);
        DataSize requestMaxSize = DataSize.ofMegabytes(30);
        factory.setMaxFileSize(maxSize);
        /// 设置一次上传文件的总大小
        factory.setMaxRequestSize(requestMaxSize);
        return factory.createMultipartConfig();
    }
}
