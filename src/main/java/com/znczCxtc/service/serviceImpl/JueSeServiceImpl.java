package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;
import com.znczCxtc.entity.*;

@Service
public class JueSeServiceImpl implements JueSeService {

	@Autowired
	private JueSeMapper jueSeDao;
	@Autowired
	private QuanXianMapper quanXianDao;

	@Override
	public int add(JueSe js) {
		// TODO Auto-generated method stub
		return jueSeDao.add(js);
	}

	@Override
	public int edit(JueSe js) {
		// TODO Auto-generated method stub
		return jueSeDao.edit(js);
	}

	@Override
	public int queryForInt(String mc) {
		// TODO Auto-generated method stub
		return jueSeDao.queryForInt(mc);
	}

	@Override
	public List<JueSe> queryList(String mc, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return jueSeDao.queryList(mc, (page-1)*rows, rows, sort, order);
	}

	@Override
	public JueSe selectById(String id) {
		// TODO Auto-generated method stub
		JueSe js = jueSeDao.selectById(id);
		List<QuanXian> qxList = quanXianDao.queryCBBList();
		String qxIds = js.getQxIds();
		String[] qxIdArr = qxIds.split(",");
		String qxMcs = "";
		for (String qxIdStr : qxIdArr) {
			int qxId = Integer.valueOf(qxIdStr);
			for (int i = 0; i < qxList.size(); i++) {
				QuanXian qx = qxList.get(i);
				if(qxId==qx.getId()) {
					qxMcs+=","+qx.getMc();
					break;
				}
			}
		}
		js.setQxMcs(qxMcs.substring(1));
		return js;
	}

	@Override
	public List<JueSe> queryCBBList() {
		// TODO Auto-generated method stub
		return jueSeDao.queryCBBList();
	}
}
