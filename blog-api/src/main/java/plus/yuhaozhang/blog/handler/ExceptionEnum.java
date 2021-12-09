package plus.yuhaozhang.blog.handler;

/**
 * enum exception types
 * @author HULK
 */

public enum ExceptionEnum implements ExceptionEnumInterface {
    //  参数错误
    INVALID_PARAMS(300,"Params wrong"),
    INVALID_TOKEN(401,"Invalid Token"),
    INVALID_USER(401,"Login Fail");
    private final Integer code;
    private final String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDefaultMessage() {
        return this.message;
    }
}

