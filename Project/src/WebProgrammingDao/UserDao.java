package WebProgrammingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import WebProgrammingModel.User;

public class UserDao {
	public User findByLogiInfo(String loginId, String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

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

    public User findById(String loginId) {
    	Connection conn = null;
    	try {
    		 conn = DBManager.getConnection();

    		 String sql = "SELECT * FROM user WHERE id = ?";

    		  PreparedStatement pStmt = conn.prepareStatement(sql);
              pStmt.setString(1, loginId);
              ResultSet rs = pStmt.executeQuery();

              if (!rs.next()) {
                  return null;
              }

              String loginIdDate = rs.getString("login_id");
              String nameDate = rs.getString("name");
              Date birthDate = rs.getDate("birth_date");
              String createDate = rs.getString("create_date");
              String updateDate = rs.getString("update_date");
              return new User(0, loginIdDate,nameDate,birthDate,null,updateDate, updateDate);

    }	catch (SQLException e) {
        e.printStackTrace();
        return null;
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

    public User findByEntry(String loginId,  String name, String birthDate , String password) {
    	Connection conn = null;
    	try {
    		conn = DBManager.getConnection();
    		String sql = "INSERT INTO user (login_id, password, name, birth_date, create_date, update_date)VALUES (?, ?, ?, ?, now(), now())";

    		PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			pStmt.setString(3, name);
			pStmt.setString(4, birthDate);

 			int result = pStmt.executeUpdate();

    	} catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                 }
            }
        }
		return null;
    }

    public User findByUpdate(String password, String confirm, String name, String birthDate) {

    }

	public List<User> findAll(){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

//			String sql = "INSERT INTO user VALUES (id, rs.login_id, rs.name, rs.birth_date, rs.password, rs.create_date, rs.update_date)"

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
