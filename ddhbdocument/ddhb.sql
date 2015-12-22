/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50546
Source Host           : localhost:3306
Source Database       : ddhb

Target Server Type    : MYSQL
Target Server Version : 50546
File Encoding         : 65001

Date: 2015-12-22 16:59:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cm_area
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_area`;
CREATE TABLE `t_cm_area` (
  `area_id` varchar(36) NOT NULL COMMENT '区域代理id',
  `name` varchar(20) NOT NULL COMMENT '区域代理名称',
  `address` varchar(50) NOT NULL COMMENT '区域代理地址',
  `user_id` varchar(36) NOT NULL COMMENT '代理人id',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  `oper_id` varchar(255) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cm_commision
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_commision`;
CREATE TABLE `t_cm_commision` (
  `commision_id` varchar(36) NOT NULL COMMENT '佣金id',
  `year` int(10) NOT NULL COMMENT '年份',
  `month` int(10) NOT NULL COMMENT '月份',
  `commision_money` decimal(10,0) NOT NULL COMMENT '这个月的佣金',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `status` int(10) NOT NULL COMMENT '佣金发放状态',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`commision_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cm_commisionsetting
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_commisionsetting`;
CREATE TABLE `t_cm_commisionsetting` (
  `commisionsetting_id` varchar(36) NOT NULL COMMENT '佣金设置id',
  `type` int(10) DEFAULT NULL COMMENT '佣金类型1为特殊2为统一',
  `kind` int(10) DEFAULT NULL COMMENT '佣金种类1：区域\r\n2：专卖\r\n3：微商',
  `min_rebate` int(10) NOT NULL,
  `max_rebate` int(10) NOT NULL COMMENT '返佣率(%)',
  `user_id` varchar(36) NOT NULL COMMENT '代理人id',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`commisionsetting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cm_innernotice
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_innernotice`;
CREATE TABLE `t_cm_innernotice` (
  `innernotice_id` varchar(36) NOT NULL COMMENT '内部公告id',
  `name` varchar(50) NOT NULL COMMENT '公告名称',
  `content` varchar(150) NOT NULL COMMENT '内容',
  `user_id` varchar(36) NOT NULL COMMENT '发布人id',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  `creaetime` datetime NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`innernotice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cm_order_audit
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_order_audit`;
CREATE TABLE `t_cm_order_audit` (
  `order_audit_id` varchar(36) NOT NULL COMMENT '工程单审核id',
  `content` varchar(50) NOT NULL COMMENT '审核内容',
  `projectorder_id` varchar(36) NOT NULL COMMENT '工程订单id',
  `user_id` varchar(36) NOT NULL COMMENT '审核人id',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cm_projectorder
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_projectorder`;
CREATE TABLE `t_cm_projectorder` (
  `projectorder_id` varchar(36) NOT NULL COMMENT '工程单id',
  `type` int(10) DEFAULT NULL COMMENT '工程单类型',
  `describle` varchar(50) NOT NULL COMMENT '工程单描述',
  `address` varchar(50) NOT NULL COMMENT '需要施工的地址',
  `user_id` varchar(36) NOT NULL COMMENT '提交人id',
  `receiver_id` varchar(36) NOT NULL COMMENT '接收人id',
  `telephone` varchar(11) NOT NULL COMMENT '需要施工的联系电话',
  `price` decimal(10,2) DEFAULT NULL COMMENT '工程单的价钱（施工队完成后所填的）',
  `status` int(10) NOT NULL COMMENT '工程单状态',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  PRIMARY KEY (`projectorder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cm_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_cm_shop`;
CREATE TABLE `t_cm_shop` (
  `shop_id` varchar(36) NOT NULL COMMENT '专卖店id',
  `name` varchar(20) NOT NULL COMMENT '专卖店名称',
  `address` varchar(50) NOT NULL COMMENT '专卖店地址',
  `user_id` varchar(36) NOT NULL COMMENT '店主id',
  `area_id` varchar(36) NOT NULL COMMENT '区域代理id',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_order
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_order`;
CREATE TABLE `t_mm_order` (
  `order_id` varchar(36) NOT NULL COMMENT '订单id',
  `order_amount` decimal(10,2) NOT NULL COMMENT '订单总价',
  `tradecode` varchar(50) NOT NULL COMMENT '第三方交易号（用于退款）',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `status` int(10) NOT NULL COMMENT '订单状态',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_orderitem`;
CREATE TABLE `t_mm_orderitem` (
  `orderitem_id` varchar(36) NOT NULL COMMENT '订单明细id',
  `product_id` varchar(36) NOT NULL COMMENT '商品id',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `num` int(11) NOT NULL COMMENT ' 商品数量',
  `price` decimal(10,2) NOT NULL COMMENT '商品单价',
  `total_amount` varchar(255) NOT NULL COMMENT '商品总价',
  `order_id` varchar(36) DEFAULT NULL COMMENT ' 订单id',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`orderitem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_product
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_product`;
CREATE TABLE `t_mm_product` (
  `product_id` varchar(36) NOT NULL COMMENT '商品id',
  `name` varchar(50) NOT NULL COMMENT '商品名',
  `describle` varchar(150) NOT NULL COMMENT '商品描述',
  `createtime` datetime NOT NULL COMMENT '上架时间',
  `product_type_id` varchar(36) NOT NULL COMMENT '商品类型id',
  `product_stock_id` varchar(36) NOT NULL COMMENT '商品库存id',
  `product_use_id` varchar(36) NOT NULL COMMENT '商品用途id',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(255) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_product_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_product_notice`;
CREATE TABLE `t_mm_product_notice` (
  `product_notice_id` varchar(36) NOT NULL COMMENT '商品公告id',
  `name` varchar(50) NOT NULL COMMENT '公告名称',
  `content` varchar(150) NOT NULL COMMENT '内容',
  `createtime` datetime NOT NULL COMMENT '发布时间',
  `user_id` varchar(36) NOT NULL COMMENT '发布人id',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_product_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_product_picture`;
CREATE TABLE `t_mm_product_picture` (
  `product_picture_id` varchar(36) NOT NULL COMMENT '商品焦点图id',
  `product_id` varchar(36) NOT NULL COMMENT '商品id',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(255) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  `url` varchar(50) NOT NULL COMMENT '路径',
  PRIMARY KEY (`product_picture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_product_stock
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_product_stock`;
CREATE TABLE `t_mm_product_stock` (
  `product_stock_id` varchar(36) NOT NULL COMMENT '商品库存id',
  `total` int(10) NOT NULL COMMENT '商品总数',
  `surplus` int(10) NOT NULL COMMENT '商品剩余量',
  `clicknum` int(10) NOT NULL COMMENT '商品点击量',
  `price` decimal(10,2) NOT NULL COMMENT '商品单价',
  `area_price` decimal(10,2) NOT NULL COMMENT '区域代理单价',
  `shop_price` decimal(10,2) NOT NULL COMMENT '专卖店单价',
  `microproxy_price` decimal(10,2) NOT NULL COMMENT '微代理单价',
  `sale_price` decimal(10,2) DEFAULT NULL COMMENT '商品特销价',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_product_type
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_product_type`;
CREATE TABLE `t_mm_product_type` (
  `product_type_id` varchar(36) NOT NULL COMMENT '商品类型id',
  `name` varchar(20) NOT NULL COMMENT '类型名',
  `describle` varchar(50) DEFAULT NULL COMMENT '资源描述',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_mm_product_use
-- ----------------------------
DROP TABLE IF EXISTS `t_mm_product_use`;
CREATE TABLE `t_mm_product_use` (
  `product_use_id` varchar(36) NOT NULL COMMENT '商品用途id',
  `name` varchar(20) NOT NULL COMMENT '用途名',
  `describle` varchar(50) DEFAULT NULL COMMENT '资源描述',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`product_use_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sm_region
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_region`;
CREATE TABLE `t_sm_region` (
  `region_id` varchar(36) NOT NULL COMMENT '行政编码',
  `name` varchar(20) NOT NULL COMMENT '所在地区',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sm_res
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_res`;
CREATE TABLE `t_sm_res` (
  `res_id` varchar(36) NOT NULL COMMENT '资源id',
  `name` varchar(20) NOT NULL COMMENT '资源名',
  `describle` varchar(50) NOT NULL COMMENT '资源描述',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  `oper_id` varchar(255) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sm_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_role`;
CREATE TABLE `t_sm_role` (
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `describle` varchar(50) NOT NULL COMMENT '描述',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性',
  `oper_id` varchar(255) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sm_role_res
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_role_res`;
CREATE TABLE `t_sm_role_res` (
  `role_res_id` varchar(36) NOT NULL COMMENT '角色资源id',
  `res_id` varchar(36) NOT NULL COMMENT '资源id',
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sm_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_user`;
CREATE TABLE `t_sm_user` (
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `telephone` varchar(11) NOT NULL COMMENT '手机号码',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `photo` varchar(50) DEFAULT NULL COMMENT '头像',
  `validity` tinyint(1) NOT NULL DEFAULT '1' COMMENT '有效性(0无效,1有效)',
  `oper_id` varchar(36) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
