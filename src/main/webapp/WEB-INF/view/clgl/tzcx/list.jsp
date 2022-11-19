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
.tab1_div .toolbar .row_div .cph_span,
.tab1_div .toolbar .row_div .ddzt_span,
.tab1_div .toolbar .row_div .jcsj_span,
.tab1_div .toolbar .row_div .ccsj_span,
.tab1_div .toolbar .row_div .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .row_div .ddh_inp,
.tab1_div .toolbar .row_div .cph_inp{
	width: 120px;
	height: 25px;
}
</style>
<title>车辆列表</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var ddglPath=path+'ddgl/';
var clglPath=path+'clgl/';
$(function(){
	initDDZTCBB();
	initJCSJSDTB();
	initJCSJEDTB();
	initCCSJSDTB();
	initCCSJEDTB();
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

function initDDZTCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	$.post(ddglPath+"queryDingDanZhuangTaiCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			ddztCBB=$("#ddzt_cbb").combobox({
				valueField:"value",
				textField:"text",
				//multiple:true,
				data:data
			});
		}
	,"json");
}

function initJCSJSDTB(){
	jcsjsDTB=$('#jcsjs_dtb').datetimebox({
        required:false
    });
}

function initJCSJEDTB(){
	jcsjeDTB=$('#jcsje_dtb').datetimebox({
        required:false
    });
}

function initCCSJSDTB(){
	ccsjsDTB=$('#ccsjs_dtb').datetimebox({
        required:false
    });
}

function initCCSJEDTB(){
	ccsjeDTB=$('#ccsje_dtb').datetimebox({
        required:false
    });
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var ddh=$("#toolbar #ddh").val();
			var cph=$("#toolbar #cph").val();
			var ddztId=ddztCBB.combobox("getValue");
			var jcsjs=jcsjsDTB.datetimebox("getValue");
			var jcsje=jcsjeDTB.datetimebox("getValue");
			var ccsjs=ccsjsDTB.datetimebox("getValue");
			var ccsje=ccsjeDTB.datetimebox("getValue");
			tab1.datagrid("load",{ddh:ddh,cph:cph,ddztId:ddztId,jcsjs:jcsjs,jcsje:jcsje,ccsjs:ccsjs,ccsje:ccsje});
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
		title:"车辆管理-台账查询-列表",
		url:clglPath+"queryCLTZList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:200},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"ddztMc",title:"订单状态",width:150},
			{field:"jcsj",title:"进厂时间",width:200},
			{field:"ccsj",title:"出厂时间",width:200},
            {field:"id",title:"操作",width:80,formatter:function(value,row){
            	var str="<a href=\""+clglPath+"tzcx/detail?id="+value+"\">详情</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:6});
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
			<div class="row_div">
				<span class="ddh_span">订单号：</span>
				<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
				<span class="cph_span">车牌号：</span>
				<input type="text" class="cph_inp" id="cph" placeholder="请输入车牌号"/>
				<span class="ddzt_span">订单状态：</span>
				<input id="ddzt_cbb"/>
			</div>
			<div class="row_div">
				<span class="jcsj_span">进厂时间：</span>
				<input id="jcsjs_dtb"/>
				-
				<input id="jcsje_dtb"/>
				<span class="ccsj_span">出厂时间：</span>
				<input id="ccsjs_dtb"/>
				-
				<input id="ccsje_dtb"/>
				<a class="search_but" id="search_but">查询</a>
				<a id="remove_but">删除</a>
			</div>
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>