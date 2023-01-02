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
.tab1_div .toolbar .ddh_span{
	margin-left: 13px;
}
.tab1_div .toolbar .ddh_inp{
	width: 120px;height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
.tab1_div .edit_a{
	visibility: hidden;
}

.preview_bdxx_bg_div,
.output_excel_bg_div{
	width: 100%;
	height: 100%;
	background-color: rgba(0,0,0,.45);
	position: fixed;
	z-index: 9016;
	display:none;
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
var gbglPath=path+'gbgl/';
var gkjPath=path+'gkj/';
var exportExcelPath=path+'exportExcel/';
var dialogTop=10;
var dialogLeft=20;
var pbdxxdNum=0;
var oedNum=1;

var appendStr="";

var dqyDcfw;
var syyDcfw;

var dqyDcfwMc;
var syyDcfwMc;
$(function(){
	initDcfwVar();
	
	initSearchLB();
	initAddLB();
	initRemoveLB();
	initOutputBut();
	initTab1();
	initPreviewBDXXDialog();//0
	initOutputExcelDialog();//1
	
	initDialogPosition();//将不同窗体移动到主要内容区域
	showCompontByQx();
});

function initDcfwVar(){
	dqyDcfw=parseInt('${requestScope.dqyDcfw}');
	syyDcfw=parseInt('${requestScope.syyDcfw}');

	dqyDcfwMc='${requestScope.dqyDcfwMc}';
	syyDcfwMc='${requestScope.syyDcfwMc}';
}

function initDialogPosition(){
	var pbdxxdpw=$("body").find(".panel.window").eq(pbdxxdNum);
	var pbdxxdws=$("body").find(".window-shadow").eq(pbdxxdNum);
	
	var oedpw=$("body").find(".panel.window").eq(oedNum);
	var oedws=$("body").find(".window-shadow").eq(oedNum);

	var pbdxxdDiv=$("#preview_bdxx_div");
	pbdxxdDiv.append(pbdxxdpw);
	pbdxxdDiv.append(pbdxxdws);
	
	var oedDiv=$("#output_excel_div");
	oedDiv.append(oedpw);
	oedDiv.append(oedws);
}

function showCompontByQx(){
	addLB.hide();
	if(yhm=="admin"){
		addLB.show();
	}
}

function showOptionButByQx(){
	if(yhm=="admin"){
		$(".tab1_div .edit_a").css("visibility","visible");
	}
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
        	        	window.open("print?time="+time);
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
	appendStr="<div style=\"width: 100%;height:40px;line-height:40px;text-align: center;font-size: 20px;font-weight: bold;\">山东创新炭材料有限公司</div>";
	
	appendStr+="<input type=\"hidden\" id=\"ddId_val_hid\"/>";
	appendStr+="<input type=\"hidden\" id=\"ddztMc_val_hid\"/>";
  	
	appendStr+="<div style=\"width: 90%;height:30px;line-height:30px;margin:auto;\">";
		appendStr+="<span class=\"dysj_key_td\" style=\"margin-left: 10px;\">打印时间：</span>";
		appendStr+="<span id=\"dysj_val_span\" style=\"margin-left: 20px;\"></span>";
		appendStr+="<span id=\"gby_key_span\" style=\"margin-left: 20px;\">过磅员</span>";
		appendStr+="<span id=\"gby_val_span\" style=\"margin-left: 20px;\"></span>";
		appendStr+="<span id=\"dh_key_span\" style=\"margin-left: 120px;\">单号:</span>";
		appendStr+="<span id=\"dh_val_span\" style=\"margin-left: 20px;\"></span>";
	    appendStr+="<span style=\"margin-left: 50px;\">单位：kg</span>";
    appendStr+="</div>";
    
	appendStr+="<table border=\"1\" style=\"width: 90%;margin:auto;text-align: center;border-color: #000;border-spacing:0;\">";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"wzMc_key_td\" style=\"width: 10%;\">物资名称</td>";
			appendStr+="<td class=\"wzMc_val_td\" id=\"wzMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"jcsj_key_td\" style=\"width: 10%;\">进厂时间</td>";
			appendStr+="<td class=\"jcsj_val_td\" id=\"jcsj_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"ccsj_key_td\" style=\"width: 10%;\">出厂时间</td>";
			appendStr+="<td class=\"ccsj_val_td\" id=\"ccsj_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"gg_key_td\" style=\"width: 10%;\">规格</td>";
			appendStr+="<td class=\"gg_val_td\" id=\"gg_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"mz_key_td\" style=\"width: 10%;\">毛重</td>";
			appendStr+="<td class=\"mz_val_td\" id=\"mz_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"dfgbmz_key_td\" style=\"width: 10%;\">对方过磅毛重</td>";
			appendStr+="<td class=\"dfgbmz_val_td\" id=\"dfgbmz_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"fhdwMc_key_td\" style=\"width: 10%;\">供货单位</td>";
			appendStr+="<td class=\"fhdwMc_val_td\" id=\"fhdwMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"pz_key_td\" style=\"width: 10%;\">皮重</td>";
			appendStr+="<td class=\"pz_val_td\" id=\"pz_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"dfgbpz_key_td\" style=\"width: 10%;\">对方过磅皮重</td>";
			appendStr+="<td class=\"dfgbpz_val_td\" id=\"dfgbpz_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"shdwMc_key_td\" style=\"width: 10%;\">收货单位</td>";
			appendStr+="<td class=\"shdwMc_val_td\" id=\"shdwMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"jz_key_td\" style=\"width: 10%;\">净重</td>";
			appendStr+="<td class=\"jz_val_td\" id=\"jz_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"dfgbjz_key_td\" style=\"width: 10%;\">对方过磅净重</td>";
			appendStr+="<td class=\"dfgbjz_val_td\" id=\"dfgbjz_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
		appendStr+="<tr style=\"height: 25px;\">";
			appendStr+="<td class=\"yssMc_key_td\" style=\"width: 10%;\">运输单位</td>";
			appendStr+="<td class=\"yssMc_val_td\" id=\"yssMc_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"cyclCph_key_td\" style=\"width: 10%;\">车号</td>";
			appendStr+="<td class=\"cyclCph_val_td\" id=\"cyclCph_val_td\" style=\"width: 23%;\"></td>";
			appendStr+="<td class=\"bz_key_td\" style=\"width: 10%;\">备注</td>";
			appendStr+="<td class=\"bz_val_td\" id=\"bz_val_td\" style=\"width: 23%;\"></td>";
		appendStr+="</tr>";
	appendStr+="</table>";
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
        			var dcfw=dcfwCBB.combobox("getValue");
        			params+="ddh="+ddh+"&dcfw="+dcfw;
        			if(dcfw==dqyDcfw){
	        			var options=tab1.datagrid("getPager").data("pagination").options;
	        			var page=options.pageNumber;
	        			var rows=options.pageSize;
	        			params+="&page="+page+"&rows="+rows;
        			}
        			location.href=exportExcelPath+"exportBDJLList?"+params;
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
			tab1.datagrid("load",{ddh:ddh});
		}
	});
}

