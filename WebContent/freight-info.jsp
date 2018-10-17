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
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css">
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/LocationRange.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/freight-info.css">
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
				<c:if test="${sessionScope.User==null}">
					<li><a href="login.html">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==1}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==2}">
					<li><a href="courier-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<li class="active" class="dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">发布跑腿<span
						class="caret"></span></a>
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


	<div class="container biao">
		<div
			style="border: 1px solid #F5841C; margin-left: 0; margin-right: 0;">
			<ul class="new_tab_ul row">
				<li class="new_tab_f hover col-lg-6 col-md-6 col-sm-6" id="one1"
					style="background: #fff;" onclick="setTab(&#39;one&#39;,1,2)">
					<a href="javascript:;" style="color: #F5841C;">发布代跑腿</a>
				</li>
				<li class="new_tab_f col-lg-6 col-md-6 col-sm-6" id="one2"
					onclick="setTab(&#39;one&#39;,2,2)"><a href="javascript:;">如何填写下单</a>
				</li>
			</ul>
			<div class="row">
				<!--货源发布-->
				<div class="new_tab_div" id="list_one1">

					<form id="order" method="post" class="bd">
						<div class="form-group row">
							<label class="col-sm-2 control-label"><span>*&nbsp;</span>起送地</label>
							<div class="list_div area-wraper col-sm-4">
								<input autocomplete="off" type="text" id="beginAdd"
									name="beginAdd" class="list_select form-control" value=""
									placeholder="出发城市">

							</div>

							<div id="msg" style="color: red"></div>
							<label class="col-sm-2 control-label">到达地</label>
							<div class="list_div list_div_last col-sm-4">
								<input type="text" id="endAdd" name="endAdd"
									class="list_select1 form-control" value=""
									placeholder="出发地详细地址">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 control-label"><span>*&nbsp;</span>物品介绍</label>
							<div class="list_div list_div_last col-sm-4">
								<input type="text" class="form-control" name="disPS" id="disPS"
									value="" placeholder="请填写货物名称">
							</div>

							<label class="col-sm-2 control-label">联系电话</label>
							<div class="list_div col-sm-2">
								<input name="disTel" maxlength="11" id="disTel"
									class="form-control" type="tel" value="" placeholder="填写阿拉伯数字">
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 control-label"><span>*&nbsp;</span>物品类型</label>
							<div class="list_div list_div_last col-sm-4">
								<select name="goodsType" id="goodsType"
									class="list_type form-control">
									<option value="请选择" selected>请选择</option>
									<option value="1">美食</option>
									<option value="2">文件</option>
									<option value="3">蛋糕</option>
									<option value="4">手机</option>
									<option value="5">钥匙</option>
									<option value="6">鲜花</option>
									<option value="7">其他</option>

								</select>
							</div>

							<input type="hidden" id="userId" name="userId"
								value="${sessionScope.User.userId}"> <input
								type="hidden" id="userPwd" name="userPwd"
								value="${sessionScope.User.userPwd}"> <label
								class="col-sm-2 control-label">报酬</label>
							<div class="list_div col-sm-4">
								<input id="disPrice" name="disPrice" type="text"
									class="form-control" placeholder="请输入运费金额">
							</div>
						</div>

						<div class="new_tab_bottom form-group row">
							<input class=" btn btn-info col-sm-1 col-sm-offset-9"
								type="submit" id="sure" value="下单并付款" href="modal-container" data-toggle="modal" >
							<!-- <input class=" btn btn-info col-sm-1 col-sm-offset-9" type="button" id="sure" value="下单并付款"> -->
							
							<input class=" btn btn-warning col-sm-1" type="reset" value="重置">					
							<button class="btn btn-primary btn-lg" id="toModal" data-toggle="modal" data-target="#myModal">开始演示模态框</button>
							
								</div>
					
					</form>
				</div>

			</div>
		</div>
	</div>
	        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"
                                data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                       <h4 class="modal-title" id="myModalLabel">确认支付页面</h4>
                        </h4>
                    </div>
                    <div class="modal-body">
                    <label>支付密码</label> <input type="password" id="surePwd"
							name="surePwd" placeholder="请输入支付密码">
                    </div>
                    <div class="modal-footer">
<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="doPay" name="doPay" type="submit"
							class="btn btn-secondary" data-dismiss="modal">确认支付</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>

	
	
	<div class="container row">
		<p style="text-align: right; color: red; margin-right: 15px;">*
			发布的信息只保留15天！</p>
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
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/laydate.js"></script>


	<script src="js/jquery.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/messages_zh.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	$("#toModal").hide();

});
</script>
	<script src="js/jquery_002_002.js" type="text/javascript"></script>
	<script src="js/areaData1.js" type="text/javascript"></script>
	<script src="js/LocationRange.js" type="text/javascript"></script>
	<script src="js/jquery_003.js" type="text/javascript"></script>
	<script src="js/freight.js" type="text/javascript"></script>
</body>
</html>