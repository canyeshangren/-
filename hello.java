package jdbc;

import java.sql.*;

/**
 * 这是一个jdbc工具类
 * @函数1	可以调用doselect函数来进行查询，参数为sql语句，以及占位符对应的参数
 * @函数2	可以调用doupdate函数来进行增删改，参数为sql语句，以及占位符对应的参数
 * @author 郑卫国
 */
public class hello {
	static {
		try {			  
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//在每次初始化时加载好jdbc引擎
	
	/**
	 * 与数据库进行连接，默认连接test1数据库
	 * @return 返回一个连接类型的值
	 * @throws SQLException
	 */
	public Connection getconnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tao?serverTimezone=UTC";
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	/**
	 * 实现对数据库的增删改操作
	 * @param sql 参数1，sql语句，带有占位符的
	 * @param parms 参数2， 配合占位符使用
	 * @throws SQLException
	 */
	public void doupdate(String sql,Object ...parms) throws SQLException {
		Connection conn = getconnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < parms.length; i++ ) {
			pstmt.setObject(i+1, parms[i]);
		}
		int a = pstmt.executeUpdate();
		System.out.println("影响行数:"+ a);//输出影响行数
		
		pstmt.close();
		conn.close();//关闭连接
	}
	
	/**
	 * 实现对数据库的查询操作
	 * @param sql 参数1，sql查询语句
	 * @param parms 参数2， 需要查询的东西
	 * @throws SQLException
	 */
	public ResultSet doselect(String sql,Object ...parms) throws SQLException {
		Connection conn = getconnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < parms.length; i++ ) {
			pstmt.setObject(i+1, parms[i]);
		}
		ResultSet rs =pstmt.executeQuery();
//        ResultSetMetaData rsmd = rs.getMetaData();
//        int numColumns = rsmd.getColumnCount();
//		while(rs.next()) {
//			for (int i = 1; i <= numColumns; i++) {
//                String columnName = rsmd.getColumnName(i);
//                String columnValue = rs.getString(i);
//                System.out.println(columnName + " = " + columnValue);
//            }
//		}
		return rs;
	}
//	public static void main(String[] args) {
//		hello a = new hello();
//		try {
//			ResultSet b= a.doselect("select postid from post where body like ?", "%内容%");
//			System.out.println("dalksjdkla");
//			while(b.next()) {
//				System.out.println(b.getString("postid"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//	}
}
