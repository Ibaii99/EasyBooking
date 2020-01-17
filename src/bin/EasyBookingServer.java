package bin;



import java.util.ArrayList;
import java.util.List;

import data.Pago;
import data.Reserva;
import data.Usuario;
import data.Vuelo;
import data.dto.DTOAssembler;
import data.dto.PagoDTO;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;
import db.DataAccessObject;
import services.AerolineaService;
import services.AutentificationService;
import services.PagoService;


public class EasyBookingServer {
	private AerolineaService aerolineas = new AerolineaService();
	private AutentificationService autentification = new AutentificationService();
	private PagoService pago = new PagoService();
	public static DataAccessObject db;
	public static DTOAssembler assem;
	
	public static void main(String[] args) {
		assem = new DTOAssembler();
		db = new DataAccessObject();
		System.out.println("inicio");
		db.createSomeDatos();
		
		for(Reserva reserva: db.getReservas()) {
			//TODO
			try {
			System.out.println("asassasaassaassa");
			reserva.testToString();
			reserva.getUsuario().testToString();
			reserva.getPago().testToString();
			reserva.getVuelo().testToString();
			System.out.println("------------------");
			} catch(Exception exc) { exc.printStackTrace();}
			}
		
		DTOAssembler dto = new DTOAssembler();
		for(Usuario e: db.getUsuarios()) {
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("###Printing reserva");
			e.reservasToString();
			System.out.println("###Printing usuario" + e.getNombre());
			e.testToString();
			UsuarioDTO usrdto = dto.assemble(e);
			System.out.println("Printing usuario DTO");
			usrdto.testToString();
			System.out.println("###Printing usuario disassembled");
			Usuario usrdisassem = dto.disassemble(usrdto);
			usrdisassem.testToString();
			System.out.println("----------------------");
			System.out.println("### Reservas before");
			e.reservasToString();
			System.out.println("### Reservas after");
			try {
			usrdisassem.reservasToString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("------------------------------\n");
			
		}
		
		db.closeConection();
	}
	
	public boolean reservarYpagar(int precio, int plazas, String emailPaypal, VueloDTO vuelo, String emailUsuarioReserva, String nombreUsuario) {
		if(pago.pagar(precio, emailPaypal) == true) {
			if(aerolineas.reservarVuelo(vuelo, nombreUsuario, plazas) == true) {
				PagoDTO p = new PagoDTO();
				p.setEmail(emailPaypal);
				p.setFecha("");
				p.setNumeroAsientos(plazas);
				p.setPaypalEmail(emailPaypal);
				p.setPrecio(precio);
				p.setTipoPago("paypal");
				Pago pg = assem.disassemble(p);
				db.store(pg);
				Vuelo v = assem.disassemble(vuelo);
				db.store(v);
				Reserva r = new Reserva();
				r.setFecha("");
				r.setNumeroAsientos(plazas);
				r.setPago(pg);
				r.setTipoPago("paypal");
				UsuarioDTO u = new UsuarioDTO();
				u.setEmail(emailUsuarioReserva);
				u.setNombre(nombreUsuario);
				Usuario user = assem.disassemble(u);
				r.setUsuario(user);
				r.setVuelo(v);
				db.store(r);
				return true;
			}
		}
		return false;
	}
	
	public boolean login(String email, String password) {
		if(autentification.login(email, password) ==  true){
			for( Usuario u : db.getUsuarios()) {
				if(u.isUser(email)== true) return true;
			}
		}
		return false;
	}
	
	public void register(String email, String password, String nombre, int edad, String aeropuertoPreferido) {
		autentification.registrar(email, password);
		
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setNombre(nombre);
		user.setAeropuertoPreferido(aeropuertoPreferido);
		user.setEdad(edad);
		user.setEmail(email);
		user.setNombre(nombre);
		user.setTipoLogin("google");
		db.store(user);
		
	}
	
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta, int asientos) {
		return aerolineas.buscarVuelo(aeropuertoDestino, aeropuertoOrigen, fechaIda, fechaVuelta, asientos);
	}
	
	public ArrayList<VueloDTO> getAllVuelos(){
		return aerolineas.getAllVuelos();
	}
	
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos){
		return aerolineas.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos);
	}
	

}
