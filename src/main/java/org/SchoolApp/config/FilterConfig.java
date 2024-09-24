package org.SchoolApp.config;

import org.SchoolApp.Filters.ApiPrefixFilter;
import org.SchoolApp.Filters.RestResponseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<ApiPrefixFilter> apiPrefixFilter() {
//        FilterRegistrationBean<ApiPrefixFilter> registrationBean = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new ApiPrefixFilter());
//        registrationBean.addUrlPatterns("/*"); // Appliquer à toutes les URL
//        registrationBean.setOrder(1); // Définir l'ordre du filtre
//
//        return registrationBean;
//    }
@Bean
public FilterRegistrationBean<RestResponseFilter> responseFormatFilter() {
    FilterRegistrationBean<RestResponseFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new RestResponseFilter());
    registrationBean.addUrlPatterns("/*"); // Apply to all URLs

    // Exclude Swagger paths
    registrationBean.addInitParameter("excludedPaths", "/v2/api-docs,/swagger-ui/,/swagger-resources/,/webjars/*");

    registrationBean.setOrder(1); // Set filter order
    return registrationBean;
}
}
