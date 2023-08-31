package com.CollegeOGDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.CollegeOG.model.FriendList;
import com.CollegeOG.model.Students;

public class StudentDao {

	private Connection conn;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public StudentDao(Connection conn) {
		
		this.conn = conn;

	}
	
	public List<Students> getAllStudent()
	{
		List<Students> students=new ArrayList<>();
		
		try {
			query="select * from StudentList";
			pst=this.conn.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next())
			{
				Students stu=new Students();
				stu.setName(rs.getString("name"));
				stu.setDept(rs.getString("department"));
				stu.setImg(rs.getString("img"));
				students.add(stu);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return students;
		
	}
	public List<FriendList> getFriendList(ArrayList<FriendList> flist)
	{
		List<FriendList> frnds=new ArrayList<>();
		try {
			if(flist.size()>0)
			{
				for(FriendList f: flist)
				{
					query="select * from StudentList where name=?";
					pst=this.conn.prepareStatement(query);
					pst.setString(1, f.getName());
					rs=pst.executeQuery();
					while(rs.next())
					{
						FriendList fl=new FriendList();
						fl.setName(rs.getString(1));
						fl.setDept(rs.getString(2));
						fl.setImg(rs.getString(3));
						frnds.add(fl);
						
						
					}
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return frnds;
	}
	
	
}
