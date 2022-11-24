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
.tab1_div .toolbar .dlMc_span,
.tab1_div .toolbar .hm_span,
.tab1_div .toolbar .pdh_span,
.tab1_div .toolbar .zt_span{
	margin-left: 13px;
}
.tab1_div .toolbar .dlMc_inp,
.tab1_div .toolbar .hm_inp,
.tab1_div .toolbar .pdh_inp{
	width: 120px;
	height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
</style>
<title>号码查询</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var pdglPath=path+'pdgl/';
$(function(){
	initZTCBB();
	initSearchLB();
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
	data.push({"value":"","text":"请选择状态"});
	$.post(pdglPath+"queryHaoMaZhuangTaiCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			ztCBB=$("#zt_cbb").combobox({
				valueField:"value",
				textField:"text",
				//multiple:true,
				data:data
			});
		}
	,"json");
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var dlMc=$("#toolbar #dlMc").val();
			var hm=$("#toolbar #hm").val();
			var pdh=$("#toolbar #pdh").val();
			var ddztId=ztCBB.combobox("getValue");
			tab1.datagrid("load",{dlMc:dlMc,hm:hm,pdh:pdh,ddztId:ddztId});
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
		title:"排队管理-号码查询-列表",
		url:pdglPath+"queryHaoMaList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"hm",title:"号码",width:200},
            {field:"pdh",title:"排队号",width:200},
            {field:"prsj",title:"排入时间",width:200},
            {field:"fl",title:"分类",width:200,formatter:function(value,row){
            	var str;
            	switch (value) {
				case 1:
					str="普通";
					break;
				case 2:
					str="其他";
					break;
				}
            	return str;
            }},
            {field:"hmztMc",title:"状态",width:100},
            {field:"ksjhsj",title:"开始叫号时间",width:200},
            {field:"jhcs",title:"叫号次数",width:200},
            {field:"id",title:"操作",width:80,formatter:function(value,row){
            	var str="";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{hm:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"hm",colspan:8});
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
			$.post(pdglPath + "deleteHaoMa",
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
			<span class="dlMc_span">队列名称：</span>
			<input type="text" class="dlMc_inp" id="dlMc" placeholder="请输入队列名称"/>
			<span class="hm_span">号码：</span>
			<input type="text" class="hm_inp" id="hm" placeholder="请输入号码"/>
			<span class="pdh_span">排队号：</span>
			<input type="text" class="pdh_inp" id="pdh" placeholder="请输入排队号"/>
			<span class="zt_span">状态：</span>
			<input id="zt_cbb"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="remove_but">删除</a>
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>