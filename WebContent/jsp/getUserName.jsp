<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${requestScope.User==null}">
	<a
					href="login.html" target="_blank" id="login">登录</a>&nbsp; <a
					href="register.html" target="_blank" id="reg">注册</a>
</c:if>
<c:if test="${requestScope.User!=null}">
	<jsp:forward page=""></jsp:forward>
</c:if>