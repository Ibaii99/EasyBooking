package data.dto;

import data.Aerolinea;
import data.Pago;
import data.Reserva;
import data.Usuario;
import data.Vuelo;

public class DTOAssembler {
	//TODO los metodos de estas clases que contienen 
	//informacion sobre otras no se obtienen desensamblando 
	//esa clase, seria accediendo al dao y obteniendola de la base de datos
	
	public static AerolineaDTO assemble(Aerolinea a) {
		AerolineaDTO dto = new AerolineaDTO();
		dto.setCodAerolinea(a.getCodAerolinea());
		dto.setNombre(a.getNombre());
		return dto;
	}
	
	public static Aerolinea disassemble(AerolineaDTO dto) {
		Aerolinea a= new Aerolinea();
		a.setCodAerolinea(dto.getCodAerolinea());
		a.setNombre(dto.getNombre());
		return a;
	}
	
	public static PagoDTO assemble(Pago p) {
		PagoDTO dto = new PagoDTO();
		dto.setPrecio(p.getPrecio());
		dto.setTipo(p.getTipo());
		return dto;
	}
	
	public static Pago disassemble(PagoDTO dto) {
		Pago p = new Pago();
		p.setPaypalEmail(dto.getPaypalEmail());
		p.setPrecio(dto.getPrecio());
		p.setReserva(disassemble(dto.getReserva()));
		p.setTarjetaFechaCaducidad(dto.getTarjetaFechaCaducidad());
		p.setTarjetaNumero(dto.getTarjetaNumero());
		p.setTarjetaTipo(dto.getTarjetaTipo());
		p.setTipo(dto.getTipo());
		return p;
	} 
	
	public static ReservaDTO assemble(Reserva r) {
		ReservaDTO dto = new ReservaDTO();
		dto.setFecha(r.getFecha());
		dto.setNumeroAsientos(r.getNumeroAsientos());
		dto.setTipoPago(r.getTipoPago());
		return dto;
	}

	public static Reserva disassemble(ReservaDTO dto) {
		Reserva r = new Reserva();
		r.setFecha(dto.getFecha());
		r.setNumeroAsientos(dto.getNumeroAsientos());
		r.setPago(disassemble(dto.getPago()));
		r.setTipoPago(dto.getTipoPago());
		r.setUsuario(disassemble(dto.getUsuario()));
		r.setVuelo(disassemble(dto.getVuelo()));
		return r;
	}
	
	public static UsuarioDTO assemble(Usuario u) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(u.getEmail());
		dto.setNombre(u.getEmail());
		return dto;
	}
	
	public static Usuario disassemble(UsuarioDTO dto) {
		Usuario u = new Usuario();
		u.setEmail(dto.getEmail());
		u.setNombre(dto.getNombre());
		return u;
	}
	
	public static VueloDTO assemble(Vuelo v) {
		VueloDTO dto = new VueloDTO();
		dto.setAeropuertoDestino(v.getAeropuertoDestino());
		dto.setAeropuertoOrigen(v.getAeropuertoOrigen());
		dto.setFecha(v.getFecha());
		dto.setNumAsientos(v.getNumAsientos());
		return dto;
	}
	
	public static Vuelo disassemble(VueloDTO dto) {
		Vuelo v = new Vuelo();
		v.setAerolinea(aerolinea);
		v.setAeropuertoDestino(aeropuertoDestino);
		v.setAeropuertoOrigen(aeropuertoOrigen);
		v.setFecha(fecha);
		v.setNumAsientos(numAsientos);
		v.setReservas(reservas);
		return v;
	}
	
	
	
}
