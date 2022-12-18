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
