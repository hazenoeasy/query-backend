package project.database.forum.handler.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import project.database.forum.vo.Result;

/** Aop implements for exceptions
 * @author Yuh Z
 * @date 12/8/21
 */
@ControllerAdvice
public class AllExceptionHandler {
    /**
     * This is a default catcher, for unexpected err
     * @param ex default exception
     * @return return 500 status code and default message
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result unCaughtException(Exception ex){
        ex.printStackTrace();
        return Result.fail(500,"system false");
    }

    /**  if ex have customized message, output customer message.
     *   else output enum message.
     *  Handle expected err
     */
    @ExceptionHandler(CaughtException.class)
    @ResponseBody
    public Result caughtException(CaughtException ex){
        ex.printStackTrace();
        if (ex.getCustomMessage()==null){
            return Result.fail(ex.getExceptionInfo().getCode(),ex.getExceptionInfo().getDefaultMessage());
        }else{
            return Result.fail(ex.getExceptionInfo().getCode(),ex.getCustomMessage());
        }
    }
}
