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
		User user = userDao.findById(id);

		
	if (user == null) {
		
		request.setAttribute("errMsg", "入力された内容は正しくありません。");

		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDelete.jsp");
		dispatcher.forward(request, response);
		return;
	}
}
