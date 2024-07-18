package kr.co.polycube.backendtest.core.config;

import kr.co.polycube.backendtest.core.filter.InvalidCharacterFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterMvcConfig {

    @Bean
    public FilterRegistrationBean<InvalidCharacterFilter> corsFilter(){
        FilterRegistrationBean<InvalidCharacterFilter> bean = new FilterRegistrationBean<>(new InvalidCharacterFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(0);
        return bean;
    }
}
