package plus.yuhaozhang.blog.handler;

/**
 * enum exception types
 * @author HULK
 */

public enum ExceptionEnum implements ExceptionEnumInterface {
    //  参数错误
    INVALID_PARAMS(300,"参数不正确");

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

