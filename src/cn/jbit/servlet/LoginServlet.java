package cn.jbit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName != null && password != null){
			if(userName.equals(password)){
				request.getSession().setAttribute("user", userName);
				
				//向客户端写入cookie
				Cookie cook = new Cookie("sso",userName); //创建cookie对象，key-value
				cook.setMaxAge(3600);					  //设置cookie属性，最大存活时间(单位：s)
				cook.setDomain(".jbit.cn");				  //设置作用域(一级作用域)
				cook.setPath("/");						  //当前tomcat下的.jbit.cn域下的所有网站都可以拿到cookie
				
				response.addCookie(cook);
			}
		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
