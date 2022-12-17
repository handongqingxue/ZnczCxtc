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
.zp_img,.xsz_img,.scqd_img,.pfjdcxjt_img{
	width: 220px;
	height:220px;
	margin-top: 10px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var clglPath=path+'clgl/';
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
		title:"车辆信息",
		width:setFitWidthInParent("body","detail_div"),
		height:700,
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
		if(i==5||i==6||i==7)
			height=310;
		else if(i==8)
			height=100;
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
		<div class="page_location_div">车辆管理-综合查询-车辆详情</div>
		
		<div id="detail_div">
			<table>
			  <tr>
				<td class="td1" align="right">
					车牌号
				</td>
				<td class="td2">
					${requestScope.cl.cph }
				</td>
				<td class="td1" align="right">
					发动机号码
				</td>
				<td class="td2">
					${requestScope.cl.fdjhm }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					车辆识别代号
				</td>
				<td class="td2">
					${requestScope.cl.clsbdh }
				</td>
				<td class="td1" align="right">
					注册日期
				</td>
				<td class="td2">
					${requestScope.cl.zcrq }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					排放阶段
				</td>
				<td class="td2">
					<c:if test="${requestScope.cl.pfjd eq requestScope.gwryPfjd }">${requestScope.gwryPfjdMc }</c:if>
					<c:if test="${requestScope.cl.pfjd eq requestScope.gwrqPfjd }">${requestScope.gwrqPfjdMc }</c:if>
					<c:if test="${requestScope.cl.pfjd eq requestScope.glryPfjd }">${requestScope.glryPfjdMc }</c:if>
					<c:if test="${requestScope.cl.pfjd eq requestScope.glrqPfjd }">${requestScope.glrqPfjdMc }</c:if>
					<c:if test="${requestScope.cl.pfjd eq requestScope.ddPfjd }">${requestScope.ddPfjdMc }</c:if>
				</td>
				<td class="td1" align="right">
					车辆运输类型
				</td>
				<td class="td2">
					<c:if test="${requestScope.cl.clyslx eq requestScope.physYslx }">${requestScope.physYslxMc }</c:if>
					<c:if test="${requestScope.cl.clyslx eq requestScope.cnysYslx }">${requestScope.cnysYslxMc }</c:if>
					<c:if test="${requestScope.cl.clyslx eq requestScope.whpysYslx }">${requestScope.whpysYslxMc }</c:if>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					品牌型号
				</td>
				<td class="td2">
					${requestScope.cl.ppxh }
				</td>
				<td class="td1" align="right">
					车主信息
				</td>
				<td class="td2">
					${requestScope.cl.czxx }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					发证日期
				</td>
				<td class="td2">
					${requestScope.cl.fzrq }
				</td>
				<td class="td1" align="right">
					皮重
				</td>
				<td class="td2">
					${requestScope.cl.pz }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					车辆类型
				</td>
				<td class="td2">
					<c:if test="${requestScope.cl.cllx eq 1 }">重型</c:if>
				</td>
				<td class="td1" align="right">
					照片
				</td>
				<td class="td2">
					<img class="zp_img" id="zp_img" alt="" src="${requestScope.cl.zp }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					行驶证
				</td>
				<td class="td2">
					<img class="xsz_img" id="xsz_img" alt="" src="${requestScope.cl.xsz }"/>
				</td>
				<td class="td1" align="right">
					随车清单
				</td>
				<td class="td2">
					<img class="scqd_img" id="scqd_img" alt="" src="${requestScope.cl.scqd }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					排放阶段查询截图
				</td>
				<td class="td2">
					<img class="pfjdcxjt_img" id="pfjdcxjt_img" alt="" src="${requestScope.cl.pfjdcxjt }"/>
				</td>
				<td class="td1" align="right">
					是否在用
				</td>
				<td class="td2">
					<c:choose>
						<c:when test="${requestScope.cl.sfzy }">是</c:when>
						<c:otherwise>否</c:otherwise>
					</c:choose>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					审核状态
				</td>
				<td class="td2">
					<c:if test="${requestScope.cl.shzt eq requestScope.dshShzt }">${requestScope.dshShztMc }</c:if>
					<c:if test="${requestScope.cl.shzt eq requestScope.shtgShzt }">${requestScope.shtgShztMc }</c:if>
					<c:if test="${requestScope.cl.shzt eq requestScope.bjzShzt }">${requestScope.bjzShztMc }</c:if>
				</td>
				<td class="td1" align="right">
					备注
				</td>
				<td class="td2">
					${requestScope.cl.bz }
				</td>
			  </tr>
			</table>
		</div>

		<%@include file="../../inc/foot.jsp"%>
	</div>
</div>
</body>
</html>