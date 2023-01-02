package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface BangDanJiLuService {

	int add(BangDanJiLu bdjl);

	int deleteByIds(String ids);

	int edit(BangDanJiLu bdjl);

	int queryForInt(String ddh);

	List<BangDanJiLu> queryList(String ddh, int page, int rows, String sort, String order);

	BangDanJiLu selectById(String id);

	BangDanJiLu selectByDdId(Integer ddId);

	boolean checkIfExistByDdId(Long ddId);

	int deleteByDdId(Long id);
}
