package com.sii.biblioteca.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Autor;
import com.sii.biblioteca.models.Carti_Autori;
import com.sii.biblioteca.utils.MyException;

public class AutorController extends BaseController<Autor> {

	public AutorController() {
		super(Autor.class);
	}
	
	
	public List<Autor> getAllAuthorsBornIn(int year) //throws MyException
	{
		List<Autor> authors = new ArrayList<Autor>();
		Timestamp start_date = null;
		Timestamp end_date = null;
		
		//get the first day of the year
		Calendar cs = new GregorianCalendar();
		cs.set(year, 0, 1, 0, 0, 0);
		start_date=new Timestamp(cs.getTimeInMillis());
		
		Calendar ce = new GregorianCalendar();
		ce.set(year, 11, 31, 24, 59, 59);
		end_date=new Timestamp(ce.getTimeInMillis());
		
		openConnection();
		
		try {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM autor WHERE DATE(data_nastere) BETWEEN ? AND ?");
				ps.setTimestamp(1, start_date);
				ps.setTimestamp(2, end_date);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNume(rs.getString("nume"));
			a.setData_nastere(rs.getTimestamp("data_nastere"));
			
			authors.add(a);
		}
		
		rs.close();
		ps.close();
		
		}catch(Exception e){
			//log the exception and throw it 
		}
		
		closeConnection();
		
		
		return authors;
	}

	
	/*public List<Autor> autorNume(int an)
	{
		List<Autor> authors = new ArrayList<Autor>();
		Timestamp start_date = null;
		Calendar cs = new GregorianCalendar();
		cs.set(an, 0, 1, 0, 0, 0);
		start_date=new Timestamp(cs.getTimeInMillis());
               openConnection();
		
		try {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM autor WHERE DATE(data_nastere) > ?");
				ps.setTimestamp(1, start_date);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Autor a = new Autor();
			a.setId(rs.getInt("id"));
			a.setNume(rs.getString("nume"));
			a.setData_nastere(rs.getTimestamp("data_nastere"));
			
			authors.add(a);
		}
		
		rs.close();
		ps.close();
		
		}catch(Exception e){
			//log the exception and throw it 
		}
		return authors;
	}*/
	public List<Carti_Autori> getTitluNume(int status,int an) throws SQLException
	{
		List<Carti_Autori> cartiautor=new ArrayList<Carti_Autori>();
		openConnection();
		try{
		PreparedStatement ps=(PreparedStatement)conn.prepareStatement("SELECT c.titlu,a.nume FROM autor a ,carti c,carti_autori ca where c.idCarti=ca.idCarti and a.id=ca.idAutor and  year (a.data_nastere) > ? and c.status=?");
		ps.setInt(1, an);
		ps.setInt(2, status);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Carti_Autori ca=new Carti_Autori();
			ca.setTitlu(rs.getString("titlu"));
			ca.setNume(rs.getString("nume"));
			cartiautor.add(ca);
			
		}
		rs.close();
		ps.close();
	}catch(Exception e){
		
	}
	
     closeConnection();
	
	return cartiautor;
	
}
	
	public void addAutor(Autor a) throws SQLException
	{
		openConnection();
		PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("INSERT INTO autor VALUES (?,?,?)");
		stmt.setInt(1,a.getId());
		stmt.setString(2, a.getNume());
		stmt.setDate(3, (Date) a.getData_nastere());
		stmt.executeUpdate();
		stmt.close();
		closeConnection();
	}
	
	
	public  List<Autor> getIdDupaNume(int id)
	{
		List<Autor> autor=new ArrayList<Autor>();
		openConnection();
		try
		{
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("SELECT nume FROM autor WHERE id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Autor aut=new Autor();
				
				aut.setNume(rs.getString("nume"));
				
				
				autor.add(aut);
			}
			rs.close();
			ps.close();
		}catch(Exception ex)
		{
			
		}
		closeConnection();
		
		return autor;
			
	}
	
	
}
