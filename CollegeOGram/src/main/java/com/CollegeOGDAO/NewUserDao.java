package com.CollegeOGDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.CollegeOG.model.NewUser;

public class NewUserDao {
	
	private Connection conn;
	private String query;
	private String query2;
	private PreparedStatement pst;
	private ResultSet rs;

	public NewUserDao(Connection conn) {

		this.conn = conn;
	}
	public NewUser newUser(String name,String dept,String img,String email,String pass)
	{
		
		NewUser nu=null;
		try {
			query="Insert into StudentList values(?,?,?)";
			pst=this.conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, dept);
			pst.setString(3, img);
			int r=pst.executeUpdate();
			query2="Insert into user values(?,?,?)";
			pst=this.conn.prepareStatement(query2);
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, pass);
			int r2=pst.executeUpdate();
			
			if(r>0 && r2>0)
				
			{
				nu=new NewUser();
				nu.setName(name);
				nu.setDept(dept);
				nu.setEmail(email);
				nu.setPass(pass);
				nu.setImg(img);
			}
			
			
			

			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nu;
		
	}

}
