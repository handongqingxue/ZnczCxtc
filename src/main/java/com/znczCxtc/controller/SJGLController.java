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
	public static final String MODULE_NAME="sjgl";

	/**
	 * ��ת��˾������-�����-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dsh/list")
	public String goDshList(HttpServletRequest request) {

		request.setAttribute("shzt", SiJi.DAI_SHEN_HE);
		
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
		
		return MODULE_NAME+"/zhcx/edit";
	}

	/**
	 * ��ת��˾������-�ۺϲ�ѯ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/list";
	}

	@RequestMapping(value="/zhcx/detail")
	public String goZhcxDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		SiJi sj=siJiService.selectById(id);
		request.setAttribute("sj", sj);
		
		return MODULE_NAME+"/zhcx/detail";
	}
	
	@RequestMapping(value="/newSiJi")
	@ResponseBody
	public Map<String, Object> newSiJi(SiJi sj,
			@RequestParam(value="sfzzp_file",required=false) MultipartFile sfzzp_file,
			@RequestParam(value="jz_file",required=false) MultipartFile jz_file,
			@RequestParam(value="zgzs_file",required=false) MultipartFile zgzs_file,
			HttpServletRequest request) {
		
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
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
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
			@RequestParam(value="zgzs_file",required=false) MultipartFile zgzs_file,
			HttpServletRequest request) {
		
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
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
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

	@RequestMapping(value="/shenHeSiJi",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String shenHeSiJi(String ids, String flag) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=siJiService.shenHe(ids,flag);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		if("sh".equals(flag))
			tsStr="���";
		else if("th".equals(flag))
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
}