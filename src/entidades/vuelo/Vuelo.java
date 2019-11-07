package entidades.vuelo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import entidades.aerolinea.Aerolinea;
@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id_vuelo;

	private String aeropuerto_destino;
	private String aeropuerto_origen;
	
	
	private Aerolinea aerolinea; 
	
	
}
 