package com.maven.pafMonitor;

import java.io.IOException;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonitoringAPI
 */
public class MonitoringAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 MonitorRepository itemObj = new MonitorRepository();
	 Monitor m =new Monitor();
	 String stsMsg="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonitoringAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 int accNo= Integer.parseInt(request.getParameter("accNo").trim());
		 int curUnits= Integer.parseInt(request.getParameter("curUnits").trim());
		 System.out.println(Integer.toString(accNo)+" "+ Integer.toString(curUnits));

		 m.setAccountNo(accNo);
		 m.setCurrentUnits(curUnits);
		 
		  stsMsg = itemObj.create(m);
		 response.getWriter().write(stsMsg);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 {
	
	 String[] p = param.split("=");
	 map.put(p[0], p[1]);
	 }
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}


	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		
		int accNo= Integer.parseInt(paras.get("accNo").toString());
		 int curUnits= Integer.parseInt(paras.get("curUnits").toString());
		 System.out.println("update "+ Integer.toString(accNo)+" "+ Integer.toString(curUnits));

		 m.setAccountNo(accNo);
		 m.setCurrentUnits(curUnits);
		 
		  stsMsg = itemObj.update(m);
		  response.getWriter().write(stsMsg);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		int DaccNo= Integer.parseInt(paras.get("accNo").toString());
		 String stsMsg = itemObj.delete(DaccNo);
		response.getWriter().write(stsMsg);
	}

}
