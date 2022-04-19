package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB_helper.db_helper;
//import com.offcn.model.Brand;
import servelet.items;

public class itemService {
	
	db_helper db = new db_helper();

	public List findAll() {
		ArrayList list = new ArrayList();
		try (Connection conn = db.getConnection()) {
			String sql = "select * from items";
			PreparedStatement pstat = db.getStatement(conn, sql);
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("score"));
				items item = new items(
						rs.getInt("id"),
					
						rs.getString("name"),
						rs.getString("sex"),
						rs.getString("workName"),
						rs.getInt("score")
						);
				list.add(item);
			}
			
			db.free(pstat, conn);
		} catch (SQLException e) {
			System.out.println("brand failure!!!!");
			e.printStackTrace();
		}
		return list;
	}
	
	public List search(String keyWords) {
		
		ArrayList list = new ArrayList();
		try (Connection conn = db.getConnection()) {
			 String s1="select * from items ";
		     StringBuilder sb=new StringBuilder();
		     sb.append(s1);
		     sb.append("where id like ");
		     sb.append("'%");
		     sb.append(keyWords);
		     sb.append("%' or ");
		     sb.append("name like ");
		       sb.append("'%");
		       sb.append(keyWords);
		       sb.append("%' or ");
		       sb.append("workName like ");
		       sb.append("'%");
		       sb.append(keyWords);
		       sb.append("%'");
		       String sql=sb.toString();
			PreparedStatement pstat = db.getStatement(conn, sql);
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				items item = new items(
						rs.getInt("id"),
					
						rs.getString("name"),
						rs.getString("sex"),
						rs.getString("workName"),
						rs.getInt("score")
						);
				list.add(item);
			}
			db.free(pstat, conn);
		} catch (SQLException e) {
			System.out.println("brand failure!!!!");
			e.printStackTrace();
		}
		return list;
		
//	    
//	       System.out.println(sql);
//	    rs= stmt.executeQuery(sql);
//	       System.out.println(rs);
//	addFlushData(rs);
//	page();


	
}


	public void delete(String id) {
		try (// 1、获取数据库连接
		Connection conn = db.getConnection()) {
			// 2、定义sql语句，执行
			String sql = "delete from items where id = ?";
			PreparedStatement pstat = db.getStatement(conn, sql);
			pstat.setInt(1, Integer.parseInt(id));
			pstat.executeUpdate();
			// 3、关闭数据库连接
			db.free(pstat, conn);
		} catch (NumberFormatException | SQLException e) {
			System.out.println("删除品牌失败");
			e.printStackTrace();
		}
		
	}

	public void add(String name, String sex, String workName,String score) {
		try (// 1、获取连接
		Connection conn = db.getConnection()) {
			// 2、创建sql语句，执行
			String sql = "insert into items(name,sex,workName,score) values(?, ?, ?,?)";
			PreparedStatement pstat = db.getStatement(conn, sql);
			pstat.setString(1, name);
			pstat.setString(2, sex);
			pstat.setString(3, workName);
			pstat.setString(4, score);
			pstat.executeUpdate();
			db.free(pstat, conn);
		} catch (SQLException e) {
			System.out.println("增加品牌数据失败");
			e.printStackTrace();
		}
		
		// 3、关闭连接
		
	}
	
//	public items findById(String id) {
//		items item = null;
//		try (Connection conn = db.getConnection()) {
//			String sql = "select * from brand where id = ?";
//			PreparedStatement pstat = db.getStatement(conn, sql);
//			pstat.setInt(1, Integer.parseInt(id));
//			ResultSet rs = pstat.executeQuery();
//			if(rs.next()) {
//				item = new items(
//						rs.getInt("id"),
//						rs.getString("name"),
//						rs.getString("price"),
//						rs.getString("information"));
//			}
//		} catch (NumberFormatException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return brand;
//		
//	}

	public void update(String id, String name, String sex, String workName,String score) {
		try (Connection conn = db.getConnection()) {
			String sql = "update items set name = ?, sex = ?, workName=?,score=? where id = ?";
			PreparedStatement pstat = db.getStatement(conn, sql);
			pstat.setString(1, name);
			pstat.setString(2, sex);
			pstat.setString(3, workName);
			pstat.setInt(4, Integer.parseInt(score));
			pstat.setInt(5, Integer.parseInt(id));
			pstat.executeUpdate();
			db.free(pstat, conn);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}
