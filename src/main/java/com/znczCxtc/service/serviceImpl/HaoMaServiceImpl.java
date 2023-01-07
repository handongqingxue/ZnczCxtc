package com.znczCxtc.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public int queryForInt(String dlMc, String hm, String pdh, Integer hmztId) {
		// TODO Auto-generated method stub
		return haoMaDao.queryForInt(dlMc,hm,pdh,hmztId);
	}

	@Override
	public List<HaoMa> queryList(String dlMc, String hm, String pdh, Integer hmztId, int page, int rows, String sort,
			String order) {
		// TODO Auto-generated method stub
		return haoMaDao.queryList(dlMc, hm, pdh, hmztId, (page-1)*rows, rows, sort, order);
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
		List<Integer> ymdDlIdList=new ArrayList<Integer>();//已满队列表
		List<HaoMa> slzHmList=haoMaDao.getSlzList();
		for (HaoMa slzHm : slzHmList) {
			Integer slzsl = slzHm.getSlzsl();
			Integer dlJhyz = slzHm.getDlJhyz();
			if(slzsl==dlJhyz) {//若受理中数量等于队列叫号阈值，就判断该队列已满队，不再继续叫号
				Integer dlId = slzHm.getDlId();
				ymdDlIdList.add(dlId);
			}
		}
		HaoMa firstHm=haoMaDao.getFirstWmdPdz(ymdDlIdList);//获取第一个未满队行列里的号码
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
	public Map<String, Object> changeToJhzByIds(String ids, String hms, String ddIds) {
		// TODO Auto-generated method stub
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<Integer> ymdDlIdList=new ArrayList<Integer>();//已满队列表
		List<HaoMa> slzHmList=haoMaDao.getSlzList();
		for (HaoMa slzHm : slzHmList) {
			Integer slzsl = slzHm.getSlzsl();
			Integer dlJhyz = slzHm.getDlJhyz();
			if(slzsl==dlJhyz) {//若受理中数量等于队列叫号阈值，就判断该队列已满队，不再继续叫号
				Integer dlId = slzHm.getDlId();
				ymdDlIdList.add(dlId);
			}
		}

		List<Long> wmdIdList=new ArrayList<>();
		List<String> ymdHmList=new ArrayList<>();
		List<Long> ddIdList=new ArrayList<>();
		String[] idArr = ids.split(",");
		String[] hmArr = hms.split(",");
		String[] ddIdArr = ddIds.split(",");
		List<HaoMa> hmList=haoMaDao.getWmdPdzList(ymdDlIdList);
		for (int i = 0; i < idArr.length; i++) {
			boolean exist=false;
			long idInt = Long.valueOf(idArr[i]);
			for (int j = 0; j < hmList.size(); j++) {
				HaoMa hm = hmList.get(j);
				if(idInt==hm.getId()) {
					exist=true;
					wmdIdList.add(idInt);
					long ddIdInt = Long.valueOf(ddIdArr[i]);
					ddIdList.add(ddIdInt);
					break;
				}
			}
			if(!exist) {
				String ymdHm = hmArr[i];
				ymdHmList.add(ymdHm);
			}
		}

		int count=0;
		if(ymdHmList.size()>0) {
			String ymdHmsStr="";
			for (int i = 0; i < ymdHmList.size(); i++) {
				String ymdHm = ymdHmList.get(i);
				ymdHmsStr=","+ymdHm;
			}
			if(wmdIdList.size()>0) {
				int jhzHmztId = haoMaZhuangTaiDao.getIdByMc(HaoMaZhuangTai.JIAO_HAO_ZHONG_TEXT);
				count=haoMaDao.changeZtByIdList(jhzHmztId,wmdIdList);
				if(count>0) {
					int drcDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.DAI_RU_CHANG_TEXT);
					count=dingDanDao.changeZtByIdList(drcDdztId,ddIdList);
				}
			}
			jsonMap.put("status", "partFinish");
			jsonMap.put("message", "号码:"+ymdHmsStr.substring(1)+"所属队列已满队，稍后再叫号");
		}
		else {
			if(wmdIdList.size()>0) {
				int jhzHmztId = haoMaZhuangTaiDao.getIdByMc(HaoMaZhuangTai.JIAO_HAO_ZHONG_TEXT);
				count=haoMaDao.changeZtByIdList(jhzHmztId,wmdIdList);
				if(count>0) {
					int drcDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.DAI_RU_CHANG_TEXT);
					count=dingDanDao.changeZtByIdList(drcDdztId,ddIdList);
				}
			}
			jsonMap.put("status", "allFinish");
			jsonMap.put("message", "叫号成功");
		}
		
		return jsonMap;
	}

	@Override
	public int sortPdzHm() {
		// TODO Auto-generated method stub
		int count=0;
		List<HaoMa> pdzList=haoMaDao.getPdzList();
		for (int i = 0; i < pdzList.size(); i++) {
			HaoMa pdzHm = pdzList.get(i);
			pdzHm.setPdh(++i);
			count=haoMaDao.edit(pdzHm);
		}
		return count;
	}

	@Override
	public HaoMa getLastByDdId(Long ddId) {
		// TODO Auto-generated method stub
		return haoMaDao.getLastByDdId(ddId);
	}
}
