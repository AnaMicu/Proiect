package com.sii.biblioteca.controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.sii.biblioteca.models.Edituri;

public class EdituriController extends BaseController<Edituri>{

	public EdituriController() {
		super(Edituri.class);
		
	}
	
	public ArrayList<Edituri> stringEdituri(ArrayList<Edituri>editura)
	{
		openConnection();
		Statement stmt=null;
		try
		{
			stmt=conn.createStatement();
			String sql="SELECT idEditura,denumire FROM edituri";
            ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Edituri edit=new Edituri();
				edit.setIdEditura(rs.getInt("idEditura"));
				edit.setDenumire(rs.getString("denumire"));
				editura.add(edit);
			}
			rs.close();
			stmt.close();
		}catch(Exception e){
			
		}
		
		closeConnection();
		return editura;
		
		
	}

	
	
	

}
