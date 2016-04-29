package com.sii.biblioteca.controllers;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Autor;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Carti_Autori;

public class Carti_AutoriController extends BaseController<Carti_Autori>{

	public Carti_AutoriController() {
		super(Carti_Autori.class);
		
	}

	public void legatura(Carti_Autori ca) throws SQLException
	{
		openConnection();
		PreparedStatement stmt=(PreparedStatement) conn.prepareStatement("INSERT INTO abonat VALUES (?,?,?)");
		stmt.setInt(1,ca.getIdCA());
		stmt.setInt(2,ca.getIdC());
		stmt.setInt(3, ca.getIdA());
		stmt.close();
		closeConnection();
	}
	
	
}
