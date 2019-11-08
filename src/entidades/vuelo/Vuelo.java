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
	private String fecha;


	private int num_asientos;


	private Aerolinea aerolinea; 
	
	@Join
	@Persistent(mappedBy="vuelo", dependentElement="true")
	private List<Reserva> reservas = new ArrayList<>();
	
	public Vuelo(int num_asientos, String fecha) {
		this.num_asientos = num_asientos;
		this.fecha = fecha;
	}

	public long getId_vuelo() {
		return id_vuelo;
	}

	public void setId_vuelo(long id_vuelo) {
		this.id_vuelo = id_vuelo;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getNum_asientos() {
		return num_asientos;
	}
	
	public void setNum_asientos(int num_asientos) {
		this.num_asientos = num_asientos;
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
 