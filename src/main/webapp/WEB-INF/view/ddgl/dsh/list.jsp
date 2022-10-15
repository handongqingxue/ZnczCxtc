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
.tab1_div .toolbar .row_div{
	height:32px;
}
.tab1_div .toolbar .row_div .ddh_span,
.tab1_div .toolbar .row_div .yss_span,
.tab1_div .toolbar .row_div .wzmc_span,
.tab1_div .toolbar .row_div .fhdw_span,
.tab1_div .toolbar .row_div .shdw_span,
.tab1_div .toolbar .row_div .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .row_div .ddh_inp,
.tab1_div .toolbar .row_div .yssMc_inp,
.tab1_div .toolbar .row_div .wzMc_inp,
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
var ddglPath=path+'ddgl/';
var defaultDdztMc='${requestScope.ddztMc}';
var bjzDdztMc='${requestScope.bjzDdztMc}';
var yxdDdztMc='${requestScope.yxdDdztMc}';
$(function(){
	initSearchLB();
	initTGLB();
	initTHLB();
	initTab1();
});

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var ddh=$("#toolbar #ddh").val();
			var wzMc=$("#toolbar #wzMc").val();
			var yssMc=$("#toolbar #yssMc").val();
			var fhdwMc=$("#toolbar #fhdwMc").val();
			var shdwMc=$("#toolbar #shdwMc").val();
			tab1.datagrid("load",{ddh:ddh,ddztMc:defaultDdztMc,wzMc:wzMc,yssMc:yssMc,fhdwMc:fhdwMc,shdwMc:shdwMc});
		}
	});
}

function initTGLB(){
	$("#tg_but").linkbutton({
		iconCls:"icon-ok",
		onClick:function(){
			checkByIds(true);
		}
	});
}

function initTHLB(){
	$("#th_but").linkbutton({
		iconCls:"icon-back",
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

	var shIds = "";
	for (var i = 0; i < rows.length; i++) {
		shIds += "," + rows[i].id;
	}
	if(shIds!="")
		shIds=shIds.substring(1);
	
	var confirmStr="请确保所有订单都认真审核过！";
	if(confirm(confirmStr)){
		var ddztMc;
		if(shjg)
			ddztMc=yxdDdztMc;
		else
			ddztMc=bjzDdztMc;
		var shlx='${requestScope.shlx}';
		var shrId='${sessionScope.yongHu.id}';
		$.post(ddglPath + "checkDingDanByIds",
			{ids:shIds,ddztMc:ddztMc,shlx:shlx,shjg:shjg,shrId:shrId},
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
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"订单管理-待审核-列表",
		url:ddglPath+"queryZHCXList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		queryParams:{ddztMc:defaultDdztMc},
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:150},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"wzMc",title:"物资名称",width:150},
			{field:"yssMc",title:"运输商",width:150},
			{field:"fhdwMc",title:"发货单位",width:150},
			{field:"shdwMc",title:"收货单位",width:150},
            {field:"lxlx",title:"流向类型",width:100,formatter:function(value,row){
            	var str;
            	switch (value) {
				case 1:
					str="送运";
					break;
				case 2:
					str="取运";
					break;
				}
            	return str;
            }},
            {field:"jhysrq",title:"计划运输日期",width:150},
            {field:"yzxzl",title:"预装卸重量",width:100}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:9});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");
		}
	});
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "center_con_div":
		space=205;
		break;
	case "tab1_div":
		space=250;
		break;
	case "check_ddxx_dialog_div":
		space=50;
		break;
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
	<div class="tab1_div" id="tab1_div">
		<div class="toolbar" id="toolbar">
			<div class="row_div">
				<span class="ddh_span">订单号：</span>
				<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
				<span class="wzMc_span">物资名称：</span>
				<input type="text" class="wzMc_inp" id="wzMc" placeholder="请输入物资名称"/>
				<span class="yss_span">运输商：</span>
				<input type="text" class="yssMc_inp" id="yssMc" placeholder="请输入运输商"/>
				<span class="fhdw_span">发货单位：</span>
				<input type="text" class="fhdwMc_inp" id="fhdwMc" placeholder="请输入发货单位"/>
				<span class="shdw_span">收货单位：</span>
				<input type="text" class="shdwMc_inp" id="shdwMc" placeholder="请输入收货单位"/>
				<a class="search_but" id="search_but">查询</a>
				<a id="tg_but">通过</a>
				<a id="th_but">退回</a>
			</div>
		</div>
		<table id="tab1">
		</table>
	</div>
	
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>