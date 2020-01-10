package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Aerolinea implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	private String codAerolinea;
	private String nombre;

	@Persistent(mappedBy = "aerolinea")
	private List<Vuelo> vuelos = new ArrayList<>();
	
	public Aerolinea() {
	}
	
	public String getCodAerolinea() {
		return this.codAerolinea;
	}
	
	public void setCodAerolinea(String codAerolinea) {
		this.codAerolinea = codAerolinea;
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
