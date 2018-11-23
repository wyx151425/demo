package cn.edu.cnu.zhanghao.context;

import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置管理器
 *
 * @author 张浩
 */
@Component
public class DemoWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor())
                .addPathPatterns("/api/**")
                .addPathPatterns("")
                .addPathPatterns("/")
                .addPathPatterns("/index")
                .addPathPatterns("/plan")
                .addPathPatterns("/student");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/plan").setViewName("plan");
        registry.addViewController("/student").setViewName("student");
    }
}
