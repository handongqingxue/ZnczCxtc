package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

@Controller
@RequestMapping("/"+XTGLController.MODULE_NAME)
public class XTGLController {

	@Autowired
	private YongHuService yongHuService;
	@Autowired
	private JueSeService jueSeService;
	@Autowired
	private QuanXianService quanXianService;
	static final String MODULE_NAME=Constant.XTGL_MODULE_NAME;
	
	@RequestMapping(value="/yhxx")
	public String goYhxx(HttpServletRequest request) {
		
		YongHu yh=(YongHu)SecurityUtils.getSubject().getPrincipal();
		request.setAttribute("yh", yh);
		
		return MODULE_NAME+"/yhxx";
	}

	@RequestMapping(value="/yhcx/edit")
	public String goYhcxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YongHu yh=yongHuService.selectById(id);
		request.setAttribute("yh", yh);
		
		Constant.setYhShztInRequest(request);
		
		return MODULE_NAME+"/yhcx/edit";
	}
	
	@RequestMapping(value="/yhcx/list")
	public String goYhcxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setYhShztInRequest(request);
		
		return MODULE_NAME+"/yhcx/list";
	}

	@RequestMapping(value="/yhcx/detail")
	public String goYhcxDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YongHu yh=yongHuService.selectById(id);
		request.setAttribute("yh", yh);
		
		Constant.setYhShztInRequest(request);
		
		return MODULE_NAME+"/yhcx/detail";
	}
	
	@RequestMapping(value="/jscx/new")
	public String goJscxNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/new";
	}

	@RequestMapping(value="/jscx/edit")
	public String goJscxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		JueSe js=jueSeService.selectById(id);
		request.setAttribute("js", js);
		
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/edit";
	}
	
	@RequestMapping(value="/jscx/list")
	public String goJscxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/list";
	}

	@RequestMapping(value="/jscx/detail")
	public String goJscxDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		JueSe js=jueSeService.selectById(id);
		request.setAttribute("js", js);
		
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/detail";
	}
	
	@RequestMapping(value="/qxcx/new")
	public String goQxcxNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/qxcx/new";
	}

	@RequestMapping(value="/qxcx/edit")
	public String goQxcxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		QuanXian qx=quanXianService.selectById(id);
		request.setAttribute("qx", qx);
		
		return MODULE_NAME+"/qxcx/edit";
	}
	
	@RequestMapping(value="/qxcx/list")
	public String goQxcxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/qxcx/list";
	}
	
	@RequestMapping(value="/checkMm")
	@ResponseBody
	public Map<String, Object> checkMm(String mm, String yhm) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		boolean bool=yongHuService.checkMm(mm,yhm);
		
		if(bool) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
			jsonMap.put("message", "原密码错误！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editYongHu")
	@ResponseBody
	public Map<String, Object> editYongHu(YongHu yh) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yongHuService.edit(yh);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑用户信息成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑用户信息失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryYongHuList")
	@ResponseBody
	public Map<String, Object> queryYongHuList(String yhm,Integer shzt,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = yongHuService.queryForInt(yhm,shzt);
		List<YongHu> yhList=yongHuService.queryList(yhm, shzt, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", yhList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newJueSe")
	@ResponseBody
	public Map<String, Object> newJueSe(JueSe js) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=jueSeService.add(js);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建角色成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建角色失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editJueSe")
	@ResponseBody
	public Map<String, Object> editJueSe(JueSe js) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=jueSeService.edit(js);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑角色成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑角色失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryJueSeList")
	@ResponseBody
	public Map<String, Object> queryJueSeList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = jueSeService.queryForInt(mc);
		List<JueSe> jsList=jueSeService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", jsList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryQuanXianList")
	@ResponseBody
	public Map<String, Object> queryQuanXianList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = quanXianService.queryForInt(mc);
		List<QuanXian> qxList=quanXianService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", qxList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newQuanXian")
	@ResponseBody
	public Map<String, Object> newQuanXian(QuanXian qx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=quanXianService.add(qx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建权限成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建权限失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editQuanXian")
	@ResponseBody
	public Map<String, Object> editQuanXian(QuanXian qx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=quanXianService.edit(qx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑权限成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑权限失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/updateMmByYhId")
	@ResponseBody
	public String updateMmByYhId(String mm) {
		YongHu yongHu=(YongHu)SecurityUtils.getSubject().getPrincipal();
		Integer id = yongHu.getId();
		int count = yongHuService.updateMmById(mm,id);
		
		PlanResult plan=new PlanResult();
		if(count==0) {
			plan.setStatus(0);
		}
		else {
			plan.setStatus(1);
		}
		return JsonUtil.getJsonFromObject(plan);
	}
	
	@RequestMapping(value="/queryJueSeCBBList")
	@ResponseBody
	public Map<String, Object> queryJueSeCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<JueSe> jsList=jueSeService.queryCBBList();
		
		jsonMap.put("rows", jsList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryQuanXianCBBList")
	@ResponseBody
	public Map<String, Object> queryQuanXianCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<QuanXian> qxList=quanXianService.queryCBBList();
		
		jsonMap.put("rows", qxList);
		
		return jsonMap;
	}
}
