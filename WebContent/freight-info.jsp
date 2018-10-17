<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/logo.ico">
<title>快递侠-首页</title>
<meta name="description" content="快递侠实现了跑腿代跑和威客任务的实时连接，通过互联网服务于跑男和兼职群体。坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！">
<meta name="keywords" content="物流,跑腿,跑男,快递侠">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css">
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/LocationRange.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/freight-info.css">
<!-- 引入地图js -->
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>  
<script src="http://api.map.baidu.com/api?v=2.0&ak=Dc8o3GUube9RVOhmeuuhfNL9QRyzhuaj" type="text/javascript"></script>
  <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
<![endif]-->

</head>
<body>
<!--顶部-开始-->
<div style=" background:#EBEBEB; width:100%; height:80px; line-height:80px;">
    <div class="container">
        <div class="row">
            <span class="col-sm-7 col-sm-offset-1 col-xs-6 col-xs-offset-1"><img src="images/logo.png" class="img-responsive" alt="新广货运联盟"></span>
            <span class="col-sm-4 col-xs-5" style="float:right">
            	<a href="modify data.html" target="_blank" style="display:none">su23c0e</a>
                <a href="" style="display:none">退出</a>
            </span>
            <span class="col-sm-4 col-xs-5" style="float:right">
            	<c:if test="${sessionScope.User==null }">
						<a href="login.html" target="_blank" id="login">登录</a>&nbsp; <a
						href="register.html" target="_blank" id="reg">注册</a>
					</c:if>
					<c:if test="${sessionScope.User!=null }">
						<ul class="right navbar-nav">
							<li class="dropdown"><a href="" class="dropdown-toggle" data-toggle="dropdown">
								${sessionScope.User.userName}
								<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="userMessage.jsp">个人信息</a></li>
									<li><a href="#">余额充值</a></li>								
									<li><a href="LoginServlet.do?op=exchange">退出账号</a></li>
								</ul></li>
						</ul>	
					</c:if>
            </span>
        </div>
    </div>
</div>
<!--顶部-结束-->

<!--导航-开始-->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">首页</a></li>
                <c:if test="${sessionScope.User==null}">
					<li><a href="login.html">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==1}">
					<li><a href="user-order-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
				<c:if test="${sessionScope.User.userType==2}">
					<li><a href="courier-main.jsp">跑腿吧<span class="sr-only"></span></a></li>
				</c:if>
                <li class="active" class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">发布跑腿<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="freight-info.jsp">信息发布</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">帮助<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="driving-knowledge.jsp">如何下单</a></li>
                    </ul>
                </li>
                <li><a href="alliance.jsp">关于我们</a></li>
                <li><a href="contact-us.jsp">联系我们</a></li>
            </ul>
        </div>
    </div>
</nav>
<!--导航-结束-->


