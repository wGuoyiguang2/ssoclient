package com.example.demo.Interceptor;


import com.majiaxueyuan.sso.core.filter.MaJiaSSOIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MaJiaSsoConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ssoIntercepter()).addPathPatterns("/**");
    }

    @Bean
    public MaJiaSSOIntercepter ssoIntercepter() {
        // MaJiaSSOIntercepter 是 上面 的 pom 依赖引入的
        return new MaJiaSSOIntercepter().setTokenSalt("token-salt");
    }
}
