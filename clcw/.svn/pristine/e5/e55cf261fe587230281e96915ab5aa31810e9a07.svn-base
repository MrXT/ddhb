package com.manzz.framework.core.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.manzz.framework.core.exception.BusinessException;

public class BatchProcUtil {
    public static final int  DEFALUT_MAX_INSERT_COUNT = 500;
    
    public static <T> void batchInsert(List<T> list,Object obj,String methodName){
        
        if(list==null || list.size()==0){
            return;
        }
        try {
            Method m = obj.getClass().getDeclaredMethod(methodName, List.class);
            List<T> tList = new ArrayList<T>();
            int toIndex=0;
            int times = list.size()/DEFALUT_MAX_INSERT_COUNT;
            if(list.size()%DEFALUT_MAX_INSERT_COUNT!=0){
                times++;
            }
            
            for(int i=0;i<times;i++){
                toIndex=(i+1)*DEFALUT_MAX_INSERT_COUNT>list.size()?list.size():(i+1)*DEFALUT_MAX_INSERT_COUNT;
                tList = list.subList(i*DEFALUT_MAX_INSERT_COUNT, toIndex);
                m.invoke(obj, tList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("20000","批量操作失败");
        } 
    }
}
