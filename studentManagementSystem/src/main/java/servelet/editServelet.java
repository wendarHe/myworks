package servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.offcn.servlet.WebServlet;

import service.*;
@WebServlet("/items/edit")
public class editServelet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private itemService itemservice = new itemService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
//		Brand brand = brandService.findById(id);
//		req.setAttribute("brand", brand);
//		req.getRequestDispatcher("../brandedit.jsp").forward(req, resp);
		// 编码
		req.setCharacterEncoding("UTF-8");
		// 获取数据
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String workName = req.getParameter("workName");
		String score = req.getParameter("score");

		// 保存/更新数据
		itemservice.update(id, name, sex, workName,score);
		// 跳转页面
		resp.sendRedirect("/studentManagementSystem/items");
	}

//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		// 编码
////		req.setCharacterEncoding("UTF-8");
////		// 获取数据
////		String id = req.getParameter("id");
////		String name = req.getParameter("name");
////		String price = req.getParameter("price");
////		String information = req.getParameter("information");
////
////		// 保存/更新数据
////		brandService.update(id, name, price, information);
////		// 跳转页面
////		resp.sendRedirect("/myserver02/brand");
//	}

}
