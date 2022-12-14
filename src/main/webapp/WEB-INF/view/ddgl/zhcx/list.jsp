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
	height:128px;
}
.tab1_div .toolbar .row_div{
	height:32px;
}
.tab1_div .toolbar .row_div .ddh_span,
.tab1_div .toolbar .row_div .ddzt_span,
.tab1_div .toolbar .row_div .cyclCph_span,
.tab1_div .toolbar .row_div .jhysrq_span,
.tab1_div .toolbar .row_div .yss_span,
.tab1_div .toolbar .row_div .wzMc_span,
.tab1_div .toolbar .row_div .fhdw_span,
.tab1_div .toolbar .row_div .shdw_span,
.tab1_div .toolbar .row_div .cjsjXm_span,
.tab1_div .toolbar .row_div .cysjSfzh_span,
.tab1_div .toolbar .row_div .jcsj_span,
.tab1_div .toolbar .row_div .ccsj_span,
.tab1_div .toolbar .row_div .search_but{
	margin-left: 13px;
}
.tab1_div .toolbar .row_div .ddh_inp,
.tab1_div .toolbar .row_div .cyclCph_inp,
.tab1_div .toolbar .row_div .yssMc_inp,
.tab1_div .toolbar .row_div .wzMc_inp,
.tab1_div .toolbar .row_div .fhdwMc_inp,
.tab1_div .toolbar .row_div .shdwMc_inp,
.tab1_div .toolbar .row_div .cysjXm_inp,
.tab1_div .toolbar .row_div .cysjSfzh_inp{
	width: 120px;
	height: 25px;
}
.tab1_div .edit_a{
	visibility: hidden;
}

.input_sfzh_bg_div,
.input_cph_bg_div,
.input_ewm_bg_div,
.preview_bdxx_bg_div,
.output_excel_bg_div{
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,.45);
	position: fixed;
	z-index: 9016;
	display:none;
}

.input_sfzh_div{
	width: 500px;
	height: 260px;
	margin: 250px auto 0;
	background-color: #fff;
	border-radius:5px;
	position: absolute;
	left: 0;
	right: 0;
}

.input_cph_div,
.input_ewm_div{
	width: 500px;
	height: 300px;
	margin: 200px auto 0;
	background-color: #fff;
	border-radius:5px;
	position: absolute;
	left: 0;
	right: 0;
}

.preview_bdxx_div{
	width: 1000px;
	height: 570px;
	margin: 100px auto 0;
	background-color: #fff;
	border-radius:5px;
	position: absolute;
	left: 0;
	right: 0;
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
var gbglPath=path+'gbgl/';
var gkjPath=path+'gkj/';
var exportExcelPath=path+'exportExcel/';
var dialogTop=10;
var dialogLeft=20;
var isfzhdNum=0;
var icphdNum=1;
var iewmdNum=2;
var pbdxxdNum=3;
var oedNum=4;

var appendStr="";
var sheetFlag='${requestScope.sheetFlag}';

var syLxlx;
var qyLxlx;

var syLxlxMc;
var qyLxlxMc;

var dsbGbzt;
var sbzGbzt;
var dczGbzt;
var czzGbzt;
var dxbGbzt;
var xbzGbzt;
var ywcGbzt;

var dsbGbztMc;
var sbzGbztMc;
var dczGbztMc;
var czzGbztMc;
var dxbGbztMc;
var xbzGbztMc;
var ywcGbztMc;

var wgb;
var yhbf;
var ehbf;
var shbf;
var mg;

var wgbMc;
var yhbfMc;
var ehbfMc;
var shbfMc;
var mgMc;

var pushEwm;
var pushCph;
var pushSfzh;

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;

$(function(){
	initLxlxVar();
	initGbztVar();
	initPlaceFlagVar();
	initPushVar();
	initDcfwVar();
	
	initDDZTCBB();
	initJHYSRQDB();
	initJCSJSDTB();
	initJCSJEDTB();
	initCCSJSDTB();
	initCCSJEDTB();
	initSearchLB();
	initRgsbsfzLB();
	initRgsbcpLB();
	initRgsbewmLB();
	initDdfwLB();
	initBddyLB();
	initAddLB();
	initRemoveLB();
	initOutputLB();
	initTab1();
	
	initInputSfzhDialog();//0
	initInputRgsbcpDialog();//1
	initInputRgsbewmDialog();//2
	initPreviewBDXXDialog();//3
	initOutputExcelDialog();//4
	
	initDialogPosition();//??????????????????????????????????????????
	showCompontByQx();
});

function initLxlxVar(){
	syLxlx=parseInt('${requestScope.syLxlx}');
	qyLxlx=parseInt('${requestScope.qyLxlx}');

	syLxlxMc='${requestScope.syLxlxMc}';
	qyLxlxMc='${requestScope.qyLxlxMc}';
}

function initGbztVar(){
	dsbGbzt=parseInt('${requestScope.dsbGbzt}');
	sbzGbzt=parseInt('${requestScope.sbzGbzt}');
	dczGbzt=parseInt('${requestScope.dczGbzt}');
	czzGbzt=parseInt('${requestScope.czzGbzt}');
	dxbGbzt=parseInt('${requestScope.dxbGbzt}');
	xbzGbzt=parseInt('${requestScope.xbzGbzt}');
	ywcGbzt=parseInt('${requestScope.ywcGbzt}');
	
	dsbGbztMc='${requestScope.dsbGbztMc}';
	sbzGbztMc='${requestScope.sbzGbztMc}';
	dczGbztMc='${requestScope.dczGbztMc}';
	czzGbztMc='${requestScope.czzGbztMc}';
	dxbGbztMc='${requestScope.dxbGbztMc}';
	xbzGbztMc='${requestScope.xbzGbztMc}';
	ywcGbztMc='${requestScope.ywcGbztMc}';
}

function initPlaceFlagVar(){
	wgb=parseInt('${requestScope.wgb}');
	yhbf=parseInt('${requestScope.yhbf}');
	ehbf=parseInt('${requestScope.ehbf}');
	shbf=parseInt('${requestScope.shbf}');
	mg=parseInt('${requestScope.mg}');

	wgbMc='${requestScope.wgbMc}';
	yhbfMc='${requestScope.yhbfMc}';
	ehbfMc='${requestScope.ehbfMc}';
	shbfMc='${requestScope.shbfMc}';
	mgMc='${requestScope.mgMc}';
}

function initPushVar(){
	pushEwm='${requestScope.pushEwm}';
	pushCph='${requestScope.pushCph}';
	pushSfzh='${requestScope.pushSfzh}';
}

function initDcfwVar(){
	dqyDcfw=parseInt('${requestScope.dqyDcfw}');
	syyDcfw=parseInt('${requestScope.syyDcfw}');

	dqyDcfwMc='${requestScope.dqyDcfwMc}';
	syyDcfwMc='${requestScope.syyDcfwMc}';
}

function showCompontByQx(){
	rgsbsfzLB.hide();
	rgsbcpLB.hide();
	rgsbewmLB.hide();
	ddfwLB.hide();
	bddyLB.hide();
	addLB.hide();
	removeLB.hide();
	if(yhm=="admin"){
		rgsbsfzLB.show();
		rgsbcpLB.show();
		rgsbewmLB.show();
		ddfwLB.show();
		bddyLB.show();
		addLB.show();
		removeLB.show();
	}
	else{
		var rgsbsfzQx='${requestScope.rgsbsfzQx}';
		var rgsbcpQx='${requestScope.rgsbcpQx}';
		var rgsbewmQx='${requestScope.rgsbewmQx}';
		var ddfwQx='${requestScope.ddfwQx}';
		var bddyQx='${requestScope.bddyQx}';
		var tjddQx='${requestScope.tjddQx}';
		var scddQx='${requestScope.scddQx}';
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==rgsbsfzQx){
				rgsbsfzLB.show();
			}
			if(qxIdsArr[i]==rgsbcpQx){
				rgsbcpLB.show();
			}
			if(qxIdsArr[i]==rgsbewmQx){
				rgsbewmLB.show();
			}
			if(qxIdsArr[i]==ddfwQx){
				ddfwLB.show();
			}
			if(qxIdsArr[i]==bddyQx){
				bddyLB.show();
			}
			if(qxIdsArr[i]==tjddQx){
				addLB.show();
			}
			if(qxIdsArr[i]==scddQx){
				removeLB.show();
			}
		}
	}
}

