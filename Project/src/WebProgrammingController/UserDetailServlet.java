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

@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public UserDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			String id = request.getParameter("id");
			System.out.println(id);

//			// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
//			dao
//			全部
//			UserListのUserServletの?

			request.setCharacterEncoding("UTF-8");

			UserDao userDao = new UserDao();
			User userList = userDao.findById(id);

//			// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
//			メソッド
//			インスタンス

			request.setAttribute("user", userList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDetail.jsp");
			dispatcher.forward(request, response);
			return;
	}
}
