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
.cph_inp,.fdjhm_inp,.clsbdh_inp,.ppxh_inp,.czxx_inp,.pz_inp{
	width: 150px;
	height:30px;
}
.uploadBut_div{
	line-height:30px;
	text-align:center;
	color:#fff;
	background-color: #1777FF;
	border-radius:5px;
	cursor: pointer;
}
.upZpBut_div{
	width: 90px;
	height: 30px;
}
.upXszBut_div{
	width: 100px;
	height: 30px;
}
.upScqdBut_div{
	width: 120px;
	height: 30px;
}
.upPfjdcxjtBut_div{
	width: 180px;
	height: 30px;
}
.zp_file,.xsz_file,.scqd_file,.pfjdcxjt_file{
	display: none;
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
var edNum=0;
var dshShzt='${requestScope.dshShzt}';
var bjzShzt='${requestScope.bjzShzt}';
$(function(){
	initEditDialog();

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var edpw=$("body").find(".panel.window").eq(edNum);
	var edws=$("body").find(".window-shadow").eq(edNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(edpw);
	ccDiv.append(edws);
}

function initEditDialog(){
	dialogTop+=20;
	$("#edit_div").dialog({
		title:"车辆信息",
		width:setFitWidthInParent("body","edit_div_table"),
		height:700,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"保存",id:"ok_but",iconCls:"icon-save",handler:function(){
        	   	checkEdit();
           }}
        ]
	});

	$("#edit_div table").css("width",(setFitWidthInParent("body","edit_div_table"))+"px");
	$("#edit_div table").css("magin","-100px");
	$("#edit_div table td").css("padding-left","50px");
	$("#edit_div table td").css("padding-right","20px");
	$("#edit_div table td").css("font-size","15px");
	$("#edit_div table .td1").css("width","15%");
	$("#edit_div table .td2").css("width","30%");
	$("#edit_div table tr").css("border-bottom","#CAD9EA solid 1px");
	$("#edit_div table tr").each(function(i){
		var height;
		if(i==5||i==6||i==7)
			height=310;
		else if(i==8)
			height=100;
		else
			height=45;
		$(this).css("height",height+"px");
	});

	$(".panel.window").eq(edNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(edNum).css("color","#000");
	$(".panel.window .panel-title").eq(edNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(edNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(edNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(edNum).css("border-color","#ddd");

	$("#edit_div #ok_but").css("left","45%");
	$("#edit_div #ok_but").css("position","absolute");
	$(".dialog-button").css("background-color","#fff");
	$(".dialog-button .l-btn-text").css("font-size","20px");

	initZCRQDB();
	initPFJDCBB();
	initYSLXCBB();
	initFZRQDB();
	initCLLXCBB();
	initSFZYCBB();
}

function initZCRQDB(){
    zcrqDB=$('#zcrq_db').datebox({
        required:false,
        onHidePanel:function(){
        	$("#zcrq").val(zcrqDB.datebox("getValue"));
        },
        onSelect:function(){
        	$("#zcrq").val(zcrqDB.datebox("getValue"));
        }
    });
    zcrqDB.datebox("setValue",'${requestScope.cl.zcrq }');
}

function initPFJDCBB(){
	var data=[];
	data.push({"value":"","text":"请选择排放阶段"});
	data.push({"value":"1","text":"国五燃油"});
	data.push({"value":"2","text":"国五燃气"});
	data.push({"value":"3","text":"国六燃油"});
	data.push({"value":"4","text":"国六燃气"});
	data.push({"value":"5","text":"电动"});
	pfjdCBB=$("#pfjd_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.cl.pfjd }');
		},
		onSelect:function(){
			$("#pfjd").val($(this).combobox("getValue"));
		}
	});
}

function initYSLXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择运输类型"});
	data.push({"value":"1","text":"普货运输"});
	data.push({"value":"2","text":"厂内运输"});
	data.push({"value":"3","text":"危化品运输"});
	yslxCBB=$("#yslx_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.cl.yslx }');
		},
		onSelect:function(){
			$("#yslx").val($(this).combobox("getValue"));
		}
	});
}

