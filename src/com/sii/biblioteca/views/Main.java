package com.sii.biblioteca.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sii.biblioteca.controllers.AbonatController;
import com.sii.biblioteca.controllers.AutorController;
import com.sii.biblioteca.controllers.CartiController;
import com.sii.biblioteca.controllers.UserController;
import com.sii.biblioteca.models.Abonat;
import com.sii.biblioteca.models.Autor;
import com.sii.biblioteca.models.Carti;
import com.sii.biblioteca.models.Carti_Autori;
import com.sii.biblioteca.models.User;

public class Main {

	public static void main(String[] args) throws SQLException {

		//example 1 - uncomment&test
		/*List<Autor> autori = new AutorController().selectAll();
		for (Autor a : autori) {
			System.out.println(a.getNume());
		}
	}*/

		//example 2
		/*List<Autor> autori = new AutorController().getAllAuthorsBornIn(1850);
		for (Autor a : autori) {
			System.out.println(a.getNume().concat(" was born on ").concat(a.getDataNastereString()));
		}*/
		
		//ex3
		/*List<Carti>carte=new CartiController().getFromCarteByStare(1);
		for (Carti a : carte) {
		System.out.println(a.getTitlu());
		}*/
		
		//ex4
		/*List<Abonat>abonati=new AbonatController().getOrdonare(0);
		for(Abonat ab :abonati)
		{
			System.out.println(ab.getNume() + " " +  ab.getPrenume());
		}*/
		
	
		
		//ex5
		/*List<Autor>ath=new AutorController().autorNume(1840);
		for(Autor a:ath)
		{
			System.out.println(a.getNume());
		}*/
		//ex6
		/*List<Carti>book=new CartiController().getTitluStatus(1);
		for(Carti b :book)
		{
			System.out.println(b.getTitlu());
		}*/
		/*List<Carti_Autori>ca=new AutorController().getTitluNume(1, 1840);
		for(Carti_Autori c:ca)
		{
			System.out.println(c.getNume() + " " +  c.getTitlu());
		}*/
		
	/*boolean uss=new UserController().verificaType("ana","micu");
	System.out.println(uss);
		
	}*/
	
	
}
}

