package jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search_showposts")
public class search_showposts extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//模板

	@Override //模板
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {//模板
		//设置请求头
		response.setHeader("Access-Control-Allow-Origin", "*");//模板
	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");//模板
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");//模板
	    //设置编码格式
	    request.setCharacterEncoding("UTF-8");//模板
	    response.setCharacterEncoding("UTF-8");//模板
	    String numbers="false";
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            String name = cookie.getName();
	            if (name.equals("numbers")) {
					numbers=cookie.getValue();
				}
	        }
	    }
	    String[] arr = numbers.split("\\|");
//	    for(String aString : arr) {
//	    	System.out.println(aString);
//	    }
	    
	    hello a = new hello();//模板
		try {//模板
			if(arr[0]!="false")
				for(int i = 0; i < arr.length; i++) {
					ResultSet b = a.doselect("select user.img,post.postid,post.title,post.created,user.username,post.body from user,post where post.author=user.id and post.postid=?",arr[i]);//这里就是添加了通配符的select语句
					b.next();
					response.getWriter().write(b.getString("img")+";");
					response.getWriter().write(b.getString("postid")+";");
					response.getWriter().write(b.getString("title")+";");
					response.getWriter().write(b.getString("created")+";");
					response.getWriter().write(b.getString("username")+";");
					response.getWriter().write(b.getString("body")+";");
				}
			else {
				response.getWriter().write("false");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
