package com.znczCxtc.service;

import java.util.List;

import com.znczCxtc.entity.*;

public interface RglrSfzhJiLuService {

	List<String> queryXzSfzhCBBList(int page, int rows, String sort, String order);

	/**
	 * ���ݶ���id�����֤����֤��¼�Ƿ����(�����������֤���֤�ż�¼���Ƿ���ڣ�����֤����������Ǹ�������ͬ����Ϊ���֤��¼���붩������ļ�¼��һ��ͬ�����������ű��Ӹ���֤����)
	 * @param ddId
	 * @param sfzh
	 * @return
	 */
	boolean checkIfExistByDdIdSfzh(Long ddId, String sfzh);

	int add(RglrSfzhJiLu rglrSfzhJiLu);

}
