/**
 * 前端用户界面订单的展示
 */
$(function () {
	/**
	 * 用户界面已完成订单
	 */
	$("#completeorder").click(function(){
		$("#headName").html("已完成的订单");
	$.ajax({
             type: "get",
             url: "rs.do?op=completeorder",
             /*data: {username:$("#username").val(),
             content:$("#content").val()
                },*/
             dataType: "json",
             
             success: function(data){
                        /* $('#resText').empty();*/   //清空resText里面的所有内容
                         //var html = ''; 
            	 $("thead").html("<tr><th>配送员id</th><th>派单号</th><th>订单号</th><th>起送时间</th><th>结束时间</th><th>状态</th></tr>");
         		var jsonStr=JSON.stringify(data);
         		//alert(jsonStr);
    			var arr = JSON.parse(jsonStr);
         		var str = "";
    			$.each(arr.data, function(index,a){
    				str = str + "<tr><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+"已送达"+"</a></td>";
    			});
    			$("tbody").html(str);
    			layui.use('laypage', function() {
    				var laypage = layui.laypage;

    				var c = arr.total;

    				var l = arr.pageSize;

    				var p = arr.page;

    				//执行一个laypage实例
    				laypage.render({
    					elem : 'test1' //注意，这里的 test1 是 ID，不用加 # 号
    					,
    					count : c, //数据总数，从服务端得到
    					limit : l,
    					skip : '#5e7cdf',
    					layout : ['count','prev', 'page', 'next','limit', 'skip', 'refresh' ],
    					curr : p,
    					jump : function(obj, first) {
    						if (!first) {
    							$.ajax({
    					             type: "get",
    					             url: "rs.do?op=completeorder&pageIndex="+obj.curr+"&pageSize="+obj.limit,
    					             /*data: {username:$("#username").val(),
    					             content:$("#content").val()
    					                },*/
    					             dataType: "json",
    					             success: function(data){
    					                        /* $('#resText').empty();*/   //清空resText里面的所有内容
    					                         //var html = ''; 
    					         		var jsonStr=JSON.stringify(data);
    					         		//alert(jsonStr);
    					    			var arr = JSON.parse(jsonStr);
    					    			//alert(arr.page);
    					         		var str = "";
    					    			$.each(arr.data, function(index,a){
    					    				str = str + "<tr><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+"已送达"+"</a></td>";
    					    			});
    					    			$("tbody").html(str);
    					    			
    					             }
    					         });
    							//location.href = "rs.do?op=completeorder&pageIndex="+obj.curr+"&pageSize="+obj.limit;
    							
    						}
    					}
    				});
    			});
             }
         });
	});
	
	
	/**
	 * 用户界面显示正在配送中订单
	 */
	$("#dispatching").click(function(){
		$("#headName").html("配送中的订单");
		$.ajax({
	             type: "get",
	             url: "rs.do?op=dispatching",
	             /*data: {username:$("#username").val(),
	             content:$("#content").val()
	                },*/
	             dataType: "json",
	             
	             success: function(data){
	                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	                         //var html = ''; 
	            	 $("thead").html("<tr><th>接单号</th><th>配送员id</th><th>派单号</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th></tr>");
	         		var jsonStr=JSON.stringify(data);
	         		//alert(jsonStr);
	    			var arr = JSON.parse(jsonStr);
	         		var str = "";
	    			$.each(arr.data, function(index,a){
	    				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance;
	    			});
	    			$("tbody").html(str);
	    			layui.use('laypage', function() {
	    				var laypage = layui.laypage;

	    				var c = arr.total;

	    				var l = arr.pageSize;

	    				var p = arr.page;

	    				//执行一个laypage实例
	    				laypage.render({
	    					elem : 'test1' //注意，这里的 test1 是 ID，不用加 # 号
	    					,
	    					count : c, //数据总数，从服务端得到
	    					limit : l,
	    					skip : '#5e7cdf',
	    					layout : ['count','prev', 'page', 'next','limit', 'skip', 'refresh' ],
	    					curr : p,
	    					jump : function(obj, first) {
	    						if (!first) {
	    							$.ajax({
	    					             type: "get",
	    					             url: "rs.do?op=dispatching&pageIndex="+obj.curr+"&pageSize="+obj.limit,
	    					             /*data: {username:$("#username").val(),
	    					             content:$("#content").val()
	    					                },*/
	    					             dataType: "json",
	    					             success: function(data){
	    					                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	    					                         //var html = ''; 
	    					         		var jsonStr=JSON.stringify(data);
	    					         		//alert(jsonStr);
	    					    			var arr = JSON.parse(jsonStr);
	    					    			//alert(arr.page);
	    					         		var str = "";
	    					    			$.each(arr.data, function(index,a){
	    					    				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance;
	    					    			});
	    					    			$("tbody").html(str);
	    					    			
	    					             }
	    					         });
	    							//location.href = "rs.do?op=completeorder&pageIndex="+obj.curr+"&pageSize="+obj.limit;
	    							
	    						}
	    					}
	    				});
	    			});
	             }
	         });
		});
	
	/**
	 * 普通用户查看订单
	 *
	 */
	$("#allDispatch").click(function(){
		$("#headName").html("所有订单");
		$.ajax({
	             type: "get",
	             url: "rs.do?op=allDispatch",
	             /*data: {username:$("#username").val(),
	             content:$("#content").val()
	                },*/
	             dataType: "json",
	             
	             success: function(data){
	                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	                         //var html = ''; 
	            	 $("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
	         		var jsonStr=JSON.stringify(data);
	         		//alert(jsonStr);
	    			var arr = JSON.parse(jsonStr);
	         		var str = "";
	    			$.each(arr.data, function(index,a){
	    				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'已接单':'未接单')+"</a></td></tr>";
	    			});
	    			$("tbody").html(str);
	    			layui.use('laypage', function() {
	    				var laypage = layui.laypage;

	    				var c = arr.total;

	    				var l = arr.pageSize;

	    				var p = arr.page;

	    				//执行一个laypage实例
	    				laypage.render({
	    					elem : 'test1' //注意，这里的 test1 是 ID，不用加 # 号
	    					,
	    					count : c, //数据总数，从服务端得到
	    					limit : l,
	    					skip : '#5e7cdf',
	    					layout : ['count','prev', 'page', 'next','limit', 'skip', 'refresh' ],
	    					curr : p,
	    					jump : function(obj, first) {
	    						if (!first) {
	    							$.ajax({
	    					             type: "get",
	    					             url: "rs.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit,
	    					             /*data: {username:$("#username").val(),
	    					             content:$("#content").val()
	    					                },*/
	    					             dataType: "json",
	    					             success: function(data){
	    					                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	    					                         //var html = ''; 
	    					         		var jsonStr=JSON.stringify(data);
	    					         		//alert(jsonStr);
	    					    			var arr = JSON.parse(jsonStr);
	    					    			//alert(arr.page);
	    					         		var str = "";
	    					    			$.each(arr.data, function(index,a){
	    					    				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'已接单':'未接单')+"</a></td></tr>";
	    					    			});
	    					    			$("tbody").html(str);
	    					    			
	    					             }
	    					         });
	    							
	    							
	    						}
	    					}
	    				});
	    			});
	             }
	         });
		});
	
	/**
	 * 待配送订单
	 * 这边条件还没修改 待配送订单-dispatch中disState为0 的内容
	 */
	$("#waitSendDispatch").click(function(){
		$("#headName").html("待配送订单");
		$.ajax({
	             type: "get",
	             url: "rs.do?op=waitSendDispatch",
	             /*data: {username:$("#username").val(),
	             content:$("#content").val()
	                },*/
	             dataType: "json",
	             
	             success: function(data){
	                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	                         //var html = ''; 
	            		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
	         		var jsonStr=JSON.stringify(data);
	         		//alert(jsonStr);
	    			var arr = JSON.parse(jsonStr);
	         		var str = "";
	    			$.each(arr.data, function(index,a){
	    				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'待配送订单':'未接单')+"</a></td></tr>";
	    			});
	    			$("tbody").html(str);
	    			layui.use('laypage', function() {
	    				var laypage = layui.laypage;

	    				var c = arr.total;

	    				var l = arr.pageSize;

	    				var p = arr.page;

	    				//执行一个laypage实例
	    				laypage.render({
	    					elem : 'test1' //注意，这里的 test1 是 ID，不用加 # 号
	    					,
	    					count : c, //数据总数，从服务端得到
	    					limit : l,
	    					skip : '#5e7cdf',
	    					layout : ['count','prev', 'page', 'next','limit', 'skip', 'refresh' ],
	    					curr : p,
	    					jump : function(obj, first) {
	    						if (!first) {
	    							$.ajax({
	    					             type: "get",
	    					             url: "rs.do?op=waitSendDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit,
	    					             /*data: {username:$("#username").val(),
	    					             content:$("#content").val()
	    					                },*/
	    					             dataType: "json",
	    					             success: function(data){
	    					                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	    					                         //var html = ''; 
	    					         		var jsonStr=JSON.stringify(data);
	    					         		//alert(jsonStr);
	    					    			var arr = JSON.parse(jsonStr);
	    					    			//alert(arr.page);
	    					         		var str = "";
	    					    			$.each(arr.data, function(index,a){
	    					    				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'待配送订单':'未接单')+"</a></td></tr>";
	    					    			});
	    					    			$("tbody").html(str);
	    					    			
	    					             }
	    					         });
	    							
	    						}
	    					}
	    				});
	    			});
	             }
	         });
		});
	
	/**
	 * 显示用户界面所有未评价的表
	 */
	$("#waitEvaluate").click(function(){
		$("#headName").html("待评价订单");
		$.ajax({
	             type: "get",
	             url: "rs.do?op=waitEvaluate",
	             /*data: {username:$("#username").val(),
	             content:$("#content").val()
	                },*/
	             dataType: "json",
	             
	             success: function(data){
	                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	                         //var html = ''; 
	            	 $("thead").html("<tr><th>评价id</th><th>订单号</th><th>评价分</th><th>评价信息</th><th>评价状态</th></tr>");
	         		var jsonStr=JSON.stringify(data);
	         		//alert(jsonStr);
	    			var arr = JSON.parse(jsonStr);
	         		var str = "";
	    			$.each(arr.data, function(index,a){
	    				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>未评价</a></td></tr>";
	    			});
	    			$("tbody").html(str);
	    			layui.use('laypage', function() {
	    				var laypage = layui.laypage;

	    				var c = arr.total;

	    				var l = arr.pageSize;

	    				var p = arr.page;

	    				//执行一个laypage实例
	    				laypage.render({
	    					elem : 'test1' //注意，这里的 test1 是 ID，不用加 # 号
	    					,
	    					count : c, //数据总数，从服务端得到
	    					limit : l,
	    					skip : '#5e7cdf',
	    					layout : ['count','prev', 'page', 'next','limit', 'skip', 'refresh' ],
	    					curr : p,
	    					jump : function(obj, first) {
	    						if (!first) {
	    							$.ajax({
	    					             type: "get",
	    					             url: "rs.do?op=waitEvaluate&pageIndex="+obj.curr+"&pageSize="+obj.limit,
	    					             /*data: {username:$("#username").val(),
	    					             content:$("#content").val()
	    					                },*/
	    					             dataType: "json",
	    					             success: function(data){
	    					                        /* $('#resText').empty();*/   //清空resText里面的所有内容
	    					                         //var html = ''; 
	    					         		var jsonStr=JSON.stringify(data);
	    					         		//alert(jsonStr);
	    					    			var arr = JSON.parse(jsonStr);
	    					    			//alert(arr.page);
	    					         		var str = "";
	    					    			$.each(arr.data, function(index,a){
	    					    				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>未评价</a></td></tr>";
	    					    			});
	    					    			$("tbody").html(str);
	    					    			
	    					             }
	    					         });
	    							
	    						}
	    					}
	    				});
	    			});
	             }
	         });
		});
})