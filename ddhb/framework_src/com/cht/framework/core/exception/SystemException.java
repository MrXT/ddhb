package com.cht.framework.core.exception;
/**
 * 与用户操作无关,由程序或网络等原因造成的异常<br>
 * @author WJK
 * @version 2014-09
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 8989828988277681296L;

    public SystemException() {
		super("系统异常");
	}
    
    public SystemException(Exception e) {
        super(e);
    }

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, Throwable arg) {
		super(message, arg);
	}
}
