/**
 * Courier查看
 */

$(function(){
	/*layui.use([ 'laypage', 'layer' ], function() {
		var laypage = layui.laypage, layer = layui.layer;
		//完整功能
		laypage.render({
			elem : 'test1',
			count : 100,
			layout : [ 'count', 'prev', 'page', 'next', 'limit',
					'refresh', 'skip' ],
			jump : function(obj, first) { //跳转
				if (!first) {
					location.href = "register.html";
				}
			}
		});
	});*/ 
});


$(function(){
	/**
	 * 设置一个用于遍历dispatch的函数
	 */
	getallDis=function(pageIndex,pageSize){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("CourierServlet.do","op=allDispatch"+"&pageIndex="+pageIndex+"&pageSize="+pageSize,function(data,status){
			
			var jsonStr=data;
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'已接单':'未接单')+"</a></td></tr>";
			});
			$("tbody").html(str);
		});
	}
	/*$(document).ready(function() {
		getallDis(1,4);
	})*/
	//点击标签出发事件：显示所有派单信息，Dispatch
	$("#allDispatch").click(function(){
		var strJson="${requestScope.dataJson}";
		var arr=JSON.parse(strJson);
		getReceiptSend(arr.page,arr.pageSize);
		/*var jsonStr=getallDis(1,4);
		var arr=JSON.parse(jsonStr);*/
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
				curr : function() {
					var page = p; // 当前页(后台获取到的)
					return page ? page : 1; // 返回当前页码值
				}(),
				jump : function(obj, first) {
					if (!first) {
						getallDis(p,l);
						//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
						
					}
				}
			});
		});
	});
	/**
	 * 用于ajax遍历sendreceipt表的方法
	 */
	getReceiptSend=function(pageIndex,pageSize){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("CourierServlet.do","op=waitSendReceipt"+"&pageIndex="+pageIndex+"&pageSize="+pageSize,function(data,status){
			
			var jsonStr=data;
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>待送</a></td></tr>";
			});
			$("tbody").html(str);
		});
	}
	//点击a标签事件，显示所有待送订单，receipt表
	$("#waitSendReceipt").click(function(){
		var strJson="${requestScope.dataJson}";
		var arr=JSON.parse(strJson);
		getReceiptSend(arr.page,arr.pageSize);
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
					curr : function() {
						var page = p; // 当前页(后台获取到的)
						return page ? page : 1; // 返回当前页码值
					}(),
					jump : function(obj, first) {
						if (!first) {
							getReceiptSend(p,l);
							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
							
						}
					}
				});
			});
	});
	
	/**
	 * 设置一个用于遍历waitreceipt的函数
	 */
		getReceiptWait=function(pageIndex,pageSize){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("CourierServlet.do","op=waitUpdateReceipt"+"&pageIndex="+pageIndex+"&pageSize="+pageSize,function(data,status){
			
			var jsonStr=data;
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td></tr>";
			});
			$("tbody").html(str);
		});
	}
	//点击a标签事件，显示所有配送中订单，receipt表
	$("#waitUpdateReceipt").click(function(){
			var strJson="${requestScope.dataJson}";
			var arr=JSON.parse(strJson);
			getReceiptWait(arr.page,arr.pageSize);
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
					curr : function() {
						var page = p; // 当前页(后台获取到的)
						return page ? page : 1; // 返回当前页码值
					}(),
					jump : function(obj, first) {
						if (!first) {
							getReceiptWait(p,l);
							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
							
						}
					}
				});
			});
	});
	/**
	 * 设置一个用于遍历waitEvaluate的函数
	 */
		getEvaluateWait=function(pageIndex,pageSize){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("CourierServlet.do","op=waitEvaluate"+"&pageIndex="+pageIndex+"&pageSize="+pageSize,function(data,status){
			
			var jsonStr=data;
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>未评价</a></td></tr>";
			});
			$("tbody").html(str);
		});
	}
	//点击a标签事件，显示所有未评价订单，evaluate表
	$("#waitEvaluate").click(function(){
		var strJson="${requestScope.dataJson}";
		var arr=JSON.parse(strJson);
		getEvaluateWait(arr.page,arr.pageSize);
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
					curr : function() {
						var page = p; // 当前页(后台获取到的)
						return page ? page : 1; // 返回当前页码值
					}(),
					jump : function(obj, first) {
						if (!first) {
							getEvaluateWait(p,l);
							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
							
						}
					}
				});
			});
	});
	/**
	 * 设置一个用于遍历overEvaluate的函数
	 */
		getEvaluateOver=function(pageIndex,pageSize){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("CourierServlet.do","op=overEvaluate"+"&pageIndex="+pageIndex+"&pageSize="+pageSize,function(data,status){
			
			var jsonStr=data;
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>未评价</a></td></tr>";
			});
			$("tbody").html(str);
		});
	}
	//点击a标签事件，显示所有已评价订单，evaluate表
	$("#overEvaluate").click(function(){
		var strJson="${requestScope.dataJson}";
		var arr=JSON.parse(strJson);
		getEvaluateOver(arr.page,arr.pageSize);
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
					curr : function() {
						var page = p; // 当前页(后台获取到的)
						return page ? page : 1; // 返回当前页码值
					}(),
					jump : function(obj, first) {
						if (!first) {
							getEvaluateOver(p,l);
							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
							
						}
					}
				});
			});
	});
	
	
	
})