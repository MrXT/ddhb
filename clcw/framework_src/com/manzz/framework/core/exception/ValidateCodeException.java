package com.manzz.framework.core.exception;
/**
 * 验证码异常
 * @author WJK
 * @version 2015-08
 */
public class ValidateCodeException extends Exception {
    private static final long serialVersionUID = 5822904816104154076L;
    
    private String errorCode;

    public ValidateCodeException() {
		super("系统异常");
	}
    
    public ValidateCodeException(Exception e) {
        super(e);
    }

    public ValidateCodeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

	public ValidateCodeException(String message, Throwable arg) {
		super(message, arg);
	}
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
