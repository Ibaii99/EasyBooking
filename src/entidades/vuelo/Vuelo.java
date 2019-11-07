package entidades.vuelo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import entidades.aerolinea.Aerolinea;
@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	private int id_vuelo;
	
	private String codigo_aeropuerto;
	private Aerolinea a; //private int id_aerolinea
	

}
 