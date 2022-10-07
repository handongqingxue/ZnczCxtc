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
.sfzzp_img,.zgzs_img,.jz_img{
	width: 220px;
	height:220px;
	margin-top: 10px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
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
		title:"司机信息",
		width:setFitWidthInParent("body","detail_div"),
		height:680,
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
		if(i==1||i==3)
			height=260;
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
		<div class="page_location_div">司机管理-待审核-司机详情</div>
		
		<div id="detail_div">
			<table>
			  <tr>
				<td class="td1" align="right">
					姓名
				</td>
				<td class="td2">
					${requestScope.sj.xm }
				</td>
				<td class="td1" align="right">
					手机号
				</td>
				<td class="td2">
					${requestScope.sj.sjh }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					照片
				</td>
				<td class="td2">
					<img class="sfzzp_img" id="sfzzp_img" alt="" src="${requestScope.sj.sfzzp }"/>
				</td>
				<td class="td1" align="right">
					身份证号
				</td>
				<td class="td2">
					${requestScope.sj.sfzh }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					资格证有效期至
				</td>
				<td class="td2">
					${requestScope.sj.zgzyxqz }
				</td>
				<td class="td1" align="right">
					驾证有效期至
				</td>
				<td class="td2">
					${requestScope.sj.jzyxqz }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					资格证书
				</td>
				<td class="td2">
					<img class="zgzs_img" id="zgzs_img" alt="" src="${requestScope.sj.zgzs }"/>
				</td>
				<td class="td1" align="right">
					驾证
				</td>
				<td class="td2">
					<img class="jz_img" id="jz_img" alt="" src="${requestScope.sj.jz }"/>
				</td>
			  </tr>
			</table>
		</div>

		<%@include file="../../inc/foot.jsp"%>
	</div>
</div>
</body>
</html>