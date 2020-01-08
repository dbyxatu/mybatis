package cn.itcast.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

/**
 * 
 * @ClassName: UserMapper
 * @Description: mapper接口，相当 于dao接口，用户管理
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/07 21:25:49
 */
public interface UserMapper {

	// 用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	// 用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;

	// 根据用户名列查询用户列表
	public List<User> findUserByName(@Param(value = "name") String name) throws Exception;

	// 插入用户
	public void insertUser(User user) throws Exception;

	// 删除用户
	public void deleteUser(int id) throws Exception;

}
