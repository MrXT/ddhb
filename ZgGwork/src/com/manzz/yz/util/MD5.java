package com.manzz.yz.util;

import java.security.MessageDigest;


public class MD5 {

    /**
     * MD5加密数据
     * @param args
     */
    public static String getStr2Digest(String iStrDigest) {
        String iReStrMD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(iStrDigest.getBytes());
            byte[] Result = md.digest();
            for (int i = 0; i < Result.length; i++) {
                iReStrMD5 += byteHEX(Result[i]);
            }
        } catch (Exception e) {
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
    public static void main(String[] args) {
        System.out.println(MD5.getStr2Digest("2015-12-04 13:42:380000000000000000000000Order_Get_SchoolQuerymanzz_zgyg"));
    }

}