<div class="container biao">
    <div style="border:1px solid #F5841C; margin-left:0; margin-right:0;">
         <ul class="new_tab_ul row">
             <li class="new_tab_f hover col-lg-6 col-md-6 col-sm-6" id="one1" style="background:#fff;" onclick="setTab(&#39;one&#39;,1,2)">
            	 <a href="javascript:;" style="color:#F5841C;">发布代跑腿</a>
             </li>
             <li class="new_tab_f col-lg-6 col-md-6 col-sm-6" id="one2" onclick="setTab(&#39;one&#39;,2,2)">
         		 <a href="javascript:;">如何填写下单</a>
             </li>
         </ul>
         <div class="row">
            <!--货源发布-->
            <div class="new_tab_div" id="list_one1">
            	<form action="" method="post" class="bd">
                    <div class="form-group row">
                        <label class="col-sm-2 control-label"><span>*&nbsp;</span>起送地</label>
                        <div class="list_div area-wraper col-sm-4">
                           <input  type="text" id="begincity" name="begincity" class="list_select form-control" value="" placeholder="出发城市">
                        </div>
                        <label class="col-sm-2 control-label">到达地</label>
                        <div class="list_div list_div_last col-sm-4">
                            <input type="text" id="get_addr" name="get_addr" class="list_select1 form-control" value="" placeholder="目的地详细地址">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label"><span>*&nbsp;</span>物品介绍</label>
                        <div class="list_div list_div_last col-sm-4">
                            <input type="text" class="form-control" name="goodstype" id="goodstype" value="" placeholder="请填写货物名称">
                        </div>
                        <label class="col-sm-2 control-label">联系电话</label>
                       
                        <div class="list_div col-sm-2">
                            <input name="weight_unit" maxlength="11" id="weight" class="form-control" type="tel" value="" placeholder="填写阿拉伯数字">
                        </div>
                    </div>
                   
                     <div class="form-group row">
                        <label class="col-sm-2 control-label"><span>*&nbsp;</span>物品类型</label>
                        <div class="list_div list_div_last col-sm-4">
                            <select name="car_num" id="car_num" class="list_type form-control">
                                <option value="请选择" selected>请选择</option>
                                <option value="1">美食</option>
                                <option value="2">文件</option>
                                <option value="3">蛋糕</option>
                                <option value="4">手机</option>
                                <option value="5">钥匙</option>
                                <option value="6">鲜花</option>
                                
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">小费</label>
                        <div class="list_div col-sm-4">
                            <input name="weight_unit" type="text" class="form-control" placeholder="请输入运费金额">
                        </div>
                    </div>
                    
                    <div class="new_tab_bottom form-group row">
                        <input class=" btn btn-info col-sm-1 col-sm-offset-9" type="submit" value="下单并付款">
                        <input class=" btn btn-warning col-sm-1" type="reset" value="重置">
                    </div>
                </form>
            </div>
            <!--车源发布-->
            <div class="new_tab_div" style="display:none" id="list_one2">
            	<ul>
            	<li class="row">
                	<a href="driving-kn-details.jsp" class="col-sm-10">李克强:加快新旧动能转换</a><span class="col-sm-2" style=" float:right">2016-02-14</span>
                </li>
                <li class="row">
                	<a href="driving-kn-details.jsp" class="col-sm-10">李克强:加快新旧动能转换</a><span class="col-sm-2" style=" float:right">2016-02-14</span>
                </li>
                <li class="row">
                	<a href="driving-kn-details.jsp" class="col-sm-10">李克强:加快新旧动能转换</a><span class="col-sm-2" style=" float:right">2016-02-14</span>
                </li>
                <li class="row">
                	<a href="driving-kn-details.jsp" class="col-sm-10">李克强:加快新旧动能转换</a><span class="col-sm-2" style=" float:right">2016-02-14</span>
                </li>
                <li class="row">
                	<a href="driving-kn-details.jsp" class="col-sm-10">李克强:加快新旧动能转换</a><span class="col-sm-2" style=" float:right">2016-02-14</span>
                </li>
            </ul>
			</div>
                </div>
            </div>
         </div> 
    <div class="container row">
    	<p style="text-align:right; color:red; margin-right:15px;">* 发布的信息只保留15天！</p>
    </div>

<!--尾部-开始-->
<div class="footer" style="background:#525252; width:100%; padding-bottom:20px; margin-top:30px;">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <p>友情链接</p>
                <hr>
                <ul>
                   <li><a href="" target="_blank">中国物流网</a></li>
                   <li><a href="" target="_blank">中国物流网</a></li>
                   <li><a href="" target="_blank">中国物流网</a></li>
                </ul>
            </div>
            <div class="col-sm-4">
                <p>快递侠</p>
                <hr>
                <p>快递侠成立于2018年，是一家专业提供跑腿业务的平台。</p>
                <p>快递侠的跑腿业务提供一个平台给任何普通用户以及需要兼职的用户群体。</p>
                <p>快递侠坚持社会效益始终第一的原则，服务质量期待你的关注，希望一路与你同行，共创美好的未来！</p>
            </div>
            <div class="col-sm-4">
                <p><a href="register.html">加入跑男</a> | <a href="contact-us.jsp">联系我们</a></p>
                <hr>
                <p>咨询电话：13015962382</p>
                <p>邮箱：coolfors@163.com</p>
                <p>地址：厦门市软件园</p>
            </div>
            <div class="col-sm-12 text-center" style="margin-top:20px;">
            	Copyright ©  快递侠 版权所有 Power by 快递侠
            </div>
        </div>
    </div>
