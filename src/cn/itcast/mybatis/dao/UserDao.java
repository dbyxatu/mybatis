package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;

/**
 * 
 * @ClassName: UserDao
 * @Description: dao接口，用户管理
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/07 20:20:20
 */
public interface UserDao {

	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据用户名列查询用户列表
	public List<User> findUserByName(String name) throws Exception;

	// 添加用户信息
	public void insertUser(User user) throws Exception;

	// 删除用户信息
	public void deleteUser(int id) throws Exception;

}
