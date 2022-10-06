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
.xm_inp,.sjh_inp,.sfzh_inp{
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
.upSfzzpBut_div,.upJzBut_div{
	width: 100px;
	height: 30px;
}
.upZgzsBut_div{
	width: 130px;
	height: 30px;
}
.sfzzp_file,.zgzs_file,.jz_file{
	display: none;
}
.sfzzp_img,.zgzs_img,.jz_img{
	width: 220px;
	height:220px;
	margin-top: 10px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var sjglPath=path+'sjgl/';
var dialogTop=70;
var dialogLeft=20;
var edNum=0;
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
		title:"司机信息",
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
		if(i==1||i==3)
			height=310;
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
	
	initZGZYXQZDB();
	initJZYXQZDB();
	initZYZTCBB();
	initSHZTCBB();
}

function initZGZYXQZDB(){
	zgzyxqzDB=$('#zgzyxqz_db').datebox({
		width:160,
        required:false,
        onHidePanel:function(){
        	$("#zgzyxqz").val(zgzyxqzDB.datebox("getValue"));
        },
        onSelect:function(){
        	$("#zgzyxqz").val(zgzyxqzDB.datebox("getValue"));
        }
    });
	zgzyxqzDB.datebox('textbox').attr('placeholder', '请选择资格证有效期至');
}

function initJZYXQZDB(){
	jzyxqzDB=$('#jzyxqz_db').datebox({
		width:160,
        required:false,
        onHidePanel:function(){
        	$("#jzyxqz").val(jzyxqzDB.datebox("getValue"));
        },
        onSelect:function(){
        	$("#jzyxqz").val(jzyxqzDB.datebox("getValue"));
        }
    });
	jzyxqzDB.datebox('textbox').attr('placeholder', '请选择驾证有效期至');
}

function initZYZTCBB(){
	var data=[];
	data.push({"value":"","text":"请选择在用状态"});
	data.push({"value":"1","text":"是"});
	data.push({"value":"0","text":"否"});
	zyztCBB=$("#zyzt_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.sj.zyzt }'?1:0);
		},
		onSelect:function(){
			$("#zyzt").val($(this).combobox("getValue"));
		}
	});
}

function initSHZTCBB(){
	shztCBB=$("#shzt_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:[{"value":"","text":"请选择审核状态"},{"value":"1","text":"编辑中"},{"value":"2","text":"待审核"},{"value":"3","text":"审核通过"}],
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.sj.shzt }');
		},
		onSelect:function(){
			$("#shzt").val($(this).combobox("getValue"));
		}
	});
}

function checkEdit(){
	if(checkXM()){
		if(checkSFZH()){
			if(checkZYZT()){
				if(checkSHZT()){
					editSiJi();
				}
			}
		}
	}
}

