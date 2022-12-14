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
import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/"+SJGLController.MODULE_NAME)
public class SJGLController {

	@Autowired
    private SiJiService siJiService;
	@Autowired
    private SiJiShenHeJiLuService siJiShenHeJiLuService;
	static final String MODULE_NAME=Constant.SJGL_MODULE_NAME;

	/**
	 * ��ת��˾������-�����-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dsh/list")
	public String goDshList(HttpServletRequest request) {

		request.setAttribute("shzt", SiJi.DAI_SHEN_HE);
		Constant.setDcfwInRequest(request);
		request.setAttribute("sheetFlag", SiJi.DAI_SHEN_HE_SHEET);
		
		return MODULE_NAME+"/dsh/list";
	}

	@RequestMapping(value="/dsh/detail")
	public String goDshDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		SiJi sj=siJiService.selectById(id);
		request.setAttribute("sj", sj);
		
		return MODULE_NAME+"/dsh/detail";
	}

	@RequestMapping(value="/zhcx/new")
	public String goZhcxNew(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/new";
	}

	@RequestMapping(value="/zhcx/edit")
	public String goZhcxEdit(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		SiJi sj=siJiService.selectById(id);
		request.setAttribute("sj", sj);
		
		request.setAttribute("dshShzt", SiJi.DAI_SHEN_HE);
		request.setAttribute("bjzShzt", SiJi.BIAN_JI_ZHONG);
		
		return MODULE_NAME+"/zhcx/edit";
	}

	/**
	 * ��ת��˾������-�ۺϲ�ѯ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {

		Constant.setSjShztInRequest(request);
		Constant.setSjZyztInRequest(request);
		Constant.setDcfwInRequest(request);
		request.setAttribute("sheetFlag", SiJi.ZONG_HE_CHA_XUN_SHEET);
		
		return MODULE_NAME+"/zhcx/list";
	}

	@RequestMapping(value="/zhcx/detail")
	public String goZhcxDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		SiJi sj=siJiService.selectById(id);
		request.setAttribute("sj", sj);
		
		return MODULE_NAME+"/zhcx/detail";
	}

	/**
	 * ��ת��˾������-��˼�¼-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shjl/list")
	public String goShjlList(HttpServletRequest request) {

		Constant.setSjShjgInRequest(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/shjl/list";
	}
	
	@RequestMapping(value="/newSiJi")
	@ResponseBody
	public Map<String, Object> newSiJi(SiJi sj,
			@RequestParam(value="sfzzp_file",required=false) MultipartFile sfzzp_file,
			@RequestParam(value="jz_file",required=false) MultipartFile jz_file,
			@RequestParam(value="zgzs_file",required=false) MultipartFile zgzs_file) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			MultipartFile[] fileArr=new MultipartFile[3];
			fileArr[0]=sfzzp_file;
			fileArr[1]=jz_file;
			fileArr[2]=zgzs_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="SiJi/";
						switch (i) {
						case 0:
							folder+="Sfzzp";//���֤��Ƭ
							break;
						case 1:
							folder+="Jz";//��֤
							break;
						case 2:
							folder+="Zgzs";//�ʸ�֤��
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								sj.setSfzzp(dataJO.get("src").toString());
								break;
							case 1:
								sj.setJz(dataJO.get("src").toString());
								break;
							case 2:
								sj.setZgzs(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
			
			int count=siJiService.add(sj);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "����˾����Ϣ�ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "����˾����Ϣʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/deleteSiJi",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteSiJi(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=siJiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ��˾����Ϣʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ��˾����Ϣ�ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/editSiJi")
	@ResponseBody
	public Map<String, Object> editSiJi(SiJi sj,
			@RequestParam(value="sfzzp_file",required=false) MultipartFile sfzzp_file,
			@RequestParam(value="jz_file",required=false) MultipartFile jz_file,
			@RequestParam(value="zgzs_file",required=false) MultipartFile zgzs_file) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			MultipartFile[] fileArr=new MultipartFile[3];
			fileArr[0]=sfzzp_file;
			fileArr[1]=jz_file;
			fileArr[2]=zgzs_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="SiJi/";
						switch (i) {
						case 0:
							folder+="Sfzzp";//��Ƭ
							break;
						case 1:
							folder+="Jz";//��֤
							break;
						case 2:
							folder+="Zgzs";//�ʸ�֤��
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								sj.setSfzzp(dataJO.get("src").toString());
								break;
							case 1:
								sj.setJz(dataJO.get("src").toString());
								break;
							case 2:
								sj.setZgzs(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
			
			int count=siJiService.edit(sj);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "�༭˾����Ϣ�ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "�༭˾����Ϣʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/querySiJiList")
	@ResponseBody
	public Map<String, Object> querySiJiList(String xm,String sjh,String sfzh,Integer zyzt,Integer shzt,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = siJiService.queryForInt(xm,sjh,sfzh,zyzt,shzt);
		List<SiJi> sjList=siJiService.queryList(xm,sjh,sfzh,zyzt, shzt, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", sjList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/querySHJLList")
	@ResponseBody
	public Map<String, Object> querySHJLList(String sjXm,String shrYhm,String shsjks,String shsjjs,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = siJiShenHeJiLuService.queryForInt(sjXm,shrYhm,shsjks,shsjjs);
			List<SiJiShenHeJiLu> sjshjlList=siJiShenHeJiLuService.queryList(sjXm, shrYhm, shsjks, shsjjs, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", sjshjlList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/checkSiJiByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkSiJiByIds(String ids, SiJiShenHeJiLu sjshjl) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=siJiService.checkByIds(ids,sjshjl);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		Boolean shjg = sjshjl.getShjg();
		if(shjg)
			tsStr="���";
		else
			tsStr="�˻�";
		
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg(tsStr+"˾����Ϣʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg(tsStr+"˾����Ϣ�ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/querySiJiCBBList")
	@ResponseBody
	public Map<String, Object> querySiJiCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<SiJi> sjList=siJiService.queryCBBList();
		
		jsonMap.put("rows", sjList);
		
		return jsonMap;
	}
}
