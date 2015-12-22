package com.cht.framework.core.spring.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.model.WSJson;
import com.cht.framework.core.util.LogUtil;
/**
 * WebService层AOP<br>
 * @author WJK
 * @version 2015-08-10
 */
public class WSInterceptor implements MethodInterceptor {
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.getMethod().isAnnotationPresent(ResponseBody.class)) {
            WSJson json = new WSJson();
            try {
                Object result = invocation.proceed();
                if(result instanceof WSJson){
                    return result;
                }else{
                    json.setMsg("操作成功");
                    json.setData(result);
                }
                json.setIsSuccess(true);
                return json;
            } catch (BusinessException e) {
                json.setErrorCode(e.getErrorCode());
                json.setMsg(e.getMessage());
            } catch (DataAccessException e) {
                json.setErrorCode("20001");
                json.setMsg(DATABASE_EXCEPTION);
            } catch (Exception e) {
                e.printStackTrace();
                json.setErrorCode("00000");
                json.setMsg(UNKNOWN_EXCEPTION);
            } catch (Error e) {
                LogUtil.ERROR(e.getMessage());
                json.setErrorCode("20002");
                json.setMsg(SYSTEM_ERROR);
            }
            return json;
        }
        return invocation.proceed();
    }
    
    private final static String DATABASE_EXCEPTION = "数据库异常!";
    private final static String UNKNOWN_EXCEPTION = "未知异常!";
    private final static String SYSTEM_ERROR = "系统错误!";
}
