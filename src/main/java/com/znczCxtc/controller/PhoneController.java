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
	@Autowired
	private BangDanJiLuService bangDanJiLuService;
	@Autowired
	private GuoBangJiLuService guoBangJiLuService;
	@Autowired
	private CheLiangShenHeJiLuService cheLiangShenHeJiLuService;
	@Autowired
    private CheLiangTaiZhangService cheLiangTaiZhangService;
	@Autowired
    private SiJiShenHeJiLuService siJiShenHeJiLuService;
	@Autowired
    private HaoMaZhuangTaiService haoMaZhuangTaiService;
	@Autowired
    private HaoMaService haoMaService;
	@Autowired
    private DuiLieService duiLieService;
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
			jsonMap.put("info", "??????????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????????");
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
			jsonMap.put("info", "??????????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????????");
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
				jsonMap.put("message", "????????");
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
				jsonMap.put("message", "????????");
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
				jsonMap.put("message", "????????");
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
				jsonMap.put("message", "????????");
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
				long ddId=dingDanService.getIdByDdh(ddh);//????????????????????????????????id??????????????????id????????????????????????????????????????id
				
				dfgbjl.setDdId(ddId);
				duiFangGuoBangJiLuService.add(dfgbjl);
				
				RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
				rglrCphJiLu.setCph(dd.getCyclCph());
				rglrCphJiLu.setDdId(ddId);//????????id??????????????????????????????????id????????????????????????????????????????????????????????????????????????????????????????????
				rglrCphJiLuService.add(rglrCphJiLu);
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????????");
				jsonMap.put("ddId", ddId);
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????????");
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
			boolean existDd=dingDanService.checkIfExistByIdCph(ddId,cph);//????????????????????????id????????????????????????????????????????????????????????????????????????????????????????????????????????
			int count=dingDanService.edit(dd);
			if(count>0) {
				boolean existDfgbjl=duiFangGuoBangJiLuService.checkIfExistByDdId(ddId);
				if(existDfgbjl) {
					duiFangGuoBangJiLuService.editByDdId(dfgbjl);
				}
				else {
					duiFangGuoBangJiLuService.add(dfgbjl);
				}
				
				if(!existDd) {//????id????????id????????????????????????????????????????????????????????????????????????????????
					RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
					rglrCphJiLu.setCph(cph);
					rglrCphJiLu.setDdId(ddId);
					rglrCphJiLuService.add(rglrCphJiLu);
				}
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????????");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????????");
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
					if("????".equals(fileJson.get("msg"))) {
						JSONObject dataJO = (JSONObject)fileJson.get("data");
						dfgbjl.setDfbdzp(dataJO.get("src").toString());
					}
				}
			}
			
			int count=duiFangGuoBangJiLuService.updateFileByDdId(dfgbjl);
			System.out.println("count==="+count);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????");
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
			String yssMc,String wzMc,String fhdwMc,String shdwMc,String sjXm,String sjSfzh,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = dingDanShenHeJiLuService.queryForInt(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh);
			List<DingDanShenHeJiLu> ddshjlList=dingDanShenHeJiLuService.queryList(ddh,shlx,shsjks,shsjjs,cyclCph,shrYhm,yssMc,wzMc,fhdwMc,shdwMc,sjXm,sjSfzh, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
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

	@RequestMapping(value="/getBDJLList")
	@ResponseBody
	public Map<String, Object> getBDJLList(String ddh,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = bangDanJiLuService.queryForInt(ddh);
		List<BangDanJiLu> bdjlList=bangDanJiLuService.queryList(ddh, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", bdjlList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getGBJL")
	@ResponseBody
	public Map<String, Object> getGBJL(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			GuoBangJiLu gbjl=guoBangJiLuService.selectById(id);
			if(gbjl==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("gbjl", gbjl);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getGBJLList")
	@ResponseBody
	public Map<String, Object> getGBJLList(String ddh,String cyclCph,String gbsjks,String gbsjjs,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = guoBangJiLuService.queryForInt(ddh,cyclCph,gbsjks,gbsjjs);
		List<GuoBangJiLu> gbjlList=guoBangJiLuService.queryList(ddh, cyclCph, gbsjks, gbsjjs, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", gbjlList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getDJYList")
	@ResponseBody
	public Map<String, Object> getDJYList(String ddh,String ddztMc,String cysjXm,String cysjSfzh,String cyclCph,String yssMc,String fhdwMc,
			String shdwMc,String gbsjks,String gbsjjs,Integer gblx,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = guoBangJiLuService.queryDJYForInt(ddh,ddztMc,cysjXm,cysjSfzh,cyclCph,yssMc,fhdwMc,shdwMc,gbsjks,gbsjjs,gblx);
		List<GuoBangJiLu> jyjlList=guoBangJiLuService.queryDJYList(ddh, ddztMc, cysjXm, cysjSfzh, cyclCph, yssMc, fhdwMc, shdwMc, gbsjks, gbsjjs, gblx, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", jyjlList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newWuZiLeiXing")
	@ResponseBody
	public Map<String, Object> newWuZiLeiXing(WuZiLeiXing wzlx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiLeiXingService.add(wzlx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "??????????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????????");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editWuZiLeiXing")
	@ResponseBody
	public Map<String, Object> editWuZiLeiXing(WuZiLeiXing wzlx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiLeiXingService.edit(wzlx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "??????????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????????");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getWZLX")
	@ResponseBody
	public Map<String, Object> getWZLX(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			WuZiLeiXing wzlx=wuZiLeiXingService.selectById(id);
			if(wzlx==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("wzlx", wzlx);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getWZLXList")
	@ResponseBody
	public Map<String, Object> getWZLXList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = wuZiLeiXingService.queryForInt(mc);
			List<WuZiLeiXing> wzlxList=wuZiLeiXingService.queryList(mc, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", wzlxList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/newWuZi")
	@ResponseBody
	public Map<String, Object> newWuZi(WuZi wz) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiService.add(wz);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "??????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????");
		}
		return jsonMap;
	}

	@RequestMapping(value="/editWuZi")
	@ResponseBody
	public Map<String, Object> editWuZi(WuZi wz) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=wuZiService.edit(wz);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "??????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getWuZi")
	@ResponseBody
	public Map<String, Object> getWuZi(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			WuZi wz=wuZiService.selectById(id);
			if(wz==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("wz", wz);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getWuZiList")
	@ResponseBody
	public Map<String, Object> getWuZiList(String mc,String wzlxmc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = wuZiService.queryForInt(mc,wzlxmc);
		List<WuZi> wzList=wuZiService.queryList(mc, wzlxmc, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", wzList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newCheLiang")
	@ResponseBody
	public Map<String, Object> newCheLiang(CheLiang cl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count=cheLiangService.add(cl);
			if(count>0) {
				int clId=cheLiangService.getIdByCph(cl.getCph());
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????????????");
				jsonMap.put("clId", clId);
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????????????");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/editCheLiang")
	@ResponseBody
	public Map<String, Object> editCheLiang(CheLiang cl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=cheLiangService.edit(cl);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????????????");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????????????");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/uploadCheLiangFile")
	@ResponseBody
	public Map<String, Object> uploadCheLiangFile(CheLiang cl,
			@RequestParam(value="file",required=false) MultipartFile file) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			String jsonStr = null;
			if(file!=null) {
				if(file.getSize()>0) {
					String folder="CheLiang/";
					switch (cl.getWjlx()) {
					case CheLiang.ZHAO_PIAN:
						folder+="Zp";//????
						break;
					case CheLiang.XING_SHI_ZHENG:
						folder+="Xsz";//??????
						break;
					case CheLiang.SUI_CHE_QING_DAN:
						folder+="Scqd";//????????
						break;
					case CheLiang.PAI_FANG_JIE_DUAN_CHA_XUN_JIE_TU:
						folder+="Pfjdcxjt";//????????????????
						break;
					}
					jsonStr = FileUploadUtil.appUploadContentImg(file,folder);
					JSONObject fileJson = JSONObject.fromObject(jsonStr);
					if("????".equals(fileJson.get("msg"))) {
						JSONObject dataJO = (JSONObject)fileJson.get("data");
						String src = dataJO.get("src").toString();
						switch (cl.getWjlx()) {
						case CheLiang.ZHAO_PIAN:
							cl.setZp(src);
							break;
						case CheLiang.XING_SHI_ZHENG:
							cl.setXsz(src);
							break;
						case CheLiang.SUI_CHE_QING_DAN:
							cl.setScqd(src);
							break;
						case CheLiang.PAI_FANG_JIE_DUAN_CHA_XUN_JIE_TU:
							cl.setPfjdcxjt(src);
							break;
						}
					}
				}
			}
			
			int count=cheLiangService.updateFileById(cl);
			System.out.println("count==="+count);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getCheLiang")
	@ResponseBody
	public Map<String, Object> getCheLiang(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			CheLiang cl=cheLiangService.selectById(id);
			if(cl==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("cl", cl);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getCheLiangList")
	@ResponseBody
	public Map<String, Object> getCheLiangList(String cph,Integer cllx,Boolean sfzy,Integer pfjd,String shzt,String bz,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cheLiangService.queryForInt(cph,cllx,sfzy,pfjd,shzt,bz);
		List<CheLiang> clList=cheLiangService.queryList(cph, cllx, sfzy, pfjd, shzt, bz, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", clList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getCLSHJLList")
	@ResponseBody
	public Map<String, Object> getCLSHJLList(String clCph,String shrYhm,String shsjks,String shsjjs,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = cheLiangShenHeJiLuService.queryForInt(clCph,shrYhm,shsjks,shsjjs);
			List<CheLiangShenHeJiLu> clshjlList=cheLiangShenHeJiLuService.queryList(clCph, shrYhm, shsjks, shsjjs, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", clshjlList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getCLTZ")
	@ResponseBody
	public Map<String, Object> getCLTZ(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			CheLiangTaiZhang cltz=cheLiangTaiZhangService.selectById(id);
			if(cltz==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("cltz", cltz);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getCLTZList")
	@ResponseBody
	public Map<String, Object> getCLTZList(String ddh,String cph,String ddztIds,String ddztMcs,String jcsjs,String jcsje,String ccsjs,String ccsje,
			int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cheLiangTaiZhangService.queryForInt(ddh,cph,ddztIds,ddztMcs,jcsjs,jcsje,ccsjs,ccsje);
		List<CheLiangTaiZhang> cltzList=cheLiangTaiZhangService.queryList(ddh, cph, ddztIds, ddztMcs, jcsjs, jcsje, ccsjs, ccsje, page, rows, sort, order);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", cltzList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newSiJi")
	@ResponseBody
	public Map<String, Object> newSiJi(SiJi sj) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count=siJiService.add(sj);
			if(count>0) {
				int sjId=siJiService.getIdBySfzh(sj.getSfzh());
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????????????");
				jsonMap.put("sjId", sjId);
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????????????");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editSiJi")
	@ResponseBody
	public Map<String, Object> editSiJi(SiJi sj) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=siJiService.edit(sj);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????????????");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????????????");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/uploadSiJiFile")
	@ResponseBody
	public Map<String, Object> uploadSiJiFile(SiJi sj,
			@RequestParam(value="file",required=false) MultipartFile file) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			String jsonStr = null;
			if(file!=null) {
				if(file.getSize()>0) {
					String folder="SiJi/";
					switch (sj.getWjlx()) {
					case SiJi.SHEN_FEN_ZHENG_ZHAO_PIAN:
						folder+="Sfzzp";//??????????
						break;
					case SiJi.ZI_GE_ZHENG_SHU:
						folder+="Zgzs";//????????
						break;
					case SiJi.JIA_ZHENG:
						folder+="Jz";//????
						break;
					}
					jsonStr = FileUploadUtil.appUploadContentImg(file,folder);
					JSONObject fileJson = JSONObject.fromObject(jsonStr);
					if("????".equals(fileJson.get("msg"))) {
						JSONObject dataJO = (JSONObject)fileJson.get("data");
						String src = dataJO.get("src").toString();
						switch (sj.getWjlx()) {
						case SiJi.SHEN_FEN_ZHENG_ZHAO_PIAN:
							sj.setSfzzp(src);
							break;
						case SiJi.ZI_GE_ZHENG_SHU:
							sj.setZgzs(src);
							break;
						case SiJi.JIA_ZHENG:
							sj.setJz(src);
							break;
						}
					}
				}
			}
			
			int count=siJiService.updateFileById(sj);
			System.out.println("count==="+count);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "??????????");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "??????????");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getSiJi")
	@ResponseBody
	public Map<String, Object> getSiJi(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			SiJi sj=siJiService.selectById(id);
			if(sj==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("sj", sj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getSiJiList")
	@ResponseBody
	public Map<String, Object> getSiJiList(String xm,String sjh,String sfzh,Integer zyzt,Integer shzt,int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = siJiService.queryForInt(xm,sjh,sfzh,zyzt,shzt);
		List<SiJi> sjList=siJiService.queryList(xm,sjh,sfzh,zyzt, shzt, page, rows, sort, order);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", sjList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getSJSHJLList")
	@ResponseBody
	public Map<String, Object> getSJSHJLList(String sjXm,String shrYhm,String shsjks,String shsjjs,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = siJiShenHeJiLuService.queryForInt(sjXm,shrYhm,shsjks,shsjjs);
			List<SiJiShenHeJiLu> sjshjlList=siJiShenHeJiLuService.queryList(sjXm, shrYhm, shsjks, shsjjs, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", sjshjlList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newHaoMaZhuangTai")
	@ResponseBody
	public Map<String, Object> newHaoMaZhuangTai(HaoMaZhuangTai hmzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=haoMaZhuangTaiService.add(hmzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "??????????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????????");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editHaoMaZhuangTai")
	@ResponseBody
	public Map<String, Object> editHaoMaZhuangTai(HaoMaZhuangTai hmzt) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=haoMaZhuangTaiService.edit(hmzt);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "??????????????????");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "??????????????????");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getHMZT")
	@ResponseBody
	public Map<String, Object> getHMZT(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			HaoMaZhuangTai hmzt=haoMaZhuangTaiService.selectById(id);
			if(hmzt==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("hmzt", hmzt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getHMZTList")
	@ResponseBody
	public Map<String, Object> getHMZTList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = haoMaZhuangTaiService.queryForInt(mc);
			List<HaoMaZhuangTai> hmztList=haoMaZhuangTaiService.queryList(mc, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "????????");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", hmztList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getHaoMaList")
	@ResponseBody
	public Map<String, Object> getHaoMaList(String dlMc,String hm,String pdh,Integer hmztId,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = haoMaService.queryForInt(dlMc, hm, pdh, hmztId);
		List<HaoMa> hmList=haoMaService.queryList(dlMc, hm, pdh, hmztId, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", hmList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getDuiLieList")
	@ResponseBody
	public Map<String, Object> getDuiLieList(String mc,String dm,Integer zt,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = duiLieService.queryForInt(mc,dm,zt);
		List<DuiLie> dlList=duiLieService.queryList(mc, dm, zt, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "????????");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", dlList);
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
		jsonMap.put("gbjlGbzt", Constant.GBJLGBZT);
		jsonMap.put("gblx", Constant.GBLX);
		jsonMap.put("clPfjd", Constant.CLPFJD);
		jsonMap.put("clShzt", Constant.CLSHZT);
		jsonMap.put("clSfzy", Constant.CLSFZY);
		jsonMap.put("clYslx", Constant.CLYSLX);
		jsonMap.put("clWjlx", Constant.CLWJLX);
		jsonMap.put("clShjg", Constant.CLSHJG);
		jsonMap.put("sjShzt", Constant.SJSHZT);
		jsonMap.put("sjZyzt", Constant.SJZYZT);
		jsonMap.put("sjWjlx", Constant.SJWJLX);
		jsonMap.put("hmzt", Constant.HMZT);
		jsonMap.put("hmFl", Constant.HMFL);
		jsonMap.put("dlZt", Constant.DLZT);
		
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
			case Constant.GBJLGBZT:
				Map<String, Object> gbjlGbztMap = Constant.getGbjlGbztMap();
				jsonMap.put("gbjlGbztMap", gbjlGbztMap);
				break;
			case Constant.GBLX:
				Map<String, Object> gblxMap = Constant.getGblxMap();
				jsonMap.put("gblxMap", gblxMap);
				break;
			case Constant.CLPFJD:
				Map<String, Object> clPfjdMap = Constant.getClPfjdMap();
				jsonMap.put("clPfjdMap", clPfjdMap);
				break;
			case Constant.CLSHZT:
				Map<String, Object> clShztMap = Constant.getClShztMap();
				jsonMap.put("clShztMap", clShztMap);
				break;
			case Constant.CLSFZY:
				Map<String, Object> clSfzyMap = Constant.getClSfzyMap();
				jsonMap.put("clSfzyMap", clSfzyMap);
				break;
			case Constant.CLYSLX:
				Map<String, Object> clYslxMap = Constant.getClYslxMap();
				jsonMap.put("clYslxMap", clYslxMap);
				break;
			case Constant.CLWJLX:
				Map<String, Object> clWjlxMap = Constant.getClWjlxMap();
				jsonMap.put("clWjlxMap", clWjlxMap);
				break;
			case Constant.CLSHJG:
				Map<String, Object> clShjgMap = Constant.getClShjgMap();
				jsonMap.put("clShjgMap", clShjgMap);
				break;
			case Constant.SJSHZT:
				Map<String, Object> sjShztMap = Constant.getSjShztMap();
				jsonMap.put("sjShztMap", sjShztMap);
				break;
			case Constant.SJZYZT:
				Map<String, Object> sjZyztMap = Constant.getSjZyztMap();
				jsonMap.put("sjZyztMap", sjZyztMap);
				break;
			case Constant.SJWJLX:
				Map<String, Object> sjWjlxMap = Constant.getSjWjlxMap();
				jsonMap.put("sjWjlxMap", sjWjlxMap);
				break;
			case Constant.HMZT:
				Map<String, Object> hmztMap = Constant.getHmztMap();
				jsonMap.put("hmztMap", hmztMap);
				break;
			case Constant.HMFL:
				Map<String, Object> hmFlMap = Constant.getHmFlMap();
				jsonMap.put("hmFlMap", hmFlMap);
				break;
			case Constant.DLZT:
				Map<String, Object> dlZtMap = Constant.getDLZtMap();
				jsonMap.put("dlZtMap", dlZtMap);
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

	/**
	 * ??????????????????????
	 * @return
	 */
	@RequestMapping(value="/getHaoMaZhuangTaiSelectList")
	@ResponseBody
	public Map<String, Object> getHaoMaZhuangTaiSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<HaoMaZhuangTai> hmztList=haoMaZhuangTaiService.queryHaoMaZhuangTaiCBBList();
		
		jsonMap.put("list", hmztList);
		
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
