
package com.cht.ddhb.common.util;


import java.util.List;

import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.util.ValidateUtils;

/**
 * ClassName: ValidateAndThrowUtil <br/>
 * Function: 验证请求的参数是否符合，不符合抛出业务异常
 *
 * @author XT
 * @version 2015年12月25日
 */
public class ValidateAndThrowUtil {
    /**   
     * 判断输入list是否为空（包括list.size()=0）
     * @return 为空true反之throw异常
     */  
    
    public static final boolean isNullList(List<?> list) {
        if(list == null || list.size() == 0){
            throw new BusinessException("请求参数错误！");
        }else{
            return false;
        }
    }
    
    /**   
     * 判断输入字符串是否为空字符串（包括空格）
     * @return 为空true反之throw异常
     */  
    public static final boolean isBlank(String ... strs) {
        boolean result = true;
        for (String str : strs) {
            if(ValidateUtils.isBlank(str)){
                result = false;
            }
        }
        if(result){
            return false;
        }else{
            throw new BusinessException("请求参数错误！");
        }
    }
    
    /**   
     * 判断输入字符串是否为空字符串（不包括空格）
     * @return 为空true反之false 
     */  
    public static boolean isEmpty(String str)
    {
        return str == null || str.length() == 0;
    }

    
    /**   
     * 判断输入字符串是否符合规范
     * 即判断输入字符是否包含双字节（如：中文，日语，全角等）
     * @return 包含双字节字符返回false,否则throw异常
     */   
    public static boolean isLegal(String str){   
        if(ValidateUtils.isLegal(str)){
            return true;
        }else{
            throw new BusinessException("字符串不符合规范！");
        }
    }

    /**   
     * 判断输入字符串是否为纯数字
     * @return 是纯数字返回true反之throw异常
     */  
    public static boolean isPureNumber(String str){   
        if(ValidateUtils.isPureNumber(str)){
            return true;
        }else{
            throw new BusinessException("字符串不是纯数字！");
        }
    }
    
    /**   
     * 判断输入字符串是否满足邮箱格式
     * @return 满足返回true反之throw异常
     */  
    public static boolean isEmailFormat(String str) {
        if(ValidateUtils.isEmailFormat(str)){
            return true;
        }else{
            throw new BusinessException("邮箱格式错误！");
        }
    }
    
    /**   
     * 判断输入字符串是否满足手机号格式<br>
     * 手机号格式为：13,,14,15,18开头的11位纯数字
     * @return 满足返回true反之throw异常
     */ 
    public static boolean isMobileNo(String str){   
        if(ValidateUtils.isMobileNo(str)){
            return true;
        }else{
            throw new BusinessException("手机号格式错误！");
        }
    }
    
    
    /**
     * 电话号码验证
     * 
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) { 
        if(ValidateUtils.isPhone(str)){
            return true;
        }else{
            throw new BusinessException("电话号码格式错误！");
        }
    }
    
    /**
     * 判断输入字符串是否为IP地址
     * @return 是则返回true反之throw异常
     */
    public static boolean isIPAddress(String str){
        if(ValidateUtils.isIPAddress(str)){
            return true;
        }else{
            throw new BusinessException("ip地址格式错误！");
        }
    }
    
    /**
     * @description: 金额验证
     * @param str
     * @return
     */
    public static boolean isAmount(String str) {
        if(ValidateUtils.isAmount(str)){
            return true;
        }else{
            throw new BusinessException("金额验证失败！");
        }
    }
}

