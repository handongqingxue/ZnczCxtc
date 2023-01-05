package com.znczCxtc.controller;

import java.util.Arrays;
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

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/"+DDGLController.MODULE_NAME)
public class DDGLController {

	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private DingDanZhuangTaiService dingDanZhuangTaiService;
	@Autowired
	private RglrCphJiLuService rglrCphJiLuService;
	@Autowired
	private RglrSfzhJiLuService rglrSfzhJiLuService;
	@Autowired
	private BangDanJiLuService bangDanJiLuService;
	@Autowired
	private GuoBangJiLuService guoBangJiLuService;
	@Autowired
	private DuiFangGuoBangJiLuService duiFangGuoBangJiLuService;
	@Autowired
	private DingDanShenHeJiLuService dingDanShenHeJiLuService;
	static final String MODULE_NAME=Constant.DDGL_MODULE_NAME;
	
	@RequestMapping(value="/ddzt/new")
	public String goDdztNew(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.DING_DAN_ZHUANG_TAI_CHA_XUN,request)) {
			url=MODULE_NAME+"/ddzt/new";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/ddzt/edit")
	public String goDdztEdit(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.DING_DAN_ZHUANG_TAI_CHA_XUN,request)) {
			String id = request.getParameter("id");
			DingDanZhuangTai ddzt=dingDanZhuangTaiService.selectById(id);
			request.setAttribute("ddzt", ddzt);
			url=MODULE_NAME+"/ddzt/edit";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * ��ת����������-����״̬-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ddzt/list")
	public String goDdztList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.DING_DAN_ZHUANG_TAI_CHA_XUN,request)) {
			url=MODULE_NAME+"/ddzt/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/ddzt/detail")
	public String goDdztDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.DING_DAN_ZHUANG_TAI_CHA_XUN,request)) {
			String id = request.getParameter("id");
			DingDanZhuangTai ddzt=dingDanZhuangTaiService.selectById(id);
			request.setAttribute("ddzt", ddzt);
			url=MODULE_NAME+"/ddzt/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * ��ת����������-�����-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dsh/list")
	public String goDshList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.XIA_DAN_SHEN_HE,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDdztInRequest(request);
			Constant.setDdShlxInRequest(request);
			Constant.setLxlxInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", DingDan.DAI_SHEN_HE_SHEET);
			url=MODULE_NAME+"/dsh/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * ��ת����������-���ʼ�-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dzj/list")
	public String goDzjList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.ZHI_JIAN_SHEN_HE,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDdztInRequest(request);
			Constant.setDdShlxInRequest(request);
			Constant.setLxlxInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", DingDan.DAI_JIAN_YAN_SHEET);
			url=MODULE_NAME+"/dzj/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * ��ת����������-�����-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/drk/list")
	public String goDrkList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.ZHUANG_XIE_HUO_SHEN_HE,request)) {
			//publicService.selectNav(request);
			Constant.setYhQxInRequest(request);
			Constant.setDdztInRequest(request);
			Constant.setDdShlxInRequest(request);
			Constant.setLxlxInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", DingDan.DAI_ZHUANG_XIE_HUO_SHEET);
			url=MODULE_NAME+"/drk/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/zhcx/new")
	public String goZhcxNew(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.TIAN_JIA_DING_DAN,request)) {
			Constant.setYhQxInRequest(request);
			url=MODULE_NAME+"/zhcx/new";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/zhcx/edit")
	public String goZhcxEdit(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.XIU_GAI_DING_DAN,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			DingDan dd=dingDanService.selectById(id);
			request.setAttribute("dd", dd);
			
			DuiFangGuoBangJiLu dfgbjl=duiFangGuoBangJiLuService.selectByDdId(id);
			request.setAttribute("dfgbjl", dfgbjl);
			
			request.setAttribute("dshDdztMc", DingDanZhuangTai.DAI_SHEN_HE_TEXT);
			request.setAttribute("bjzDdztMc", DingDanZhuangTai.BIAN_JI_ZHONG_TEXT);
			url=MODULE_NAME+"/zhcx/edit";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * ��ת����������-�ۺϲ�ѯ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_DING_DAN,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setLxlxInRequest(request);
			Constant.setDdztInRequest(request);
			Constant.setDdGbztInRequest(request);
			Constant.setPlaceInRequest(request);
			Constant.setPushInRequest(request);
			Constant.setDcfwInRequest(request);
			request.setAttribute("sheetFlag", DingDan.ZONG_HE_CHA_XUN_SHEET);
			url=MODULE_NAME+"/zhcx/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/zhcx/detail")
	public String goZhcxDetail(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_DING_DAN,request)) {
			Constant.setYhQxInRequest(request);
			String id = request.getParameter("id");
			DingDan dd=dingDanService.selectById(id);
			request.setAttribute("dd", dd);
			
			DuiFangGuoBangJiLu dfgbjl=duiFangGuoBangJiLuService.selectByDdId(id);
			request.setAttribute("dfgbjl", dfgbjl);
	
			request.setAttribute("dshDdztMc", DingDanZhuangTai.DAI_SHEN_HE_TEXT);
			request.setAttribute("bjzDdztMc", DingDanZhuangTai.BIAN_JI_ZHONG_TEXT);
			request.setAttribute("yxdDdztMc", DingDanZhuangTai.YI_XIA_DAN_TEXT);
			request.setAttribute("shlx", DingDanShenHeJiLu.XIA_DAN_SHEN_HE);
			url=MODULE_NAME+"/zhcx/detail";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}

	/**
	 * ��ת����������-��˼�¼-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shjl/list")
	public String goShjlList(HttpServletRequest request) {

		String url=null;
		if(Constant.checkIfExistQx(QuanXian.CHA_XUN_DING_DAN_SHEN_HE_JI_LU,request)) {
			Constant.setYhQxInRequest(request);
			Constant.setDdShlxInRequest(request);
			Constant.setLxlxInRequest(request);
			Constant.setDdShjgInRequest(request);
			Constant.setDcfwInRequest(request);
			url=MODULE_NAME+"/shjl/list";
		}
		else
			url=Constant.NO_QX_RETURN_URL;
		
		return url;
	}
	
	@RequestMapping(value="/newDingDanZhuangTai")
	@ResponseBody
	public Map<String, Object> newDingDanZhuangTai(DingDanZhuangTai ddzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=dingDanZhuangTaiService.add(ddzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "��������״̬�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "��������״̬ʧ�ܣ�");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editDingDanZhuangTai")
	@ResponseBody
	public Map<String, Object> editDingDanZhuangTai(DingDanZhuangTai ddzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=dingDanZhuangTaiService.edit(ddzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�༭����״̬�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�༭����״̬ʧ�ܣ�");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryDDZTList")
	@ResponseBody
	public Map<String, Object> queryDDZTList(String mc,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanZhuangTaiService.queryForInt(mc);
			List<DingDanZhuangTai> ddztList=dingDanZhuangTaiService.queryList(mc, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", ddztList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newDingDan")
	@ResponseBody
	public Map<String, Object> newDingDan(DingDan dd, DuiFangGuoBangJiLu dfgbjl, 
			@RequestParam(value="dfbdzp_file",required=false) MultipartFile dfbdzp_file) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			MultipartFile[] fileArr=new MultipartFile[1];
			fileArr[0]=dfbdzp_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="DuiFangGuoBangJiLu/";
						switch (i) {
						case 0:
							folder+="Dfbdzp";//�Է�����Ƭ
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								dfgbjl.setDfbdzp(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
			
			String ddh=dingDanService.createDdhByDateYMD();
			dd.setDdh(ddh);
	        
			int count=dingDanService.add(dd);
			if(count>0) {
				long ddId=dingDanService.getIdByDdh(ddh);//��Ϊ�¶���֮ǰ��ӵ�������ǰû��id�������ɺ������id�������������ɺ�Ҫ���ݶ����Ż�ȡ����id
				
				dfgbjl.setDdId(ddId);
				duiFangGuoBangJiLuService.add(dfgbjl);
				
				RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
				rglrCphJiLu.setCph(dd.getCyclCph());
				rglrCphJiLu.setDdId(ddId);//��ȡ����id�������˹�¼�복�ƺż�¼���붩��id����������ĳ��ƺ�ֻ�ǳ��ƺż�¼������ҵ����Ա�ڶ�����¼��ĳ��ƺſ��ܻ����������������
				rglrCphJiLuService.add(rglrCphJiLu);
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "���������ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "��������ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editDingDan")
	@ResponseBody
	public Map<String, Object> editDingDan(DingDan dd, DuiFangGuoBangJiLu dfgbjl,
			@RequestParam(value="dfbdzp_file",required=false) MultipartFile dfbdzp_file) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			MultipartFile[] fileArr=new MultipartFile[1];
			fileArr[0]=dfbdzp_file;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="DuiFangGuoBangJiLu/";
						switch (i) {
						case 0:
							folder+="Dfbdzp";//�Է�����Ƭ
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								dfgbjl.setDfbdzp(dataJO.get("src").toString());
								break;
							}
						}
					}
				}
			}
			
			Long ddId = dd.getId();
			String cph = dd.getCyclCph();
			boolean existDd=dingDanService.checkIfExistByIdCph(ddId,cph);//���޸Ķ�����Ϣǰ���ݶ���id�����ڵĳ��ƺ���֤���������Ƿ���ڶ�����һ��Ҫ���޸Ķ���֮ǰ��֤����Ϊ��ʱ���ƺž�������Ҳ��û����µ�
			int count=dingDanService.edit(dd);
			if(count>0) {
				boolean existDfgbjl=duiFangGuoBangJiLuService.checkIfExistByDdId(ddId);
				if(existDfgbjl) {
					duiFangGuoBangJiLuService.editByDdId(dfgbjl);
				}
				else {
					duiFangGuoBangJiLuService.add(dfgbjl);
				}
				
				if(!existDd) {//����id����һ��id���������ڣ�˵���༭������Ϣʱ���ƺ�Ҳ����ˣ�����Ҫ���ö����ټ���¼�복�ƺż�¼
					RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
					rglrCphJiLu.setCph(cph);
					rglrCphJiLu.setDdId(ddId);
					rglrCphJiLuService.add(rglrCphJiLu);
				}
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "�༭�����ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "�༭����ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/queryZHCXList")
	@ResponseBody
	public Map<String, Object> queryZHCXList(String ddh,Integer ddztId,String ddztMc,String cyclCph,String jhysrq,String yssMc,String wzMc,
			String fhdwMc,String shdwMc,String cysjXm,String cysjSfzh,String jcsjs,String jcsje,String ccsjs,String ccsje,
			int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanService.queryForInt(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje);
			List<DingDan> zhglList=dingDanService.queryList(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", zhglList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/deleteShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteShenHeJiLu(String ids) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=dingDanShenHeJiLuService.deleteByIds(ids);
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

	@RequestMapping(value="/fwddById",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String fwddById(DingDan dd,int jyFlag) {

		PlanResult plan=new PlanResult();
		String json;
		boolean bool=false;
		int count=dingDanService.edit(dd);
		if(jyFlag==GuoBangJiLu.RU_CHANG_GUO_BANG) {
			bool=bangDanJiLuService.checkIfExistByDdId(dd.getId());
			if(bool)
				bangDanJiLuService.deleteByDdId(dd.getId());
		}
		bool=guoBangJiLuService.checkIfExistByDdId(jyFlag,dd.getId());
		if(bool)
			guoBangJiLuService.deleteByDdId(jyFlag,dd.getId());
			
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("������λʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("������λ�ɹ����복�������Ŷ��ϰ�");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/querySHJLList")
	@ResponseBody
	public Map<String, Object> querySHJLList(String ddh,Integer shlx,String shsjks,String shsjjs,String cyclCph,String shrYhm,
			String yssMc,String wzMc,String fhdwMc,String shdwMc,String sjXm,String sjSfzh,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanShenHeJiLuService.queryForInt(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh);
			List<DingDanShenHeJiLu> ddshjlList=dingDanShenHeJiLuService.queryList(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh, page, rows, sort, order);
			
			jsonMap.put("total", count);
			jsonMap.put("rows", ddshjlList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/checkDingDanByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkDingDanByIds(String ids, String ddztMc, Integer jyFlag, DingDanShenHeJiLu shjl) {
		//TODO ��Է���Ķ�̬����ʵʱ��������
		int count=dingDanService.checkByIds(ids,ddztMc,jyFlag,shjl);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("��˶���ʧ��");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("��˶����ɹ�");
			json=JsonUtil.getJsonFromObject(plan);
			
			if(!shjl.getShjg()) {//����������һ����˻������˲�ͨ������£��Ѷ���״̬��ԭ��֮ǰ�Ĵ�ɨ�롣���µ���ˡ��������޹�
				List<String> idList = Arrays.asList(ids.split(","));
				for (String idStr : idList) {
					Long ddId = Long.valueOf(idStr);
					DingDan dd=new DingDan();
					dd.setId(ddId);
					if(shjl.getShlx()==DingDanShenHeJiLu.YI_JIAN_SHEN_HE) {
						dd.setDdztMc(DingDanZhuangTai.YI_JIAN_DAI_SAO_MA_TEXT);
						dd.setYjzt(DingDan.DAI_SHANG_BANG);
					}
					else if(shjl.getShlx()==DingDanShenHeJiLu.ER_JIAN_SHEN_HE) {
						dd.setDdztMc(DingDanZhuangTai.ER_JIAN_DAI_SAO_MA_TEXT);
						dd.setEjzt(DingDan.DAI_SHANG_BANG);
					}
					dingDanService.edit(dd);
				}
			}
		}
		return json;
	}
	
	@RequestMapping(value="/queryDingDanZhuangTaiCBBList")
	@ResponseBody
	public Map<String, Object> queryDingDanZhuangTaiCBBList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<DingDanZhuangTai> ddztList=dingDanZhuangTaiService.queryCBBList();
		
		jsonMap.put("rows", ddztList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryXzSfzhCBBList")
	@ResponseBody
	public Map<String, Object> queryXzSfzhCBBList(int page,int rows,String sort,String order) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<String> sfzhList=rglrSfzhJiLuService.queryXzSfzhCBBList(page, rows, sort, order);
		
		jsonMap.put("rows", sfzhList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryXzCphCBBList")
	@ResponseBody
	public Map<String, Object> queryXzCphCBBList(int page,int rows,String sort,String order) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<String> cphList=rglrCphJiLuService.queryXzCphCBBList(page, rows, sort, order);
		
		jsonMap.put("rows", cphList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/queryLrSjcCBBList")
	@ResponseBody
	public List<RglrCphJiLu> queryLrSjcCBBList(String q,int page,int rows,String sort,String order) {

		List<RglrCphJiLu> sjcList=rglrCphJiLuService.queryLrSjcCBBList(q, page, rows, sort, order);
		
		return sjcList;
	}
	
	@RequestMapping(value="/queryLrWscphCBBList")
	@ResponseBody
	public List<RglrCphJiLu> queryLrWscphCBBList(String sjc,String q,int page,int rows,String sort,String order) {

		List<RglrCphJiLu> cphList=rglrCphJiLuService.queryLrWscphCBBList(sjc, q, page, rows, sort, order);
		
		return cphList;
	}
}
