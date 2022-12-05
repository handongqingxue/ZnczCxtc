package com.znczCxtc.dao;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface YongHuMapper {

	//通过用户信息查询用户
	YongHu getYongHu(YongHu yh);

	String getMmByYhm(@Param("yhm") String yhm);

	int updateMmById(@Param("mm") String mm, @Param("id") Integer id);
}
