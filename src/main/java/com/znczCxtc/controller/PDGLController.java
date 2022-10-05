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

@Controller
@RequestMapping("/"+PDGLController.MODULE_NAME)
public class PDGLController {

	@Autowired
    private DuiLieService duiLieService;
	public static final String MODULE_NAME="pdgl";

	@RequestMapping(value="/dlcx/new")
	public String goDlcxNew(HttpServletRequest request) {
		
		return MODULE_NAME+"/dlcx/new";
	}

	/**
	 * 跳转到排队管理-队列查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dlcx/list")
	public String goDlcxList(HttpServletRequest request) {
		
		return MODULE_NAME+"/dlcx/list";
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
}
