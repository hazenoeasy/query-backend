package project.database.forum.handler.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import project.database.forum.dao.pojo.User;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.LoginService;
import project.database.forum.utils.UserThreadLocal;
import project.database.forum.vo.Result;

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

        if (StringUtils.isBlank(request.getHeader("Authorization"))) {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(JSON.toJSONString(Result.fail(ExceptionEnum.INVALID_TOKEN.getCode(), ExceptionEnum.INVALID_TOKEN.getDefaultMessage())));
            return false;
        }
        User user = loginService.findUserByToken(request.getHeader("Authorization"));
        if (user == null) {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(JSON.toJSONString(Result.fail(ExceptionEnum.INVALID_TOKEN.getCode(), ExceptionEnum.INVALID_TOKEN.getDefaultMessage())));
            return false;
        }
        UserThreadLocal.put(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.delete();
    }
}