function showOptionButByQx(){
	if(yhm=="admin"){
		$(".tab1_div .edit_a").css("visibility","visible");
	}
	else{
		var xgddQx='${requestScope.xgddQx}';
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==xgddQx){
				$(".tab1_div .edit_a").css("visibility","visible");
			}
		}
	}
}

function initDialogPosition(){
	var isfzhdpw=$("body").find(".panel.window").eq(isfzhdNum);
	var isfzhdws=$("body").find(".window-shadow").eq(isfzhdNum);
	
	var icphdpw=$("body").find(".panel.window").eq(icphdNum);
	var icphdws=$("body").find(".window-shadow").eq(icphdNum);
	
	var iewmdpw=$("body").find(".panel.window").eq(iewmdNum);
	var iewmdws=$("body").find(".window-shadow").eq(iewmdNum);
	
	var pbdxxdpw=$("body").find(".panel.window").eq(pbdxxdNum);
	var pbdxxdws=$("body").find(".window-shadow").eq(pbdxxdNum);
	
	var oedpw=$("body").find(".panel.window").eq(oedNum);
	var oedws=$("body").find(".window-shadow").eq(oedNum);

	var isfzhdDiv=$("#input_sfzh_div");
	isfzhdDiv.append(isfzhdpw);
	isfzhdDiv.append(isfzhdws);
	
	var icphdDiv=$("#input_cph_div");
	icphdDiv.append(icphdpw);
	icphdDiv.append(icphdws);
	
	var iewmdDiv=$("#input_ewm_div");
	iewmdDiv.append(iewmdpw);
	iewmdDiv.append(iewmdws);

	var pbdxxdDiv=$("#preview_bdxx_div");
	pbdxxdDiv.append(pbdxxdpw);
	pbdxxdDiv.append(pbdxxdws);

	var oedDiv=$("#output_excel_div");
	oedDiv.append(oedpw);
	oedDiv.append(oedws);
}

function initInputSfzhDialog(){
	$("#input_sfzh_dialog_div").dialog({
		title:"??????????????????",
		width:setFitWidthInParent("#input_sfzh_div","input_sfzh_dialog_div"),
		height:200,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"??????",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkSfzhToClient();
           }},
           {text:"??????",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openInputSfzhDialog(false);
           }}
        ]
	});

	$("#input_sfzh_dialog_div table").css("width",(setFitWidthInParent("#input_sfzh_div","input_sfzh_dialog_table"))+"px");
	$("#input_sfzh_dialog_div table").css("magin","-100px");
	$("#input_sfzh_dialog_div table td").css("padding-left","40px");
	$("#input_sfzh_dialog_div table td").css("padding-right","20px");
	$("#input_sfzh_dialog_div table td").css("font-size","15px");
	$("#input_sfzh_dialog_div table .td1").css("width","30%");
	$("#input_sfzh_dialog_div table .td2").css("width","60%");
	$("#input_sfzh_dialog_div table tr").css("height","45px");

	$(".panel.window").eq(isfzhdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(isfzhdNum).css("color","#000");
	$(".panel.window .panel-title").eq(isfzhdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(isfzhdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//?????????????????????????????????
	$(".window-shadow").eq(isfzhdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(isfzhdNum).css("border-color","#ddd");

	$("#input_sfzh_dialog_div #ok_but").css("left","30%");
	$("#input_sfzh_dialog_div #ok_but").css("position","absolute");

	$("#input_sfzh_dialog_div #cancel_but").css("left","50%");
	$("#input_sfzh_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initXzSfzhCBB();
}

function initXzSfzhCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	$.post(ddglPath+"queryXzSfzhCBBList",
		{page:1,rows:20,sort:"lrsj",order:"desc"},
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i],"text":rows[i]});
			}
			xzsfzhCBB=$("#xzsfzh_cbb").combobox({
				width:120,
				valueField:"value",
				textField:"text",
				data:data,
				onChange:function(){
					var sfzh=xzsfzhCBB.combobox("getValue");
					$("#input_sfzh_div #sfzh_inp").val(sfzh);
				}
			});
		}
	,"json");
}

