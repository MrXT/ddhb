package com.cht.framework.core.web.serializer;

import java.io.IOException;
import java.util.Date;

import com.cht.framework.core.util.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**
 * 指定日期类型转化为'yyyy年MM月dd日'格式的json格式后的格式
 * @author WJK
 * @version:1.1 2015-02
 */
public class CustomDateGBSerializer extends JsonSerializer <Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) 
        throws IOException,JsonProcessingException {
        jgen.writeString(DateUtils.toShortDateGBString(value));
    }
}
