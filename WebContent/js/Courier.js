/**
 * Courier查看
 */
//取货距离的方法

//	执行获取距离的动作
	function doDistance(beginAdd,endAdd,disId,courierId){
//		console.log(beginAdd);
//		console.log(endAdd);
//		console.log(disId);
//		console.log(courierId);
		$.get("BuildReceipt.do?op=buildReceipt&CourierId="+courierId+"&disId="+disId+"&beginAdd="+beginAdd+"&endAdd="+endAdd,function (data,status) {
			if(data==1){
				alert("抢单成功！");
				$("#"+disId+"").html("<font color='blue'>已抢单</font>");
			}else{
				alert("抢单失败，下次出手快点！");
				$("#"+disId+"").html("<font color='red'>抢单失败</font>");
			}
		});
        
        //搜索起始位置和结束位置
        localSearch.search([beginPos,endPos]);
        
	}
// 弹出模态窗获取地图
function createMapGet(disId,courierAdd){
	//获得
	$.get("GpsServlet.do?op=getBeginAdd&disId="+disId,function(data,status){
		
//		var a="古歌华苑";
//		var b="厦门中软";
		var map = new BMap.Map("l-maps");
		map.centerAndZoom(new BMap.Point(118.10388605,24.48923061), 11);
		var walking = new BMap.WalkingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});
		walking.search(courierAdd, data);
	});
}
function createMapSend(disId,courierAdd){
	//获得
	$.get("GpsServlet.do?op=getEndAdd&disId="+disId,function(data,status){
		
//		var a="古歌华苑";
//		var b="厦门中软";
		var map = new BMap.Map("l-maps");
		map.centerAndZoom(new BMap.Point(118.10388605,24.48923061), 11);
		var walking = new BMap.WalkingRoute(map, {renderOptions: {map: map, panel: "r-result", autoViewport: true}});
		walking.search(courierAdd, data);
	});
}
/*//送货距离的方法
function sendDistanceGPS(beginPos,endPos,disId,courierId){
	//创建一个地图实例
	var map = new BMap.Map("map");
    //设置搜索结束时的回调函数
    localSearch.setSearchCompleteCallback(function (searchResult) {
    	var pois=new Array();
    	for(var i=0;i<=1;i++){
        	//获取搜索结果
            var poi = searchResult[i].getPoi(0);
            //创建标注
            var marker = new BMap.Marker(poi.point);
            //存储点
            pois.push(poi.point);
            //添加覆盖物
            map.addOverlay(marker);  
    	}
        //计算两点之间距离
        //$("input[name='distance']").val((map.getDistance(pois[0],pois[1])).toFixed(2)+'米');
    	var distance=map.getDistance(pois[0],pois[1]).toFixed(2);
    	$.get("CourierServlet.do?op=updateAdd&add="+add+"&CourierId="+courierId,function (data,status) {
			
		});
    });
    //搜索起始位置和结束位置
    localSearch.search([beginPos,endPos]);
    
}

function doDistance(beginAdd,endAdd,disId,courierId){
	$.get("BuildReceipt.do?op=buildReceipt&CourierId="+courierId+"&disId="+disId,function (data,status) {
		getDistanceGPS(data,beginAdd);
		sendDistanceGPS(beginAdd,endAdd);
	});
}*/




