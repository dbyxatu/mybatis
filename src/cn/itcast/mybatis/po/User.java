package cn.itcast.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @ClassName: User
 * @Description: 用户po
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/06 22:43:43
 */
@Data
public class User implements Serializable{

	// 属性名和数据库表的字段对应
	private int id;
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址

	// 用户创建的订单列表
	private List<Orders> ordersList;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + "]";
	}

}
