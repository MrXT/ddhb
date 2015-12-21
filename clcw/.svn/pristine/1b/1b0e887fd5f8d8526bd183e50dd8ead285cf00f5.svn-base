package com.manzz.framework.core.util;

import java.security.MessageDigest;

import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.exception.SystemException;

public class MD5 {

    /**
     * MD5加密数据
     * @param args
     */
    public static String getStr2Digest(String iStrDigest) {
        if(iStrDigest==null){
            throw new BusinessException("10002","密码为空");
        }
        String iReStrMD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(iStrDigest.getBytes());
            byte[] Result = md.digest();
            for (int i = 0; i < Result.length; i++) {
                iReStrMD5 += byteHEX(Result[i]);
            }
        } catch (Exception e) {
            throw new SystemException(e.getMessage());
        }
        return iReStrMD5.toUpperCase();
    }

    /**
     * byteHEX()，用来把一个byte类型的数转换成十六进制的ASCII表示
     * 因为java中的byte的toString无法实现这一点，我们又没有C语言中的 sprintf(outbuf,"%02X",ib)
     */
    public static String byteHEX(byte ib) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

}
