package com.cht.ddhb.common.enums.constant;

import com.cht.ddhb.common.enums.ConstantEnum;

/** 是否标志枚举 */
public class YesOrNoEnum extends ConstantEnum{
    private static final long serialVersionUID = 1423945665958441303L;
    /** 是*/
    public static final YesOrNoEnum YES = new YesOrNoEnum("是", "1");
    /** 否*/
    public static final YesOrNoEnum NO = new YesOrNoEnum("否", "0");
    
    public YesOrNoEnum(String label, String value) {
        super(label, value);
    }
}