package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class GuoBangJiLuServiceImpl implements GuoBangJiLuService {

	@Autowired
	private GuoBangJiLuMapper guoBangJiLuDao;

	@Override
	public int add(GuoBangJiLu gbjl) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.add(gbjl);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=guoBangJiLuDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(GuoBangJiLu gbjl) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.edit(gbjl);
	}

	@Override
	public int queryForInt(String ddh, String cyclCph, String gbsjks, String gbsjjs) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.queryForInt(ddh, cyclCph, gbsjks, gbsjjs);
	}

	@Override
	public List<GuoBangJiLu> queryList(String ddh, String cyclCph, String gbsjks, String gbsjjs, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.queryList(ddh, cyclCph, gbsjks, gbsjjs, (page-1)*rows, rows, sort, order);
	}

	@Override
	public GuoBangJiLu selectById(String id) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.selectById(id);
	}

	@Override
	public int queryDJYForInt(String ddh, String ddztMc, String cysjXm, String cysjSfzh, String cyclCph, String yssMc, String fhdwMc, String shdwMc, String gbsjks, String gbsjjs, Integer gblx) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.queryDJYForInt(ddh, ddztMc, cysjXm, cysjSfzh, cyclCph, yssMc, fhdwMc, shdwMc, gbsjks, gbsjjs, gblx);
	}

	@Override
	public List<GuoBangJiLu> queryDJYList(String ddh, String ddztMc, String cysjXm, String cysjSfzh, String cyclCph, String yssMc, String fhdwMc, String shdwMc, String gbsjks, String gbsjjs, Integer gblx, int page, int rows,
			String sort, String order) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.queryDJYList(ddh, ddztMc, cysjXm, cysjSfzh, cyclCph, yssMc, fhdwMc, shdwMc, gbsjks, gbsjjs, gblx, (page-1)*rows, rows, sort, order);
	}

	@Override
	public GuoBangJiLu selectPrintInfo(Integer ddId, Integer gblx) {
		// TODO Auto-generated method stub
		GuoBangJiLu gbjl = guoBangJiLuDao.selectPrintInfo(ddId, gblx);
		if(gbjl.getGblx()==GuoBangJiLu.RU_CHANG_GUO_BANG)
			gbjl.setGblxName("入厂过磅");
		else
			gbjl.setGblxName("出厂过磅");
		return gbjl;
	}

	@Override
	public boolean checkIfExistByDdId(Integer gblx, Long ddId) {
		// TODO Auto-generated method stub
		int count=guoBangJiLuDao.getCountByDdId(gblx,ddId);
		return count==0?false:true;
	}

	@Override
	public int deleteByDdId(Integer gblx,Long ddId) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.deleteByDdId(gblx, ddId);
	}
}
