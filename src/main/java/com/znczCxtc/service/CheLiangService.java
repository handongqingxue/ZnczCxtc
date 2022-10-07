package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface CheLiangService {

	public int add(CheLiang cl);

	public int deleteCheLiang(String ids);

	public int shenHeCheLiang(String ids,String flag);

	public int editCheLiang(CheLiang cl);

	public int queryForInt(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz);

	public List<CheLiang> queryList(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz, int page, int rows, String sort, String order);

	public CheLiang selectCheLiangById(String id);
}
