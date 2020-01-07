package cn.itcast.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

/**
 * 
 * @ClassName: UserDaoImpl
 * @Description: dao接口实现类
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/07 20:20:57
 */
public class UserDaoImpl implements UserDao {

	// 需要向dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * 
	 * @see cn.itcast.mybatis.dao.UserDao#findUserById(int)
	 * @Function: UserDaoImpl.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:21:29
	 *
	 */
	@Override
	public User findUserById(int id) throws Exception {
		/*
		 * 问题一 此处为模版方法
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();

		/*
		 * 问题二 此处方法调用时存在statement id = test.findUserById 硬编码问题
		 */
		/*
		 * 问题三
		 * 调用sqlsession方法时传入的变量，由于sqlsession方法使用Object泛型，即使变量类型传入错误，在编译阶段也不报错，不利于程序员开发
		 */
		User user = sqlSession.selectOne("test.findUserById", id);

		// 释放资源
		sqlSession.close();

		return user;

	}

	/**
	 * 
	 * @see cn.itcast.mybatis.dao.UserDao#findUserByName(java.lang.String)
	 * @Function: UserDaoImpl.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:21:56
	 *
	 */
	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", name);

		// 释放资源
		sqlSession.close();

		return list;
	}

	/**
	 * 
	 * @see cn.itcast.mybatis.dao.UserDao#insertUser(cn.itcast.mybatis.po.User)
	 * @Function: UserDaoImpl.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:22:00
	 *
	 */
	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行插入操作
		sqlSession.insert("test.insertUser", user);

		// 提交事务
		sqlSession.commit();

		// 释放资源
		sqlSession.close();

	}

	/**
	 * 
	 * @see cn.itcast.mybatis.dao.UserDao#deleteUser(int)
	 * @Function: UserDaoImpl.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: dongby1
	 * @date: 2020年1月7日 下午8:22:03
	 *
	 */
	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行插入操作
		sqlSession.delete("test.deleteUser", id);

		// 提交事务
		sqlSession.commit();

		// 释放资源
		sqlSession.close();

	}

}
