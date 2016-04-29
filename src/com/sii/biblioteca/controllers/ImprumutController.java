package com.sii.biblioteca.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Imprumut;

public class ImprumutController extends BaseController<Imprumut>{

	public ImprumutController() {
		super(Imprumut.class);
		
	}
	
	public void addLista(Imprumut i) throws SQLException
	   {
		   openConnection();
		   PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("INSERT INTO imprumut VALUES (?,?,?,?,?)");
		  stmt.setInt(1, i.getIdImp());
		  stmt.setDate(2, (java.sql.Date) i.getData_imp());
		  stmt.setDate(3, (java.sql.Date) i.getData_rest());
		  stmt.setInt(4, i.getIdAbonat());
		  stmt.setInt(5, i.getIdCarti());
		   stmt.executeUpdate();
		   stmt.close();
		   closeConnection();
	   }
	 
	public List<Imprumut> returnCarti()
	{
		List<Imprumut> lista=new ArrayList<Imprumut>();
		openConnection();
		Statement stmt=null;
		try
		{
			stmt=conn.createStatement();
			String sql="SELECT * FROM imprumut WHERE DATE(data_rest)<=CURDATE()";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Imprumut i=new Imprumut();
				i.setIdImp(rs.getInt("idImprumut"));
			   i.setIdCarti(rs.getInt("idCarti"));
			i.setIdAbonat(rs.getInt("idabonat"));
			i.setData_rest(rs.getDate("data_rest"));
				lista.add(i);
			}
			rs.close();
			stmt.close();
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	
		closeConnection();
		return lista;
		
	}

	
	public List<Imprumut> depasireReturnare()
	{
		List<Imprumut> lista=new ArrayList<Imprumut>();
		openConnection();
		Statement stmt=null;
		try
		{
			stmt=conn.createStatement();
			String sql="SELECT * FROM imprumut WHERE DATE(data_rest)<CURDATE()";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Imprumut i=new Imprumut();
			   i.setIdCarti(rs.getInt("idCarti"));
			i.setIdAbonat(rs.getInt("idabonat"));
			i.setData_rest(rs.getDate("data_rest"));
				lista.add(i);
			}
			rs.close();
			stmt.close();
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	
		closeConnection();
		return lista;
		
	}
	
	
}
