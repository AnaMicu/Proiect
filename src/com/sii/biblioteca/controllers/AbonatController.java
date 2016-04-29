package com.sii.biblioteca.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Carti;

public class AbonatController extends BaseController<Abonat>{

	public AbonatController() {
		super(Abonat.class);

	}
public  List<Abonat> getOrdonare(int nr_penalizari)
{
	List<Abonat> abonat=new ArrayList<Abonat>();
	openConnection();
	try
	{
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement("SELECT * FROM abonat WHERE nr_penalizari =?");
		ps.setInt(1, nr_penalizari);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Abonat abn=new Abonat();
			abn.setIdAbonat(rs.getInt("idabonat"));
			abn.setCnp(rs.getString("cnp"));
			abn.setNume(rs.getString("nume"));
			abn.setPrenume(rs.getString("prenume"));
			abn.setOras(rs.getString("oras"));
			abn.setTel(rs.getString("tel"));
			abn.setStare(rs.getString("stare"));
			abn.setNr_penalizari(rs.getInt("nr_penalizari"));
			
			abonat.add(abn);
		}
		rs.close();
		ps.close();
	}catch(Exception ex)
	{
		
	}
	closeConnection();
	
	return abonat;
		
}

 public void AddAbonat(Abonat a) throws SQLException
{
	openConnection();
	PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("INSERT INTO abonat VALUES (?,?,?,?,?,?,?,?)");
	stmt.setInt(1, a.getIdAbonat());
	stmt.setString(2, a.getCnp());
	stmt.setString(3, a.getNume());
	stmt.setString(4, a.getPrenume());
	stmt.setString(5, a.getOras());
	stmt.setString(6, a.getTel());
	stmt.setString(7, a.getStare());
	stmt.setInt(8, a.getNr_penalizari());
	stmt.executeUpdate();
	stmt.close();
	closeConnection();
}
 
 public ArrayList<Abonat> vreauNume(ArrayList<Abonat> abonat)
 {
	 openConnection();
	 Statement stmt=null;
	 try
	 {
		stmt=conn.createStatement();
		String sql="SELECT idabonat,nume FROM abonat";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			Abonat a=new Abonat();
		    a.setIdAbonat(rs.getInt("idabonat"));
		    a.setNume(rs.getString("nume"));
		    abonat.add(a);
		}
		 rs.close();
		 stmt.close();
	 }catch(SQLException ex)
	 {
		 ex.printStackTrace();
	 }
	 closeConnection();
	return abonat;
	 
 }
 
 public List<Abonat> vreauTabel(String stare) throws SQLException
 {
	 List<Abonat> abonat=new ArrayList<Abonat>();
		openConnection();
		try
		{
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("SELECT * FROM abonat WHERE stare=?");
			ps.setString(1, stare);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Abonat abn=new Abonat();
				abn.setIdAbonat(rs.getInt("idabonat"));
				abn.setCnp(rs.getString("cnp"));
				abn.setNume(rs.getString("nume"));
				abn.setPrenume(rs.getString("prenume"));
				abn.setOras(rs.getString("oras"));
				abn.setTel(rs.getString("tel"));
				abn.setStare(rs.getString("stare"));
				abn.setNr_penalizari(rs.getInt("nr_penalizari"));
				
				abonat.add(abn);
			}
			rs.close();
			ps.close();
		}catch(Exception ex)
		{
			
		}
		closeConnection();

		return  abonat;

			
	}
 
 public int inactiv() throws SQLException
 {
	 openConnection();
	 Statement stmt=null;
	 
		 stmt=conn.createStatement();
			String sql="SELECT count(idabonat) FROM abonat WHERE stare='inactiv'";
			ResultSet rs=stmt.executeQuery(sql);
			  rs.next();
			    int rowCount = rs.getInt(1);
			    System.out.println(rowCount);

			    rs.close();
			    stmt.close();
			    conn.close();

		
		closeConnection();
		return rowCount;
		
 }
 
 
 
 
 public void modificaPenalizari(int idabonat)
	{
		
		openConnection();
		 try {

	            String sql        = "UPDATE abonat SET nr_penalizari =nr_penalizari+1 "
	                     + " WHERE idabonat = ?";

	            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
	            pst.setInt(1, idabonat);
	            pst.executeUpdate();
	            System.out.println("Updated Successfully!");

	          

	         } catch (SQLException e) {
	           
	            e.printStackTrace();
	         }
		
      closeConnection();
		
	}
 
 public ArrayList<Abonat> vreauIDAbnt(ArrayList<Abonat> lista) {
		openConnection();
		Statement stmt=null;
		try{
			
			stmt=conn.createStatement();
			String sql="SELECT idabonat FROM abonat ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				Abonat c=new Abonat();
				c.setIdAbonat(rs.getInt("idabonat"));
				lista.add(c);
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){ex.printStackTrace();}
		closeConnection();
		return lista;
		
	}
	
}
