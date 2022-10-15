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
.yzxzl_inp,.sjzl_inp,.jszl_inp,.bs_inp,.ks_inp,.dfgbjz_inp,.dfgbpz_inp,.dfgbmz_inp{
	width: 180px;
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
.upDfbdzpBut_div{
	width: 150px;
	height: 30px;
}
.dfbdzp_file{
	display: none;
}
.ewm_img,.dfbdzp_img{
	width: 220px;
	height:220px;
	margin-top: 10px;
}
</style>
<script type="text/javascript">
var path='<%=basePath %>';
var ddglPath=path+'ddgl/';
var wzglPath=path+'wzgl/';
var dwglPath=path+'dwgl/';
var clglPath=path+'clgl/';
var sjglPath=path+'sjgl/';
var dialogTop=70;
var dialogLeft=20;
var edNum=0;
var dshDdztMc='${requestScope.dshDdztMc}';
var bjzDdztMc='${requestScope.bjzDdztMc}';
$(function(){
	initEditDialog();//0

	initDialogPosition();//将不同窗体移动到主要内容区域
	showCompontByQx();
});

function showCompontByQx(){
	if(yhm=="admin"){
		$("#edit_div #ddh").removeAttr("disabled");
		lxlxCBB.combobox({disabled:false});
		setTimeout(function(){
			wzlxCBB.combobox({disabled:false});
			yssCBB.combobox({disabled:false});
			fhdwCBB.combobox({disabled:false});
			shdwCBB.combobox({disabled:false});
		},"2000");
		wzCBB.combobox({disabled:false});
	}
	else{
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==2){
				$("#edit_div #ddh").removeAttr("disabled");
				lxlxCBB.combobox({disabled:false});
				setTimeout(function(){
					wzlxCBB.combobox({disabled:false});
					yssCBB.combobox({disabled:false});
					fhdwCBB.combobox({disabled:false});
					shdwCBB.combobox({disabled:false});
				},"2000");
				wzCBB.combobox({disabled:false});
			}
		}
	}
}

function initDialogPosition(){
	//基本属性组
	var edpw=$("body").find(".panel.window").eq(edNum);
	var edws=$("body").find(".window-shadow").eq(edNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(edpw);
	ccDiv.append(edws);
	ccDiv.css("width",setFitWidthInParent("body","center_con_div")+"px");
}

function initEditDialog(){
	dialogTop+=20;
	$("#edit_div").dialog({
		title:"订单信息",
		width:setFitWidthInParent("body","edit_div"),
		height:720,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"保存",id:"ok_but",iconCls:"icon-ok",handler:function(){
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
		if(i==2)
			height=230;
		else if(i==4)
			height=100;
		else if(i==8)
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

	initLXLXCBB();
	initJHYSRQDB();
	initDFGBSJDTB();
	initYSSCBB();
	initWZLXCBB();
	initWZCBB();
	initFHDWCBB();
	initSHDWCBB();
	initCYCLCBB();
	initCYSJCBB();
	setTimeout(function(){
		loadWZCBBData();
	},"1000");
}

function initLXLXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择流向类型"});
	data.push({"value":"1","text":"送运"});
	data.push({"value":"2","text":"取运"});
	lxlxCBB=$("#lxlx_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.dd.lxlx }');
		},
		onSelect:function(){
			$("#lxlx").val($(this).combobox("getValue"));
		}
	});
}

function initJHYSRQDB(){
	jhysrqDB=$('#jhysrq_db').datebox({
        required:false
    });
	jhysrqDB.datebox("setValue",'${requestScope.dd.jhysrq }');
}

function initDFGBSJDTB(){
	dfgbsjDTB=$('#dfgbsj_dtb').datetimebox({
        required:false
    });
	dfgbsjDTB.datetimebox("setValue",'${requestScope.dfgbjl.dfgbsj }');
}

function initYSSCBB(){
	var data=[];
	data.push({"value":"","text":"请选择运输商"});
	$.post(dwglPath+"queryYunShuShangCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			yssCBB=$("#edit_div #yss_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.dd.yssId }');
				}
			});
		}
	,"json");
}

function initWZLXCBB(){
	var data=[];
	data.push({"value":"","text":"请选择物资类型"});
	$.post(wzglPath+"queryWuZiLeiXingCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			wzlxCBB=$("#edit_div #wzlx_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.dd.wzlxId }');
				},
				onSelect:function(){
					loadWZCBBData();
				}
			});
		}
	,"json");
}

