package com.znczCxtc.controller;

import java.util.HashMap;
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
	static final String MODULE_NAME=Constant.XTGL_MODULE_NAME;
	
	@RequestMapping(value="/yhxx")
	public String goYhxx(HttpServletRequest request) {
		
		YongHu yongHu=(YongHu)SecurityUtils.getSubject().getPrincipal();
		request.setAttribute("yongHu", yongHu);
		
		return MODULE_NAME+"/yhxx";
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
			jsonMap.put("message", "‘≠√‹¬Î¥ÌŒÛ£°");
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
}
