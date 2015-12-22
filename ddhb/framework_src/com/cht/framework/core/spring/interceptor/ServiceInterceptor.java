package com.cht.framework.core.spring.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Service层AOP<br>
 * 
 * @author WJK
 * @version 2014-10
 */
public class ServiceInterceptor implements MethodInterceptor {

    private static transient Log logger = LogFactory.getLog(ServiceInterceptor.class);
    private long slowExecutionTime = 3000; // 定义执行时间过慢的标准,默认为3000毫秒。
    private boolean logExceptionDetail = true; // 是否记录异常详细信息

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
//        methodBeforeAdvice(invocation);
        
        Object result = new Object();
        try {
            long startTime = System.currentTimeMillis();
            result = invocation.proceed();
            long endTime = System.currentTimeMillis();
            logExecuteTime(invocation.getMethod().getName(), endTime - startTime);
        } catch (Exception e) {
            recordException(invocation.getMethod().getName(), e);
            throw e;
        }
        return result;
    }
    
    /** 前置通知 */
//    private void methodBeforeAdvice(MethodInvocation invocation) {
//        String methodName = invocation.getMethod().getName();
//        if(methodName.startsWith("do")){
//            // 自动将session中的用户ID设置为参数中BaseEntity子类的operId
//            for (Object arg : invocation.getArguments()) {
//                if (arg instanceof BaseEntity) {
//                    String userId = SessionHolder.getCurrentUser().getUserId();
//                    ReflectUtils.setFieldValue(arg, "templeId", SessionHolder.getCurrentUser().getTempleId());
//                    ReflectUtils.setFieldValue(arg, "operId", userId);
//                }
//            }
//        } else if(methodName.startsWith("query")){
//            for (Object arg : invocation.getArguments()) {
//                if (arg instanceof BaseEntity) {
//                    try {
//                        ReflectUtils.setFieldValue(arg, "templeId", SessionHolder.getCurrentUser().getTempleId());
//                        ReflectUtils.setFieldValue(arg, "validity", StatusEnum.VALID.getBooleanValue());
//                    } catch (IllegalArgumentException e) {
//                        // 没有属性则不做操作
//                    }
//                    
//                }
//            }
//        } else {
//            throw new SystemException(methodName+" Service接口命名不满足规范");
//        }
//    }

    /**
     * 如果执行时间过长,则计入日志
     * @param methodName 方法名称
     * @param executeTime 执行时间
     */
    private void logExecuteTime(String methodName, long executeTime) {
        long slowTime = getSlowExecutionTime();
        if (executeTime > slowTime) {
            logger.warn("方法:" + methodName + " 运行耗时:" + executeTime + "ms");
        }
    }
    
    /**
     * 将异常信息计入日志
     * @param methodName 方法名称
     * @param exception  异常对象
     */
    private void recordException(String methodName, Exception exception) {
        logger.error("方法" + methodName + "抛出异常:");
        StringBuffer sb = new StringBuffer();
        sb.append(exception.getMessage() + "\n");
        if (isLogExceptionDetail()) {
            StackTraceElement[] ste = exception.getStackTrace();
            for (int i = 0; i < ste.length; i++) {
                sb.append(ste[i].toString() + "\n");
            }
        }
        logger.error(sb);
        sb = null;
    }

    public long getSlowExecutionTime() {
        return slowExecutionTime;
    }

    public void setSlowExecutionTime(long slowExecutionTime) {
        this.slowExecutionTime = slowExecutionTime;
    }

    public boolean isLogExceptionDetail() {
        return logExceptionDetail;
    }

    public void setLogExceptionDetail(boolean logExceptionDetail) {
        this.logExceptionDetail = logExceptionDetail;
    }
}