function initInputRgsbcpDialog(){
	$("#input_cph_dialog_div").dialog({
		title:"???????????????",
		width:setFitWidthInParent("#input_cph_div","input_cph_dialog_div"),
		height:250,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"??????",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkCphToClient();
           }},
           {text:"??????",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openInputCphDialog(false);
           }}
        ]
	});

	$("#input_cph_dialog_div table").css("width",(setFitWidthInParent("#input_cph_div","input_cph_dialog_table"))+"px");
	$("#input_cph_dialog_div table").css("magin","-100px");
	$("#input_cph_dialog_div table td").css("padding-left","40px");
	$("#input_cph_dialog_div table td").css("padding-right","20px");
	$("#input_cph_dialog_div table td").css("font-size","15px");
	$("#input_cph_dialog_div table .td1").css("width","30%");
	$("#input_cph_dialog_div table .td2").css("width","60%");
	$("#input_cph_dialog_div table tr").css("height","45px");

	$(".panel.window").eq(icphdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(icphdNum).css("color","#000");
	$(".panel.window .panel-title").eq(icphdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(icphdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//?????????????????????????????????
	$(".window-shadow").eq(icphdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(icphdNum).css("border-color","#ddd");

	$("#input_cph_dialog_div #ok_but").css("left","30%");
	$("#input_cph_dialog_div #ok_but").css("position","absolute");

	$("#input_cph_dialog_div #cancel_but").css("left","50%");
	$("#input_cph_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initRgsbcpPlaceCBB();
	initRgsbcpXzCphCBB();
	initRgsbcpLrSjcCBB();
	initRgsbcpLrWscphCBB();
}

function initRgsbcpPlaceCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	data.push({"value":mg,"text":mgMc});
	data.push({"value":yhbf,"text":yhbfMc});
	data.push({"value":ehbf,"text":ehbfMc});
	data.push({"value":shbf,"text":shbfMc});
	
	rgsbcpPlaceCBB=$("#rgsbcp_place_cbb").combobox({
		width:120,
		valueField:"value",
		textField:"text",
		//multiple:true,
		data:data
	});
}

function initRgsbcpXzCphCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	$.post(ddglPath+"queryXzCphCBBList",
		{page:1,rows:20,sort:"lrsj",order:"desc"},
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i],"text":rows[i]});
			}
			rgsbcpXzcphCBB=$("#rgsbcp_xzcph_cbb").combobox({
				width:120,
				valueField:"value",
				textField:"text",
				data:data,
				onChange:function(){
					var cph=rgsbcpXzcphCBB.combobox("getValue");
					rgsbcpLrSjcCBB.combobox("setValue",cph.substring(0,1));
					rgsbcpLrWscphCBB.combobox("setValue",cph.substring(1));
				}
			});
		}
	,"json");
}

function initRgsbcpLrSjcCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	rgsbcpLrSjcCBB=$("#rgsbcp_lrSjc_cbb").combobox({
		width:50,
		valueField:"sjc",
		textField:"sjc",
		editable:true,
        mode:'remote',
        url:ddglPath+"queryLrSjcCBBList",
        onBeforeLoad: function(param){
    		param.page = 1;
    		param.rows = 100;
    		param.sort = "lrsj";
    		param.order = "desc";
    	}
	});
}

function initRgsbcpLrWscphCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	rgsbcpLrWscphCBB=$("#rgsbcp_lrWscph_cbb").combobox({
		width:70,
		valueField:"wscph",
		textField:"wscph",
		editable:true,
        mode:'remote',
        url:ddglPath+"queryLrWscphCBBList",
        onBeforeLoad: function(param){
        	var sjc=rgsbcpLrSjcCBB.combobox("getValue");
        	if(sjc==null||sjc==""){
        	  	return false;
        	}
    		param.sjc = sjc;
    		param.page = 1;
    		param.rows = 100;
    		param.sort = "lrsj";
    		param.order = "desc";
    	}
	});
}

function initInputRgsbewmDialog(){
	$("#input_ewm_dialog_div").dialog({
		title:"?????????????????????",
		width:setFitWidthInParent("#input_ewm_div","input_ewm_dialog_div"),
		height:250,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"??????",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkEwmToClient();
           }},
           {text:"??????",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openInputEwmDialog(false);
           }}
        ]
	});

	$("#input_ewm_dialog_div table").css("width",(setFitWidthInParent("#input_ewm_div","input_ewm_dialog_table"))+"px");
	$("#input_ewm_dialog_div table").css("magin","-100px");
	$("#input_ewm_dialog_div table td").css("padding-left","40px");
	$("#input_ewm_dialog_div table td").css("padding-right","20px");
	$("#input_ewm_dialog_div table td").css("font-size","15px");
	$("#input_ewm_dialog_div table .td1").css("width","30%");
	$("#input_ewm_dialog_div table .td2").css("width","60%");
	$("#input_ewm_dialog_div table tr").css("height","45px");

	$(".panel.window").eq(iewmdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(iewmdNum).css("color","#000");
	$(".panel.window .panel-title").eq(iewmdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(iewmdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//?????????????????????????????????
	$(".window-shadow").eq(iewmdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(iewmdNum).css("border-color","#ddd");

	$("#input_ewm_dialog_div #ok_but").css("left","30%");
	$("#input_ewm_dialog_div #ok_but").css("position","absolute");

	$("#input_ewm_dialog_div #cancel_but").css("left","50%");
	$("#input_ewm_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initRgsbewmPlaceCBB();
	initRgsbewmXzCphCBB();
	initRgsbewmLrSjcCBB();
	initRgsbewmLrWscphCBB();
}

function initRgsbewmPlaceCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	data.push({"value":yhbf,"text":yhbfMc});
	data.push({"value":ehbf,"text":ehbfMc});
	data.push({"value":shbf,"text":shbfMc});
	
	rgsbewmPlaceCBB=$("#rgsbewm_place_cbb").combobox({
		width:120,
		valueField:"value",
		textField:"text",
		//multiple:true,
		data:data
	});
}

function initRgsbewmXzCphCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	$.post(ddglPath+"queryXzCphCBBList",
		{page:1,rows:20,sort:"lrsj",order:"desc"},
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i],"text":rows[i]});
			}
			rgsbewmXzcphCBB=$("#rgsbewm_xzcph_cbb").combobox({
				width:120,
				valueField:"value",
				textField:"text",
				data:data,
				onChange:function(){
					var cph=rgsbewmXzcphCBB.combobox("getValue");
					rgsbewmLrSjcCBB.combobox("setValue",cph.substring(0,1));
					rgsbewmLrWscphCBB.combobox("setValue",cph.substring(1));
				}
			});
		}
	,"json");
}

function initRgsbewmLrSjcCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	rgsbewmLrSjcCBB=$("#rgsbewm_lrSjc_cbb").combobox({
		width:50,
		valueField:"sjc",
		textField:"sjc",
		editable:true,
        mode:'remote',
        url:ddglPath+"queryLrSjcCBBList",
        onBeforeLoad: function(param){
    		param.page = 1;
    		param.rows = 100;
    		param.sort = "lrsj";
    		param.order = "desc";
    	}
	});
}

function initRgsbewmLrWscphCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
	rgsbewmLrWscphCBB=$("#rgsbewm_lrWscph_cbb").combobox({
		width:70,
		valueField:"wscph",
		textField:"wscph",
		editable:true,
        mode:'remote',
        url:ddglPath+"queryLrWscphCBBList",
        onBeforeLoad: function(param){
        	var sjc=rgsbewmLrSjcCBB.combobox("getValue");
        	if(sjc==null||sjc==""){
        	  	return false;
        	}
    		param.sjc = sjc;
    		param.page = 1;
    		param.rows = 100;
    		param.sort = "lrsj";
    		param.order = "desc";
    	}
	});
}

