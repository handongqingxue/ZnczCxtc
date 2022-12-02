package com.znczCxtc.service.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

	@Override
	public List<CangKu> queryCangKuList(String mc, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<CangKu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryCangKuList(mc, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryCangKuList(mc, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<CheLiang> queryCLZHCXList(String cph, Integer cllx, Boolean sfzy, Integer pfjd, String shzt, String bz,
			Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<CheLiang> list = null;
		List<String> shztList = null;
		if(!StringUtils.isEmpty(shzt))
			shztList = Arrays.asList(shzt.split(","));
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryCLZHCXList(cph, cllx, sfzy, pfjd, shztList, bz, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryCLZHCXList(cph, cllx, sfzy, pfjd, shztList, bz, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<CheLiangShenHeJiLu> queryCLSHJLList(String clCph, String shrYhm, String shsjks, String shsjjs,
			Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<CheLiangShenHeJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryCLSHJLList(clCph, shrYhm, shsjks, shsjjs, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryCLSHJLList(clCph, shrYhm, shsjks, shsjjs, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<CheLiangTaiZhang> queryCLTZList(String ddh, String cph, String ddztIds, String ddztMcs, String jcsjs,
			String jcsje, String ccsjs, String ccsje, Integer page, Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<String> ddztIdList = null;
		if(!StringUtils.isBlank(ddztIds))
			ddztIdList = Arrays.asList(ddztIds.split(","));
		
		List<String> ddztMcList = null;
		if(!StringUtils.isBlank(ddztMcs))
			ddztMcList = Arrays.asList(ddztMcs.split(","));
		
		List<CheLiangTaiZhang> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryCLTZList(ddh, cph, ddztIdList, ddztMcList, jcsjs, jcsje, ccsjs, ccsje, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryCLTZList(ddh, cph, ddztIdList, ddztMcList, jcsjs, jcsje, ccsjs, ccsje, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<SiJi> querySiJiList(String xm, String sjh, String sfzh, Integer zyzt, Integer shzt, Integer page,
			Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<SiJi> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.querySiJiList(xm, sjh, sfzh, zyzt, shzt, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.querySiJiList(xm, sjh, sfzh, zyzt, shzt, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<SiJiShenHeJiLu> querySJSHJLList(String sjXm, String shrYhm, String shsjks, String shsjjs, Integer page,
			Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<SiJiShenHeJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.querySJSHJLList(sjXm, shrYhm, shsjks, shsjjs, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.querySJSHJLList(sjXm, shrYhm, shsjks, shsjjs, dcfw);
			break;
		}
		return list;
	}

	@Override
	public List<HaoMa> queryHaoMaList(String dlMc, String hm, String pdh, Integer ztId, Integer page, Integer rows,
			int dcfw) {
		// TODO Auto-generated method stub
		List<HaoMa> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryHaoMaList(dlMc, hm, pdh, ztId, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			list = exportExcelDao.queryHaoMaList(dlMc, hm, pdh, ztId, dcfw);
			break;
		}
		return list;
	}

}
