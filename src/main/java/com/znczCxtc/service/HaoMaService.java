package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface HaoMaService {


	public int queryForInt(String dlMc, String hm, String pdh, Integer ztId);

	public List<HaoMa> queryList(String dlMc, String hm, String pdh, Integer ztId, int page, int rows, String sort,
			String order);

	public int newHaoMaChaXun(HaoMa hm);

	public HaoMa selectHaoMaById(String id);

	public List<HaoMa> getJhPdList();

	public int edit(HaoMa hm);
}
