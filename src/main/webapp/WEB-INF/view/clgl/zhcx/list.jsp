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
</style>
<title>车辆列表</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var clglPath=path+'clgl/';
$(function(){
	initCLLXCBB();
	initSFZYCBB();
	initSHZTCBB();
	initSearchLB();
	initAddLB();
	initRemoveLB();
	initTab1();
	showCompontByQx();
});

function showCompontByQx(){
	removeLB.hide();
	if(yhm=="admin"){
		removeLB.show();
	}
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

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"车辆管理-综合查询-车辆列表",
		url:clglPath+"queryCheLiangList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
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
				return value?"是":"否";
			}},
			{field:"shzt",title:"状态",width:100,formatter:function(value){
				var str;
				switch (value) {
				case 1:
					str="待审核";
					break;
				case 2:
					str="审核通过";
					break;
				case 3:
					str="编辑中";
					break;
				}
				return str;
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
			$.post(clglPath + "deleteFaHuoDanWei",
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

function setFitWidthInParent(o){
	var width=$(o).css("width");
	return width.substring(0,width.length-2)-340;
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
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>