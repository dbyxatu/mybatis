package cn.itcast.mybatis.po;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @ClassName: Orders
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/09 14:23:42
 */
@Data
public class Orders {
	private Integer id;

	private Integer userId;

	private String number;

	private Date createtime;

	private String note;

	// 用户信息
	private User user;

	// 订单明细
	private List<Orderdetail> orderdetails;

}