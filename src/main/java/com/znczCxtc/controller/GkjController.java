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
import com.znczCxtc.socket.*;
import com.znczCxtc.util.*;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/"+GkjController.MODULE_NAME)
public class GkjController {

	@Autowired
	private DingDanService dingDanService;
	@Autowired
    private HaoMaService haoMaService;
	@Autowired
    private DuiLieService duiLieService;
	@Autowired
    private CheLiangTaiZhangService cheLiangTaiZhangService;
	@Autowired
	private RglrCphJiLuService rglrCphJiLuService; 
	@Autowired
	private RglrSfzhJiLuService rglrSfzhJiLuService;
	@Autowired
	private BangDanJiLuService bangDanJiLuService;
	@Autowired
	private GuoBangJiLuService guoBangJiLuService;
	static final String MODULE_NAME=Constant.GKJ_MODULE_NAME;

	/**
	 * �������֤�źͶ���״̬��ѯ����(����һ��������¼,�����Ÿ����֤�Ķ�������)
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
			jsonMap.put("message", "û�ҵ���ض���");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("dingDan", dd);
		}
		
		return jsonMap;
	}

	/**
	 * ���ݳ��ƺźͶ���״̬��ѯ����(���صĶ���ֻ��һ����¼,״̬���������Ƕ��״̬)
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
			jsonMap.put("message", "û�ҵ���ض���");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("dingDan", dd);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/getDingDanByZt")
	@ResponseBody
	public Map<String, Object> getDingDanByZt(Integer yjbfh,Integer ejbfh,String ddztMc,Integer yjzt,Integer ejzt) {
		
		System.out.println("yjbfh==="+yjbfh);
		System.out.println("ejbfh==="+ejbfh);
		System.out.println("ddztMc==="+ddztMc);
		System.out.println("yjzt==="+yjzt);
		System.out.println("ejzt==="+ejzt);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		DingDan dd = dingDanService.getByZt(yjbfh,ejbfh,ddztMc,yjzt,ejzt);
		
		if(dd==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "û�ҵ���ض���");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("dingDan", dd);
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/checkDingDanIfExistByZt")
	@ResponseBody
	public Map<String, Object> checkDingDanIfExistByZt(Integer yjbfh,Integer ejbfh,String ddztMc, Integer yjzt, Integer ejzt) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		boolean bool=dingDanService.checkIfExistByZt(yjbfh,ejbfh,ddztMc, yjzt, ejzt);
		if(bool) {
			jsonMap.put("status", "ok");
			jsonMap.put("message", "�����Ѵ��ڣ�");
		}
		else {
			jsonMap.put("status", "no");
		}
		return jsonMap;
	}
	
	@RequestMapping(value="/getLastHaoMaByDdId")
	@ResponseBody
	public Map<String, Object> getLastHaoMaByDdId(Long ddId) {

		System.out.println("ddId==="+ddId);

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		HaoMa hm = haoMaService.getLastByDdId(ddId);
		
		if(hm==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "û�ҵ���غ���");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("haoMa", hm);
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
	
	@RequestMapping(value="/editDingDanByZt")
	@ResponseBody
	public Map<String, Object> editDingDanByZt(DingDan dd,
			HttpServletRequest request) {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			int count=dingDanService.editByZt(dd);
			if(count>0) {
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

	/**
	 * ��ýк��С��Ŷ��еĺ����б�
	 * @return
	 */
	@RequestMapping(value="/getJhPdHMList")
	@ResponseBody
	public Map<String, Object> getJhPdList() {
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		haoMaService.changeToJhz();
		//�ı�״̬�����������Ŷ��еĺ���
		haoMaService.sortPdzHm();
		List<HaoMa> hmList=haoMaService.getJhPdList();
		
		if(hmList==null) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "��������");
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
		System.out.println("maxHm==="+maxHm);
		if(maxHm==null)
			maxHm=0;
		Integer maxPdh=haoMaService.getMaxPdh();
		System.out.println("maxPdh==="+maxPdh);
		if(maxPdh==null)
			maxPdh=0;
		
