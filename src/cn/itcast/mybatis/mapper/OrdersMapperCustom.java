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

	/**
	 * 
	 * @Function: findOrdersUser
	 * @Description: 查询订单关联查询用户信息
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月14日 上午9:42:14
	 *
	 */
	public List<Orders> findOrdersUser() throws Exception;

	/**
	 * 
	 * @Function: findOrdersUserResultMap
	 * @Description: 查询订单关联查询用户使用resultMap
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月14日 上午9:42:30
	 *
	 */
	public List<Orders> findOrdersUserResultMap() throws Exception;

	/**
	 * 
	 * @Function: findOrdersAndOrderDetailResultMap
	 * @Description: 查询订单(关联用户)及订单明细
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月14日 上午9:42:40
	 *
	 */
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

	/**
	 * 
	 * @Function: findUserAndItemsResultMap
	 * @Description: 查询用户购买商品信息
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月14日 上午9:42:55
	 *
	 */
	public List<User> findUserAndItemsResultMap() throws Exception;

	/**
	 * 
	 * @Function: findOrdersUserLazyLoading
	 * @Description: 查询订单关联查询用户，用户信息是延迟加载
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月14日 上午9:43:06
	 *
	 */
	public List<Orders> findOrdersUserLazyLoading() throws Exception;

}
