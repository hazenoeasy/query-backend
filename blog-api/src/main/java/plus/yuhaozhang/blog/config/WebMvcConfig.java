package plus.yuhaozhang.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import plus.yuhaozhang.blog.constant.WhiteList;
import plus.yuhaozhang.blog.handler.interceptor.LoginInterceptor;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;
    /**
     *
     * @param registry  allow cross site
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/test");
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(WhiteList.whiteArray);
    }
}
