package com.znczCxtc.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

@Service
public class DingDanServiceImpl implements DingDanService {

	@Autowired
	private DingDanMapper dingDanDao;
	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;
	@Autowired
	private DingDanShenHeJiLuMapper dingDanShenHeJiLuDao;
	@Autowired
	private BangDanJiLuMapper bangDanJiLuDao;
	@Autowired
	private GuoBangJiLuMapper guoBangJiLuDao;
	private SimpleDateFormat ddhSdf=new SimpleDateFormat("yyyyMMdd");

	@Override
	public int queryForInt(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq, String yssMc, String wzMc, 
			String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs, String jcsje, String ccsjs, String ccsje) {
		// TODO Auto-generated method stub
		return dingDanDao.queryForInt(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje);
	}

	@Override
	public List<DingDan> queryList(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq, String yssMc, String wzMc, 
			String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs, String jcsje, String ccsjs, String ccsje, 
			int page, int rows, String sort, String order) {
		// TODO Auto-generated method stub
		return dingDanDao.queryList(ddh, ddztId, ddztMc, cyclCph, jhysrq, yssMc, wzMc, fhdwMc, shdwMc, cysjXm, cysjSfzh, jcsjs, jcsje, ccsjs, ccsje, 
				(page-1)*rows, rows, sort, order);
	}

	@Override
	public DingDan selectById(String id) {
		// TODO Auto-generated method stub
		return dingDanDao.selectById(id);
	}

