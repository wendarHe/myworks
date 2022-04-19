package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB_helper.db_helper;
public class regService {
	
	

	
	/**
	 * 类型包含和用户业务相关的处理功能
	 * 		用户注册
	 * 		用户登录
	 * 		查看资料
	 * 		修改密码
	 * 		完善资料
	 * 		...
	 * @author wenbinmu
	 *
	 */
//	public class UserService {
		private static final int REG_SUCCESS = 0;
		private static final int REG_EXITS = 1;
		private static final int REG_ERROR = 2;
		
		private static final int LOGIN_SUCCESS = 0;
		private static final int LOGIN_FAIL = 1;
		private static final int LOGIN_ERROR = 2;
		
		public int regService(String username,
				String password
				) {
			try (
				// 获取数据库连接
				Connection conn = db_helper.getConnection()) {
				// 1、检测账号是否可用
				String sql = "select * from user where username = ?";
				PreparedStatement pstat = db_helper.getStatement(conn, sql);
				pstat.setString(1,  username);
				ResultSet rs = pstat.executeQuery();
				rs.next();
				if(rs.getRow() > 0) {
					System.out.println("该账号已经被使用，请使用其他账号注册");
					return REG_EXITS;
				}
				
				// 2、注册
				String regSql = "insert into user(username, password) values(?, ?)";
				PreparedStatement pstat2 = db_helper.getStatement(conn, regSql);
				pstat2.setString(1, username);
				pstat2.setString(2, password);
				
				int row = pstat2.executeUpdate();
				if(row <= 0) {
					System.out.println("服务器繁忙，注册失败");
					return REG_ERROR;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("服务器繁忙，注册失败");
				return REG_ERROR;
			}
			System.out.println("注册成功！");
			return REG_SUCCESS;
		}

		public int loginService(String username, String password) {
			Connection conn = null;
			try {
				// 1、获取数据库连接
				conn = db_helper.getConnection();
				// 2、定义sql语句，执行sql，判断登录结果
				String sql = "select * from user where username = ? and password = ?";
				PreparedStatement pstat = db_helper.getStatement(conn, sql);
				pstat.setString(1, username);
				pstat.setString(2, password);
				ResultSet rs = pstat.executeQuery();
				rs.next();
				if(rs.getRow() <= 0) {
					System.out.println("账号或者密码有误");
					return LOGIN_FAIL;
				}
				
			} catch (SQLException e) {
				System.out.println("执行SQL语句出现问题...");
				System.out.println("服务器繁忙，请稍后再试");
				e.printStackTrace();
				return LOGIN_ERROR;
			}
		
			// 3、返回登录结果：登录成功
			return LOGIN_SUCCESS;
		}
//	}










}
