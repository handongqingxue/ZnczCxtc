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
	@Autowired
    private CheLiangTaiZhangService cheLiangTaiZhangService;
	@Autowired
	private CheLiangShenHeJiLuService cheLiangShenHeJiLuService;
	static final String MODULE_NAME=Constant.CLGL_MODULE_NAME;

	/**
	 * 跳转到车辆管理-待审核-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dsh/list")
	public String goDshList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.SHEN_HE_CHE_LIANG,request)) {
			request.setAttribute("shzt", CheLiang.DAI_SHEN_HE);
			Constant.setYhQxInRequest(request);
			Constant.setClPfjdInRequest(request);
			Constant.setClSfzyInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", CheLiang.DAI_SHEN_HE_SHEET);
			url=MODULE_NAME+"/dsh/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-待审核-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dsh/detail")
	public String goDshDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.SHEN_HE_CHE_LIANG,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			CheLiang cl=cheLiangService.selectById(id);
			request.setAttribute("cl", cl);
			
			Constant.setClPfjdInRequest(request);
			Constant.setClYslxInRequest(request);
			url=MODULE_NAME+"/dsh/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-综合查询-添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/new")
	public String goZhcxNew(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.TIAN_JIA_CHE_LIANG,request)) {
			Constant.setYhQxInRequest(request);
			url=MODULE_NAME+"/zhcx/new";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-综合查询-编辑页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/edit")
	public String goZhcxEdit(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.XIU_GAI_CHE_LIANG,request)) {
			//publicService.selectNav(request);
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			CheLiang cl=cheLiangService.selectById(id);
			request.setAttribute("cl", cl);
			
			request.setAttribute("dshShzt", CheLiang.DAI_SHEN_HE);
			request.setAttribute("bjzShzt", CheLiang.BIAN_JI_ZHONG);
			url=MODULE_NAME+"/zhcx/edit";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-综合查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setClPfjdInRequest(request);
			Constant.setClSfzyInRequest(request);
			Constant.setClShztInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", CheLiang.ZONG_HE_CHA_XUN_SHEET);
			url=MODULE_NAME+"/zhcx/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-综合查询-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/detail")
	public String goZhcxDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG,request)) {
			//publicService.selectNav(request);
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			CheLiang cl=cheLiangService.selectById(id);
			request.setAttribute("cl", cl);
			
			Constant.setClPfjdInRequest(request);
			Constant.setClYslxInRequest(request);
			Constant.setClShztInRequest(request);
			url=MODULE_NAME+"/zhcx/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-审核记录-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shjl/list")
	public String goShjlList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG_SHEN_HE_JI_LU,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setClShjgInRequest(request);
			Constant.setDcfwInRequest(request);
			url=MODULE_NAME+"/shjl/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-台账查询-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/tzcx/list")
	public String goTzcxList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG_TAI_ZHANG,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", CheLiangTaiZhang.ZONG_HE_CHA_XUN_SHEET);
			url=MODULE_NAME+"/tzcx/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-台账查询-详情页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/tzcx/detail")
	public String goTzcxDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG_TAI_ZHANG,request)) {
			//publicService.selectNav(request);
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			CheLiangTaiZhang cltz=cheLiangTaiZhangService.selectById(id);
			request.setAttribute("cltz", cltz);
			url=MODULE_NAME+"/tzcx/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * 跳转到车辆管理-厂内台账-列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cntz/list")
	public String goCntzList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG_TAI_ZHANG,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDdztInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", CheLiangTaiZhang.CHANG_NEI_SHEET);
			url=MODULE_NAME+"/cntz/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	@RequestMapping(value="/cntz/detail")
	public String goCntzDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_CHE_LIANG_TAI_ZHANG,request)) {
			//publicService.selectNav(request);
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			CheLiangTaiZhang cltz=cheLiangTaiZhangService.selectById(id);
			request.setAttribute("cltz", cltz);
			url=MODULE_NAME+"/cntz/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	
	@RequestMapping(value="/newCheLiang")
	@ResponseBody
	public Map<String, Object> newCheLiang(CheLiang cl,
			@RequestParam(value="zp_file",required=false) MultipartFile zp_file,
			@RequestParam(value="xsz_file",required=false) MultipartFile xsz_file,
			@RequestParam(value="scqd_file",required=false) MultipartFile scqd_file,
			@RequestParam(value="pfjdcxjt_file",required=false) MultipartFile pfjdcxjt_file) {
		
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
						jsonStr = FileUploadUtil.appUploadContentImg(fileArr[i],folder);
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

	@RequestMapping(value="/deleteCheLiang",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteCheLiang(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=cheLiangService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除车辆信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除车辆信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editCheLiang")
	@ResponseBody
	public Map<String, Object> editCheLiang(CheLiang cl,
			@RequestParam(value="zp_file",required=false) MultipartFile zp_file,
			@RequestParam(value="xsz_file",required=false) MultipartFile xsz_file,
			@RequestParam(value="scqd_file",required=false) MultipartFile scqd_file,
			@RequestParam(value="pfjdcxjt_file",required=false) MultipartFile pfjdcxjt_file) {
		
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
						jsonStr = FileUploadUtil.appUploadContentImg(fileArr[i],folder);
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
			
			int count=cheLiangService.edit(cl);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "编辑车辆信息成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑车辆信息失败！");
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

	/**
	 * 验证车牌号是否存在
	 * @param cph
	 * @return
	 */
	@RequestMapping(value="/checkCphIfExist",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkCphIfExist(String cph) {
		boolean exist=cheLiangService.checkCphIfExist(cph);
		PlanResult plan=new PlanResult();
		String json;
		if(exist) {
			plan.setStatus(0);
			plan.setMsg("车牌号已存在");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteShenHeJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=cheLiangShenHeJiLuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除审核记录失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除审核记录成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/querySHJLList")
	@ResponseBody
	public Map<String, Object> querySHJLList(String clCph,String shrYhm,String shsjks,String shsjjs,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = cheLiangShenHeJiLuService.queryForInt(clCph,shrYhm,shsjks,shsjjs);
			List<CheLiangShenHeJiLu> clshjlList=cheLiangShenHeJiLuService.queryList(clCph, shrYhm, shsjks, shsjjs, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", clshjlList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/checkCheLiangByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkCheLiangByIds(String ids, CheLiangShenHeJiLu clshjl) {
		//TODO 针对分类的动态进行实时调整更新
		int count=cheLiangService.checkByIds(ids,clshjl);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		Boolean shjg = clshjl.getShjg();
		if(shjg)
			tsStr="审核";
		else
			tsStr="退回";
		
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg(tsStr+"车辆信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg(tsStr+"车辆信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteCLTZ",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteCLTZ(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=cheLiangTaiZhangService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除车辆台账失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除车辆台账成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/queryCLTZList")
	@ResponseBody
	public Map<String, Object> queryCLTZList(String ddh,String cyclCph,String ddztIds,String ddztMcs,String jcsjs,String jcsje,String ccsjs,String ccsje,
			int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cheLiangTaiZhangService.queryForInt(ddh,cyclCph,ddztIds,ddztMcs,jcsjs,jcsje,ccsjs,ccsje);
		List<CheLiangTaiZhang> cltzList=cheLiangTaiZhangService.queryList(ddh, cyclCph, ddztIds, ddztMcs, jcsjs, jcsje, ccsjs, ccsje, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", cltzList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryCheLiangCBBList")
	@ResponseBody
	public Map<String, Object> queryCheLiangCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<CheLiang> clList=cheLiangService.queryCBBList();
		
		jsonMap.put("rows", clList);
		
		return jsonMap;
	}
}