function initFZRQDB(){
    fzrqDB=$('#fzrq_db').datebox({
        required:false,
        onHidePanel:function(){
        	$("#fzrq").val(fzrqDB.datebox("getValue"));
        },
        onSelect:function(){
        	$("#fzrq").val(fzrqDB.datebox("getValue"));
        }
    });
    fzrqDB.datebox("setValue",'${requestScope.cl.fzrq }');
}

function initCLLXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择车辆类型"});
	data.push({"value":"1","text":"重型"});
	cllxCBB=$("#cllx_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.cl.cllx }');
		},
		onSelect:function(){
			$("#cllx").val($(this).combobox("getValue"));
		}
	});
}

function initSFZYCBB(){
	var data=[];
	data.push({"value":"","text":"请选择是否在用"});
	data.push({"value":"1","text":"是"});
	data.push({"value":"0","text":"否"});
	sfzyCBB=$("#sfzy_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.cl.sfzy }'=="true"?"1":"0");
		},
		onSelect:function(){
			$("#sfzy").val($(this).combobox("getValue"));
		}
	});
}

function checkEdit(){
	if(checkCPH()){
		if(checkZCRQ()){
			if(checkPFJD()){
				if(checkYSLX()){
					if(checkPPXH()){
						if(checkFZRQ()){
							if(checkCLLX()){
								if(checkSFZY()){
									editCheLiang();
								}
							}
						}
					}
				}
			}
		}
	}
}

function editCheLiang(){
	var shzt=$("#edit_div #shzt").val();
	if(shzt==bjzShzt)
		$("#edit_div #shzt").val(dshShzt);
	
	var formData = new FormData($("#form1")[0]);
	$.ajax({
		type:"post",
		url:clglPath+"editCheLiang",
		dataType: "json",
		data:formData,
		cache: false,
		processData: false,
		contentType: false,
		success: function (data){
			if(data.message=="ok"){
				alert(data.info);
				history.go(-1);
			}
			else{
				alert(data.info);
			}
		}
	});
}

function focusCPH(){
	var cph = $("#cph").val();
	if(cph=="车牌号不能为空"){
		$("#cph").val("");
		$("#cph").css("color", "#555555");
	}
}

//验证车牌号
function checkCPH(){
	var mc = $("#cph").val();
	if(mc==null||mc==""||mc=="车牌号不能为空"){
		$("#cph").css("color","#E15748");
    	$("#cph").val("车牌号不能为空");
    	return false;
	}
	else
		return true;
}

//验证注册日期
function checkZCRQ(){
	var zcrq=zcrqDB.datebox("getValue")
	if(zcrq==null||zcrq==""){
	  	alert("请选择注册日期");
	  	return false;
	}
	else
		return true;
}

//验证排放阶段
function checkPFJD(){
	var pfjd=pfjdCBB.combobox("getValue");
	if(pfjd==null||pfjd==""){
	  	alert("请选择排放阶段");
	  	return false;
	}
	else
		return true;
}

//验证运输类型
function checkYSLX(){
	var yslx=yslxCBB.combobox("getValue");
	if(yslx==null||yslx==""){
	  	alert("请选择运输类型");
	  	return false;
	}
	else
		return true;
}

function focusPPXH(){
	var ppxh = $("#ppxh").val();
	if(ppxh=="品牌型号不能为空"){
		$("#ppxh").val("");
		$("#ppxh").css("color", "#555555");
	}
}

//验证品牌型号
function checkPPXH(){
	var ppxh = $("#ppxh").val();
	if(ppxh==null||ppxh==""||ppxh=="品牌型号不能为空"){
		$("#ppxh").css("color","#E15748");
  	$("#ppxh").val("品牌型号不能为空");
  	return false;
	}
	else
		return true;
}

//验证发证日期
function checkFZRQ(){
	var fzrq=fzrqDB.datebox("getValue")
	if(fzrq==null||fzrq==""){
	  	alert("请选择发证日期");
	  	return false;
	}
	else
		return true;
}

