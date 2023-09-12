package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basic.MemberDTO;

public class MemberDAO {

	public ArrayList<MemberDTO> getMemberList() {
		System.out.println("DAO request completed.");
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("SELECT * FROM MEMBER");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		ResultSet rs = null;

		// DTO로 변환된 전체 record를 담을 구조
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();

		// record 하나를 변환해서 담을 DTO
		MemberDTO member = null;

		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			rs = preparedStmt.executeQuery();

			while (rs.next()) {
				// ResultSet의 record를 Java Object(DTO)로 변환
				member = new MemberDTO(rs.getString("id"), rs.getString("pass"), rs.getString("name"),
						rs.getString("addr"), rs.getDate("regdate"), rs.getInt("point"), rs.getString("info"));
				
				// 변환된 DTO를 ArrayList에 저장
				memberList.add(member);
			}
			System.out.println("조회된 record 개수: "+memberList.size());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStmt, con);
		}
		return memberList;

	}

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
	public int delete(String id) {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("DELETE FROM MEMBER WHERE ");
		sqlCommand.append("ID=?");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		int result=0;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			preparedStmt.setString(1, id);
			result=preparedStmt.executeUpdate();
			System.out.println(result+" row delete completed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStmt, con);
		}
		return result;

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
			ResultSet result = preparedStmt.executeQuery();
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
		int result = 0;
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

	// insert
	public int insert(MemberDTO member) {
		StringBuffer sqlCommand = new StringBuffer();
		sqlCommand.append("INSERT INTO MEMBER VALUES(");
		sqlCommand.append("?,?,?,?,SYSDATE,10000,?)");
		Connection con = null;
		PreparedStatement preparedStmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			preparedStmt = con.prepareStatement(sqlCommand.toString());
			preparedStmt.setString(1, member.getId());
			preparedStmt.setString(2, member.getPass());
			preparedStmt.setString(3, member.getName());
			preparedStmt.setString(4, member.getAddr());
			preparedStmt.setString(5, member.getInfo());
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
