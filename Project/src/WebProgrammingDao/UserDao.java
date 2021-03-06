package WebProgrammingDao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import WebProgrammingModel.User;

public class UserDao {
	public User findByLogiInfo(String loginId, String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,loginId);
			pStmt.setString(2, md5(password));
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
              return new User(Integer.parseInt(loginId), loginIdDate,nameDate,birthDate,null,updateDate, updateDate);

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

    public User findByEntry(String loginId, String name, String birthDate , String password) throws SQLException{
    	Connection conn = null;
    	try {
    		conn = DBManager.getConnection();
    		String sql = "INSERT INTO user (login_id, password, name, birth_date, create_date, update_date)VALUES (?, ? ,? , ?, now(), now())";

    		PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginId);
			pStmt.setString(2, md5(password));
			pStmt.setString(3, name);
			pStmt.setString(4, birthDate);

 			int result = pStmt.executeUpdate();

    	} catch (SQLException e) {
            e.printStackTrace();
            throw e;
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

    public User findByUpdate(String password, String name, String birthDate, String id) {
    	Connection conn = null;
    	try {
    		conn = DBManager.getConnection();
    		String sql = "UPDATE user SET password = ?, name = ?, birth_date = ? WHERE id = ?";

    		PreparedStatement pStmt = conn.prepareStatement(sql);

    		pStmt.setString(1, md5(password));
    		pStmt.setString(2, name);
			pStmt.setString(3, birthDate);
			pStmt.setString(4, id);

			int result = pStmt.executeUpdate();

    	} catch (SQLException e){
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

    public User findByUpdateNoPassword(String name, String birthDate, String id) {
    	Connection conn = null;
    	try {
    		conn = DBManager.getConnection();
    		String sql = "UPDATE user SET name = ?, birth_date = ? WHERE id = ?";

    		PreparedStatement pStmt = conn.prepareStatement(sql);

    		pStmt.setString(1, name);
			pStmt.setString(2, birthDate);
			pStmt.setString(3, id);

			int result = pStmt.executeUpdate();

    	} catch (SQLException e){
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

    public 	User findByDelete(String id) {
    	Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM user WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, id);

			int result = pStmt.executeUpdate();

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
		return null;
    }

	public List<User> findAll(){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id != 1";
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

	public List<User> findSearch(String loginIdP, String userNameP, String dateStartP, String dateEndP){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE id != 1";

			if(!loginIdP.equals("")) {
				sql += " AND login_id = '" + loginIdP + "'";
			}

			if(!userNameP.equals("")) {
				sql += " AND name LIKE '%" + userNameP + "%'";
			}

			if(!dateStartP.equals("")) {
				sql += " AND birth_date >= '" + dateStartP + "'";
			}

			if(!dateEndP.equals("")) {
				sql += " AND birth_date <= '" + dateEndP + "'";
			}
// 部分一致、以上以下

			System.out.println(sql);

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

	private String md5(String password) {
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";

		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		System.out.println(result);
		return result;
	}
}
