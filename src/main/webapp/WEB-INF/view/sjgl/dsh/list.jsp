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
<title>发货单位</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var sjglPath=path+'sjgl/';
var exportExcelPath=path+'exportExcel/';
var dialogTop=10;
var dialogLeft=20;
var oedNum=0;

var sheetFlag='${requestScope.sheetFlag}';
var defaultShzt='${requestScope.shzt}';

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;
$(function(){
	initDcfwVar();
	
	initSearchLB();
	initSHTGLB();
	initTHLB();
	initOutputBut();
	initTab1();
	
	initOutputExcelDialog();//0
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	
	//showCompontByQx();
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
        			var xm=encodeURIParam($("#toolbar #xm").val());
        			var sjh=$("#toolbar #sjh").val();
        			var sfzh=$("#toolbar #sfzh").val();
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="xm="+xm+"&sjh="+sjh+"&sfzh="+sfzh+"&shzt="+defaultShzt+"&sheetFlag="+sheetFlag+"&dcfw="+dcfw;
        			if(dcfw==dqyDcfw){
	        			var options=tab1.datagrid("getPager").data("pagination").options;
	        			var page=options.pageNumber;
	        			var rows=options.pageSize;
	        			params+="&page="+page+"&rows="+rows;
        			}
        			location.href=exportExcelPath+"exportSiJiList?"+params;
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
		title:"司机管理-待审核-列表",
		url:sjglPath+"querySiJiList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
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

function openOutputExcelDialog(flag){
	if(flag){
		$("#output_excel_bg_div").css("display","block");
	}
	else{
		$("#output_excel_bg_div").css("display","none");
	}
}

function checkByIds(shjg) {
	var tsStr;
	if(shjg)
		tsStr="审核";
	else
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

			var shrId='${sessionScope.yongHu.id}';
			$.ajaxSetup({async:false});
			$.post(sjglPath + "checkSiJiByIds",
				{ids:ids,shjg:shjg,shrId:shrId},
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
			<span class="xm_span">姓名：</span>
			<input type="text" class="xm_inp" id="xm" placeholder="请输入姓名"/>
			<span class="sjh_span">手机号：</span>
			<input type="text" class="sjh_inp" id="sjh" placeholder="请输入手机号"/>
			<span class="sfzh_span">身份证号：</span>
			<input type="text" class="sfzh_inp" id="sfzh" placeholder="请输入身份证号"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="shtg_but">审核通过</a>
			<a id="th_but">退回</a>
         	<a id="output_but">导出</a>
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