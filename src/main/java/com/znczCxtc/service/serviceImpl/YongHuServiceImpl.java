package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class YongHuServiceImpl implements YongHuService {

	@Autowired
	private YongHuMapper yongHuDao;
	@Autowired
	private JueSeMapper jueSeDao;

	@Override
	public int add(YongHu yh) {
		// TODO Auto-generated method stub
		return yongHuDao.add(yh);
	}

	@Override
	public int edit(YongHu yh) {
		// TODO Auto-generated method stub
		return yongHuDao.edit(yh);
	}

	@Override
	public int queryForInt(String yhm,Integer shzt) {
		// TODO Auto-generated method stub
		return yongHuDao.queryForInt(yhm,shzt);
	}

	@Override
	public List<YongHu> queryList(String yhm, Integer shzt, int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return yongHuDao.queryList(yhm, shzt, (page-1)*rows, rows, sort, order);
	}

	@Override
	public YongHu selectById(String id) {
		// TODO Auto-generated method stub
		YongHu yh = yongHuDao.selectById(id);
		List<JueSe> jsList = jueSeDao.queryCBBList();
		String jsIds = yh.getJsIds();
		String[] jsIdArr = jsIds.split(",");
		String jsMcs = "";
		for (String jsIdStr : jsIdArr) {
			int jsId = Integer.valueOf(jsIdStr);
			for (int i = 0; i < jsList.size(); i++) {
				JueSe js = jsList.get(i);
				if(jsId==js.getId()) {
					jsMcs+=","+js.getMc();
					break;
				}
			}
		}
		yh.setJsMcs(jsMcs.substring(1));
		return yh;
	}

	@Override
	public boolean checkMm(String mm, String yhm) {
		// TODO Auto-generated method stub

		String mm1 = yongHuDao.getMmByYhm(yhm);
		if(mm1.equals(mm)) {
			return true;
		}
		else
			return false;
	}

	@Override
	public int updateMmById(String mm, Integer id) {
		// TODO Auto-generated method stub
		return yongHuDao.updateMmById(mm,id);
	}
}
