<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.tab1_div{
	margin-top:80px;
	margin-left: 220px;
	position: fixed;
}
.tab1_div .toolbar{
	height:32px;
}
.tab1_div .toolbar .cph_span,
.tab1_div .toolbar .cllx_span,
.tab1_div .toolbar .sfzy_span,
.tab1_div .toolbar .shzt_span,
.tab1_div .toolbar .bz_span{
	margin-left: 13px;
}
.tab1_div .toolbar .cph_inp,
.tab1_div .toolbar .bz_inp{
	width: 120px;
	height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}

.output_excel_bg_div{
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,.45);
	position: fixed;
	z-index: 9016;
	display:none;
}

.output_excel_div{
	width: 500px;
	height: 210px;
	margin: 250px auto 0;
	background-color: #fff;
	border-radius:5px;
	position: absolute;
	left: 0;
	right: 0;
}
</style>
<title>车辆列表</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var clglPath=path+'clgl/';
var exportExcelPath=path+'exportExcel/';
var dialogTop=10;
var dialogLeft=20;
var oedNum=0;

var sheetFlag='${requestScope.sheetFlag}';

var shiSfzy;
var fouSfzy;

var shiSfzyMc;
var fouSfzyMc;

var dshShzt;
var shtgShzt;
var bjzShzt;

var dshShztMc;
var shtgShztMc;
var bjzShztMc;

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;
$(function(){
	initSfzyVar();
	initShztVar();
	initDcfwVar();
	
	initCLLXCBB();
	initSFZYCBB();
	initSHZTCBB();
	initSearchLB();
	initAddLB();
	initRemoveLB();
	initOutputBut();
	initTab1();
	
	initOutputExcelDialog();//0
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	
	showCompontByQx();
});

function showCompontByQx(){
	removeLB.hide();
	if(yhm=="admin"){
		removeLB.show();
	}
}

function initSfzyVar(){
	shiSfzy='${requestScope.shiSfzy}';
	fouSfzy='${requestScope.fouSfzy}';

	shiSfzyMc='${requestScope.shiSfzyMc}';
	fouSfzyMc='${requestScope.fouSfzyMc}';
}

function initShztVar(){
	dshShzt=parseInt('${requestScope.dshShzt}');
	shtgShzt=parseInt('${requestScope.shtgShzt}');
	bjzShzt=parseInt('${requestScope.bjzShzt}');

	dshShztMc='${requestScope.dshShztMc}';
	shtgShztMc='${requestScope.shtgShztMc}';
	bjzShztMc='${requestScope.bjzShztMc}';
}

function initDcfwVar(){
	dqyDcfw=parseInt('${requestScope.dqyDcfw}');
	syyDcfw=parseInt('${requestScope.syyDcfw}');

	dqyDcfwMc='${requestScope.dqyDcfwMc}';
	syyDcfwMc='${requestScope.syyDcfwMc}';
}

function initDialogPosition(){
	var oedpw=$("body").find(".panel.window").eq(oedNum);
	var oedws=$("body").find(".window-shadow").eq(oedNum);

	var oedDiv=$("#output_excel_div");
	oedDiv.append(oedpw);
	oedDiv.append(oedws);
}

function initCLLXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择车辆类型"});
	data.push({"value":"1","text":"重型"});
	cllxCBB=$("#cllx_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data
	});
}

function initSFZYCBB(){
	var data=[];
	data.push({"value":"","text":"请选择是否在用"});
	data.push({"value":"1","text":"是"});
	data.push({"value":"0","text":"否"});
	sfzyCBB=$("#sfzy_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data
	});
}

function initSHZTCBB(){
	var data=[];
	data.push({"value":"","text":"请选择审核状态"});
	data.push({"value":"1","text":"待审核 "});
	data.push({"value":"2","text":"审核通过"});
	data.push({"value":"3","text":"编辑中"});
	shztCBB=$("#shzt_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data
	});
}

