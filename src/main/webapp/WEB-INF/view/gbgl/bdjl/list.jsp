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

.preview_bdxx_bg_div{
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
</style>
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var gbglPath=path+'gbgl/';
var dialogTop=10;
var dialogLeft=20;
var pbdxxdNum=0;
var appendStr="";
$(function(){
	initSearchLB();
	initAddLB();
	initTab1();
	initPreviewBDXXDialog();//0
	
	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	var pbdxxdpw=$("body").find(".panel.window").eq(pbdxxdNum);
	var pbdxxdws=$("body").find(".window-shadow").eq(pbdxxdNum);

	var pbdxxdDiv=$("#preview_bdxx_div");
	pbdxxdDiv.append(pbdxxdpw);
	pbdxxdDiv.append(pbdxxdws);
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
        		   	 if(data.message=="ok")
        	        	window.open("print?time="+time);
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
  	    appendStr+="<div style=\"width: 90%;height:30px;line-height:30px;margin:auto;\">";
		appendStr+="<span class=\"dysj_key_td\" style=\"margin-left: 10px;\">打印时间：</span>";
		appendStr+="<span id=\"dysj_val_span\" style=\"margin-left: 20px;\">2022-10-15 08:35:57</span>";
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
	$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=gbglPath+"bdjl/new";
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
            	var str="<a href=\"edit?id="+value+"\">编辑</a>&nbsp;&nbsp;"
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
		}
	});
}

function openPreviewBDXXDialog(flag,row){
	var panelBody=$("#preview_bdxx_dialog_div .panel-body");
	panelBody.empty();
	if(flag){
		panelBody.append(appendStr);
		
		$("#preview_bdxx_bg_div").css("display","block");
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

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "tab1_div":
		space=250;
		break;
	case "preview_bdxx_dialog_div":
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
			<span class="ddh_span">订单号：</span>
			<input type="text" class="ddh_inp" id="ddh" placeholder="请输入订单号"/>
			<a class="search_but" id="search_but">查询</a>
			<a id="add_but">添加</a>
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
	
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>