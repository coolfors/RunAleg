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
<link rel="stylesheet" href="admin/lib/layui/css/layui.css" media="all">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/user.js"></script>
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
				</span> <span class="col-sm-4 col-xs-5" style="float: right">
				 <c:if test="${sessionScope.User==null }">
						<a href="login.html" target="_blank" id="login">登录</a>&nbsp; <a
						href="register.html" target="_blank" id="reg">注册</a>
					</c:if>
					<c:if test="${sessionScope.User!=null }">
						<ul class="right navbar-nav">
							<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown">
								${sessionScope.User.userName}
								<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="userMessage.jsp">个人信息</a></li>
									<li><a href="pay.jsp">余额充值</a></li>								
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
					<li><a href="index.jsp">首页</a></li>
					<li class="active"><a href="#">跑腿吧<span class="sr-only"></span></a></li>
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
		<a href="" target="_blank"><img src="images/ggt_03.png"
			class="img-responsive" style="width: 100%; height: auto;"></a>
	</div>
	<div class="container">
		<!--货源信息-->
		<h3 id="headName">所有订单</h3>
		<script type="text/javascript">
			$(function () {
				$("#headName").html("jjjj");
			})
		</script>
		<table class="table table-bordered">
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
		<div id="test1" class="text-center"></div>
		<script src="admin/lib/layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
		<script>
			layui.use([ 'laypage', 'layer' ], function() {
				var laypage = layui.laypage, layer = layui.layer;
				//完整功能
				laypage.render({
					elem : 'test1',
					count : 20,
					layout : [ 'count', 'prev', 'page', 'next', 'limit',
							'refresh', 'skip' ],
					jump : function(obj, first) { //跳转
						if (!first) {
							location.href = "#";
						}
					}
				});
			});
		</script>
	</div>
	<div class="container">
		<!--货源地图-->

	</div>
	<!--<hr class="featurette-divider">	-->
	<div class="container">
		<!--司机读本、行内互动-->
		<div class="row" style="margin: 0;">
			<div class="col-sm-5" style="border: 1px solid #ccc;">
				<div class="row reader">
					<h3 class="driver">
						<img src="images/reader driver.png"> <span> 当前订单</span>
					</h3>
					<div class="col-md-3 col-xs-6">
						<a id="waitSendDispatch"> <img src="images/tubiao_03.png" class="img-circle">
							<p>待配送订单</p>
						</a>
					</div>
					<div class="col-md-3 col-xs-6">
						<a href=""> <img src="images/tubiao_09.png" class="img-circle">
						<p>配送中订单</p>
						</a>
					</div>
					<div class="col-md-3 col-xs-6">
						<a id="allDispatch"><img src="images/trucks.png" class="img-circle">
						<p>所有订单</p></a>
					</div>
					<div class="col-md-3 col-xs-6">
						<a href="freight-info.jsp"><img src="images/06.png" class="img-circle">
						<p>下单</p></a>
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
							<p>待评价订单</p>
						</a>
					</div>
					<div class="col-md-4 col-xs-6">
						<a href=""> <img src="images/ttubiao_10.png"
							class="img-circle">
							<p>已完成订单</p>
						</a>
					</div>
					<div class="col-md-4 col-xs-6">
						<a href=""> <img src="images/ttubiao_12.png"
							class="img-circle">
							<p>加入跑男</p>
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