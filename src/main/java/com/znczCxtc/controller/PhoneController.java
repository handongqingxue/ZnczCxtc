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

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.*;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/"+PhoneController.MODULE_NAME)
public class PhoneController {

	@Autowired
	private YongHuService yongHuService;
	@Autowired
	private DingDanService dingDanService;
	@Autowired
	private DingDanZhuangTaiService dingDanZhuangTaiService;
	@Autowired
	private YunShuShangService yunShuShangService;
	@Autowired
	private WuZiLeiXingService wuZiLeiXingService;
	@Autowired
	private WuZiService wuZiService;
	@Autowired
	private FaHuoDanWeiService faHuoDanWeiService;
	@Autowired
    private ShouHuoDanWeiService shouHuoDanWeiService;
	@Autowired
	private CheLiangService cheLiangService;
	@Autowired
    private SiJiService siJiService;
	@Autowired
	private DuiFangGuoBangJiLuService duiFangGuoBangJiLuService;
	@Autowired
	private RglrCphJiLuService rglrCphJiLuService;
	@Autowired
	private DingDanShenHeJiLuService dingDanShenHeJiLuService;
	static final String MODULE_NAME=Constant.PHONE_MODULE_NAME;

	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, Object> login(String yhm, String mm) {
		
		System.out.println("yhm==="+yhm);
		System.out.println("mm==="+mm);

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		YongHu yongHu=yongHuService.get(yhm,mm);

		if(yongHu==null) {
			jsonMap.put("status", "no");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("yongHu", yongHu);
		}
		
		return jsonMap;
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
	
	@RequestMapping(value="/getDDZT")
	@ResponseBody
	public Map<String, Object> getDDZT(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			DingDanZhuangTai ddzt=dingDanZhuangTaiService.selectById(id);
			if(ddzt==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "��������");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("ddzt", ddzt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getDDZTList")
	@ResponseBody
	public Map<String, Object> getDDZTList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanZhuangTaiService.queryForInt(mc);
			List<DingDanZhuangTai> ddztList=dingDanZhuangTaiService.queryList(mc, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "��������");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", ddztList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getDingDan")
	@ResponseBody
	public Map<String, Object> getDingDan(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			DingDan dd=dingDanService.selectById(id);
			if(dd==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "��������");
			}
			else {
				DuiFangGuoBangJiLu dfgbjl=duiFangGuoBangJiLuService.selectByDdId(id);
				jsonMap.put("status", "ok");
				jsonMap.put("dd", dd);
				jsonMap.put("dfgbjl", dfgbjl);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getDDZHCXList")
	@ResponseBody
	public Map<String, Object> getDDZHCXList(String ddh,Integer ddztId,String ddztMc,String cyclCph,String jhysrq,String yssMc,String wzMc,
			String fhdwMc,String shdwMc,String cysjXm,String cysjSfzh,String jcsjs,String jcsje,String ccsjs,String ccsje,
			int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanService.queryForInt(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje);
			List<DingDan> zhglList=dingDanService.queryList(ddh,ddztId,ddztMc,cyclCph,jhysrq,yssMc,wzMc,fhdwMc,shdwMc,cysjXm,cysjSfzh,jcsjs,jcsje,ccsjs,ccsje, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "��������");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", zhglList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newDingDan")
	@ResponseBody
	public Map<String, Object> newDingDan(DingDan dd, DuiFangGuoBangJiLu dfgbjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
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
				jsonMap.put("ddId", ddId);
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
	public Map<String, Object> editDingDan(DingDan dd, DuiFangGuoBangJiLu dfgbjl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
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

	@RequestMapping(value="/uploadDuiFangGuoBangJiLuFile")
	@ResponseBody
	public Map<String, Object> uploadDuiFangGuoBangJiLuFile(DuiFangGuoBangJiLu dfgbjl,
			@RequestParam(value="file",required=false) MultipartFile file) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			String jsonStr = null;
			if(file!=null) {
				if(file.getSize()>0) {
					jsonStr = FileUploadUtil.appUploadContentImg(file,"DuiFangGuoBangJiLu/Dfbdzp/");
					JSONObject fileJson = JSONObject.fromObject(jsonStr);
					if("�ɹ�".equals(fileJson.get("msg"))) {
						JSONObject dataJO = (JSONObject)fileJson.get("data");
						dfgbjl.setDfbdzp(dataJO.get("src").toString());
					}
				}
			}
			
			int count=duiFangGuoBangJiLuService.updateFileByDdId(dfgbjl);
			System.out.println("count==="+count);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "�ϴ��ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "�ϴ�ʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getDDSHJLList")
	@ResponseBody
	public Map<String, Object> getDDSHJLList(String ddh,Integer shlx,String shsjks,String shsjjs,String cyclCph,String shrYhm,
			String yssMc,String wzMc,String fhdwMc,String shdwMc,String sjXm,String sjSfzh,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanShenHeJiLuService.queryForInt(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh);
			List<DingDanShenHeJiLu> ddshjlList=dingDanShenHeJiLuService.queryList(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh, page, rows, sort, order);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "��������");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", ddshjlList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getConstantFlagMap")
	@ResponseBody
	public Map<String, Object> getConstantFlagMap(){

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("lxlx", Constant.LXLX);
		jsonMap.put("ddzt", Constant.DDZT);
		jsonMap.put("ddGbzt", Constant.DDGBZT);
		jsonMap.put("place", Constant.PLACE);
		jsonMap.put("ddShlx", Constant.DDSHLX);
		jsonMap.put("ddShjg", Constant.DDSHJG);
		
		return jsonMap;
	}

	@RequestMapping(value="/getConstantMap")
	@ResponseBody
	public Map<String, Object> getConstantMap(String flags) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		String[] flagArr = flags.split(",");
		for (String flag : flagArr) {
			Integer flagInt = Integer.valueOf(flag);
			switch (flagInt) {
			case Constant.LXLX:
				Map<String, Object> lxlxMap = Constant.getLxlxMap();
				jsonMap.put("lxlxMap", lxlxMap);
				break;
			case Constant.DDZT:
				Map<String, Object> ddztMap = Constant.getDdztMap();
				jsonMap.put("ddztMap", ddztMap);
				break;
			case Constant.DDGBZT:
				Map<String, Object> ddGbztMap = Constant.getDdGbztMap();
				jsonMap.put("ddGbztMap", ddGbztMap);
				break;
			case Constant.PLACE:
				Map<String, Object> placeMap = Constant.getPlaceMap();
				jsonMap.put("placeMap", placeMap);
				break;
			case Constant.DDSHLX:
				Map<String, Object> ddShlxMap = Constant.getDdShlxMap();
				jsonMap.put("ddShlxMap", ddShlxMap);
				break;
			case Constant.DDSHJG:
				Map<String, Object> ddShjgMap = Constant.getDdShjgMap();
				jsonMap.put("ddShjgMap", ddShjgMap);
				break;
			}
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getDingDanZhuangTaiSelectList")
	@ResponseBody
	public Map<String, Object> getDingDanZhuangTaiSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<DingDanZhuangTai> ddztList=dingDanZhuangTaiService.queryCBBList();
		
		jsonMap.put("list", ddztList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getYunShuShangSelectList")
	@ResponseBody
	public Map<String, Object> getYunShuShangSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<YunShuShang> yssList=yunShuShangService.queryCBBList();
		
		jsonMap.put("list", yssList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getWuZiLeiXingSelectList")
	@ResponseBody
	public Map<String, Object> getWuZiLeiXingSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<WuZiLeiXing> wzlxList=wuZiLeiXingService.queryCBBList();
		
		jsonMap.put("list", wzlxList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getWuZiSelectList")
	@ResponseBody
	public Map<String, Object> queryWuZiCBBList(String wzlxId) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<WuZi> wzList=wuZiService.queryCBBList(wzlxId);
		
		jsonMap.put("list", wzList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getFaHuoDanWeiSelectList")
	@ResponseBody
	public Map<String, Object> getFaHuoDanWeiSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<FaHuoDanWei> fhdwList=faHuoDanWeiService.queryCBBList();
		
		jsonMap.put("list", fhdwList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getShouHuoDanWeiSelectList")
	@ResponseBody
	public Map<String, Object> getShouHuoDanWeiSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<ShouHuoDanWei> shdwList=shouHuoDanWeiService.queryCBBList();
		
		jsonMap.put("list", shdwList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getCheLiangSelectList")
	@ResponseBody
	public Map<String, Object> getCheLiangSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<CheLiang> clList=cheLiangService.queryCBBList();
		
		jsonMap.put("list", clList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getSiJiSelectList")
	@ResponseBody
	public Map<String, Object> getSiJiSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<SiJi> sjList=siJiService.queryCBBList();
		
		jsonMap.put("list", sjList);
		
		return jsonMap;
	}
}
