package servelet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;

@WebServlet("/items/add")
public class addServelet extends HttpServlet{
	
	
	

	

	
	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private itemService itemservice = new itemService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			resp.sendRedirect("/myserver02/brandadd.jsp");
			
//			String account = (String)req.getSession().getAttribute("login");
//			if(account == null) {
//				resp.sendRedirect("/myserver02/login.jsp");
//				return;
//			}
			req.setCharacterEncoding("UTF-8");
			// 获取数据
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String workName = req.getParameter("workName");
			String score = req.getParameter("score");
			
//			req.setCharacterEncoding("UTF-8");
			// 获取参数
//			String name = req.getParameter("name");
//			String price = req.getParameter("price");
//			String intro = req.getParameter("intro");
			// 增加数据
			itemservice.add(name,sex,workName,score);
			// 跳转页面
			resp.sendRedirect("/studentManagementSystem/items");
			
			
		}

//		@Override
//		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////			String account = (String)req.getSession().getAttribute("login");
////			if(account == null) {
////				resp.sendRedirect("/myserver02/login.jsp");
////				return;
////			}
////			
////			req.setCharacterEncoding("UTF-8");
////			// 获取参数
////			String name = req.getParameter("name");
////			String price = req.getParameter("price");
////			String intro = req.getParameter("intro");
////			// 增加数据
////			brandService.add(name, price, intro);
////			// 跳转页面
////			resp.sendRedirect("/myserver02/brand");
//		}

		
	












}
