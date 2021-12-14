package plus.yuhaozhang.blog.handler.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.handler.exception.ExceptionEnum;
import plus.yuhaozhang.blog.service.struct.LoginService;
import plus.yuhaozhang.blog.utils.UserThreadLocal;
import plus.yuhaozhang.blog.vo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yuh Z
 * @date 12/10/21
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        log.info("=================");
        log.info(request.getRequestURI());
        log.info(request.getHeader("Authorization"));
        log.info("=================");

        if(StringUtils.isBlank(request.getHeader("Authorization"))){
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(JSON.toJSONString(Result.fail(ExceptionEnum.INVALID_TOKEN.getCode(), ExceptionEnum.INVALID_TOKEN.getDefaultMessage())));
            return false;
        }
        SysUser sysUser =loginService.findUserByToken(request.getHeader("Authorization"));
        if(sysUser==null){
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(JSON.toJSONString(Result.fail(ExceptionEnum.INVALID_TOKEN.getCode(), ExceptionEnum.INVALID_TOKEN.getDefaultMessage())));
            return false;
        }
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.delete();
    }
}
