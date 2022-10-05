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
.tab1_div .toolbar .mc_span,.tab1_div .toolbar .dm_span,.tab1_div .toolbar .zt_span{
	margin-left: 13px;
}
.tab1_div .toolbar .mc_inp,.tab1_div .toolbar .dm_inp{
	width: 120px;
	height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
</style>
<title>队列查询</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var pdglPath=path+'pdgl/';
$(function(){
	initZTCBB();
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

function initZTCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":1,"text":"在用"});
	data.push({"value":2,"text":"暂停"});
	data.push({"value":3,"text":"废弃"});
	
	ztCBB=$("#zt_cbb").combobox({
		valueField:"value",
		textField:"text",
		//multiple:true,
		data:data
	});
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var mc=$("#toolbar #mc").val();
			var dm=$("#toolbar #dm").val();
			var zt=ztCBB.combobox("getValue");
			tab1.datagrid("load",{mc:mc,dm:dm,zt:zt});
		}
	});
}

function initAddLB(){
	$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=pdglPath+"dlcx/new";
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
		title:"队列-列表",
		url:pdglPath+"queryDuiLieList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"mc",title:"名称",width:200},
			{field:"dm",title:"代码",width:150},
			{field:"jhxs",title:"叫号形式",width:150,formatter:function(value,row){
            	var str;
            	switch (value) {
				case 1:
					str="自动";
					break;
				case 2:
					str="手动";
					break;
				}
            	str+="叫号";
            	return str;
            }},
			{field:"jhyz",title:"叫号阈值",width:150},
            {field:"zt",title:"状态",width:100,formatter:function(value,row){
            	var str;
            	switch (value) {
				case 1:
					str="在用";
					break;
				case 2:
					str="暂停";
					break;
				case 3:
					str="废弃";
					break;
				}
            	return str;
            }},
            {field:"id",title:"操作",width:150,formatter:function(value,row){
            	var str="<a href=\""+pdglPath+"dlcx/detail?id="+value+"\">详情</a>"
            	+"&nbsp;|&nbsp;<a href=\""+pdglPath+"dlcx/edit?id="+value+"\">修改</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{mc:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"mc",colspan:6});
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
			$.post(pdglPath + "deleteDuiLie",
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
			<span class="mc_span">名称：</span>
			<input type="text" class="mc_inp" id="mc" placeholder="请输入名称"/>
			<span class="dm_span">代码：</span>
			<input type="text" class="dm_inp" id="dm" placeholder="请输入代码"/>
			<span class="zt_span">状态：</span>
			<input id="zt_cbb"/>
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