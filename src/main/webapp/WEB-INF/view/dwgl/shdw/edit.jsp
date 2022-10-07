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
.mc_inp{
	width: 150px;
	height:30px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var dwglPath=path+'dwgl/';
var pdglPath=path+'pdgl/';
var dialogTop=70;
var dialogLeft=20;
var edNum=0;
var dlzt='${requestScope.dlzt}';
$(function(){
	initEditDialog();

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var edpw=$("body").find(".panel.window").eq(edNum);
	var edws=$("body").find(".window-shadow").eq(edNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(edpw);
	ccDiv.append(edws);
}

function initEditDialog(){
	dialogTop+=20;
	$("#edit_div").dialog({
		title:"收货单位信息",
		width:setFitWidthInParent("body","edit_div_table"),
		height:200,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"保存",id:"ok_but",iconCls:"icon-save",handler:function(){
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
	$("#edit_div table tr").css("height","45px");

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
	
	initDLCBB();
}

function initDLCBB(){
	var data=[];
	data.push({"value":"","text":"请选择队列"});
	$.post(pdglPath+"queryDuiLieCBBList",
		{zt:dlzt},
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			dlCBB=$("#dl_cbb").combobox({
				valueField:"value",
				textField:"text",
				//multiple:true,
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.shdw.dlId }');
				},
				onSelect:function(){
					$("#dlId").val($(this).combobox("getValue"));
				}
			});
		}
	,"json");
}

function checkEdit(){
	if(checkMC()){
		editShouHuoDanWei();
	}
}

function editShouHuoDanWei(){
	var dlId=dlCBB.combobox("getValue");
	var ywdl;
	if(dlId=="")
		ywdl=0;
	else
		ywdl=1;
	$("#ywdl").val(ywdl);
	
	var formData = new FormData($("#form1")[0]);
	$.ajax({
		type:"post",
		url:dwglPath+"editShouHuoDanWei",
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

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
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
<title>编辑</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">单位管理-收货单位-编辑</div>
		
		<div id="edit_div">
			<form id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${requestScope.shdw.id }"/>
			<input type="hidden" id="ywdl" name="ywdl" value="${requestScope.shdw.ywdl }"/>
			<table>
			  <tr>
				<td class="td1" align="right">
					名称
				</td>
				<td class="td2">
					<input type="text" class="mc_inp" id="mc" name="mc" value="${requestScope.shdw.mc }" placeholder="请输入名称" onfocus="focusMC()" onblur="checkMC()"/>
				</td>
				<td class="td1" align="right">
					队列
				</td>
				<td class="td2">
					<input id="dl_cbb"/>
					<input type="hidden" id="dlId" name="dlId"/>
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