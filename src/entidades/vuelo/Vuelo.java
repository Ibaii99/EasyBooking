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
	private long idVuelo;

	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private String fecha;


	private int numAsientos;


	private Aerolinea aerolinea; 
	
	@Join
	@Persistent(mappedBy="vuelo", dependentElement="true")
	private List<Reserva> reservas = new ArrayList<>();
	
	public Vuelo(String aeropuertoOrigen, String aeropuertoDestino, int numAsientos, String fecha) {
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.numAsientos = numAsientos;
		this.fecha = fecha;
	}
	
	public Vuelo() {
		this.numAsientos = 0;
		this.fecha = "";
	}

	public long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getNumAsientos() {
		return numAsientos;
	}
	
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
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
	
	//Obtener numero de reservas
		public int getNumeroReservas() {
			return reservas.size();
		}
		
		//añadir reservas en la lista
		public void addReserva(Reserva reserva) {
			reservas.add(reserva);
		}

		//eliminar reserva de la lista
		public void removeReserva(Reserva reserva) {
			reservas.remove(reserva);
		}
	
	
	
}
 