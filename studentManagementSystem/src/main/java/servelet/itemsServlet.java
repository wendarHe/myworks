package servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.itemService;

@WebServlet("/items")
public class itemsServlet extends HttpServlet{
	
	

		private static final long serialVersionUID = 1L;
		
		private itemService itemService = new itemService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// select all brands, transfer jsp page!
			List list =itemService.findAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("items.jsp").forward(req, resp);
		}

		

























}
