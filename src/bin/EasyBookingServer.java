package bin;


import java.util.List;

import data.Usuario;
import db.DataAccessObject;


public class EasyBookingServer {

	public static void main(String[] args) {
		System.out.println("inicio");
		DataAccessObject db = new DataAccessObject();
		db.createSomeDatos();
		List<Usuario> usr = db.getUsuarios();
		
		for(Usuario e: usr) {
			System.out.println(e.getEmail());
		}
		
		
	}
}
