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

		request.setCharacterEncoding("UTF-8");

		UserDao userDao = new UserDao();
		User userList = userDao.findById(id);

		request.setAttribute("user", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String id = request.getParameter("id");

		if (!password.equals(confirm) || name.equals("") || birthDate.equals("")) {
			System.out.println("error");

			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
//		Dao作成
//		int result = pStmt.executeUpdate();

		UserDao userDao = new UserDao();
		User user = userDao.findByUpdate(password, name, birthDate, id);

		response.sendRedirect("UserListServlet");
	}
}
