package servelet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.itemService;

@WebServlet("/items/delete")
public class deleteServlet extends HttpServlet{
	


		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private itemService itemservice = new itemService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 获取要删除的品牌编号
			String id = req.getParameter("id");
			// 调用service删除品牌数据
			itemservice.delete(id);
			// 删除完成后，跳转到品牌页面
			resp.sendRedirect("/studentManagementSystem/items");
		}
		
		


}
