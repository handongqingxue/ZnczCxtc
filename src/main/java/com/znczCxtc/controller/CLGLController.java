package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.znczCxtc.service.*;

import net.sf.json.JSONObject;

import com.znczCxtc.util.*;
import com.znczCxtc.entity.*;

@Controller
@RequestMapping("/"+CLGLController.MODULE_NAME)
public class CLGLController {

	@Autowired
	private CheLiangService cheLiangService;
	public static final String MODULE_NAME="clgl";

	@RequestMapping(value="/zhcx/new")
	public String goZhcxNew(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/new";
	}

	/**
	 * 跳转到车辆管理-综合查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/list";
	}
	
	@RequestMapping(value="/newCheLiang")
	@ResponseBody
	public Map<String, Object> newCheLiang(CheLiang cl,
			@RequestParam(value="zp_file",required=false) MultipartFile zp_file,
			@RequestParam(value="xsz_file",required=false) MultipartFile xsz_file,
			@RequestParam(value="scqd_file",required=false) MultipartFile scqd_file,
			@RequestParam(value="pfjdcxjt_file",required=false) MultipartFile pfjdcxjt_file,
			HttpServletRequest request) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			MultipartFile[] fileArr=new MultipartFile[4];
			fileArr[0]=zp_file;
			fileArr[1]=xsz_file;
			fileArr[2]=scqd_file;
			fileArr[3]=pfjdcxjt_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="CheLiang/";
						switch (i) {
						case 0:
							folder+="Zp";//照片
							break;
						case 1:
							folder+="Xsz";//行驶证
							break;
						case 2:
							folder+="Scqd";//随车清单
							break;
						case 3:
							folder+="Pfjdcxjt";//排放阶段查询截图
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("成功".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								cl.setZp(dataJO.get("src").toString());
								break;
							case 1:
								cl.setXsz(dataJO.get("src").toString());
								break;
							case 2:
								cl.setScqd(dataJO.get("src").toString());
								break;
							case 3:
								cl.setPfjdcxjt(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
			
			int count=cheLiangService.add(cl);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "创建车辆信息成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "创建车辆信息失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryCheLiangList")
	@ResponseBody
	public Map<String, Object> queryCheLiangList(String cph,Integer cllx,Boolean sfzy,Integer pfjd,String shzt,String bz,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cheLiangService.queryForInt(cph,cllx,sfzy,pfjd,shzt,bz);
		List<CheLiang> clList=cheLiangService.queryList(cph, cllx, sfzy, pfjd, shzt, bz, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", clList);
		
		return jsonMap;
	}
}
