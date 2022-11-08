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
@RequestMapping("/gkj")
public class GkjController {

	@Autowired
	private DingDanService dingDanService;
	@Autowired
    private HaoMaService haoMaService;

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
	
	@RequestMapping(value="/editDingDan")
	@ResponseBody
	public Map<String, Object> editDingDan(DingDan dd,
			HttpServletRequest request) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=dingDanService.edit(dd);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "编辑订单成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑订单失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/getJhPdHMList")
	@ResponseBody
	public Map<String, Object> getJhPdList() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<HaoMa> hmList=haoMaService.getJhPdList();
		
		if(hmList==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("hmList", hmList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/editHaoMa")
	@ResponseBody
	public Map<String, Object> editHaoMa(HaoMa hm,
			HttpServletRequest request) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=haoMaService.edit(hm);
			if(count>0) {
				if(HaoMaZhuangTai.YI_GUO_HAO_TEXT.equals(hm.getHmztMc())) {
					DingDan dd=new DingDan();
					dd.setId(hm.getDdId());
					dd.setDdztMc(DingDanZhuangTai.YI_XIA_DAN_TEXT);
					count=dingDanService.edit(dd);
				}
			}
			
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "编辑号码成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑号码失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
}
