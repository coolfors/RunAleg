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
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=oMN1mtyewGGM1EIbHzDmHk0nR1sxU2WA"></script>
</head>
<body>
<!--顶部-开始-->
<div id="allmap" hidden="hidden"></div>
	<input id="lng" name="lng" hidden="hidden" value="" />
	<input id="lat" name="lat" hidden="hidden" value="" />
	<input id="CourierId" name="CourierId" hidden="hidden" value="${sessionScope.Courier.courierId}" />
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
                <c:if test="${sessionScope.User==null}">
					<li><a href="login.html">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==1}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==2}">
					<li><a href="courier-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==1}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
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
                <li><a href="alliance.jsp">关于我们</a></li>
                <li class="active"><a href="contact-us.jsp">联系我们</a></li>
            </ul>
        </div>
    </div>
</nav>
<!--导航-结束-->

<div class="container">
    <div class="row neirong">
    	<div class="col-sm-6">
			<h3>联系我们</h3>
            <hr>
            <p>感谢您来到快递侠，若您有加盟意向或者有什么宝贵建议，请您为我们留言或者通过以下方式联系我们，我们将尽快给您回复，并为您及时解答各方面的问题，谢谢。</p>
            <p><span>地址：</span>厦门市软件园</p>
            <p><span>电话：</span>13011111111</p>
            <p><span>邮箱：</span>coolfors@163.com</p>
        </div>
        <div class="col-sm-6">
        	<h3>留言板</h3>
            <hr>
        	<form action=
        	<c:if test="${sessionScope.User==null}">
        		"login.html"
        	</c:if>
        	<c:if test="${sessionScope.User!=null}">
        		"FeedBackServlet.do?op=FeedBack&UserId=${sessionScope.User.userId}"
        	</c:if>
        	 method="post">
                <!-- <label class="control-label" for="biaoti">称呼</label>
                <input type="text" id="biaoti" class="form-control" placeholder="请输入您的姓名或昵称"> -->
                <label class="control-label" for="neirong">内容</label>
                <textarea class="form-control" id="neirong" name="neirong" placeholder="请输入您想说的话或者宝贵建议" rows="5"></textarea>
                <input class="btn btn-info form-control" style="width:20%; margin-top:10px; float:right;" type="submit" value="确定">
            </form>
        </div>
		<div class="col-sm-12">
        	<h3>留言问答</h3>
            <hr>
			<div>
				<c:if test="${sessionScope.User!=null&&requestScope.pd==null}">
					<jsp:forward page="FeedBackServlet.do?op=getFeedBack&UserId=${sessionScope.User.userId}"></jsp:forward>
				</c:if>
				<c:forEach var="a" items="${requestScope.pd.data}">
							<div class="liuyan">
                	<div class="row">
                    	<span class="col-sm-1 col-xs-4 text-right">内容：</span>
                        <span class="col-sm-11 col-xs-8">${a.feedbackInfo}</span>
                    </div>
                    <div class="row">
                    	<span class="col-sm-1 col-xs-4 text-right">留言人：</span>
                        <span class="col-sm-11 col-xs-8">${sessionScope.User.userName}</span>
                    </div>
                    <div class="row">
                    	<span class="col-sm-1 col-xs-4 text-right">回复：</span>
                        <span class="col-sm-11 col-xs-8">${a.managerAns==null?"暂未回复":a.managerAns}</span>
                    </div>
                </div>
							</c:forEach>
            	<!-- <div class="liuyan">
                	<div class="row">
                    	<span class="col-sm-1 col-xs-4 text-right">内容：</span>
                        <span class="col-sm-11 col-xs-8">快递侠是外卖服务吗</span>
                    </div>
                    <div class="row">
                    	<span class="col-sm-1 col-xs-4 text-right">留言人：</span>
                        <span class="col-sm-11 col-xs-8">马小兵</span>
                    </div>
                    <div class="row">
                    	<span class="col-sm-1 col-xs-4 text-right">回复：</span>
                        <span class="col-sm-11 col-xs-8">加油!很不错的平台，以后可以躺床上不用下楼了</span>
                    </div>
                </div>
            </div> -->
        </div>
            <div id="test1" class="text-center"></div>

					<script src="layui/layui.js"></script>
					<script>
					layui.use('laypage', function(){
						  var laypage = layui.laypage;
						  var c =${ pd.total};

			   				var l = ${pd.pageSize};

			   				var p = ${ pd.page};
						  //执行一个laypage实例
						  laypage.render({
						    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
						    ,count: c //数据总数，从服务端得到
						    ,limit: l	//每页显示的数据数
						    ,layout :['count','prev', 'page', 'next', 'refresh']
						    ,curr: p	//当前页面
						    ,jump: function(obj,first){	//跳转
						    	if(!first){
						    		location.href="FeedBackServlet.do?op=getFeedBack&UserId=${sessionScope.User.userId}&pageIndex="+obj.curr+"&pageSize=5";
						    	}
						    }
						  });
						});
					</script>
    </div>
</div>

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
                <p>新广货运联盟</p>
                <hr>
                <p>新广货运联盟成立于2018年，是一家专业提供互联网物流信息的网站。</p>
                <p>新广货运联盟实现了车找货、货找车的实时连接，通过互联网服务于广大货运司机和相关货运的各界人士。</p>
                <p>新广货运联盟坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！</p>
            </div>
            <div class="col-sm-4">
                <p><a href="contact-us.jsp">加盟我们</a> | <a href="contact-us.jsp">联系我们</a></p>
                <hr>
                <p>咨询电话：13462264663</p>
                <p>邮箱：xinguanghuoyun@163.com</p>
                <p>地址：河南省新乡市八一路35号中同街办事处</p>
            </div>
            <div class="col-sm-12 text-center" style="margin-top:20px;">
            	Copyright ©  新广货运联盟 版权所有 Power by www.xghylm.com  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
            </div>
        </div>
    </div>
</div>
<!--尾部-结束-->
<c:if test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==1}">
		<script src="js/GPS_GetLng&LatByBrow.js"></script>
	</c:if>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<c:if test="${sessionScope.User.userType==2&&sessionScope.Courier.sockState==1}">
		<script src="js/GPS_GetLng&LatByBrow.js"></script>
	</c:if>
</body>
</html>