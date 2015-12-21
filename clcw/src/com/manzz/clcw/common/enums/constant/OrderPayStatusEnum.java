package com.manzz.clcw.common.enums.constant;

import com.manzz.clcw.common.enums.ConstantEnum;


/** 订单支付状态枚举类   */
public class OrderPayStatusEnum extends ConstantEnum{
	private static final long serialVersionUID = -8356272639794862058L;
	/** -1.未付款 */
    public static final OrderPayStatusEnum NOPAY    = new OrderPayStatusEnum("未付款", "-1");
    /** 1.已支付 */
    public static final OrderPayStatusEnum PAY  = new OrderPayStatusEnum("已支付", "1");
    /** 2.已退票 */
    public static final OrderPayStatusEnum REFUND  = new OrderPayStatusEnum("已退票", "2");
    /** 3.已过期 */
    public static final OrderPayStatusEnum EXPIRE  = new OrderPayStatusEnum("已过期", "3");
    
    public OrderPayStatusEnum(String label, String value) {
        super(label, value);
    }
    
    public static void main(String[] args) {
        System.out.println(OrderPayStatusEnum.EXPIRE);
        System.out.println(OrderPayStatusEnum.EXPIRE.getValue());
        System.out.println(OrderPayStatusEnum.EXPIRE.getIntValue());
    }
}