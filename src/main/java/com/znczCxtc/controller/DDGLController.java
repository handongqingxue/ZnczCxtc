package com.znczCxtc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/"+DDGLController.MODULE_NAME)
public class DDGLController {

	public static final String MODULE_NAME="ddgl";

	/**
	 * ��ת����������-�ۺϲ�ѯ-�б�ҳ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/zhcx/list")
	public String goZhcxList(HttpServletRequest request) {
		
		return MODULE_NAME+"/zhcx/list";
	}
}
