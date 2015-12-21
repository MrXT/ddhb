package com.manzz.framework.core.spring.interceptor;

import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.manzz.framework.core.util.CharsetUtils;
import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.model.PaginationVO;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.model.WSJson;
import com.manzz.framework.core.util.CommonUtils;
import com.manzz.framework.core.util.LogUtil;
/**
 * Controller层AOP<br>
 * 主要是对返回结果直接写入HTTP response body中（@ResponseBody注解）的Controller层方法进行封装处理
 * @author WJK
 * @version 2014-09
 */
public class ControllerInterceptor implements MethodInterceptor {
    
    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.getMethod().isAnnotationPresent(ResponseBody.class)) {
            ResponseJson json = new ResponseJson();
            try {
                Object result = invocation.proceed();
                if(result instanceof ResponseJson || result instanceof WSJson){
                    return result;
                }else if(result instanceof Map){
                    json.setData((Map<String,Object>)result);
                }else if(result instanceof List){
                    json.setRows((List<Object>)result);
                    json.setTotal(((List<Object>)result).size());
                }else if(result instanceof PaginationVO){
                    json.setRows(((PaginationVO<Object>)result).getResult());
                    json.setTotal(((PaginationVO<Object>)result).getRecordCount());
                }else{
                    json.setMsg("操作成功");
                    json.setData(result);
                }
                json.setSuccess(true);
                return json;
            } catch (MaxUploadSizeExceededException e){
                return CharsetUtils.changeCharset("上传文件大小不能超过"+MAX_UPLOAD_SIZE+"M", CharsetUtils.ISO_8859_1);
            } catch (BusinessException e) {
                json.setMsg(e.getMessage());
            } catch (DataAccessException e) {
                LogUtil.ERROR(e.getMessage());
                json.setMsg(DATABASE_EXCEPTION);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.ERROR(e.getMessage());
                json.setMsg(UNKNOWN_EXCEPTION);
            } catch (Error e) {
                LogUtil.ERROR(e.getMessage());
                json.setMsg(SYSTEM_ERROR);
            }
            return json;
        }
        return invocation.proceed();
    }
    
    public static final int MAX_UPLOAD_SIZE = Integer.parseInt(CommonUtils.readResource("max.upload.size"))/1024/1024;//上传文件最大限制（单位M）
    private final static String DATABASE_EXCEPTION = "数据库异常!";
    private final static String UNKNOWN_EXCEPTION = "未知异常!";
    private final static String SYSTEM_ERROR = "系统错误!";
}
