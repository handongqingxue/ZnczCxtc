package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface JueSeService {

	int queryForInt(String mc);

	List<JueSe> queryList(String mc, int page, int rows, String sort, String order);

	List<JueSe> queryCBBList();
}
