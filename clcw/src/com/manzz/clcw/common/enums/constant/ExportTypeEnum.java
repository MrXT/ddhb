package com.manzz.clcw.common.enums.constant;

import com.manzz.clcw.common.enums.ConstantEnum;

/** 导出类型枚举类 */
public class ExportTypeEnum extends ConstantEnum {
    private static final long serialVersionUID = -2113463310934069900L;

    public static final ExportTypeEnum CSV  = new ExportTypeEnum("csv", "csv");
    public static final ExportTypeEnum HTML = new ExportTypeEnum("html", "html");
    public static final ExportTypeEnum PDF  = new ExportTypeEnum("pdf", "pdf");
    public static final ExportTypeEnum XLS  = new ExportTypeEnum("xls", "xls");
    
    public ExportTypeEnum(String label, String value) {
        super(label, value);
    }
}
