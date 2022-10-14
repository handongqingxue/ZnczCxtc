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
.dfbdzp_img{
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
var ndNum=0;
$(function(){
	initNewDialog();//0

	initDialogPosition();//将不同窗体移动到主要内容区域
});

function initDialogPosition(){
	//基本属性组
	var ndpw=$("body").find(".panel.window").eq(ndNum);
	var ndws=$("body").find(".window-shadow").eq(ndNum);

	var ccDiv=$("#center_con_div");
	ccDiv.append(ndpw);
	ccDiv.append(ndws);
	ccDiv.css("width",setFitWidthInParent("body","center_con_div")+"px");
}

function initNewDialog(){
	dialogTop+=20;
	$("#new_div").dialog({
		title:"订单信息",
		width:setFitWidthInParent("body","new_div"),
		height:720,
		top:dialogTop,
		left:dialogLeft,
		buttons:[
           {text:"保存",id:"ok_but",iconCls:"icon-ok",handler:function(){
        	   checkNew();
           }}
        ]
	});

	$("#new_div table").css("width",(setFitWidthInParent("body","new_div_table"))+"px");
	$("#new_div table").css("magin","-100px");
	$("#new_div table td").css("padding-left","50px");
	$("#new_div table td").css("padding-right","20px");
	$("#new_div table td").css("font-size","15px");
	$("#new_div table .td1").css("width","15%");
	$("#new_div table .td2").css("width","30%");
	$("#new_div table tr").css("border-bottom","#CAD9EA solid 1px");
	$("#new_div table tr").each(function(i){
		var height;
		if(i==2)
			height=100;
		else if(i==5)
			height=310;
		else
			height=45;
		$(this).css("height",height+"px");
	});

	$(".panel.window").eq(ndNum).css("margin-top","20px");
	$(".panel.window .panel-title").eq(ndNum).css("color","#000");
	$(".panel.window .panel-title").eq(ndNum).css("font-size","15px");
	$(".panel.window .panel-title").eq(ndNum).css("padding-left","10px");
	
	$(".panel-header, .panel-body").css("border-color","#ddd");
	
	//以下的是表格下面的面板
	$(".window-shadow").eq(ndNum).css("margin-top","20px");
	$(".window,.window .window-body").eq(ndNum).css("border-color","#ddd");

	$("#new_div #ok_but").css("left","45%");
	$("#new_div #ok_but").css("position","absolute");
	
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
}

function initLXLXCBB(){
	lxlxCBB=$("#lxlx_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:[
			{"value":"","text":"请选择流向类型"},{"value":"1","text":"送运"},{"value":"2","text":"取运"}
		],
		onSelect:function(){
			$("#lxlx").val($(this).combobox("getValue"));
		}
	});
}

function initJHYSRQDB(){
	jhysrqDB=$('#jhysrq_db').datebox({
        required:false
    });
}

