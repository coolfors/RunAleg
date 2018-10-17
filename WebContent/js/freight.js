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
			surePwd : {
				required : true,
				equalTo : "#userPwd"
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

//手机号码验证  
//jQuery.validator.addMethod("isMobile", function(value, element) {  
//var length = value.length;  
//var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;  
//return this.optional(element) || (length == 11 && mobile.test(value));  
//}, "请正确填写手机号码"); 



$(function() {
	$("#doPay").click(function() {
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
				// console.log(data=="\"ok\"");
				if (data == "\"ok\"") {// 成功执行
					alert("成功");
				} else {
					alert('出错');// 出错执行
				}
			}
		});
	});
});


