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

	public long getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(long id_vuelo) {
		this.id_vuelo = id_vuelo;
	}

	public String getAeropuerto_destino() {
		return aeropuerto_destino;
	}

	public void setAeropuerto_destino(String aeropuerto_destino) {
		this.aeropuerto_destino = aeropuerto_destino;
	}

	public String getAeropuerto_origen() {
		return aeropuerto_origen;
	}

	public void setAeropuerto_origen(String aeropuerto_origen) {
		this.aeropuerto_origen = aeropuerto_origen;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	
}
 