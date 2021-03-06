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
<script src=js/layer.js></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var userId = $("#userInfoId").val();
				var userType = $("#userinfoType").val();
				$.get("AlipayService?userId=" + userId + "&userType="
						+ userType, function(data, statue) {
				});
			})
	$(document).ready(
			function() {
				var userId = $("#courierId").val();
				var userType = $("#courierType").val();
				$.get("AlipayService?userId=" + userId + "&userType="
						+ userType, function(data, statue) {
				});
			})
</script>
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=oMN1mtyewGGM1EIbHzDmHk0nR1sxU2WA"></script>
</head>
<body>
	<div id="allmap" hidden="hidden"></div>
	<input id="lng" name="lng" hidden="hidden" value="" />
	<input id="lat" name="lat" hidden="hidden" value="" />
	<input id="CourierId" name="CourierId" hidden="hidden"
		value="${sessionScope.Courier.courierId}" />
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
						<a href="login.html" target="" id="login">登录</a>&nbsp; <a
							href="register.html" target="" id="reg">注册</a>
					</c:if> <c:if test="${sessionScope.User!=null }">
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
					<li><strong><a id="modal-546969"
							href="#modal-container-546969" role="button" class="btn qupdate"
							data-toggle="modal" onclick="editPassword()">修改密码</a></strong></li>

					<!-- <li><a class="yiji"><span>订单中心</span><em>&nbsp;</em></a>
						<ul class="erji">
							<li><i>&nbsp;</i> <strong><a href="">我的订单</a></strong></li>
							<li><i>&nbsp;</i> <strong><a href="">我的账单</a></strong></li>
							<li><i>&nbsp;</i> <strong><a href="">常发货物</a></strong></li>
							<li><i>&nbsp;</i> <strong><a href="">常用联系人</a></strong></li>
						</ul></li> -->
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
								<li><span>手机：</span> <input name="mgrTel" type="text"
									placeholder="${sessionScope.Userinfo.userTel}"></li>
								<li><span>地址：</span> <input name="mgrAdd" type="text"
									placeholder="${sessionScope.Userinfo.userTel}"></li>
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
							<li><span>账户余额：</span> <em>${sessionScope.Userinfo.userBalance}</em>
								&nbsp;&nbsp;&nbsp;<a class="btn btn-success btn-xs"
								href="pay.jsp">点击充值</a></li>
						</ul>
						<strong>基本信息</strong>
						<!-- 普通用户信息显示修改 -->
						<form action="UserInfoServlet?op=userinfoEdit" method="post">
							<input type="hidden" id="userInfoId" name="userInfoId"
								value="${sessionScope.User.userId}" /> <input type="hidden"
								id="userinfoType" value="${sessionScope.User.userType}" />
							<ul>
								<li><span>用户ID:</span> <em>${sessionScope.User.userId}</em>
								</li>
								<li><span>性别：</span> <select name="sexInfo" id="sex">
										<option value="${sessionScope.Userinfo.userSex}">${sessionScope.Userinfo.userSex}</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select></li>
								<li><span>手机：</span> <input name="userTelInfo" type="text"
									value="${sessionScope.Userinfo.userTel}"></li>
								<li><span>常用地址：</span> <input name="userAddInfo"
									type="text" value="${sessionScope.Userinfo.userAdd}"></li>
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
							<li><span>账户余额：</span> <em>${sessionScope.Courier.balance}</em>
								&nbsp;&nbsp;&nbsp; <a class="btn btn-success btn-xs"
								href="pay.jsp">点击充值</a></li>
						</ul>
						<!-- 跑腿用户信息显示修改 -->
						<strong>基本信息</strong>
						<form action="CourierServlet.do" method="get">
							<input type="hidden" name="op" value="xiugai" /> <input
								type="hidden" id="courierId" name="courierId"
								value="${sessionScope.User.userId}" /> <input type="hidden"
								id="courierType" value="${sessionScope.User.userType}" />
							<ul>
								<li><span>用户ID:</span> <em>${sessionScope.User.userId}</em>
								</li>
								<li><span>性别：</span> <select name="couriersex"
									id="couriersex">
										<option value="${sessionScope.Userinfo.userSex}">${sessionScope.Userinfo.userSex}</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select></li>
								<li><span>身份证：</span> <em>${sessionScope.Courier.IDcard}</em></li>
								<li><span>手机：</span> <input name="courierTel" type="text"
									value="${sessionScope.Courier.tel}"></li>
								<li><span>地址：</span> <input name="courierAdd" type="text"
									value="${sessionScope.Courier.address}"></li>
								<li><span>配送范围：</span> <input name="ableDistance"
									type="text" value="${sessionScope.Courier.ableDistance}">
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
				<form id="form_data" method="get" action="BeCourier.do">
					<input type="hidden" name="op" value="toBeCourier" /> <input
						type="hidden" name="userId" value="${sessionScope.User.userId}" />
					<input type="hidden" name="tel"
						value="${sessionScope.Userinfo.userTel}" /> <input type="hidden"
						name="address" value="${sessionScope.Userinfo.userAdd}" /> <input
						type="hidden" name="balance"
						value="${sessionScope.Userinfo.userBalance}" />
					<div class="modal-body">
						<div class="form-group ">
							<label for="">证件照:</label> <img id="idImg" src=""
								style="width: 80px; height: 60px" /> <input type="file"
								id="selectImg" name="idImg" onchange="fun(this)" value="" />
						</div>

						<div class="form-group">
							<label for="">真实姓名:</label><input class="form-control"
								type="text" name="realName" id="realName">
						</div>

						<div class="form-group">
							<label for="">身份证:</label> <input class="form-control"
								type="text" name="realIDcard" id="realIDcard">
						</div>

						<div class="form-group">
							<label for="">押金:</label><em>500</em>
							<button class="btn-link" id="pay" name="pay">点击付款</button>
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
	<!-- 修改密码 模态开始 -->

	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="modal fade" id="modal-container-546969" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">密码修改</h4>
						</div>
						<div class="modal-body">

							<form name="editForm" action="ChangPwdServlet" method="get"
								class="form-horizontal" role="form">
								<input type="hidden" id="userId" name="userId"
									value="${sessionScope.User.userId}" /> <input type="hidden"
									id="op" name="op" value="ChangPwd"> <input
									type="hidden" name="userPwd" id="userPwd"
									value="${sessionScope.User.userPwd}" />



								<div class="form-group">

									<label for="oldPwd" class="col-sm-2 control-label">旧密码</label>
									<div class="col-sm-8">

										<input type='password' id="oldpassword" class="form-control"
											name="oldpassword" id="oldpassword" required
											placeholder="原密码">
										<div style="display: inline" id="tip1"></div>


									</div>
								</div>



								<div class="form-group">
									<label for="newPwd" class="col-sm-2 control-label">新密码</label>
									<div class="col-sm-8">
										<input type='password' id="newPwd" name="newPwd"
											class="form-control" required placeholder="长度为: 6-18">
										<div style="display: inline" id="tip2"></div>
									</div>
								</div>

								<div class="form-group">
									<label for="surePwd" class="col-sm-2 control-label">确认密码</label>
									<div class="col-sm-8">
										<input type='password' id="surePwd" name="surePwd"
											class="form-control" required placeholder="必须和第一次一样">
										<div style="display: inline" id="tip3"></div>
									</div>
								</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary"
								onclick="surechange">确认修改</button>
						</div>
						</form>

					</div>

				</div>

			</div>

		</div>
	</div>
	<!--  修改密码 模态结束 -->



	<!--尾部-结束-->
	<c:if
		test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==1}">
		<script src="js/GPS_GetLng&LatByBrow.js"></script>
	</c:if>
	<script type="text/javascript">
		function fun(o) {
			document.getElementById("idImg").src = window.URL
					.createObjectURL(o.files[0]);
		}
	</script>
	<script>
		/**
		 * 判断用户是否在登录状态
		 */
		$("#modal-546969").click(function() {
			var u = $("#userId").val();
			if (u == "") {
				alert('请先登录~');
				window.location.href = "login.html";
			}
		});
	</script>
</body>
</html>