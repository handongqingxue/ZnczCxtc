package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class CheLiangServiceImpl implements CheLiangService {

	@Autowired
	private CheLiangMapper cheLiangDao;
	@Autowired
	private CheLiangShenHeJiLuMapper cheLiangShenHeJiLuDao;

	@Override
	public int add(CheLiang cl) {
		// TODO Auto-generated method stub
		return cheLiangDao.add(cl);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count = cheLiangDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int checkByIds(String ids,CheLiangShenHeJiLu clshjl) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		if(cheLiangDao.checkByIds(idList,clshjl.getShjg())>0) {
			for (String idStr : idList) {
				Integer clId = Integer.valueOf(idStr);
				clshjl.setClId(clId);
				count+=cheLiangShenHeJiLuDao.add(clshjl);
			}
		}
		return count;
	}

	@Override
	public int edit(CheLiang cl) {
		// TODO Auto-generated method stub
		return cheLiangDao.edit(cl);
	}

	@Override
	public int queryForInt(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz) {
		// TODO Auto-generated method stub
		List<String> shztList = null;
		if(!StringUtils.isEmpty(shzt))
			shztList = Arrays.asList(shzt.split(","));
		return cheLiangDao.queryForInt(cph,cllx,sfzy,pfjd,shztList,bz);
	}

	@Override
	public List<CheLiang> queryList(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		List<String> shztList = null;
		if(!StringUtils.isEmpty(shzt))
			shztList = Arrays.asList(shzt.split(","));
		return cheLiangDao.queryList(cph, cllx, sfzy, pfjd, shztList, bz, (page-1)*rows, rows, sort, order);
	}

	@Override
	public CheLiang selectById(String id) {
		// TODO Auto-generated method stub
		return cheLiangDao.selectById(id);
	}

	@Override
	public List<CheLiang> queryCBBList() {
		// TODO Auto-generated method stub
		return cheLiangDao.queryCBBList();
	}

	@Override
	public int getIdByCph(String cph) {
		// TODO Auto-generated method stub
		return cheLiangDao.getIdByCph(cph);
	}
}
