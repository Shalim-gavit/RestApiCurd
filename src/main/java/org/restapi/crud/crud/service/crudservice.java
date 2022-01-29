package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.restapi.crud.crud.model.crudmodel;

public class crudservice 
{
	
	Connection con;

	
	public crudservice()
	{
		
		try 
		{
			String url =String.format("jdbc:mysql://localhost:3306/students_data");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} 
		catch(Exception e) 
		{
			System.out.println(e +"data insert unsuccess.");
		}
	}

/*--------------------Insert Data ----------------------------------------------------------------- */
	public crudmodel insertStud(crudmodel stud) 
	{   
		String insert = "insert into students(student_no,student_name,student_dob,student_doj) values(?,?,?,?) ";
		
		try 
		{
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setLong(1, stud.getSno());
			ps.setString(2, stud.getSname());
			ps.setDate(3,Date.valueOf(stud.getSdob()));
            ps.setDate(4,Date.valueOf(stud.getSdoj()));	
			ps.execute();
		}
		catch(Exception e) 
		{
			System.out.println(e +"data insert unsuccess.");
		}
		
		return stud;
		
	}
/*--------------------Show Data -----------------------------------------------------------------*/	
	    public ArrayList<crudmodel> getStud() throws SQLException
	    {
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from students";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			crudmodel model = new crudmodel();
			
            model.setSno(rs.getInt("student_no")); 
			model.setSname(rs.getString("student_name"));
			model.setSdob(rs.getString("student_dob"));
			model.setSdoj(rs.getString("student_doj"));
			data.add(model);
		}
		
		return data;
		
	}
 /*--------------------Select Data by id -----------------------------------------------------------------*/	
	
	public ArrayList<crudmodel> getStudById(int id) throws SQLException
	{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from students where student_no =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) 
		{
			crudmodel model = new crudmodel();
			model.setSno(rs.getInt("student_no"));
			model.setSname(rs.getString("student_name")); 
			model.setSdob(rs.getString("student_dob"));
			model.setSdoj(rs.getString("student_doj"));
			data.add(model);		
		}		
		return data;	
	}
/*--------------------Update Data by id ----------------------------------------------------------------- */	
	public crudmodel updatetStud(crudmodel stud) 
	{
		String insert = "update students set student_name=?,student_dob=?,student_doj=? where student_no=?";
		int a=102;
		try 
		{
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, stud.getSname());
			ps.setDate(2,Date.valueOf(stud.getSdob()));
            ps.setDate(3,Date.valueOf(stud.getSdoj()));
            ps.setLong(4,stud.getSno());
			
			ps.executeUpdate();
		}
		catch(Exception e) 
		{
			System.out.println(e +"data insert unsuccess.");
		}
		
		return stud;
		
	}
/*--------------------Update Data by id ----------------------------------------------------------------- */	
	public int deletetStud(int id) 
	{
		String insert = "delete from students where student_no =?";
		
		try 
		{
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}
		catch(Exception e) 
		{
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
	}	
	 
}

