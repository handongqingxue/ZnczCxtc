package com.znczCxtc.dao;

import org.apache.ibatis.annotations.Param;

import com.znczCxtc.entity.*;

public interface DuiFangGuoBangJiLuMapper {

	int add(DuiFangGuoBangJiLu dfgbjl);

	int editByDdId(DuiFangGuoBangJiLu dfgbjl);

	DuiFangGuoBangJiLu selectByDdId(@Param("ddId") String ddId);

	int getCountByDdId(@Param("ddId") Long ddId);

	int updateFileByDdId(DuiFangGuoBangJiLu dfgbjl);
}
