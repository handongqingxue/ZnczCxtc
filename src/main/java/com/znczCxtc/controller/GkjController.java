package com.znczCxtc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.util.FileUploadUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/gkj")
public class GkjController {

	@Autowired
	private DingDanService dingDanService;
	@Autowired
    private HaoMaService haoMaService;
	@Autowired
    private DuiLieService duiLieService;
	@Autowired
    private CheLiangTaiZhangService cheLiangTaiZhangService;

	/**
	 * 根据身份证号和订单状态查询订单(返回一条订单记录,用于门岗身份证阅读器那里)
	 * @param sfzh
	 * @param ddztMc
	 * @return
	 */
	@RequestMapping(value="/getDingDanBySfzhZt")
	@ResponseBody
	public Map<String, Object> getDingDanBySfzhZt(String sfzh,String ddztMc) {
		
		System.out.println("sfzh==="+sfzh);
		System.out.println("ddztMc==="+ddztMc);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		DingDan dd = dingDanService.getDingDanBySfzhZt(sfzh, ddztMc);
		
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

	/**
	 * 根据车牌号和订单状态查询订单(返回的订单只有一条记录,状态参数可能是多个状态)
	 * @param cph
	 * @param ddztMcs
	 * @return
	 */
	@RequestMapping(value="/getDingDanByCphZts")
	@ResponseBody
	public Map<String, Object> getDingDanByCphZts(String cph,String ddztMcs) {
		
		System.out.println("cph==="+cph);
		System.out.println("ddztMcs==="+ddztMcs);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		DingDan dd = dingDanService.getDingDanByCphZts(cph, ddztMcs);
		
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
	
	@RequestMapping(value="/editDingDan")
	@ResponseBody
	public Map<String, Object> editDingDan(DingDan dd) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=dingDanService.edit(dd);
			if(count>0) {
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

	/**
	 * 获得叫号中、排队中的号码列表
	 * @return
	 */
	@RequestMapping(value="/getJhPdHMList")
	@ResponseBody
	public Map<String, Object> getJhPdList() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		haoMaService.changeToJhz();
		//改变状态后，重新排序排队中的号码
		haoMaService.sortPdzHm();
		List<HaoMa> hmList=haoMaService.getJhPdList();
		
		if(hmList==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "暂无数据");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("hmList", hmList);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/newHaoMa")
	@ResponseBody
	public Map<String, Object> newHaoMa(Long ddId) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		Integer dlId=duiLieService.getIdByDdId(ddId);
		Integer maxHm=haoMaService.getMaxHmByDlId(dlId);
		Integer maxPdh=haoMaService.getMaxPdh();
		
		HaoMa hm=new HaoMa();
		hm.setHm(maxHm++);
		hm.setPdh(maxPdh++);
		hm.setHmztMc(HaoMaZhuangTai.PAI_DUI_ZHONG_TEXT);
		hm.setFl(HaoMa.PU_TONG);
		hm.setDdId(ddId);
		int count=haoMaService.add(hm);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "添加号码成功！");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "添加号码失败！");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/editHaoMa")
	@ResponseBody
	public Map<String, Object> editHaoMa(HaoMa hm) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=haoMaService.edit(hm);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "编辑号码成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "编辑号码失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/uploadCheLiangTaiZhang")
	@ResponseBody
	public Map<String, Object> uploadCheLiangTaiZhang(CheLiangTaiZhang cltz, int actionFlag,
			@RequestParam(value = "zp_file", required = false) MultipartFile zp_file,
			HttpServletRequest request) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			MultipartFile[] fileArr=new MultipartFile[1];
			fileArr[0]=zp_file;
			String pzSrc=null;
			for (int i = 0; i < fileArr.length; i++) {
				String jsonStr = null;
				if(fileArr[i]!=null) {
					if(fileArr[i].getSize()>0) {
						String folder="CheLiangTaiZhang/";
						switch (i) {
						case 0:
							switch (actionFlag) {
							case CheLiangTaiZhang.JIN_CHANG:
								folder+="Jczp";//进厂照片
								break;
							case CheLiangTaiZhang.CHU_CHANG:
								folder+="Cczp";//出厂照片
								break;
							}
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("成功".equals(fileJson.get("msg"))) {
							JSONObject dataJO = (JSONObject)fileJson.get("data");
							switch (i) {
							case 0:
								pzSrc=dataJO.get("src").toString();
								break;
							}
						}
					}
				}
			}
		
			int count=0;
			String actionStr=null;
			switch (actionFlag) {
			case CheLiangTaiZhang.JIN_CHANG:
				cltz.setJczp(pzSrc);
				count=cheLiangTaiZhangService.uploadJinChang(cltz);
				actionStr="进厂";
				break;
			case CheLiangTaiZhang.CHU_CHANG:
				cltz.setCczp(pzSrc);
				count=cheLiangTaiZhangService.uploadChuChang(cltz);
				actionStr="出厂";
				break;
			}

			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "上传"+actionStr+"台账成功！");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "上传"+actionStr+"台账失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	@RequestMapping(value="/testFile")
	@ResponseBody
	public Map<String, Object> testFile(CheLiangTaiZhang cltz,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2) {
		//https://blog.csdn.net/weixin_31976851/article/details/114153507
		//https://wenku.baidu.com/view/73de8f265c0e7cd184254b35eefdc8d377ee1450.html?_wkts_=1667965735195&bdQuery=java+HttpURLConnection%E5%A6%82%E4%BD%95%E4%BC%A0%E9%80%92file%E5%AF%B9%E8%B1%A1
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		System.out.println("jcsj==="+cltz.getJcsj());
		System.out.println("file1size==="+file1.getSize());
		System.out.println("file2size==="+file2.getSize());
		return jsonMap;
	}
}
