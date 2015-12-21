package com.manzz.framework.core.util;

import java.io.UnsupportedEncodingException;
/**
 * <p> 字符转换工具类 </p>
 * @author Internet
 * @version 2010-10
 */
public class CharsetUtils {
   
    public static final String US_ASCII = "US-ASCII";    // 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 
    public static final String ISO_8859_1 = "ISO-8859-1";//ISO拉丁字母表 No.1，也叫做ISO-LATIN-1     
    public static final String UTF_8 = "UTF-8";          //8位 UCS 转换格式     
    public static final String UTF_16BE = "UTF-16BE";    //16 位 UCS 转换格式，Big Endian(最低地址存放高位字节）字节顺序     
    public static final String UTF_16LE = "UTF-16LE";    //16 位 UCS 转换格式，Litter Endian（最高地址存放地位字节）字节顺序     */
    public static final String UTF_16 = "UTF-16";        //16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识     
    public static final String GBK = "GBK";              //中文超大字符集     
    public static final String GB2312 = "GB2312";
    
    /** 
     * 字符串编码转换的实现方法
     * @param str    待转换的字符串
     * @param newCharset    目标编码
     */
    public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        return changeCharset(str, null, newCharset);
    }
    
    /** 
     * 字符串编码转换的实现方法
     * @param str    待转换的字符串
     * @param oldCharset    源字符集
     * @param newCharset    目标字符集
     */
	public static String changeCharset(String str, String oldCharset,
			String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			byte[] bs = null;

			if (oldCharset == null) {
				// 用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
				bs = str.getBytes();
				return new String(bs, newCharset); // 用新的字符编码生成字符串
			} else {
				// 用源字符编码解码字符串
				bs = str.getBytes(oldCharset);
			}

			return new String(bs, newCharset);// 用新的字符编码生成字符串
		}
		return null;
	}
}