function initDFGBSJDTB(){
	dfgbsjDTB=$('#dfgbsj_dtb').datetimebox({
        required:false
    });
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
			yssCBB=$("#new_div #yss_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data
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
			wzlxCBB=$("#new_div #wzlx_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data,
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
	wzCBB=$("#new_div #wz_cbb").combobox({
		valueField:"value",
		textField:"text",
		data:data
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
			fhdwCBB=$("#new_div #fhdw_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data
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
			shdwCBB=$("#new_div #shdw_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data
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
			cyclCBB=$("#new_div #cycl_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data
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
			cysjCBB=$("#new_div #cysj_cbb").combobox({
				valueField:"value",
				textField:"text",
				data:data
			});
		}
	,"json");
}

function checkNew(){
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
											newDingDan();
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

function newDingDan(){
	var lxlx=lxlxCBB.combobox("getValue");
	$("#new_div #lxlx").val(lxlx);
	var wzlxId=wzlxCBB.combobox("getValue");
	$("#new_div #wzlxId").val(wzlxId);
	var wzId=wzCBB.combobox("getValue");
	$("#new_div #wzId").val(wzId);
	var yssId=yssCBB.combobox("getValue");
	$("#new_div #yssId").val(yssId);
	var fhdwId=fhdwCBB.combobox("getValue");
	$("#new_div #fhdwId").val(fhdwId);
	var shdwId=shdwCBB.combobox("getValue");
	$("#new_div #shdwId").val(shdwId);
	var cyclId=cyclCBB.combobox("getValue");
	$("#new_div #cyclId").val(cyclId);
	var cyclCph=cyclCBB.combobox("getText");
	$("#new_div #cyclCph").val(cyclCph);
	var cysjId=cysjCBB.combobox("getValue");
	$("#new_div #cysjId").val(cysjId);
	
	var formData = new FormData($("#form1")[0]);
	$.ajax({
		type:"post",
		url:ddglPath+"newDingDan",
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

//验证物资名称
function checkWZId(){
	var wzId=wzCBB.combobox("getValue");
	if(wzId==null||wzId==""){
	  	alert("请选择物资名称");
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
	case "new_div":
		space=340;
		break;
	case "new_div_table":
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
		<div class="page_location_div">综合查询-添加订单</div>
		
		<div id="new_div">
			<form id="form1" name="form1" method="post" action="" enctype="multipart/form-data">
			<table>
			  <tr>
				<td class="td1" align="right">
					预装卸重量
				</td>
				<td class="td2">
					<input type="number" class="yzxzl_inp" id="yzxzl" name="yzxzl" placeholder="请输入预装卸重量" onfocus="focusYZXZL()" onblur="checkYZXZL()"/>
				</td>
				<td class="td1" align="right">
					流向类型
				</td>
				<td class="td2">
					<input id="lxlx_cbb"/>
					<input type="hidden" id="lxlx" name="lxlx"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					实际重量
				</td>
				<td class="td2">
					<input type="number" class="sjzl_inp" id="sjzl" name="sjzl" placeholder="请输入实际重量"/>
				</td>
				<td class="td1" align="right">
					计划运输日期
				</td>
				<td class="td2">
					<input id="jhysrq_db"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					备注
				</td>
				<td class="td2">
					<textarea rows="3" cols="30" id="bz" name="bz" placeholder="请输入备注"></textarea>
				</td>
				<td class="td1" align="right">
					结算重量
				</td>
				<td class="td2">
					<input type="number" class="jszl_inp" id="jszl" name="jszl" placeholder="请输入结算重量"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					包数
				</td>
				<td class="td2">
					<input type="text" class="bs_inp" id="bs" name="bs" placeholder="请输入包数" />
				</td>
				<td class="td1" align="right">
					块数
				</td>
				<td class="td2">
					<input type="text" class="ks_inp" id="ks" name="ks" placeholder="请输入包数" />
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					对方过磅净重
				</td>
				<td class="td2">
					<input type="number" class="dfgbjz_inp" id="dfgbjz" name="dfgbjz" placeholder="请输入对方过磅净重" />
				</td>
				<td class="td1" align="right">
					对方过磅皮重
				</td>
				<td class="td2">
					<input type="number" class="dfgbpz_inp" id="dfgbpz" name="dfgbpz" placeholder="请输入对方过磅皮重" />
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					对方过磅毛重
				</td>
				<td class="td2">
					<input type="number" class="dfgbmz_inp" id="dfgbmz" name="dfgbmz" placeholder="请输入对方过磅毛重" />
				</td>
				<td class="td1" align="right">
					对方榜单照片
				</td>
				<td class="td2">
					<div class="uploadBut_div upDfbdzpBut_div" onclick="uploadDfbdzp()">选择对方榜单照片</div>
					<input type="file" class="dfbdzp_file" id="dfbdzp_file" name="dfbdzp_file" onchange="showDfbdzp(this)"/>
					<img class="dfbdzp_img" id="dfbdzp_img" alt="" src=""/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					对方过磅时间
				</td>
				<td class="td2">
					<input id="dfgbsj_dtb"/>
				</td>
				<td class="td1" align="right">
					运输商
				</td>
				<td class="td2">
					<input id="yss_cbb"/>
					<input type="hidden" id="yssId" name="yssId"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					物资类型
				</td>
				<td class="td2">
					<input id="wzlx_cbb"/>
					<input type="hidden" id="wzlxId" name="wzlxId"/>
				</td>
				<td class="td1" align="right">
					物资名称
				</td>
				<td class="td2">
					<input id="wz_cbb"/>
					<input type="hidden" id="wzId" name="wzId"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					发货单位
				</td>
				<td class="td2">
					<input id="fhdw_cbb"/>
					<input type="hidden" id="fhdwId" name="fhdwId"/>
				</td>
				<td class="td1" align="right">
					收货单位
				</td>
				<td class="td2">
					<input id="shdw_cbb"/>
					<input type="hidden" id="shdwId" name="shdwId"/>
				</td>
			  </tr>
			  <tr>
				<td class="td1" align="right">
					承运车辆
				</td>
				<td class="td2">
					<input id="cycl_cbb"/>
					<input type="hidden" id="cyclId" name="cyclId"/>
					<input type="hidden" id="cyclCph" name="cyclCph"/>
				</td>
				<td class="td1" align="right">
					承运司机
				</td>
				<td class="td2">
					<input id="cysj_cbb"/>
					<input type="hidden" id="cysjId" name="cysjId"/>
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