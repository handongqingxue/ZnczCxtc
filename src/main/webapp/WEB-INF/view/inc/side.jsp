<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>边框导航栏</title>
<style type="text/css">
.layui-layout-admin{
	padding: 1px;
}
.header_div{
	position: fixed;
}
.side {
	position: fixed;
	top: 50px;
	bottom: 0;
	height: 100%;
	justify-content: center;
	display: flex;
}

.head {
	align-items: center;
	position: relative;
	height: 50px;
	background-color: #20A0FF !important;
}

.headTitle, .headTitle>h1 {
	padding-left: 15px;
	margin: 0px auto;
}
.layui-nav .layui-nav-item a{
	color:#000;
}
.layui-nav .layui-nav-item .pointer-img{
	margin-top: 18px;
	margin-left: 18px;
	position: absolute;
}
.layui-nav .level-ul{
	height: 800px;
	margin-right: 10px;
	overflow-y:scroll;
}
.layui-nav .first-level-div{
	width: 92%; 
	margin: 20px auto 0; 
	border: #CAD9EA solid 1px;
	background-color: #F5FAFE;
}
.layui-nav .first-level{
    font-size: 15px;
	font-weight: bold;
	background-color: #E7F4FD;
}
.layui-nav,.layui-side{
	background-color: #FAFDFE;
}
.layui-side{
	border-right:#86B9D6 solid 1px;
}
.layui-layout-admin .layui-header{
	width:100%;
	background-color:  #E7F4FD;
}
.line_div{
	width:100%;
	height: 1px;
	background-color: #CAD9EA;
}
.bgLogo_img{
	width: 101px;
	height: 57px;
}

.ddgl_first_div,
.ddgl_first_div .ddzt_item_li,
.ddgl_first_div .dsh_item_li,
.ddgl_first_div .dzj_item_li,
.ddgl_first_div .drk_item_li,
.ddgl_first_div .zhcx_item_li,
.ddgl_first_div .shjl_item_li,
.gbgl_first_div,
.gbgl_first_div .bdjl_item_li,
.gbgl_first_div .gbjl_item_li,
.gbgl_first_div .yjdsh_item_li,
.gbgl_first_div .ejdsh_item_li,
.wzgl_first_div,
.wzgl_first_div .wzlx_item_li,
.wzgl_first_div .wzcx_item_li,
.dwgl_first_div,
.dwgl_first_div .yss_item_li,
.dwgl_first_div .fhdw_item_li,
.dwgl_first_div .shdw_item_li,
.dwgl_first_div .ck_item_li,
.clgl_first_div,
.clgl_first_div .dsh_item_li,
.clgl_first_div .zhcx_item_li,
.clgl_first_div .shjl_item_li,
.clgl_first_div .tzcx_item_li,
.clgl_first_div .cntz_item_li,
.sjgl_first_div,
.sjgl_first_div .dsh_item_li,
.sjgl_first_div .zhcx_item_li,
.sjgl_first_div .shjl_item_li,
.pdgl_first_div,
.pdgl_first_div .hmzt_item_li,
.pdgl_first_div .hmcx_item_li,
.pdgl_first_div .dlcx_item_li,
.xtgl_first_div .yhcx_item_li,
.xtgl_first_div .dshyh_item_li,
.xtgl_first_div .yhshjl_item_li,
.xtgl_first_div .jscx_item_li,
.xtgl_first_div .qxcx_item_li{
	display:none;
}
</style>
<script type="text/javascript">
var yhm='${sessionScope.yongHu.yhm}';
var qxIds='${sessionScope.yongHu.qxIds}';
$(function(){
	showLeftMenuByQx();
});

