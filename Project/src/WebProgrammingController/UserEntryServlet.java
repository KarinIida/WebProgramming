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

@WebServlet("/UserNewEntryServlet")
public class UserEntryServlet extends HttpServlet{
private static final long serialVersionUID = 1L;

	public UserEntryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNewEntry.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		if (!password.equals(confirm)  || loginId.equals("") || password.equals("") || confirm.equals("") || name.equals("") || birthDate.equals("")) {
			System.out.println("error");

			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNewEntry.jsp");
			dispatcher.forward(request, response);
			return;
		}
		UserDao userDao = new UserDao();
		User user = userDao.findByEntry(loginId, name, birthDate, password ,confirm);

		response.sendRedirect("UserListServlet");
	}
}
