package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showusers")
public class showusers extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置请求头
		response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    //设置编码格式
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	  
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select id,username,password,created from user");
			while(b.next()) {
				response.getWriter().write(b.getString("id")+";");
				response.getWriter().write(b.getString("username")+";");
				response.getWriter().write(b.getString("password")+";");
				response.getWriter().write(b.getString("created")+";");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