		HaoMa hm=new HaoMa();
		hm.setHm(++maxHm);
		hm.setPdh(++maxPdh);
		hm.setHmztMc(HaoMaZhuangTai.PAI_DUI_ZHONG_TEXT);
		hm.setFl(HaoMa.PU_TONG);
		hm.setDdId(ddId);
		int count=haoMaService.add(hm);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "��Ӻ���ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "��Ӻ���ʧ�ܣ�");
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
				jsonMap.put("info", "�༭����ɹ���");
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
								folder+="Jczp";//������Ƭ
								break;
							case CheLiangTaiZhang.CHU_CHANG:
								folder+="Cczp";//������Ƭ
								break;
							}
							break;
						}
						jsonStr = FileUploadUtil.appUploadContentImg(request,fileArr[i],folder);
						JSONObject fileJson = JSONObject.fromObject(jsonStr);
						if("�ɹ�".equals(fileJson.get("msg"))) {
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
				actionStr="����";
				break;
			case CheLiangTaiZhang.CHU_CHANG:
				cltz.setCczp(pzSrc);
				count=cheLiangTaiZhangService.uploadChuChang(cltz);
				actionStr="����";
				break;
			}

			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "�ϴ�"+actionStr+"̨�˳ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "�ϴ�"+actionStr+"̨��ʧ�ܣ�");
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

	@RequestMapping(value="/newBangDanJiLu")
	@ResponseBody
	public Map<String, Object> newBangDanJiLu(BangDanJiLu bdjl) {

		System.out.println("ddId==="+bdjl.getDdId());
		System.out.println("mz==="+bdjl.getMz());
		System.out.println("pz==="+bdjl.getPz());
		System.out.println("jz==="+bdjl.getJz());
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		int count = bangDanJiLuService.add(bdjl);
		
		if(count==0) {
			jsonMap.put("status", "no");
			jsonMap.put("message", "����������Ϣʧ�ܣ�");
		}
		else {
			jsonMap.put("status", "ok");
			jsonMap.put("message", "����������Ϣ�ɹ���");
		}
		
		return jsonMap;
	}

	@RequestMapping(value="/editBangDanJiLu")
	@ResponseBody
	public Map<String, Object> editBangDanJiLu(BangDanJiLu bdjl) {

		System.out.println("ddId==="+bdjl.getDdId());
		System.out.println("mz==="+bdjl.getMz());
		System.out.println("pz==="+bdjl.getPz());
		System.out.println("jz==="+bdjl.getJz());
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		int count=bangDanJiLuService.edit(bdjl);
		if(count>0) {
			jsonMap.put("message", "ok");
			jsonMap.put("info", "�༭������Ϣ�ɹ���");
		}
		else {
			jsonMap.put("message", "no");
			jsonMap.put("info", "�༭������Ϣʧ�ܣ�");
		}
		return jsonMap;
	}

	@RequestMapping(value="/selectBangDanJiLuByDdId")
	@ResponseBody
	public Map<String, Object> selectBangDanJiLuByDdId(Integer ddId) {

		System.out.println("ddId==="+ddId);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		try {
			BangDanJiLu bdjl = bangDanJiLuService.selectByDdId(ddId);
			if(bdjl==null) {
				jsonMap.put("status", "no");
				jsonMap.put("message", "�Ҳ�����ذ�����");
			}
			else {
				jsonMap.put("status", "ok");
				jsonMap.put("bdjl", bdjl);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return jsonMap;
		}
	}

	@RequestMapping(value="/newGuoBangJiLu")
	@ResponseBody
	public Map<String, Object> newGuoBangJiLu(GuoBangJiLu gbjl) {

		Map<String, Object> jsonMap=new HashMap<String, Object>();
		try {
			int count=guoBangJiLuService.add(gbjl);
			if(count>0) {
				jsonMap.put("message", "ok");
				jsonMap.put("info", "����������Ϣ�ɹ���");
			}
			else {
				jsonMap.put("message", "no");
				jsonMap.put("info", "����������Ϣʧ�ܣ�");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return jsonMap;
		}
	}

	@RequestMapping(value="/pushToClient")
	@ResponseBody
	public Map<String, Object> pushToClient(HttpServletRequest request) {
		
		Long ddId = Long.valueOf(request.getParameter("ddId"));
		String pushFlag = request.getParameter("pushFlag");
		
		System.out.println("pushToClient.ddId==="+ddId);
		System.out.println("pushToClient.pushFlag==="+pushFlag);

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		//ProxySet.sayToClient("³A9031", SocketProxy.YI_JIAN);
		StringBuilder mesJOSB=new StringBuilder();
		String mesJOStr=null;
		mesJOSB.append("");
		mesJOSB.append("");
		mesJOSB.append("");
		mesJOSB.append("");
		
		mesJOSB.append("{\"action\":\""+pushFlag+"\",");
		if(Constant.PUSH_CPH.equals(pushFlag)) {
			Integer placeFlag = Integer.valueOf(request.getParameter("placeFlag"));
			System.out.println("pushToClient.placeFlag==="+placeFlag);
			switch (placeFlag) {
			case Constant.YI_HAO_BANG_FANG:
			case Constant.ER_HAO_BANG_FANG:
			case Constant.SAN_HAO_BANG_FANG:
				Integer jyFlag = Integer.valueOf(request.getParameter("jyFlag"));
				mesJOSB.append("jyFlag:"+jyFlag+",");
				break;
			}
			String cph = request.getParameter("cph");
			mesJOSB.append("\"cph\":\""+cph+"\"}");
			mesJOStr=mesJOSB.toString();
			ProxySet.sayToClient(mesJOStr, placeFlag);//���͸��ͻ��˹��ػ����˹�̧��
			
			boolean exist=rglrCphJiLuService.checkIfExistByDdIdCph(ddId,cph);//��֤ͬһ�������Ƿ���ڸó��ƺţ�������˵��֮ǰ¼����ˣ�����Ҫ�����ɳ��ƺż�¼�ˣ���֮����Ҫ����
			if(!exist) {
				RglrCphJiLu rglrCphJiLu=new RglrCphJiLu();
				rglrCphJiLu.setCph(cph);
				rglrCphJiLu.setDdId(ddId);
				rglrCphJiLuService.add(rglrCphJiLu);
			}
		}
		else if(Constant.PUSH_SFZH.equals(pushFlag)) {
			String sfzh = request.getParameter("sfzh");
			mesJOSB.append("\"sfzh\":\""+sfzh+"\"}");
			mesJOStr=mesJOSB.toString();
			ProxySet.sayToClient(mesJOStr, Constant.MEN_GANG);//���͸��ͻ��˹��ػ��˽����Ŷ���
			
			boolean exist=rglrSfzhJiLuService.checkIfExistByDdIdSfzh(ddId,sfzh);//��֤ͬһ�������Ƿ���ڸ����֤�ţ�������˵��֮ǰ¼����ˣ�����Ҫ���������֤�ż�¼�ˣ���֮����Ҫ����
			if(!exist) {
				RglrSfzhJiLu rglrSfzhJiLu=new RglrSfzhJiLu();
				rglrSfzhJiLu.setSfzh(sfzh);
				rglrSfzhJiLu.setDdId(ddId);
				rglrSfzhJiLuService.add(rglrSfzhJiLu);
			}
		}
		
		jsonMap.put("status", "ok");
		
		return jsonMap;
	}
}
