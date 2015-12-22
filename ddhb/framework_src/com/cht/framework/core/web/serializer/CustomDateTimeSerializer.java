package com.cht.framework.core.web.serializer;

import java.io.IOException;
import java.util.Date;

import com.cht.framework.core.util.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * 指定时间类型转化为形如yyyy-MM-dd HH:mm:ss格式的json格式
 * @author WJK
 * @version:1.0 2015-02
 */
public class CustomDateTimeSerializer  extends JsonSerializer<Date>{
	@Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
	    jgen.writeString(DateUtils.toLongDateString(value));
    }
}
