package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

/**
 * 
 * @ClassName: OrdersMapperCustom
 * @Description: 订单mapper
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/09 14:11:41
 */
public interface OrdersMapperCustom {

	// 查询订单关联查询用户信息
	public List<Orders> findOrdersUser() throws Exception;

	// 查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap() throws Exception;

	// 查询订单(关联用户)及订单明细
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

	// 查询用户购买商品信息
	public List<User> findUserAndItemsResultMap() throws Exception;

	// 查询订单关联查询用户，用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading() throws Exception;

}
