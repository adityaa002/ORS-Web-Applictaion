package in.co.rays.adv.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.adv.bean.UserBean;
import in.co.rays.adv.util.JDBCDataSource;

public class UserModel {

	public static Integer nextPk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from user");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		JDBCDataSource.closeConnection(conn);

		return pk + 1;
	}

	public static void add(UserBean bean) throws Exception {
		// int id = nextPk();
		Connection conn = JDBCDataSource.getConnection();
		try {

			// conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(" insert into user values( ? , ? , ?  , ? , ?, ? , ? )  ");
			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getAddress());

			// conn.commit();

			int i = pstmt.executeUpdate();
			JDBCDataSource.closeConnection(conn);

			System.out.println("Data inserted Successfully....! " + i);
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Exception : " + e.getMessage());

		}
	}

	public static void upate(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update user set first_name = ? ,last_name = ? , login_id = ?, password = ? , dob = ? , address = ? where id = ?");
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getAddress());
		pstmt.setString(7, bean.getLoginId());
		int i = pstmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);

		System.out.println("Data update Success : " + 1);
	}

	public static void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(" delete from user where id = ? ");
		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		JDBCDataSource.closeConnection(conn);

		System.out.println("Record deleted successfully....!!");

	}

	public static void findPk(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where id = ?  ");
		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));
		}
		JDBCDataSource.closeConnection(conn);

	}

	public static void findByLogin(String login) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where login_id = ?");
		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getDate(6));
			System.out.println("\t" + rs.getString(7));
		}
		JDBCDataSource.closeConnection(conn);

	}

	public static List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");

		if (pageSize > 0) {
			pageNo = (pageSize - 1) * pageNo;
			sql.append(" limit " + pageNo + "," + pageSize);

		}

		System.out.println("Your Query : " + sql);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();
			bean.setLoginId(rs.getString(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		JDBCDataSource.closeConnection(conn);

		return list;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user where login_id = ? and password = ?");

		pstmt.setString(1, loginId);
		pstmt.setString(2, password);  
		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
		}

		JDBCDataSource.closeConnection(conn);
		return bean;

	}

}
