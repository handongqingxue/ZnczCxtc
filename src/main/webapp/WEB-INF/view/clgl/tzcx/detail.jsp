<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
.jczp_img,.cczp_img{
	width: 220px;
	height:220px;
	margin-top: 10px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var ddglPath=path+'ddgl/';
var dialogTop=70;
var dialogLeft=20;
var ddNum=0;
$(function(){
	initDetailDialog();//0

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var ddpw=$("body").find(".panel.window").eq(ddNum);
	var ddws=$("body").find(".window-shadow").eq(ddNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(ddpw);
	ccDiv.append(ddws);
	ccDiv.css("width",setFitWidthInParent("body","center_con_div")+"px");
}

function initDetailDialog(){
	dialogTop+=20;
	$("#detail_div").dialog({
		title:"台账信息",
		width:setFitWidthInParent("body","detail_div"),
		height:720,
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
	$("#detail_div table tr").each(function(i){
		var height;
		if(i==3)
			height=310;
		else
			height=45;
		$(this).css("height",height+"px");
	});

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
	case "center_con_div":
		space=205;
		break;
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
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">车辆管理-台账查询-台账详情</div>
		
		<div id="detail_div">
			<table>
			  <tr>
				<td class="td1" align="right">
					订单号
				</td>
				<td class="td2">
					${requestScope.cltz.ddh }
				</td>
				<td class="td1" align="right">
					车牌号
				</td>
				<td class="td2">
					${requestScope.cltz.cyclCph }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					订单状态
				</td>
				<td class="td2">
					${requestScope.cltz.ddztMc }
				</td>
				<td class="td1" align="right">
					流向类型
				</td>
				<td class="td2">
					<c:choose>
						<c:when test="${requestScope.cltz.lxlx eq 1 }">送运</c:when>
						<c:otherwise>取运</c:otherwise>
					</c:choose>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					进厂时间
				</td>
				<td class="td2">
					${requestScope.cltz.jcsj }
				</td>
				<td class="td1" align="right">
					出厂时间
				</td>
				<td class="td2">
					${requestScope.cltz.ccsj }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					进厂照片
				</td>
				<td class="td2">
					<img class="jczp_img" id="jczp_img" alt="" src="${requestScope.cltz.jczp }"/>
				</td>
				<td class="td1" align="right">
					出厂照片
				</td>
				<td class="td2">
					<img class="cczp_img" id="cczp_img" alt="" src="${requestScope.cltz.cczp }"/>
				</td>
			  </tr>
			</table>
		</div>

		<%@include file="../../inc/foot.jsp"%>
	</div>
</div>

</body>
</html>