$(function(){
	
	

	
	/*$(document).ready(function() {
		getallDis(1,4);
	})*/
	//点击标签出发事件：显示所有派单信息，Dispatch
	$("#allDispatch").click(function(){
		$("#headName").html("所有订单");
		$.ajax({//test
            type: "get",
            url: "CourierServlet.do?op=allDispatch",
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
   			var courierId=$("#CourierId").val();
        		var str = "";
   			$.each(arr.data, function(index,a){
				//str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a id='"+a.disId+"' href='#' onclick='getDistance('"+a.beginAdd+"','"+a.endAdd+"','"+a.disId+"','"+courierId+"')'>"+"未接单"+"</a></td></tr>";
   				
   				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a id='"+a.disId+"' href='#' onclick='doDistance(\""+a.beginAdd+"\",\""+a.endAdd+"\",\""+a.disId+"\",\""+courierId+"\")'>"+"未接单"+"</a></td></tr>";
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
   					             url: "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit,
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
   					 				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a id='"+a.disId+"' href='#' onclick='doDistance(\""+a.beginAdd+"\",\""+a.endAdd+"\",\""+a.disId+"\",\""+courierId+"\")'>"+"未接单"+"</a></td></tr>";
   					    			});
   					    			$("tbody").html(str);
   					    			
   					             }
   					         });
   							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
   							
   						}
   					}
   				});
   			});
            }
        });
	});
	/**
	 * 用于ajax遍历sendreceipt表的方法waitSendReceipt
	 */
	
	//点击a标签事件，显示所有待送订单，receipt表
	$("#waitSendReceipt").click(function(){
		$("#headName").html("待送订单");
		
		var courierId=$("#CourierId").val();
		
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=waitSendReceipt&courierId="+courierId,
            /*data: {username:$("#username").val(),
            content:$("#content").val()
               },*/
            dataType: "json",
            success: function(data){
                       /* $('#resText').empty();*/   //清空resText里面的所有内容
                        //var html = ''; 
            	$("thead").html("<tr><th>派单号</th><th>收货人电话</th><th>发货人电话</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th><th>状态</th><th>查看位置</th></tr>");var jsonStr=JSON.stringify(data);
        		var courierId=$("#CourierId").val();
        		//alert(jsonStr);
        		var jsonStr=JSON.stringify(data);
   			var arr = JSON.parse(jsonStr);
        		var str = "";
        		
   			$.each(arr.data, function(index,a){
   				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>未配送</a></td><td><button onclick='createMapGet(\""+a.disId+"\",\""+a.courierAdd+"\")' class='\"btn btn-primary btn-lg\"'  data-toggle='modal' data-target='#myModal'>查看位置</button></td></tr>";
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
   					             url: "CourierServlet.do?op=waitSendReceipt&pageIndex="+obj.curr+"&pageSize="+obj.limit,
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
   					    				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>未配送</a></td><td><button onclick='createMapGet(\""+a.disId+"\",\""+a.courierAdd+"\")' class='\"btn btn-primary btn-lg\"'  data-toggle='modal' data-target='#myModal'>查看位置</button></td></tr>";});
   					    			$("tbody").html(str);
   					    			
   					             }
   					         });
   							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
   							
   						}
   					}
   				});
   			});
            }
        });
	});
	//显示所有配送中的订单，有手机号码
	$("#sendReceipt").click(function(){
	
		var courierId=$("#CourierId").val();
		
		$("#headName").html("配送中的订单");
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=sendReceipt&courierId="+courierId,
            data: {username:$("#username").val(),
            content:$("#content").val()
               },
            dataType: "json",
            success: function(data){
            	$("thead").html("<tr><th>派单号</th><th>收货人电话</th><th>发货人电话</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th><th>状态</th><th>查看位置</th></tr>");
        		var jsonStr=JSON.stringify(data);
        		//alert(jsonStr);
   			var arr = JSON.parse(jsonStr);
        		var str = "";
   			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td><td><button onclick='createMapSend(\""+a.disId+"\",\""+a.courierAdd+"\")' class='\"btn btn-primary btn-lg\"'  data-toggle='modal' data-target='#myModal'>查看位置</button></td></tr>";
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
   					             url: "CourierServlet.do?op=sendReceipt&pageIndex="+obj.curr+"&pageSize="+obj.limit,
   					            
   					             dataType: "json",
   					             success: function(data){
   					                         $('#resText').empty();   //清空resText里面的所有内容
   					                         //var html = ''; 
   					         		var jsonStr=JSON.stringify(data);
   					         		//alert(jsonStr);
   					    			var arr = JSON.parse(jsonStr);
   					    			//alert(arr.page);
   					         		var str = "";
   					    			$.each(arr.data, function(index,a){
   					 				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td><td><button onclick='createMapSend(\""+a.disId+"\",\""+a.courierAdd+"\")' class='\"btn btn-primary btn-lg\"'  data-toggle='modal' data-target='#myModal'>查看位置</button></td></tr>";
   					    				   					    			});
   					    			$("tbody").html(str);
   					    			
   					             }
   					         });
   							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
   							
   						}
   					}
   				});
   			});
            }
        });
	});   
	
	/**
	 * 设置一个用于遍历waitreceipt的函数waitUpdateReceipt
	 */
	/*//点击a标签事件，显示所有配送中订单，receipt表
	$("#waitUpdateReceipt").click(function(){
		$("#headName").html("配送中的订单");
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=waitUpdateReceipt",
            data: {username:$("#username").val(),
            content:$("#content").val()
               },
            dataType: "json",
            success: function(data){
                        $('#resText').empty();   //清空resText里面的所有内容
                        //var html = ''; 
            	$("thead").html("<tr><th>接单号</th><th>配送员id</th><th>派单号</th><th>订单号加密码</th><th>起送时间</th><th>结束时间</th><th>配送员位置</th><th>配送员到起送点的距离</th><th>从起送点到目的地的距离</th><th>状态</th></tr>");
        		var jsonStr=JSON.stringify(data);
        		//alert(jsonStr);
   			var arr = JSON.parse(jsonStr);
        		var str = "";
   			$.each(arr.data, function(index,a){
				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td></tr>";
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
   					             url: "CourierServlet.do?op=waitUpdateReceipt&pageIndex="+obj.curr+"&pageSize="+obj.limit,
   					             data: {username:$("#username").val(),
   					             content:$("#content").val()
   					                },
   					             dataType: "json",
   					             success: function(data){
   					                         $('#resText').empty();   //清空resText里面的所有内容
   					                         //var html = ''; 
   					         		var jsonStr=JSON.stringify(data);
   					         		//alert(jsonStr);
   					    			var arr = JSON.parse(jsonStr);
   					    			//alert(arr.page);
   					         		var str = "";
   					    			$.each(arr.data, function(index,a){
   					 				str = str + "<tr><td>"+a.receiptId+"</td><td>"+a.courierId+"</td><td>"+a.disId+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td></tr>";
   					    				   					    			});
   					    			$("tbody").html(str);
   					    			
   					             }
   					         });
   							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
   							
   						}
   					}
   				});
   			});
            }
        });
	});*/
	/**
	 * 设置一个用于遍历waitEvaluate的函数waitEvaluate
	 */
	//点击a标签事件，显示所有未评价订单，evaluate表
	$("#waitEvaluate").click(function(){
		$("#headName").html("待评价订单");
		var courierId=$("#CourierId").val();
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=waitEvaluate&courierId="+courierId,
            /*data: {username:$("#username").val(),
            content:$("#content").val()
               },*/
            dataType: "json",
            success: function(data){
                       /* $('#resText').empty();*/   //清空resText里面的所有内容
                        //var html = ''; 
            	$("thead").html("<tr><th>评价id</th><th>订单号</th><th>评价状态</th></tr>");
        		var jsonStr=JSON.stringify(data);
        		//alert(jsonStr);
   			var arr = JSON.parse(jsonStr);
        		var str = "";
   			$.each(arr.data, function(index,a){
   				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td><class='see'><a href=''>未评价</a></td></tr>";
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
   					             url: "CourierServlet.do?op=waitEvaluate&pageIndex="+obj.curr+"&pageSize="+obj.limit,
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
   							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
   							
   						}
   					}
   				});
   			});
            }
        });
	});
	/**
	 * 设置一个用于遍历overEvaluate的函数overEvaluate
	 */
	//点击a标签事件，显示所有已评价订单，evaluate表
	$("#overEvaluate").click(function(){
		$("#headName").html("已评价订单");
		var courierId=$("#CourierId").val();
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=overEvaluate&courierId="+courierId,
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
   				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>已评价</a></td></tr>";
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
   					             url: "CourierServlet.do?op=overEvaluate&pageIndex="+obj.curr+"&pageSize="+obj.limit,
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
   					    				str = str + "<tr><td>"+a.evaluateId+"</td><td>"+a.receiptId+"</td><td>"+a.evaScore+"</td><td>"+a.evaInfo+"</td><td><class='see'><a href=''>已评价</a></td></tr>";
   					    				});
   					    			$("tbody").html(str);
   					    			
   					             }
   					         });
   							//location.href = "CourierServlet.do?op=allDispatch&pageIndex="+obj.curr+"&pageSize="+obj.limit;
   							
   						}
   					}
   				});
   			});
            }
        });
	});
	
	
	
	
	
})