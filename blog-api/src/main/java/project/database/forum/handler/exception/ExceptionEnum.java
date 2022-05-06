package project.database.forum.handler.exception;

/**
 * enum exception types
 * @author HULK
 */

public enum ExceptionEnum implements ExceptionEnumInterface {
    //  参数错误
    INVALID_PARAMS(300,"Params wrong"),
    INVALID_TOKEN(401,"Invalid Token"),
    INVALID_ACCOUNT(401,"Invalid account"),
    INVALID_USER(401,"Login Fail"),
    SYSTEM_FAIL(500,"System Fail");
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

