package com.znczCxtc.service.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Service
public class HaoMaServiceImpl implements HaoMaService {

	@Autowired
	private HaoMaMapper haoMaDao;
	@Autowired
	private HaoMaZhuangTaiMapper haoMaZhuangTaiDao;
	@Autowired
	private DingDanMapper dingDanDao;
	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;

	@Override
	public int queryForInt(String dlMc, String hm, String pdh, Integer ztId) {
		// TODO Auto-generated method stub
		return haoMaDao.queryForInt(dlMc,hm,pdh,ztId);
	}

	@Override
	public List<HaoMa> queryList(String dlMc, String hm, String pdh, Integer ztId, int page, int rows, String sort,
			String order) {
		// TODO Auto-generated method stub
		return haoMaDao.queryList(dlMc, hm, pdh, ztId, (page-1)*rows, rows, sort, order);
	}

	@Override
	public int add(HaoMa hm) {
		// TODO Auto-generated method stub
		String hmztMc = hm.getHmztMc();
		if(!StringUtils.isEmpty(hmztMc)) {
			int hmztId=haoMaZhuangTaiDao.getIdByMc(hmztMc);
			hm.setHmztId(hmztId);
		}
		return haoMaDao.add(hm);
	}

	@Override
	public HaoMa selectHaoMaById(String id) {
		// TODO Auto-generated method stub
		return haoMaDao.selectHaoMaById(id);
	}

	@Override
	public List<HaoMa> getJhPdList() {
		// TODO Auto-generated method stub
		return haoMaDao.getJhPdList();
	}

	@Override
	public int edit(HaoMa hm) {
		// TODO Auto-generated method stub
		String hmztMc = hm.getHmztMc();
		if(!StringUtils.isEmpty(hmztMc)) {
			int hmztId=haoMaZhuangTaiDao.getIdByMc(hmztMc);
			hm.setHmztId(hmztId);
		}
		return haoMaDao.edit(hm);
	}

	@Override
	public Integer getMaxHmByDlId(Integer dlId) {
		// TODO Auto-generated method stub
		return haoMaDao.getMaxHmByDlId(dlId);
	}

	@Override
	public Integer getMaxPdh() {
		// TODO Auto-generated method stub
		return haoMaDao.getMaxPdh();
	}

	@Override
	public int changeToJhz() {
		// TODO Auto-generated method stub
		int count=0;
		List<Integer> ymdDlIdList=new ArrayList<Integer>();
		List<HaoMa> slzHmList=haoMaDao.getSlzList();
		for (HaoMa slzHm : slzHmList) {
			Integer slzsl = slzHm.getSlzsl();
			Integer dlJhyz = slzHm.getDlJhyz();
			if(slzsl==dlJhyz) {
				Integer dlId = slzHm.getDlId();
				ymdDlIdList.add(dlId);
			}
		}
		HaoMa firstHm=haoMaDao.getFirstWmdPdz(ymdDlIdList);
		if(firstHm!=null) {
			Long id = firstHm.getId();
			Long ddId = firstHm.getDdId();
			
			int jhzHmztId = haoMaZhuangTaiDao.getIdByMc(HaoMaZhuangTai.JIAO_HAO_ZHONG_TEXT);
			
			HaoMa hm=new HaoMa();
			hm.setId(id);
			hm.setHmztId(jhzHmztId);
			count=haoMaDao.edit(hm);
			if(count>0) {
				int drcDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.DAI_RU_CHANG_TEXT);
				
				DingDan dd=new DingDan();
				dd.setId(ddId);
				dd.setDdztId(drcDdztId);
				count=dingDanDao.edit(dd);
			}
		}
		return count;
	}

	@Override
	public int sortPdzHm() {
		// TODO Auto-generated method stub
		int count=0;
		List<HaoMa> pdzList=haoMaDao.getPdzList();
		for (int i = 0; i < pdzList.size(); i++) {
			HaoMa pdzHm = pdzList.get(i);
			pdzHm.setHm(i++);
			count=haoMaDao.edit(pdzHm);
		}
		return count;
	}
}
