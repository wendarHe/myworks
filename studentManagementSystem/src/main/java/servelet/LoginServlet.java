package servelet;

//public class LoginServlet {
//
//}package servelet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;





	@WebServlet("/login")
	public class LoginServlet extends HttpServlet{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		private UserService userService = new UserService();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 直接返回登录页面
			resp.sendRedirect("/studentManagementSystem/login.jsp");
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 接受用户数据，完成登录操作
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			// 登录操作
			int ret =userService.loginService(username, password);
			if(ret > 0) {
				if(ret == 1) {
					req.setAttribute("error", "账号或者密码有误");
				}else if (ret == 2) {
					req.setAttribute("error", "服务器繁忙，请稍后再试");
				}
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			}
			//登录成功时，session(会话)记录用户信息[记录用户登录账号]
			// 如果有需要的话，可以记录完整用户信息

			req.getSession().setAttribute("login", username);
			resp.sendRedirect("/studentManagementSystem/items");
		}

		
	}




