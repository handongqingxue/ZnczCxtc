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
}
.tab1_div .toolbar{
	height:32px;
}
.tab1_div .toolbar .mc_span{
	margin-left: 13px;
}
.tab1_div .toolbar .mc_inp{
	width: 120px;height: 25px;
}
.tab1_div .toolbar .search_but{
	margin-left: 13px;
}
.tab1_div .edit_a{
	visibility: hidden;
}
</style>
<title>Insert title here</title>
<%@include file="../../inc/js.jsp"%>
<script type="text/javascript">
var path='<%=basePath %>';
var xtglPath=path+'xtgl/';

var xzZt;
var zcsyZt;
var fqZt;
var ywZt;

var xzZtMc;
var zcsyZtMc;
var fqZtMc;
var ywZtMc;
$(function(){
	initZtVar();
	
	initSearchLB();
	initAddLB();
	initTab1();
	
	showCompontByQx();
});

function showCompontByQx(){
	addLB.hide();
	//removeLB.hide();
	if(yhm=="admin"){
		addLB.show();
		//removeLB.show();
	}
	else{
		var tjjsQx='${requestScope.tjjsQx}';
		var scjsQx='${requestScope.scjsQx}';
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==tjjsQx){
				addLB.show();
			}
			if(qxIdsArr[i]==scjsQx){
				//removeLB.show();
			}
		}
	}
}

function showOptionButByQx(){
	if(yhm=="admin"){
		$(".tab1_div .edit_a").css("visibility","visible");
	}
	else{
		var xgjsQx='${requestScope.xgjsQx}';
		var qxIdsArr=qxIds.split(",");
		for(var i=0;i<qxIdsArr.length;i++){
			if(qxIdsArr[i]==xgjsQx){
				$(".tab1_div .edit_a").css("visibility","visible");
			}
		}
	}
}

function initZtVar(){
	xzZt=parseInt('${requestScope.xzZt}');
	zcsyZt=parseInt('${requestScope.zcsyZt}');
	fqZt=parseInt('${requestScope.fqZt}');
	ywZt=parseInt('${requestScope.ywZt}');

	xzZtMc='${requestScope.xzZtMc}';
	zcsyZtMc='${requestScope.zcsyZtMc}';
	fqZtMc='${requestScope.fqZtMc}';
	ywZtMc='${requestScope.ywZtMc}';
}

function initSearchLB(){
	$("#search_but").linkbutton({
		iconCls:"icon-search",
		onClick:function(){
			var mc=$("#toolbar #mc").val();
			tab1.datagrid("load",{mc:mc});
		}
	});
}

function initAddLB(){
	addLB=$("#add_but").linkbutton({
		iconCls:"icon-add",
		onClick:function(){
			location.href=xtglPath+"jscx/new";
		}
	});
}

function initTab1(){
	tab1=$("#tab1").datagrid({
		title:"????????????-????????????-??????",
		url:xtglPath+"queryJueSeList",
		toolbar:"#toolbar",
		width:setFitWidthInParent("body"),
		pagination:true,
		pageSize:10,
		columns:[[
			{field:"mc",title:"??????",width:150},
			{field:"zt",title:"??????",width:100,formatter:function(value){
				return getZtMcById(value);
			}},
			{field:"ms",title:"??????",width:300},
            {field:"id",title:"??????",width:110,formatter:function(value,row){
            	var str="<a class=\"edit_a\" href=\"edit?id="+value+"\">??????</a>&nbsp;&nbsp;"
        			+"<a href=\"detail?id="+value+"\">??????</a>";
            	return str;
            }}
	    ]],
        onLoadSuccess:function(data){
			if(data.total==0){
				$(this).datagrid("appendRow",{mc:"<div style=\"text-align:center;\">????????????<div>"});
				$(this).datagrid("mergeCells",{index:0,field:"mc",colspan:4});
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

function getZtMcById(ztId){
	var str;
	switch (ztId) {
	case xzZt:
		str=xzZtMc;//??????
		break;
	case zcsyZt:
		str=zcsyZtMc;//????????????
		break;
	case fqZt:
		str=fqZtMc;//??????
		break;
	case ywZt:
		str=ywZtMc;//??????
		break;
	}
	return str;
}

function setFitWidthInParent(o){
	var width=$(o).css("width");
	return width.substring(0,width.length-2)-250;
}
</script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	<%@include file="../../inc/side.jsp"%>
	<div class="tab1_div" id="tab1_div">
		<div class="toolbar" id="toolbar">
			<span class="mc_span">?????????</span>
			<input type="text" class="mc_inp" id="mc" placeholder="???????????????"/>
			<a class="search_but" id="search_but">??????</a>
			<a id="add_but">??????</a>
		</div>
		<table id="tab1">
		</table>
	</div>
	<%@include file="../../inc/foot.jsp"%>
</div>
</body>
</html>