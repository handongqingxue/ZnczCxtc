package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface SiJiService {

	public int add(SiJi sj);

	public int edit(SiJi sj);

	public int queryForInt(String xm, String sjh, String sfzh, Integer zyzt,Integer shzt);

	public List<SiJi> queryList(String xm, String sjh, String sfzh, Integer zyzt, Integer shzt, int page, int rows, String sort, String order);

	public SiJi selectById(String id);
}