function initWZCBB(){
	var data=[];
	data.push({"value":"","text":"请选择物资名称"});
	wzCBB=$("#edit_div #wz_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data,
		onLoadSuccess:function(){
			$(this).combobox("setValue",'${requestScope.dd.wzId }');
		}
	});
}

function loadWZCBBData(){
	var data=[];
	data.push({"value":"","text":"请选择物资名称"});
	var wzlxId=wzlxCBB.combobox("getValue");
	$.post(wzglPath+"queryWuZiCBBList",
		{wzlxId:wzlxId},
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			wzCBB.combobox("loadData",data);
		}
	,"json");
}

function initFHDWCBB(){
	var data=[];
	data.push({"value":"","text":"请选择发货单位"});
	$.post(dwglPath+"queryFaHuoDanWeiCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			fhdwCBB=$("#edit_div #fhdw_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.dd.fhdwId }');
				}
			});
		}
	,"json");
}

function initSHDWCBB(){
	var data=[];
	data.push({"value":"","text":"请选择收货单位"});
	$.post(dwglPath+"queryShouHuoDanWeiCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].mc});
			}
			shdwCBB=$("#edit_div #shdw_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.dd.shdwId }');
				}
			});
		}
	,"json");
}

function initCYCLCBB(){
	var data=[];
	data.push({"value":"","text":"请选择承运车辆"});
	$.post(clglPath+"queryCheLiangCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].cph});
			}
			cyclCBB=$("#edit_div #cycl_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.dd.cyclId }');
				}
			});
		}
	,"json");
}

function initCYSJCBB(){
	var data=[];
	data.push({"value":"","text":"请选择承运司机"});
	$.post(sjglPath+"querySiJiCBBList",
		function(result){
			var rows=result.rows;
			for(var i=0;i<rows.length;i++){
				data.push({"value":rows[i].id,"text":rows[i].xm});
			}
			cysjCBB=$("#edit_div #cysj_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
				onLoadSuccess:function(){
					$(this).combobox("setValue",'${requestScope.dd.cysjId }');
				}
			});
		}
	,"json");
}

