package data.dto;

import java.io.Serializable;

import data.Pago;
import data.Usuario;
import data.Vuelo;

public class ReservaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tipoPago;
	private int numeroAsientos;
	private String fecha; // Habria que mirar la clase Date de java
	private UsuarioDTO usuario;
	private VueloDTO vuelo;
	private PagoDTO pago;
	
	public ReservaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoDTO getPago() {
		return pago;
	}

	public void setPago(PagoDTO pago) {
		this.pago = pago;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public VueloDTO getVuelo() {
		return vuelo;
	}

	public void setVuelo(VueloDTO vuelo) {
		this.vuelo = vuelo;
	}

	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public int getNumeroAsientos() {
		return numeroAsientos;
	}
	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
