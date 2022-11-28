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
	public List<GuoBangJiLu> queryGBJList(String ddh, String cph, String gbsjks, String gbsjjs, Integer page,
			Integer rows, int dcfw) {
		// TODO Auto-generated method stub
		List<GuoBangJiLu> list = null;
		switch (dcfw) {
		case Constant.DANG_QIAN_YE:
			list = exportExcelDao.queryGBJList(ddh, cph, gbsjks, gbsjjs, (page-1)*rows, rows, dcfw);
			break;
		case Constant.SUO_YOU_YE:
			
			break;
		}
		return list;
	}

}
