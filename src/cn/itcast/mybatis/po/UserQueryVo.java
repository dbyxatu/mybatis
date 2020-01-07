package cn.itcast.mybatis.po;

import java.util.List;

import lombok.Data;

/**
 * 
 * @ClassName: UserQueryVo
 * @Description: 包装类型
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/07 22:09:22
 */
@Data
public class UserQueryVo {

	// 传入多个id
	private List<Integer> ids;

	// 在这里包装所需要的查询条件

	// 用户查询条件
	private UserCustom userCustom;

	// 可以包装其它的查询条件，订单、商品
	// ....

}
