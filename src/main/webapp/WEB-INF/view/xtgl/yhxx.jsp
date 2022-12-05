<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="../inc/js.jsp"%>
<style type="text/css">
.center_con_div{
	height: 90vh;
	margin-left:205px;
	position: absolute;
}
.page_location_div{
	height: 50px;
	line-height: 50px;
	margin-top: 60px;
	margin-left: 20px;
	font-size: 18px;
}
.uploadBut_div{
	line-height:30px;
	text-align:center;
	color:#fff;
	background-color: #1777FF;
	border-radius:5px;
	cursor: pointer;
}
.xgmmBut_div{
	width: 90px;
	height: 30px;
	margin-top:-25px;
	margin-left: 100px;
}

.xgmm_bg_div{
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,.45);
	position: fixed;
	z-index: 9016;
	display:none;
}

.xgmm_div{
	width: 500px;
	height: 310px;
	margin: 250px auto 0;
	background-color: #fff;
	border-radius:5px;
	position: absolute;
	left: 0;
	right: 0;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var mainPath=path+'main/';
var xtglPath=path+'xtgl/';
var dialogTop=70;
var dialogLeft=20;
var yhxxdNum=0;
var xgmmdNum=1;
$(function(){
	initYhxxDialog();//0
	
	initXgmmDialog();//1
	
	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var yhxxdpw=$("body").find(".panel.window").eq(yhxxdNum);
	var yhxxws=$("body").find(".window-shadow").eq(yhxxdNum);
	
	var xgmmdpw=$("body").find(".panel.window").eq(xgmmdNum);
	var xgmmdws=$("body").find(".window-shadow").eq(xgmmdNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(yhxxdpw);
	ccDiv.append(yhxxws);
	ccDiv.css("width",setFitWidthInParent("body","center_con_div")+"px");

	var oedDiv=$("#xgmm_div");
	oedDiv.append(xgmmdpw);
	oedDiv.append(xgmmdws);
}

function initYhxxDialog(){
	dialogTop+=20;
	$("#yhxx_div").dialog({
		title:"用户信息",
		width:setFitWidthInParent("body","yhxx_div"),
		height:280,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"修改用户信息",id:"xgyhxx_but",iconCls:"icon-save",handler:function(){
        	   	//checkEdit();
           }}
        ]
	});

	$("#yhxx_div table").css("width",(setFitWidthInParent("body","yhxx_div_table"))+"px");
	$("#yhxx_div table").css("magin","-100px");
	$("#yhxx_div table td").css("padding-left","50px");
	$("#yhxx_div table td").css("padding-right","20px");
	$("#yhxx_div table td").css("font-size","15px");
	$("#yhxx_div table .td1").css("width","15%");
	$("#yhxx_div table .td2").css("width","30%");
	$("#yhxx_div table tr").css("border-bottom","#CAD9EA solid 1px");
	$("#yhxx_div table tr").each(function(i){
		$(this).css("height",(i==2?90:45)+"px");
	});

	$(".panel.window").eq(yhxxdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(yhxxdNum).css("color","#000");
	$(".panel.window .panel-title").eq(yhxxdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(yhxxdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(yhxxdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(yhxxdNum).css("border-color","#ddd");

	$("#yhxx_div #xgyhxx_but").css("left","45%");
	$("#yhxx_div #xgyhxx_but").css("position","absolute");
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");
}

function openXgmmDialog(flag){
	if(flag){
		$("#xgmm_bg_div").css("display","block");
	}
	else{
		$("#xgmm_bg_div").css("display","none");
	}
}

function initXgmmDialog(){
	$("#xgmm_dialog_div").dialog({
		title:"修改密码",
		width:setFitWidthInParent("#xgmm_div","xgmm_dialog_div"),
		height:250,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"确定",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkEditMm();
           }},
           {text:"取消",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openXgmmDialog(false);
           }}
        ]
	});

	$("#xgmm_dialog_div table").css("width",(setFitWidthInParent("#xgmm_div","xgmm_dialog_table"))+"px");
	$("#xgmm_dialog_div table").css("magin","-100px");
	$("#xgmm_dialog_div table td").css("padding-left","40px");
	$("#xgmm_dialog_div table td").css("padding-right","20px");
	$("#xgmm_dialog_div table td").css("font-size","15px");
	$("#xgmm_dialog_div table .td1").css("width","30%");
	$("#xgmm_dialog_div table .td2").css("width","60%");
	$("#xgmm_dialog_div table tr").css("height","45px");

	$(".panel.window").eq(xgmmdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(xgmmdNum).css("color","#000");
	$(".panel.window .panel-title").eq(xgmmdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(xgmmdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(xgmmdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(xgmmdNum).css("border-color","#ddd");

	$("#xgmm_dialog_div #ok_but").css("left","30%");
	$("#xgmm_dialog_div #ok_but").css("position","absolute");

	$("#xgmm_dialog_div #cancel_but").css("left","50%");
	$("#xgmm_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

}

function checkEditMm(){
	if(checkMm()){
		if(checkXmm()){
			if(checkXmm2()){
				var mm = $("#xmm").val();
				$.post(xtglPath+"updateMmByYhId",
					//{xmm:MD5(xmm).toUpperCase()},
					{mm:mm},
					function(result){
						openXgmmDialog(false);
						var json=JSON.parse(result);
						if(json.status==1){
							$.messager.defaults.ok = "是";
						    $.messager.defaults.cancel = "否";
						    $.messager.defaults.width = 350;//更改消息框宽度
						    $.messager.confirm(
						    	"提示",
						    	"修改密码成功，重新登录生效！是否重新登录？"
						        ,function(r){    
						            if (r){    
						                location.href=mainPath+"exit";
						            }
						        }); 
						}
						else{
							$.messager.alert("提示","修改密码失败","warning");
						}
					}
				);
			}
		}
	}
}

//验证原密码
function checkMm(){
	var flag=false;
	var yhm='${sessionScope.yongHu.yhm}';
	var mm = $("#mm").val();
	if(mm==null||mm==""){
  	alert("原密码不能为空");
  	flag=false;
	}
	else{
		$.ajaxSetup({async:false});
		$.post(xtglPath+"checkMm",
			//{passWord:MD5(passWord).toUpperCase(),yhm:yhm},
			{mm:mm,yhm:yhm},
			function(data){
				if(data.status=="ok"){
					flag=true;
				}
				else{
					alert(data.message);
					flag=false;
				}
			}
		,"json");
	}
	return flag;
}

//验证新密码
function checkXmm(){
	var mm = $("#mm").val();
	var xmm = $("#xmm").val();
	if(xmm==null||xmm==""){
  	alert("新密码不能为空");
  	return false;
	}
	if(xmm==mm){
		alert("新密码不能和原密码一致！");
  	return false;
	}
	else
		return true;
}

//验证确认密码
function checkXmm2(){
	var xmm = $("#xmm").val();
	var xmm2 = $("#xmm2").val();
	if(xmm2==null||xmm2==""){
  	alert("确认密码不能为空");
  	return false;
	}
	else if(xmm!=xmm2){
		alert("两次密码不一致！");
  	return false;
	}
	else
		return true;
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "center_con_div":
		space=205;
		break;
	case "yhxx_div":
		space=340;
		break;
	case "yhxx_div_table":
	case "panel_window":
		space=355;
		break;
	case "xgmm_dialog_div":
		space=50;
		break;
	case "xgmm_dialog_table":
		space=68;
		break;
	}
	var width=$(parent).css("width");
	return width.substring(0,width.length-2)-space;
}
</script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">系统管理-用户信息</div>
		
		<div id="yhxx_div">
			<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
			<table>
			  <tr>
				<td class="td1" align="right">
					用户名
				</td>
				<td class="td2">
					${requestScope.yongHu.yhm }
				</td>
				<td class="td1" align="right">
					昵称
				</td>
				<td class="td2">
					${requestScope.yongHu.nc }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					姓名
				</td>
				<td class="td2">
					${requestScope.yongHu.xm }
				</td>
				<td class="td1" align="right">
					密码
				</td>
				<td class="td2">
					已设置
					<div class="uploadBut_div xgmmBut_div" onclick="openXgmmDialog(true)">修改密码</div>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					简述
				</td>
				<td class="td2">
					${requestScope.yongHu.js }
				</td>
				<td class="td1" align="right">
				</td>
				<td class="td2">
				</td>
			  </tr>
			</table>
			</form>
		</div>

		<%@include file="../inc/foot.jsp"%>
	</div>
	
	<div class="xgmm_bg_div" id="xgmm_bg_div">
		<div class="xgmm_div" id="xgmm_div">
			<div class="xgmm_dialog_div" id="xgmm_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						原密码
					</td>
					<td class="td2">
						<input type="password" id="mm" placeholder="原密码"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						新密码
					</td>
					<td class="td2">
						<input type="password" id="xmm" placeholder="新密码"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						确认密码
					</td>
					<td class="td2">
						<input type="password" id="xmm2" placeholder="确认密码"/>
					</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>