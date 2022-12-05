package com.znczCxtc.service;

import com.znczCxtc.entity.*;

public interface YongHuService {

	int edit(YongHu yh);

	boolean checkMm(String mm, String yhm);

	int updateMmById(String mm, Integer id);

}
