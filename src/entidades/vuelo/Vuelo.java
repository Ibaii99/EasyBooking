package entidades.vuelo;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import entidades.aerolinea.Aerolinea;
import entidades.reserva.Reserva;
@PersistenceCapable
public class Vuelo {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long id_vuelo;

	private String aeropuerto_destino;
	private String aeropuerto_origen;
	
	
	private Aerolinea aerolinea; 
	
	@Join
	@Persistent(mappedBy="vuelo", dependentElement="true")
	private List<Reserva> reservas = new ArrayList<>();
	
}
 