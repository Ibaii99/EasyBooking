package bin;



import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	private static AerolineaService aerolineas = new AerolineaService();
	private AutentificationService autentification = new AutentificationService();
	private static PagoService pago;
	public static DataAccessObject db;
	public static DTOAssembler assem;
	
	public static void main(String[] args) {
		//pago = new PagoService(); //Descomentar para usarlo
		assem = new DTOAssembler();
		db = new DataAccessObject();
		System.out.println("inicio");
		db.createSomeDatos();
		//register("ibai2.guillen@opendeusto.es","1qwerty78","ibai2",22,"BIO")
		try {
			for(VueloDTO v : aerolineas.getAllVuelos()) {
				v.testToString();
			}
		} catch (RemoteException e) {
			System.out.println("Error"+ e.getMessage());
			e.printStackTrace();
		}
		/*
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
		*/
		db.closeConection();
	}
	
	public boolean reservarYpagar(int precio, int plazas, String emailPaypal,String contrasenya, VueloDTO vuelo, String emailUsuarioReserva) {
		try {
			if(pago.tieneFondos(precio, emailPaypal, contrasenya) == true) {
				//if(aerolineas.reservarVuelo(vuelo, plazas) == true) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				    Date date = new Date();  
					String fecha = formatter.format(date);
					
					Usuario u = new Usuario();
					u = db.getUserByEmail(emailUsuarioReserva);
					
					Vuelo v = assem.disassemble(vuelo);
					
					Pago p = new Pago();
					Reserva r = new Reserva();
									
					r.setFecha(fecha);
					r.setNumeroAsientos(plazas);
					
					r.setTipoPago("paypal");
					r.setUsuario(u);
					r.setVuelo(v);
					
					p.setPaypalEmail(emailPaypal);
					p.setPrecio(precio);
					p.setTipo("paypal");

					r.setPago(p);
					p.setReserva(r);
					
//					p.setTarjetaFechaCaducidad(tarjetaFechaCaducidad);
//					p.setTarjetaNumero(tarjetaNumero);
//					p.setTarjetaTipo(tarjetaTipo);
					db.store(r);
					db.store(p);
					db.store(v);
					
					pago.pagar(precio, emailPaypal, contrasenya);
					return true;
				//}
			}
		} catch (Exception e) {
			System.err.println("- Error al pagar: " + e.getMessage());
		}
		return false;
	}
	
	public boolean login(String email, String password) throws RemoteException {
		if(autentification.login(email, password) ==  true){
			for( Usuario u : db.getUsuarios()) {
				if(u.isUser(email)== true) return true;
			}
		}
		return false;
	}
	
	public void register(String email, String password, String nombre, int edad, String aeropuertoPreferido) throws RemoteException {
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
	
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta, int asientos) throws RemoteException {
		return aerolineas.buscarVuelo(aeropuertoDestino, aeropuertoOrigen, fechaIda, fechaVuelta, asientos);
	}
	
	public ArrayList<VueloDTO> getAllVuelos() throws RemoteException{
		return aerolineas.getAllVuelos();
	}
	
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException{
		return aerolineas.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos);
	}
	
	//Funciona
	/** Con un email te devuelve la lista de Reservas de ese usuario
	 * @param email
	 * @return
	 */
	public List<Reserva> getReservasByUser(String email) {
		Usuario u = db.getUserByEmail(email);
		return u.getReservas();
	}

}