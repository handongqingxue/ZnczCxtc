package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Controller
@RequestMapping("/gkj")
public class GkjController {

	@Autowired
	private DingDanService dingDanService;
	@Autowired
    private HaoMaService haoMaService;
	@Autowired
    private CheLiangTaiZhangService cheLiangTaiZhangService;

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
	public Map<String, Object> editDingDan(DingDan dd) {
		
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
	public Map<String, Object> editHaoMa(HaoMa hm) {
		
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

	@RequestMapping(value="/uploadCheLiangTaiZhang")
	@ResponseBody
	public Map<String, Object> uploadCheLiangTaiZhang(CheLiangTaiZhang cltz, int actionFlag) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		int count=0;
		String actionStr=null;
		switch (actionFlag) {
		case CheLiangTaiZhang.JIN_CHANG:
			count=cheLiangTaiZhangService.uploadJinChang(cltz);
			actionStr="进厂";
			break;
		case CheLiangTaiZhang.CHU_CHANG:
			count=cheLiangTaiZhangService.uploadChuChang(cltz);
			actionStr="出厂";
			break;
		}

		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "上传"+actionStr+"台账成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "上传"+actionStr+"台账失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/testFile")
	@ResponseBody
	public Map<String, Object> testFile(@RequestParam(value = "file", required = false) MultipartFile file) {
		//https://blog.csdn.net/weixin_31976851/article/details/114153507
		//https://blog.csdn.net/weixin_35674742/article/details/114192180
		//https://wenku.baidu.com/view/73de8f265c0e7cd184254b35eefdc8d377ee1450.html?_wkts_=1667965735195&bdQuery=java+HttpURLConnection%E5%A6%82%E4%BD%95%E4%BC%A0%E9%80%92file%E5%AF%B9%E8%B1%A1
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("file==="+file);
		return jsonMap;
	}
}
