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
@RequestMapping("/"+PDGLController.MODULE_NAME)
public class PDGLController {

	@Autowired
    private DuiLieService duiLieService;
	@Autowired
    private HaoMaService haoMaService;
	@Autowired
    private HaoMaZhuangTaiService haoMaZhuangTaiService;
	static final String MODULE_NAME=Constant.PDGL_MODULE_NAME;
	
	@RequestMapping(value="/hmzt/new")
	public String goHmztNew(HttpServletRequest request) {
		
		return MODULE_NAME+"/hmzt/new";
	}
	
	@RequestMapping(value="/hmzt/edit")
	public String goHmztEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		HaoMaZhuangTai hmzt=haoMaZhuangTaiService.selectById(id);
		request.setAttribute("hmzt", hmzt);
		
		return MODULE_NAME+"/hmzt/edit";
	}

	/**
	 * 跳转到排队管理-号码状态-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/hmzt/list")
	public String goHmztList(HttpServletRequest request) {
		
		return MODULE_NAME+"/hmzt/list";
	}
	
	@RequestMapping(value="/hmzt/detail")
	public String goHmztDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		HaoMaZhuangTai hmzt=haoMaZhuangTaiService.selectById(id);
		request.setAttribute("hmzt", hmzt);
		
		return MODULE_NAME+"/hmzt/detail";
	}

	/**
	 * 跳转到排队管理-号码查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/hmcx/list")
	public String goHmcxList(HttpServletRequest request) {

		Constant.setYhQxInRequest(request);
		Constant.setHmFlInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/hmcx/list";
	}

	@RequestMapping(value="/dlcx/new")
	public String goDlcxNew(HttpServletRequest request) {

		Constant.setYhQxInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/dlcx/new";
	}

	@RequestMapping(value="/dlcx/edit")
	public String goDlcxEdit(HttpServletRequest request) {

		Constant.setYhQxInRequest(request);
		String id = request.getParameter("id");
		DuiLie dl=duiLieService.selectById(id);
		request.setAttribute("dl", dl);
		
		return MODULE_NAME+"/dlcx/edit";
	}

	/**
	 * 跳转到排队管理-队列查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dlcx/list")
	public String goDlcxList(HttpServletRequest request) {

		Constant.setYhQxInRequest(request);
		Constant.setDLJhxsInRequest(request);
		Constant.setDLZtInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/dlcx/list";
	}

	@RequestMapping(value="/dlcx/detail")
	public String goDlcxDetail(HttpServletRequest request) {

		Constant.setYhQxInRequest(request);
		String id = request.getParameter("id");
		DuiLie dl=duiLieService.selectById(id);
		request.setAttribute("dl", dl);
		
		return MODULE_NAME+"/dlcx/detail";
	}
	
	@RequestMapping(value="/newHaoMaZhuangTai")
	@ResponseBody
	public Map<String, Object> newHaoMaZhuangTai(HaoMaZhuangTai hmzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=haoMaZhuangTaiService.add(hmzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建号码状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建号码状态失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editHaoMaZhuangTai")
	@ResponseBody
	public Map<String, Object> editHaoMaZhuangTai(HaoMaZhuangTai hmzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=haoMaZhuangTaiService.edit(hmzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑号码状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑号码状态失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryHMZTList")
	@ResponseBody
	public Map<String, Object> queryHMZTList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = haoMaZhuangTaiService.queryForInt(mc);
			List<HaoMaZhuangTai> hmztList=haoMaZhuangTaiService.queryList(mc, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", hmztList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/queryHaoMaList")
	@ResponseBody
	public Map<String, Object> queryHaoMaList(String dlMc,String hm,String pdh,Integer hmztId,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = haoMaService.queryForInt(dlMc, hm, pdh, hmztId);
		List<HaoMa> hmList=haoMaService.queryList(dlMc, hm, pdh, hmztId, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", hmList);
		
		return jsonMap;
	}

	@RequestMapping(value="/newDuiLie")
	@ResponseBody
	public Map<String, Object> newDuiLie(DuiLie dl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=duiLieService.add(dl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建队列成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建队列失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteDuiLie",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteDuiLie(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=duiLieService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除队列失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除队列成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editDuiLie")
	@ResponseBody
	public Map<String, Object> editDuiLie(DuiLie dl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=duiLieService.edit(dl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑队列成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑队列失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryDuiLieList")
	@ResponseBody
	public Map<String, Object> queryDuiLieList(String mc,String dm,Integer zt,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = duiLieService.queryForInt(mc,dm,zt);
		List<DuiLie> dlList=duiLieService.queryList(mc, dm, zt, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", dlList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryDuiLieCBBList")
	@ResponseBody
	public Map<String, Object> queryDuiLieCBBList(Integer zt) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<DuiLie> dlList=duiLieService.queryCBBList(zt);
		
		jsonMap.put("rows", dlList);
		
		return jsonMap;
	}

	/**
	 * 查询号码状态下拉框信息
	 * @return
	 */
	@RequestMapping(value="/queryHaoMaZhuangTaiCBBList")
	@ResponseBody
	public Map<String, Object> queryHaoMaZhuangTaiCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<HaoMaZhuangTai> hmztList=haoMaZhuangTaiService.queryHaoMaZhuangTaiCBBList();
		
		jsonMap.put("rows", hmztList);
		
		return jsonMap;
	}
}
