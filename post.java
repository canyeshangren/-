package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class post extends HttpServlet{
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
	    String postid="1";
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            String name = cookie.getName();
	            if (name.equals("postid")) {
					postid=cookie.getValue();
				}
	        }
	    }
	    
		hello a = new hello();
		try {
			ResultSet b = a.doselect("select user.img,post.postid,post.title,post.created,user.username,post.body from user,post where post.author=user.id and post.postid=?",postid);
			if(b.next()) {
				response.getWriter().write(b.getString("img")+";");
				response.getWriter().write(b.getString("postid")+";");
				response.getWriter().write(b.getString("title")+";");
				response.getWriter().write(b.getString("created")+";");
				response.getWriter().write(b.getString("username")+";");
				response.getWriter().write(b.getString("body")+";");
				b = a.doselect("select user.img,user.username,comment.body from user,comment where comment.parentpost=? and user.id=comment.author;",postid);
				while (b.next()) {
					response.getWriter().write(b.getString("img")+";");
					response.getWriter().write(b.getString("username")+";");
					response.getWriter().write(b.getString("body")+";");
				}
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
