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
	height:96px;
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
.tab1_div .check_a{
	visibility: hidden;
}

.input_sfzh_bg_div,
.input_cph_bg_div,
.preview_bdxx_bg_div{
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

.input_cph_div{
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
</style>
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var ddglPath=path+'ddgl/';
var gbglPath=path+'gbgl/';
var gkjPath=path+'gkj/';
var dialogTop=10;
var dialogLeft=20;
var isfzhdNum=0;
var icphdNum=1;
var pbdxxdNum=2;
var appendStr="";

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

var pushCph;
var pushSfzh;

$(function(){
	initLxlxVar();
	initGbztVar();
	initPlaceFlagVar();
	initPushVar();
	
	initDDZTCBB();
	initJHYSRQDB();
	initJCSJSDTB();
	initJCSJEDTB();
	initCCSJSDTB();
	initCCSJEDTB();
	initSearchLB();
	initRgsbsfzLB();
	initRgsbcpLB();
	initDdfwLB();
	initBddyLB();
	initAddLB();
	initRemoveLB();
	initTab1();
	
	initInputSfzhDialog();//0
	initInputCphDialog();//1
	initPreviewBDXXDialog();//2
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	//showCompontByQx();
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
	pushCph='${requestScope.pushCph}';
	pushSfzh='${requestScope.pushSfzh}';
}

function showCompontByQx(){
	rgsbcpLB.hide();
	removeLB.hide();
	if(yhm=="admin"){
		rgsbcpLB.show();
		removeLB.show();
	}
	else{
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==1){//仓储员
				setTimeout(function(){
					$(".tab1_div .check_a").css("visibility","visible");
				},2000)
			}
			if(qxIdsArr[i]==2){//磅房人员
				rgsbcpLB.show();
			}
		}
	}
}

function initDialogPosition(){
	var isfzhdpw=$("body").find(".panel.window").eq(isfzhdNum);
	var isfzhdws=$("body").find(".window-shadow").eq(isfzhdNum);
	
	var icphdpw=$("body").find(".panel.window").eq(icphdNum);
	var icphdws=$("body").find(".window-shadow").eq(icphdNum);
	
	var pbdxxdpw=$("body").find(".panel.window").eq(pbdxxdNum);
	var pbdxxdws=$("body").find(".window-shadow").eq(pbdxxdNum);

	var isfzhdDiv=$("#input_sfzh_div");
	isfzhdDiv.append(isfzhdpw);
	isfzhdDiv.append(isfzhdws);
	
	var icphdDiv=$("#input_cph_div");
	icphdDiv.append(icphdpw);
	icphdDiv.append(icphdws);

	var pbdxxdDiv=$("#preview_bdxx_div");
	pbdxxdDiv.append(pbdxxdpw);
	pbdxxdDiv.append(pbdxxdws);
}

function initInputSfzhDialog(){
	$("#input_sfzh_dialog_div").dialog({
		title:"录入身份证号",
		width:setFitWidthInParent("#input_sfzh_div","input_sfzh_dialog_div"),
		height:200,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"确定",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkSfzhToClient();
           }},
           {text:"取消",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
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
	
	//以下的是表格下面的面板
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
	data.push({"value":"","text":"请选择"});
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

function initInputCphDialog(){
	$("#input_cph_dialog_div").dialog({
		title:"录入车牌号",
		width:setFitWidthInParent("#input_cph_div","input_cph_dialog_div"),
		height:250,
		top:5,
		left:dialogLeft,
		buttons:[
           {text:"确定",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkCphToClient();
           }},
           {text:"取消",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
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
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(icphdNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(icphdNum).css("border-color","#ddd");

	$("#input_cph_dialog_div #ok_but").css("left","30%");
	$("#input_cph_dialog_div #ok_but").css("position","absolute");

	$("#input_cph_dialog_div #cancel_but").css("left","50%");
	$("#input_cph_dialog_div #cancel_but").css("position","absolute");
	
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initPlaceCBB();
	initXzCphCBB();
	initLrSjcCBB();
	initLrWscphCBB();
}

function initPlaceCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	data.push({"value":mg,"text":mgMc});
	data.push({"value":yhbf,"text":yhbfMc});
	data.push({"value":ehbf,"text":ehbfMc});
	data.push({"value":shbf,"text":shbfMc});
	
	placeCBB=$("#place_cbb").combobox({
		width:120,
		valueField:"value",
		textField:"text",
		//multiple:true,
		data:data
	});
}

function initXzCphCBB(){
	var data=[];
	data.push({"value":"","text":"请选择"});
	$.post(ddglPath+"queryXzCphCBBList",
		{page:1,rows:20,sort:"lrsj",order:"desc"},
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i],"text":rows[i]});
			}
			xzcphCBB=$("#xzcph_cbb").combobox({
				width:120,
				valueField:"value",
				textField:"text",
				data:data,
				onChange:function(){
					var cph=xzcphCBB.combobox("getValue");
					lrSjcCBB.combobox("setValue",cph.substring(0,1));
					lrWscphCBB.combobox("setValue",cph.substring(1));
				}
			});
		}
	,"json");
}

function initLrSjcCBB(){
	var data=[];
	data.push({"value":"","text":"请录入"});
	lrSjcCBB=$("#lrSjc_cbb").combobox({
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

function initLrWscphCBB(){
	var data=[];
	data.push({"value":"","text":"请录入"});
	lrWscphCBB=$("#lrWscph_cbb").combobox({
		width:70,
		valueField:"wscph",
		textField:"wscph",
		editable:true,
        mode:'remote',
        url:ddglPath+"queryLrWscphCBBList",
        onBeforeLoad: function(param){
        	var sjc=lrSjcCBB.combobox("getValue");
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
		title:"磅单信息",
		width:setFitWidthInParent("#preview_bdxx_div","preview_bdxx_dialog_div"),
		height:480,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"打印",id:"print_but",iconCls:"icon-ok",handler:function(){
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
        	   //window.print();//打印上面新建的网页
        	   //window.document.body.innerHTML= pageHtml;
        	   //location.href=location.href;
           }},
           {text:"取消",id:"cancel_but",iconCls:"icon-cancel",handler:function(){
        	   openPreviewBDXXDialog(false,null);
           }}
        ]
	});

	$(".panel.window").eq(pbdxxdNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(pbdxxdNum).css("color","#000");
	$(".panel.window .panel-title").eq(pbdxxdNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(pbdxxdNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
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
	appendStr="<div style=\"width: 100%;height:40px;line-height:40px;text-align: center;font-size: 20px;font-weight: bold;\">山东创新炭材料有限公司磅单</div>";
  	
	appendStr+="<div style=\"width: 90%;height:30px;line-height:30px;margin:auto;\">";
		appendStr+="<span class=\"dysj_key_td\" style=\"margin-left: 10px;\">打印时间：</span>";
		appendStr+="<span id=\"dysj_val_span\" style=\"margin-left: 20px;\"></span>";
		appendStr+="<span id=\"dh_key_span\" style=\"margin-left: 120px;\">单号:</span>";
		appendStr+="<span id=\"dh_val_span\" style=\"margin-left: 20px;\"></span>";
	    appendStr+="<span style=\"margin-left: 50px;\">单位：kg</span>";
    appendStr+="</div>";
    
	appendStr+="<table border=\"1\" style=\"width: 90%;margin:auto;text-align: center;border-color: #000;border-spacing:0;\">";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"wzMc_key_td\" style=\"width: 10%;\">物资名称</td>";
			appendStr+="<td class=\"wzMc_val_td\" id=\"wzMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"wzlxMc_key_td\" style=\"width: 10%;\">型号</td>";
			appendStr+="<td class=\"wzlxMc_val_td\" id=\"wzlxMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"cyclCph_key_td\" style=\"width: 10%;\">车号</td>";
			appendStr+="<td class=\"cyclCph_val_td\" id=\"cyclCph_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"fhdwMc_key_td\">发货单位</td>";
			appendStr+="<td class=\"fhdwMc_val_td\" id=\"fhdwMc_val_td\"></td>";
			appendStr+="<td class=\"mz_key_td\">我方毛重</td>";
			appendStr+="<td class=\"mz_val_td\" id=\"mz_val_td\"></td>";
			appendStr+="<td class=\"dfgbmz_key_td\">对方毛重</td>";
			appendStr+="<td class=\"dfgbmz_val_td\" id=\"dfgbmz_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"shdwMc_key_td\">收货单位</td>";
			appendStr+="<td class=\"shdwMc_val_td\" id=\"shdwMc_val_td\"></td>";
			appendStr+="<td class=\"pz_key_td\">我方皮重</td>";
			appendStr+="<td class=\"pz_val_td\" id=\"pz_val_td\"></td>";
			appendStr+="<td class=\"dfgbpz_key_td\">对方皮重</td>";
			appendStr+="<td class=\"dfgbpz_val_td\" id=\"dfgbpz_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"yssMc_key_td\">运输单位</td>";
			appendStr+="<td class=\"yssMc_val_td\" id=\"yssMc_val_td\"></td>";
			appendStr+="<td class=\"jz_key_td\">我方净重</td>";
			appendStr+="<td class=\"jz_val_td\" id=\"jz_val_td\"></td>";
			appendStr+="<td class=\"dfgbjz_key_td\">对方净重</td>";
			appendStr+="<td class=\"dfgbjz_val_td\" id=\"dfgbjz_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"jcsj_key_td\">进厂时间</td>";
			appendStr+="<td class=\"jcsj_val_td\" id=\"jcsj_val_td\"></td>";
			appendStr+="<td class=\"bs_key_td\">包 数</td>";
			appendStr+="<td class=\"bs_val_td\" id=\"bs_val_td\"></td>";
			appendStr+="<td class=\"ks_key_td\">块 数</td>";
			appendStr+="<td class=\"ks_val_td\" id=\"ks_val_td\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"ccsj_key_td\">出厂时间</td>";
			appendStr+="<td class=\"ccsj_val_td\" id=\"ccsj_val_td\"></td>";
			appendStr+="<td class=\"jszl_key_td\">结算重量</td>";
			appendStr+="<td class=\"jszl_val_td\" id=\"jszl_val_td\"></td>";
			appendStr+="<td class=\"bz_key_td\">备 注</td>";
			appendStr+="<td class=\"bz_val_td\" id=\"bz_val_td\"></td>";
		appendStr+="</tr>";
	appendStr+="</table>";
	
  	appendStr+="<div style=\"width: 90%;height:30px;line-height:30px;margin:auto;\">";
		appendStr+="<span id=\"gby_key_span\" style=\"margin-left: 20px;\">过磅员</span>";
		appendStr+="<span id=\"gby_val_span\" style=\"margin-left: 20px;\"></span>";
		appendStr+="<span id=\"cysjXm_key_span\" style=\"margin-left: 120px;\">司机</span>";
		appendStr+="<span id=\"cysjXm_val_span\" style=\"margin-left: 20px;\"></span>";
    appendStr+="</div>";
}

function checkSfzhToClient(){
	if(checkRglrSfzh()){
		pushSfzhToClient();
	}
}

//验证人工录入身份证号
function checkRglrSfzh(){
	var sfzh = $("#input_sfzh_div #sfzh_inp").val();
	if(sfzh==null||sfzh==""||sfzh=="身份证号不能为空"){
		$("#input_sfzh_div #sfzh_inp").css("color","#E15748");
    	$("#input_sfzh_div #sfzh_inp").val("身份证号不能为空");
    	return false;
	}
	else
		return true;
}

function pushSfzhToClient(){
	var rows=tab1.datagrid("getSelections");
	var sfzh = $("#input_sfzh_div #sfzh_inp").val();
	if(sfzh!=rows[0].cysjSfzh){
		alert("输入的身份证号与订单里的身份证号不一致");
		return false;
	}
	
	var paramJO={};
	paramJO.sfzh=sfzh;
	paramJO.pushFlag=pushSfzh;
	
	var ddztMc=rows[0].ddztMc;
	if(ddztMc!='${requestScope.yxdDdztMc}'){//已下单
		alert("该车辆非"+ddztMc+"状态");
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
	if(checkPlace()){
		if(checkRglrCph()){
			pushCphToClient();
		}
	}
}

function pushCphToClient(){
	var rows=tab1.datagrid("getSelections");
	var placeFlag=parseInt(placeCBB.combobox("getValue"));
	var sjc=lrSjcCBB.combobox("getValue");
	var wscph=lrWscphCBB.combobox("getValue");
	var cph=sjc+wscph;
	if(cph!=rows[0].cyclCph){
		alert("输入的车牌号与订单里的车牌号不一致");
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
		if(ddztMc=='${requestScope.yjdsbDdztMc}')//一检待上磅
			jyFlag=1
		else if(ddztMc=='${requestScope.ejdsbDdztMc}')//二检待上磅
			jyFlag=2
		else{
			alert("该车辆非待上磅状态");
			return false;
		}
		paramJO.jyFlag=jyFlag;
		break;
	case mg:
		var jccFlag=0;//进出厂标识
		if(ddztMc=='${requestScope.yxdDdztMc}')//已下单
			jccFlag=1;
		else if(ddztMc=='${requestScope.ddypzDdztMc}'||ddztMc=='${requestScope.dlcDdztMc}')//待打印凭证或待离厂
			jccFlag=2
		else{
			alert("该车辆非"+ddztMc+"状态");
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

//验证地点
function checkPlace(){
	var bfh=placeCBB.combobox("getValue");
	if(bfh==null||bfh==""){
	  	alert("请选择地点");
	  	return false;
	}
	else
		return true;
}

//验证人工录入车牌号
function checkRglrCph(){
	var sjc=lrSjcCBB.combobox("getValue");
	var wscph=lrWscphCBB.combobox("getValue");
	if(sjc==null||sjc==""||wscph==null||wscph==""){
	  	alert("请录入车牌号");
	  	return false;
	}
	else
		return true;
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

function initDdfwLB(){
	ddfwLB=$("#ddfw_but").linkbutton({
		iconCls:"icon-back",
		onClick:function(){
			var rows=tab1.datagrid("getSelections");
			if (rows.length == 0) {
				$.messager.alert("提示","请选择要复位的订单信息！","warning");
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
				$.messager.alert("提示","请选择要打印磅单的订单信息！","warning");
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

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"订单管理-综合查询-列表",
		url:ddglPath+"queryZHCXList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		pagination:true,
		pageSize:10,
		columns:[[
            {field:"id",title:"操作",width:100,formatter:function(value,row){
            	var str;
           		if(row.id!="<div style=\"text-align:center;\">暂无信息<div>"){
	            	str="<a href=\"edit?id="+value+"\">编辑</a>&nbsp;&nbsp;"
	            	   +"<a href=\"detail?id="+value+"\">详情</a>&nbsp;&nbsp;";
           		}
           		else
           			str=value;
            	return str;
            }},
			{field:"ddh",title:"订单号",width:150},
			{field:"cysjSfzh",title:"司机身份证号",width:200},
			{field:"wzlxMc",title:"物资类型",width:150},
			{field:"wzMc",title:"物资名称",width:150},
			{field:"cyclCph",title:"车牌号",width:150},
			{field:"yssMc",title:"运输商",width:150},
			{field:"fhdwMc",title:"发货单位",width:150},
			{field:"shdwMc",title:"收货单位",width:150},
            {field:"lxlx",title:"流向类型",width:100,formatter:function(value,row){
            	return getLxlxMcById(value);
            }},
			{field:"jhysrq",title:"计划运输日期",width:150},
			{field:"ddztMc",title:"订单状态",width:150},
			{field:"yjzt",title:"一检状态",width:100,formatter:function(value,row){
            	return getGbztMcById(value);
            }},
			{field:"ejzt",title:"二检状态",width:100,formatter:function(value,row){
				return getGbztMcById(value);
            }},
            {field:"yjbfh",title:"一检地磅",width:100,formatter:function(value,row){
            	return getBfMcByBfh(value);
            }},
            {field:"ejbfh",title:"二检地磅",width:100,formatter:function(value,row){
            	return getBfMcByBfh(value);
            }},
            {field:"yzxzl",title:"预装卸重量",width:150},
            {field:"bjsj",title:"编辑时间",width:150},
            {field:"jcsj",title:"进厂时间",width:150},
            {field:"ccsj",title:"出厂时间",width:150},
            {field:"mz",title:"毛重",width:100},
            {field:"pz",title:"皮重",width:150},
            {field:"sjzl",title:"实际重量",width:150},
            {field:"dfgbmz",title:"对方过磅毛重",width:150},
            {field:"dfgbpz",title:"对方过磅皮重",width:150},
            {field:"dfgbjz",title:"对方过磅净重",width:150}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{id:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"id",colspan:26});
				data.total=0;
			}
			
			$(".panel-header .panel-title").css("color","#000");
			$(".panel-header .panel-title").css("font-size","15px");
			$(".panel-header .panel-title").css("padding-left","10px");
			$(".panel-header, .panel-body").css("border-color","#ddd");
		}
	});
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

function getGbztMcById(gbztId){
	var str;
	switch (gbztId) {
	case dsbGbzt:
		str=dsbGbztMc;//待上磅
		break;
	case sbzGbzt:
		str=sbzGbztMc;//上磅中
		break;
	case dczGbzt:
		str=dczGbztMc;//待称重
		break;
	case czzGbzt:
		str=czzGbztMc;//称重中
		break;
	case dxbGbzt:
		str=dxbGbztMc;//待下磅
		break;
	case xbzGbzt:
		str=xbzGbztMc;//下磅中
		break;
	case ywcGbzt:
		str=ywcGbztMc;//已完成
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
	var yjsbDdztMc='${requestScope.yjsbDdztMc}';
	var ejsbDdztMc='${requestScope.ejsbDdztMc}';
	if(ddztMc==yjsbDdztMc)
		return true;
	else if(ddztMc==ejsbDdztMc)
		return true;
	else{
		alert("该车辆非过磅状态");
		return false;
	}
}

function fwddById(){
	var jyFlag=0;
	var rows=tab1.datagrid("getSelections");
	var id=rows[0].id;
	var ddztMc=rows[0].ddztMc;
	var yjsbDdztMc='${requestScope.yjsbDdztMc}';
	var ejsbDdztMc='${requestScope.ejsbDdztMc}';
	var xddztMc;
	var yjzt;
	var ejzt;
	if(ddztMc==yjsbDdztMc){
		jyFlag=1
		yjzt=1;
		xddztMc='${requestScope.yjpdzDdztMc}';
	}
	else if(ddztMc==ejsbDdztMc){
		jyFlag=2
		ejzt=1;
		xddztMc='${requestScope.ejpdzDdztMc}';
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
	case "preview_bdxx_dialog_div":
		space=50;
		break;
	case "input_sfzh_dialog_table":
	case "input_cph_dialog_table":
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
				<span class="ddzt_span">订单状态：</span>
				<input id="ddzt_cbb"/>
				<span class="cyclCph_span">车牌号：</span>
				<input type="text" class="cyclCph_inp" id="cyclCph" placeholder="请输入车牌号"/>
				<span class="jhysrq_span">计划运输日期：</span>
				<input id="jhysrq_db"/>
				<span class="yss_span">运输商：</span>
				<input type="text" class="yssMc_inp" id="yssMc" placeholder="请输入运输商"/>
			</div>
			<div class="row_div">
				<span class="wzMc_span">物资名称：</span>
				<input type="text" class="wzMc_inp" id="wzMc" placeholder="请输入物资名称"/>
				<span class="fhdw_span">发货单位：</span>
				<input type="text" class="fhdwMc_inp" id="fhdwMc" placeholder="请输入发货单位"/>
				<span class="shdw_span">收货单位：</span>
				<input type="text" class="shdwMc_inp" id="shdwMc" placeholder="请输入收货单位"/>
				<span class="cjsjXm_span">司机姓名：</span>
				<input type="text" class="cysjXm_inp" id="cysjXm" placeholder="请输入司机姓名"/>
				<span class="cysjSfzh_span">司机身份证号：</span>
				<input type="text" class="cysjSfzh_inp" id="cysjSfzh" placeholder="请输入司机身份证号"/>
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
				<a id="rgsbsfz_but">人工识别身份证</a>
				<a id="rgsbcp_but">人工识别车牌</a>
				<a id="ddfw_but">订单复位</a>
				<a id="bddy_but">磅单打印</a>
				<a id="add_but">添加</a>
				<a id="remove_but">删除</a>
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
						选择
					</td>
					<td class="td2">
						<input id="xzsfzh_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						身份证号
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
						地点
					</td>
					<td class="td2">
						<input id="place_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						选择
					</td>
					<td class="td2">
						<input id="xzcph_cbb"/>
					</td>
				  </tr>
				  <tr>
					<td class="td1" align="right">
						车牌号
					</td>
					<td class="td2">
						<input id="lrSjc_cbb"/>
						<input id="lrWscph_cbb"/>
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
	
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>