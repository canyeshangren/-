package jdbc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		//设置请求头
			response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		    //设置编码格式
		    request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
	}
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置请求头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    //设置编码格式
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");

  		String username = request.getParameter("username");
		String password = request.getParameter("password");
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select * from user where username=? and password=?",username,password);
			if(b.next()) {
				
				response.getWriter().write("true;"+b.getString("permission")+";"+b.getString("id"));
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
