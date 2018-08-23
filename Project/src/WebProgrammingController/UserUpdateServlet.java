package WebProgrammingController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebProgrammingDao.UserDao;
import WebProgrammingModel.User;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public UserUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);

		String name = request.getParameter("name");
		String date = request.getParameter("date");

		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo(name, date);

	}
}
