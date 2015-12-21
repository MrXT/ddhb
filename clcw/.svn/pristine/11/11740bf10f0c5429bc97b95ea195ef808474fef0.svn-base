/**
 * Project Name:dtdp
 * File Name:DtdpDefaultJsonMapper.java
 * Package Name:com.manzz.framework.core.web.mime
 * Date:2015年1月31日下午3:59:46
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.framework.core.web.mime;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName: DefaultJsonMapper <br/>
 * @author WJK
 * @version 2015-07
 */
public class DefaultJsonMapper extends ObjectMapper
{
    private static final long serialVersionUID = 7679503945581779104L;
    
    /**
     * Creates a new instance of DtdpDefaultJsonMapper.
     *
     */
    public DefaultJsonMapper()
    {
        super();
        // 允许单引号
//        this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        // 字段和值都加引号
//        this.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        // 数字也加引号
//        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
//        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
//        // 空值处理为空串
//        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
//        {
//
//            @Override
//            public void serialize(
//                    Object value,
//                    JsonGenerator jg,
//                    SerializerProvider sp) throws IOException, JsonProcessingException
//            {
//                jg.writeString("");
//            }
//        });
    }
    
    public ObjectMapper setDateFormat(String dateFormat)
    {
        return super.setDateFormat(new SimpleDateFormat(dateFormat));
    }

}

