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
	height:64px;
}
.tab1_div .toolbar .row_div{
	height:32px;
}
.tab1_div .toolbar .row_div .ddh_span,
.tab1_div .toolbar .row_div .cph_span,
.tab1_div .toolbar .row_div .ddzt_span,
.tab1_div .toolbar .row_div .jcsj_span,
.tab1_div .toolbar .row_div .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .row_div .ddh_inp,
.tab1_div .toolbar .row_div .cph_inp{
	width: 120px;
	height: 25px;
}

.output_excel_bg_div{
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,.45);
	position: fixed;
	z-index: 9016;
	display:none;
}

.output_excel_div{
	width: 500px;
	height: 210px;
	margin: 250px auto 0;
	background-color: #fff;
	border-radius:5px;
	position: absolute;
	left: 0;
	right: 0;
}
</style>
<title>车辆列表</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var ddglPath=path+'ddgl/';
var clglPath=path+'clgl/';
var exportExcelPath=path+'exportExcel/';
var dialogTop=10;
var dialogLeft=20;
var oedNum=0;

var sheetFlag='${requestScope.sheetFlag}';

var defaultDdzt;
var defaultDdztMc;

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;
$(function(){
	initDcfwVar();
	
	initDefaultDdztMc();
	initDDZTCBB();
	initJCSJSDTB();
	initJCSJEDTB();
	initSearchLB();
	initRemoveLB();
	initOutputBut();
	initTab1();
	
	initOutputExcelDialog();//0
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	
	showCompontByQx();
});

function showCompontByQx(){
	removeLB.hide();
	if(yhm=="admin"){
		removeLB.show();
	}
}

function initDialogPosition(){
	var oedpw=$("body").find(".panel.window").eq(oedNum);
	var oedws=$("body").find(".window-shadow").eq(oedNum);

	var oedDiv=$("#output_excel_div");
	oedDiv.append(oedpw);
	oedDiv.append(oedws);
}

function initDcfwVar(){
	dqyDcfw=parseInt('${requestScope.dqyDcfw}');
	syyDcfw=parseInt('${requestScope.syyDcfw}');

	dqyDcfwMc='${requestScope.dqyDcfwMc}';
	syyDcfwMc='${requestScope.syyDcfwMc}';
}

function initDefaultDdztMc(){
	var djyDdzt='${requestScope.djyDdzt}';
	var yjdsmDdzt='${requestScope.yjdsmDdzt}';
	var yjdsbDdzt='${requestScope.yjdsbDdzt}';
	var yjzDdzt='${requestScope.yjzDdzt}';
	var yjdshDdzt='${requestScope.yjdshDdzt}';
	var dzxhDdzt='${requestScope.dzxhDdzt}';
	var ejdsmDdzt='${requestScope.ejdsmDdzt}';
	var ejdsbDdzt='${requestScope.ejdsbDdzt}';
	var ejzDdzt='${requestScope.ejzDdzt}';
	var ejdshDdzt='${requestScope.ejdshDdzt}';
	var ddypzDdzt='${requestScope.ddypzDdzt}';
	var dlcDdzt='${requestScope.dlcDdzt}';
	defaultDdzt=djyDdzt+","+yjdsmDdzt+","+yjdsbDdzt+","+yjzDdzt+","+yjdshDdzt+","+dzxhDdzt;
	defaultDdzt+=","+ejdsmDdzt+","+ejdsbDdzt+","+ejzDdzt+","+ejdshDdzt+","+ddypzDdzt+","+dlcDdzt;
	
	var djyDdztMc='${requestScope.djyDdztMc}';
	var yjdsmDdztMc='${requestScope.yjdsmDdztMc}';
	var yjdsbDdztMc='${requestScope.yjdsbDdztMc}';
	var yjzDdztMc='${requestScope.yjzDdztMc}';
	var yjdshDdztMc='${requestScope.yjdshDdztMc}';
	var dzxhDdztMc='${requestScope.dzxhDdztMc}';
	var ejdsmDdztMc='${requestScope.ejdsmDdztMc}';
	var ejdsbDdztMc='${requestScope.ejdsbDdztMc}';
	var ejzDdztMc='${requestScope.ejzDdztMc}';
	var ejdshDdztMc='${requestScope.ejdshDdztMc}';
	var ddypzDdztMc='${requestScope.ddypzDdztMc}';
	var dlcDdztMc='${requestScope.dlcDdztMc}';
	defaultDdztMc=djyDdztMc+","+yjdsmDdztMc+","+yjdsbDdztMc+","+yjzDdztMc+","+yjdshDdztMc+","+dzxhDdztMc;
	defaultDdztMc+=","+ejdsmDdztMc+","+ejdsbDdztMc+","+ejzDdztMc+","+ejdshDdztMc+","+ddypzDdztMc+","+dlcDdztMc;
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
				multiple:true,
				data:data
			});
			ddztCBB.combobox("setValues",defaultDdzt.split(","));
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

