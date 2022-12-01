package com.znczCxtc.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {

	@Autowired
	private ExportExcelMapper exportExcelDao;

	@Override
	public List<DingDan> queryDDZHCXList(String ddh, Integer ddztId, String ddztMc, String cyclCph, String jhysrq,
			String yssMc, String wzMc, String fhdwMc, String shdwMc, String cysjXm, String cysjSfzh, String jcsjs,
			String jcsje, String ccsjs, String ccsje, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<DingDan> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryDDZHCXList(ddh, ddztId, ddztMc, cyclCph, jhysrq, yssMc, wzMc, fhdwMc, shdwMc, cysjXm, cysjSfzh, jcsjs,
					jcsje, ccsjs, ccsje, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryDDZHCXList(ddh, ddztId, ddztMc, cyclCph, jhysrq, yssMc, wzMc, fhdwMc, shdwMc, cysjXm, cysjSfzh, jcsjs,
					jcsje, ccsjs, ccsje, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<DingDanShenHeJiLu> queryDDSHJLList(String ddh, Integer shlx, String shsjks, String shsjjs, String cyclCph,
			String shrYhm, String yssMc, String wzMc, String fhdwMc, String shdwMc, String sjXm, String sjSfzh,
			Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<DingDanShenHeJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryDDSHJLList(ddh, shlx, shsjks, shsjjs, cyclCph, shrYhm, yssMc, wzMc, fhdwMc, shdwMc, sjXm, sjSfzh,
					(page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryDDSHJLList(ddh, shlx, shsjks, shsjjs, cyclCph, shrYhm, yssMc, wzMc, fhdwMc, shdwMc, sjXm, sjSfzh, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<BangDanJiLu> queryBDJLList(String ddh, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<BangDanJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryBDJLList(ddh, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryBDJLList(ddh, dcfw);
			break;
		}
		return list;
	}
	
	@Override
	public List<GuoBangJiLu> queryGBJLList(String ddh, String cyclCph, String gbsjks, String gbsjjs, Integer page,
			Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<GuoBangJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryGBJLList(ddh, cyclCph, gbsjks, gbsjjs, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryGBJLList(ddh, cyclCph, gbsjks, gbsjjs, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<GuoBangJiLu> queryDJYList(String ddh, String ddztMc, String cysjXm, String cysjSfzh, String cyclCph,
			String yssMc, String fhdwMc, String shdwMc, String gbsjks, String gbsjjs, Integer gblx, Integer page,
			Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<GuoBangJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryDJYList(ddh, ddztMc, cysjXm, cysjSfzh, cyclCph, yssMc, fhdwMc, shdwMc, gbsjks, gbsjjs, gblx, 
					(page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryDJYList(ddh, ddztMc, cysjXm, cysjSfzh, cyclCph, yssMc, fhdwMc, shdwMc, gbsjks, gbsjjs, gblx, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<WuZiLeiXing> queryWZLXList(String mc, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<WuZiLeiXing> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryWZLXList(mc, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryWZLXList(mc, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<WuZi> queryWuZiList(String mc, String wzlxmc, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<WuZi> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryWuZiList(mc, wzlxmc, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryWuZiList(mc, wzlxmc, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<YunShuShang> queryYunShuShangList(String mc, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<YunShuShang> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryYunShuShangList(mc, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryYunShuShangList(mc, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<FaHuoDanWei> queryFaHuoDanWeiList(String mc, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<FaHuoDanWei> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryFaHuoDanWeiList(mc, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryFaHuoDanWeiList(mc, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<ShouHuoDanWei> queryShouHuoDanWeiList(String mc, Boolean ywdl, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<ShouHuoDanWei> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryShouHuoDanWeiList(mc, ywdl, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryShouHuoDanWeiList(mc, ywdl, dcfw);
			break;
		}
		return list;
	}

}