</div>
<!--尾部-结束-->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">  

</script>  
<script type="text/javascript">
    /*  定位*/
    $(function(){  
    $("#begincity").click(function(){    
        //创建百度地图控件  
        var geolocation = new BMap.Geolocation();  
        geolocation.getCurrentPosition(function(r){  
            if(this.getStatus() == BMAP_STATUS_SUCCESS){  
                //以指定的经度与纬度创建一个坐标点  
                var pt = new BMap.Point(r.point.lng,r.point.lat);  
                //创建一个地理位置解析器  
                var geoc = new BMap.Geocoder();  
                geoc.getLocation(pt, function(rs){//解析格式：城市，区县，街道  
                    var addComp = rs.addressComponents;  
                    
         $("#begincity").val(addComp.city + ", " + addComp.district + ", " + addComp.street)
                });      
            }  
            else {  
                $(ev.currentTarget).text('定位失败');  
            }          
        },{enableHighAccuracy: true})//指示浏览器获取高精度的位置，默认false  
        
    });  
});  
    var app_url ='';
    function setTab(name,cursel,n){
		for(i=1;i<=n;i++){
			if(cursel==i){
			   $('#'+name+i).attr("class","hover");
			   $('#'+name+i).css("background","#fff");
			   $('#'+name+i+" a").css("color","#F5841C");
			   $('#list_'+name+i).css("display","block");
			 }else{
			   $('#'+name+i).attr("class","");
			   $('#'+name+i).css("background","#F5841C");
			   $('#'+name+i+" a").css("color","#fff");
			   $('#list_'+name+i).css("display","none");
			 }
		}
}

    function setTab2(name,cursel,n){
		for(i=1;i<=n;i++){
			if(cursel==i){
			   $('#'+name+i).attr("class","tit_hover");
			   $('#'+name+i+" a").css("color","#29a25b");
			   $('#list_'+name+i).css("display","block");
			 }else{
			   $('#'+name+i).attr("class","");
			   $('#'+name+i+" a").css("color","#fff");
			   $('#list_'+name+i).css("display","none");
			 }
		}
}

	$(function(){
      $('.denglu').click(function(){
           $('.head').toggle();
		   
		   
	    });   
	  $('.guanbi').click(function(){
           $('.head').hide();
	    });
	 $('.guanbi1').click(function(){
           $('.header').hide();
	    });
      $('.chaxun').click(function(){
           var  search_begincity = $('#search_begincity').val();
		   var  search_endcity = $('#search_endcity').val();
		   if(search_begincity.length <= 0 &&search_endcity.length <= 0 ){
			    $('#demo1').show().html("<div style='font-size:12px; color:#50B1E3; line-height:24px; padding-left:20px;'>请输入出发城市或到达城市！</div>");
				return false;
			}
		   
		   var  type = $('#type').val();
		    $.post(app_url+"goods/",{num:0,type:type,search_begincity:search_begincity,search_endcity:search_endcity},function(data){
				if(data.resid){
						  $('#demo1').html(data.msg);
					}
				},'json');
	   
	    });
		
		$('#huo1').click(function(){
			$.post(app_url+"goods/",{num:0,type:8},function(data){
			if(data.resid){
					  $('#demo1').html(data.msg);
				}
			},'json');

		});
		
		$('#huo2').click(function(){
			var num = 0;
			$.post(app_url+"carlist/",{type:6},function(data){
				if(data.resid){
				    $('#demo2').html(data.msg);	
					}
				},'json');
		});
		$('#huo3').click(function(){
			var num = 0;
			$.post(app_url+"goods/",{type:1,num:0},function(data){
				if(data.resid){
				    $('#demo3').html(data.msg);	
					}
				},'json');
		});
		$('#huo4').click(function(){
			var num = 0;
			$.post(app_url+"carlist/",{type:1},function(data){
				if(data.resid){
				    $('#demo4').html(data.msg);	

					}
				},'json');
		});
		$('#huo5').click(function(){
			var num = 0;
			$.post(app_url+"carlist/",{type:2},function(data){
				if(data.resid){
				    $('#demo5').html(data.msg);	

					}
				},'json');
		});
		$('#huo6').click(function(){
			var num = 0;
			$.post(app_url+"goods/",{num:0,type:2},function(data){
				if(data.resid){
				    $('#demo6').html(data.msg);	

					}
				},'json');
		});		

		$('input').focus(function(){  
		   $(this).attr('placeholder','');
		})	
		$('.tp_bk_1').mouseover(function(){  	   
				 $(this).attr('class','tp_bk'); 
		});
		
       	$('.tp_bk_1').mouseout(function(){  
             $(this).attr('class','tp_bk_1'); 
		});
		   
		$('input').blur(function(){
			 var numb = $("#mobile").val();
			 var verify = $("#verify").val();
			 var code = $("#code").val();
			 var mobileno = $("#mobileno").val();
			 var goodstype = $("#goodstype").val();
			 if(mobileno == ''){
				$("#mobileno").attr('placeholder','请输入您的手机号');
			 }
			 if(numb == ''){
				$("#mobile").attr('placeholder','请输入您的手机号');
			 }
			 if(code == ''){
				$("#code").attr('placeholder','请输入验证码');
			 }
			 if(verify == ''){
				$("#verify").attr('placeholder','请输入验证码');
			 } 
		});
		

		$('.btnLogin,#btnLogin').click(function(){
   
			var mobileno = $('#mobileno').val();
			var begincity = $('#begincity').val();
			var endcity = $('#endcity').val();
			var get_addr = $('#get_addr').val();
			var put_addr = $('#put_addr').val();
			var endmobile = $('#endmobile').val();
			var goodstype = $('#goodstype').val();
			var yan_code = $('#yan_code').val();
			var verify = $('#car_verify').val();
             
		   
			if(begincity.length <= 0){
			    $('.begincity').show();
				$('#begincity').focus();
				return false;
			}else{
			    $('.begincity').show();
			}
			if(endcity.length <= 0){
				$('.endcity').show();
				$('#endcity').focus();
				return false;
			}else{
			    $('.endcity').hide();
			}
			
			if(goodstype.length <= 0){
			    $('.goodstype').show().html("货物名称不能为空");
				$('#goodstype').focus();
				return false;
			}else{
			    $('.good_stype').hide();
			}
			if(mobileno.length != 11){
				$('.mobileno').show().html("发货人电话不能为空");
				$('#mobileno').focus();
				return false;
			}else{
			    $('.mobileno').hide();
			}

			if(yan_code.length != 4){
			    $('.header').show();
				$('#car_mobileno').attr("value",mobileno);
				$('#btnLogin').attr("class","btnLogin");
				$('#yan_code').focus();
				return false;
			}else{
			    $('.yan_code').hide();
			}
			

			if(verify.length != 4){
			    $('.ve_rify').show();
				$('#car_verify').focus();
				return false;
			}else{
			    $('.ve_rify').hide();
			}
				$.post(app_url+"goods_send/",{mobileno:mobileno,get_addr:get_addr,put_addr:put_addr,endmobile:endmobile,begincity:begincity,endcity:endcity,verify:verify,goodstype:goodstype,ips:"61.52.245.52"},function(data){
				if(data.resid==1){
				    $('.header').hide();
					$('.btn_Login').html(data.msg);
				    $('.new_importance_tab').append(data.xinxi);
					//$('#items_denglu').html(denglu);
				}else if(data.resid==2){
				    $('.mobileno').show().html(data.msg);
					
				}else{
				    $('.mobileno').show().html(data.msg);
					
				}
			},'json');
			
			 var wait=100; 
             time(this);
			 function time(o) { 
                if (wait == 0) { 
                    o.removeAttribute("disabled");           
                    o.value="发布货源"; 
                    wait = 100; 
                } else { 
                    o.setAttribute("disabled", true); 
                    o.value=wait+"秒可再次发货"; 
                    wait--; 
                    setTimeout(function() { 
                        time(o) 
                    }, 
                    1000) 
                } 
               }
			
		});
		
 	$('.car_btnLogin').click(function(){
			var mobileno = $('#car_mobileno').val();
			var begincity = $('#car_begincity').val();
			var endcity = $('#car_endcity').val();
			var mob = $('#mob').val();
			if(begincity.length <= 0){
				$('.city').show().html("出发城市不能为空！");
				$('#car_begincity').focus();
				return false;
			}else{
			      $('.city').hide();
			}
			if(endcity.length <= 0){
				$('.city').show().html("到达城市不能为空！");
				$('#car_endcity').focus();
				return false;
			}else{
			      $('.city').hide();
			}
			
			
			if(runtime.length <= 0){
				$('.runtime').show().html("发车时间不能为空!");
				$('#runtime').focus();
				return false;
			}else{
			    $('.runtime').hide();
			}
			
			
			if(mobileno.length != 11){
				$('.header').show();
				$('#car_mobileno').attr("value",mob);
				$('#btnLogin').attr("id","");
				return false;
			}	
			
			
						
			$.post(app_url+"car_send/",{mobileno:mobileno,begincity:begincity,endcity:endcity,verify:verify,cartype:cartype,car_num:car_num,carlength:carlength,weight:weight,
				weight_unit:weight_unit,volume:volume,runtime:runtime,ips:"61.52.245.52"},function(data){
				if(data.resid==1){
					$('.header').hide();
				    $('.new_importance_tab').append(data.xinxi);
				}else if(data.resid==2){
                    $('.runtime').show().html(data.msg);
				    $('.yz_ts').show().html(data.msg);
				}else{
				    $('.yz_ts').show().html(data.msg);
					$('.runtime').show().html(data.msg);
					
				}
			},'json');
		});
		
		
})
	function gb(){ 
		$('#tc').hide();	
		window.location.href=app_url;	
	}	
	
	function msn(){
		var mobile = $('#car_mobileno').val();
		var yan_code = $('#yan_code').val();
		if(mobile.length != 11){
			$('.yz_ts').show().html("手机号码输入错误！");
			$('#mobile').focus();
			return false;
		}
        $.post(app_url+"msn/",{mobile:mobile,yan_code:yan_code},function(data){
			if(data.resid==3){
				$('.yz_ts').show().html(data.msg);
			}else{	
				$('.yz_ts').show().html(data.msg);
			}
		},'json');
	}
	
		function dl_msn(){
		var mobile = $('#dl_mobileno').val();
		var yan_code = $('#dl_code').val();
		if(mobile.length != 11){
			$('.dl_yz_ts').show().html("手机号码输入错误！");
			$('#dl_mobileno').focus();
			return false;
		}
        $.post(app_url+"msn/",{mobile:mobile,yan_code:yan_code},function(data){
			if(data.resid==3){
				$('.dl_yz_ts').show().html(data.msg);
			}else{	
				$('.dl_yz_ts').show().html(data.msg);
			}
		},'json');
	}
</script> 
<script src="js/jquery_002_002.js" type="text/javascript"></script> 
<script src="js/areaData1.js" type="text/javascript"></script> 
<script src="js/LocationRange.js" type="text/javascript"></script> 
<script src="js/jquery_003.js" type="text/javascript"></script> 
</body>
</html>