function initOutputExcelDialog(){
	$("#output_excel_dialog_div").dialog({
		title:"导出excel",
		width:setFitWidthInParent("#output_excel_div","output_excel_dialog_div"),
		height:150,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"确定",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   if(checkDcfw()){
        		   	var params="";
        			var cph=encodeURIParam($("#toolbar #cph").val());
        			var cllx=cllxCBB.combobox("getValue");
        			var sfzy=sfzyCBB.combobox("getValue");
        			var shzt=shztCBB.combobox("getValue");
        			var bz=encodeURIParam($("#toolbar #bz").val());
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="cph="+cph+"&cllx="+cllx+"&sfzy="+sfzy+"&shzt="+shzt+"&bz="+bz+"&sheetFlag="+sheetFlag+"&dcfw="+dcfw;
        			if(dcfw==dqyDcfw){
	        			var options=tab1.datagrid("getPager").data("pagination").options;
	        			var page=options.pageNumber;
	        			var rows=options.pageSize;
	        			params+="&page="+page+"&rows="+rows;
        			}
        			location.href=exportExcelPath+"exportCheLiangList?"+params;
             	   	openOutputExcelDialog(false);
        	   }
           }},
           {text:"取消",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openOutputExcelDialog(false);
           }}
        ]
	});

	$("#output_excel_dialog_div table").css("width",(setFitWidthInParent("#output_excel_div","output_excel_dialog_table"))+"px");
	$("#output_excel_dialog_div table").css("magin","-100px");
	$("#output_excel_dialog_div table td").css("padding-left","40px");
	$("#output_excel_dialog_div table td").css("padding-right","20px");
	$("#output_excel_dialog_div table td").css("font-size","15px");
	$("#output_excel_dialog_div table .td1").css("width","30%");
	$("#output_excel_dialog_div table .td2").css("width","60%");
	$("#output_excel_dialog_div table tr").css("height","45px");

	$(".panel.window").eq(oedNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(oedNum).css("color","#000");
	$(".panel.window .panel-title").eq(oedNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(oedNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(oedNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(oedNum).css("border-color","#ddd");

	$("#output_excel_dialog_div #ok_but").css("left","30%");
	$("#output_excel_dialog_div #ok_but").css("position","absolute");

	$("#output_excel_dialog_div #cancel_but").css("left","50%");
	$("#output_excel_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initDcfwCBB();
}

function initDcfwCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":dqyDcfw,"text":dqyDcfwMc});
	data.push({"value":syyDcfw,"text":syyDcfwMc});
	dcfwCBB=$("#dcfw_cbb").combobox({
		width:120,
		valueField:"value",
		textField:"text",
		data:data
	});
}

//验证导出范围
function checkDcfw(){
	var dcfw=dcfwCBB.combobox("getValue");
	if(dcfw==null||dcfw==""){
	  	alert("请选择导出范围");
	  	return false;
	}
	else
		return true;
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var cph=$("#toolbar #cph").val();
			var cllx=cllxCBB.combobox("getValue");
			var sfzy=sfzyCBB.combobox("getValue");
			var shzt=shztCBB.combobox("getValue");
			var bz=$("#toolbar #bz").val();
			tab1.datagrid("load",{cph:cph,cllx:cllx,sfzy:sfzy,shzt:shzt,bz:bz});
		}
	});
}

function initAddLB(){
	$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=clglPath+"zhcx/new";
		}
	});
}

function initRemoveLB(){
	removeLB=$("#remove_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			deleteByIds();
		}
	});
}

