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
	private CheLiangShenHeJiLuService cheLiangShenHeJiLuService;
	static final String MODULE_NAME=Constant.CLGL_MODULE_NAME;

	/**
	 * ��ת����������-�����-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dsh/list")
	public String goDshList(HttpServletRequest request) {

		request.setAttribute("shzt", CheLiang.DAI_SHEN_HE);
		
		return MODULE_NAME+"/dsh/list";
	}

	@RequestMapping(value="/dsh/detail")
	public String goDshDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		CheLiang cl=cheLiangService.selectById(id);
		request.setAttribute("cl", cl);
		
		return MODULE_NAME+"/dsh/detail";
	}

	@RequestMapping(value="/zhcx/new")
	public String goZhcxNew(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/new";
	}

	/**
	 * ��ת����������-�ۺϲ�ѯ-�༭ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/edit")
	public String goZhcxEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		CheLiang cl=cheLiangService.selectById(id);
		request.setAttribute("cl", cl);
		
		request.setAttribute("dshShzt", CheLiang.DAI_SHEN_HE);
		request.setAttribute("bjzShzt", CheLiang.BIAN_JI_ZHONG);
		
		return MODULE_NAME+"/zhcx/edit";
	}

	/**
	 * ��ת����������-�ۺϲ�ѯ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/list";
	}

	@RequestMapping(value="/zhcx/detail")
	public String goZhcxDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		CheLiang cl=cheLiangService.selectById(id);
		request.setAttribute("cl", cl);
		
		return MODULE_NAME+"/zhcx/detail";
	}

	/**
	 * ��ת����������-��˼�¼-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shjl/list")
	public String goShjlList(HttpServletRequest request) {
		
		return MODULE_NAME+"/shjl/list";
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
							folder+="Zp";//��Ƭ
							break;
						case 1:
							folder+="Xsz";//��ʻ֤
							break;
						case 2:
							folder+="Scqd";//�泵�嵥
							break;
						case 3:
							folder+="Pfjdcxjt";//�ŷŽ׶β�ѯ��ͼ
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
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
				jsonMap.put("info", "����������Ϣ�ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "����������Ϣʧ�ܣ�");
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
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=cheLiangService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ��������Ϣʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ��������Ϣ�ɹ�");
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
							folder+="Zp";//��Ƭ
							break;
						case 1:
							folder+="Xsz";//��ʻ֤
							break;
						case 2:
							folder+="Scqd";//�泵�嵥
							break;
						case 3:
							folder+="Pfjdcxjt";//�ŷŽ׶β�ѯ��ͼ
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
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
				jsonMap.put("info", "�༭������Ϣ�ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "�༭������Ϣʧ�ܣ�");
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

	@RequestMapping(value="/deleteShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteShenHeJiLu(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=cheLiangShenHeJiLuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ����˼�¼ʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ����˼�¼�ɹ�");
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
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=cheLiangService.checkByIds(ids,clshjl);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		Boolean shjg = clshjl.getShjg();
		if(shjg)
			tsStr="���";
		else
			tsStr="�˻�";
		
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg(tsStr+"������Ϣʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg(tsStr+"������Ϣ�ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
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
