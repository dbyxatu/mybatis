package cn.itcast.mybatis.po;

import lombok.Data;

/**
 * 
 * @ClassName: OrdersCustom
 * @Description: 订单的扩展类
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/09 14:07:44
 */
// 通过此类映射订单和用户查询的结果，让此类继承包括 字段较多的pojo类
@Data
public class OrdersCustom extends Orders {

	// 添加用户属性
	/*
	 * USER.username, USER.sex, USER.address
	 */

	private String username;
	private String sex;
	private String address;

}
