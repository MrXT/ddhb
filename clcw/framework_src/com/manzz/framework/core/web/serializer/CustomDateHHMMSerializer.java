package com.manzz.framework.core.web.serializer;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.manzz.framework.core.util.DateUtils;
/**
 * 指定时间类型转化为形如HH:mm格式的json格式
 * @author WJK
 * @version:1.1 2015-02
 */
public class CustomDateHHMMSerializer extends JsonSerializer <Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) 
        throws IOException,JsonProcessingException {
        jgen.writeString(DateUtils.toFormatDateString(value,"HH:mm"));
    }
}
