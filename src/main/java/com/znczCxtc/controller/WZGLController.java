package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

@Controller
@RequestMapping("/"+WZGLController.MODULE_NAME)
public class WZGLController {

	@Autowired
	private WuZiLeiXingService wuZiLeiXingService;
	@Autowired
	private WuZiService wuZiService;
	static final String MODULE_NAME=Constant.WZGL_MODULE_NAME;
	
	@RequestMapping(value="/wzlx/new")
	public String goWzlxNew(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.TIAN_JIA_WU_ZI_LEI_XING,request)) {
			Constant.setYhQxInRequest(request);
			url=MODULE_NAME+"/wzlx/new";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	@RequestMapping(value="/wzlx/edit")
	public String goWzlxEdit(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.XIU_GAI_WU_ZI_LEI_XING,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			WuZiLeiXing wzlx=wuZiLeiXingService.selectById(id);
			request.setAttribute("wzlx", wzlx);
			url=MODULE_NAME+"/wzlx/edit";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/wzlx/list")
	public String goWzlxList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_WU_ZI_LEI_XING,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDcfwInRequest(request);
			url=MODULE_NAME+"/wzlx/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	@RequestMapping(value="/wzlx/detail")
	public String goWzlxDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_WU_ZI_LEI_XING,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			WuZiLeiXing wzlx=wuZiLeiXingService.selectById(id);
			request.setAttribute("wzlx", wzlx);
			url=MODULE_NAME+"/wzlx/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/wzcx/new")
	public String goWzcxNew(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.TIAN_JIA_WU_ZI,request)) {
			Constant.setYhQxInRequest(request);
			url=MODULE_NAME+"/wzcx/new";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	@RequestMapping(value="/wzcx/edit")
	public String goWzcxEdit(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.XIU_GAI_WU_ZI,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			WuZi wz=wuZiService.selectById(id);
			request.setAttribute("wz", wz);
			url=MODULE_NAME+"/wzcx/edit";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/wzcx/list")
	public String goWzcxList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_WU_ZI,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDcfwInRequest(request);
			url=MODULE_NAME+"/wzcx/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	@RequestMapping(value="/wzcx/detail")
	public String goWzcxDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_WU_ZI,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			WuZi wz=wuZiService.selectById(id);
			request.setAttribute("wz", wz);
			url=MODULE_NAME+"/wzcx/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/queryWZLXList")
	@ResponseBody
	public Map<String, Object> queryWZLXList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = wuZiLeiXingService.queryForInt(mc);
			List<WuZiLeiXing> wzlxList=wuZiLeiXingService.queryList(mc, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", wzlxList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newWuZiLeiXing")
	@ResponseBody
	public Map<String, Object> newWuZiLeiXing(WuZiLeiXing wzlx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiLeiXingService.add(wzlx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建物资类型成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建物资类型失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteWuZiLeiXing",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteWuZiLeiXing(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=wuZiLeiXingService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除物资类型失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除物资类型成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/editWuZiLeiXing")
	@ResponseBody
	public Map<String, Object> editWuZiLeiXing(WuZiLeiXing wzlx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiLeiXingService.edit(wzlx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑物资类型成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑物资类型失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/newWuZi")
	@ResponseBody
	public Map<String, Object> newWuZi(WuZi wz) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiService.add(wz);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建物资成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建物资失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/checkIfExistWuZiByLxIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkIfExistWuZiByLxIds(String lxIds,String lxMcs) {
		//TODO 针对分类的动态进行实时调整更新
		List<WuZiLeiXing> wzlxList=wuZiService.checkIfExistByLxIds(lxIds,lxMcs);
		PlanResult plan=new PlanResult();
		String json;
		if(wzlxList.size()>0) {
			plan.setStatus(1);
			StringBuilder msgSB=new StringBuilder();
			for (int i = 0; i < wzlxList.size(); i++) {
				WuZiLeiXing wzlx = wzlxList.get(i);
				msgSB.append(",");
				msgSB.append(wzlx.getMc());
			}
			msgSB.append("类型下有物资，请先删除物资");
			String msgStr = msgSB.toString();
			plan.setMsg(msgStr.substring(1, msgStr.length()));
			plan.setData(wzlxList);
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(0);
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteWuZi",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteWuZi(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=wuZiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除物资失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除物资成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editWuZi")
	@ResponseBody
	public Map<String, Object> editWuZi(WuZi wz) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiService.edit(wz);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑物资成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑物资失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryWuZiList")
	@ResponseBody
	public Map<String, Object> queryWuZiList(String mc,String wzlxmc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = wuZiService.queryForInt(mc,wzlxmc);
		List<WuZi> wzList=wuZiService.queryList(mc, wzlxmc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", wzList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryWuZiLeiXingCBBList")
	@ResponseBody
	public Map<String, Object> queryWuZiLeiXingCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<WuZiLeiXing> wzlxList=wuZiLeiXingService.queryCBBList();
		
		jsonMap.put("rows", wzlxList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryWuZiCBBList")
	@ResponseBody
	public Map<String, Object> queryWuZiCBBList(String wzlxId) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<WuZi> wzList=wuZiService.queryCBBList(wzlxId);
		
		jsonMap.put("rows", wzList);
		
		return jsonMap;
	}
}
