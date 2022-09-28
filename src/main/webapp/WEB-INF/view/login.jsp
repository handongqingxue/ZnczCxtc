<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"
		+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath %>resource/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
var path='<%=basePath %>';
function focusYHM(){
	var yhm=$("#yhm_inp").val();
	if(yhm=="请填写用户名"||yhm=="用户名不能有特殊字符"||yhm=="用户名首尾不能出现下划线\'_\'"){
		$("#yhm_inp").val("");
		$("#yhm_inp").css("color","#000");
	}
}
    
function checkYHM(){
    var yhm=$("#yhm_inp").val();
    if(yhm==null||yhm==""||yhm=="请填写用户名"){
		$("#yhm_inp").css("color","#f00");
		$("#yhm_inp").val("请填写用户名");
		return false;
	}
    else if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(yhm)) {
    	$("#yhm_inp").css("color","#f00");
		$("#yhm_inp").val("用户名不能有特殊字符");
        return false;
    }
    else if (/(^\_)|(\__)|(\_+$)/.test(yhm)) {
    	$("#yhm_inp").css("color","#f00");
		$("#yhm_inp").val("用户名首尾不能出现下划线\'_\'");
        return false;
    }
	else
		return true;
}

function checkMM(){
	var mm=$("#mm_inp").val();
	if(mm==null||mm==""||mm=="请填写密码"){
		alert("请填写密码");
		return false;
	}
	else
		return true;
}

function login(){
	if(checkYHM()){
		if(checkMM()){
			var yhm=$("#yhm_inp").val();
			var mm=$("#mm_inp").val();
			//var loginVCode=$("#loginVCode").val();
			$.post(path+"main/login",
				{yhm:yhm,mm:mm},
				function(json){
		        	console.log(json)
		        	if(json.status==0){
		        		window.location.href=path+json.url;
		        	}else if(json.status==1){
		        		alert(json.msg);
		        	}
				}
			,"json");
		}
	}
}
</script>
<title>登录</title>
<style type="text/css">
body{
	margin: 0;
}
.main_div{
	width:100%;
	height:100vh;
	background: #001529;
	padding: 1px;
}
.login_div{
	width: 310px;
	height:220px;
	background: #fff;
	border-radius: 5px;
	margin: 215px auto 0;
	padding:20px 20px 20px 20px;
}
.hydl_h3{
	font-size: 16px;
	font-weight: 500;
}
.yhm_inp{
	width: 100%;
	height:25px;
}
.mm_inp{
	width: 100%;
	height:25px;
	margin-top: 25px;
}
.login_but_div{
	width: 100%;
	height:35px;
	line-height:35px;
	margin-top: 25px;
	text-align:center;
	font-size: 14px;
	color: #fff;
	background-color: #1890ff;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>
<div class="main_div">
	<div class="login_div">
		<h3 class="hydl_h3">欢迎登录</h3>
		<input class="yhm_inp" id="yhm_inp" type="text" placeholder="用户名" onfocus="focusYHM();" onblur="checkYHM();"/>
		<input class="mm_inp" id="mm_inp" type="password" placeholder="密码" onblur="checkMM()"/>
		<div class="login_but_div" onclick="login()">登录</div>
	</div>
</div>
</body>
</html>