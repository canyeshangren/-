package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userchangepassword")
public class userchangepassword extends HttpServlet{
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

	    String currentpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String userid ="2";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				if(name.equals("userid")) {
					userid=cookie.getValue();
				}
			}
		}
		//System.out.println("newpassword="+newpassword+"currentpassword="+currentpassword+"userid="+userid);
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select password from user where id=?",userid);
			if(b.next() && b.getString("password").equals(currentpassword)) {
				a.doupdate("update user set password=? where id=?",newpassword,userid);
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
