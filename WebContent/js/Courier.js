/**
 * Courier查看
 */



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
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a id='"+a.disId+"' href='#' onclick='getDistance("+a.beginAdd+","+a.endAdd+","+a.disId+","+courierId+")'>"+"未接单"+"</a></td></tr>";
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
   					 				str = str + "<tr><td>"+a.disId+"</td><td>"+a.userId+"</td><td>"+a.beginAdd+"</td><td>"+a.endAdd+"</td><td>"+a.disTel+"</td><td>"+a.disPrice+"</td><td>"+a.goodsType+"</td><td>"+a.disPS+"</td><td><class='see'><a id='"+a.disId+"' href='#' onclick='getDistance("+a.beginAdd+","+a.endAdd+","+a.disId+","+courierId+")'>"+"未接单"+"</a></td></tr>";
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
   			var arr = JSON.parse(jsonStr);
        		var str = "";
   			$.each(arr.data, function(index,a){
   				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>未配送</a></td><td><button href=''>查看位置</button></td></tr>";
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
   					    				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>未配送</a></td><td><button href=''>查看位置</button></td></tr>";});
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
				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td><td><button href=''>查看位置</button></td></tr>";
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
   					 				str = str + "<tr><td>"+a.disId+"</td><td>"+a.disTel+"</td><td>"+a.userTel+"</td><td>"+a.encryptionKey+"</td><td>"+a.startTime+"</td><td>"+a.endTime+"</td><td>"+a.courierAdd+"</td><td>"+a.getDistance+"</td><td>"+a.sendDistance+"</td><td><class='see'><a href=''>配送中</a></td><td><button href=''>查看位置</button></td></tr>";
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
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=waitEvaluate",
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
		$.ajax({
            type: "get",
            url: "CourierServlet.do?op=overEvaluate",
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
	function getDistance(beginAdd,endAdd,disId,courierId) {
		/*$.get("GpsServlet.do?op=getDistance&beginAdd="+beginAdd+"&endAdd="+endAdd+"&disId="+disId+"&courierId="+courierId,function (data,status) {
			if(status==success){
				if(data==1){
					alert("抢单成功!");
					$("#"+disId+"").html("<font color = 'blue'>抢单成功</font>");
				}else{
					alert("抢单失败，下次出手快点哦！");
					$("#"+disId+"").html("<font color = 'red'>抢单失败</font>");
				}
			}
		});*/
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(116.331398,39.897445);
		map.centerAndZoom(point,12);
		
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(function(r){
			if(this.getStatus() == BMAP_STATUS_SUCCESS){
				var mk = new BMap.Marker(r.point);
				map.addOverlay(mk);
				map.panTo(r.point);
				// 经度：r.point.lng
				//纬度：r.point.lat 
				//alert('您的位置：'+r.point.lng+','+r.point.lat);
				//获取经纬度
				var lng=r.point.lng;
				var lat=r.point.lat;
				//起点的经纬度
				//var beginP=document.getElementById("BeginPoint").value;
				var begins=beginAdd.split(",");
				//终点的经纬度
				//var endP=document.getElementById("EndPoint").value;
				var ends=endAdd.split(",");
				//骑手位置的经纬度
				var courP=document.getElementById("CourierPoint").value;
				var cours=endP.split(",");
				//构建起点map
				var pointA=new BMap.Point(begins[0],begins[1]);
				//构建终点map
				var pointB=new BMap.Point(ends[0],end[1]);
				//构建派送员map
				var pointC=new BMap.Point(cours[0],cours[1]);
				//计算配送员到取货地点的距离
				var distanceGet=(map.getDistance(pointC,pointA)).toFixed(2);
				//计算取货地点到终点的距离
				var distanceSend=(map.getDistance(pointA,pointB)).toFixed(2);
				//获取disId
				/*var disId=document.getElementById("disId").value;
				var courierId=document.getElementById("courierId").value;*/
				//用ajax方式更新数据库
				$.get("BuildReceipt.do?op=buildReceipt&getDistance="+distanceGet+"&sendDistance="+distanceSend+"&disId="+disId+"&courierId="+courierId,function (data,status) {
					if(status==success){
						if(data==true){
							alert("抢单成功!");
							$("#"+disId+"").html("<font color = 'blue'>抢单成功</font>");
						}else{
							alert("抢单失败，下次出手快点哦！");
							$("#"+disId+"").html("<font color = 'red'>抢单失败</font>");
						}
					}
				});
				//location.href="CourierServlet.do?op=updateAdd&lng="+lng+"&lat="+lat+"&CourierId="+courierId;
				//getl();
			}
			else {
				alert('failed'+this.getStatus());
			}        
		},{enableHighAccuracy: true})
		//关于状态码
		//BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
		//BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
		//BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
		//BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
		//BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
		//BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
		//BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
		//BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
		//BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
		var indoorManager = new BMapLib.IndoorManager(map);
	}
	
	
	
	
})