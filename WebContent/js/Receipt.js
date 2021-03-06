/**
 * 前端用户界面订单的展示
 */
// 弹出模态窗获取地图
function createMapUser(disId, courierAdd) {
	setInterval(acmain,10000);
	function acmain(){
		
		// 获得
		$.get("GpsServlet.do?op=getEndAdd&disId=" + disId,
				function(data, status) {
			
			// var a="古歌华苑";
			// var b="厦门中软";
			var map = new BMap.Map("l-maps");
			map
			.centerAndZoom(
					new BMap.Point(118.10388605, 24.48923061), 11);
			var walking = new BMap.WalkingRoute(map, {
				renderOptions : {
					map : map,
					panel : "r-result",
					autoViewport : true
				}
			});
			walking.search(courierAdd, data);
		});
	}
}
$(function() {
	/**
	 * 用户界面已完成订单
	 */
	$("#completeorder")
			.click(
					function() {
						$("#headName").html("已完成的订单");
						var userId = $("#userId").val();
						$
								.ajax({
									type : "get",
									url : "rs.do?op=completeorder&userId="+userId,
									/*
									 * data: {username:$("#username").val(),
									 * content:$("#content").val() },
									 */
									dataType : "json",

									success : function(data) {
										/* $('#resText').empty(); */// 清空resText里面的所有内容
										// var html = '';
										$("thead")
												.html(
														"<tr><th>配送员id</th><th>派单号</th><th>订单号</th><th>起送时间</th><th>结束时间</th><th>状态</th></tr>");
										var jsonStr = JSON.stringify(data);
										// alert(jsonStr);
										var arr = JSON.parse(jsonStr);
										var str = "";
										$.each(arr.data, function(index, a) {
											str = str + "<tr><td>"
													+ a.courierId + "</td><td>"
													+ a.disId + "</td><td>"
													+ a.encryptionKey
													+ "</td><td>" + a.startTime
													+ "</td><td>" + a.endTime
													+ "</td><td>" + "已送达"
													+ "</a></td>";
										});
										$("tbody").html(str);
										layui
												.use(
														'laypage',
														function() {
															var laypage = layui.laypage;

															var c = arr.total;

															var l = arr.pageSize;

															var p = arr.page;

															// 执行一个laypage实例
															laypage
																	.render({
																		elem : 'test1' // 注意，这里的
																		// test1
																		// 是
																		// ID，不用加
																		// # 号
																		,
																		count : c, // 数据总数，从服务端得到
																		limit : l,
																		skip : '#5e7cdf',
																		layout : [
																				'count',
																				'prev',
																				'page',
																				'next',
																				'limit',
																				'skip',
																				'refresh' ],
																		curr : p,
																		jump : function(
																				obj,
																				first) {
																			if (!first) {
																				$
																						.ajax({
																							type : "get",
																							url : "rs.do?op=completeorder&userId="+userId+"&pageIndex="
																									+ obj.curr
																									+ "&pageSize="
																									+ obj.limit,
																							/*
																							 * data:
																							 * {username:$("#username").val(),
																							 * content:$("#content").val() },
																							 */
																							dataType : "json",
																							success : function(
																									data) {
																								/* $('#resText').empty(); */// 清空resText里面的所有内容
																								// var
																								// html
																								// =
																								// '';
																								var jsonStr = JSON
																										.stringify(data);
																								// alert(jsonStr);
																								var arr = JSON
																										.parse(jsonStr);
																								// alert(arr.page);
																								var str = "";
																								$
																										.each(
																												arr.data,
																												function(
																														index,
																														a) {
																													str = str
																															+ "<tr><td>"
																															+ a.courierId
																															+ "</td><td>"
																															+ a.disId
																															+ "</td><td>"
																															+ a.encryptionKey
																															+ "</td><td>"
																															+ a.startTime
																															+ "</td><td>"
																															+ a.endTime
																															+ "</td><td>"
																															+ "已送达"
																															+ "</a></td>";
																												});
																								$(
																										"tbody")
																										.html(
																												str);

																							}
																						});
																				// location.href
																				// =
																				// "rs.do?op=completeorder&pageIndex="+obj.curr+"&pageSize="+obj.limit;

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
	$("#dispatching")
			.click(
					function() {
						$("#headName").html("配送中的订单");
						var userId = $("#userId").val();
						$
								.ajax({
									type : "get",
									url : "rs.do?op=dispatching&userId="+userId,
									/*
									 * data: {username:$("#username").val(),
									 * content:$("#content").val() },
									 */
									dataType : "json",

									success : function(data) {
										/* $('#resText').empty(); */// 清空resText里面的所有内容
										// var html = '';
										$("thead")
												.html(
														"<tr><th>派单号</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th><th>状态</th><th>位置</th></tr>");
										var jsonStr = JSON.stringify(data);
										// alert(jsonStr);
										var arr = JSON.parse(jsonStr);
										var str = "";
										$
												.each(
														arr.data,
														function(index, a) {
															str = str
																	+ "<tr><td>"
																	+ a.disId
																	+ "</td><td>"
																	+ a.encryptionKey
																	+ "</td><td>"
																	+ a.startTime
																	+ "</td><td>"
																	+ a.endTime
																	+ "</td><td>"
																	+ a.courierAdd
																	+ "</td><td>"
																	+ a.getDistance
																	+ "</td><td>"
																	+ a.sendDistance
																	+ "</td><td><class='see'><a href=''>未配送</a></td><td><button onclick='createMapUser(\""
																	+ a.disId
																	+ "\",\""
																	+ a.courierAdd
																	+ "\")' class='\"btn btn-primary btn-lg\"'  data-toggle='modal' data-target='#myModalUser'>查看位置</button></td></tr>";
														});
										$("tbody").html(str);
										layui
												.use(
														'laypage',
														function() {
															var laypage = layui.laypage;

															var c = arr.total;

															var l = arr.pageSize;

															var p = arr.page;

															// 执行一个laypage实例
															laypage
																	.render({
																		elem : 'test1' // 注意，这里的
																		// test1
																		// 是
																		// ID，不用加
																		// # 号
																		,
																		count : c, // 数据总数，从服务端得到
																		limit : l,
																		skip : '#5e7cdf',
																		layout : [
																				'count',
																				'prev',
																				'page',
																				'next',
																				'limit',
																				'skip',
																				'refresh' ],
																		curr : p,
																		jump : function(
																				obj,
																				first) {
																			if (!first) {
																				$
																						.ajax({
																							type : "get",
																							url : "rs.do?op=dispatching&userId="+userId+"&pageIndex="
																									+ obj.curr
																									+ "&pageSize="
																									+ obj.limit,
																							/*
																							 * data:
																							 * {username:$("#username").val(),
																							 * content:$("#content").val() },
																							 */
																							dataType : "json",
																							success : function(
																									data) {
																								/* $('#resText').empty(); */// 清空resText里面的所有内容
																								// var
																								// html
																								// =
																								// '';
																								var jsonStr = JSON
																										.stringify(data);
																								// alert(jsonStr);
																								var arr = JSON
																										.parse(jsonStr);
																								// alert(arr.page);
																								var str = "";
																								$
																										.each(
																												arr.data,
																												function(
																														index,
																														a) {
																													str = str
																															+ "<tr><td>"
																															+ a.disId
																															+ "</td><td>"
																															+ a.encryptionKey
																															+ "</td><td>"
																															+ a.startTime
																															+ "</td><td>"
																															+ a.endTime
																															+ "</td><td>"
																															+ a.courierAdd
																															+ "</td><td>"
																															+ a.getDistance
																															+ "</td><td>"
																															+ a.sendDistance
																															+ "</td><td><class='see'><a href=''>未配送</a></td><td><button onclick='createMapUser(\""
																															+ a.disId
																															+ "\",\""
																															+ a.courierAdd
																															+ "\")' class='\"btn btn-primary btn-lg\"'  data-toggle='modal' data-target='#myModalUser'>查看位置</button></td></tr>";

																												});
																								$(
																										"tbody")
																										.html(
																												str);

																							}
																						});
																				// location.href
																				// =
																				// "rs.do?op=completeorder&pageIndex="+obj.curr+"&pageSize="+obj.limit;

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
	$("#allDispatch")
			.click(
					function() {
						$("#headName").html("所有订单");
						var userId = $("#userId").val();
						$
								.ajax({
									type : "get",
									url : "rs.do?op=allDispatch&userId="+userId,
									/*
									 * data: {username:$("#username").val(),
									 * content:$("#content").val() },
									 */
									dataType : "json",

									success : function(data) {
										/* $('#resText').empty(); */// 清空resText里面的所有内容
										// var html = '';
										$("thead")
												.html(
														"<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
										var jsonStr = JSON.stringify(data);
										// alert(jsonStr);
										var arr = JSON.parse(jsonStr);
										var str = "";
										$
												.each(
														arr.data,
														function(index, a) {
															str = str
																	+ "<tr><td>"
																	+ a.disId
																	+ "</td><td>"
																	+ a.userId
																	+ "</td><td>"
																	+ a.beginAdd
																	+ "</td><td>"
																	+ a.endAdd
																	+ "</td><td>"
																	+ a.disTel
																	+ "</td><td>"
																	+ a.disPrice
																	+ "</td><td>"
																	+ a.goodsType
																	+ "</td><td>"
																	+ a.disPS
																	+ "</td><td><class='see'><a href=''>"
																	+ (a.disState == 0 ? '已接单'
																			: '未接单')
																	+ "</a></td></tr>";
														});
										$("tbody").html(str);
										layui
												.use(
														'laypage',
														function() {
															var laypage = layui.laypage;

															var c = arr.total;

															var l = arr.pageSize;

															var p = arr.page;

															// 执行一个laypage实例
															laypage
																	.render({
																		elem : 'test1' // 注意，这里的
																		// test1
																		// 是
																		// ID，不用加
																		// # 号
																		,
																		count : c, // 数据总数，从服务端得到
																		limit : l,
																		skip : '#5e7cdf',
																		layout : [
																				'count',
																				'prev',
																				'page',
																				'next',
																				'limit',
																				'skip',
																				'refresh' ],
																		curr : p,
																		jump : function(
																				obj,
																				first) {
																			if (!first) {
																				$
																						.ajax({
																							type : "get",
																							url : "rs.do?op=allDispatch&userid="+userId+"&pageIndex="
																									+ obj.curr
																									+ "&pageSize="
																									+ obj.limit,
																							/*
																							 * data:
																							 * {username:$("#username").val(),
																							 * content:$("#content").val() },
																							 */
																							dataType : "json",
																							success : function(
																									data) {
																								/* $('#resText').empty(); */// 清空resText里面的所有内容
																								// var
																								// html
																								// =
																								// '';
																								var jsonStr = JSON
																										.stringify(data);
																								// alert(jsonStr);
																								var arr = JSON
																										.parse(jsonStr);
																								// alert(arr.page);
																								var str = "";
																								$
																										.each(
																												arr.data,
																												function(
																														index,
																														a) {
																													str = str
																															+ "<tr><td>"
																															+ a.disId
																															+ "</td><td>"
																															+ a.userId
																															+ "</td><td>"
																															+ a.beginAdd
																															+ "</td><td>"
																															+ a.endAdd
																															+ "</td><td>"
																															+ a.disTel
																															+ "</td><td>"
																															+ a.disPrice
																															+ "</td><td>"
																															+ a.goodsType
																															+ "</td><td>"
																															+ a.disPS
																															+ "</td><td><class='see'><a href=''>"
																															+ (a.disState == 0 ? '已接单'
																																	: '未接单')
																															+ "</a></td></tr>";
																												});
																								$(
																										"tbody")
																										.html(
																												str);

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
	 * 待配送订单 这边条件还没修改 待配送订单-dispatch中disState为0 的内容
	 */
	$("#waitSendDispatch")
			.click(
					function() {
						$("#headName").html("待配送订单");
						var userId = $("#userId").val();
						$
								.ajax({
									type : "get",
									url : "rs.do?op=waitSendDispatch&userId="+userId,
									/*
									 * data: {username:$("#username").val(),
									 * content:$("#content").val() },
									 */
									dataType : "json",

									success : function(data) {
										/* $('#resText').empty(); */// 清空resText里面的所有内容
										// var html = '';
										$("thead")
												.html(
														"<tr><th>派单id</th><th>用户id</th><th>起送地</th><th>到达地</th><th>用户联系电话</th><th>配送价格</th><th>物品类型</th><th>物品介绍</th><th>派单状态</th></tr>");
										var jsonStr = JSON.stringify(data);
										//alert("代配送：" + jsonStr);
										var arr = JSON.parse(jsonStr);
										var str = "";
										$
												.each(
														arr.data,
														function(index, a) {
															str = str
																	+ "<tr><td>"
																	+ a.disId
																	+ "</td><td>"
																	+ a.userId
																	+ "</td><td>"
																	+ a.beginAdd
																	+ "</td><td>"
																	+ a.endAdd
																	+ "</td><td>"
																	+ a.disTel
																	+ "</td><td>"
																	+ a.disPrice
																	+ "</td><td>"
																	+ a.goodsType
																	+ "</td><td>"
																	+ a.disPS
																	+ "</td><td><class='see'><a href=''>"
																	+ (a.disState == 0 ? '待配送订单'
																			: '未接单')
																	+ "</a></td></tr>";
														});
										$("tbody").html(str);
										layui
												.use(
														'laypage',
														function() {
															var laypage = layui.laypage;

															var c = arr.total;

															var l = arr.pageSize;

															var p = arr.page;

															// 执行一个laypage实例
															laypage
																	.render({
																		elem : 'test1' // 注意，这里的
																		// test1
																		// 是
																		// ID，不用加
																		// # 号
																		,
																		count : c, // 数据总数，从服务端得到
																		limit : l,
																		skip : '#5e7cdf',
																		layout : [
																				'count',
																				'prev',
																				'page',
																				'next',
																				'limit',
																				'skip',
																				'refresh' ],
																		curr : p,
																		jump : function(
																				obj,
																				first) {
																			if (!first) {
																				$
																						.ajax({
																							type : "get",
																							url : "rs.do?op=waitSendDispatch&userId="+userId+"&pageIndex="
																									+ obj.curr
																									+ "&pageSize="
																									+ obj.limit,
																							/*
																							 * data:
																							 * {username:$("#username").val(),
																							 * content:$("#content").val() },
																							 */
																							dataType : "json",
																							success : function(
																									data) {
																								/* $('#resText').empty(); */// 清空resText里面的所有内容
																								// var
																								// html
																								// =
																								// '';
																								var jsonStr = JSON
																										.stringify(data);
																								// alert(jsonStr);
																								var arr = JSON
																										.parse(jsonStr);
																								// alert(arr.page);
																								var str = "";
																								$
																										.each(
																												arr.data,
																												function(
																														index,
																														a) {
																													str = str
																															+ "<tr><td>"
																															+ a.disId
																															+ "</td><td>"
																															+ a.userId
																															+ "</td><td>"
																															+ a.beginAdd
																															+ "</td><td>"
																															+ a.endAdd
																															+ "</td><td>"
																															+ a.disTel
																															+ "</td><td>"
																															+ a.disPrice
																															+ "</td><td>"
																															+ a.goodsType
																															+ "</td><td>"
																															+ a.disPS
																															+ "</td><td><class='see'><a href=''>"
																															+ (a.disState == 0 ? '待配送订单'
																																	: '未接单')
																															+ "</a></td></tr>";
																												});
																								$(
																										"tbody")
																										.html(
																												str);

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
	$("#waitEvaluate")
			.click(
					function() {
						$("#headName").html("评价订单");
						var userId = $("#userId").val();
						$
								.ajax({
									type : "get",
									url : "us.action?op=waitEvaluate&userId="
											+ userId,
									/*
									 * data: {username:$("#username").val(),
									 * content:$("#content").val() },
									 */
									dataType : "json",

									success : function(data) {
										/* $('#resText').empty(); */// 清空resText里面的所有内容
										// var html = '';
										$("thead")
												.html(
														"<tr><th>评价id</th><th>订单号</th><th>评价分</th><th>评价信息</th><th>评价状态</th></tr>");
										var jsonStr = JSON.stringify(data);
										// alert(jsonStr);
										var arr = JSON.parse(jsonStr);
										var str = "";
										$
												.each(
														arr.data,
														function(index, a) {
															str = str
																	+ "<tr><td>"
																	+ a.evaluateId
																	+ "</td><td>"
																	+ a.receiptId
																	+ "</td><td>"
																	+ a.evaScore
																	+ "</td><td>"
																	+ a.evaInfo
																	+ "</td><td><class='see'>"
																	+ "<button  id="
																	+ a.evaState
																	+ " onclick='chaRec(this)'    >"
																	+ ((a.evaState == 0) ? "点击评价"
																			: "评价已完成")
																	+ "</button></td></tr>";
														});
										$("tbody").html(str);
										layui
												.use(
														'laypage',
														function() {
															var laypage = layui.laypage;

															var c = arr.total;

															var l = arr.pageSize;

															var p = arr.page;

															// 执行一个laypage实例
															laypage
																	.render({
																		elem : 'test1' // 注意，这里的
																		// test1
																		// 是
																		// ID，不用加
																		// # 号
																		,
																		count : c, // 数据总数，从服务端得到
																		limit : l,
																		skip : '#5e7cdf',
																		layout : [
																				'count',
																				'prev',
																				'page',
																				'next',
																				'limit',
																				'skip',
																				'refresh' ],
																		curr : p,
																		jump : function(
																				obj,
																				first) {
																			if (!first) {
																				$
																						.ajax({
																							type : "get",
																							url : "rs.do?op=waitEvaluate&userId="+userId+"&pageIndex="
																									+ obj.curr
																									+ "&pageSize="
																									+ obj.limit,
																							/*
																							 * data:
																							 * {username:$("#username").val(),
																							 * content:$("#content").val() },
																							 */
																							dataType : "json",
																							success : function(
																									data) {
																								/* $('#resText').empty(); */// 清空resText里面的所有内容
																								// var
																								// html
																								// =
																								// '';
																								var jsonStr = JSON
																										.stringify(data);
																								// alert(jsonStr);
																								var arr = JSON
																										.parse(jsonStr);
																								// alert(arr.page);
																								var str = "";
																								$
																										.each(
																												arr.data,
																												function(
																														index,
																														a) {
																													str = str
																															+ "<tr><td>"
																															+ a.evaluateId
																															+ "</td><td>"
																															+ a.receiptId
																															+ "</td><td>"
																															+ a.evaScore
																															+ "</td><td>"
																															+ a.evaInfo
																															+ "</td><td><class='see'><button  id="
																															+ a.evaState
																															+ " onclick='chaRec(this)'    >"
																															+ ((a.evaState == 0) ? "点击评价"
																																	: "评价已完成")
																															+ "</button></td></tr>";
																												});
																								$(
																										"tbody")
																										.html(
																												str);

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

$(document).ready(function() {

	$("#form_data").validate({
		// 验证规则,
		rules : {
			evaScore : {
				required : true,
				minlength : 8
			},
			creditPoint : {
				required : true,
				digits : true,
				max : 100,
				min : 0
			}
		},

		messages : {
			evaScore : {
				required : "请输入评价内容",
				minlength : "内容不少于8个字"
			},
			creditPoint : {
				required : "请输入评价分数",
				digits : "请输入分数",
				max : "最高为100分,感谢您的评价"
			}

		}
	});

});

function chaRec(e) {
	var btnValue = $(e).text();
	var evaluateId = $(e).parents("tr").find("td").eq(0).text();
	if (btnValue == "点击评价") {
		var str = "<input type='hidden' id='evaluateId' name='evaluateId'  value="
				+ evaluateId + "> "
		$("#sss").html(str);
		$('#myModal').modal('show');
	} else if (btnValue == "评价已完成") {
		alert("评价已完成，感谢您的评价");
	}

}
