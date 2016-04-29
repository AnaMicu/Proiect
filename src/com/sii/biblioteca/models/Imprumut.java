package com.sii.biblioteca.models;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Imprumut extends BaseModel{
	
	

	int idImp;
	int idAbonat;
	int idCarti;
	Date data_imp;
	Date data_rest;
	
	public int getIdImp() {
		return idImp;
	}
	public void setIdImp(int idImp) {
		this.idImp = idImp;
	}
	public int getIdAbonat() {
		return idAbonat;
	}
	public void setIdAbonat(int idAbonat) {
		this.idAbonat = idAbonat;
	}
	public int getIdCarti() {
		return idCarti;
	}
	public void setIdCarti(int idCarti) {
		this.idCarti = idCarti;
	}
	public Date getData_imp() {
		return data_imp;
	}
	public void setData_imp(Date data_imp) {
		this.data_imp = data_imp;
	}
	public Date getData_rest() {
		return data_rest;
	}
	public void setData_rest(Date data_rest) {
		this.data_rest = data_rest;
	}
	
	public Imprumut(){}
	
	public Imprumut(int idImp, int idAbonat, int idCarti, Date data_imp,
			Date data_rest) {
		super();
		this.idImp = idImp;
		this.idAbonat = idAbonat;
		this.idCarti = idCarti;
		this.data_imp = data_imp;
		this.data_rest = data_rest;
	}
	
	/* private String getDateTime() {
	     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     Date date = new Date();
	     return dateFormat.format(date);
	 }
	
	public String restituieData()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String sd = df.format(new Date(data_rest.getTime()));
		return sd;
	}*/
	
	public String toString() {
		return "Nr_Imprumut : "  +  idImp + "       " +"Id_Abonat : "   +  idAbonat+ "        " +"Id_Carti : "      +  idCarti
				+ "       "+"Data_Restituire   :  "   +  data_rest ;
	}

}
