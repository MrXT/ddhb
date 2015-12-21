/**
 * 
 */
package com.manzz.framework.core.util;

import org.apache.log4j.Logger;

/**
 * 功能：日志工具类
 * @version 2013-03-26
 */
public class LogUtil {
	
	private static final Logger LOGGER = Logger.getLogger(LogUtil.class);
	
	public static void DEBUG(String ... args){
		if(LOGGER.isDebugEnabled()){
			StringBuffer str = new StringBuffer();
			for(String arg : args){
				str.append(arg);
			}
			LOGGER.debug(str.toString());
		}
	}
	
	public static void INFO(String ... args){
		if(LOGGER.isInfoEnabled()){
			StringBuffer str = new StringBuffer();
			for(String arg : args){
				str.append(arg);
			}
			LOGGER.info(str.toString());
		}
	}
	
	public static void WARN(String ... args){
		StringBuffer str = new StringBuffer();
		for(String arg : args){
			str.append(arg);
		}
		LOGGER.warn(str.toString());
	}
	
	public static void ERROR(String ... args){
		StringBuffer str = new StringBuffer();
		for(String arg : args){
			str.append(arg);
		}
		LOGGER.error(str.toString());
	}
}
