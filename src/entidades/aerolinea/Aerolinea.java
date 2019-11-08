package entidades.aerolinea;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import entidades.reserva.Reserva;
import entidades.vuelo.Vuelo;

@PersistenceCapable
public class Aerolinea {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int id_aerolinea;
	private String nombre;

	@Join
	@Persistent(mappedBy = "aerolinea", dependentElement = "true")
	private List<Vuelo> vuelos = new ArrayList<>();
	
	public Aerolinea(String nombre) {
		this.nombre = nombre;
	}

	public int getId_aerolinea() {
		return id_aerolinea;
	}

	public void setId_aerolinea(int id_aerolinea) {
		this.id_aerolinea = id_aerolinea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	// Obtener numero de reservas
	public int getNumeroVuelos() {
		return vuelos.size();
	}

	// añadir reservas en la lista
	public void addReserva(Vuelo vuelo) {
		vuelos.add(vuelo);
	}

	// eliminar reserva de la lista
	public void removeReserva(Vuelo vuelo) {
		vuelos.remove(vuelo);
	}

}
