/*$(function() {
	$.get("getUserServlet.do?op=getUser",function(data,status){
		var str="";
		if(data==null){
			str="<a href='login.html' target='_blank' id='login'>登录</a>&nbsp; <a href='register.html' target='_blank' id='reg'>注册</a>";			
		}else{
			var user = Json.parse(data);
			str="<a href='login.html' target='_blank' id='login'> "+user.userName+" </a>"
		}
		$("#showUserName").html(str);
	});
})*/

$(document).ready(function(){
	
	$.ajax({
		url:"LoginServlet.do?op=login",
		type:"get",
		success:function(data){
			console.log(data);
			$("#showUserName").html(data);
		}
	})
	
})
	
