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
	height:64px;
}
.tab1_div .toolbar .row_div{
	height:32px;
}
.tab1_div .toolbar .row_div .ddh_span,
.tab1_div .toolbar .row_div .cysjXm_span,
.tab1_div .toolbar .row_div .cysjSfzh_span,
.tab1_div .toolbar .row_div .cyclCph_span,
.tab1_div .toolbar .row_div .yss_span,
.tab1_div .toolbar .row_div .fhdw_span,
.tab1_div .toolbar .row_div .gbsj_span,
.tab1_div .toolbar .row_div .shdw_span,
.tab1_div .toolbar .row_div .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .row_div .ddh_inp,
.tab1_div .toolbar .row_div .cysjXm_inp,
.tab1_div .toolbar .row_div .cysjSfzh_inp,
.tab1_div .toolbar .row_div .cyclCph_inp,
.tab1_div .toolbar .row_div .yssMc_inp,
.tab1_div .toolbar .row_div .fhdwMc_inp,
.tab1_div .toolbar .row_div .shdwMc_inp{
	width: 120px;
	height: 25px;
}
</style>
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var gbglPath=path+'gbgl/';
var ddglPath=path+'ddgl/';
var exportExcelPath=path+'exportExcel/';
var defaultDdztMc='${requestScope.yjdshDdztMc}';
var defaultGblx='${requestScope.rcgbGblx}';
var yjshShlx='${requestScope.yjshShlx}';
var shrId='${sessionScope.yongHu.id}';

var syLxlx;
var qyLxlx;

var syLxlxMc;
var qyLxlxMc;

var zcGbzt;
var ycGbzt;

var zcGbztMc;
var ycGbztMc;
$(function(){
	initLxlxVar();
	initGbztVar();
	
	initGBSJKSDTB();
	initGBSJJSDTB();
	initSearchLB();
	initCheckLB();
	initSHBTGLB();
	initTab1();
});

function initLxlxVar(){
	syLxlx=parseInt('${requestScope.syLxlx}');
	qyLxlx=parseInt('${requestScope.qyLxlx}');

	syLxlxMc='${requestScope.syLxlxMc}';
	qyLxlxMc='${requestScope.qyLxlxMc}';
}

function initGbztVar(){
	zcGbzt=parseInt('${requestScope.zcGbzt}');
	ycGbzt=parseInt('${requestScope.ycGbzt}');

	zcGbztMc='${requestScope.zcGbztMc}';
	ycGbztMc='${requestScope.ycGbztMc}';
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
			var cysjXm=$("#toolbar #cysjXm").val();
			var cysjSfzh=$("#toolbar #cysjSfzh").val();
			var cyclCph=$("#toolbar #cyclCph").val();
			var yssMc=$("#toolbar #yssMc").val();
			var fhdwMc=$("#toolbar #fhdwMc").val();
			var shdwMc=$("#toolbar #shdwMc").val();
			var gbsjks=gbsjksDTB.datetimebox("getValue");
			var gbsjjs=gbsjjsDTB.datetimebox("getValue");
			tab1.datagrid("load",{ddztMc:defaultDdztMc,ddh:ddh,cysjXm:cysjXm,cysjSfzh:cysjSfzh,cyclCph:cyclCph,yssMc:yssMc,fhdwMc:fhdwMc,shdwMc:shdwMc,gbsjks:gbsjks,gbsjjs:gbsjjs,gblx:defaultGblx});
		}
	});
}

function initCheckLB(){
	$("#check_but").linkbutton({
		iconCls:"icon-ok",
		onClick:function(){
			checkByIds(true);
		}
	});
}

function initSHBTGLB(){
	$("#shbtg_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			checkByIds(false);
		}
	});
}

function checkByIds(shjg) {
	var rows=tab1.datagrid("getSelections");
	if (rows.length == 0) {
		$.messager.alert("提示","请选择要审核的信息！","warning");
		return false;
	}
	
	var ddIds = "";
	for (var i = 0; i < rows.length; i++) {
		ddIds += "," + rows[i].ddId;
	}
	ddIds=ddIds.substring(1);
	
	var dzxhDdztMc='${requestScope.dzxhDdztMc}';
	$.post(ddglPath + "checkDingDanByIds",
		{ids:ddIds,ddztMc:dzxhDdztMc,shlx:yjshShlx,shjg:shjg,shrId:shrId,jyFlag:1},
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

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"过磅管理-一检待审核-列表",
		url:gbglPath+"queryDJYList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		queryParams:{ddztMc:defaultDdztMc,gblx:defaultGblx},
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:150},
			{field:"cysjXm",title:"司机姓名",width:100},
			{field:"cysjSfzh",title:"司机身份证号",width:200},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"yssMc",title:"运输商",width:150},
			{field:"fhdwMc",title:"发货单位",width:150},
			{field:"shdwMc",title:"收货单位",width:150},
            {field:"lxlx",title:"流向类型",width:100,formatter:function(value,row){
            	return getLxlxMcById(value);
            }},
			{field:"gbzl",title:"过磅重量",width:200},
			{field:"gbzt",title:"过磅状态",width:100,formatter:function(value,row){
				return getGbztMcById(value);
			}},
            {field:"gbsj",title:"过磅时间",width:150},
            {field:"id",title:"操作",width:50,formatter:function(value,row){
            	//var str="<a href=\"detail?id="+value+"\">详情</a>";
            	//return str;
            	return "";
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:12});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");
		}
	});
}

function getLxlxMcById(lxlxId){
	var str;
	switch (lxlxId) {
	case syLxlx:
		str=syLxlxMc;//送运
		break;
	case qyLxlx:
		str=qyLxlxMc;//取运
		break;
	}
	return str;
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
			<div class="row_div">
				<span class="ddh_span">订单号：</span>
				<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
				<span class="cysjXm_span">司机姓名：</span>
				<input type="text" class="cysjXm_inp" id="cysjXm" placeholder="请输入司机姓名"/>
				<span class="cysjSfzh_span">司机身份证号：</span>
				<input type="text" class="cysjSfzh_inp" id="cysjSfzh" placeholder="请输入司机身份证号"/>
				<span class="cyclCph_span">车牌号：</span>
				<input type="text" class="cyclCph_inp" id="cyclCph" placeholder="请输入车牌号"/>
			</div>
			<div class="row_div">
				<span class="yss_span">运输商：</span>
				<input type="text" class="yssMc_inp" id="yssMc" placeholder="请输入运输商"/>
				<span class="fhdw_span">发货单位：</span>
				<input type="text" class="fhdwMc_inp" id="fhdwMc" placeholder="请输入发货单位"/>
				<span class="shdw_span">收货单位：</span>
				<input type="text" class="shdwMc_inp" id="shdwMc" placeholder="请输入收货单位"/>
				<span class="gbsj_span">过磅时间：</span>
				<input id="gbsjks_dtb"/>-
				<input id="gbsjjs_dtb"/>
				<a class="search_but" id="search_but">查询</a>
				<a id="check_but">审核</a>
				<a id="shbtg_but">审核不通过</a>
			</div>
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>