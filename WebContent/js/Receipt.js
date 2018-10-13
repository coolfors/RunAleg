/**
 * 显示已完成订单
 */
$("#completeorder").click(function () {
				$("thead").html("<tr><th>配送员id</th><th>派单号</th><th>订单号</th><th>起送时间</th><th>结束时间</th><th>状态</th></tr>");
				$.get("rs.do?op=completeorder",function(data,status) {
					var arr=JSON.parse(data);
					var str="";
					$.each(arr.data, function(index,a){
						str = str + "<tr><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+"已送达"+"</a></td>";
					});
					$("tbody").html(str);
					
				});
			});

/**
 * 显示配送中的订单
 * @returns
 */

$("#dispatching").click(function () {
	$("thead").html("<tr><th>接单号</th><th>配送员id</th><th>派单号</th><th>订单号</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th></tr>");
	$.get("rs.do?op=completeorder",function(data,status) {
		var arr=JSON.parse(data);
		var str="";
		$.each(arr.data, function(index,a){
			str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance;
		});
		$("tbody").html(str);
		
	});
});


/**
 * 普通用户查看订单
 *
 */
$(function(){
	//当前点击事件触发显示所有订单，dispatch表
	//所有订单-dispatch所有内容
	$("#allDispatch").click(function(){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("rs.do?op=allDispatch",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data,function(index,a){
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'已接单':'未接单')+"</a></td></tr>";
			});
			$("tbody").html(str);
		});
	});
	/**
	 * 待配送订单
	 * 这边条件还没修改 待配送订单-dispatch中disState为0 的内容
	 */
	$("#waitSendDispatch").click(function(){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("rs.do?op=waitSendDispatch",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data,function(index,a){
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'待配送订单':'未接单')+"</a></td></tr>";
			});
			$("tbody").html(str);
		});
	});
	//点击a标签事件，显示所有未评价订单，evaluate表
	$("#waitEvaluate").click(function(){
		$("thead").html("<tr><th>评价id</th><th>订单号</th><th>评价分</th><th>评价信息</th><th>评价状态</th></tr>");
		$.get("rs.do?op=waitEvaluate",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>未评价</a></td></tr>";
			});
			$("tbody").html(str);
		});
	});
	
	
});

