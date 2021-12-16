package plus.yuhaozhang.blog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import plus.yuhaozhang.blog.constant.WhiteList;
import plus.yuhaozhang.blog.handler.interceptor.LoginInterceptor;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.List;

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
        registry.addInterceptor(loginInterceptor).addPathPatterns(WhiteList.BlackList);
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(WhiteList.whiteArray);
    }

    //@Override
    //public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //
    //    MappingJackson2HttpMessageConverter jackson2HttpMessageConverter =
    //            new MappingJackson2HttpMessageConverter();
    //    ObjectMapper objectMapper = new ObjectMapper();
    //    SimpleModule simpleModule = new SimpleModule();
    //    simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
    //    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
    //    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
    //    objectMapper.registerModule(simpleModule);
    //    jackson2HttpMessageConverter.setObjectMapper(objectMapper);
    //    converters.add(jackson2HttpMessageConverter);
    //    converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
    //
    //}
}
