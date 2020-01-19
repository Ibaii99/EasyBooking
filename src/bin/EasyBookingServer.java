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
import data.dto.ReservaDTO;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;
import db.DataAccessObject;
import services.AerolineaService;
import services.AutentificationService;
import services.PagoService;


public class EasyBookingServer implements IEasyBookingServer{
	
	private static AerolineaService aerolineas = new AerolineaService();
	private AutentificationService autentification = new AutentificationService();
	private static PagoService pago;
	public static DataAccessObject db;
	public static DTOAssembler assem;
	
	public static void main(String[] args){
		pago = new PagoService(); //Descomentar para usarlo
		assem = new DTOAssembler();
		db = new DataAccessObject();
		
		System.out.println("inicio");
		db.createSomeDatos();
		try {
			for(VueloDTO v : aerolineas.getAllVuelos()) {
				v.testToString();
			}
		} catch (RemoteException e) {
			System.out.println("Error"+ e.getMessage());
			e.printStackTrace();
		}
		
		db.closeConection();
	}
	

	@Override
	public boolean login(String email, String password) throws RemoteException {
		if(autentification.login(email, password) ==  true){
			for( Usuario u : db.getUsuarios()) {
				if(u.isUser(email)== true) return true;
			}
		}
		return false;
	}
	
	
	@Override
	public boolean register(String email, String password, String nombre, int edad, String aeropuertoPreferido) throws RemoteException {
		if(autentification.login(email, password) == true) {
			Usuario user = new Usuario();
			user.setEmail(email);
			user.setNombre(nombre);
			user.setAeropuertoPreferido(aeropuertoPreferido);
			user.setEdad(edad);
			user.setEmail(email);
			user.setNombre(nombre);
			user.setTipoLogin("google");
			db.store(user);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean reservarYpagar(int precio, int plazas, String emailPaypal,String contrasenyaPaypal, String codigoVuelo, String emailUsuarioReserva) {
		try {
			if(pago.tieneFondos(precio, emailPaypal, contrasenyaPaypal) == true) {
				if(aerolineas.reservarVuelo(codigoVuelo, emailUsuarioReserva, plazas) == true) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				    Date date = new Date();  
					String fecha = formatter.format(date);
					
					Usuario u = new Usuario();
					u = db.getUserByEmail(emailUsuarioReserva);
					
					VueloDTO vue = aerolineas.getVuelo(codigoVuelo);
					Vuelo v = assem.disassemble(vue);
					
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
					
					db.store(r);
					db.store(p);
					db.store(v);
					
					pago.pagar(precio, emailPaypal, contrasenyaPaypal);
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println("- Error al pagar: " + e.getMessage());
		}
		return false;
	}
	
	@Override
	public List<VueloDTO> buscarVueloIda(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, int asientos) throws RemoteException {
		// TODO Auto-generated method stub
		return aerolineas.buscarVueloIda(aeropuertoDestino, aeropuertoOrigen, fechaIda, asientos);
	}
	
	
	@Override
	public List<VueloDTO> buscarVueloIdaYVuelta(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta, int asientos) throws RemoteException {
		return aerolineas.buscarVueloIdaYVuelta(aeropuertoDestino, aeropuertoOrigen, fechaIda, fechaVuelta, asientos);
	}
	
	@Override
	public List<VueloDTO> getAllVuelos() throws RemoteException{
		return aerolineas.getAllVuelos();
	}
	
	@Override
	public List<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException{
		return aerolineas.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos);
	}
	
	
	
	@Override
	public List<ReservaDTO> getReservasByUser(String email){
		Usuario u = db.getUserByEmail(email);
		List<ReservaDTO> r = new ArrayList<ReservaDTO>();
		for(Reserva res : u.getReservas()) {
			r.add(assem.assemble(res));
		}
		return r;
	}
	
	@Override
	public UsuarioDTO getUserInfo(String email) {
		Usuario u = db.getUserByEmail(email);
		return assem.assemble(u);
	}

	@Override
	public VueloDTO getVueloInfo(String codVuelo) throws RemoteException {
		return aerolineas.getVuelo(codVuelo);
	}

}