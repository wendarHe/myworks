package servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.itemService;
@WebServlet("/items/search")
public class searchServelet extends HttpServlet{
	
	
	

	
	
		


			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			private itemService itemservice = new itemService();

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				String keyWords = req.getParameter("keyWords");

//				brandService.delete(id);
				// 删除完成后，跳转到品牌页面
//				resp.sendRedirect("/studentManagementSystem/items");
				List list =itemservice.search(keyWords);
				req.setAttribute("list", list);
				req.getRequestDispatcher("../items.jsp").forward(req, resp);
				
			}
			

//			@Override
//			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//				// select all brands, transfer jsp page!
//				List list =itemService.findAll();
//				req.setAttribute("list", list);
//				req.getRequestDispatcher("items.jsp").forward(req, resp);
//			}



	

	

}