function initAddLB(){
	addLB=$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=gbglPath+"bdjl/new";
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
		title:"过磅管理-磅单记录-列表",
		url:gbglPath+"queryBDJLList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body","tab1_div"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"ddh",title:"订单号",width:150},
			{field:"mz",title:"毛重",width:150},
			{field:"pz",title:"皮重",width:150},
			{field:"jz",title:"净重",width:150},
            {field:"rq",title:"日期",width:150},
            {field:"id",title:"操作",width:150,formatter:function(value,row){
       			var rowJson = JSON.stringify(row).replace(/"/g, '&quot;');
            	var str="<a class=\"edit_a\" href=\"edit?id="+value+"\">编辑</a>&nbsp;&nbsp;"
            		+"<a href=\"detail?id="+value+"\">详情</a>&nbsp;&nbsp;"
            		+"<a onclick=\"openPreviewBDXXDialog(true,"+rowJson+")\">预览</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{ddh:"<div style=\"text-align:center;\">暂无信息<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"ddh",colspan:6});
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
			
			$.post(gbglPath + "deleteBangDanJiLu",
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

function openOutputExcelDialog(flag){
	if(flag){
		$("#output_excel_bg_div").css("display","block");
	}
	else{
		$("#output_excel_bg_div").css("display","none");
	}
}

function openPreviewBDXXDialog(flag,row){
	var panelBody=$("#preview_bdxx_dialog_div .panel-body");
	panelBody.empty();
	if(flag){
		panelBody.append(appendStr);
		
		$("#preview_bdxx_bg_div").css("display","block");
		
		$("#preview_bdxx_div #ddId_val_hid").val(row.ddId);
		$("#preview_bdxx_div #ddztMc_val_hid").val(row.ddztMc);
		
		$("#preview_bdxx_div #dysj_val_span").text(createDysj());
		$("#preview_bdxx_div #gby_val_span").text(row.cysjXm);
		$("#preview_bdxx_div #dh_val_span").text(row.ddh);
		
		$("#preview_bdxx_div #wzMc_val_td").text(row.wzMc);
		$("#preview_bdxx_div table #jcsj_val_td").text(row.jcsj);
		$("#preview_bdxx_div table #ccsj_val_td").text(row.ccsj);
		
		$("#preview_bdxx_div table #mz_val_td").text(row.mz);
		$("#preview_bdxx_div table #dfgbmz_val_td").text(row.dfgbmz);
		
		$("#preview_bdxx_div table #fhdwMc_val_td").text(row.fhdwMc);
		$("#preview_bdxx_div table #pz_val_td").text(row.pz);
		$("#preview_bdxx_div table #dfgbpz_val_td").text(row.dfgbpz);
		
		$("#preview_bdxx_div table #shdwMc_val_td").text(row.shdwMc);
		$("#preview_bdxx_div table #jz_val_td").text(row.jz);
		$("#preview_bdxx_div table #dfgbjz_val_td").text(row.dfgbjz);
		
		$("#preview_bdxx_div table #yssMc_val_td").text(row.shdwMc);
		$("#preview_bdxx_div table #cyclCph_val_td").text(row.cyclCph);
		$("#preview_bdxx_div table #bz_val_td").text(row.bz);
	}
	else{
		$("#preview_bdxx_bg_div").css("display","none");
		
		$("#preview_bdxx_div #ddId_val_hid").val("");
		$("#preview_bdxx_div #ddztMc_val_hid").val("");
		
		$("#preview_bdxx_div #dysj_val_span").text("");
		$("#preview_bdxx_div #gby_val_span").text("");
		$("#preview_bdxx_div #dh_val_span").text("");
		
		$("#preview_bdxx_div #wzMc_val_td").text("");
		$("#preview_bdxx_div table #jcsj_val_td").text("");
		$("#preview_bdxx_div table #ccsj_val_td").text("");
		
		$("#preview_bdxx_div table #mz_val_td").text("");
		$("#preview_bdxx_div table #dfgbmz_val_td").text("");
		
		$("#preview_bdxx_div table #fhdwMc_val_td").text("");
		$("#preview_bdxx_div table #pz_val_td").text("");
		$("#preview_bdxx_div table #dfgbpz_val_td").text("");
		
		$("#preview_bdxx_div table #shdwMc_val_td").text("");
		$("#preview_bdxx_div table #jz_val_td").text("");
		$("#preview_bdxx_div table #dfgbjz_val_td").text("");
		
		$("#preview_bdxx_div table #yssMc_val_td").text("");
		$("#preview_bdxx_div table #cyclCph_val_td").text("");
		$("#preview_bdxx_div table #bz_val_td").text("");
	}
}

function checkBddyddZt(){
	var ddztMc=$("#preview_bdxx_div #ddztMc_val_hid").val();
	var ddypzDdztMc='${requestScope.ddypzDdztMc}';
	if(ddztMc==ddypzDdztMc)
		return true;
	else{
		return false;
	}
}

function changeDdztToDlc(){
	var ddId=$("#preview_bdxx_div #ddId_val_hid").val();
	var dlcDdztMc='${requestScope.dlcDdztMc}';
	$.post(gkjPath+"editDingDan",
		{id:ddId,ddztMc:dlcDdztMc},
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
	case "tab1_div":
		space=250;
		break;
	case "preview_bdxx_dialog_div":
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
			<span class="ddh_span">订单号：</span>
			<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="add_but">添加</a>
			<a id="remove_but">删除</a>
         	<a id="output_but">导出</a>
		</div>
		<table id="tab1">
		</table>
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