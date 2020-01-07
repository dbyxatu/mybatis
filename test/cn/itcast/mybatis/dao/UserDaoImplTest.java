package cn.itcast.mybatis.dao;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 * 
 * @ClassName: UserDaoImplTest
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/07 20:48:46
 */
public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	/**
	 * 
	 * @Function: setUp
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:48:43
	 *
	 */
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
	 * @Function: testFindUserById
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:49:05
	 *
	 */
	@Test
	public void testFindUserById() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		// 调用UserDao的方法
		User user = userDao.findUserById(1);

		System.out.println(user);
	}

	/**
	 * 
	 * @Function: testFindUserByName
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:49:09
	 *
	 */
	@Test
	public void testFindUserByName() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		// 调用UserDao的方法
		List<User> userList = userDao.findUserByName("测试");

		System.out.println(userList);
	}

	/**
	 * 
	 * @Function: testInsertUser
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:50:30
	 *
	 */
	@Test
	public void testInsertUser() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		// 准备数据
		User user = new User();
		user.setUsername("王小军");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");

		userDao.insertUser(user);

		System.out.println("success");
	}

	/**
	 * 
	 * @Function: testDeleteUser
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:52:09
	 *
	 */
	@Test
	public void testDeleteUser() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		// 调用UserDao的方法
		userDao.deleteUser(31);

		System.out.println("success");
	}

}
