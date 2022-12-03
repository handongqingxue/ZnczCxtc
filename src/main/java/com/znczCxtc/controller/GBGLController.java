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

import com.znczCxtc.util.*;

import net.sf.json.JSONObject;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

@Controller
@RequestMapping("/"+GBGLController.MODULE_NAME)
public class GBGLController {

	@Autowired
	private GuoBangJiLuService guoBangJiLuService;
	@Autowired
	private BangDanJiLuService bangDanJiLuService;
	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private DaYinJiLuService daYinJiLuService;
	public static final String MODULE_NAME=Constant.GBGL_MODULE_NAME;
	
	@RequestMapping(value="/bdjl/new")
	public String goBdjlNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/bdjl/new";
	}

	/**
	 * 跳转到过磅管理-磅单记录-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bdjl/edit")
	public String goBdjlEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		BangDanJiLu bdjl=bangDanJiLuService.selectById(id);
		request.setAttribute("bdjl", bdjl);
		
		DingDan dd=dingDanService.selectById(bdjl.getDdId().toString());
		request.setAttribute("dd", dd);
		
		return MODULE_NAME+"/bdjl/edit";
	}
	
	/**
	 * 跳转到过磅管理-磅单记录-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bdjl/list")
	public String goBdjlList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setDdztInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/bdjl/list";
	}

	/**
	 * 跳转到过磅管理-磅单记录-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/bdjl/detail")
	public String goBdjlDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		BangDanJiLu bdjl=bangDanJiLuService.selectById(id);
		request.setAttribute("bdjl", bdjl);
		
		DingDan dd=dingDanService.selectById(bdjl.getDdId().toString());
		request.setAttribute("dd", dd);
		
		return MODULE_NAME+"/bdjl/detail";
	}

	@RequestMapping(value="/bdjl/print")
	public String goBdjlPreview(HttpServletRequest request) {

		String time = request.getParameter("time");
		DaYinJiLu dyjl=daYinJiLuService.selectByTime(time);
		request.setAttribute("dyjl", dyjl);
		
		return MODULE_NAME+"/bdjl/print";
	}

	@RequestMapping(value="/newDaYinJiLu")
	@ResponseBody
	public Map<String, Object> newDaYinJiLu(DaYinJiLu dyjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=daYinJiLuService.add(dyjl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建打印记录成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建打印记录失败！");
		}
			
		return jsonMap;
	}
	
	@RequestMapping(value="/gbjl/new")
	public String goGbjlNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/gbjl/new";
	}

	/**
	 * 跳转到过磅管理-过磅记录-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/gbjl/edit")
	public String goGbjlEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		GuoBangJiLu gbjl=guoBangJiLuService.selectById(id);
		request.setAttribute("gbjl", gbjl);
		
		return MODULE_NAME+"/gbjl/edit";
	}
	
	/**
	 * 跳转到过磅管理-过磅记录-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/gbjl/list")
	public String goGbjlList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setGblxInRequest(request);
		Constant.setGbjlGbztInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/gbjl/list";
	}

	/**
	 * 跳转到过磅管理-过磅记录-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/gbjl/detail")
	public String goGbjlDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		GuoBangJiLu gbjl=guoBangJiLuService.selectById(id);
		request.setAttribute("gbjl", gbjl);
		
		return MODULE_NAME+"/gbjl/detail";
	}
	
	/**
	 * 跳转到过磅管理-一检待审核-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yjdsh/list")
	public String goYjdshList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		Constant.setDdztInRequest(request);
		Constant.setLxlxInRequest(request);
		Constant.setShlxInRequest(request);
		Constant.setGblxInRequest(request);
		Constant.setGbjlGbztInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/yjdsh/list";
	}
	
	/**
	 * 跳转到过磅管理-二检待审核-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ejdsh/list")
	public String goEjdshList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		Constant.setDdztInRequest(request);
		Constant.setLxlxInRequest(request);
		Constant.setShlxInRequest(request);
		Constant.setGblxInRequest(request);
		Constant.setGbjlGbztInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/ejdsh/list";
	}

	@RequestMapping(value="/newBangDanJiLu")
	@ResponseBody
	public Map<String, Object> newBangDanJiLu(BangDanJiLu bdjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=bangDanJiLuService.add(bdjl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建磅单信息成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建磅单信息失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/editBangDanJiLu")
	@ResponseBody
	public Map<String, Object> editBangDanJiLu(BangDanJiLu bdjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=bangDanJiLuService.edit(bdjl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑磅单信息成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑磅单信息失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryBDJLList")
	@ResponseBody
	public Map<String, Object> queryBDJLList(String ddh,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = bangDanJiLuService.queryForInt(ddh);
		List<BangDanJiLu> bdjlList=bangDanJiLuService.queryList(ddh, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", bdjlList);
		
		return jsonMap;
	}

	@RequestMapping(value="/newGuoBangJiLu")
	@ResponseBody
	public Map<String, Object> newGuoBangJiLu(GuoBangJiLu gbjl,
			@RequestParam(value="zp1_file",required=false) MultipartFile zp1_file,
			@RequestParam(value="zp2_file",required=false) MultipartFile zp2_file,
			@RequestParam(value="zp3_file",required=false) MultipartFile zp3_file,
			HttpServletRequest request) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			MultipartFile[] fileArr=new MultipartFile[3];
			fileArr[0]=zp1_file;
			fileArr[1]=zp2_file;
			fileArr[2]=zp3_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="GuoBangJiLu/";
						switch (i) {
						case 0:
							folder+="Zp1";//照片1
							break;
						case 1:
							folder+="Zp2";//照片2
							break;
						case 2:
							folder+="Zp3";//照片3
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("成功".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								gbjl.setZp1(dataJO.get("src").toString());
								break;
							case 1:
								gbjl.setZp2(dataJO.get("src").toString());
								break;
							case 2:
								gbjl.setZp3(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
		
			int count=guoBangJiLuService.add(gbjl);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "创建过磅信息成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "创建过磅信息失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/editGuoBangJiLu")
	@ResponseBody
	public Map<String, Object> editGuoBangJiLu(GuoBangJiLu gbjl,
			@RequestParam(value="zp1_file",required=false) MultipartFile zp1_file,
			@RequestParam(value="zp2_file",required=false) MultipartFile zp2_file,
			@RequestParam(value="zp3_file",required=false) MultipartFile zp3_file,
			HttpServletRequest request) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			MultipartFile[] fileArr=new MultipartFile[3];
			fileArr[0]=zp1_file;
			fileArr[1]=zp2_file;
			fileArr[2]=zp3_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="GuoBangJiLu/";
						switch (i) {
						case 0:
							folder+="Zp1";//照片1
							break;
						case 1:
							folder+="Zp2";//照片2
							break;
						case 2:
							folder+="Zp3";//照片3
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("成功".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								gbjl.setZp1(dataJO.get("src").toString());
								break;
							case 1:
								gbjl.setZp2(dataJO.get("src").toString());
								break;
							case 2:
								gbjl.setZp3(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
		
			int count=guoBangJiLuService.edit(gbjl);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "编辑过磅信息成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑过磅信息失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryGBJLList")
	@ResponseBody
	public Map<String, Object> queryGBJLList(String ddh,String cyclCph,String gbsjks,String gbsjjs,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = guoBangJiLuService.queryForInt(ddh,cyclCph,gbsjks,gbsjjs);
		List<GuoBangJiLu> gbjlList=guoBangJiLuService.queryList(ddh, cyclCph, gbsjks, gbsjjs, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", gbjlList);
		
		return jsonMap;
	}

	@RequestMapping(value="/queryDJYList")
	@ResponseBody
	public Map<String, Object> queryDJYList(String ddh,String ddztMc,String cysjXm,String cysjSfzh,String cyclCph,String yssMc,String fhdwMc,
			String shdwMc,String gbsjks,String gbsjjs,Integer gblx,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = guoBangJiLuService.queryDJYForInt(ddh,ddztMc,cysjXm,cysjSfzh,cyclCph,yssMc,fhdwMc,shdwMc,gbsjks,gbsjjs,gblx);
		List<GuoBangJiLu> jyjlList=guoBangJiLuService.queryDJYList(ddh, ddztMc, cysjXm, cysjSfzh, cyclCph, yssMc, fhdwMc, shdwMc, gbsjks, gbsjjs, gblx, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", jyjlList);
		
		return jsonMap;
	}
}
