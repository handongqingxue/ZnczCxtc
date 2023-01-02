package com.znczCxtc.controller;

import java.net.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.znczCxtc.entity.*;
import com.znczCxtc.service.*;
import com.znczCxtc.socket.*;
import com.znczCxtc.util.*;

/*
 * �������̣�
 * 1.�����ɵĶ���״̬���Ǵ���ˣ�����Ա�ڶ����б���ͨ����״̬������µ���
 * 2.�볧ǰˢ���֤��״̬����Ŷ��С�LED��Ļ��ʾ�볧�ţ��Զ��кţ���ɴ��볧��
 * 3.����ʶ������ͷʶ���״̬��ɴ����顣����ϸ���������ߣ�������״̬��������ɡ�
 * 
 * ���������
 * 1.�������δͨ����״̬���Ǳ༭�У���Ҫ������ˡ�ͨ���Ļ���״̬�������µ���
 * 2.�Զ��к�Ҫ��û���ҵ�����������ʱ���ˣ�״̬�Ӵ��볧�ֱ�����µ��ˣ��͵������Ŷ��ˡ�
 */
@Controller
@RequestMapping("/"+MainController.MODULE_NAME)
public class MainController {

	@Autowired
	private YongHuService yongHuService;
	@Autowired
	private JueSeService jueSeService;
	static final String MODULE_NAME=Constant.MAIN_MODULE_NAME;
	
	static {
		StartServer ss=new StartServer();
		ss.start();
	}

	/**
	 * ��ת����¼ҳ
	 * @return
	 */
	@RequestMapping(value="/goLogin")
	public String goLogin() {
		//http://localhost:8080/ZnczCxtc/main/goLogin
		return "login";
	}
	
	@RequestMapping(value="/goRegist")
	public String goRegist(HttpServletRequest request) {
		
		return "regist";
	}
	
	/**
	 * ע����Ϣ����ӿ�
	 * @param yh
	 * @return
	 */
	@RequestMapping(value = "/regist" , method = RequestMethod.POST,produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String regist(YongHu yh) {
		
		PlanResult plan=new PlanResult();
		int count=yongHuService.add(yh);
		if(count==0) {
			plan.setStatus(count);
			plan.setMsg("ϵͳ��������ϵά����Ա");
			return JsonUtil.getJsonFromObject(plan);
		}else {
			plan.setStatus(0);
			plan.setMsg("ע��ɹ�");
			plan.setData(yh);
			plan.setUrl("/main/goLogin");
		}
		
		return JsonUtil.getJsonFromObject(plan);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String login(String yhm,String mm,
			String rememberMe,HttpServletRequest request) {
		System.out.println("===��¼�ӿ�===");
		//����ֵ��json
		PlanResult plan=new PlanResult();
		HttpSession session=request.getSession();
		
		//TODO���⸽����ӵ�¼������Ϣ���裬���û����˺��Լ����봢�浽shiro��ܵĹ������õ��з��������ѯ
		try {
			System.out.println("��֤��һ��");
			UsernamePasswordToken token = new UsernamePasswordToken(yhm,mm); 
			Subject currentUser = SecurityUtils.getSubject();  
			if (!currentUser.isAuthenticated()){
				//ʹ��shiro����֤  
				token.setRememberMe(true);  
				currentUser.login(token);//��֤��ɫ��Ȩ��  
			}
		}catch (Exception e) {
			e.printStackTrace();
			plan.setStatus(1);
			plan.setMsg("��½ʧ��");
			return JsonUtil.getJsonFromObject(plan);
		}
		YongHu yongHu=(YongHu)SecurityUtils.getSubject().getPrincipal();
		String jsIds = yongHu.getJsIds();
		if(!StringUtils.isEmpty(jsIds)) {
			String qxIds=jueSeService.getQxIdsByIds(jsIds);
			System.out.println("qxIds==="+qxIds);
			yongHu.setQxIds(qxIds);
		}
		session.setAttribute("yongHu", yongHu);
		
		plan.setStatus(0);
		plan.setMsg("��֤ͨ��");
		plan.setUrl("xtgl/yhxx");
		return JsonUtil.getJsonFromObject(plan);
	}

	@RequestMapping(value="/checkYhmIfExist",produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String checkYhmIfExist(String yhm) {
		boolean exist=yongHuService.checkYhmIfExist(yhm);
		PlanResult plan=new PlanResult();
		String json;
		if(exist) {
			plan.setStatus(0);
			plan.setMsg("�û����Ѵ���");
			json=JsonUtil.getJsonFromObject(plan);
		}
		else {
			plan.setStatus(1);
			json=JsonUtil.getJsonFromObject(plan);
		}
		return json;
	}

	@RequestMapping(value="/exit")
	public String exit(HttpSession session) {
		System.out.println("�˳��ӿ�");
		Subject currentUser = SecurityUtils.getSubject();       
	    currentUser.logout();    
		return "login";
	}
}
