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
import com.znczCxtc.util.JsonUtil;
import com.znczCxtc.util.PlanResult;
import com.znczLfylJhb.entity.YunShuShang;

@Controller
@RequestMapping("/"+DWGLController.MODULE_NAME)
public class DWGLController {

	@Autowired
	private YunShuShangService yunShuShangService;
	@Autowired
	private FaHuoDanWeiService faHuoDanWeiService;
	@Autowired
    private ShouHuoDanWeiService shouHuoDanWeiService;
	public static final String MODULE_NAME="dwgl";

	@RequestMapping(value="/yss/new")
	public String goYssNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/yss/new";
	}

	@RequestMapping(value="/yss/edit")
	public String goYssEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YunShuShang yss=yunShuShangService.selectById(id);
		request.setAttribute("yss", yss);
		
		return MODULE_NAME+"/yss/edit";
	}
	
	/**
	 * 跳转到单位管理-运输商-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yss/list")
	public String goYssList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/yss/list";
	}

	@RequestMapping(value="/yss/detail")
	public String goYssDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YunShuShang yss=yunShuShangService.selectById(id);
		request.setAttribute("yss", yss);
		
		return MODULE_NAME+"/yss/detail";
	}

	/**
	 * 跳转到单位管理-发货单位-添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/new")
	public String goFhdwNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/fhdw/new";
	}

	/**
	 * 跳转到单位管理-发货单位-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/edit")
	public String goFhdwEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		FaHuoDanWei fhdw=faHuoDanWeiService.selectById(id);
		request.setAttribute("fhdw", fhdw);
		
		return MODULE_NAME+"/fhdw/edit";
	}
	
	/**
	 * 跳转到单位管理-发货单位-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/list")
	public String goFhdwList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/fhdw/list";
	}

	/**
	 * 跳转到单位管理-发货单位-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/detail")
	public String goFhdwDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		FaHuoDanWei fhdw=faHuoDanWeiService.selectById(id);
		request.setAttribute("fhdw", fhdw);
		
		return MODULE_NAME+"/fhdw/detail";
	}

	/**
	 * 跳转到单位管理-收货部门-添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/new")
	public String goShdwNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/shdw/new";
	}

	/**
	 * 跳转到单位管理-发货单位-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/edit")
	public String goShdwEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		ShouHuoDanWei shdw=shouHuoDanWeiService.selectById(id);
		request.setAttribute("shdw", shdw);
		
		return MODULE_NAME+"/shdw/edit";
	}
	
	/**
	 * 跳转到单位管理-收货单位-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/list")
	public String goShdwList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/shdw/list";
	}

	/**
	 * 跳转到单位管理-收货单位-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/detail")
	public String goShdwDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		ShouHuoDanWei shdw=shouHuoDanWeiService.selectById(id);
		request.setAttribute("shdw", shdw);
		
		return MODULE_NAME+"/shdw/detail";
	}

	@RequestMapping(value="/newYunShuShang")
	@ResponseBody
	public Map<String, Object> newYunShuShang(YunShuShang yss) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yunShuShangService.add(yss);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建运输商成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建运输商失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteYunShuShang",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteYunShuShang(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=yunShuShangService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除运输商失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除运输商成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editYunShuShang")
	@ResponseBody
	public Map<String, Object> editYunShuShang(YunShuShang yss) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yunShuShangService.edit(yss);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑运输商成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑运输商失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryYunShuShangList")
	@ResponseBody
	public Map<String, Object> queryYunShuShangList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = yunShuShangService.queryForInt(mc);
		List<YunShuShang> yssList=yunShuShangService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", yssList);
		
		return jsonMap;
	}

	@RequestMapping(value="/newFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> newFaHuoDanWei(FaHuoDanWei fhdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=faHuoDanWeiService.add(fhdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建发货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建发货单位失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteFaHuoDanWei",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteFaHuoDanWei(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=faHuoDanWeiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除发货单位失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除发货单位成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> editFaHuoDanWei(FaHuoDanWei fhdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=faHuoDanWeiService.edit(fhdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑发货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑发货单位失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryFaHuoDanWeiList")
	@ResponseBody
	public Map<String, Object> queryFaHuoDanWeiList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = faHuoDanWeiService.queryForInt(mc);
		List<FaHuoDanWei> fhdwList=faHuoDanWeiService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", fhdwList);
		
		return jsonMap;
	}

	@RequestMapping(value="/newShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> newShouHuoDanWei(ShouHuoDanWei shdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=shouHuoDanWeiService.add(shdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建收货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建收货单位失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteShouHuoDanWei",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteShouHuoDanWei(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=shouHuoDanWeiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除收货单位失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除收货单位成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> editShouHuoDanWei(ShouHuoDanWei shdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=shouHuoDanWeiService.edit(shdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑收货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑收货单位失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryShouHuoDanWeiList")
	@ResponseBody
	public Map<String, Object> queryShouHuoDanWeiList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = shouHuoDanWeiService.queryForInt(mc);
		List<ShouHuoDanWei> shdwList=shouHuoDanWeiService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", shdwList);
		
		return jsonMap;
	}
}
