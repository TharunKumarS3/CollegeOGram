package com.CollegeOGDAO;

import java.sql.Connection;
import java.sql.ResultSet;

import com.CollegeOG.model.User;

import java.sql.PreparedStatement;

public class UserDao {

	private Connection conn;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public UserDao(Connection conn) {

		this.conn = conn;
	}

	public User userLogin(String email, String password) {
		User user = null;

		try {

			query = "select * from user where email=? and password=?";
			pst = this.conn.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}

}
