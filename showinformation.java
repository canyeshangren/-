package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showinformation")
public class showinformation extends HttpServlet{
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
	    
		String userid="2";
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {      	
	            String name = cookie.getName();
	            if (name.equals("userid")) {
					userid=cookie.getValue();
				}
	        }
	    }
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select username,sex,email,signature,img from user where id = ?;",userid);
			if(b.next()) {
				response.getWriter().write(b.getString("username")+";");
				response.getWriter().write(b.getString("sex")+";");
				response.getWriter().write(b.getString("email")+";");
				response.getWriter().write(b.getString("signature")+";");
				response.getWriter().write(b.getString("img")+";");
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
