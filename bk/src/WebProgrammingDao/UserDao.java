package WebProgrammingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import WebProgrammingModel.User;

public class UserDao {
	public User findByLogiInfo(String loginId, String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ? nad password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return null;
			}

			String loginIdDate = rs.getString("login_id");
			String nameDate = rs.getString("name");
			return new User(loginIdDate, nameDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
	public List<User> findAll(){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password,createDate,updateDate);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}
}
