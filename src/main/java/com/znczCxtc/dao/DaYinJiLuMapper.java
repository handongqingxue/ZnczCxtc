package com.znczCxtc.dao;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface DaYinJiLuMapper {

	int add(DaYinJiLu dyjl);

	DaYinJiLu selectByTime(@Param("time") String time);

}
