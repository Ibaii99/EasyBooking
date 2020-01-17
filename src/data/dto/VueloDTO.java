package data.dto;

import java.io.Serializable;

public class VueloDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String aeropuertoDestino;
	private String aeropuertoOrigen;
	private String fecha;
	private int numAsientos;
	//Aerolinea
	private String nomAerolinea;
	
	public VueloDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public void testToString() {
		System.out.println(aeropuertoDestino);
		System.out.println(aeropuertoOrigen);
		System.out.println(fecha);
		System.out.println(numAsientos);
		System.out.println(nomAerolinea);
	}

	public String getNomAerolinea() {
		return nomAerolinea;
	}



	public void setNomAerolinea(String nomAerolinea) {
		this.nomAerolinea = nomAerolinea;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
