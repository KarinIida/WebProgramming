package WebProgrammingController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UserDetailServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String id = request.getParameter("id");
			System.out.println(id);
			
			
			System.out.println(id(userInfo));
			
			request.setAttribute("userInfo", userInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
	}
}
