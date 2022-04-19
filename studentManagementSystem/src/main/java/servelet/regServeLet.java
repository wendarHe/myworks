package servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.regService;
//import com.offcn.service.UserService;
@WebServlet("/reg")
public class regServeLet extends HttpServlet{
	


//	@WebServlet("/reg")
//	public class RegServlet extends HttpServlet{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private regService userService = new regService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 直接返回注册页面
			resp.sendRedirect("/studentManagementSystem/reg.jsp");
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			// 接受用户填写的注册数据
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String confirm = req.getParameter("passwordcon");
//			String nickname = req.getParameter("nickname");
			System.out.println(password + ":" + confirm);
			if(!password.equals(confirm)) {
				req.setAttribute("error", "两次密码输入不一致");
				req.getRequestDispatcher("reg.jsp").forward(req, resp);
				return;
			}
			// 注册用户
			int ret = userService.regService(username, password);
			if(ret != 0) {
				if(ret == 1) {
					req.setAttribute("error", "账号已经被占用");
				} else if(ret == 2) {
					req.setAttribute("error", "服务器繁忙，请稍后重新注册");
				}
				req.getRequestDispatcher("reg.jsp").forward(req, resp);
				return;
			}
			
			// 返回注册页面
//			resp.sendRedirect("/myserver02/reg.jsp");
			req.setAttribute("error", "register successfully, please login...");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
//	}










}
