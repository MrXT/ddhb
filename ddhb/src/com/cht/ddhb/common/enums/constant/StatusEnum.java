package com.cht.ddhb.common.enums.constant;

import com.cht.ddhb.common.enums.ConstantEnum;


/** 通用状态枚举类   */
public class StatusEnum extends ConstantEnum{
    private static final long serialVersionUID = -6848924814351140817L;
    /** 有效 */
    public static final StatusEnum VALID    = new StatusEnum("有效", "true");
    /** 失效 */
    public static final StatusEnum INVALID  = new StatusEnum("失效", "false");
    
    public StatusEnum(String label, String value) {
        super(label, value);
    }
    
    public static void main(String[] args) {
        System.out.println(StatusEnum.VALID.getBooleanValue());
    }
}