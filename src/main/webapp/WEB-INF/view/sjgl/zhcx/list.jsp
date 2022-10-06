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
.tab1_div .toolbar .xm_span,
.tab1_div .toolbar .sjh_span,
.tab1_div .toolbar .sfzh_span,
.tab1_div .toolbar .zyzt_span{
	margin-left: 13px;
}
.tab1_div .toolbar .xm_inp,
.tab1_div .toolbar .sjh_inp{
	width: 120px;
	height: 25px;
}
.tab1_div .toolbar .sfzh_inp{
	width: 180px;
	height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
</style>
<title>发货单位</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var sjglPath=path+'sjgl/';
$(function(){
	initZYZTCBB();
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

function initZYZTCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":"1","text":"是"});
	data.push({"value":"0","text":"否"});
	
	zyztCBB=$("#zyzt_cbb").combobox({
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
			var xm=$("#toolbar #xm").val();
			var sjh=$("#toolbar #sjh").val();
			var sfzh=$("#toolbar #sfzh").val();
			var zyzt=zyztCBB.combobox("getValue");
			tab1.datagrid("load",{xm:xm,sjh:sjh,sfzh:sfzh,zyzt:zyzt});
		}
	});
}

function initAddLB(){
	$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=sjglPath+"zhcx/new";
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
		title:"司机-列表",
		url:sjglPath+"querySiJiList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"xm",title:"姓名",width:200},
            {field:"sjh",title:"手机号",width:200},
			{field:"sfzh",title:"身份证号",width:200},
			{field:"jzyxqz",title:"驾证有效期至",width:200},
			{field:"zgzyxqz",title:"资格证有效期至",width:200},
			{field:"shzt",title:"审核状态",width:200,formatter:function(value,row){
				var str;
				switch (value) {
				case 1:
					str="编辑中";
					break;
				case 2:
					str="待审核";
					break;
				case 3:
					str="审核通过";
					break;
				}
				return str;
			}},
			{field:"zyzt",title:"在用状态",width:200,formatter:function(value,row){
				return value?"是":"否";
			}},
            {field:"id",title:"操作",width:150,formatter:function(value,row){
            	var str="<a href=\""+sjglPath+"zhcx/detail?id="+value+"\">详情</a>"
            	+"&nbsp;|&nbsp;<a href=\""+sjglPath+"zhcx/edit?id="+value+"\">修改</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{xm:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"xm",colspan:8});
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
			$.post(sjglPath + "deleteSiJi",
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
			<span class="xm_span">姓名：</span>
			<input type="text" class="xm_inp" id="xm" placeholder="请输入姓名"/>
			<span class="sjh_span">手机号：</span>
			<input type="text" class="sjh_inp" id="sjh" placeholder="请输入手机号"/>
			<span class="sfzh_span">身份证号：</span>
			<input type="text" class="sfzh_inp" id="sfzh" placeholder="请输入身份证号"/>
			<span class="zyzt_span">在用状态：</span>
			<input id="zyzt_cbb"/>
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