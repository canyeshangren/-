package jdbc;

import java.io.IOException;
import java.sql.*;

import javax.servlet.http.*;


//@WebServlet("/login")
public class jdbc1 extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	@Override
//	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	  // 设置 CORS 头
//	  response.setHeader("Access-Control-Allow-Origin", "*");
//	  response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//	  response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//
//	  // 处理预检请求
//	  response.setStatus(HttpServletResponse.SC_OK);
//	}
	/**
	 * 重写了get方法，当传来了一个get方法的请求时会调用本函数
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//		String name= request.getParameter("username");
//		String password = request.getParameter("password");
//		System.out.println(name);
//		System.out.println(password);
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		hello a = new hello();
		try {
			a.doselect("select * from user");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 重写了post方法，当传来了一个post方法的请求时会调用本函数
	 * @throws IOException 
	 */
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置请求头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    //设置编码格式
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
//	    Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("logined")) {
//                    String logined = cookie.getValue();
//                    System.out.println(logined);
//                    // 处理获取到的用户名
//                }
//            }
//        }
//        else {
//			System.out.println("无cookie");
//		}
  		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		System.out.println(username);
//		System.out.println(password);
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select * from user where username=? and password=?",username,password);
			if(b.next()) {
//				response.sendRedirect("../text3/index.html");
				response.getWriter().write("true");
			}
			else {
				response.getWriter().write("false");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
