package com.sii.biblioteca.controllers;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Edituri;

public class CartiController extends BaseController<Carti>{

	public CartiController() {
		super(Carti.class);
		
	}
	
	public void modificaStareToDisponibil(int idCarti)
	{
		
		openConnection();
		 try {

	            String sql        = "UPDATE carti SET status =1 "
	                     + " WHERE idCarti = ?";

	            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
	            pst.setInt(1, idCarti);
	            pst.executeUpdate();
	            System.out.println("Updated Successfully!");

	          

	         } catch (SQLException e) {
	            System.out.println("Exception 1!");
	            e.printStackTrace();
	         }
		
         closeConnection();
		
	}
	public void modificaStareToIndisponibil(int status,int idCarti)
	{
		
		openConnection();
		 try {

	            String sql        = "UPDATE carti SET status =? "
	                     + " WHERE idCarti =?";

	            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
	            pst.setInt(1, status);
	            pst.setInt(2, idCarti);
	            pst.executeUpdate();
	            System.out.println("Updated Successfully!");

	          

	         } catch (SQLException e) {
	            System.out.println("Exception 0!");
	            e.printStackTrace();
	         }
		
         closeConnection();
		
	}
	
	
	
	
	
	/*public List<Carti> getTitluStatus(int status)
	{
		List<Carti> lista=new ArrayList<Carti>();
		openConnection();//ca sa nu ma mai conectez de 100 de ori,apelez metoda de conexiune
		try
		{
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT titlu,status FROM carti WHERE status= ?");
			ps.setInt(1, status);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Carti c=new Carti();
				//c.setAn(rs.getInt("an"));
				//c.setIdEditura(rs.getInt("idEditura"));
				//c.setIdCarti(rs.getInt("idCarti"));
				c.setTitlu(rs.getString("titlu"));
				//c.setPret(rs.getDouble("pret"));
				c.setStatus(rs.getBoolean("status"));
				//c.setNr_imprumuturi(rs.getInt("nr_imp"));
				
			
				lista.add(c);
			}
			rs.close();
			ps.close();
		
		}catch(Exception e){
			
		}
       closeConnection();
		
		return lista;*/
	
	
	public List<Carti> topCarti()
	{
		List<Carti>carte=new ArrayList<Carti>();
		openConnection();
		Statement stmt=null;
		try{
			
			stmt=conn.createStatement();
			String sql="SELECT titlu,nr_imp FROM carti order by nr_imp desc;";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Carti c=new Carti();
				c.setTitlu(rs.getString("titlu"));
				c.setNr_imprumuturi(rs.getInt("nr_imp"));
				carte.add(c);
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){ex.printStackTrace();}
		closeConnection();
		return carte;
		
	}
	
	
	
	public ArrayList<Carti> vreauTitlu(ArrayList<Carti> carte)
	{
		openConnection();
		Statement stmt=null;
		try
		{
			stmt=conn.createStatement();
			String sql="SELECT idCarti,titlu FROM carti";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Carti c=new Carti();
				c.setIdCarti(rs.getInt(1));
				c.setTitlu(rs.getString(2));
				carte.add(c);
			}
			rs.close();
			stmt.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		closeConnection();
		return carte;
		
	}
	
   public void AddCarti(Carti c) throws SQLException
   {
	   openConnection();
	   PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("INSERT INTO carti VALUES (?,?,?,?,?,?,?)");
	   stmt.setInt(1, c.getIdCarti());
	   stmt.setString(2, c.getTitlu());
	   stmt.setDouble(3, c.getPret());
	   stmt.setInt(4, c.getStatus());
	   stmt.setInt(5, c.getIdEditura());
	   stmt.setInt(6, c.getAn());
	   stmt.setInt(7, c.getNr_imprumuturi());
	   stmt.executeUpdate();
	   stmt.close();
	   closeConnection();
   }
	
   public List<Carti> sumaPeAn() throws SQLException
   {
	   List<Carti> carte=new ArrayList<Carti>();
   
	   openConnection();
		Statement stmt=null;
		try
		{
			stmt=conn.createStatement();
			String sql="SELECT pret,an FROM carti";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Carti c=new Carti();
				c.setPret(rs.getDouble("pret"));
				c.setAn(rs.getInt("an"));
				carte.add(c);
			}
			rs.close();
			stmt.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		closeConnection();
		return carte;
		
   }
   
   

public ArrayList<Carti> vreauID(ArrayList<Carti> lista) {
	openConnection();
	Statement stmt=null;
	try{
		
		stmt=conn.createStatement();
		String sql="SELECT idCarti FROM carti ";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			Carti c=new Carti();
			c.setIdCarti(rs.getInt("idCarti"));
			lista.add(c);
		}
		rs.close();
		stmt.close();
	}catch(SQLException ex){ex.printStackTrace();}
	closeConnection();
	return lista;
	
}


public void getStatus() throws SQLException
{
	   

	   openConnection();
		Statement stmt=null;
		try
		{
			stmt=conn.createStatement();
			String sql="SELECT status FROM carti";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Carti c=new Carti();
                c.setStatus(rs.getInt("status"));
				
			}
			rs.close();
			stmt.close();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		closeConnection();
		
		
}


   
}
