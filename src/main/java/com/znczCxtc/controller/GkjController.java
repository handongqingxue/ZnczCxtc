package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Controller
@RequestMapping("/gkj")
public class GkjController {

	@Autowired
	private DingDanService dingDanService;

	@RequestMapping(value="/getDingDanBySfzhZt")
	@ResponseBody
	public Map<String, Object> getDingDanBySfzhZt(String sfzh,String ddztMc) {
		
		System.out.println("sfzh==="+sfzh);
		System.out.println("ddztMc==="+ddztMc);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		DingDan dd = dingDanService.getDingDanBySfzhZt(sfzh, ddztMc);
		
		if(dd==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "没找到相关订单");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("dingDan", dd);
		}
		
		return jsonMap;
	}
}