function initOutputExcelDialog(){
	$("#output_excel_dialog_div").dialog({
		title:"导出excel",
		width:setFitWidthInParent("#output_excel_div","output_excel_dialog_div"),
		height:150,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"确定",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   if(checkDcfw()){
        		   	var params="";
        			var ddh=$("#toolbar #ddh").val();
        			var cph=encodeURIParam($("#toolbar #cph").val());
        			var ddztIds=String(ddztCBB.combobox("getValues"));
        			var jcsjs=jcsjsDTB.datetimebox("getValue");
        			var jcsje=jcsjeDTB.datetimebox("getValue");
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="ddh="+ddh+"&cph="+cph+"&ddztIds="+ddztIds+"&jcsjs="+jcsjs+"&jcsje="+jcsje+"&sheetFlag="+sheetFlag+"&dcfw="+dcfw;
        			if(dcfw==dqyDcfw){
	        			var options=tab1.datagrid("getPager").data("pagination").options;
	        			var page=options.pageNumber;
	        			var rows=options.pageSize;
	        			params+="&page="+page+"&rows="+rows;
        			}
        			location.href=exportExcelPath+"exportCLTZList?"+params;
             	   	openOutputExcelDialog(false);
        	   }
           }},
           {text:"取消",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openOutputExcelDialog(false);
           }}
        ]
	});

	$("#output_excel_dialog_div table").css("width",(setFitWidthInParent("#output_excel_div","output_excel_dialog_table"))+"px");
	$("#output_excel_dialog_div table").css("magin","-100px");
	$("#output_excel_dialog_div table td").css("padding-left","40px");
	$("#output_excel_dialog_div table td").css("padding-right","20px");
	$("#output_excel_dialog_div table td").css("font-size","15px");
	$("#output_excel_dialog_div table .td1").css("width","30%");
	$("#output_excel_dialog_div table .td2").css("width","60%");
	$("#output_excel_dialog_div table tr").css("height","45px");

	$(".panel.window").eq(oedNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(oedNum).css("color","#000");
	$(".panel.window .panel-title").eq(oedNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(oedNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(oedNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(oedNum).css("border-color","#ddd");

	$("#output_excel_dialog_div #ok_but").css("left","30%");
	$("#output_excel_dialog_div #ok_but").css("position","absolute");

	$("#output_excel_dialog_div #cancel_but").css("left","50%");
	$("#output_excel_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initDcfwCBB();
}

function initDcfwCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":dqyDcfw,"text":dqyDcfwMc});
	data.push({"value":syyDcfw,"text":syyDcfwMc});
	dcfwCBB=$("#dcfw_cbb").combobox({
		width:120,
		valueField:"value",
		textField:"text",
		data:data
	});
}

//验证导出范围
function checkDcfw(){
	var dcfw=dcfwCBB.combobox("getValue");
	if(dcfw==null||dcfw==""){
	  	alert("请选择导出范围");
	  	return false;
	}
	else
		return true;
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var ddh=$("#toolbar #ddh").val();
			var cph=$("#toolbar #cph").val();
			var ddztIds=String(ddztCBB.combobox("getValues"));
			var jcsjs=jcsjsDTB.datetimebox("getValue");
			var jcsje=jcsjeDTB.datetimebox("getValue");
			tab1.datagrid("load",{ddh:ddh,cph:cph,ddztIds:ddztIds,jcsjs:jcsjs,jcsje:jcsje,ddztMcs:defaultDdztMc});
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

function initOutputBut(){
	opBut=$("#output_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			openOutputExcelDialog(true);
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"车辆管理-厂内台账-列表",
		url:clglPath+"queryCLTZList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		queryParams:{ddztMcs:defaultDdztMc},
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:200},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"ddztMc",title:"订单状态",width:150},
			{field:"jcsj",title:"进厂时间",width:200},
            {field:"id",title:"操作",width:80,formatter:function(value,row){
            	var str="<a href=\""+clglPath+"cntz/detail?id="+value+"\">详情</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无数据<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:5});
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

function openOutputExcelDialog(flag){
	if(flag){
		$("#output_excel_bg_div").css("display","block");
	}
	else{
		$("#output_excel_bg_div").css("display","none");
	}
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

function encodeURIParam(val){
	return encodeURI(encodeURI(val));
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "tab1_div":
		space=250;
		break;
	case "output_excel_dialog_div":
		space=50;
		break;
	case "output_excel_dialog_table":
		space=68;
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
				<a class="search_but" id="search_but">查询</a>
				<a id="remove_but">删除</a>
         		<a id="output_but">导出</a>
			</div>
		</div>
		<table id="tab1">
		</table>
	</div>
	
	<div class="output_excel_bg_div" id="output_excel_bg_div">
		<div class="output_excel_div" id="output_excel_div">
			<div class="output_excel_dialog_div" id="output_excel_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						导出范围
					</td>
					<td class="td2">
						<input id="dcfw_cbb"/>
					</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>