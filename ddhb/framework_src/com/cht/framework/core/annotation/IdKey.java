/**
 * Project Name:dtdp
 * File Name:IdKey.java
 * Package Name:com.cht.framework.core.annotation
 * Date:2015年1月5日上午11:06:31
 * Copyright (c) 2015, cht.com All Rights Reserved.
 *
 */

package com.cht.framework.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * ClassName: IdKey <br/>
 * Function: 主键标识注解
 *
 * @author ZZW
 * @version 2015年1月5日 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IdKey
{

}

