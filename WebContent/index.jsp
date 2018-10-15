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
<link rel="stylesheet" href="css/layui.css" media="all">
<!--js -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
<![endif]-->
</head>
<body>
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
				</span> <span id="showUserName" class="col-sm-4 col-xs-5"
					style="float: right"> <c:if
						test="${sessionScope.User==null }">
						<a href="login.html" target="_blank" id="login">登录</a>&nbsp; <a
							href="register.html" target="_blank" id="reg">注册</a>
					</c:if> <c:if test="${sessionScope.User!=null }">
						<%-- <a href="" target="_blank" id="UserInfo">${sessionScope.User.userName}</a> --%>

						<ul class="right navbar-nav">
							<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown">
								${sessionScope.User.userName}
								<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="userMessage.jsp">个人信息</a></li>
									<li><a href="#">余额充值</a></li>								
									<li><a href="login.html">切换账号</a></li>
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
				<li class="active"><a href="index.jsp">首页</a></li>
				<!-- <li><a href="#">跑腿吧<span class="sr-only"></span></a></li> -->
				<c:if test="${sessionScope.User==null}">
					<li><a href="login.html">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==1}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==2}">
					<li><a href="courier-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
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
						<li><a href="driving-knowledge.jsp">如何下单</a></li>
					</ul></li>
				<li><a href="alliance.jsp">关于我们</a></li>
				<li><a href="contact-us.jsp">联系我们</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!--导航-结束-->
	<!-- 中间内容开始 -->
	<!-- 中间内容的css 开始-->
	<style type="text/css">
.btn01 {
	position: absolute;
	top: 400px;
	right: 200px;
	height: 35px;
	width: 90px;
	background-color: cornflowerblue;
}

.img01 {
	position: relative;
	top: 50px;
	left: 240px;
	width: 150px;
	float: left;
}
</style>
	<!-- 中间的部分 css 结束-->
	<div class="row-fluid">
		<div class="span12">
			<div class="carousel slide" id="carousel-564098">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-564098"></li>
					<li data-slide-to="1" data-target="#carousel-564098" class="active"></li>
					<li data-slide-to="2" data-target="#carousel-564098"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<a href="" target="_blank"><img alt="" src="images/center.jpg" /></a>
						<div class="carousel-caption">
							<h4>一键下单</h4>
							<p>做快递我们是专业的</p>
						</div>
					</div>
					<div class="item active">
						<img alt="" src="images/center.jpg" />
						<div class="carousel-caption">
							<h4>跑腿1</h4>
							<p>
								冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="images/center.jpg" />
						<div class="carousel-caption">
							<h4>自行车</h4>
							<p>
								以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。</p>
						</div>
					</div>
				</div>
				<a data-slide="prev" href="#carousel-564098"
					class="left carousel-control">‹</a> <a data-slide="next"
					href="#carousel-564098" class="right carousel-control">›</a>
			</div>
		</div>
	</div>

	
	<!--内容-结束-->
	<div class="row">
		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4  ">
			<img src="images/first_tip.png " class=" center-block" />

		</div>
		<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 center-block ">
			<img src="images/middle_tip.png" class=" center-block" />
		</div>
		<div class=" col-xs-12 col-sm-4 col-md-4 col-lg-4 center-block ">
			<img src="images/last_tip.png" class=" center-block" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 center-block">
			<h3>随叫随到</h3>
			<p>随时下单，无论何时何地，闪送24小时随叫随到，竭诚为您服务。</p>

		</div>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 center-block">
			<h3>专人送达，安全无忧</h3>
			<p>专人即取即送，无中转环节，直达目的地，全程实时监控，先行赔付保障，贴心又安心。。</p>
		</div>
		<div class=" col-xs-4 col-sm-4 col-md-4 col-lg-4 center-block ">
			<h3>闪电速度</h3>
			<p>下单后，将在最短时间内为您服务到位，无需再担心时效问题。</p>
		</div>
	</div>





	<!--尾部-开始-->
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
	<!--尾部-结束-->
</body>
</html>