function editSiJi(){
	var formData = new FormData($("#form1")[0]);
	$.ajax({
		type:"post",
		url:sjglPath+"editSiJi",
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

function focusXM(){
	var xm = $("#xm").val();
	if(xm=="姓名不能为空"){
		$("#xm").val("");
		$("#xm").css("color", "#555555");
	}
}

//验证姓名
function checkXM(){
	var xm = $("#xm").val();
	if(xm==null||xm==""||xm=="姓名不能为空"){
		$("#xm").css("color","#E15748");
    	$("#xm").val("姓名不能为空");
    	return false;
	}
	else
		return true;
}

function focusSFZH(){
	var sfzh = $("#sfzh").val();
	if(sfzh=="身份证号不能为空"){
		$("#sfzh").val("");
		$("#sfzh").css("color", "#555555");
	}
}

//验证身份证号
function checkSFZH(){
	var sfzh = $("#sfzh").val();
	if(sfzh==null||sfzh==""||sfzh=="身份证号不能为空"){
		$("#sfzh").css("color","#E15748");
    	$("#sfzh").val("身份证号不能为空");
    	return false;
	}
	else
		return true;
}

//验证在用状态
function checkZYZT(){
	var zyzt=zyztCBB.combobox("getValue");
	if(zyzt==null||zyzt==""){
	  	alert("请选择在用状态");
	  	return false;
	}
	else
		return true;
}

//验证审核状态
function checkSHZT(){
	var shzt=shztCBB.combobox("getValue");
	if(shzt==null||shzt==""){
	  	alert("请选择审核状态");
	  	return false;
	}
	else
		return true;
}

function uploadSfzzp(){
	document.getElementById("sfzzp_file").click();
}

function uploadZgzs(){
	document.getElementById("zgzs_file").click();
}

function uploadJz(){
	document.getElementById("jz_file").click();
}

function showSfzzp(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#sfzzp_img");

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

function showZgzs(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#zgzs_img");

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

function showJz(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#jz_img");

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
<title>创建</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">司机信息-编辑</div>
		
		<div id="edit_div">
			<form id="form1" name="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${requestScope.sj.id }"/>
			<table>
			  <tr>
				<td class="td1" align="right">
					姓名
				</td>
				<td class="td2">
					<input type="text" class="xm_inp" id="xm" name="xm" value="${requestScope.sj.xm }" placeholder="请输入姓名" onfocus="focusXM()" onblur="checkXM()"/>
				</td>
				<td class="td1" align="right">
					手机号
				</td>
				<td class="td2">
					<input type="text" class="sjh_inp" id="sjh" name="sjh" value="${requestScope.sj.sjh }" placeholder="请输入手机号"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					照片
				</td>
				<td class="td2">
					<div class="uploadBut_div upSfzzpBut_div" onclick="uploadSfzzp()">选择照片</div>
					<input type="file" class="sfzzp_file" id="sfzzp_file" name="sfzzp_file" onchange="showSfzzp(this)"/>
					<img class="sfzzp_img" id="sfzzp_img" alt="" src="${requestScope.sj.sfzzp }"/>
				</td>
				<td class="td1" align="right">
					身份证号
				</td>
				<td class="td2">
					<input type="text" class="sfzh_inp" id="sfzh" name="sfzh" value="${requestScope.sj.sfzh }" placeholder="请输入身份证号" onfocus="focusSFZH()" onblur="checkSFZH()"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					资格证有效期至
				</td>
				<td class="td2">
					<input id="zgzyxqz_db"/>
					<input type="hidden" id="zgzyxqz" name="zgzyxqz"/>
				</td>
				<td class="td1" align="right">
					驾证有效期至
				</td>
				<td class="td2">
					<input id="jzyxqz_db"/>
					<input type="hidden" id="jzyxqz" name="jzyxqz"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					资格证书
				</td>
				<td class="td2">
					<div class="uploadBut_div upZgzsBut_div" onclick="uploadZgzs()">选择资格证书</div>
					<input type="file" class="zgzs_file" id="zgzs_file" name="zgzs_file" onchange="showZgzs(this)"/>
					<img class="zgzs_img" id="zgzs_img" alt="" src="${requestScope.sj.zgzs }"/>
				</td>
				<td class="td1" align="right">
					驾证
				</td>
				<td class="td2">
					<div class="uploadBut_div upJzBut_div" onclick="uploadJz()">选择驾证</div>
					<input type="file" class="jz_file" id="jz_file" name="jz_file" onchange="showJz(this)"/>
					<img class="jz_img" id="jz_img" alt="" src="${requestScope.sj.jz }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					在用状态
				</td>
				<td class="td2">
					<input id="zyzt_cbb"/>
					<input type="hidden" id="zyzt" name="zyzt" value="${requestScope.sj.zyzt }"/>
				</td>
				<td class="td1" align="right">
					审核状态
				</td>
				<td class="td2">
					<input id="shzt_cbb"/>
					<input type="hidden" id="shzt" name="shzt" value="${requestScope.sj.shzt }"/>
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