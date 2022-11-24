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
}
.tab1_div .toolbar{
	height:32px;
}
.tab1_div .toolbar .ddh_span,
.tab1_div .toolbar .cph_span,
.tab1_div .toolbar .gbsj_span{
	margin-left: 13px;
}
.tab1_div .toolbar .ddh_inp,
.tab1_div .toolbar .cph_inp{
	width: 120px;
	height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
</style>
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var gbglPath=path+'gbgl/';
var exportExcelPath=path+'exportExcel/';

var zcGbzt;
var ycGbzt;

var zcGbztMc;
var ycGbztMc;

var rcgbGblx;
var ccgbGblx;

var rcgbGblxMc;
var ccgbGblxMc;
$(function(){
	initGbztVar();
	initGblxVar();
	
	initGBSJKSDTB();
	initGBSJJSDTB();
	initSearchLB();
	initAddLB();
	initOutputBut();
	initTab1();
});

function initGbztVar(){
	zcGbzt=parseInt('${requestScope.zcGbzt}');
	ycGbzt=parseInt('${requestScope.ycGbzt}');

	zcGbztMc='${requestScope.zcGbztMc}';
	ycGbztMc='${requestScope.ycGbztMc}';
}

function initGblxVar(){
	rcgbGblx=parseInt('${requestScope.rcgbGblx}');
	ccgbGblx=parseInt('${requestScope.ccgbGblx}');

	rcgbGblxMc='${requestScope.rcgbGblxMc}';
	ccgbGblxMc='${requestScope.ccgbGblxMc}';
}

function initGBSJKSDTB(){
	gbsjksDTB=$("#gbsjks_dtb").datetimebox({
        required:false
    });
}

function initGBSJJSDTB(){
	gbsjjsDTB=$("#gbsjjs_dtb").datetimebox({
        required:false
    });
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var ddh=$("#toolbar #ddh").val();
			var cph=$("#toolbar #cph").val();
			var gbsjks=gbsjksDTB.datetimebox("getValue");
			var gbsjjs=gbsjjsDTB.datetimebox("getValue");
			tab1.datagrid("load",{ddh:ddh,cph:cph,gbsjks:gbsjks,gbsjjs:gbsjjs});
		}
	});
}

function initAddLB(){
	$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=gbglPath+"gbjl/new";
		}
	});
}

function initOutputBut(){
	opBut=$("#output_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			location.href=exportExcelPath+"exportGBJLList";
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"过磅管理-过磅记录-列表",
		url:gbglPath+"queryGBJLList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:150},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"gbzl",title:"过磅重量",width:200},
			{field:"gbzt",title:"过磅状态",width:100,formatter:function(value,row){
				return getGbztMcById(value);
			}},
            {field:"gblx",title:"过磅类型",width:100,formatter:function(value,row){
            	return getGblxMcById(value);
            }},
            {field:"gbsj",title:"过磅时间",width:150},
            {field:"id",title:"操作",width:110,formatter:function(value,row){
            	var str="<a href=\"edit?id="+value+"\">编辑</a>&nbsp;&nbsp;"
            		+"<a href=\"detail?id="+value+"\">详情</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:7});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");
		}
	});
}

function getGbztMcById(gbztId){
	var str;
	switch (gbztId) {
	case zcGbzt:
		str=zcGbztMc;//正常
		break;
	case ycGbzt:
		str=ycGbztMc;//异常
		break;
	}
	return str;
}

function getGblxMcById(gblxId){
	var str;
	switch (gblxId) {
	case rcgbGblx:
		str=rcgbGblxMc;//入厂过磅
		break;
	case ccgbGblx:
		str=ccgbGblxMc;//出厂过磅
		break;
	}
	return str;
}

function setFitWidthInParent(o){
	var width=$(o).css("width");
	return width.substring(0,width.length-2)-250;
}
</script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="tab1_div" id="tab1_div">
		<div class="toolbar" id="toolbar">
			<span class="ddh_span">订单号：</span>
			<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
			<span class="cph_span">车牌号：</span>
			<input type="text" class="cph_inp" id="cph" placeholder="请输入车牌号"/>
			<span class="gbsj_span">过磅时间：</span>
			<input id="gbsjks_dtb"/>-
			<input id="gbsjjs_dtb"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="add_but">添加</a>
         	<a id="output_but">导出</a>
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>