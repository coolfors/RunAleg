package com.kdx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdx.entity.Courier;
import com.kdx.service.AffairService;
import com.kdx.service.CourierService;
import com.kdx.serviceImpl.AffairServiceImpl;
import com.kdx.serviceImpl.CourierServiceImpl;
import com.kdx.util.TurnMap;

/**
 * Servlet implementation class BuildReceipt
 */
@WebServlet("/BuildReceipt.do")
public class BuildReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildReceipt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op=request.getParameter("op");
		if(op.equals("buildReceipt")) {
			buildReceipt(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 跑腿人员抢单后修改派单状态，并生成订单信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void buildReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AffairService as=new AffairServiceImpl();
		CourierService cs=new CourierServiceImpl();
		//地图类实例化
		TurnMap map=new TurnMap();
		//获得起止地点
		String beginAdd=request.getParameter("beginAdd");
		String endAdd=request.getParameter("endAdd");
		String disId=request.getParameter("disId");
		String courierId=request.getParameter("CourierId");
		//System.out.println(courierId);
		String courierAdd=cs.getCourierAdd(courierId);
		//计算经纬度
		String begin=map.getCoordinate(beginAdd)[1]+","+map.getCoordinate(beginAdd)[0];
		String end=map.getCoordinate(endAdd)[1]+","+map.getCoordinate(endAdd)[0];
		String cour=map.getCoordinate(courierAdd)[1]+","+map.getCoordinate(courierAdd)[0];
		//System.out.println(begin+","+end+","+cour);
		double getDistance=TurnMap.GetPointDistance(cour, begin);
		double sendDistance=TurnMap.GetPointDistance(begin, end);
		System.out.println(getDistance);
		System.out.println(sendDistance);
		boolean flag=as.buildeReceipt(disId, courierId, getDistance, sendDistance);
		response.getWriter().print(flag==true?1:0);
		
	}

}
