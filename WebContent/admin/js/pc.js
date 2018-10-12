$(function (){
	var handlerEmbed = function (captchaObj) {
	    $("#embed-submit").click(function (e) {
	        var validate = captchaObj.getValidate();
	        if (!validate) {//没有完成验证
	            $("#notice")[0].className = "show";
	            setTimeout(function () {
	                $("#notice")[0].className = "hide";
	            }, 2000);
	            e.preventDefault();
	        }else{
	        	//验证
	        	$.ajax({
	        		url: "http://localhost:9090/DataTableProject/validate", // 进行二次验证
	        		type: "post",
	        		dataType: "json",
	        		data: {
	        			username: $('#username2').val(),
	        			password: $('#password2').val(),
	        			geetest_challenge: validate.geetest_challenge,
	        			geetest_validate: validate.geetest_validate,
	        			geetest_seccode: validate.geetest_seccode
	        		},
	        		success: function (data) {
	        			if (data && (data.status === "success")) {
	        				alert("验证成功");
//	        				window.location.href = "/login.jsp";
	        			} else {
	        				alert("验证失败");
//	        				window.location.href = "/login.jsp";
	        			}
	        		}
	        	});
	        }
        });
	    // 将验证码加到id为captcha的元素里，同时会有三个input的值：geetest_challenge, geetest_validate, geetest_seccode
	    captchaObj.appendTo("#embed-captcha");
	    captchaObj.onReady(function () {
	        $("#wait")[0].className = "hide";
	    });
	    // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
	};
	
	$.ajax({
		// 获取id，challenge，success（是否启用failback）
		url: "http://localhost:9090/DataTableProject/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
		type: "get",
		dataType: "json",
		success: function (data) {
			// 使用initGeetest接口
			// 参数1：配置参数
			// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
			initGeetest({
				gt: data.gt,
				challenge: data.challenge,
				product: "float", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
				offline: !data.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
				// 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
			}, handlerEmbed);
		}
	});
});



