package com.znczCxtc.controller;

import java.net.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.znczCxtc.entity.*;
import com.znczCxtc.util.JsonUtil;
import com.znczCxtc.util.PlanResult;

/*
 * 订单流程：
 * 1.新生成的订单状态都是待审核，管理员在订单列表点击通过，状态变成已下单；
 * 2.入厂前刷身份证，状态变成排队中。LED屏幕显示入厂号，自动叫号，变成待入厂；
 * 3.车牌识别摄像头识别后，状态变成待检验。检验合格继续往下走，出厂后状态就是已完成。
 * 
 * 特殊情况：
 * 1.订单审核未通过，状态就是编辑中，需要重新审核。通过的话，状态才是已下单；
 * 2.自动叫号要是没有找到车辆，超过时间了，状态从待入厂又变回已下单了，就得重新排队了。
 */
@Controller
@RequestMapping("/"+MainController.MODULE_NAME)
public class MainController {
	
	public static final String MODULE_NAME="main";

	/**
	 * 跳转到登录页
	 * @return
	 */
	@RequestMapping(value="/goLogin")
	public String goLogin() {
		//http://localhost:8080/ZnczCxtc/main/goLogin
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="plain/text; charset=UTF-8")
	@ResponseBody
	public String login(String yhm,String mm,
			String rememberMe,HttpServletRequest request) {
		System.out.println("===登录接口===");
		//返回值的json
		PlanResult plan=new PlanResult();
		HttpSession session=request.getSession();
		
		//TODO在这附近添加登录储存信息步骤，将用户的账号以及密码储存到shiro框架的管理配置当中方便后续查询
		try {
			System.out.println("验证码一致");
			UsernamePasswordToken token = new UsernamePasswordToken(yhm,mm); 
			Subject currentUser = SecurityUtils.getSubject();  
			if (!currentUser.isAuthenticated()){
				//使用shiro来验证  
				token.setRememberMe(true);  
				currentUser.login(token);//验证角色和权限  
			}
		}catch (Exception e) {
			e.printStackTrace();
			plan.setStatus(1);
			plan.setMsg("登陆失败");
			return JsonUtil.getJsonFromObject(plan);
		}
		YongHu yongHu=(YongHu)SecurityUtils.getSubject().getPrincipal();
		session.setAttribute("yongHu", yongHu);
		
		plan.setStatus(0);
		plan.setMsg("验证通过");
		plan.setUrl("ddgl/zhcx/list");
		return JsonUtil.getJsonFromObject(plan);
	}
}
