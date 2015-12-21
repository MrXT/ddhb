/**
 * Project Name:dtdp
 * File Name:BaseDAO.java
 * Package Name:com.manzz.dtdp.module.bd.service
 * Date:2014年12月31日下午2:54:17
 * Copyright (c) 2014, manzz.com All Rights Reserved.
 *
 */

package com.manzz.framework.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * ClassName: BaseDAO <br/>
 *
 * @author ZZW
 * @version 2014年12月31日 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Deprecated
public @interface BaseDAO
{
}

