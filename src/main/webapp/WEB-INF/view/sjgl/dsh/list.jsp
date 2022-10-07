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
.tab1_div .toolbar .sfzh_span{
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
var defaultShzt='${requestScope.shzt}';
$(function(){
	initSearchLB();
	initSHTGLB();
	initTHLB();
	initTab1();
	showCompontByQx();
});

function showCompontByQx(){
	removeLB.hide();
	if(yhm=="admin"){
		removeLB.show();
	}
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var xm=$("#toolbar #xm").val();
			var sjh=$("#toolbar #sjh").val();
			var sfzh=$("#toolbar #sfzh").val();
			tab1.datagrid("load",{xm:xm,sjh:sjh,sfzh:sfzh,shzt:defaultShzt});
		}
	});
}

function initSHTGLB(){
	$("#shtg_but").linkbutton({
		iconCls:"icon-ok",
		onClick:function(){
			shenHeByIds("sh");
		}
	});
}

function initTHLB(){
	$("#th_but").linkbutton({
		iconCls:"icon-back",
		onClick:function(){
			shenHeByIds("th");
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"司机管理-待审核-列表",
		url:sjglPath+"querySiJiList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		queryParams:{shzt:defaultShzt},
		columns:[[
			{field:"xm",title:"姓名",width:200},
            {field:"sjh",title:"手机号",width:200},
			{field:"sfzh",title:"身份证号",width:200},
			{field:"jzyxqz",title:"驾证有效期至",width:200},
			{field:"zgzyxqz",title:"资格证有效期至",width:200},
            {field:"id",title:"操作",width:80,formatter:function(value,row){
            	var str="<a href=\""+sjglPath+"dsh/detail?id="+value+"\">详情</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{xm:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"xm",colspan:6});
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

function shenHeByIds(flag) {
	var tsStr;
	if(flag=="sh")
		tsStr="审核";
	else if(flag=="th")
		tsStr="退回";
	
	var rows=tab1.datagrid("getSelections");
	if (rows.length == 0) {
		$.messager.alert("提示","请选择要"+tsStr+"的信息！","warning");
		return false;
	}
	
	$.messager.confirm("提示","确定要"+tsStr+"吗？",function(r){
		if(r){
			var ids = "";
			for (var i = 0; i < rows.length; i++) {
				ids += "," + rows[i].id;
			}
			ids=ids.substring(1);
			
			$.ajaxSetup({async:false});
			$.post(sjglPath + "shenHeSiJi",
				{ids:ids,flag:flag},
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
			<a class="search_but" id="search_but">查询</a>
			<a id="shtg_but">审核通过</a>
			<a id="th_but">退回</a>
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>