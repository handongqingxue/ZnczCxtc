package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface RglrSfzhJiLuService {

	List<String> queryXzSfzhCBBList(int page, int rows, String sort, String order);

	/**
	 * 根据订单id、身份证号验证记录是否存在(这个方法是验证身份证号记录里是否存在，与验证订单表里的那个方法不同。因为身份证记录表与订单表里的记录不一定同步，必须两张表都加个验证方法)
	 * @param ddId
	 * @param sfzh
	 * @return
	 */
	boolean checkIfExistByDdIdSfzh(Long ddId, String sfzh);

	int add(RglrSfzhJiLu rglrSfzhJiLu);

}
