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
	$("#allDispatch").click(function(){
		
		$("thead").append("<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
		$.get("DispatchServlet.do?op=allDispatch",function(data,status){
			var arr = JSON.parse(data);
			$.each(arr.data, function(index,a){
				$("tbody").append("<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td>"+a.disState+"</td><td><class='see'><a href=''></a></td>");
			});
		});
	});
})