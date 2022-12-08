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
	private YongHuShenHeJiLuService yongHuShenHeJiLuService;
	@Autowired
	private JueSeService jueSeService;
	@Autowired
	private QuanXianService quanXianService;
	static final String MODULE_NAME=Constant.XTGL_MODULE_NAME;
	
	/**
	 * 跳转到系统管理-用户信息页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yhxx")
	public String goYhxx(HttpServletRequest request) {
		
		YongHu yh=(YongHu)SecurityUtils.getSubject().getPrincipal();
		request.setAttribute("yh", yh);
		
		return MODULE_NAME+"/yhxx";
	}

	/**
	 * 跳转到系统管理-用户查询-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yhcx/edit")
	public String goYhcxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YongHu yh=yongHuService.selectById(id);
		request.setAttribute("yh", yh);
		
		Constant.setYhShztInRequest(request);
		
		return MODULE_NAME+"/yhcx/edit";
	}
	
	/**
	 * 跳转到系统管理-用户查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yhcx/list")
	public String goYhcxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setYhShztInRequest(request);
		Constant.setDcfwInRequest(request);
		request.setAttribute("sheetFlag", YongHu.ZONG_HE_CHA_XUN_SHEET);
		
		return MODULE_NAME+"/yhcx/list";
	}

	/**
	 * 跳转到系统管理-用户查询-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yhcx/detail")
	public String goYhcxDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YongHu yh=yongHuService.selectById(id);
		request.setAttribute("yh", yh);
		
		Constant.setYhShztInRequest(request);
		
		return MODULE_NAME+"/yhcx/detail";
	}
	
	/**
	 * 跳转到系统管理-待审核用户-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dshyh/list")
	public String goDshyhcxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		request.setAttribute("shzt", YongHu.DAI_SHEN_HE);
		Constant.setYhShztInRequest(request);
		Constant.setDcfwInRequest(request);
		request.setAttribute("sheetFlag", YongHu.DAI_SHEN_HE_SHEET);
		
		return MODULE_NAME+"/dshyh/list";
	}

	/**
	 * 跳转到系统管理-用户审核记录-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yhshjl/list")
	public String goYhshjlList(HttpServletRequest request) {

		Constant.setYhShjgInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/yhshjl/list";
	}
	
	/**
	 * 跳转到角色查询-添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/jscx/new")
	public String goJscxNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/new";
	}

	/**
	 * 跳转到角色查询-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/jscx/edit")
	public String goJscxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		JueSe js=jueSeService.selectById(id);
		request.setAttribute("js", js);
		
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/edit";
	}
	
	/**
	 * 跳转到角色查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/jscx/list")
	public String goJscxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/list";
	}

	/**
	 * 跳转到角色查询-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/jscx/detail")
	public String goJscxDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		JueSe js=jueSeService.selectById(id);
		request.setAttribute("js", js);
		
		Constant.setJsZtInRequest(request);
		
		return MODULE_NAME+"/jscx/detail";
	}
	
	/**
	 * 跳转到权限查询-添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/qxcx/new")
	public String goQxcxNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/qxcx/new";
	}

	/**
	 * 跳转到权限查询-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/qxcx/edit")
	public String goQxcxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		QuanXian qx=quanXianService.selectById(id);
		request.setAttribute("qx", qx);
		
		return MODULE_NAME+"/qxcx/edit";
	}
	
	/**
	 * 跳转到权限查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/qxcx/list")
	public String goQxcxList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/qxcx/list";
	}
	
	/**
	 * 根据用户名验证原密码
	 * @param mm
	 * @param yhm
	 * @return
	 */
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
	
	/**
	 * 编辑用户
	 * @param yh
	 * @return
	 */
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
	
	/**
	 * 查询用户
	 * @param yhm
	 * @param shzt
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */
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
	
	/**
	 * 添加角色
	 * @param js
	 * @return
	 */
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
	
	/**
	 * 编辑角色
	 * @param js
	 * @return
	 */
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
	
	/**
	 * 查询角色
	 * @param mc
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */
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
	
	/**
	 * 查询权限
	 * @param mc
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */
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
	
	/**
	 * 添加权限
	 * @param qx
	 * @return
	 */
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
	
	/**
	 * 编辑权限
	 * @param qx
	 * @return
	 */
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
	
	/**
	 * 根据用户id修改密码
	 * @param mm
	 * @return
	 */
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
	
	/**
	 * 查询下拉框角色
	 * @return
	 */
	@RequestMapping(value="/queryJueSeCBBList")
	@ResponseBody
	public Map<String, Object> queryJueSeCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<JueSe> jsList=jueSeService.queryCBBList();
		
		jsonMap.put("rows", jsList);
		
		return jsonMap;
	}
	
	/**
	 * 查询下拉框权限
	 * @return
	 */
	@RequestMapping(value="/queryQuanXianCBBList")
	@ResponseBody
	public Map<String, Object> queryQuanXianCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<QuanXian> qxList=quanXianService.queryCBBList();
		
		jsonMap.put("rows", qxList);
		
		return jsonMap;
	}

	/**
	 * 删除用户审核记录
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteYongHuShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteYongHuShenHeJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=yongHuShenHeJiLuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除用户审核记录失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除用户审核记录成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	/**
	 * 用户审核记录查询
	 * @param yhm
	 * @param shrYhm
	 * @param shsjks
	 * @param shsjjs
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/queryYHSHJLList")
	@ResponseBody
	public Map<String, Object> queryYHSHJLList(String yhm,String shrYhm,String shsjks,String shsjjs,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = yongHuShenHeJiLuService.queryForInt(yhm,shrYhm,shsjks,shsjjs);
			List<YongHuShenHeJiLu> yhshjlList=yongHuShenHeJiLuService.queryList(yhm, shrYhm, shsjks, shsjjs, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", yhshjlList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	/**
	 * 审核用户
	 * @param ids
	 * @param yhshjl
	 * @return
	 */
	@RequestMapping(value="/checkYongHuByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkYongHuByIds(String ids, YongHuShenHeJiLu yhshjl) {
		//TODO 针对分类的动态进行实时调整更新
		int count=yongHuService.checkByIds(ids,yhshjl);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		Boolean shjg = yhshjl.getShjg();
		if(shjg)
			tsStr="审核";
		else
			tsStr="退回";
		
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg(tsStr+"用户信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg(tsStr+"用户信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
}
