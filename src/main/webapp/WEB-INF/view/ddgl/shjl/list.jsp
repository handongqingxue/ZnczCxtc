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
.tab1_div .toolbar .row_div .shlx_span,
.tab1_div .toolbar .row_div .shsj_span,
.tab1_div .toolbar .row_div .cyclCph_span,
.tab1_div .toolbar .row_div .shr_span,
.tab1_div .toolbar .row_div .yss_span,
.tab1_div .toolbar .row_div .wzMc_span,
.tab1_div .toolbar .row_div .fhdw_span,
.tab1_div .toolbar .row_div .shbm_span,
.tab1_div .toolbar .row_div .sjXm_span,
.tab1_div .toolbar .row_div .sjSfzh_span,
.tab1_div .toolbar .row_div .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .row_div .ddh_inp,
.tab1_div .toolbar .row_div .cyclCph_inp,
.tab1_div .toolbar .row_div .shr_inp,
.tab1_div .toolbar .row_div .yssMc_inp,
.tab1_div .toolbar .row_div .wzMc_inp,
.tab1_div .toolbar .row_div .fhdwMc_inp,
.tab1_div .toolbar .row_div .shdwMc_inp,
.tab1_div .toolbar .row_div .sjXm_inp,
.tab1_div .toolbar .row_div .sjSfzh_inp{
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

var xdshShlx;
var zjshShlx;
var yjshShlx;
var rkshShlx;
var ejshShlx;

var xdshShlxMc;
var zjshShlxMc;
var yjshShlxMc;
var rkshShlxMc;
var ejshShlxMc;

var hgShjg;
var bhgShjg;

var hgShjgMc;
var bhgShjgMc;

var syLxlx;
var qyLxlx;

var syLxlxMc;
var qyLxlxMc;

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;

$(function(){
	initShlxVar();
	initShjgVar();
	initLxlxVar();
	initDcfwVar();
	
	initSHLXCBB();
	initSHSJKSDTB();
	initSHSJJSDTB();
	initSearchLB();
	initRemoveLB();
	initOutputLB();
	initTab1();
	
	initOutputExcelDialog();//0
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	
	showCompontByQx();
});

function initShlxVar(){
	xdshShlx=parseInt('${requestScope.xdshShlx}');
	zjshShlx=parseInt('${requestScope.zjshShlx}');
	yjshShlx=parseInt('${requestScope.yjshShlx}');
	rkshShlx=parseInt('${requestScope.rkshShlx}');
	ejshShlx=parseInt('${requestScope.ejshShlx}');

	xdshShlxMc='${requestScope.xdshShlxMc}';
	zjshShlxMc='${requestScope.zjshShlxMc}';
	yjshShlxMc='${requestScope.yjshShlxMc}';
	rkshShlxMc='${requestScope.rkshShlxMc}';
	ejshShlxMc='${requestScope.ejshShlxMc}';
}

function initShjgVar(){
	hgShjg=Boolean('${requestScope.hgShjg}');
	bhgShjg=Boolean('${requestScope.bhgShjg}');

	hgShjgMc='${requestScope.hgShjgMc}';
	bhgShjgMc='${requestScope.bhgShjgMc}';
}

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
        			var shlx=shlxCBB.combobox("getValue");
        			var shsjks=shsjksDTB.datetimebox("getValue");
        			var shsjjs=shsjjsDTB.datetimebox("getValue");
        			var cyclCph=encodeURIParam($("#toolbar #cyclCph").val());
        			var shrYhm=encodeURIParam($("#toolbar #shr").val());
        			var yssMc=encodeURIParam($("#toolbar #yssMc").val());
        			var wzMc=encodeURIParam($("#toolbar #wzMc").val());
        			var fhdwMc=encodeURIParam($("#toolbar #fhdwMc").val());
        			var shdwMc=encodeURIParam($("#toolbar #shdwMc").val());
        			var sjXm=encodeURIParam($("#toolbar #sjXm").val());
        			var sjSfzh=$("#toolbar #sjSfzh").val();
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="ddh="+ddh+"&shlx="+shlx+"&shsjks="+shsjks+"&shsjjs="+shsjjs+"&cyclCph="+cyclCph+"&shrYhm="+shrYhm+"&yssMc="+yssMc+"&wzMc="+wzMc+"&fhdwMc="+fhdwMc+"&shdwMc="+shdwMc+"&sjXm="+sjXm+"&sjSfzh="+sjSfzh+"&dcfw="+dcfw;
        			if(dcfw==dqyDcfw){
	        			var options=tab1.datagrid("getPager").data("pagination").options;
	        			var page=options.pageNumber;
	        			var rows=options.pageSize;
	        			params+="&page="+page+"&rows="+rows;
        			}
        			location.href=exportExcelPath+"exportDDSHJLList?"+params;
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

function initSHLXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":1,"text":"下单审核"});
	data.push({"value":2,"text":"一检审核"});
	data.push({"value":3,"text":"入库审核"});
	data.push({"value":4,"text":"二检审核"});
	
	shlxCBB=$("#shlx_cbb").combobox({
		valueField:"value",
		textField:"text",
		//multiple:true,
		data:data
	});
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
			var ddh=$("#toolbar #ddh").val();
			var shlx=shlxCBB.combobox("getValue");
			var shsjks=shsjksDTB.datetimebox("getValue");
			var shsjjs=shsjjsDTB.datetimebox("getValue");
			var cyclCph=$("#toolbar #cyclCph").val();
			var shrYhm=$("#toolbar #shr").val();
			var yssMc=$("#toolbar #yssMc").val();
			var wzMc=$("#toolbar #wzMc").val();
			var fhdwMc=$("#toolbar #fhdwMc").val();
			var shdwMc=$("#toolbar #shdwMc").val();
			var sjXm=$("#toolbar #sjXm").val();
			var sjSfzh=$("#toolbar #sjSfzh").val();
			tab1.datagrid("load",{ddh:ddh,shlx:shlx,shsjks:shsjks,shsjjs:shsjjs,cyclCph:cyclCph,shrYhm:shrYhm,yssMc:yssMc,wzMc:wzMc,
				fhdwMc:fhdwMc,shdwMc:shdwMc,sjXm:sjXm,sjSfzh:sjSfzh});
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

function initOutputLB(){
	opBut=$("#output_but").linkbutton({
		iconCls:"icon-remove",
		onClick:function(){
			openOutputExcelDialog(true);
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"订单管理-审核记录-列表",
		url:ddglPath+"querySHJLList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:150},
			{field:"shlx",title:"审核类型",width:100,formatter:function(value,row){
            	return getShlxMcById(value);
            }},
            {field:"shsj",title:"审核时间",width:150},
			{field:"shjg",title:"审核结果",width:100,formatter:function(value,row){
            	return getShjgMcByJg(value);
            }},
            {field:"shrYhm",title:"审核人",width:150},
			{field:"sjSfzh",title:"司机身份证号",width:200},
			{field:"sjXm",title:"司机姓名",width:100},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"wzMc",title:"物资名称",width:150},
			{field:"yssMc",title:"运输商",width:150},
			{field:"fhdwMc",title:"发货单位",width:150},
			{field:"shdwMc",title:"收货单位",width:150},
            {field:"lxlx",title:"流向类型",width:100,formatter:function(value,row){
            	return getLxlxMcById(value);
            }},
            {field:"yzxzl",title:"预装卸重量",width:100},
            {field:"sjzl",title:"实际重量",width:100},
            {field:"zlceb",title:"重量差额比",width:100}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:16});
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

function getShlxMcById(shlxId){
	var str;
	switch (shlxId) {
	case xdshShlx:
		str=xdshShlxMc;//下单审核
		break;
	case zjshShlx:
		str=zjshShlxMc;//质检审核
		break;
	case yjshShlx:
		str=yjshShlxMc;//一检审核
		break;
	case rkshShlx:
		str=rkshShlxMc;//入库审核
		break;
	case ejshShlx:
		str=ejshShlxMc;//二检审核
		break;
	}
	return str;
}

function getShjgMcByJg(shjg){
	var str;
	if(shjg)
		str=hgShjgMc;//合格
	else
		str=bhgShjgMc;//不合格
	return str;
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
			
			$.post(ddglPath + "deleteShenHeJiLu",
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
	case "center_con_div":
		space=205;
		break;
	case "tab1_div":
		space=250;
		break;
	case "check_ddxx_dialog_div":
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
				<span class="shlx_span">审核类型：</span>
				<input id="shlx_cbb"/>
				<span class="shsj_span">审核时间：</span>
				<input id="shsjks_dtb"/>-
				<input id="shsjjs_dtb"/>
				<span class="cyclCph_span">车牌号：</span>
				<input type="text" class="cyclCph_inp" id="cyclCph" placeholder="请输入车牌号"/>
				<span class="shr_span">审核人：</span>
				<input type="text" class="shr_inp" id="shr" placeholder="请输入审核人"/>
			</div>
			<div class="row_div">
				<span class="yss_span">运输商：</span>
				<input type="text" class="yssMc_inp" id="yssMc" placeholder="请输入运输商"/>
				<span class="wzMc_span">物资名称：</span>
				<input type="text" class="wzMc_inp" id="wzMc" placeholder="请输入物资名称"/>
				<span class="fhdw_span">发货单位：</span>
				<input type="text" class="fhdwMc_inp" id="fhdwMc" placeholder="请输入发货单位"/>
				<span class="shbm_span">收货单位：</span>
				<input type="text" class="shdwMc_inp" id="shdwMc" placeholder="请输入收货单位"/>
				<span class="sjXm_span">司机姓名：</span>
				<input type="text" class="sjXm_inp" id="sjXm" placeholder="请输入司机姓名"/>
				<span class="sjSfzh_span">司机身份证号：</span>
				<input type="text" class="sjSfzh_inp" id="sjSfzh" placeholder="请输入司机身份证号"/>
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