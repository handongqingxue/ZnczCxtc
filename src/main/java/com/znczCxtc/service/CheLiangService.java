package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface CheLiangService {

	public int add(CheLiang cl);

	public int deleteByIds(String ids);

	public int checkByIds(String ids,CheLiangShenHeJiLu clshjl);

	public int edit(CheLiang cl);

	public int queryForInt(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz);

	public List<CheLiang> queryList(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz, int page, int rows, String sort, String order);

	public CheLiang selectById(String id);

	public List<CheLiang> queryCBBList();
}
