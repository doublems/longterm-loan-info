package org.doublem.dailyreports.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //requestTemplate.target("http://api.hf.go.kr:8090");
        //requestTemplate.` `
        //logger.info(requestTemplate.url());
    }
}
