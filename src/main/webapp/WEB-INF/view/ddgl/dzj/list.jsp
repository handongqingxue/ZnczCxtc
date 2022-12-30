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
.tab1_div .toolbar .ddh_span,
.tab1_div .toolbar .cyclCph_span,
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .ddh_inp,
.tab1_div .toolbar .cyclCph_inp{
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
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var ddglPath=path+'ddgl/';
var exportExcelPath=path+'exportExcel/';
var dialogLeft=20;
var oedNum=0;

var defaultDdztMc='${requestScope.djyDdztMc}';
var yjdsmDdztMc='${requestScope.yjdsmDdztMc}';
var shlx='${requestScope.zjshShlx}';
var shrId='${sessionScope.yongHu.id}';
var sheetFlag='${requestScope.sheetFlag}';

var syLxlx;
var qyLxlx;

var syLxlxMc;
var qyLxlxMc;

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;
$(function(){
	initLxlxVar();
	initDcfwVar();
	
	initSearchLB();
	initTGLB();
	initOutputLB();
	initTab1();
	
	initOutputExcelDialog();//0
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	showCompontByQx();
});

function initLxlxVar(){
	syLxlx=parseInt('${requestScope.syLxlx}');
	qyLxlx=parseInt('${requestScope.qyLxlx}');

	syLxlxMc='${requestScope.syLxlxMc}';
	qyLxlxMc='${requestScope.qyLxlxMc}';
}

function initDcfwVar(){
	dqyDcfw=parseInt('${requestScope.dqyDcfw}');
	syyDcfw=parseInt('${requestScope.syyDcfw}');

	dqyDcfwMc='${requestScope.dqyDcfwMc}';
	syyDcfwMc='${requestScope.syyDcfwMc}';
}

function initDialogPosition(){
	var oedpw=$("body").find(".panel.window").eq(oedNum);
	var oedws=$("body").find(".window-shadow").eq(oedNum);
	
	var oedDiv=$("#output_excel_div");
	oedDiv.append(oedpw);
	oedDiv.append(oedws);
}

function showCompontByQx(){
	tgLB.hide();
	if(yhm=="admin"){
		tgLB.show();
	}
	else{
		var zjshQx='${requestScope.zjshQx}';
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==zjshQx){
				tgLB.show();
			}
		}
	}
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
	    			var cyclCph=$("#toolbar #cyclCph").val();
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="ddh="+ddh+"&cyclCph="+cyclCph+"&ddztMc="+encodeURI(encodeURI(defaultDdztMc))+"&sheetFlag="+sheetFlag+"&dcfw="+dcfw;
        			if(dcfw==dqyDcfw){
	        			var options=tab1.datagrid("getPager").data("pagination").options;
	        			var page=options.pageNumber;
	        			var rows=options.pageSize;
	        			params+="&page="+page+"&rows="+rows;
        			}
        			location.href=exportExcelPath+"exportDDZHCXList?"+params;
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
			var cyclCph=$("#toolbar #cyclCph").val();
			tab1.datagrid("load",{ddh:ddh,ddztMc:defaultDdztMc,cph:cyclCph});
		}
	});
}

function initTGLB(){
	tgLB=$("#tg_but").linkbutton({
		iconCls:"icon-ok",
		onClick:function(){
			checkByIds(true);
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
			ddztMc=yjdsmDdztMc;
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

function initOutputLB(){
	$("#output_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			openOutputExcelDialog(true);
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"订单管理-待质检-列表",
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
            	return getLxlxMcById(value);
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

function openOutputExcelDialog(flag){
	if(flag){
		$("#output_excel_bg_div").css("display","block");
	}
	else{
		$("#output_excel_bg_div").css("display","none");
	}
}

function getLxlxMcById(lxlxId){
	var str;
	switch (lxlxId) {
	case syLxlx:
		str=syLxlxMc;//送运
		break;
	case qyLxlx:
		str=qyLxlxMc;//取运
		break;
	}
	return str;
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
			<span class="ddh_span">订单号：</span>
			<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
			<span class="cyclCph_span">车牌号：</span>
			<input type="text" class="cyclCph_inp" id="cyclCph" placeholder="请输入车牌号"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="tg_but">通过</a>
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