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
import com.znczCxtc.util.*;

@Controller
@RequestMapping("/"+DWGLController.MODULE_NAME)
public class DWGLController {

	@Autowired
	private YunShuShangService yunShuShangService;
	@Autowired
	private FaHuoDanWeiService faHuoDanWeiService;
	@Autowired
    private ShouHuoDanWeiService shouHuoDanWeiService;
	@Autowired
    private CangKuService cangKuService;
	static final String MODULE_NAME=Constant.DWGL_MODULE_NAME;

	@RequestMapping(value="/yss/new")
	public String goYssNew(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		
		return MODULE_NAME+"/yss/new";
	}

	@RequestMapping(value="/yss/edit")
	public String goYssEdit(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YunShuShang yss=yunShuShangService.selectById(id);
		request.setAttribute("yss", yss);
		
		return MODULE_NAME+"/yss/edit";
	}
	
	/**
	 * ��ת����λ����-������-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yss/list")
	public String goYssList(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/yss/list";
	}

	@RequestMapping(value="/yss/detail")
	public String goYssDetail(HttpServletRequest request) {
		
		//publicService.selectNav(request);
		String id = request.getParameter("id");
		YunShuShang yss=yunShuShangService.selectById(id);
		request.setAttribute("yss", yss);
		
		return MODULE_NAME+"/yss/detail";
	}

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
		Constant.setDcfwInRequest(request);
		
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
		
		request.setAttribute("dlzt", DuiLie.ZAI_YONG);
		
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
		request.setAttribute("dlzt", DuiLie.ZAI_YONG);
		
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
		Constant.setDcfwInRequest(request);
		
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

	@RequestMapping(value="/ck/new")
	public String goCkNew(HttpServletRequest request) {

		return MODULE_NAME+"/ck/new";
	}

	@RequestMapping(value="/ck/edit")
	public String goCkEdit(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		CangKu ck=cangKuService.selectById(id);
		request.setAttribute("ck", ck);
		
		return MODULE_NAME+"/ck/edit";
	}
	
	@RequestMapping(value="/ck/list")
	public String goCkList(HttpServletRequest request) {
		
		Constant.setDcfwInRequest(request);
		
		return MODULE_NAME+"/ck/list";
	}

	@RequestMapping(value="/ck/detail")
	public String goCkDetail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		CangKu ck=cangKuService.selectById(id);
		request.setAttribute("ck", ck);
		
		return MODULE_NAME+"/ck/detail";
	}

	@RequestMapping(value="/newYunShuShang")
	@ResponseBody
	public Map<String, Object> newYunShuShang(YunShuShang yss) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yunShuShangService.add(yss);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "���������̳ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "����������ʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteYunShuShang",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteYunShuShang(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=yunShuShangService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ��������ʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ�������̳ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editYunShuShang")
	@ResponseBody
	public Map<String, Object> editYunShuShang(YunShuShang yss) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yunShuShangService.edit(yss);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�༭�����̳ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�༭������ʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryYunShuShangList")
	@ResponseBody
	public Map<String, Object> queryYunShuShangList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = yunShuShangService.queryForInt(mc);
		List<YunShuShang> yssList=yunShuShangService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", yssList);
		
		return jsonMap;
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
	public Map<String, Object> queryShouHuoDanWeiList(String mc,Boolean ywdl,int page,int rows,String sort,String order) {
		
		//https://moyifeng.blog.csdn.net/article/details/95060416?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-95060416-blog-91444712.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-95060416-blog-91444712.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=2
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = shouHuoDanWeiService.queryForInt(mc,ywdl);
		List<ShouHuoDanWei> shdwList=shouHuoDanWeiService.queryList(mc, ywdl, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", shdwList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newCangKu")
	@ResponseBody
	public Map<String, Object> newCangKu(CangKu ck) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=cangKuService.add(ck);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�����ֿ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�����ֿ�ʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/deleteCangKu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteCangKu(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=cangKuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("ɾ���ֿ�ʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("ɾ���ֿ�ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/editCangKu")
	@ResponseBody
	public Map<String, Object> editCangKu(CangKu ck) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=cangKuService.edit(ck);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�༭�ֿ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�༭�ֿ�ʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/queryCangKuList")
	@ResponseBody
	public Map<String, Object> queryCangKuList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cangKuService.queryForInt(mc);
		List<CangKu> ckList=cangKuService.queryList(mc, page, rows, sort, order);
		
		jsonMap.put("total", count);
		jsonMap.put("rows", ckList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryYunShuShangCBBList")
	@ResponseBody
	public Map<String, Object> queryYunShuShangCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<YunShuShang> yssList=yunShuShangService.queryCBBList();
		
		jsonMap.put("rows", yssList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryFaHuoDanWeiCBBList")
	@ResponseBody
	public Map<String, Object> queryFaHuoDanWeiCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<FaHuoDanWei> fhdwList=faHuoDanWeiService.queryCBBList();
		
		jsonMap.put("rows", fhdwList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryShouHuoDanWeiCBBList")
	@ResponseBody
	public Map<String, Object> queryShouHuoDanWeiCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<ShouHuoDanWei> shdwList=shouHuoDanWeiService.queryCBBList();
		
		jsonMap.put("rows", shdwList);
		
		return jsonMap;
	}
}
