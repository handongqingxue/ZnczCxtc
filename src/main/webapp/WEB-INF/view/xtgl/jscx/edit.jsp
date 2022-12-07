<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
.mc_inp,.px_inp{
	width: 150px;
	height:30px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var xtglPath=path+'xtgl/';
var dialogTop=70;
var dialogLeft=20;
var edNum=0;

var xzZt;
var zcsyZt;
var fqZt;
var ywZt;

var xzZtMc;
var zcsyZtMc;
var fqZtMc;
var ywZtMc;
$(function(){
	initZtVar();
	
	initEditDialog();//0

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var edpw=$("body").find(".panel.window").eq(edNum);
	var edws=$("body").find(".window-shadow").eq(edNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(edpw);
	ccDiv.append(edws);
	ccDiv.css("width",setFitWidthInParent("body","center_con_div")+"px");
}

function initZtVar(){
	xzZt=parseInt('${requestScope.xzZt}');
	zcsyZt=parseInt('${requestScope.zcsyZt}');
	fqZt=parseInt('${requestScope.fqZt}');
	ywZt=parseInt('${requestScope.ywZt}');

	xzZtMc='${requestScope.xzZtMc}';
	zcsyZtMc='${requestScope.zcsyZtMc}';
	fqZtMc='${requestScope.fqZtMc}';
	ywZtMc='${requestScope.ywZtMc}';
}

function initEditDialog(){
	dialogTop+=20;
	$("#edit_div").dialog({
		title:"角色信息",
		width:setFitWidthInParent("body","edit_div"),
		height:240,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"保存",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkEdit();
           }}
        ]
	});

	$("#edit_div table").css("width",(setFitWidthInParent("body","edit_div_table"))+"px");
	$("#edit_div table").css("magin","-100px");
	$("#edit_div table td").css("padding-left","50px");
	$("#edit_div table td").css("padding-right","20px");
	$("#edit_div table td").css("font-size","15px");
	$("#edit_div table .td1").css("width","15%");
	$("#edit_div table .td2").css("width","30%");
	$("#edit_div table tr").css("border-bottom","#CAD9EA solid 1px");
	$("#edit_div table tr").each(function(i){
		$(this).css("height",(i==1?90:45)+"px");
	});

	$(".panel.window").eq(edNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(edNum).css("color","#000");
	$(".panel.window .panel-title").eq(edNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(edNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(edNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(edNum).css("border-color","#ddd");

	$("#edit_div #ok_but").css("left","45%");
	$("#edit_div #ok_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initZtCBB();
	initQXCBB();
}

function initZtCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":xzZt,"text":xzZtMc});
	data.push({"value":zcsyZt,"text":zcsyZtMc});
	data.push({"value":fqZt,"text":fqZtMc});
	data.push({"value":ywZt,"text":ywZtMc});
	
	ztCBB=$("#edit_div #zt_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.js.zt }');
		}
	});
}

function initQXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	$.post(xtglPath+"queryQuanXianCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			qxCBB=$("#edit_div #qx_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				multiple:true,
				onLoadSuccess:function(){
					$(this).combobox("setValues",'${requestScope.js.qxIds }'.split(","));
				}
			});
		}
	,"json");
}

function checkEdit(){
	if(checkMC()){
		if(checkZt()){
			if(checkQxIds()){
				editJueSe();
			}
		}
	}
}

function editJueSe(){
	var zt=ztCBB.combobox("getValue");
	$("#zt").val(zt);
	var qxIds=qxCBB.combobox("getValues");
	$("#qxIds").val(String(qxIds));
	
	var formData = new FormData($("#form1")[0]);
	$.ajax({
		type:"post",
		url:xtglPath+"editJueSe",
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

//验证状态
function checkZt(){
	var zt=ztCBB.combobox("getValue");
	if(zt==null||zt==""){
	  	alert("请选择状态");
	  	return false;
	}
	else
		return true;
}

//验证权限
function checkQxIds(){
	var qxIdArr=qxCBB.combobox("getValues");
	var qxIds=String(qxIdArr);
	if(qxIds==null||qxIds==""){
	  	alert("请选择权限");
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
	case "edit_div":
		space=340;
		break;
	case "edit_div_table":
	case "panel_window":
		space=355;
		break;
	}
	var width=$(parent).css("width");
	return width.substring(0,width.length-2)-space;
}
</script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">系统管理-角色-编辑</div>
		
		<div id="edit_div">
			<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${requestScope.js.id }"/>
			<table>
			  <tr>
				<td class="td1" align="right">
					名称
				</td>
				<td class="td2">
					<input type="text" class="mc_inp" id="mc" name="mc" value="${requestScope.js.mc }" placeholder="请输入名称" onfocus="focusMC()" onblur="checkMC()"/>
				</td>
				<td class="td1" align="right">
					状态
				</td>
				<td class="td2">
					<input id="zt_cbb"/>
					<input type="hidden" id="zt" name="zt" value="${requestScope.js.zt }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					权限
				</td>
				<td class="td2">
					<input id="qx_cbb"/>
					<input type="hidden" id="qxIds" name="qxIds" value="${requestScope.js.qxIds }"/>
				</td>
				<td class="td1" align="right">
					描述
				</td>
				<td class="td2">
					<textarea id="ms" name="ms" rows="3" cols="30" placeholder="请输入描述">${requestScope.js.ms }</textarea>
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