//验证车辆类型
function checkCLLX(){
	var cllx=cllxCBB.combobox("getValue");
	if(cllx==null||cllx==""){
	  	alert("请选择车辆类型");
	  	return false;
	}
	else
		return true;
}

//验证是否在用
function checkSFZY(){
	var sfzy=sfzyCBB.combobox("getValue");
	if(sfzy==null||sfzy==""){
	  	alert("请选择是否在用");
	  	return false;
	}
	else
		return true;
}

function uploadZp(){
	document.getElementById("zp_file").click();
}

function uploadXsz(){
	document.getElementById("xsz_file").click();
}

function uploadScqd(){
	document.getElementById("scqd_file").click();
}

function uploadPfjdcxjt(){
	document.getElementById("pfjdcxjt_file").click();
}

function showZp(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#zp_img");

    if (fileObj && fileObj.files && fileObj.files[0]) {
        dataURL = windowURL.createObjectURL(fileObj.files[0]);
        $img.attr("src", dataURL);
    } else {
        dataURL = $file.val();
        var imgObj = document.getElementById("preview");
        // 两个坑:
        // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
        // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
        imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
        imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

    }
}

function showXsz(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#xsz_img");

    if (fileObj && fileObj.files && fileObj.files[0]) {
        dataURL = windowURL.createObjectURL(fileObj.files[0]);
        $img.attr("src", dataURL);
    } else {
        dataURL = $file.val();
        var imgObj = document.getElementById("preview");
        // 两个坑:
        // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
        // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
        imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
        imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

    }
}

function showScqd(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#scqd_img");

    if (fileObj && fileObj.files && fileObj.files[0]) {
        dataURL = windowURL.createObjectURL(fileObj.files[0]);
        $img.attr("src", dataURL);
    } else {
        dataURL = $file.val();
        var imgObj = document.getElementById("preview");
        // 两个坑:
        // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
        // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
        imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
        imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

    }
}

function showPfjdcxjt(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#pfjdcxjt_img");

    if (fileObj && fileObj.files && fileObj.files[0]) {
        dataURL = windowURL.createObjectURL(fileObj.files[0]);
        $img.attr("src", dataURL);
    } else {
        dataURL = $file.val();
        var imgObj = document.getElementById("preview");
        // 两个坑:
        // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
        // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
        imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
        imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

    }
}

