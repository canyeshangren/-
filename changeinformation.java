package jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changeinformation")
public class changeinformation extends HttpServlet{
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
	    String username = request.getParameter("username");
	    String sex = request.getParameter("sex");
	    String email = request.getParameter("email");
	    String signature = request.getParameter("signature");
		hello a = new hello();
		try {
			a.doupdate("update user set username=?,sex=?,email=?,signature=? where id=?;",username,sex,email,signature,userid);
			response.getWriter().write("true");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
