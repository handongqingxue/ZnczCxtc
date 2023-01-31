package com.znczCxtc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
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
	@Autowired
    private CangKuService cangKuService;
	@Autowired
	private JueSeService jueSeService;
	@Autowired
	private QuanXianService quanXianService;
	@Autowired
	private YongHuShenHeJiLuService yongHuShenHeJiLuService;
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
			String jsIds = yongHu.getJsIds();
			if(!StringUtils.isEmpty(jsIds)) {
				String qxIds=jueSeService.getQxIdsByIds(jsIds);
				System.out.println("qxIds==="+qxIds);
				yongHu.setQxIds(qxIds);
			}
			
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
			jsonMap.put("info", "创建订单状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建订单状态失败！");
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
			jsonMap.put("info", "编辑订单状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑订单状态失败！");
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
				jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
				long ddId=dingDanService.getIdByDdh(ddh);//因为新订单之前添加到订单表前没有id，添加完成后才生成id，这里在添加完成后，要根据订单号获取订单id
				
				dfgbjl.setDdId(ddId);
				duiFangGuoBangJiLuService.add(dfgbjl);
				
				RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
				rglrCphJiLu.setCph(dd.getCyclCph());
				rglrCphJiLu.setDdId(ddId);//获取订单id后，生成人工录入车牌号记录，与订单id关联。这里的车牌号只是车牌号记录，后面业务部人员在订单里录入的车牌号可能会根据运输商情况变更
				rglrCphJiLuService.add(rglrCphJiLu);
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "创建订单成功！");
				jsonMap.put("ddId", ddId);
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "创建订单失败！");
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
			boolean existDd=dingDanService.checkIfExistByIdCph(ddId,cph);//在修改订单信息前根据订单id和现在的车牌号验证订单表里是否存在订单，一定要在修改订单之前验证，因为这时车牌号就算待变更也还没变成新的
			int count=dingDanService.edit(dd);
			if(count>0) {
				boolean existDfgbjl=duiFangGuoBangJiLuService.checkIfExistByDdId(ddId);
				if(existDfgbjl) {
					duiFangGuoBangJiLuService.editByDdId(dfgbjl);
				}
				else {
					duiFangGuoBangJiLuService.add(dfgbjl);
				}
				
				if(!existDd) {//订单id都是一个id，若不存在，说明编辑订单信息时车牌号也变更了，则需要给该订单再加条录入车牌号记录
					RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
					rglrCphJiLu.setCph(cph);
					rglrCphJiLu.setDdId(ddId);
					rglrCphJiLuService.add(rglrCphJiLu);
				}
				
				jsonMap.put("message", "ok");
				jsonMap.put("info", "编辑订单成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑订单失败！");
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
					if("成功".equals(fileJson.get("msg"))) {
						JSONObject dataJO = (JSONObject)fileJson.get("data");
						dfgbjl.setDfbdzp(dataJO.get("src").toString());
					}
				}
			}
			
			int count=duiFangGuoBangJiLuService.updateFileByDdId(dfgbjl);
			System.out.println("count==="+count);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "上传成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "上传失败！");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
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
			jsonMap.put("info", "创建物资类型成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建物资类型失败！");
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
			jsonMap.put("info", "编辑物资类型成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑物资类型失败！");
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
				jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("info", "创建物资成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建物资失败！");
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
			jsonMap.put("info", "编辑物资成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑物资失败！");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
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
				jsonMap.put("info", "创建车辆信息成功！");
				jsonMap.put("clId", clId);
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

	@RequestMapping(value="/editCheLiang")
	@ResponseBody
	public Map<String, Object> editCheLiang(CheLiang cl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
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
						folder+="Zp";//照片
						break;
					case CheLiang.XING_SHI_ZHENG:
						folder+="Xsz";//行驶证
						break;
					case CheLiang.SUI_CHE_QING_DAN:
						folder+="Scqd";//随车清单
						break;
					case CheLiang.PAI_FANG_JIE_DUAN_CHA_XUN_JIE_TU:
						folder+="Pfjdcxjt";//排放阶段查询截图
						break;
					}
					jsonStr = FileUploadUtil.appUploadContentImg(file,folder);
					JSONObject fileJson = JSONObject.fromObject(jsonStr);
					if("成功".equals(fileJson.get("msg"))) {
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
				jsonMap.put("info", "上传成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "上传失败！");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
	public Map<String, Object> getCLTZList(String ddh,String cyclCph,String ddztIds,String ddztMcs,String jcsjs,String jcsje,String ccsjs,String ccsje,
			int page,int rows,String sort,String order) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cheLiangTaiZhangService.queryForInt(ddh,cyclCph,ddztIds,ddztMcs,jcsjs,jcsje,ccsjs,ccsje);
		List<CheLiangTaiZhang> cltzList=cheLiangTaiZhangService.queryList(ddh, cyclCph, ddztIds, ddztMcs, jcsjs, jcsje, ccsjs, ccsje, page, rows, sort, order);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
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
				jsonMap.put("info", "创建司机信息成功！");
				jsonMap.put("sjId", sjId);
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "创建司机信息失败！");
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
				jsonMap.put("info", "编辑司机信息成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑司机信息失败！");
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
						folder+="Sfzzp";//身份证照片
						break;
					case SiJi.ZI_GE_ZHENG_SHU:
						folder+="Zgzs";//资格证书
						break;
					case SiJi.JIA_ZHENG:
						folder+="Jz";//驾证
						break;
					}
					jsonStr = FileUploadUtil.appUploadContentImg(file,folder);
					JSONObject fileJson = JSONObject.fromObject(jsonStr);
					if("成功".equals(fileJson.get("msg"))) {
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
				jsonMap.put("info", "上传成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "上传失败！");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("info", "创建号码状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建号码状态失败！");
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
			jsonMap.put("info", "编辑号码状态成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑号码状态失败！");
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
				jsonMap.put("message", "暂无数据");
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
				jsonMap.put("message", "暂无数据");
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
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", hmList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/newDuiLie")
	@ResponseBody
	public Map<String, Object> newDuiLie(DuiLie dl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=duiLieService.add(dl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建队列成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建队列失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/editDuiLie")
	@ResponseBody
	public Map<String, Object> editDuiLie(DuiLie dl) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=duiLieService.edit(dl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑队列成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑队列失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getDuiLie")
	@ResponseBody
	public Map<String, Object> getDuiLie(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			DuiLie dl=duiLieService.selectById(id);
			if(dl==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("dl", dl);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", dlList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/newYunShuShang")
	@ResponseBody
	public Map<String, Object> newYunShuShang(YunShuShang yss) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yunShuShangService.add(yss);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建运输商成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建运输商失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editYunShuShang")
	@ResponseBody
	public Map<String, Object> editYunShuShang(YunShuShang yss) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yunShuShangService.edit(yss);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑运输商成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑运输商失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getYunShuShang")
	@ResponseBody
	public Map<String, Object> getYunShuShang(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			YunShuShang yss=yunShuShangService.selectById(id);
			if(yss==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("yss", yss);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getYunShuShangList")
	@ResponseBody
	public Map<String, Object> getYunShuShangList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = yunShuShangService.queryForInt(mc);
		List<YunShuShang> yssList=yunShuShangService.queryList(mc, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", yssList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/newFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> newFaHuoDanWei(FaHuoDanWei fhdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=faHuoDanWeiService.add(fhdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建发货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建发货单位失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> editFaHuoDanWei(FaHuoDanWei fhdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=faHuoDanWeiService.edit(fhdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑发货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑发货单位失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getFaHuoDanWei")
	@ResponseBody
	public Map<String, Object> getFaHuoDanWei(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			FaHuoDanWei fhdw=faHuoDanWeiService.selectById(id);
			if(fhdw==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("fhdw", fhdw);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getFaHuoDanWeiList")
	@ResponseBody
	public Map<String, Object> getFaHuoDanWeiList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = faHuoDanWeiService.queryForInt(mc);
		List<FaHuoDanWei> fhdwList=faHuoDanWeiService.queryList(mc, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", fhdwList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/newShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> newShouHuoDanWei(ShouHuoDanWei shdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=shouHuoDanWeiService.add(shdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建收货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建收货单位失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/editShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> editShouHuoDanWei(ShouHuoDanWei shdw) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=shouHuoDanWeiService.edit(shdw);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑收货单位成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑收货单位失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getShouHuoDanWei")
	@ResponseBody
	public Map<String, Object> getShouHuoDanWei(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			ShouHuoDanWei shdw=shouHuoDanWeiService.selectById(id);
			if(shdw==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("shdw", shdw);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getShouHuoDanWeiList")
	@ResponseBody
	public Map<String, Object> getShouHuoDanWeiList(String mc,Boolean ywdl,int page,int rows) {
		
		//https://moyifeng.blog.csdn.net/article/details/95060416?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-95060416-blog-91444712.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-95060416-blog-91444712.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=2
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = shouHuoDanWeiService.queryForInt(mc,ywdl);
		List<ShouHuoDanWei> shdwList=shouHuoDanWeiService.queryList(mc, ywdl, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", shdwList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newCangKu")
	@ResponseBody
	public Map<String, Object> newCangKu(CangKu ck) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=cangKuService.add(ck);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建仓库成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建仓库失败！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/editCangKu")
	@ResponseBody
	public Map<String, Object> editCangKu(CangKu ck) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=cangKuService.edit(ck);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑仓库成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑仓库失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getCangKu")
	@ResponseBody
	public Map<String, Object> getCangKu(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			CangKu ck=cangKuService.selectById(id);
			if(ck==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("ck", ck);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getCangKuList")
	@ResponseBody
	public Map<String, Object> getCangKuList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = cangKuService.queryForInt(mc);
		List<CangKu> ckList=cangKuService.queryList(mc, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", ckList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/editYongHu")
	@ResponseBody
	public Map<String, Object> editYongHu(YongHu yh) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=yongHuService.edit(yh);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑用户成功,重新登录生效！是否重新登录？");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑用户失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getYongHu")
	@ResponseBody
	public Map<String, Object> getYongHu(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			YongHu yh=yongHuService.selectById(id);
			if(yh==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("yh", yh);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getYongHuList")
	@ResponseBody
	public Map<String, Object> getYongHuList(String yhm,Integer shzt,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = yongHuService.queryForInt(yhm,shzt);
		List<YongHu> yhList=yongHuService.queryList(yhm, shzt, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", yhList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getYHSHJLList")
	@ResponseBody
	public Map<String, Object> getYHSHJLList(String yhm,String shrYhm,String shsjks,String shsjjs,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		try {
			int count = yongHuShenHeJiLuService.queryForInt(yhm,shrYhm,shsjks,shsjjs);
			List<YongHuShenHeJiLu> yhshjlList=yongHuShenHeJiLuService.queryList(yhm, shrYhm, shsjks, shsjjs, page, rows, null, null);
			
			jsonMap.put("total", count);
			if(count==0) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("list", yhshjlList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newJueSe")
	@ResponseBody
	public Map<String, Object> newJueSe(JueSe js) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=jueSeService.add(js);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建角色成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建角色失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editJueSe")
	@ResponseBody
	public Map<String, Object> editJueSe(JueSe js) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=jueSeService.edit(js);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑角色成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑角色失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getJueSe")
	@ResponseBody
	public Map<String, Object> getJueSe(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			JueSe js=jueSeService.selectById(id);
			if(js==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("js", js);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getJueSeList")
	@ResponseBody
	public Map<String, Object> getJueSeList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = jueSeService.queryForInt(mc);
		List<JueSe> jsList=jueSeService.queryList(mc, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", jsList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/newQuanXian")
	@ResponseBody
	public Map<String, Object> newQuanXian(QuanXian qx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=quanXianService.add(qx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "创建权限成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "创建权限失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editQuanXian")
	@ResponseBody
	public Map<String, Object> editQuanXian(QuanXian qx) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count=quanXianService.edit(qx);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "编辑权限成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "编辑权限失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getQuanXian")
	@ResponseBody
	public Map<String, Object> getQuanXian(String id) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			QuanXian qx=quanXianService.selectById(id);
			if(qx==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "暂无数据");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("qx", qx);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getQuanXianList")
	@ResponseBody
	public Map<String, Object> getQuanXianList(String mc,int page,int rows) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = quanXianService.queryForInt(mc);
		List<QuanXian> qxList=quanXianService.queryList(mc, page, rows, null, null);
		
		jsonMap.put("total", count);
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("list", qxList);
		}
		
		return jsonMap;
	}
	
	@RequestMapping(value="/updateMmByYhId")
	@ResponseBody
	public Map<String, Object> updateMmByYhId(String mm,Integer id) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = yongHuService.updateMmById(mm,id);
		
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "修改密码失败");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("message", "修改密码成功，重新登录生效！是否重新登录？");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/checkMm")
	@ResponseBody
	public Map<String, Object> checkMm(String mm, String yhm) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		boolean bool=yongHuService.checkMm(mm,yhm);
		
		if(bool) {
			jsonMap.put("status", "ok");
		}
		else {
			jsonMap.put("status", "no");
			jsonMap.put("message", "原密码错误！");
		}
		return jsonMap;
	}

	@RequestMapping(value="/checkDingDanByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkDingDanByIds(String ids, String ddztMc, Integer jyFlag, DingDanShenHeJiLu shjl) {
		//TODO 针对分类的动态进行实时调整更新
		int count=dingDanService.checkByIds(ids,ddztMc,jyFlag,shjl);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("审核订单失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("审核订单成功");
			json=JsonUtil.getJsonFromObject(plan);
			
			if(!shjl.getShjg()) {//这块代码是在一检审核或二检审核不通过情况下，把订单状态还原到之前的待扫码。与下单审核、入库审核无关
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

	@RequestMapping(value="/deleteDingDanShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteDingDanShenHeJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=dingDanShenHeJiLuService.deleteByIds(ids);
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

	@RequestMapping(value="/deleteBangDanJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteBangDanJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=bangDanJiLuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除磅单信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除磅单信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteGuoBangJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteGuoBangJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=guoBangJiLuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除过磅信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除过磅信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/checkIfExistWuZiByLxIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkIfExistWuZiByLxIds(String lxIds,String lxMcs) {
		//TODO 针对分类的动态进行实时调整更新
		List<WuZiLeiXing> wzlxList=wuZiService.checkIfExistByLxIds(lxIds,lxMcs);
		PlanResult plan=new PlanResult();
		String json;
		if(wzlxList.size()>0) {
			plan.setStatus(1);
			StringBuilder msgSB=new StringBuilder();
			for (int i = 0; i < wzlxList.size(); i++) {
				WuZiLeiXing wzlx = wzlxList.get(i);
				msgSB.append(",");
				msgSB.append(wzlx.getMc());
			}
			msgSB.append("类型下有物资，请先删除物资");
			String msgStr = msgSB.toString();
			plan.setMsg(msgStr.substring(1, msgStr.length()));
			plan.setData(wzlxList);
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(0);
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteWuZiLeiXing",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteWuZiLeiXing(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=wuZiLeiXingService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除物资类型失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除物资类型成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteWuZi",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteWuZi(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=wuZiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除物资失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除物资成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteYunShuShang",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteYunShuShang(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=yunShuShangService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除运输商失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除运输商成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteFaHuoDanWei",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteFaHuoDanWei(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=faHuoDanWeiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除发货单位失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除发货单位成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteShouHuoDanWei",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteShouHuoDanWei(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=shouHuoDanWeiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除收货单位失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除收货单位成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteCangKu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteCangKu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=cangKuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除仓库失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除仓库成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
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

	@RequestMapping(value="/deleteCheLiangShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteCheLiangShenHeJiLu(String ids) {
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

	@RequestMapping(value="/checkSiJiByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkSiJiByIds(String ids, SiJiShenHeJiLu sjshjl) {
		//TODO 针对分类的动态进行实时调整更新
		int count=siJiService.checkByIds(ids,sjshjl);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		Boolean shjg = sjshjl.getShjg();
		if(shjg)
			tsStr="审核";
		else
			tsStr="退回";
		
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg(tsStr+"司机信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg(tsStr+"司机信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/deleteSiJi",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteSiJi(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=siJiService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除司机信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除司机信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteSiJiShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteSiJiShenHeJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=siJiShenHeJiLuService.deleteByIds(ids);
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

	@RequestMapping(value="/deleteHaoMa",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteHaoMa(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=haoMaService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除号码失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除号码成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/deleteDuiLie",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteDuiLie(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=duiLieService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除队列失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除队列成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	/**
	 * 审核用户
	 * @param ids
	 * @param yhshjl
	 * @return
	 */
	@RequestMapping(value="/checkYongHuByIds",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkYongHuByIds(String ids, YongHuShenHeJiLu yhshjl) {
		//TODO 针对分类的动态进行实时调整更新
		int count=yongHuService.checkByIds(ids,yhshjl);
		PlanResult plan=new PlanResult();
		String tsStr=null;
		Boolean shjg = yhshjl.getShjg();
		if(shjg)
			tsStr="审核";
		else
			tsStr="退回";
		
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg(tsStr+"用户信息失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg(tsStr+"用户信息成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	/**
	 * 删除用户审核记录
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteYongHuShenHeJiLu",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteYongHuShenHeJiLu(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=yongHuShenHeJiLuService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除用户审核记录失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除用户审核记录成功");
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

	@RequestMapping(value="/deleteDingDan",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String deleteDingDan(String ids) {
		//TODO 针对分类的动态进行实时调整更新
		int count=dingDanService.deleteByIds(ids);
		PlanResult plan=new PlanResult();
		String json;
		if(count==0) {
			plan.setStatus(0);
			plan.setMsg("删除订单失败");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			plan.setMsg("删除订单成功");
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}
	
	@RequestMapping(value="/getQrcodeInfoByCphZt")
	@ResponseBody
	public Map<String, Object> getQrcodeInfoByCphZt(String cyclCph,String ddztMc) {
		
		System.out.println("cyclCph==="+cyclCph);
		System.out.println("ddztMc==="+ddztMc);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		DingDan dd = dingDanService.getQrcodeInfoByCphZt(cyclCph, ddztMc);
		
		if(dd==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "没找到相关订单");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("dingDan", dd);
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
		jsonMap.put("dlJhxs", Constant.DLJHXS);
		jsonMap.put("yhShzt", Constant.YHSHZT);
		jsonMap.put("yhShjg", Constant.YHSHJG);
		jsonMap.put("jsZt", Constant.JSZT);
		jsonMap.put("yhQx", Constant.YHQX);
		
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
			case Constant.DLJHXS:
				Map<String, Object> dlJhxsMap = Constant.getDLJhxsMap();
				jsonMap.put("dlJhxsMap", dlJhxsMap);
				break;
			case Constant.YHSHZT:
				Map<String, Object> yhShztMap = Constant.getYhShztMap();
				jsonMap.put("yhShztMap", yhShztMap);
				break;
			case Constant.YHSHJG:
				Map<String, Object> yhShjgMap = Constant.getYhShjgMap();
				jsonMap.put("yhShjgMap", yhShjgMap);
				break;
			case Constant.JSZT:
				Map<String, Object> jsZtMap = Constant.getJsZtMap();
				jsonMap.put("jsZtMap", jsZtMap);
				break;
			case Constant.YHQX:
				Map<String, Object> yhQxMap = Constant.getYhQxMap();
				jsonMap.put("yhQxMap", yhQxMap);
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
	 * 查询号码状态下拉框信息
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
	
	@RequestMapping(value="/getDuiLieSelectList")
	@ResponseBody
	public Map<String, Object> getDuiLieSelectList(Integer zt) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<DuiLie> dlList=duiLieService.queryCBBList(zt);
		
		jsonMap.put("list", dlList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getJueSeSelectList")
	@ResponseBody
	public Map<String, Object> getJueSeSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<JueSe> jsList=jueSeService.queryCBBList();
		
		jsonMap.put("list", jsList);
		
		return jsonMap;
	}
	
	@RequestMapping(value="/getQuanXianSelectList")
	@ResponseBody
	public Map<String, Object> getQuanXianSelectList() {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		List<QuanXian> qxList=quanXianService.queryCBBList();
		
		jsonMap.put("list", qxList);
		
		return jsonMap;
	}
}