	@Override
	public int add(DingDan dd) {
		// TODO Auto-generated method stub
		String ddh=dd.getDdh();
		String url=dd.getCyclCph();
		String fileName = ddh + ".jpg";
		String avaPath="/ZnczCxtc/upload/Ewm/"+fileName;
		String path = "D:/resource/ZnczCxtc/Ewm";
        QrcodeUtil.createQrCode(url, path, fileName);
        dd.setEwm(avaPath);
        
		int ddztId=dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.DAI_SHEN_HE_TEXT);
		dd.setDdztId(ddztId);
		return dingDanDao.add(dd);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		int count=0;
		List<String> idList = Arrays.asList(ids.split(","));
		count=dingDanDao.deleteByIds(idList);
		return count;
	}

	@Override
	public int edit(DingDan dd) {
		// TODO Auto-generated method stub
		String ddztMc = dd.getDdztMc();
		if(!StringUtils.isEmpty(ddztMc)) {
			int ddztId=dingDanZhuangTaiDao.getIdByMc(ddztMc);
			dd.setDdztId(ddztId);
		}
		return dingDanDao.edit(dd);
	}

	@Override
	public int editByZt(DingDan dd) {
		// TODO Auto-generated method stub
		int ddztId=dingDanZhuangTaiDao.getIdByMc(dd.getDdztMc());
		dd.setDdztId(ddztId);
		String xddztMc = dd.getXddztMc();
		if(!StringUtils.isEmpty(xddztMc)&&!"null".equals(xddztMc)) {
			int xddztId=dingDanZhuangTaiDao.getIdByMc(dd.getXddztMc());
			dd.setXddztId(xddztId);
		}
		return dingDanDao.editByZt(dd);
	}

	@Override
	public int checkByIds(String ids,String ddztMc,Integer jyFlag,DingDanShenHeJiLu ddshjl) {
		// TODO Auto-generated method stub
		int count=0;
		int ddztId=dingDanZhuangTaiDao.getIdByMc(ddztMc);
		List<String> idList = Arrays.asList(ids.split(","));
		if(dingDanDao.checkByIds(idList,ddztId)>0) {
			for (String idStr : idList) {
				Long ddId = Long.valueOf(idStr);
				ddshjl.setDdId(ddId);
				count+=dingDanShenHeJiLuDao.add(ddshjl);
				
				if(!ddshjl.getShjg()&&(jyFlag==GuoBangJiLu.RU_CHANG_GUO_BANG||jyFlag==GuoBangJiLu.CHU_CHANG_GUO_BANG)) {//这块代码是在一检审核或二检审核不通过情况下，把之前的磅单记录、过磅记录删除。与下单审核、入库审核无关
					if(jyFlag==GuoBangJiLu.RU_CHANG_GUO_BANG)//在入厂过磅审核不通过情况下，要删除入厂过磅记录，肯定要连同磅单记录一起删除掉
						bangDanJiLuDao.deleteByDdId(ddId);
					guoBangJiLuDao.deleteByDdId(jyFlag,ddId);
				}
			}
		}
		return count;
	}

	@Override
	public DingDan getDingDanBySfzhZt(String sfzh, String ddztMc) {
		// TODO Auto-generated method stub
		int ddztId=dingDanZhuangTaiDao.getIdByMc(ddztMc);
		List<DingDan> ddList = dingDanDao.getByZtSfzh(ddztId,sfzh);
		DingDan dd=null;
		if(ddList!=null)
			dd=ddList.get(0);
		return dd;
	}

	@Override
	public DingDan getDingDanByCphZts(String cph, String ddztMcs) {
		// TODO Auto-generated method stub
		List<String> ddztMcList = Arrays.asList(ddztMcs.split(","));
		List<Integer> ddztIdList = dingDanZhuangTaiDao.getIdListByMcList(ddztMcList);
		List<DingDan> ddList = dingDanDao.getByZtListCph(ddztIdList,cph);
		DingDan dd=null;
		if(ddList.size()>0)
			dd=ddList.get(0);
		return dd;
	}

	@Override
	public DingDan getByZt(Integer yjbfh,Integer ejbfh,String ddztMc, Integer yjzt, Integer ejzt) {
		// TODO Auto-generated method stub
		return dingDanDao.getByZt(yjbfh,ejbfh,ddztMc, yjzt, ejzt);
	}

	@Override
	public DingDan getQrcodeInfoByCphZt(String cyclCph, String ddztMc) {
		// TODO Auto-generated method stub
		return dingDanDao.getQrcodeInfoByCphZt(cyclCph, ddztMc);
	}

	@Override
	public boolean checkDdhIfExist(String ddh) {
		// TODO Auto-generated method stub
		int count=dingDanDao.getCountByDdh(ddh);
		return count==0?false:true;
	}

	@Override
	public boolean checkIfExistByZt(Integer checkBfh,String checkDdztMc) {
		// TODO Auto-generated method stub
		boolean exist=false;
		String yjzDdztMc=null;
		String ejzDdztMc=null;
		if(DingDanZhuangTai.CHECK_SHANG_BANG_TEXT.equals(checkDdztMc)) {
			yjzDdztMc=DingDanZhuangTai.YI_JIAN_ZHONG_TEXT;
			ejzDdztMc=DingDanZhuangTai.ER_JIAN_ZHONG_TEXT;
		}
		DingDan dd=dingDanDao.getCheckByZt(checkBfh,yjzDdztMc,ejzDdztMc);
		if(dd!=null) {
			String ddztMc = dd.getDdztMc();
			if(DingDanZhuangTai.YI_JIAN_ZHONG_TEXT.equals(ddztMc)) {
				Integer yjbfh = dd.getYjbfh();
				System.out.println("yjbfh==="+yjbfh);
				if(yjbfh==checkBfh)
					exist=true;
			}
			else if(DingDanZhuangTai.ER_JIAN_ZHONG_TEXT.equals(ddztMc)) {
				Integer ejbfh = dd.getEjbfh();
				System.out.println("ejbfh==="+ejbfh);
				if(ejbfh==checkBfh)
					exist=true;
			}
		}
		
		return exist;
	}

	@Override
	public DingDan getByCphJL(String cph) {
		// TODO Auto-generated method stub
		return dingDanDao.getByCphJL(cph);
	}

	@Override
	public long getIdByDdh(String ddh) {
		// TODO Auto-generated method stub
		return dingDanDao.getIdByDdh(ddh);
	}

	@Override
	public boolean checkIfExistByIdCph(Long id, String cph) {
		// TODO Auto-generated method stub
		return dingDanDao.getCountByIdCph(id, cph)==0?false:true;
	}

	@Override
	public String createDdhByDateYMD() {
		// TODO Auto-generated method stub
		String ddhDate = "DD"+ddhSdf.format(new Date());
		Integer count=dingDanDao.getMaxDdhNumByDdhDate(ddhDate);
		if(count==null)
			count=0;
		String ddhxhStr=null;
		int ddhxh=count+1;
		if(ddhxh<10)
			ddhxhStr="000"+ddhxh;
		else if(ddhxh<100)
			ddhxhStr="00"+ddhxh;
		else if(ddhxh<1000)
			ddhxhStr="0"+ddhxh;
		return ddhDate+ddhxhStr;
	}
}