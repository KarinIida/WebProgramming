package WebProgrammingController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebProgrammingDao.UserDao;
import WebProgrammingModel.User;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public UserDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);

		request.setCharacterEncoding("UTF-8");

		UserDao userDao = new UserDao();
		User userList = userDao.findById(id);

		request.setAttribute("user", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDelete.jsp");
		dispatcher.forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		UserDao userDao = new UserDao();
		User user = userDao.findByDelete(id);
		response.sendRedirect("UserListServlet");
	}
}
