package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adduser")
public class adduser extends HttpServlet{
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

	    LocalDate currentDate = LocalDate.now();
	    String dateString = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  		String username = request.getParameter("username2");
		String password = request.getParameter("password2");
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select * from user where username=?",username);
			if(b.next()) {
				response.getWriter().write("false");
			}
			else {
				a.doupdate("insert into user (username,password,permission,created) values(?,?,'用户',?)",username,password,dateString);
				response.getWriter().write("true");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
