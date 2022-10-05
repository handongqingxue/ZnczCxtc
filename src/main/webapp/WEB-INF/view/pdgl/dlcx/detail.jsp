<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../inc/js.jsp"%>
<style type="text/css">
.center_con_div{
	height: 90vh;
	margin-left:205px;
	position: absolute;
}
.page_location_div{
	height: 50px;
	line-height: 50px;
	margin-top: 60px;
	margin-left: 20px;
	font-size: 18px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var pdglPath=path+'pdgl/';
var dialogTop=70;
var dialogLeft=20;
var ddNum=0;
$(function(){
	initDetailDialog();

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var ddpw=$("body").find(".panel.window").eq(ddNum);
	var ddws=$("body").find(".window-shadow").eq(ddNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(ddpw);
	ccDiv.append(ddws);
}

function initDetailDialog(){
	dialogTop+=20;
	$("#detail_div").dialog({
		title:"队列信息",
		width:setFitWidthInParent("body","detail_div_table"),
		height:260,
		top:dialogTop,
		left:dialogLeft
	});

	$("#detail_div table").css("width",(setFitWidthInParent("body","detail_div_table"))+"px");
	$("#detail_div table").css("magin","-100px");
	$("#detail_div table td").css("padding-left","50px");
	$("#detail_div table td").css("padding-right","20px");
	$("#detail_div table td").css("font-size","15px");
	$("#detail_div table .td1").css("width","15%");
	$("#detail_div table .td2").css("width","30%");
	$("#detail_div table tr").css("border-bottom","#CAD9EA solid 1px");
	$("#detail_div table tr").css("height","45px");

	$(".panel.window").eq(ddNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(ddNum).css("color","#000");
	$(".panel.window .panel-title").eq(ddNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(ddNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(ddNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(ddNum).css("border-color","#ddd");
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "detail_div":
		space=340;
		break;
	case "detail_div_table":
	case "panel_window":
		space=355;
		break;
	}
	var width=$(parent).css("width");
	return width.substring(0,width.length-2)-space;
}
</script>
<title>Insert title here</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">队列-详情</div>
		
		<div id="detail_div">
			<table>
			  <tr>
				<td class="td1" align="right">
					名称
				</td>
				<td class="td2">
					${requestScope.dl.mc }
				</td>
				<td class="td1" align="right">
					代码
				</td>
				<td class="td2">
					${requestScope.dl.dm }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					叫号形式
				</td>
				<td class="td2">
					<c:if test="${requestScope.dl.jhxs eq 1 }">自动</c:if>
					<c:if test="${requestScope.dl.jhxs eq 2 }">手动</c:if>
					叫号
				</td>
				<td class="td1" align="right">
					叫号阈值
				</td>
				<td class="td2">
					${requestScope.dl.jhyz }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					状态
				</td>
				<td class="td2">
					<c:if test="${requestScope.dl.zt eq 1 }">在用</c:if>
					<c:if test="${requestScope.dl.zt eq 2 }">暂停</c:if>
					<c:if test="${requestScope.dl.zt eq 3 }">废弃</c:if>
				</td>
				<td class="td1" align="right">
				</td>
				<td class="td2">
				</td>
			  </tr>
			</table>
		</div>
		<%@include file="../../inc/foot.jsp"%>
	</div>
</div>
</body>
</html>