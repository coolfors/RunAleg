/**
 * 
 */
	
function getGPS_distance() {
	
	// 百度地图API功能
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
			var beginP=document.getElementById("BeginPoint").value;
			var begins=beginP.split(",");
			//终点的经纬度
			var endP=document.getElementById("EndPoint").value;
			var ends=endP.split(",");
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
			var disId=document.getElementById("disId").value;
			var courierId=document.getElementById("courierId").value;
			//用ajax方式更新数据库
			$.get("BuildReceipt.do?op=buildReceipt&getDistance="+distanceGet+"&sendDis="+distanceSend+"&disId="+disId+"&courierId="+courierId,function (data,status) {
				
			});
			//location.href="CourierServlet.do?op=updateAdd&lng="+lng+"&lat="+lat+"&CourierId="+courierId;
			getl();
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
	function getl() {
		alert('您的位置：'+document.getElementById("lng").value+','+document.getElementById("lat").value);
	} 