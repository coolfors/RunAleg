<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/logo.ico">
<title>快递侠-首页</title>
<meta name="description"
	content="快递侠实现了跑腿代跑和威客任务的实时连接，通过互联网服务于跑男和兼职群体。坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！">
<meta name="keywords" content="物流,跑腿,跑男,快递侠">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="layui/css/layui.css" media="all">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/layer.js"></script>
<!-- <script src="js/getUserName.js" type="text/javascript"></script> -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=oMN1mtyewGGM1EIbHzDmHk0nR1sxU2WA"></script>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="js/Courier.js"></script>
</head>
<body>
	<div id="allmap" hidden="hidden"></div>
	<input id="targetAdd" name="targetAdd" hidden="hidden" value="" />
	<input id="lng" name="lng" hidden="hidden" value="" />
	<input id="lat" name="lat" hidden="hidden" value="" />
	<div id="container" hidden="hidden"></div>
	<input id="CourierPoint" name="CourierPoint" hidden="hidden"
		value="${sessionScope.Courier.address}" />
	<input id="CourierId" name="CourierId" hidden="hidden"
		value="${sessionScope.Courier.courierId}" />
	<!--顶部-开始-->
	<div
		style="background: #EBEBEB; width: 100%; height: 80px; line-height: 80px;">
		<div class="container">
			<div class="row">
				<span class="col-sm-7 col-sm-offset-1 col-xs-6 col-xs-offset-1"><img
					src="images/logo.png" class="img-responsive" alt="新广货运联盟"></span> <span
					class="col-sm-4 col-xs-5" style="float: right"> <a
					href="modify data.html" target="_blank" style="display: none">su23c0e</a>
					<a href="" style="display: none">退出</a>
				</span> <span id="showUserName" class="col-sm-4 col-xs-5"> <c:if
						test="${sessionScope.User==null }">
						<a href="login.html" target="" id="login">登录</a>&nbsp; <a
							href="register.html" target="" id="reg">注册</a>
					</c:if> <c:if test="${sessionScope.User!=null }">
						<%-- <a href="" target="_blank" id="UserInfo">${sessionScope.User.userName}</a> --%>

						<ul class="right navbar-nav">
							<li class="dropdown"><a href="" class="dropdown-toggle"
								data-toggle="dropdown"> ${sessionScope.User.userName} <b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="userMessage.jsp">个人信息</a></li>
									<li><a href="pay.jsp">余额充值</a></li>
									<li><a href="LoginServlet.do?op=exchange">退出账号</a></li>
								</ul></li>
						</ul>
					</c:if>
				</span>
			</div>
		</div>
	</div>
	<!--顶部-结束-->

	<!--导航-开始-->
	<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">首页</a></li>
				<c:if test="${sessionScope.User==null}">
					<li><a href="login.html">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==1}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if
					test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==1}">
					<li><a href="courier-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if
					test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==0}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">发布跑腿<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="freight-info.jsp">信息发布</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">帮助<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="heplist.jsp">如何下单</a></li>
					</ul></li>
				<li><a href="alliance.jsp">关于我们</a></li>
				<li><a href="contact-us.jsp">联系我们</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<!--导航-结束-->

	<!--内容-开始-->
	<!--货源信息-->
	<div class="container">
		<!--广告-->
		<a href="#" target=""><img src="images/ggt_03.png"
			class="img-responsive" style="width: 100%; height: auto;"></a>
	</div>
	<div class="container">
		<!--货源信息-->
		<h3 id="headName"></h3>
		<div class="table-responsive">
		<table class="table">
			<thead>
				<!-- <tr>

					<th>派单id</th>
					<th>用户id</th>
					<th>起送地</th>
					<th>到达地</th>
					<th>用户联系电话</th>
					<th>配送价格</th>
					<th>物品类型</th>
					<th>物品介绍</th>
					<th>派单状态</th>
				</tr> -->
			</thead>
			<tbody>
				<!-- <tr>
					<td>1</td>
					<td>1</td>
					<td>厦门中软海晟1楼</td>
					<td>厦门中软海晟2楼</td>
					<td>13011111111</td>
					<td>12</td>
					<td>花瓶</td>
					<td>一个大花瓶</td>
					<td class="see"><a href="">抢单</a></td>
				</tr> -->
			</tbody>
		</table>
		</div>
		<div id="test1" class="text-center"></div>
		<script src="layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script id="layuiJs">
			
		</script>
	</div>
	<input type="hidden" id="CourierId" name="CourierId"
		value="${sessionScope.Courier.courierId}" />
	<!-- <div class="container">
		货源地图
		<h3>送单详情</h3>

	</div> -->
	<!--<hr class="featurette-divider">	-->
	<div class="container">
		<!--司机读本、行内互动-->
		<div class="row" style="margin: 0;">
			<div class="col-sm-5" style="border: 1px solid #ccc;">
				<div class="row reader">
					<h3 class="driver">
						<img src="images/reader driver.png"> <span> 订单详情</span>
					</h3>
					<div class="col-md-3 col-xs-6">
						<a id="waitSendReceipt"> <img src="images/tubiao_03.png"
							class="img-circle">
							<p>待送订单</p>
						</a>
					</div>
					<div class="col-md-3 col-xs-6">
						<a id="sendReceipt"> <img src="images/tubiao_09.png"
							class="img-circle">
							<p>配送中订单</p>
						</a>
					</div>
					<div class="col-md-3 col-xs-6">
						<a id="allDispatch"><img src="images/trucks.png"
							class="img-circle">
							<p>所有订单</p></a>
					</div>
					<div class="col-md-3 col-xs-6">
						<a href="user-order-main.jsp"><img src="images/06.png"
							class="img-circle">
							<p>我的派单</p></a>
					</div>
				</div>
			</div>
			<div class="col-sm-5 col-sm-offset-2" style="border: 1px solid #ccc;">
				<div class="row line">
					<h3 class="driver" style="background: #FA8686;">
						<img src="images/line interaction.png"> <span> 历史订单</span>
					</h3>
					<div class="col-md-4 col-xs-6">
						<a id="waitEvaluate"> <img src="images/ttubiao_08.png"
							class="img-circle">
							<p>待评订单</p>
						</a>
					</div>
					<div class="col-md-4 col-xs-6">
						<a id="overEvaluate"> <img src="images/ttubiao_10.png"
							class="img-circle">
							<p>已评订单</p>
						</a>
					</div>
					<div class="col-md-4 col-xs-6">
						<a href="freight-info.jsp"> <img src="images/ttubiao_12.png"
							class="img-circle">
							<p>我想派单</p>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--内容-结束-->
	<div class="container">
		<!--广告-->
	</div>

	<!--尾部-开始-->
	<!-- 地图显示模态窗 -->
	<div class="footer"
		style="background: #525252; width: 100%; padding-bottom: 20px; margin-top: 30px;">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<p>友情链接</p>
					<hr>
					<ul>
						<li><a href="" target="_blank">中国物流网</a></li>
						<li><a href="" target="_blank">中国物流网</a></li>
						<li><a href="" target="_blank">中国物流网</a></li>
					</ul>
				</div>
				<div class="col-sm-4">
					<p>快递侠</p>
					<hr>
					<p>快递侠成立于2018年，是一家专业提供跑腿业务的平台。</p>
					<p>快递侠的跑腿业务提供一个平台给任何普通用户以及需要兼职的用户群体。</p>
					<p>快递侠坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！</p>
				</div>
				<div class="col-sm-4">
					<p>
						<a href="register.html">加入跑男</a> | <a href="contact-us.jsp">联系我们</a>
					</p>
					<hr>
					<p>咨询电话：13015962382</p>
					<p>邮箱：coolfors@163.com</p>
					<p>地址：厦门市软件园</p>
				</div>
				<div class="col-sm-12 text-center" style="margin-top: 20px;">
					Copyright © 快递侠 版权所有 Power by 快递侠</div>
			</div>
		</div>
	</div>
	<style type="text/css">
#l-maps {
	height: 300px;
	width: 100%;
}

#r-result, #r-result table {
	width: 100%;
}
</style>
	<!-- 模态窗 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">查看位置</h4>
				</div>
				<div class="modal-body" id="maps">
					<div id="l-maps"></div>
					<div id="r-result"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!--尾部-结束-->
	<c:if
		test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==1}">
		<script src="js/GPS_GetLng&LatByBrow.js"></script>
	</c:if>

</body>
</html>