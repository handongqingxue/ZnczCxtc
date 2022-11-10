package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface DuiLieService {

	int add(DuiLie dl);

	int deleteByIds(String ids);

	int edit(DuiLie dl);

	int queryForInt(String mc, String dm, Integer zt);

	List<DuiLie> queryList(String mc, String dm, Integer zt, int page, int rows, String sort, String order);

	DuiLie selectById(String id);

	List<DuiLie> queryCBBList(Integer zt);

	Integer getIdByDdId(Long ddId);

}
