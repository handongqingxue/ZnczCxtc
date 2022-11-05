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
.tab1_div .toolbar .sjXm_span,
.tab1_div .toolbar .shr_span,
.tab1_div .toolbar .shsj_span,
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .sjXm_inp,
.tab1_div .toolbar .shr_inp{
	width: 120px;
	height: 25px;
}
</style>
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var sjglPath=path+'sjgl/';
$(function(){
	initSHSJKSDTB();
	initSHSJJSDTB();
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

function initSHSJKSDTB(){
	shsjksDTB=$("#shsjks_dtb").datetimebox({
        required:false
    });
}

function initSHSJJSDTB(){
	shsjjsDTB=$("#shsjjs_dtb").datetimebox({
        required:false
    });
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var sjXm=$("#toolbar #sjXm").val();
			var shrYhm=$("#toolbar #shr").val();
			var shsjks=shsjksDTB.datetimebox("getValue");
			var shsjjs=shsjjsDTB.datetimebox("getValue");
			tab1.datagrid("load",{sjXm:sjXm,shrYhm:shrYhm,shsjks:shsjks,shsjjs:shsjjs});
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
		title:"司机管理-审核记录-列表",
		url:sjglPath+"querySHJLList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"sjXm",title:"姓名",width:150},
            {field:"shrYhm",title:"审核人",width:150},
            {field:"shsj",title:"审核时间",width:150},
			{field:"shjg",title:"审核结果",width:100,formatter:function(value,row){
            	return value==1?"合格":"不合格";
            }},
            {field:"bz",title:"备注",width:300}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{sjXm:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"sjXm",colspan:5});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");
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
			
			$.post(sjglPath + "deleteShenHeJiLu",
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
			<span class="sjXm_span">姓名：</span>
			<input type="text" class="sjXm_inp" id="sjXm" placeholder="请输入姓名"/>
			<span class="shr_span">审核人：</span>
			<input type="text" class="shr_inp" id="shr" placeholder="请输入审核人"/>
			<span class="shsj_span">审核时间：</span>
			<input id="shsjks_dtb"/>-
			<input id="shsjjs_dtb"/>
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