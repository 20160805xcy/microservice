package com.xcy.microserviecorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author xcy
 * @date 2019/01/31 11:50
 * @description rest配置
 * @since V1.0.0
 */
@Configuration
public class restConfig {

    // 向Spring容器中定义RestTemplate对象
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
