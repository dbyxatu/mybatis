package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.Orderdetail;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

/**
 * 
 * @ClassName: OrdersMapperCustomTest
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/09 14:20:03
 */
public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 
	 * @Function: setUp
	 * @Description: 此方法是在执行testFindUserById之前执行
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月9日 下午2:21:42
	 *
	 */
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 
	 * @Function: testFindOrdersUser
	 * @Description: 一对一映射-使用resultType
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月9日 下午2:21:26
	 *
	 */
	@Test
	public void testFindOrdersUser() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<Orders> list = ordersMapperCustom.findOrdersUser();

		System.out.println(list);

		sqlSession.close();
	}

	/**
	 * 
	 * @Function: testFindOrdersUserResultMap
	 * @Description: 一对一映射-使用resultMap-映射的pojo中包含其他pojo/association：用于映射关联查询单个对象的信息-javaType
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月9日 下午2:21:20
	 *
	 */
	@Test
	public void testFindOrdersUserResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		
		//遍历list
		for(Orders orders : list) {
			System.out.println(orders.getUserId());
		}

		System.out.println(list);

		sqlSession.close();
	}

	/**
	 * 
	* @Function: testFindOrdersAndOrderDetailResultMap
	* @Description: 一对多映射-映射的pojo中不仅包含其他的pojo，还包含其他pojo的List/collection：对关联查询到多条记录映射到集合对象中 -ofType
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: dongby1
	* @date: 2020年1月13日 下午2:30:22 
	*
	 */
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		
//		for(Orders orders : list) {
//			for(Orderdetail od : orders.getOrderdetails()) {
//				System.out.println("-----------------------------------------------"+od.getId() + od.getItemsId() + od.getItemsNum() + od.getItems().toString());
//			}
//		}

		System.out.println(list);

		sqlSession.close();
	}

	
	/**
	 * 
	* @Function: testFindUserAndItemsResultMap
	* @Description: 多对多查询-List套List再套pojo
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: dongby1
	* @date: 2020年1月13日 下午2:39:20 
	*
	 */
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	// 查询订单关联查询用户，用户信息使用延迟加载
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 查询订单信息（单表）
		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

		// 遍历上边的订单列表
		for (Orders orders : list) {
			// 执行getUser()去查询用户信息，这里实现按需加载
			User user = orders.getUser();
			System.out.println(user);
		}

	}

	// 一级缓存测试
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 下边查询使用一个SqlSession
		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);

		// 如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。

		// 更新user1的信息
		// user1.setUsername("测试用户22");
		// userMapper.updateUser(user1);
		// //执行commit操作去清空缓存
		// sqlSession.commit();

		// 第二次发起请求，查询id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();

	}

	// 二级缓存测试
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);

		// 这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
		sqlSession1.close();

		// //使用sqlSession3执行commit()操作
		// UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		// User user = userMapper3.findUserById(1);
		// user.setUsername("张明明");
		// userMapper3.updateUser(user);
		// //执行提交，清空UserMapper下边的二级缓存
		// sqlSession3.commit();
		// sqlSession3.close();

		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 第二次发起请求，查询id为1的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();

	}

}