function showLeftMenuByQx(){
	/*
	$(".ddgl_first_div").css("display","none");
	$(".ddzt_item_li").css("display","none");
	$(".dsh_item_li").css("display","none");
	$(".dzj_item_li").css("display","none");
	$(".drk_item_li").css("display","none");
	$(".ddgl_first_div .zhcx_item_li").css("display","none");
	$(".ddgl_first_div .shjl_item_li").css("display","none");

	$(".gbgl_first_div").css("display","none");
	$(".bdjl_item_li").css("display","none");
	$(".gbjl_item_li").css("display","none");
	$(".yjdsh_item_li").css("display","none");
	$(".ejdsh_item_li").css("display","none");
	
	$(".wzgl_first_div").css("display","none");
	$(".wzlx_item_li").css("display","none");
	$(".wzcx_item_li").css("display","none");
	
	$(".dwgl_first_div").css("display","none");
	$(".yss_item_li").css("display","none");
	$(".fhdw_item_li").css("display","none");
	$(".shdw_item_li").css("display","none");
	$(".ck_item_li").css("display","none");

	$(".clgl_first_div").css("display","none");
	$(".clgl_first_div .dsh_item_li").css("display","none");
	$(".clgl_first_div .zhcx_item_li").css("display","none");
	$(".clgl_first_div .shjl_item_li").css("display","none");
	$(".tzcx_item_li").css("display","none");
	$(".cntz_item_li").css("display","none");

	$(".sjgl_first_div").css("display","none");
	$(".sjgl_first_div .dsh_item_li").css("display","none");
	$(".sjgl_first_div .zhcx_item_li").css("display","none");
	$(".sjgl_first_div .shjl_item_li").css("display","none");

	$(".pdgl_first_div").css("display","none");
	$(".pdgl_first_div .hmzt_item_li").css("display","none");
	$(".pdgl_first_div .hmcx_item_li").css("display","none");
	$(".pdgl_first_div .dlcx_item_li").css("display","none");

	$(".xtgl_first_div").css("display","none");
	$(".xtgl_first_div .yhxx_item_li").css("display","none");
	$(".xtgl_first_div .yhcx_item_li").css("display","none");
	$(".xtgl_first_div .dshyh_item_li").css("display","none");
	$(".xtgl_first_div .yhshjl_item_li").css("display","none");
	$(".xtgl_first_div .jscx_item_li").css("display","none");
	$(".xtgl_first_div .qxcx_item_li").css("display","none");
	*/
	
	if(yhm=="admin"){
		$(".ddgl_first_div").css("display","block");
		$(".ddzt_item_li").css("display","block");
		$(".dsh_item_li").css("display","block");
		$(".dzj_item_li").css("display","block");
		$(".drk_item_li").css("display","block");
		$(".ddgl_first_div .zhcx_item_li").css("display","block");
		$(".ddgl_first_div .shjl_item_li").css("display","block");

		$(".gbgl_first_div").css("display","block");
		$(".bdjl_item_li").css("display","block");
		$(".gbjl_item_li").css("display","block");
		$(".yjdsh_item_li").css("display","block");
		$(".ejdsh_item_li").css("display","block");

		$(".wzgl_first_div").css("display","block");
		$(".wzlx_item_li").css("display","block");
		$(".wzcx_item_li").css("display","block");
		
		$(".dwgl_first_div").css("display","block");
		$(".yss_item_li").css("display","block");
		$(".fhdw_item_li").css("display","block");
		$(".shdw_item_li").css("display","block");
		$(".ck_item_li").css("display","block");

		$(".clgl_first_div").css("display","block");
		$(".clgl_first_div .dsh_item_li").css("display","block");
		$(".clgl_first_div .zhcx_item_li").css("display","block");
		$(".clgl_first_div .shjl_item_li").css("display","block");
		$(".tzcx_item_li").css("display","block");
		$(".cntz_item_li").css("display","block");

		$(".sjgl_first_div").css("display","block");
		$(".sjgl_first_div .dsh_item_li").css("display","block");
		$(".sjgl_first_div .zhcx_item_li").css("display","block");
		$(".sjgl_first_div .shjl_item_li").css("display","block");

		$(".pdgl_first_div").css("display","block");
		$(".pdgl_first_div .hmzt_item_li").css("display","block");
		$(".pdgl_first_div .hmcx_item_li").css("display","block");
		$(".pdgl_first_div .dlcx_item_li").css("display","block");
		
		$(".xtgl_first_div").css("display","block");
		$(".xtgl_first_div .yhxx_item_li").css("display","block");
		$(".xtgl_first_div .yhcx_item_li").css("display","block");
		$(".xtgl_first_div .dshyh_item_li").css("display","block");
		$(".xtgl_first_div .yhshjl_item_li").css("display","block");
		$(".xtgl_first_div .jscx_item_li").css("display","block");
		$(".xtgl_first_div .qxcx_item_li").css("display","block");
	}
	else{
		var ddztcxQx='${requestScope.ddztcxQx}';
		var xdshQx='${requestScope.xdshQx}';
		var zjshQx='${requestScope.zjshQx}';
		var cxddQx='${requestScope.cxddQx}';
		var zxhshQx='${requestScope.zxhshQx}';
		var cxbdjlQx='${requestScope.cxbdjlQx}';
		var cxgbjlQx='${requestScope.cxgbjlQx}';
		var yjshQx='${requestScope.yjshQx}';
		var ejshQx='${requestScope.ejshQx}';
		var cxwzlxQx='${requestScope.cxwzlxQx}';
		var cxwzQx='${requestScope.cxwzQx}';
		var cxyssQx='${requestScope.cxyssQx}';
		var cxfhdwQx='${requestScope.cxfhdwQx}';
		var cxshdwQx='${requestScope.cxshdwQx}';
		var cxckQx='${requestScope.cxckQx}';
		var shclQx='${requestScope.shclQx}';
		var cxclQx='${requestScope.cxclQx}';
		var cxclshjlQx='${requestScope.cxclshjlQx}';
		var cxcltzQx='${requestScope.cxcltzQx}';
		var shsjQx='${requestScope.shsjQx}';
		var cxsjQx='${requestScope.cxsjQx}';
		var cxsjshjlQx='${requestScope.cxsjshjlQx}';
		var pdhmztcxQx='${requestScope.pdhmztcxQx}';
		var cxpdhmQx='${requestScope.cxpdhmQx}';
		var cxdlQx='${requestScope.cxdlQx}';
		var cxyhQx='${requestScope.cxyhQx}';
		var shyhQx='${requestScope.shyhQx}';
		var cxyhshjlQx='${requestScope.cxyhshjlQx}';
		var cxjsQx='${requestScope.cxjsQx}';
		var cxddshjlQx='${requestScope.cxddshjlQx}';
		//alert(qxIds)
		var qxIdArr=qxIds.split(",");
		for(var i=0;i<qxIdArr.length;i++){
			if(qxIdArr[i]==ddztcxQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .ddzt_item_li").css("display","block");

				$(".clgl_first_div").css("display","block");
				$(".mscl_item_li").css("display","block");
				$(".dsbcl_item_li").css("display","block");
				$(".ysbcl_item_li").css("display","block");
				$(".clgl_first_div .zhcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==xdshQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .dsh_item_li").css("display","block");
			}
			if(qxIdArr[i]==zjshQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .dzj_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxddQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .zhcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==zxhshQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .drk_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxddshjlQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .shjl_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxbdjlQx){
				$(".gbgl_first_div").css("display","block");
				$(".bdjl_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxgbjlQx){
				$(".gbgl_first_div").css("display","block");
				$(".gbjl_item_li").css("display","block");
			}
			if(qxIdArr[i]==yjshQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .shjl_item_li").css("display","block");
				
				$(".gbgl_first_div").css("display","block");
				$(".yjdsh_item_li").css("display","block");
			}
			if(qxIdArr[i]==ejshQx){
				$(".ddgl_first_div").css("display","block");
				$(".ddgl_first_div .shjl_item_li").css("display","block");
				
				$(".gbgl_first_div").css("display","block");
				$(".ejdsh_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxwzlxQx){
				$(".wzgl_first_div").css("display","block");
				$(".wzlx_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxwzQx){
				$(".wzgl_first_div").css("display","block");
				$(".wzcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxyssQx){
				$(".dwgl_first_div").css("display","block");
				$(".yss_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxfhdwQx){
				$(".dwgl_first_div").css("display","block");
				$(".fhdw_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxshdwQx){
				$(".dwgl_first_div").css("display","block");
				$(".shdw_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxckQx){
				$(".dwgl_first_div").css("display","block");
				$(".ck_item_li").css("display","block");
			}
			if(qxIdArr[i]==shclQx){
				$(".clgl_first_div").css("display","block");
				$(".clgl_first_div .dsh_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxclQx){
				$(".clgl_first_div").css("display","block");
				$(".clgl_first_div .zhcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxclshjlQx){
				$(".clgl_first_div").css("display","block");
				$(".clgl_first_div .shjl_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxcltzQx){
				$(".clgl_first_div").css("display","block");
				$(".clgl_first_div .tzcx_item_li").css("display","block");
				$(".clgl_first_div .cntz_item_li").css("display","block");
			}
			if(qxIdArr[i]==shsjQx){
				$(".sjgl_first_div").css("display","block");
				$(".sjgl_first_div .dsh_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxsjQx){
				$(".sjgl_first_div").css("display","block");
				$(".sjgl_first_div .zhcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxsjshjlQx){
				$(".sjgl_first_div").css("display","block");
				$(".sjgl_first_div .shjl_item_li").css("display","block");
			}
			if(qxIdArr[i]==pdhmztcxQx){
				$(".pdgl_first_div").css("display","block");
				$(".pdgl_first_div .hmzt_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxpdhmQx){
				$(".pdgl_first_div").css("display","block");
				$(".pdgl_first_div .hmcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxdlQx){
				$(".pdgl_first_div").css("display","block");
				$(".pdgl_first_div .dlcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxyhQx){
				$(".xtgl_first_div").css("display","block");
				$(".xtgl_first_div .yhcx_item_li").css("display","block");
			}
			if(qxIdArr[i]==shyhQx){
				$(".xtgl_first_div").css("display","block");
				$(".xtgl_first_div .dshyh_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxyhshjlQx){
				$(".xtgl_first_div").css("display","block");
				$(".xtgl_first_div .yhshjl_item_li").css("display","block");
			}
			if(qxIdArr[i]==cxjsQx){
				$(".xtgl_first_div").css("display","block");
				$(".xtgl_first_div .jscx_item_li").css("display","block");
			}
		}
	}
}
</script>
</head>
<body>
<div class="layui-header header_div">
		<div class="layui-logo">
			<img class="bgLogo_img" alt="" src="<%=basePath%>resource/image/bgLogo.jpg"/>
			<a>创新炭材称重平台</a>
		</div>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;"> 
					<!-- 
					<img src="${sessionScope.user.headImgUrl }" class="layui-nav-img">
					 -->
					${sessionScope.yongHu.yhm }
				</a>
			</li>
			<li class="layui-nav-item"><a href="<%=basePath%>main/exit">退出</a>
			</li>
		</ul>
	</div>

	<div class="layui-side ">
		<div class="layui-side-scroll">
			<ul class="layui-nav layui-nav-tree layui-inline level-ul" lay-filter="demo">
				<div class="first-level-div ddgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							订单管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item ddzt_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>ddgl/ddzt/list">
							&nbsp;&nbsp;&nbsp;订单状态
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item dsh_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>ddgl/dsh/list">
							&nbsp;&nbsp;&nbsp;待审核
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item dzj_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>ddgl/dzj/list">
							&nbsp;&nbsp;&nbsp;待质检
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item drk_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>ddgl/drk/list">
							&nbsp;&nbsp;&nbsp;待入库
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item zhcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>ddgl/zhcx/list">
							&nbsp;&nbsp;&nbsp;综合查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item shjl_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>ddgl/shjl/list">
							&nbsp;&nbsp;&nbsp;审核记录
						</a>
					</li>
				</div>
				<div class="first-level-div gbgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							过磅管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item bdjl_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>gbgl/bdjl/list">
							&nbsp;&nbsp;&nbsp;磅单记录
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item gbjl_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>gbgl/gbjl/list">
							&nbsp;&nbsp;&nbsp;过磅记录
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item yjdsh_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>gbgl/yjdsh/list">
							&nbsp;&nbsp;&nbsp;一检待审核
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item ejdsh_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>gbgl/ejdsh/list">
							&nbsp;&nbsp;&nbsp;二检待审核
						</a>
					</li>
				</div>
				<div class="first-level-div wzgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							物资管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item wzlx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>wzgl/wzlx/list">
							&nbsp;&nbsp;&nbsp;物资类型
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item wzcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>wzgl/wzcx/list">
							&nbsp;&nbsp;&nbsp;物资查询
						</a>
					</li>
				</div>
				<div class="first-level-div dwgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							单位管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item yss_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>dwgl/yss/list">
							&nbsp;&nbsp;&nbsp;运输商
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item fhdw_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>dwgl/fhdw/list">
							&nbsp;&nbsp;&nbsp;发货单位
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item shdw_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>dwgl/shdw/list">
							&nbsp;&nbsp;&nbsp;收货单位
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item ck_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>dwgl/ck/list">
							&nbsp;&nbsp;&nbsp;仓库
						</a>
					</li>
				</div>
				<div class="first-level-div clgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							车辆管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item dsh_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>clgl/dsh/list">
							&nbsp;&nbsp;&nbsp;待审核
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item zhcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>clgl/zhcx/list">
							&nbsp;&nbsp;&nbsp;综合查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item shjl_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>clgl/shjl/list">
							&nbsp;&nbsp;&nbsp;审核记录
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item tzcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>clgl/tzcx/list">
							&nbsp;&nbsp;&nbsp;台账查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item cntz_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>clgl/cntz/list">
							&nbsp;&nbsp;&nbsp;厂内台账
						</a>
					</li>
				</div>
				<div class="first-level-div sjgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							司机管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item dsh_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>sjgl/dsh/list">
							&nbsp;&nbsp;&nbsp;待审核
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item zhcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>sjgl/zhcx/list">
							&nbsp;&nbsp;&nbsp;综合查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item shjl_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>sjgl/shjl/list">
							&nbsp;&nbsp;&nbsp;审核记录
						</a>
					</li>
				</div>
				<div class="first-level-div pdgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							排队管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item hmzt_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>pdgl/hmzt/list">
							&nbsp;&nbsp;&nbsp;号码状态
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item hmcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>pdgl/hmcx/list">
							&nbsp;&nbsp;&nbsp;号码查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item dlcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>pdgl/dlcx/list">
							&nbsp;&nbsp;&nbsp;队列查询
						</a>
					</li>
				</div>
				<div class="first-level-div xtgl_first_div">
					<li class="layui-nav-item first-level">
						<a>
							系统管理
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item yhxx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>xtgl/yhxx">
							&nbsp;&nbsp;&nbsp;用户信息
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item yhcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>xtgl/yhcx/list">
							&nbsp;&nbsp;&nbsp;用户查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item dshyh_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>xtgl/dshyh/list">
							&nbsp;&nbsp;&nbsp;待审核用户
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item yhshjl_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>xtgl/yhshjl/list">
							&nbsp;&nbsp;&nbsp;用户审核记录
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item jscx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>xtgl/jscx/list">
							&nbsp;&nbsp;&nbsp;角色查询
						</a>
					</li>
					<div class="line_div"></div>
					<li class="layui-nav-item qxcx_item_li">
						<img class="pointer-img" alt="" src="<%=basePath%>resource/image/ico_3.gif" />
						<a href="<%=basePath%>xtgl/qxcx/list">
							&nbsp;&nbsp;&nbsp;权限查询
						</a>
					</li>
				</div>
			</ul>
		</div>
	</div>
</body>
</html>