function initOutputBut(){
	opBut=$("#output_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			openOutputExcelDialog(true);
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"车辆管理-综合查询-车辆列表",
		url:clglPath+"queryCheLiangList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"cph",title:"车牌号",width:200},
            {field:"ppxh",title:"品牌型号",width:200},
			{field:"fdjhm",title:"发动机号码",width:200},
			{field:"clsbdm",title:"车辆识别代号",width:200},
			{field:"zcrq",title:"注册日期",width:200},
			{field:"pfjd",title:"排放阶段",width:200,formatter:function(value){
				var str;
				switch (value) {
				case 1:
					str="国五燃油";
					break;
				case 2:
					str="国五燃气";
					break;
				case 3:
					str="国六燃油";
					break;
				case 4:
					str="国六燃气";
					break;
				case 5:
					str="电动";
					break;
				}
				return str;
			}},
			{field:"fzrq",title:"发证日期",width:200},
			{field:"sfzy",title:"是否在用",width:100,formatter:function(value){
				return getSfzyMcById(value);
			}},
			{field:"shzt",title:"状态",width:100,formatter:function(value){
				return getShztMcById(value);
			}},
			{field:"bz",title:"备注",width:200},
            {field:"id",title:"操作",width:150,formatter:function(value,row){
            	var str="<a href=\""+clglPath+"zhcx/detail?id="+value+"\">详情</a>"
            	+"&nbsp;|&nbsp;<a href=\""+clglPath+"zhcx/edit?id="+value+"\">修改</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{cph:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"cph",colspan:11});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");

			$(".datagrid-header td .datagrid-cell").each(function(){
				$(this).find("span").eq(0).css("margin-left","11px");
			});
			$(".datagrid-body td .datagrid-cell").each(function(){
				var html=$(this).html();
				$(this).html("<span style=\"margin-left:11px;\">"+html+"</span>");
			});
		}
	});
}

function openOutputExcelDialog(flag){
	if(flag){
		$("#output_excel_bg_div").css("display","block");
	}
	else{
		$("#output_excel_bg_div").css("display","none");
	}
}

function getSfzyMcById(sfzy){
	var str;
	if(sfzy)
		str=shiSfzyMc;
	else
		str=fouSfzyMc;
	return str;
}

function getShztMcById(shztId){
	var str;
	switch (shztId) {
	case dshShzt:
		str=dshShztMc;//待审核
		break;
	case shtgShzt:
		str=shtgShztMc;//审核通过
		break;
	case bjzShzt:
		str=bjzShztMc;//编辑中
		break;
	}
	return str;
}

function deleteByIds() {
	var rows=tab1.datagrid("getSelections");
	if (rows.length == 0) {
		$.messager.alert("提示","请选择要删除的信息！","warning");
		return false;
	}
	
	$.messager.confirm("提示","确定要删除吗？",function(r){
		if(r){
			var ids = "";
			for (var i = 0; i < rows.length; i++) {
				ids += "," + rows[i].id;
			}
			ids=ids.substring(1);
			
			$.ajaxSetup({async:false});
			$.post(clglPath + "deleteCheLiang",
				{ids:ids},
				function(result){
					if(result.status==1){
						alert(result.msg);
						tab1.datagrid("load");
					}
					else{
						alert(result.msg);
					}
				}
			,"json");
			
		}
	});
}

function encodeURIParam(val){
	return encodeURI(encodeURI(val));
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "tab1_div":
		space=250;
		break;
	case "output_excel_dialog_div":
		space=50;
		break;
	case "output_excel_dialog_table":
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
	<%@include file="../../inc/side.jsp"%>
	<div class="tab1_div" id="tab1_div">
		<div class="toolbar" id="toolbar">
			<span class="cph_span">车牌号：</span>
			<input type="text" class="cph_inp" id="cph" placeholder="请输入车牌号"/>
			<span class="cllx_span">车辆类型：</span>
			<input id="cllx_cbb"/>
			<span class="sfzy_span">是否在用：</span>
			<input id="sfzy_cbb"/>
			<span class="shzt_span">审核状态：</span>
			<input id="shzt_cbb"/>
			<span class="bz_span">备注：</span>
			<input type="text" class="bz_inp" id="bz" placeholder="请输入备注"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="add_but">添加</a>
			<a id="remove_but">删除</a>
         	<a id="output_but">导出</a>
		</div>
		<table id="tab1">
		</table>
	</div>
	
	<div class="output_excel_bg_div" id="output_excel_bg_div">
		<div class="output_excel_div" id="output_excel_div">
			<div class="output_excel_dialog_div" id="output_excel_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						导出范围
					</td>
					<td class="td2">
						<input id="dcfw_cbb"/>
					</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>