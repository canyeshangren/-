package jdbc;

import java.io.IOException;//模板
import java.sql.ResultSet;//模板//模板
import java.sql.SQLException;//模板

import javax.servlet.annotation.WebServlet;//模板
import javax.servlet.http.HttpServlet;//模板
import javax.servlet.http.HttpServletRequest;//模板
import javax.servlet.http.HttpServletResponse;//模板

@WebServlet("/路由名称")
public class servlet模板 extends HttpServlet{//模板
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

  		String search = request.getParameter("search"); //这个地方可以获取前端传来的名为search的数据，以字符串保存
		
	    hello a = new hello();//模板
		try {//模板
			ResultSet b = a.doselect("select postid from post where title like ? or body like ?","%"+search+"%","%"+search+"%");//这里就是添加了通配符的select语句
			while(b.next()) {//b代表查询结果，查询之后的那个表，next（）函数就是往下一行，逐行扫描
				response.getWriter().write(b.getString("postid")+",");//这里表示的是往返回的那个response里面添加字符串，修改write括号后的内容即可
			}//模板
		
		} catch (SQLException e) {//模板
			e.printStackTrace();//模板
		}//模板
	}//模板
}//模板
