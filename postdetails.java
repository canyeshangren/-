package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postdetails")
public class postdetails extends HttpServlet{
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
	    
	    String postid = request.getParameter("postid");
		hello a = new hello();
		try {
			postid=postid.substring(4);
			ResultSet b = a.doselect("select title,body from post where postid=?;",postid);
				if(b.next()) {
				
					response.getWriter().write(b.getString("title")+";");
					response.getWriter().write(b.getString("body")+";");
				}
				else
					response.getWriter().write("false");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
