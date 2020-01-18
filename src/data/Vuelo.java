package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
public class Vuelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private String fecha;
	private int numAsientos;
	private Aerolinea aerolinea; 
	private String numVuelo;
	
	@Persistent(mappedBy = "vuelo")
	private List<Reserva> reservas = new ArrayList<>();
	
	
	public Vuelo() {
	}
	
	public void testToString() {
		System.out.println(aeropuertoDestino);
		System.out.println(aeropuertoOrigen);
		System.out.println(fecha);
		System.out.println(numAsientos);
		System.out.println(aerolinea.getNombre());
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

	public String getNumVuelo() {
		return numVuelo;
	}

	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
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
 