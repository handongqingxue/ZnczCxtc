package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface ShouHuoDanWeiService {

	public int add(ShouHuoDanWei shdw);

	public int deleteByIds(String ids);

	public int edit(ShouHuoDanWei shdw);

	public int queryForInt(String mc);

	public List<ShouHuoDanWei> queryList(String mc, int page, int rows, String sort, String order);

	public ShouHuoDanWei selectById(String id);

	List<ShouHuoDanWei> queryCBBList();

}
