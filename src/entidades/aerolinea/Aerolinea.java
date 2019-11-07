package entidades.aerolinea;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import entidades.vuelo.Vuelo;

@PersistenceCapable
public class Aerolinea {

	@PrimaryKey
	private int id_aerolinea;
	
	private String nombre;
	private Vuelo id_vuelo; //private int id_vuelo;
	 
	
}
