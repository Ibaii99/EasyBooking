package data.dto;

import java.util.ArrayList;
import java.util.List;

import data.Aerolinea;
import data.Pago;
import data.Reserva;
import data.Usuario;
import data.Vuelo;
import db.DataAccessObject;

public class DTOAssembler {

	private static DataAccessObject db = new DataAccessObject();
	
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
		dto.setPaypalEmail(p.getPaypalEmail());
		dto.setTarjetaNumero(p.getTarjetaNumero());
		dto.setTipoPago(p.getTipo());
		dto.setTarjetaTipo(p.getTarjetaTipo());
		dto.setTarjetaFechaCaducidad(p.getTarjetaFechaCaducidad());
		
		dto.setEmail(p.getReserva().getUsuario().getEmail());
		dto.setFecha(p.getReserva().getFecha());
		dto.setNumeroAsientos(p.getReserva().getNumeroAsientos());
		
		return dto;
	}
	
	public static Pago disassemble(PagoDTO dto) {
		Pago p = new Pago();
		p.setPaypalEmail(dto.getPaypalEmail());	
		p.setPrecio(dto.getPrecio());		
		p.setTarjetaFechaCaducidad(dto.getTarjetaFechaCaducidad());
		p.setTarjetaNumero(dto.getTarjetaNumero());
		p.setTarjetaTipo(dto.getTarjetaTipo());
		p.setTipo(dto.getTipo());
		
		List<Reserva> reservas = db.getReservas();
		
		for(Reserva reserva : reservas) {
			if(		reserva.getFecha().equals(dto.getFecha()) && 
					reserva.getNumeroAsientos() == dto.getNumeroAsientos() && 
					reserva.getUsuario().getEmail().equals(dto.getEmail())	) 
			{
					p.setReserva(reserva);
			}
		}
		
		return p;
	} 
	
	public static ReservaDTO assemble(Reserva r) {
		ReservaDTO dto = new ReservaDTO();
		dto.setFecha(r.getFecha());
		dto.setNumeroAsientos(r.getNumeroAsientos());
		dto.setTipoPago(r.getTipoPago());
		
		dto.setPaypalEmail(r.getPago().getPaypalEmail());
		dto.setPrecio(r.getPago().getPrecio());
		dto.setTarjetaNumero(r.getPago().getTarjetaNumero());
		dto.setEmail(r.getUsuario().getEmail());
		
		return dto;
	}

	public static Reserva disassemble(ReservaDTO dto) {
		Reserva r = new Reserva();
		r.setFecha(dto.getFecha());
		r.setNumeroAsientos(dto.getNumeroAsientos());
		r.setTipoPago(dto.getTipoPago());
		
		List<Reserva> reservas = db.getReservas();
		
		for(Reserva reserva : reservas) {
			if(		reserva.getPago().getPrecio()== dto.getPrecio() &&
					reserva.getPago().getPaypalEmail().equals(dto.getPaypalEmail()) &&
					reserva.getPago().getTarjetaNumero().contentEquals(dto.getTarjetaNumero()) &&
					reserva.getUsuario().getEmail().equals(dto.getEmail())	) 
			{
					r.setPago(reserva.getPago());
					r.setUsuario(r.getUsuario());
					r.setVuelo(r.getVuelo());
			}
		}
		
		return r;
	}
	
	public static UsuarioDTO assemble(Usuario u) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(u.getEmail());
		dto.setNombre(u.getNombre());
		
		return dto;
	}
	
	public static Usuario disassemble(UsuarioDTO dto) {
		Usuario u = new Usuario();
		u.setEmail(dto.getEmail());
		u.setNombre(dto.getNombre());
		
		List<Usuario> usuarios = db.getUsuarios();
		for(Usuario user: usuarios) {
			if(		user.getEmail().equals(dto.getEmail()) && 
					user.getNombre().equals(dto.getNombre())) 
			{
					u.setAeropuerto_preferido(user.getAeropuertoPreferido());
					u.setEdad(user.getEdad());
					u.setTipoLogin(user.getTipoLogin());
					u.setReservas(user.getReservas());
			}
		}
		
		return u;
	}
	
	public static VueloDTO assemble(Vuelo v) {
		VueloDTO dto = new VueloDTO();
		dto.setAeropuertoDestino(v.getAeropuertoDestino());
		dto.setAeropuertoOrigen(v.getAeropuertoOrigen());
		dto.setFecha(v.getFecha());
		dto.setNumAsientos(v.getNumAsientos());
		dto.setNomAerolinea(v.getAerolinea().getNombre());
		dto.setPrecioporPlaza(v.getPrecioporPlaza());
		return dto;
	}
	
	public static Vuelo disassemble(VueloDTO dto) {
		Vuelo v = new Vuelo();
		
		v.setAeropuertoDestino(dto.getAeropuertoDestino());
		v.setAeropuertoOrigen(dto.getAeropuertoOrigen());
		v.setFecha(dto.getFecha());
		v.setNumAsientos(dto.getNumAsientos());
		v.setPrecioporPlaza(dto.getPrecioporPlaza());
		List<Vuelo> vuelos = db.getVuelos();
		for(Vuelo vuelo : vuelos) {
			if(		vuelo.getAerolinea().getNombre().equals(dto.getNomAerolinea()) &&
					vuelo.getAeropuertoOrigen().equals(dto.getAeropuertoOrigen()) &&
					vuelo.getAeropuertoDestino().equals(dto.getAeropuertoDestino()) &&
					vuelo.getFecha().equals(dto.getFecha()) &&
					vuelo.getNumAsientos()==dto.getNumAsientos()) 
			{
					v.setAerolinea(vuelo.getAerolinea());
					v.setReservas(vuelo.getReservas());
			}	
		}

		return v;
	}
	
	
	
}
