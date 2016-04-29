package com.sii.biblioteca.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.PreparedStatement;
import com.sii.biblioteca.models.User;

public class UserController extends BaseController<User> {

	public UserController() {
		super(User.class);
		
	}
	
	public boolean verificaType(String user,String pass) throws SQLException
	{
		openConnection();
		boolean logic=false;
		String sql="SELECT nume,pass FROM user WHERE nume=? AND pass=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			
		ps.setString(1, user);
		ps.setString(2, pass);
		
		
		ResultSet rs=ps.executeQuery();
			
		String checkUser=null;
		String checkPass=null;
	
		if(rs.next())
		{
			checkUser=rs.getString(1);
			checkPass=rs.getString(2);
			
		}
				
		if(checkUser!=null && checkPass!=null )
		
			if((checkUser.equals(user)) && (checkPass.equals(pass)))
				logic=true;
			else
				logic=false;
		
				
		
			
			rs.close();
			ps.close();
		    closeConnection();
		    
	return logic;
		
	}
	
	public int adminActiv(String n,String p) throws SQLException
	{
		int admin=-1;
		openConnection();
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement("SELECT admin FROM user WHERE nume=? and pass=?");
		ps.setString(1, n);
		ps.setString(2, p);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			admin=rs.getInt(1);
			
		}
		return admin;
	}
	
	public void AddUser(User u) throws SQLException
	{
		openConnection();
		PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?)");
		stmt.setInt(1, u.getId());
		stmt.setString(2, u.getNume());
		stmt.setString(3, u.getPass());
		stmt.setInt(4, u.getType());
		stmt.setInt(5, u.getAdmin());
		stmt.executeUpdate();
		stmt.close();
		closeConnection();
	}

	
	public int tipUser(String n,String p) throws SQLException
	{
		int tip=-1;
		openConnection();
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement("SELECT type FROM user WHERE nume=? and pass=?");
		ps.setString(1, n);
		ps.setString(2, p);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			tip=rs.getInt(1);
			
		}
		return tip;
	}
	
	
	public ArrayList<User> selectNume(ArrayList<User> utilizatori) throws SQLException
	{
		openConnection();
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement("SELECT nume FROM user WHERE type>0");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			User u=new User();
			u.setNume(rs.getString("nume"));
			utilizatori.add(u);
		}
		rs.close();
		ps.close();
		closeConnection();
		return utilizatori;
	}
	
	public void modificaParola(String pass,String nume)
	{
		
		openConnection();
		 try {

	            String sql        = "UPDATE user SET pass=? "
	                     + " WHERE nume = ?";

	            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
	            pst.setString(1, pass);
	            pst.setString(2, nume);
	            pst.executeUpdate();
	            System.out.println("Updated Successfully!");

	          

	         } catch (SQLException e) {
	           
	            e.printStackTrace();
	         }
		
         closeConnection();
		
	}
	
}
