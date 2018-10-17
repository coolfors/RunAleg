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
<title>快递侠-个人信息</title>
<meta name="description"
	content="快递侠实现了跑腿代跑和威客任务的实时连接，通过互联网服务于跑男和兼职群体。坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！">
<meta name="keywords" content="物流,跑腿,跑男,快递侠">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/thems.css" />
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
					src="images/logo.png" class="img-responsive" alt="快递侠"></span> <span
					class="col-sm-4 col-xs-5" style="float: right"> <a
					href="modify data.html" target="_blank" style="display: none">su23c0e</a>
					<a href="" style="display: none">退出</a>
				</span> <span class="col-sm-4 col-xs-5" style="float: right"> <c:if
						test="${sessionScope.User==null }">
						<a href="login.html" target="_blank" id="login">登录</a>&nbsp; <a
							href="register.html" target="_blank" id="reg">注册</a>
					</c:if> <c:if test="${sessionScope.User!=null }">
						<ul class="right navbar-nav">
							<li class="dropdown"><a href="" class="dropdown-toggle"
								data-toggle="dropdown"> ${sessionScope.User.userName} <b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="userMessage.jsp">个人信息</a></li>
									<li><a href="#">余额充值</a></li>
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
				<li><a href="index.jsp">跑腿吧<span class="sr-only"></span></a></li>
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
				<li class=""><a href="contact-us.jsp">联系我们</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!--导航-结束-->
	<!--内容开始  -->
	<!--中间部分-->
	<div class="main">
		<!--订单中心-->
		<div class="person clearfix">
			<div class="order_l person_l">
				<ul id="left_menu" class="left_menu">
					<li><a class="yiji"><span>个人中心</span><em>&nbsp;</em></a>
						<ul class="erji">
							<li><i>&nbsp;</i> <strong><a href="">个人资料</a></strong></li>
						</ul></li>
					<li><a class="yiji"><span>订单中心</span><em>&nbsp;</em></a>
						<ul class="erji">
							<li><i>&nbsp;</i> <strong><a href="">我的订单</a></strong></li>
							<li><i>&nbsp;</i> <strong><a href="">我的账单</a></strong></li>
							<li><i>&nbsp;</i> <strong><a href="">常发货物</a></strong></li>
							<li><i>&nbsp;</i> <strong><a href="">常用联系人</a></strong></li>
						</ul></li>
				</ul>
			</div>
			<div class="person_r">
				<div class="person_h">
					<span>个人资料设置</span>
				</div>
				<div class="person_rmain">
					<c:if test="${sessionScope.User.userType == 0}">
						<strong>帐户信息</strong>
						<ul>
							<li><span>登陆帐户：</span> <em>${sessionScope.User.userName}</em>
							</li>
							<li><span>账户类型：</span> <em>${sessionScope.User.userType == 0 ? "管理员":(sessionScope.User.userType == 1 ? "普通用户":"跑腿用户")}</em>
							</li>
						</ul>
						<strong>基本信息</strong>
						<!-- 管理员信息显示修改 -->
						<form action="" method="post">
						
							<ul>
								<li><span>用户ID:</span> <em>${sessionScope.User.userId}</em>
								</li>
								<li><span>性别：</span> <select name="mgrsex" id="mgrsex">
										<option value="">${sessionScope.Userinfo.userSex}</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select></li>
								<li><span>手机：</span> <input name="mgrTel" type="text" placeholder="${sessionScope.Userinfo.userTel}">
								</li>
								<li><span>地址：</span> <input name="mgrAdd" type="text" placeholder="${sessionScope.Userinfo.userTel}">
								</li>
								<li>
									<button class="submit">保存</button>
								</li>
							</ul>
						</form>
					</c:if>
					<c:if test="${sessionScope.User.userType == 1}">
						<strong>帐户信息</strong>
						<ul>
							<li><span>登陆帐户：</span> <em>${sessionScope.User.userName}</em>
							</li>
							<li><span>账户类型：</span> <em>${sessionScope.User.userType == 0 ? "管理员":(sessionScope.User.userType == 1 ? "普通用户":"跑腿用户")}</em>
								&nbsp;&nbsp;&nbsp;
								<button class="btn btn-success btn-xs" data-toggle="modal"
									data-target="#myModal">成为快递侠</button></li>
							<li><span>账户余额：</span> <em>${sessionScope.Userinfo.userBalance}</em></li>
						</ul>
						<strong>基本信息</strong>
						<!-- 普通用户信息显示修改 -->
						<form action="UserInfoServlet?op=userinfoEdit" method="post">
							<input type="hidden" name="userInfoId" value="${sessionScope.User.userId}"/>
							<ul>
								<li><span>用户ID:</span> <em>${sessionScope.User.userId}</em>
								</li>
								<li><span>性别：</span> <select name="sexInfo" id="sex">
										<option value="">${sessionScope.Userinfo.userSex}</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select></li>
								<li><span>手机：</span> <input name="userTelInfo" type="text"
									value="${sessionScope.Userinfo.userTel}"></li>
								<li><span>常用地址：</span> <input name="userAddInfo" type="text"
									value="${sessionScope.Userinfo.userAdd}"></li>
								<li>
									<button class="submit">修改</button>
								</li>
							</ul>
						</form>
					</c:if>
					<!-- 跑腿用户信息显示修改 -->
					<c:if test="${sessionScope.User.userType == 2}">
						<strong>帐户信息</strong>
						<ul>
							<li><span>登陆帐户：</span> <em>${sessionScope.User.userName}</em>
							</li>
							<li><span>账户类型：</span> <em>${sessionScope.User.userType == 0 ? "管理员":(sessionScope.User.userType == 1 ? "普通用户":"跑腿用户")}</em>
							</li>
							<li><span>账户押金：</span> <em>${sessionScope.Courier.deposit}</em></li>
							<li><span>账户余额：</span> <em>${sessionScope.Courier.balance}</em></li>
						</ul>
						<!-- 跑腿用户信息显示修改 -->
						<strong>基本信息</strong>
						<form action="CourierServlet.do?op=updateCourierMessage" method="get">
							<input type="hidden" name="courierId" value="${sessionScope.User.userId}"/>
							<ul>
								<li><span>用户ID:</span> <em>${sessionScope.User.userId}</em>
								</li>
								<li><span>性别：</span> <select name="couriersex" id="sex">
										<option value="">${sessionScope.Userinfo.userSex}</option>
										<option value="男">男</option>
										<option value=女">女</option>
								</select></li>
								<li><span>身份证：</span> <em>${sessionScope.Courier.IDcard}</em></li>
								<li><span>手机：</span> <input name="courierTel" type="text"
									placeholder="${sessionScope.Courier.tel}"></li>
								<li><span>地址：</span> <input name="courierAdd" type="text"
									placeholder="${sessionScope.Courier.address}"></li>
								<li><span>配送范围：</span> <input name="ableDistance"
									type="text" placeholder="${sessionScope.Courier.ableDistance}">
								</li>
								<li><span>信用分：</span><em>${sessionScope.Courier.creditPoint}</em>
								</li>
								<li>
									<button class="submit">保存</button>
								</li>
							</ul>
						</form>
					</c:if>
				</div>
			</div>
		</div>
		<!--订单中心-->
		<div class="space_hx">&nbsp;</div>
	</div>
	<!--中间部分结束-->
	<!-- 模态框（Modal） -->
	<!-- 修改 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="form_data" method="post" action="us.do">
					<div class="modal-body">
						<input type="hidden" name="op" value="update" /> <input
							type="hidden" name="userId" id="userId" />
						<div class="form-group">
							<label for="">真实姓名(之后的用户名):</label><input class="form-control"
								type="text" name="realName" id="realName">
						</div>
						<div class="form-group">
							<label for="">性别:</label> <select id="realSex" name="realSex"
								class="form-control">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
						<div class="form-group">
							<label for="">手机号:</label> <input class="form-control"
								type="text" name="realTel" id="realTel">
						</div>
						<div class="form-group">
							<label for="">身份证:</label> <input class="form-control"
								type="text" name="realIDcard" id="realIDcard">
						</div>
						<div class="form-group ">
							<label for="">证件照:</label>
							<!--  <input class="form-control" type="file"
								name="realIDImg" id="realIDImg"> -->
							<input id="avatarSlect" type="file">
							<img id="avatarPreview" src="/static/images/sample.png" title="点击更换图片">

						</div>
						<div class="form-group">
							<label for="">地址:</label> <input class="form-control" type="text"
								name="realAddress" id="realAddress">
						</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button class="btn btn-primary" type="submit">保存</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
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
					<p>新广货运联盟</p>
					<hr>
					<p>新广货运联盟成立于2018年，是一家专业提供互联网物流信息的网站。</p>
					<p>新广货运联盟实现了车找货、货找车的实时连接，通过互联网服务于广大货运司机和相关货运的各界人士。</p>
					<p>新广货运联盟坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！</p>
				</div>
				<div class="col-sm-4">
					<p>
						<a href="contact-us.jsp">加盟我们</a> | <a href="contact-us.jsp">联系我们</a>
					</p>
					<hr>
					<p>咨询电话：13462264663</p>
					<p>邮箱：xinguanghuoyun@163.com</p>
					<p>地址：河南省新乡市八一路35号中同街办事处</p>
				</div>
				<div class="col-sm-12 text-center" style="margin-top: 20px;">
					Copyright © 新广货运联盟 版权所有 Power by www.xghylm.com 更多模板：<a
						href="http://www.mycodes.net/" target="_blank">源码之家</a>
				</div>
			</div>
		</div>
	</div>
	<!--尾部-结束-->
</body>
</html>