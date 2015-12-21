package com.manzz.framework.core.spring.initializer;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.manzz.framework.core.spring.date.DateConvertEditor;
/**
 * 指定日期类型转化格式
 * @author WJK
 * @version:1.0 2014-09
 */
public class MyWebBinding implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}
}