function checkEdit(){
	if(checkYZXZL()){
		if(checkLXLXId()){
			if(checkJHYSRQ()){
				if(checkYSSId()){
					if(checkWZLXId()){
						if(checkWZId()){
							if(checkFHDWId()){
								if(checkSHDWId()){
									if(checkCYCLId()){
										if(checkCYSJId()){
											editDingDan();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

function editDingDan(){
	var lxlx=lxlxCBB.combobox("getValue");
	$("#edit_div #lxlx").val(lxlx);
	var jhysrq=jhysrqDB.datebox("getValue");
	$("#edit_div #jhysrq").val(jhysrq);
	var dfgbsj=dfgbsjDTB.datetimebox("getValue");
	$("#edit_div #dfgbsj").val(dfgbsj);
	var wzlxId=wzlxCBB.combobox("getValue");
	$("#edit_div #wzlxId").val(wzlxId);
	var wzId=wzCBB.combobox("getValue");
	$("#edit_div #wzId").val(wzId);
	var yssId=yssCBB.combobox("getValue");
	$("#edit_div #yssId").val(yssId);
	var fhdwId=fhdwCBB.combobox("getValue");
	$("#edit_div #fhdwId").val(fhdwId);
	var shdwId=shdwCBB.combobox("getValue");
	$("#edit_div #shdwId").val(shdwId);
	var cyclId=cyclCBB.combobox("getValue");
	$("#edit_div #cyclId").val(cyclId);
	var cyclCph=cyclCBB.combobox("getText");
	$("#edit_div #cyclCph").val(cyclCph);
	var cysjId=cysjCBB.combobox("getValue");
	$("#edit_div #cysjId").val(cysjId);
	var ddztMc=$("#edit_div #ddztMc").val();
	if(ddztMc==bjzDdztMc)
		$("#edit_div #ddztMc").val(dshDdztMc);
	
	var formData = new FormData($("#form1")[0]);
	
	$.ajax({
		type:"post",
		url:ddglPath+"editDingDan",
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

function focusYZXZL(){
	var yzxzl = $("#yzxzl").val();
	if(yzxzl=="预装卸重量不能为空"){
		$("#yzxzl").val("");
		$("#yzxzl").css("color", "#555555");
	}
}

//验证预装卸重量
function checkYZXZL(){
	var yzxzl = $("#yzxzl").val();
	if(yzxzl==null||yzxzl==""||yzxzl=="预装卸重量不能为空"){
		$("#yzxzl").css("color","#E15748");
    	$("#yzxzl").val("预装卸重量不能为空");
    	return false;
	}
	else
		return true;
}

//验证流向类型
function checkLXLXId(){
	var lxlx=lxlxCBB.combobox("getValue");
	if(lxlx==null||lxlx==""){
	  	alert("请选择流向类型");
	  	return false;
	}
	else
		return true;
}

//验证计划运输日期
function checkJHYSRQ(){
	var jhysrq=jhysrqDB.datebox("getValue");
	if(jhysrq==null||jhysrq==""){
	  	alert("请选择计划运输日期");
	  	return false;
	}
	else
		return true;
}

//验证运输商
function checkYSSId(){
	var yssId=yssCBB.combobox("getValue");
	if(yssId==null||yssId==""){
	  	alert("请选择运输商");
	  	return false;
	}
	else
		return true;
}

//验证物资类型
function checkWZLXId(){
	var wzlxId=wzlxCBB.combobox("getValue");
	if(wzlxId==null||wzlxId==""){
	  	alert("请选择物资类型");
	  	return false;
	}
	else
		return true;
}

//验证物资
function checkWZId(){
	var wzId=wzCBB.combobox("getValue");
	if(wzId==null||wzId==""){
	  	alert("请选择物资");
	  	return false;
	}
	else
		return true;
}

//验证发货单位
function checkFHDWId(){
	var fhdwId=fhdwCBB.combobox("getValue");
	if(fhdwId==null||fhdwId==""){
	  	alert("请选择发货单位");
	  	return false;
	}
	else
		return true;
}

//验证收货单位
function checkSHDWId(){
	var shdwId=shdwCBB.combobox("getValue");
	if(shdwId==null||shdwId==""){
	  	alert("请选择收货单位");
	  	return false;
	}
	else
		return true;
}

//验证承运车辆
function checkCYCLId(){
	var cyclId=cyclCBB.combobox("getValue");
	if(cyclId==null||cyclId==""){
	  	alert("请选择承运车辆");
	  	return false;
	}
	else
		return true;
}

//验证承运司机
function checkCYSJId(){
	var cysjId=cysjCBB.combobox("getValue");
	if(cysjId==null||cysjId==""){
	  	alert("请选择承运司机");
	  	return false;
	}
	else
		return true;
}

function uploadDfbdzp(){
	document.getElementById("dfbdzp_file").click();
}

function showDfbdzp(obj){
	var file = $(obj);
    var fileObj = file[0];
    var windowURL = window.URL || window.webkitURL;
    var dataURL;
    var $img = $("#dfbdzp_img");

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
	case "center_con_div":
		space=205;
		break;
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
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="center_con_div" id="center_con_div">
		<div class="page_location_div">订单管理-综合查询-编辑订单</div>
		
		<div id="edit_div">
			<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${requestScope.dd.id }"/>
			<input type="hidden" id="ddId" name="ddId" value="${requestScope.dd.id }"/>
			<input type="hidden" id="ddztMc" name="ddztMc" value="${requestScope.dd.ddztMc }"/>
			<table>
			  <tr>
				<td class="td1" align="right">
					订单号
				</td>
				<td class="td2">
					${requestScope.dd.ddh }
				</td>
				<td class="td1" align="right">
					预装卸重量
				</td>
				<td class="td2">
					<input type="number" class="yzxzl_inp" id="yzxzl" name="yzxzl" value="${requestScope.dd.yzxzl }" placeholder="请输入预装卸重量" onfocus="focusYZXZL()" onblur="checkYZXZL()"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					流向类型
				</td>
				<td class="td2">
					<input id="lxlx_cbb"/>
					<input type="hidden" id="lxlx" name="lxlx"/>
				</td>
				<td class="td1" align="right">
					编辑时间
				</td>
				<td class="td2">
					${requestScope.dd.bjsj }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					二维码
				</td>
				<td class="td2">
					<img class="ewm_img" id="ewm_img" alt="" src="${requestScope.dd.ewm }"/>
				</td>
				<td class="td1" align="right">
					实际重量
				</td>
				<td class="td2">
					<input type="number" class="sjzl_inp" id="sjzl" name="sjzl" value="${requestScope.dd.sjzl }" placeholder="请输入实际重量"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					重量差额比
				</td>
				<td class="td2">
					${requestScope.dd.zlceb }
				</td>
				<td class="td1" align="right">
					订单状态
				</td>
				<td class="td2">
					${requestScope.dd.ddztMc }
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					计划运输日期
				</td>
				<td class="td2">
					<input id="jhysrq_db"/>
					<input type="hidden" id="jhysrq" name="jhysrq"/>
				</td>
				<td class="td1" align="right">
					备注
				</td>
				<td class="td2">
					<textarea rows="3" cols="30" id="bz" name="bz" placeholder="请输入备注">${requestScope.dd.bz }</textarea>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					结算重量
				</td>
				<td class="td2">
					<input type="number" class="jszl_inp" id="jszl" name="jszl" value="${requestScope.dd.jszl }" placeholder="请输入结算重量"/>
				</td>
				<td class="td1" align="right">
					包数
				</td>
				<td class="td2">
					<input type="text" class="bs_inp" id="bs" name="bs" value="${requestScope.dd.bs }" placeholder="请输入包数" />
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					块数
				</td>
				<td class="td2">
					<input type="text" class="ks_inp" id="ks" name="ks" value="${requestScope.dd.ks }" placeholder="请输入块数" />
				</td>
				<td class="td1" align="right">
					对方过磅净重
				</td>
				<td class="td2">
					<input type="number" class="dfgbjz_inp" id="dfgbjz" name="dfgbjz" value="${requestScope.dfgbjl.dfgbjz }" placeholder="请输入对方过磅净重" />
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					对方过磅皮重
				</td>
				<td class="td2">
					<input type="number" class="dfgbpz_inp" id="dfgbpz" name="dfgbpz" value="${requestScope.dfgbjl.dfgbpz }" placeholder="请输入对方过磅皮重" />
				</td>
				<td class="td1" align="right">
					对方过磅毛重
				</td>
				<td class="td2">
					<input type="number" class="dfgbmz_inp" id="dfgbmz" name="dfgbmz" value="${requestScope.dfgbjl.dfgbmz }" placeholder="请输入对方过磅毛重" />
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					对方榜单照片
				</td>
				<td class="td2">
					<div class="uploadBut_div upDfbdzpBut_div" onclick="uploadDfbdzp()">选择对方榜单照片</div>
					<input type="file" class="dfbdzp_file" id="dfbdzp_file" name="dfbdzp_file" onchange="showDfbdzp(this)"/>
					<img class="dfbdzp_img" id="dfbdzp_img" alt="" src="${requestScope.dfgbjl.dfbdzp }"/>
				</td>
				<td class="td1" align="right">
					对方过磅时间
				</td>
				<td class="td2">
					<input id="dfgbsj_dtb"/>
					<input type="hidden" id="dfgbsj" name="dfgbsj" value="${requestScope.dfgbjl.dfgbsj }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					出卡次数
				</td>
				<td class="td2">
					${requestScope.dd.ckcs }
				</td>
				<td class="td1" align="right">
					过磅时间
				</td>
				<td class="td2">
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					运输商
				</td>
				<td class="td2">
					<input id="yss_cbb" disabled="disabled"/>
					<input type="hidden" id="yssId" name="yssId"/>
				</td>
				<td class="td1" align="right">
					物资类型
				</td>
				<td class="td2">
					<input id="wzlx_cbb" disabled="disabled"/>
					<input type="hidden" id="wzlxId" name="wzlxId" value="${requestScope.dd.wzlxId }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					物资名称
				</td>
				<td class="td2">
					<input id="wz_cbb" disabled="disabled"/>
					<input type="hidden" id="wzId" name="wzId" value="${requestScope.dd.wzId }"/>
				</td>
				<td class="td1" align="right">
					发货单位
				</td>
				<td class="td2">
					<input id="fhdw_cbb" disabled="disabled"/>
					<input type="hidden" id="fhdwId" name="fhdwId" value="${requestScope.dd.fhdwId }"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					收货单位
				</td>
				<td class="td2">
					<input id="shdw_cbb" disabled="disabled"/>
					<input type="hidden" id="shdwId" name="shdwId" value="${requestScope.dd.shdwId }"/>
				</td>
				<td class="td1" align="right">
					承运车辆
				</td>
				<td class="td2">
					<input id="cycl_cbb"/>
					<input type="hidden" id="cyclId" name="cyclId" value="${requestScope.dd.cyclId }"/>
					<input type="hidden" id="cyclCph" name="cyclCph"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					承运司机
				</td>
				<td class="td2">
					<input id="cysj_cbb"/>
					<input type="hidden" id="cysjId" name="cysjId" value="${requestScope.dd.cysjId }"/>
				</td>
				<td class="td1" align="right">
				</td>
				<td class="td2">
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