package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface WuZiService {


	public int add(WuZi wz);

	public int deleteByIds(String ids);

	public int edit(WuZi wz);

	public int queryForInt(String mc, String wzlxmc);

	public List<WuZi> queryList(String mc, String wzlxmc, int page, int rows, String sort, String order);

	public WuZi selectById(String id);

	public List<WuZi> queryCBBList(String wzlxId);

	public List<WuZiLeiXing> checkIfExistByLxIds(String lxIds,String lxMcs);
}
