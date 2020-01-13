package cn.itcast.mybatis.po;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @ClassName: Items
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author dongby1
 * @date 2020/01/13 15:16:55
 */
@Data
public class Items {
	private Integer id;

	private String name;

	private Float price;

	private String pic;

	private Date createtime;

	private String detail;

	public void setDetail(String detail) {
		this.detail = detail == null ? null : detail.trim();
	}
}