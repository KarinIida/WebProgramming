package WebProgrammingController;

import java.io.IOException;

public class LoginServlet extends HttpServeit{
	private static final long serialVersionUID 1L;
	public LoginServlet() {
		super();
		protected void doGet(HttpServlrtRequest request, HttpServletRespose respose)
			throws ServletException IOException{
			RequestDispatcher dispather request.getRequeatDispather("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, respose);
		}
		
	}
}
