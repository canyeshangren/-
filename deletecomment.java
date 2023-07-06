package jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletecomment")
public class deletecomment extends HttpServlet{
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
	    
	    String commentid = request.getParameter("selectedIds");
	    System.out.println(commentid);
	    String[] arr = commentid.split(",");
		hello a = new hello();
		try {
			for (int i = 0; i < arr.length; i++) {
				arr[i]=arr[i].substring(7);
				a.doupdate("delete from comment where commentid=?;",arr[i]);
			}
			response.getWriter().write("true");
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