function initPreviewBDXXDialog(){
	dialogTop+=20;
	$("#preview_bdxx_dialog_div").dialog({
		title:"????????????",
		width:setFitWidthInParent("#preview_bdxx_div","preview_bdxx_dialog_div"),
		height:480,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"??????",id:"print_but",iconCls:"icon-ok",handler:function(){
        	   var time=new Date().getTime();
        	   var printHtml = $("#preview_bdxx_dialog_div .panel-body").html();
        	   $.post(gbglPath+"newDaYinJiLu",
        		  {time:time,html:printHtml},
        	   	  function(data){
        		   	 if(data.message=="ok"){
        		   		if(checkBddyddZt())
        		   			changeDdztToDlc();
        	        	window.open(gbglPath+"bdjl/print?time="+time);
        		   	 }
        	      }
        	   ,"json");
        	   //window.document.body.innerHTML= $("#preview_bdxx_dialog_div .panel-body").html();
        	   //window.print();//???????????????????????????
        	   //window.document.body.innerHTML= pageHtml;
        	   //location.href=location.href;
           }},
           {text:"??????",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openPreviewBDXXDialog(false,null);
           }}
        ]
	});

	$(".panel.window").eq(pbdxxdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(pbdxxdNum).css("color","#000");
	$(".panel.window .panel-title").eq(pbdxxdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(pbdxxdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//?????????????????????????????????
	$(".window-shadow").eq(pbdxxdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(pbdxxdNum).css("border-color","#ddd");

	$("#preview_bdxx_dialog_div #print_but").css("left","30%");
	$("#preview_bdxx_dialog_div #print_but").css("position","absolute");

	$("#preview_bdxx_dialog_div #cancel_but").css("left","45%");
	$("#preview_bdxx_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");
	
	initPreviewModuleHtmlStr();
}

function initPreviewModuleHtmlStr(){
	appendStr="<div style=\"width: 100%;height:40px;line-height:40px;text-align: center;font-size: 20px;font-weight: bold;\">???????????????????????????????????????</div>";
  	
	appendStr+="<div style=\"width: 90%;height:30px;line-height:30px;margin:auto;\">";
		appendStr+="<span class=\"dysj_key_td\" style=\"margin-left: 10px;\">???????????????</span>";
		appendStr+="<span id=\"dysj_val_span\" style=\"margin-left: 20px;\"></span>";
		appendStr+="<span id=\"dh_key_span\" style=\"margin-left: 120px;\">??????:</span>";
		appendStr+="<span id=\"dh_val_span\" style=\"margin-left: 20px;\"></span>";
	    appendStr+="<span style=\"margin-left: 50px;\">?????????kg</span>";
    appendStr+="</div>";
    
	appendStr+="<table border=\"1\" style=\"width: 90%;margin:auto;text-align: center;border-color: #000;border-spacing:0;\">";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"wzMc_key_td\" style=\"width: 10%;\">????????????</td>";
			appendStr+="<td class=\"wzMc_val_td\" id=\"wzMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"wzlxMc_key_td\" style=\"width: 10%;\">??????</td>";
			appendStr+="<td class=\"wzlxMc_val_td\" id=\"wzlxMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"cyclCph_key_td\" style=\"width: 10%;\">??????</td>";
			appendStr+="<td class=\"cyclCph_val_td\" id=\"cyclCph_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"fhdwMc_key_td\">????????????</td>";
			appendStr+="<td class=\"fhdwMc_val_td\" id=\"fhdwMc_val_td\"></td>";
			appendStr+="<td class=\"mz_key_td\">????????????</td>";
			appendStr+="<td class=\"mz_val_td\" id=\"mz_val_td\"></td>";
			appendStr+="<td class=\"dfgbmz_key_td\">????????????</td>";
			appendStr+="<td class=\"dfgbmz_val_td\" id=\"dfgbmz_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"shdwMc_key_td\">????????????</td>";
			appendStr+="<td class=\"shdwMc_val_td\" id=\"shdwMc_val_td\"></td>";
			appendStr+="<td class=\"pz_key_td\">????????????</td>";
			appendStr+="<td class=\"pz_val_td\" id=\"pz_val_td\"></td>";
			appendStr+="<td class=\"dfgbpz_key_td\">????????????</td>";
			appendStr+="<td class=\"dfgbpz_val_td\" id=\"dfgbpz_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"yssMc_key_td\">????????????</td>";
			appendStr+="<td class=\"yssMc_val_td\" id=\"yssMc_val_td\"></td>";
			appendStr+="<td class=\"jz_key_td\">????????????</td>";
			appendStr+="<td class=\"jz_val_td\" id=\"jz_val_td\"></td>";
			appendStr+="<td class=\"dfgbjz_key_td\">????????????</td>";
			appendStr+="<td class=\"dfgbjz_val_td\" id=\"dfgbjz_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"jcsj_key_td\">????????????</td>";
			appendStr+="<td class=\"jcsj_val_td\" id=\"jcsj_val_td\"></td>";
			appendStr+="<td class=\"bs_key_td\">??? ???</td>";
			appendStr+="<td class=\"bs_val_td\" id=\"bs_val_td\"></td>";
			appendStr+="<td class=\"ks_key_td\">??? ???</td>";
			appendStr+="<td class=\"ks_val_td\" id=\"ks_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"ccsj_key_td\">????????????</td>";
			appendStr+="<td class=\"ccsj_val_td\" id=\"ccsj_val_td\"></td>";
			appendStr+="<td class=\"jszl_key_td\">????????????</td>";
			appendStr+="<td class=\"jszl_val_td\" id=\"jszl_val_td\"></td>";
			appendStr+="<td class=\"bz_key_td\">??? ???</td>";
			appendStr+="<td class=\"bz_val_td\" id=\"bz_val_td\"></td>";
		appendStr+="</tr>";
	appendStr+="</table>";
	
  	appendStr+="<div style=\"width: 90%;height:30px;line-height:30px;margin:auto;\">";
		appendStr+="<span id=\"gby_key_span\" style=\"margin-left: 20px;\">?????????</span>";
		appendStr+="<span id=\"gby_val_span\" style=\"margin-left: 20px;\"></span>";
		appendStr+="<span id=\"cysjXm_key_span\" style=\"margin-left: 120px;\">??????</span>";
		appendStr+="<span id=\"cysjXm_val_span\" style=\"margin-left: 20px;\"></span>";
    appendStr+="</div>";
}

function initOutputExcelDialog(){
	$("#output_excel_dialog_div").dialog({
		title:"??????excel",
		width:setFitWidthInParent("#output_excel_div","output_excel_dialog_div"),
		height:150,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"??????",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   if(checkDcfw()){
        		   	var params="";
        			var ddh=$("#toolbar #ddh").val();
        			var ddztId=ddztCBB.combobox("getValue");
        			var cyclCph=encodeURIParam($("#toolbar #cyclCph").val());
        			var jhysrq=jhysrqDB.datebox("getValue");
        			var yssMc=encodeURIParam($("#toolbar #yssMc").val());
        			var wzMc=encodeURIParam($("#toolbar #wzMc").val());
        			var fhdwMc=encodeURIParam($("#toolbar #fhdwMc").val());
        			var shdwMc=encodeURIParam($("#toolbar #shdwMc").val());
        			var cysjXm=encodeURIParam($("#toolbar #cysjXm").val());
        			var jcsjs=jcsjsDTB.datetimebox("getValue");
        			var jcsje=jcsjeDTB.datetimebox("getValue");
        			var ccsjs=ccsjsDTB.datetimebox("getValue");
        			var ccsje=ccsjeDTB.datetimebox("getValue");
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="ddh="+ddh+"&wzMc="+wzMc+"&yssMc="+yssMc+"&fhdwMc="+fhdwMc+"&shdwMc="+shdwMc+"&sheetFlag="+sheetFlag+"&dcfw="+dcfw;
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
           {text:"??????",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
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
	
	//?????????????????????????????????
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
	data.push({"value":"","text":"?????????"});
	data.push({"value":dqyDcfw,"text":dqyDcfwMc});
	data.push({"value":syyDcfw,"text":syyDcfwMc});
	dcfwCBB=$("#dcfw_cbb").combobox({
		width:120,
		valueField:"value",
		textField:"text",
		data:data
	});
}

//??????????????????
function checkDcfw(){
	var dcfw=dcfwCBB.combobox("getValue");
	if(dcfw==null||dcfw==""){
	  	alert("?????????????????????");
	  	return false;
	}
	else
		return true;
}

function checkSfzhToClient(){
	if(checkRglrSfzh()){
		pushSfzhToClient();
	}
}

//??????????????????????????????
function checkRglrSfzh(){
	var sfzh = $("#input_sfzh_div #sfzh_inp").val();
	if(sfzh==null||sfzh==""||sfzh=="????????????????????????"){
		$("#input_sfzh_div #sfzh_inp").css("color","#E15748");
    	$("#input_sfzh_div #sfzh_inp").val("????????????????????????");
    	return false;
	}
	else
		return true;
}

function pushSfzhToClient(){
	var rows=tab1.datagrid("getSelections");
	var sfzh = $("#input_sfzh_div #sfzh_inp").val();
	if(sfzh!=rows[0].cysjSfzh){
		alert("?????????????????????????????????????????????????????????");
		return false;
	}
	
	var paramJO={};
	paramJO.sfzh=sfzh;
	paramJO.pushFlag=pushSfzh;
	
	var ddztMc=rows[0].ddztMc;
	if(ddztMc!='${requestScope.yxdDdztMc}'){//?????????
		alert("????????????"+ddztMc+"??????");
		return false;
	}
	
	var ddId=rows[0].id;
	paramJO.ddId=ddId;
	$.post(gkjPath+"pushToClient",
		paramJO,
		function(data){
			if(data.status=="ok"){
				openInputSfzhDialog(false);
			}
		}
	,"json");
}

function checkCphToClient(){
	if(checkRgsbcpPlace()){
		if(checkRgsbcpRglrCph()){
			pushRgsbcphToClient();
		}
	}
}

//????????????
function checkRgsbcpPlace(){
	var bfh=rgsbcpPlaceCBB.combobox("getValue");
	if(bfh==null||bfh==""){
	  	alert("???????????????");
	  	return false;
	}
	else
		return true;
}

//???????????????????????????
function checkRgsbcpRglrCph(){
	var sjc=rgsbcpLrSjcCBB.combobox("getValue");
	var wscph=rgsbcpLrWscphCBB.combobox("getValue");
	if(sjc==null||sjc==""||wscph==null||wscph==""){
	  	alert("??????????????????");
	  	return false;
	}
	else
		return true;
}

function pushRgsbcphToClient(){
	var rows=tab1.datagrid("getSelections");
	var placeFlag=parseInt(rgsbcpPlaceCBB.combobox("getValue"));
	var sjc=rgsbcpLrSjcCBB.combobox("getValue");
	var wscph=rgsbcpLrWscphCBB.combobox("getValue");
	var cph=sjc+wscph;
	if(cph!=rows[0].cyclCph){
		alert("???????????????????????????????????????????????????");
		return false;
	}
	
	var paramJO={};
	paramJO.cph=cph;
	paramJO.placeFlag=placeFlag;
	paramJO.pushFlag=pushCph;
	
	var ddztMc=rows[0].ddztMc;
	switch (placeFlag) {
	case yhbf:
	case ehbf:
	case shbf:
		var jyFlag=0;
		if(ddztMc=='${requestScope.yjdsbDdztMc}')//???????????????
			jyFlag=1
		else if(ddztMc=='${requestScope.ejdsbDdztMc}')//???????????????
			jyFlag=2
		else{
			alert("???????????????????????????");
			return false;
		}
		paramJO.jyFlag=jyFlag;
		break;
	case mg:
		var jccFlag=0;//???????????????
		if(ddztMc=='${requestScope.drcDdztMc}')//?????????
			jccFlag=1;
		else if(ddztMc=='${requestScope.ddypzDdztMc}'||ddztMc=='${requestScope.dlcDdztMc}')//???????????????????????????
			jccFlag=2
		else{
			alert("???????????????????????????????????????");
			return false;
		}
		paramJO.jccFlag=jccFlag;
		break;
	}
	
	
	var ddId=rows[0].id;
	paramJO.ddId=ddId;
	$.post(gkjPath+"pushToClient",
		//{ddId:ddId,cph:cph,placeFlag:placeFlag,pushFlag:pushCph},
		paramJO,
		function(data){
			if(data.status=="ok"){
				openInputCphDialog(false);
			}
		}
	,"json");
}

function checkEwmToClient(){
	if(checkRgsbewmPlace()){
		if(checkRgsbewmRglrCph()){
			pushRgsbewmToClient();
		}
	}
}

//????????????
function checkRgsbewmPlace(){
	var bfh=rgsbewmPlaceCBB.combobox("getValue");
	if(bfh==null||bfh==""){
	  	alert("???????????????");
	  	return false;
	}
	else
		return true;
}

//????????????????????????????????????
function checkRgsbewmRglrCph(){
	var sjc=rgsbewmLrSjcCBB.combobox("getValue");
	var wscph=rgsbewmLrWscphCBB.combobox("getValue");
	if(sjc==null||sjc==""||wscph==null||wscph==""){
	  	alert("??????????????????");
	  	return false;
	}
	else
		return true;
}

function pushRgsbewmToClient(){
	var rows=tab1.datagrid("getSelections");
	var placeFlag=parseInt(rgsbewmPlaceCBB.combobox("getValue"));
	var sjc=rgsbewmLrSjcCBB.combobox("getValue");
	var wscph=rgsbewmLrWscphCBB.combobox("getValue");
	var cph=sjc+wscph;
	if(cph!=rows[0].cyclCph){
		alert("???????????????????????????????????????????????????");
		return false;
	}
	
	var paramJO={};
	paramJO.cph=cph;
	paramJO.placeFlag=placeFlag;
	paramJO.pushFlag=pushEwm;
	
	var ddztMc=rows[0].ddztMc;
	switch (placeFlag) {
	case yhbf:
	case ehbf:
	case shbf:
		var jyFlag=0;
		if(ddztMc=='${requestScope.yjdsmDdztMc}')//???????????????
			jyFlag=1
		else if(ddztMc=='${requestScope.ejdsmDdztMc}')//???????????????
			jyFlag=2
		else{
			alert("???????????????????????????");
			return false;
		}
		paramJO.jyFlag=jyFlag;
		break;
	}
	
	
	var ddId=rows[0].id;
	paramJO.ddId=ddId;
	$.post(gkjPath+"pushToClient",
		paramJO,
		function(data){
			if(data.status=="ok"){
				openInputEwmDialog(false);
			}
		}
	,"json");
}

function initDDZTCBB(){
	var data=[];
	data.push({"value":"","text":"?????????"});
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

function initJHYSRQDB(){
	jhysrqDB=$('#jhysrq_db').datebox({
        required:false
    });
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
			var ddztId=ddztCBB.combobox("getValue");
			var cyclCph=$("#toolbar #cyclCph").val();
			var jhysrq=jhysrqDB.datebox("getValue");
			var yssMc=$("#toolbar #yssMc").val();
			var wzMc=$("#toolbar #wzMc").val();
			var fhdwMc=$("#toolbar #fhdwMc").val();
			var shdwMc=$("#toolbar #shdwMc").val();
			var cysjXm=$("#toolbar #cysjXm").val();
			var jcsjs=jcsjsDTB.datetimebox("getValue");
			var jcsje=jcsjeDTB.datetimebox("getValue");
			var ccsjs=ccsjsDTB.datetimebox("getValue");
			var ccsje=ccsjeDTB.datetimebox("getValue");
			
			tab1.datagrid("load",{ddh:ddh,ddztId:ddztId,cyclCph:cyclCph,jhysrq:jhysrq,yssMc:yssMc,
				wzMc:wzMc,fhdwMc:fhdwMc,shdwMc:shdwMc,cysjXm:cysjXm,jcsjs:jcsjs,jcsje:jcsje,ccsjs:ccsjs,ccsje:ccsje});
		}
	});
}

function initRgsbsfzLB(){
	rgsbsfzLB=$("#rgsbsfz_but").linkbutton({
		iconCls:"icon-save",
		onClick:function(){
			openInputSfzhDialog(true);
		}
	});
}

function initRgsbcpLB(){
	rgsbcpLB=$("#rgsbcp_but").linkbutton({
		iconCls:"icon-save",
		onClick:function(){
			openInputCphDialog(true);
		}
	});
}

function initRgsbewmLB(){
	rgsbewmLB=$("#rgsbewm_but").linkbutton({
		iconCls:"icon-save",
		onClick:function(){
			openInputEwmDialog(true);
		}
	});
}

function initDdfwLB(){
	ddfwLB=$("#ddfw_but").linkbutton({
		iconCls:"icon-back",
		onClick:function(){
			var rows=tab1.datagrid("getSelections");
			if (rows.length == 0) {
				$.messager.alert("??????","????????????????????????????????????","warning");
				return false;
			}
			if(checkFwddZt()){
				fwddById();
			}
		}
	});
}

function initBddyLB(){
	bddyLB=$("#bddy_but").linkbutton({
		iconCls:"icon-print",
		onClick:function(){
			var rows=tab1.datagrid("getSelections");
			if (rows.length == 0) {
				$.messager.alert("??????","??????????????????????????????????????????","warning");
				return false;
			}
   			openPreviewBDXXDialog(true,rows[0]);
		}
	});
}

function initAddLB(){
	addLB=$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=ddglPath+"zhcx/new";
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
		title:"????????????-????????????-??????",
		url:ddglPath+"queryZHCXList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		pagination:true,
		pageSize:10,
		columns:[[
            {field:"id",title:"??????",width:100,formatter:function(value,row){
            	var str;
           		if(row.id!="<div style=\"text-align:center;\">????????????<div>"){
	            	str="<a class=\"edit_a\" href=\"edit?id="+value+"\">??????</a>&nbsp;&nbsp;"
	            	   +"<a href=\"detail?id="+value+"\">??????</a>&nbsp;&nbsp;";
           		}
           		else
           			str=value;
            	return str;
            }},
			{field:"ddh",title:"?????????",width:150},
			{field:"cysjSfzh",title:"??????????????????",width:200},
			{field:"wzlxMc",title:"????????????",width:150},
			{field:"wzMc",title:"????????????",width:150},
			{field:"cyclCph",title:"?????????",width:150},
			{field:"yssMc",title:"?????????",width:150},
			{field:"fhdwMc",title:"????????????",width:150},
			{field:"shdwMc",title:"????????????",width:150},
            {field:"lxlx",title:"????????????",width:100,formatter:function(value,row){
            	return getLxlxMcById(value);
            }},
			{field:"jhysrq",title:"??????????????????",width:150},
			{field:"ddztMc",title:"????????????",width:150},
			{field:"yjzt",title:"????????????",width:100,formatter:function(value,row){
            	return getGbztMcById(value);
            }},
			{field:"ejzt",title:"????????????",width:100,formatter:function(value,row){
				return getGbztMcById(value);
            }},
            {field:"yjbfh",title:"????????????",width:100,formatter:function(value,row){
            	return getBfMcByBfh(value);
            }},
            {field:"ejbfh",title:"????????????",width:100,formatter:function(value,row){
            	return getBfMcByBfh(value);
            }},
            {field:"yzxzl",title:"???????????????",width:150},
            {field:"bjsj",title:"????????????",width:150},
            {field:"jcsj",title:"????????????",width:150},
            {field:"ccsj",title:"????????????",width:150},
            {field:"mz",title:"??????",width:100},
            {field:"pz",title:"??????",width:150},
            {field:"sjzl",title:"????????????",width:150},
            {field:"dfgbmz",title:"??????????????????",width:150},
            {field:"dfgbpz",title:"??????????????????",width:150},
            {field:"dfgbjz",title:"??????????????????",width:150}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{id:"<div style=\"text-align:center;\">????????????<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"id",colspan:26});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");
			
			showOptionButByQx();
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
		str=syLxlxMc;//??????
		break;
	case qyLxlx:
		str=qyLxlxMc;//??????
		break;
	}
	return str;
}

function getGbztMcById(gbztId){
	var str;
	switch (gbztId) {
	case dsbGbzt:
		str=dsbGbztMc;//?????????
		break;
	case sbzGbzt:
		str=sbzGbztMc;//?????????
		break;
	case dczGbzt:
		str=dczGbztMc;//?????????
		break;
	case czzGbzt:
		str=czzGbztMc;//?????????
		break;
	case dxbGbzt:
		str=dxbGbztMc;//?????????
		break;
	case xbzGbzt:
		str=xbzGbztMc;//?????????
		break;
	case ywcGbzt:
		str=ywcGbztMc;//?????????
		break;
	}
	return str;
}

function getBfMcByBfh(bfh){
	var str;
	switch (bfh) {
	case wgb:
		str=wgbMc;
		break;
	case yhbf:
		str=yhbfMc;
		break;
	case ehbf:
		str=ehbfMc;
		break;
	case shbf:
		str=shbfMc;
		break;
	}
	return str;
}

function openInputSfzhDialog(flag){
	if(flag){
		$("#input_sfzh_bg_div").css("display","block");
	}
	else{
		$("#input_sfzh_bg_div").css("display","none");
	}
}

function openInputCphDialog(flag){
	if(flag){
		$("#input_cph_bg_div").css("display","block");
	}
	else{
		$("#input_cph_bg_div").css("display","none");
	}
}

function openInputEwmDialog(flag){
	if(flag){
		$("#input_ewm_bg_div").css("display","block");
	}
	else{
		$("#input_ewm_bg_div").css("display","none");
	}
}

function openPreviewBDXXDialog(flag,row){
	var panelBody=$("#preview_bdxx_dialog_div .panel-body");
	panelBody.empty();
	if(flag){
		panelBody.append(appendStr);
		
		$("#preview_bdxx_bg_div").css("display","block");
		
		$("#preview_bdxx_div #dysj_val_span").text(createDysj());
		$("#preview_bdxx_div #dh_val_span").text(row.ddh);
		
		$("#preview_bdxx_div #wzMc_val_td").text(row.wzMc);
		$("#preview_bdxx_div #wzlxMc_val_td").text(row.wzlxMc);
		$("#preview_bdxx_div table #cyclCph_val_td").text(row.cyclCph);
		
		$("#preview_bdxx_div table #fhdwMc_val_td").text(row.fhdwMc);
		$("#preview_bdxx_div table #mz_val_td").text(row.mz);
		$("#preview_bdxx_div table #dfgbmz_val_td").text(row.dfgbmz);
		
		$("#preview_bdxx_div table #shdwMc_val_td").text(row.shdwMc);
		$("#preview_bdxx_div table #pz_val_td").text(row.pz);
		$("#preview_bdxx_div table #dfgbpz_val_td").text(row.dfgbpz);
		
		$("#preview_bdxx_div table #yssMc_val_td").text(row.shdwMc);
		$("#preview_bdxx_div table #jz_val_td").text(row.jz);
		$("#preview_bdxx_div table #dfgbjz_val_td").text(row.dfgbjz);
		
		$("#preview_bdxx_div table #jcsj_val_td").text(row.jcsj);
		$("#preview_bdxx_div table #bs_val_td").text(row.bs);
		$("#preview_bdxx_div table #ks_val_td").text(row.ks);
		
		$("#preview_bdxx_div table #ccsj_val_td").text(row.ccsj);
		$("#preview_bdxx_div table #jszl_val_td").text(row.jszl);
		$("#preview_bdxx_div table #bz_val_td").text(row.bz);
		
		$("#preview_bdxx_div #gby_val_span").text(row.cysjXm);
		$("#preview_bdxx_div #cysjXm_val_span").text(row.cysjXm);
	}
	else{
		$("#preview_bdxx_bg_div").css("display","none");
		
		$("#preview_bdxx_div #dysj_val_span").text("");
		$("#preview_bdxx_div #dh_val_span").text("");
		
		$("#preview_bdxx_div #wzMc_val_td").text("");
		$("#preview_bdxx_div #wzlxMc_val_td").text("");
		$("#preview_bdxx_div table #cyclCph_val_td").text("");
		
		$("#preview_bdxx_div table #fhdwMc_val_td").text("");
		$("#preview_bdxx_div table #mz_val_td").text("");
		$("#preview_bdxx_div table #dfgbmz_val_td").text("");
		
		$("#preview_bdxx_div table #shdwMc_val_td").text("");
		$("#preview_bdxx_div table #pz_val_td").text(row.pz);
		$("#preview_bdxx_div table #dfgbpz_val_td").text("");
		
		$("#preview_bdxx_div table #yssMc_val_td").text("");
		$("#preview_bdxx_div table #jz_val_td").text("");
		$("#preview_bdxx_div table #dfgbjz_val_td").text("");
		
		$("#preview_bdxx_div table #jcsj_val_td").text("");
		$("#preview_bdxx_div table #bs_val_td").text("");
		$("#preview_bdxx_div table #ks_val_td").text("");
		
		$("#preview_bdxx_div table #ccsj_val_td").text("");
		$("#preview_bdxx_div table #jszl_val_td").text("");
		$("#preview_bdxx_div table #bz_val_td").text("");
		
		$("#preview_bdxx_div #gby_val_span").text("");
		$("#preview_bdxx_div #cysjXm_val_span").text("");
	}
}

function deleteByIds() {
	var rows=tab1.datagrid("getSelections");
	if (rows.length == 0) {
		$.messager.alert("??????","??????????????????????????????","warning");
		return false;
	}
	
	$.messager.confirm("??????","?????????????????????",function(r){
		if(r){
			var ids = "";
			for (var i = 0; i < rows.length; i++) {
				ids += "," + rows[i].id;
			}
			ids=ids.substring(1);
			
			$.post(ddglPath + "deleteDingDan",
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

function checkFwddZt(){
	var rows=tab1.datagrid("getSelections");
	var ddztMc=rows[0].ddztMc;
	var yjzDdztMc='${requestScope.yjzDdztMc}';
	var ejzDdztMc='${requestScope.ejzDdztMc}';
	if(ddztMc==yjzDdztMc)
		return true;
	else if(ddztMc==ejzDdztMc)
		return true;
	else{
		alert("????????????????????????");
		return false;
	}
}

function fwddById(){
	var jyFlag=0;
	var rows=tab1.datagrid("getSelections");
	var id=rows[0].id;
	var ddztMc=rows[0].ddztMc;
	var yjzDdztMc='${requestScope.yjzDdztMc}';
	var ejzDdztMc='${requestScope.ejzDdztMc}';
	var xddztMc;
	var yjzt;
	var ejzt;
	if(ddztMc==yjzDdztMc){
		jyFlag=1
		yjzt=1;
		xddztMc='${requestScope.yjdsmDdztMc}';
	}
	else if(ddztMc==ejzDdztMc){
		jyFlag=2
		ejzt=1;
		xddztMc='${requestScope.ejdsmDdztMc}';
	}
	$.post(ddglPath+"fwddById",
		{id:id,jyFlag:jyFlag,ddztMc:xddztMc,yjzt:yjzt,ejzt:ejzt},
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

function checkBddyddZt(){
	var rows=tab1.datagrid("getSelections");
	var ddztMc=rows[0].ddztMc;
	var ddypzDdztMc='${requestScope.ddypzDdztMc}';
	if(ddztMc==ddypzDdztMc)
		return true;
	else{
		return false;
	}
}

function changeDdztToDlc(){
	var rows=tab1.datagrid("getSelections");
	var id=rows[0].id;
	var dlcDdztMc='${requestScope.dlcDdztMc}';
	$.post(gkjPath+"editDingDan",
		{id:id,ddztMc:dlcDdztMc},
		function(result){
			
		}
	,"json");
}

function createDysj(){
	var date=new Date();
	var year=date.getFullYear();
	var month=date.getMonth();
	month=month+1;
	month=month<10?"0"+month:month;
	var dateOfMonth=date.getDate();
	dateOfMonth=dateOfMonth<10?"0"+dateOfMonth:dateOfMonth;
	var hour=date.getHours();
	var minute=date.getMinutes();
	minute=minute<10?"0"+minute:minute;
	var second=date.getSeconds();
	second=second<10?"0"+second:second;
	var dysj=year+"-"+month+"-"+dateOfMonth+" "+hour+":"+minute+":"+second;
	return dysj;
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
	case "input_sfzh_dialog_div":
	case "input_cph_dialog_div":
	case "input_ewm_dialog_div":
	case "preview_bdxx_dialog_div":
	case "output_excel_dialog_div":
		space=50;
		break;
	case "input_sfzh_dialog_table":
	case "input_cph_dialog_table":
	case "input_ewm_dialog_table":
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
				<span class="ddh_span">????????????</span>
				<input type="text" class="ddh_inp" id="ddh" placeholder="??????????????????"/>
				<span class="ddzt_span">???????????????</span>
				<input id="ddzt_cbb"/>
				<span class="cyclCph_span">????????????</span>
				<input type="text" class="cyclCph_inp" id="cyclCph" placeholder="??????????????????"/>
				<span class="jhysrq_span">?????????????????????</span>
				<input id="jhysrq_db"/>
				<span class="yss_span">????????????</span>
				<input type="text" class="yssMc_inp" id="yssMc" placeholder="??????????????????"/>
			</div>
			<div class="row_div">
				<span class="wzMc_span">???????????????</span>
				<input type="text" class="wzMc_inp" id="wzMc" placeholder="?????????????????????"/>
				<span class="fhdw_span">???????????????</span>
				<input type="text" class="fhdwMc_inp" id="fhdwMc" placeholder="?????????????????????"/>
				<span class="shdw_span">???????????????</span>
				<input type="text" class="shdwMc_inp" id="shdwMc" placeholder="?????????????????????"/>
				<span class="cjsjXm_span">???????????????</span>
				<input type="text" class="cysjXm_inp" id="cysjXm" placeholder="?????????????????????"/>
				<span class="cysjSfzh_span">?????????????????????</span>
				<input type="text" class="cysjSfzh_inp" id="cysjSfzh" placeholder="???????????????????????????"/>
			</div>
			<div class="row_div">
				<span class="jcsj_span">???????????????</span>
				<input id="jcsjs_dtb"/>
				-
				<input id="jcsje_dtb"/>
				<span class="ccsj_span">???????????????</span>
				<input id="ccsjs_dtb"/>
				-
				<input id="ccsje_dtb"/>
				<a class="search_but" id="search_but">??????</a>
			</div>
			<div class="row_div">
				<a id="rgsbsfz_but">?????????????????????</a>
				<a id="rgsbcp_but">??????????????????</a>
				<a id="rgsbewm_but">?????????????????????</a>
				<a id="ddfw_but">????????????</a>
				<a id="bddy_but">????????????</a>
				<a id="add_but">??????</a>
				<a id="remove_but">??????</a>
         		<a id="output_but">??????</a>
			</div>
		</div>
		<table id="tab1">
		</table>
	</div>
	
	<div class="input_sfzh_bg_div" id="input_sfzh_bg_div">
		<div class="input_sfzh_div" id="input_sfzh_div">
			<div class="input_sfzh_dialog_div" id="input_sfzh_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						??????
					</td>
					<td class="td2">
						<input id="xzsfzh_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						????????????
					</td>
					<td class="td2">
						<input id="sfzh_inp"/>
					</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	
	<div class="input_cph_bg_div" id="input_cph_bg_div">
		<div class="input_cph_div" id="input_cph_div">
			<div class="input_cph_dialog_div" id="input_cph_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						??????
					</td>
					<td class="td2">
						<input id="rgsbcp_place_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						??????
					</td>
					<td class="td2">
						<input id="rgsbcp_xzcph_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						?????????
					</td>
					<td class="td2">
						<input id="rgsbcp_lrSjc_cbb"/>
						<input id="rgsbcp_lrWscph_cbb"/>
					</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	
	<div class="input_ewm_bg_div" id="input_ewm_bg_div">
		<div class="input_ewm_div" id="input_ewm_div">
			<div class="input_ewm_dialog_div" id="input_ewm_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						??????
					</td>
					<td class="td2">
						<input id="rgsbewm_place_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						??????
					</td>
					<td class="td2">
						<input id="rgsbewm_xzcph_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						?????????
					</td>
					<td class="td2">
						<input id="rgsbewm_lrSjc_cbb"/>
						<input id="rgsbewm_lrWscph_cbb"/>
					</td>
				  </tr>
				</table>
			</div>
		</div>
	</div>
	
	<div class="preview_bdxx_bg_div" id="preview_bdxx_bg_div">
		<div class="preview_bdxx_div" id="preview_bdxx_div">
			<div class="preview_bdxx_dialog_div" id="preview_bdxx_dialog_div">
			</div>
		</div>
	</div>
	
	<div class="output_excel_bg_div" id="output_excel_bg_div">
		<div class="output_excel_div" id="output_excel_div">
			<div class="output_excel_dialog_div" id="output_excel_dialog_div">
				<table>
				  <tr>
					<td class="td1" align="right">
						????????????
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