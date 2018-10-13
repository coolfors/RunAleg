$(function() {
	$.get("getUserServlet.do?op=getUserName",function(data,status){
		var userName = JSON.parse(data);
		var str="";
		if(userName==null){
			str="<a href='login.html' target='_blank' id='login'>登录</a>&nbsp; <a href='register.html' target='_blank' id='reg'>注册</a>";			
		}else{
			str="<a href='login.html' target='_blank' id='login'> "+userName+" </a>"
		}
		$("#showUserName").html(str);
	});
})