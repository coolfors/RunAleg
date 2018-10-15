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
<meta name="description" content="快递侠实现了跑腿代跑和威客任务的实时连接，通过互联网服务于跑男和兼职群体。坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！">
<meta name="keywords" content="物流,跑腿,跑男,快递侠">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
<![endif]-->
</head>
<body>
<!--顶部-开始-->
<div style=" background:#EBEBEB; width:100%; height:80px; line-height:80px;">
    <div class="container">
        <div class="row">
            <span class="col-sm-7 col-sm-offset-1 col-xs-6 col-xs-offset-1"><img src="images/logo.png" class="img-responsive" alt="新广货运联盟"></span>
            <span class="col-sm-4 col-xs-5" style="float:right">
            	<a href="modify data.html" target="_blank" style="display:none">su23c0e</a>
                <a href="" style="display:none">退出</a>
            </span>
            <span class="col-sm-4 col-xs-5" style="float:right">
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
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">首页</a></li>
                <li><a href="index.jsp">跑腿吧<span class="sr-only"></span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">发布跑腿<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="freight-info.jsp">信息发布</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">帮助<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="driving-knowledge.jsp">如何下单</a></li>
                    </ul>
                </li>
                <li class="active"><a href="alliance.jsp">关于我们</a></li>
                <li><a href="contact-us.jsp">联系我们</a></li>
            </ul>
        </div>
    </div>
</nav>
<!--导航-结束-->
<!--内容-开始-->
<div class="container">
	<ol class="breadcrumb">
    	<li>当前位置：</li>
        <li><a href="index.jsp">首页</a></li>
        <li><a href="#">联盟简介</a></li>
        <li class="active">正文</li>
    </ol>
    <div class="row neirong">
    	<div class="col-sm-8">
        	<p class="text-center">联盟简介</p>
        	<p>快递侠成立于2018年，是一家专业提供跑腿业务的平台。</p>
                <p>快递侠的跑腿业务提供一个平台给任何普通用户以及需要兼职的用户群体。</p>
                <p>快递侠坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！</p>
            <p>习近平强调，全面从严治党，核心是加强党的领导，基础在全面，关键在严，要害在治。要把纪律建设摆在更加突出位置，
            	坚持纪严于法、纪在法前，健全完善制度，深入开展纪律教育，狠抓执纪监督，养成纪律自觉，用纪律管住全体党员。要增强领导干部政治
                警觉性和政治鉴别力，各级干部特别是领导干部要善于从政治上看问题，站稳立场、把准方向，始终忠诚于党，始终牢记政治责任。要坚持高标准和守底线
                相结合，既要注重规范惩戒、严明纪律底线，更要引导人向善向上，坚守共产党人精神追求，筑牢拒腐防变思想道德防线。</p>
        </div>
        <div class="col-sm-3 col-sm-offset-1">
        	<p class="pic">广告图片</p>
            <hr>
            <a href="" target="_blank"><img src="images/93ce5c4da31cd173.jpg" class="text-center img-responsive" style="width:100%; height:100%"></a><hr>
            <a href="" target="_blank"><img src="images/93ce5c4da31cd173.jpg" class="text-center img-responsive" style="width:100%; height:100%"></a><hr>
            <a href="" target="_blank"><img src="images/93ce5c4da31cd173.jpg" class="text-center img-responsive" style="width:100%; height:100%"></a><hr>
        </div>
    </div>
</div>
<!--内容-结束-->


<!--尾部-开始-->
<div class="footer" style="background:#525252; width:100%; padding-bottom:20px; margin-top:30px;">
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
                <p><a href="register.html">加入跑男</a> | <a href="contact-us.jsp">联系我们</a></p>
                <hr>
                <p>咨询电话：13015962382</p>
                <p>邮箱：coolfors@163.com</p>
                <p>地址：厦门市软件园</p>
            </div>
            <div class="col-sm-12 text-center" style="margin-top:20px;">
            	Copyright ©  快递侠 版权所有 Power by 快递侠
            </div>
        </div>
    </div>
</div>
<!--尾部-结束-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>