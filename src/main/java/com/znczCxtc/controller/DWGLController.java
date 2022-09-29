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
import com.znczCxtc.util.JsonUtil;
import com.znczCxtc.util.PlanResult;

@Controller
@RequestMapping("/"+DWGLController.MODULE_NAME)
public class DWGLController {

	//@Autowired
	//private YunShuShangService yunShuShangService;
	@Autowired
	private FaHuoDanWeiService faHuoDanWeiService;
	@Autowired
    private ShouHuoDanWeiService shouHuoDanWeiService;
	public static final String MODULE_NAME="dwgl";

	/**
	 * ��ת����λ����-������λ-���ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/new")
	public String goFhdwNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/fhdw/new";
	}

	/**
	 * ��ת����λ����-������λ-�༭ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/edit")
	public String goFhdwEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		FaHuoDanWei fhdw=faHuoDanWeiService.selectById(id);
		request.setAttribute("fhdw", fhdw);
		
		return MODULE_NAME+"/fhdw/edit";
	}
	
	/**
	 * ��ת����λ����-������λ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/list")
	public String goFhdwList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/fhdw/list";
	}

	/**
	 * ��ת����λ����-������λ-����ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fhdw/detail")
	public String goFhdwDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		FaHuoDanWei fhdw=faHuoDanWeiService.selectById(id);
		request.setAttribute("fhdw", fhdw);
		
		return MODULE_NAME+"/fhdw/detail";
	}

	/**
	 * ��ת����λ����-�ջ�����-���ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/new")
	public String goShdwNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/shdw/new";
	}

	/**
	 * ��ת����λ����-������λ-�༭ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/edit")
	public String goShdwEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		ShouHuoDanWei shdw=shouHuoDanWeiService.selectById(id);
		request.setAttribute("shdw", shdw);
		
		return MODULE_NAME+"/shdw/edit";
	}
	
	/**
	 * ��ת����λ����-�ջ���λ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/list")
	public String goShdwList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/shdw/list";
	}

	/**
	 * ��ת����λ����-�ջ���λ-����ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shdw/detail")
	public String goShdwDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		ShouHuoDanWei shdw=shouHuoDanWeiService.selectById(id);
		request.setAttribute("shdw", shdw);
		
		return MODULE_NAME+"/shdw/detail";
	}

	@RequestMapping(value="/newFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> newFaHuoDanWei(FaHuoDanWei fhdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=faHuoDanWeiService.add(fhdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "����������λ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "����������λʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteFaHuoDanWei",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteFaHuoDanWei(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=faHuoDanWeiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ��������λʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ��������λ�ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> editFaHuoDanWei(FaHuoDanWei fhdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=faHuoDanWeiService.edit(fhdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�༭������λ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�༭������λʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryFaHuoDanWeiList")
	@ResponseBody
	public Map<String, Object> queryFaHuoDanWeiList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = faHuoDanWeiService.queryForInt(mc);
		List<FaHuoDanWei> fhdwList=faHuoDanWeiService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", fhdwList);
		
		return jsonMap;
	}

	@RequestMapping(value="/newShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> newShouHuoDanWei(ShouHuoDanWei shdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=shouHuoDanWeiService.add(shdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�����ջ���λ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�����ջ���λʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteShouHuoDanWei",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteShouHuoDanWei(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=shouHuoDanWeiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ���ջ���λʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ���ջ���λ�ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> editShouHuoDanWei(ShouHuoDanWei shdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=shouHuoDanWeiService.edit(shdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�༭�ջ���λ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�༭�ջ���λʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryShouHuoDanWeiList")
	@ResponseBody
	public Map<String, Object> queryShouHuoDanWeiList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = shouHuoDanWeiService.queryForInt(mc);
		List<ShouHuoDanWei> shdwList=shouHuoDanWeiService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", shdwList);
		
		return jsonMap;
	}
}
