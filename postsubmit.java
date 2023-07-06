package jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postsubmit")
public class postsubmit extends HttpServlet{
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
	    String author="2";
	    LocalDate currentDate = LocalDate.now();
	    String dateString = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            String name = cookie.getName();
	            if (name.equals("userid")) {
					author=cookie.getValue();
				}
	            // 处理 Cookie
	            // ...
	        }
	    }
	    String title =  request.getParameter("post-title");
	    String body = request.getParameter("post-content");
		hello a = new hello();
		try {
				a.doupdate("insert into post (title,body,author,created) values(?,?,?,?)",title,body,author,dateString);
				response.getWriter().write("true");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
