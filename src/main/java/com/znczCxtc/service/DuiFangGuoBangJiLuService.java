package com.znczCxtc.service;

import com.znczCxtc.entity.*;

public interface DuiFangGuoBangJiLuService {

	int add(DuiFangGuoBangJiLu dfgbjl);

	int editByDdId(DuiFangGuoBangJiLu dfgbjl);

	DuiFangGuoBangJiLu selectByDdId(String ddId);

	boolean checkIfExistByDdId(Integer ddId);
}
