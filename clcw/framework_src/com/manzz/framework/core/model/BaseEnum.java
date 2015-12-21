package com.manzz.framework.core.model;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.enums.Enum;
import org.apache.commons.lang.enums.ValuedEnum;

/**
 * 基础枚举类:封装枚举类的基本属性和方法
 * @author WJK
 * @version 2014-09
 */
public abstract class BaseEnum extends Enum {

    private static final long serialVersionUID = 8276852646399082708L;

    /** 通过枚举显示的label */
    private String label;

    /** 通过枚举保存的value */
    private String value;

    public BaseEnum(String label, String value) {
        super(value);
        this.label = label;
        this.value = value;
    }

    protected static Enum getEnum(Class<?> enumClass, int value) {
        if (enumClass == null)
            throw new IllegalArgumentException("枚举类不能为空");
        List<?> list = Enum.getEnumList(enumClass);
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            ValuedEnum enumeration = (ValuedEnum) it.next();
            if (enumeration.getValue() == value)
                return enumeration;
        }
        return null;
    }

    @Override
    public String toString() {
        return super.getName();
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
    
    public Integer getIntValue() {
        return Integer.parseInt(value);
    }
    
    public Short getShortValue() {
        return Short.parseShort(value);
    }
    
    public Boolean getBooleanValue() {
        return Boolean.parseBoolean(value);
    }
}