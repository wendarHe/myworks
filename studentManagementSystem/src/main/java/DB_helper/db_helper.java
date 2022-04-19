package DB_helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class db_helper {
	
	
	
	/**
	 * 管理数据库连接的工具类
	 * @author 
	 *
	 */


	
		 private static final String DRIVER = "com.mysql.jdbc.Driver";
		 private static final String URI = "jdbc:mysql://localhost:3306/def?useSSL=false";
		 private static final String USER = "root";
		 private static final String PASSWORD = "He200203";
		 
		 static {
			 try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				System.out.println("数据驱动注册失败");
			}
		 }
		 
		 public static Connection getConnection() {
			 Connection conn = null;
			 try {
				conn = DriverManager.getConnection(URI, USER, PASSWORD);
			} catch (SQLException e) {
				System.out.println("数据库连接获取失败...");
			}
			 return conn;
		 }
		 
		 public static PreparedStatement getStatement(Connection conn, String sql) {
			 PreparedStatement pstat = null;
			 try {
				pstat = conn.prepareStatement(sql);
			} catch (SQLException e) {
				System.out.println("SQL语句解析失败...");
			}
			 return pstat;
		 }
		 
		 public static void free(PreparedStatement pstat, Connection conn) {
			 try {
				 if(pstat != null && !pstat.isClosed()) {
					 pstat.close();
				 }
				 if(conn != null && !conn.isClosed()) {
					 conn.close();
				 }
			 }catch(SQLException e) {
				 System.out.println("关闭连接，释放资源");
			 } finally {
				 pstat = null;
				 conn = null;
			 }
		 }
		 
		 
		 
		 
		 
	


}
