<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../inc/js.jsp"%>
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
.mc_inp,.dm_inp{
	width: 150px;
	height:30px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var pdglPath=path+'pdgl/';
var dialogTop=70;
var dialogLeft=20;
var ndNum=0;
$(function(){
	initNewDialog();

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var ndpw=$("body").find(".panel.window").eq(ndNum);
	var ndws=$("body").find(".window-shadow").eq(ndNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(ndpw);
	ccDiv.append(ndws);
}

function initNewDialog(){
	dialogTop+=20;
	$("#new_div").dialog({
		title:"队列信息",
		width:setFitWidthInParent("body","new_div_table"),
		height:260,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"保存",id:"ok_but",iconCls:"icon-save",handler:function(){
        	   	checkNew();
           }}
        ]
	});

	$("#new_div table").css("width",(setFitWidthInParent("body","new_div_table"))+"px");
	$("#new_div table").css("magin","-100px");
	$("#new_div table td").css("padding-left","50px");
	$("#new_div table td").css("padding-right","20px");
	$("#new_div table td").css("font-size","15px");
	$("#new_div table .td1").css("width","15%");
	$("#new_div table .td2").css("width","30%");
	$("#new_div table tr").css("border-bottom","#CAD9EA solid 1px");
	$("#new_div table tr").css("height","45px");

	$(".panel.window").eq(ndNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(ndNum).css("color","#000");
	$(".panel.window .panel-title").eq(ndNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(ndNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(ndNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(ndNum).css("border-color","#ddd");

	$("#new_div #ok_but").css("left","45%");
	$("#new_div #ok_but").css("position","absolute");
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");
	
	initJHXSCBB();
	initZTCBB();
}

function initJHXSCBB(){
	var data=[];
	data.push({"value":"","text":"请选择叫号形式"});
	data.push({"value":"1","text":"自动叫号"});
	data.push({"value":"2","text":"手动叫号"});
	
	jhxsCBB=$("#jhxs_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onSelect:function(){
			$("#jhxs").val($(this).combobox("getValue"));
		}
	});
}

function initZTCBB(){
	var data=[];
	data.push({"value":"","text":"请选择状态"});
	data.push({"value":"1","text":"在用"});
	data.push({"value":"2","text":"暂停"});
	data.push({"value":"3","text":"废弃"});
	
	ztCBB=$("#zt_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onSelect:function(){
			$("#zt").val($(this).combobox("getValue"));
		}
	});
}

function checkNew(){
	if(checkMC()){
		if(checkDM()){
			if(checkJHXS()){
				if(checkJHYZ()){
					if(checkZT()){
						newDuiLie();
					}
				}
			}
		}
	}
}

function newDuiLie(){
	var formData = new FormData($("#form1")[0]);
	$.ajax({
		type:"post",
		url:pdglPath+"newDuiLie",
		dataType: "json",
		data:formData,
		cache: false,
		processData: false,
		contentType: false,
		success: function (data){
			if(data.message=="ok"){
				alert(data.info);
				history.go(-1);
			}
			else{
				alert(data.info);
			}
		}
	});
}

function focusMC(){
	var mc = $("#mc").val();
	if(mc=="名称不能为空"){
		$("#mc").val("");
		$("#mc").css("color", "#555555");
	}
}

//验证名称
function checkMC(){
	var mc = $("#mc").val();
	if(mc==null||mc==""||mc=="名称不能为空"){
		$("#mc").css("color","#E15748");
    	$("#mc").val("名称不能为空");
    	return false;
	}
	else
		return true;
}

function focusDM(){
	var dm = $("#dm").val();
	if(dm=="代码不能为空"){
		$("#dm").val("");
		$("#dm").css("color", "#555555");
	}
}

//验证代码
function checkDM(){
	var dm = $("#dm").val();
	if(dm==null||dm==""||dm=="代码不能为空"){
		$("#dm").css("color","#E15748");
    	$("#dm").val("代码不能为空");
    	return false;
	}
	else
		return true;
}

//验证叫号形式
function checkJHXS(){
	var jhxs=jhxsCBB.combobox("getValue");
	if(jhxs==null||jhxs==""){
	  	alert("请选择叫号形式");
	  	return false;
	}
	else
		return true;
}

function focusJHYZ(){
	var jhyz = $("#jhyz").val();
	if(jhyz=="叫号阈值不能为空"){
		$("#jhyz").val("");
		$("#jhyz").css("color", "#555555");
	}
}

//验证叫号阈值
function checkJHYZ(){
	var jhyz = $("#jhyz").val();
	if(jhyz==null||jhyz==""||jhyz=="叫号阈值不能为空"){
		$("#jhyz").css("color","#E15748");
  		$("#jhyz").val("叫号阈值不能为空");
  		return false;
	}
	else
		return true;
}

//验证状态
function checkZT(){
	var zt=ztCBB.combobox("getValue");
	if(zt==null||zt==""){
	  	alert("请选择状态");
	  	return false;
	}
	else
		return true;
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "new_div":
		space=340;
		break;
	case "new_div_table":
	case "panel_window":
		space=355;
		break;
	}
	var width=$(parent).css("width");
	return width.substring(0,width.length-2)-space;
}
</script>
<title>创建</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">队列-创建</div>
		
		<div id="new_div">
		<form id="form1" name="form1" method="post" enctype="multipart/form-data">
			<table>
			  <tr>
				<td class="td1" align="right">
					名称
				</td>
				<td class="td2">
					<input type="text" class="mc_inp" id="mc" name="mc" placeholder="请输入名称" onfocus="focusMC()" onblur="checkMC()"/>
				</td>
				<td class="td1" align="right">
					代码
				</td>
				<td class="td2">
					<input type="text" class="dm_inp" id="dm" name="dm" placeholder="请输入代码" onfocus="focusDM()" onblur="checkDM()"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					叫号形式
				</td>
				<td class="td2">
					<input id="jhxs_cbb"/>
					<input type="hidden" id="jhxs" name="jhxs"/>
				</td>
				<td class="td1" align="right">
					叫号阈值
				</td>
				<td class="td2">
					<input type="text" class="jhyz_inp" id="jhyz" name="jhyz" placeholder="请输入叫号阈值" onfocus="focusJHYZ()" onblur="checkJHYZ()"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					状态
				</td>
				<td class="td2">
					<input id="zt_cbb"/>
					<input type="hidden" id="zt" name="zt"/>
				</td>
				<td class="td1" align="right">
				</td>
				<td class="td2">
				</td>
			  </tr>
			</table>
		</form>
		</div>
		<%@include file="../../inc/foot.jsp"%>
	</div>
</div>
</body>
</html>