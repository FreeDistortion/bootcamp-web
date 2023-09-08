package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	// login
	public void login(String id, String pass) {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER ");
		sqlCommand.append("WHERE ID=? AND PASS=?");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			preparedStmt.setString(1, id);
			preparedStmt.setString(2, pass);
			rs = preparedStmt.executeQuery(sqlCommand.toString());
			if (rs.next()) {
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("PASS") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getString("ADDR") + "\t");
				System.out.print(rs.getDate("REGDATE") + "\t");
				System.out.print(rs.getString("POINT") + "\t");
				System.out.println(rs.getString(7) + "\t");
			} else {
				System.out.println("Login failed.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, preparedStmt, con);
		}
	}

	// select
	public void select() {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("INSERT INTO MEMBER VALUES(");
		sqlCommand.append("?,?,?,?,SYSDATE,10000,?)");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			rs = preparedStmt.executeQuery(sqlCommand.toString());
			System.out.println("조회된 ResultSet Object: " + rs);
			while (rs.next()) {
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("PASS") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getString("ADDR") + "\t");
				System.out.print(rs.getDate("REGDATE") + "\t");
				System.out.print(rs.getString("POINT") + "\t");
				System.out.println(rs.getString(7) + "\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, preparedStmt, con);
		}
	}

	// delete
	public void delete(String id) {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("DELETE FROM MEMBER WHERE ");
		sqlCommand.append("ID=?");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			preparedStmt.setString(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStmt, con);
		}

	}

	// update
	public void update(String id, String addr) {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("UPDATE MEMBER SET ");
		sqlCommand.append("ADDR=? WHERE ID=?");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			preparedStmt.setString(1, addr);
			preparedStmt.setString(2, id);
			ResultSet result = preparedStmt.executeQuery(sqlCommand.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStmt, con);
		}
	}

	// insert
	public int insert(String id, String pass, String name, String addr, String info) {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("INSERT INTO MEMBER VALUES(");
		sqlCommand.append("?,?,?,?,SYSDATE,10000,?)");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		int result=0;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			preparedStmt.setString(1, id);
			preparedStmt.setString(2, pass);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, addr);
			preparedStmt.setString(5, info);
			result = preparedStmt.executeUpdate();
			System.out.println(result + " rows insert completed!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStmt, con);
		}
		return result;
	}

}
