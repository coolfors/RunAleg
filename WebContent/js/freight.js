/**
 * 对用户下单信息进行校验
 */

$(document).ready(function() {

	$("#order").validate({
		// 验证规则,
		rules : {
			beginAdd : {
				required : true
			},
			endAdd : {
				required : true
			},
			disPS : {
				required : true
			},
			disTel : {
				required : true,
				minlength : 11
				/*, 
		        isMobile : true */
			},
			goodsType : {
				required : true
			},
			disPrice : {
				required : true,
				number:true	
			},
			
		},

		messages : {
			beginAdd : {
				required : "请输入起送地"
			},
			endAdd : {
				required : "请输入目的地"
			},
			disPS : {
				required : "请输入物品介绍"
			},
			disTel : {
				required : "请输入联系电话",
				minlength : "不能小于11个字符",  
			   
			},
			goodsType : {
				required : "请选择商品类型"
			},
			disPrice : {
				required : "请输入派单报酬",
				number:"报酬为金额（数字）"
			},

		},
		submitHandler : function(form) {
			
			 event.preventDefault();
			
			// $(form).ajaxSubmit();		 
			 
				$("#toModal").click();
			
		}
	});
	

});



function pay(surePwd) {
	$.ajax({
		type : 'get',
		url : "DispatchServlet?op=suPwd",
		async:false,
		data : {
			userId : $('#userId').val(),
			surepwd : surePwd.value
		},
		success : function(data) {
			// console.log(data=="\"ok\"");
			//alert("返回值" +data);
			if(data){
				$.ajax({
				type : 'get',
				url : "DispatchServlet?op=addDispatch",
				data : {
					userId : $('#userId').val(),
					beginAdd : $('#beginAdd').val(),
					endAdd : $('#endAdd').val(),
					disPS : $('#disPS').val(),
					disTel : $('#disTel').val(),
					goodsType : $('#goodsType').val(),
					disPrice : $('#disPrice').val(),

				},
				success : function(data) {
					alert('下单成功');
				}
			});
			}else{
				alert('支付密码错误');
			}
		}
	});
}

/**
 * 判断用户是否在登录状态
 */
/*$(function(){
	$("#sure").click(function(){
		if(${sessionScope.User.userPwd}==null){
			location.href("login.html")
		}
	});
});
*/

