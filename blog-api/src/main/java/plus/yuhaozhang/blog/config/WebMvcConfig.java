package plus.yuhaozhang.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     *
     * @param registry  allow cross site
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("https://localhost:8080");
    }
}
