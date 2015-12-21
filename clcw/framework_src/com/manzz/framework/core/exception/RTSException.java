package com.manzz.framework.core.exception;
/**
 * 安标系统异常<br>
 * @author WJK
 * @version 2015-05
 */
public class RTSException extends Exception {

    private static final long serialVersionUID = -4942849136285353014L;

    public RTSException() {
		super("安标系统接口异常");
	}
    
    public RTSException(Exception e) {
        super(e);
    }

	public RTSException(String message) {
		super(message);
	}

	public RTSException(String message, Throwable arg) {
		super(message, arg);
	}
}