function setFitWidthInParent(parent,self){
	var space=0;
	switch (self) {
	case "edit_div":
		space=340;
		break;
	case "edit_div_table":
	case "panel_window":
		space=355;
		break;
	}
	var width=$(parent).css("width");
	return width.substring(0,width.length-2)-space;
}
</script>
<title>编辑</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">车辆管理-综合查询-车辆编辑</div>
		
		<div id="edit_div">
			<form id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${requestScope.cl.id }"/>
			<table>
			  <tr>
				<td class="td1" align="right">
					车牌号
				</td>
				<td class="td2">
					<input type="text" class="cph_inp" id="cph" name="cph" value="${requestScope.cl.cph }" placeholder="请输入车牌号" onfocus="focusCPH()" onblur="checkCPH()"/>
				</td>
				<td class="td1" align="right">
					发动机号码
				</td>
				<td class="td2">
					<input type="text" class="fdjhm_inp" id="fdjhm" name="fdjhm" value="${requestScope.cl.fdjhm }" placeholder="请输入发动机号码"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					车辆识别代号
				</td>
				<td class="td2">
					<input type="text" class="clsbdh_inp" id="clsbdh" name="clsbdh" value="${requestScope.cl.clsbdh }" placeholder="请输入车辆识别代号"/>
				</td>
				<td class="td1" align="right">
					注册日期
				</td>
				<td class="td2">
					<input id="zcrq_db"/>
					<input type="hidden" id="zcrq" name="zcrq" value="${requestScope.cl.fzrq }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					排放阶段
				</td>
				<td class="td2">
					<input id="pfjd_cbb"/>
					<input type="hidden" id="pfjd" name="pfjd"/>
				</td>
				<td class="td1" align="right">
					运输类型
				</td>
				<td class="td2">
					<input id="yslx_cbb"/>
					<input type="hidden" id="yslx" name="yslx"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					品牌型号
				</td>
				<td class="td2">
					<input type="text" class="ppxh_inp" id="ppxh" name="ppxh" value="${requestScope.cl.ppxh }" placeholder="请输入品牌型号" onfocus="focusPPXH()" onblur="checkPPXH()"/>
				</td>
				<td class="td1" align="right">
					车主信息
				</td>
				<td class="td2">
					<input type="text" class="czxx_inp" id="czxx" name="czxx" value="${requestScope.cl.czxx }" placeholder="请输入车主信息"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					发证日期
				</td>
				<td class="td2">
					<input id="fzrq_db"/>
					<input type="hidden" id="fzrq" name="fzrq" value="${requestScope.cl.fzrq }"/>
				</td>
				<td class="td1" align="right">
					皮重
				</td>
				<td class="td2">
					<input type="number" class="pz_inp" id="pz" name="pz" value="${requestScope.cl.pz }" placeholder="请输入皮重"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					车辆类型
				</td>
				<td class="td2">
					<input id="cllx_cbb"/>
					<input type="hidden" id="cllx" name="cllx"/>
				</td>
				<td class="td1" align="right">
					照片
				</td>
				<td class="td2">
					<div class="uploadBut_div upZpBut_div" onclick="uploadZp()">选择照片</div>
					<input type="file" class="zp_file" id="zp_file" name="zp_file" onchange="showZp(this)"/>
					<img class="zp_img" id="zp_img" alt="" src="${requestScope.cl.zp }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					行驶证
				</td>
				<td class="td2">
					<div class="uploadBut_div upXszBut_div" onclick="uploadXsz()">选择行驶证</div>
					<input type="file" class="xsz_file" id="xsz_file" name="xsz_file" onchange="showXsz(this)"/>
					<img class="xsz_img" id="xsz_img" alt="" src="${requestScope.cl.xsz }"/>
				</td>
				<td class="td1" align="right">
					随车清单
				</td>
				<td class="td2">
					<div class="uploadBut_div upScqdBut_div" onclick="uploadScqd()">选择随车清单</div>
					<input type="file" class="scqd_file" id="scqd_file" name="scqd_file" onchange="showScqd(this)"/>
					<img class="scqd_img" id="scqd_img" alt="" src="${requestScope.cl.scqd }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					排放阶段查询截图
				</td>
				<td class="td2">
					<div class="uploadBut_div upPfjdcxjtBut_div" onclick="uploadPfjdcxjt()">选择排放阶段查询截图</div>
					<input type="file" class="pfjdcxjt_file" id="pfjdcxjt_file" name="pfjdcxjt_file" onchange="showPfjdcxjt(this)"/>
					<img class="pfjdcxjt_img" id="pfjdcxjt_img" alt="" src="${requestScope.cl.pfjdcxjt }"/>
				</td>
				<td class="td1" align="right">
					是否在用
				</td>
				<td class="td2">
					<input id="sfzy_cbb"/>
					<input type="hidden" id="sfzy" name="sfzy"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					审核状态
				</td>
				<td class="td2">
					<input type="hidden" id="shzt" name="shzt" value="${requestScope.cl.shzt }"/>
					<c:if test="${requestScope.cl.shzt eq 1 }">待审核</c:if>
					<c:if test="${requestScope.cl.shzt eq 2 }">审核通过</c:if>
					<c:if test="${requestScope.cl.shzt eq 3 }">编辑中</c:if>
				</td>
				<td class="td1" align="right">
					备注
				</td>
				<td class="td2">
					<textarea rows="3" cols="30" id="bz" name="bz" placeholder="请输入备注">${requestScope.cl.bz }</textarea>
				</td>
			  </tr>
			</table>
			</form>
		</div>
		<%@include file="../../inc/foot.jsp"%>
	</div>
</div>
</body>
</html>