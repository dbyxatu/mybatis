package cn.itcast.mybatis.po;

import lombok.Data;

@Data
public class Orderdetail {
	private Integer id;

	private Integer ordersId;

	private Integer itemsId;

	private Integer itemsNum;

	// 明细对应的商品信息
	private Items items;

	@Override
	public String toString() {
		return "Orderdetail [id=" + id + ", ordersId=" + ordersId + ", itemsId=" + itemsId + ", itemsNum=" + itemsNum
				+ "]";
	}

}