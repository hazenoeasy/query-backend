package plus.yuhaozhang.blog.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/9/21
 */
@Data
public class CaughtException extends RuntimeException{
    private ExceptionEnum exceptionInfo;
    private String customMessage;

    public CaughtException(ExceptionEnum exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
        this.customMessage = null;
    }

    public CaughtException(ExceptionEnum exceptionInfo, String customMessage) {
        this.exceptionInfo = exceptionInfo;
        this.customMessage = customMessage;
    }
}
