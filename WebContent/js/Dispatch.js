/**
 * 派单显示
 */
/*<tr>
	<th>派单id</th>
	<th>用户id</th>
	<th>起送地</th>
	<th>到达地</th>
	<th>用户联系电话</th>
	<th>配送价格</th>
	<th>物品类型</th>
	<th>物品介绍</th>
	<th>派单状态</th>
</tr>*/
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
	//点击标签出发事件：显示所有派单信息
	$("#allDispatch").click(function(){
		$("thead").html("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("DispatchServlet.do?op=allDispatch",function(data,status){
			var arr = JSON.parse(data);
			var str = "";
			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a href=''>"+(a.disState==0?'已接单':'未接单')+"</a></td>";
			});
			$("tbody").html(str);
		});
	});
})