package entidades.aerolinea;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import entidades.vuelo.Vuelo;

@PersistenceCapable
public class Aerolinea {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int id_aerolinea;
	
	private String nombre;
	
	@Join
	@Persistent(mappedBy="aerolinea", dependentElement="true")
	private List<Vuelo> vuelos = new ArrayList<>();
	
}
