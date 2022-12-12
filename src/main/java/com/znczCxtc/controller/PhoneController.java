package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

@Controller
@RequestMapping("/"+PhoneController.MODULE_NAME)
public class PhoneController {

	@Autowired
	private YongHuService yongHuService;
	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private DingDanZhuangTaiService dingDanZhuangTaiService;
	static final String MODULE_NAME=Constant.PHONE_MODULE_NAME;

	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, Object> login(String yhm, String mm) {
		
		System.out.println("yhm==="+yhm);
		System.out.println("mm==="+mm);

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		YongHu yongHu=yongHuService.get(yhm,mm);

		if(yongHu==null) {
			jsonMap.put("status", "no");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("yongHu", yongHu);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newDingDanZhuangTai")
	@ResponseBody
	public Map<String, Object> newDingDanZhuangTai(DingDanZhuangTai ddzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=dingDanZhuangTaiService.add(ddzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建订单状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建订单状态失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editDingDanZhuangTai")
	@ResponseBody
	public Map<String, Object> editDingDanZhuangTai(DingDanZhuangTai ddzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=dingDanZhuangTaiService.edit(ddzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑订单状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑订单状态失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getDDZT")
	@ResponseBody
	public Map<String, Object> getDDZT(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			DingDanZhuangTai ddzt=dingDanZhuangTaiService.selectById(id);
			if(ddzt==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("ddzt", ddzt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getDDZTList")
	@ResponseBody
	public Map<String, Object> getDDZTList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanZhuangTaiService.queryForInt(mc);
			List<DingDanZhuangTai> ddztList=dingDanZhuangTaiService.queryList(mc, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", ddztList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getZHCXList")
	@ResponseBody
	public Map<String, Object> getZHCXList(String ddh,Integer ddztId,String ddztMc,String cyclCph,String jhysrq,String yssMc,String wzMc,
			String fhdwMc,String shdwMc,String cysjXm,String cysjSfzh,String jcsjs,String jcsje,String ccsjs,String ccsje,
			int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanService.queryForInt(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje);
			List<DingDan> zhglList=dingDanService.queryList(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", zhglList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getConstantFlagMap")
	@ResponseBody
	public Map<String, Object> getConstantFlagMap(){

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("lxlx", Constant.LXLX);
		jsonMap.put("ddzt", Constant.DDZT);
		
		return jsonMap;
	}

	@RequestMapping(value="/getConstantMap")
	@ResponseBody
	public Map<String, Object> getConstantMap(String flags) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		String[] flagArr = flags.split(",");
		for (String flag : flagArr) {
			Integer flagInt = Integer.valueOf(flag);
			switch (flagInt) {
			case Constant.LXLX:
				Map<String, Object> lxlxMap = Constant.getLxlxMap();
				jsonMap.put("lxlxMap", lxlxMap);
				break;
			case Constant.DDZT:
				Map<String, Object> ddztMap = Constant.getDdztMap();
				jsonMap.put("ddztMap", ddztMap);
				break;
			}
		}
		
		return jsonMap;
	}
}
