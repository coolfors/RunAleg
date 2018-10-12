/**
 * 派单显示
 */
/*接单号
配送员id
派单号
订单号加密码
起送时间
结束时间
状态
配送员位置
配送员到起送点的距离
从起送点到目的地的距离*/

/*<tr>
 	<td>1</td>
	<td>1</td>
	<td>厦门中软海晟1楼</td>
	<td>厦门中软海晟2楼</td>
	<td>13011111111</td>
	<td>12</td>
	<td>花瓶</td>
	<td>一个大花瓶</td>
	<td class="see"><a href="">抢单</a></td>
</tr>*/
$(function(){
	//点击标签出发事件：显示所有派单信息，Dispatch
	$("#allDispatch").click(function(){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("CourierServlet.do?op=allDispatch",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'已接单':'未接单')+"</a></td>";
			});
			$("tbody").html(str);
		});
	});
	
	//点击a标签事件，显示所有待送订单，receipt表
	$("#waitSendReceipt").click(function(){
		$("thead").html("<tr><th>接单号</th><th>配送员id</th><th>派单号</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th><th>状态</th></tr>");
		$.get("CourierServlet.do?op=waitSendReceipt",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>待送</a></td>";
			});
			$("tbody").html(str);
		});
	});
	
	//点击a标签事件，显示所有待修改订单，receipt表
	$("#waitUpdateReceipt").click(function(){
		$("thead").html("<tr><th>接单号</th><th>配送员id</th><th>派单号</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th><th>状态</th></tr>");
		$.get("CourierServlet.do?op=waitUpdateReceipt",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>待修改</a></td>";
			});
			$("tbody").html(str);
		});
	});
	
})