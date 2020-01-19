package bin;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.Reserva;
import data.dto.ReservaDTO;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;

public interface IEasyBookingServer extends Remote {

	public boolean login(String email, String password) throws RemoteException;
	public boolean register(String email, String password, String nombre, int edad, String aeropuertoPreferido) throws RemoteException;
	
	public boolean reservarYpagar(int precio, int plazas, String emailPaypal,String contrasenyaPaypal, String codigoVuelo, String emailUsuarioReserva);
	
	public List<VueloDTO> buscarVueloIdaYVuelta(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, String fechaVuelta, int asientos) throws RemoteException;
	public List<VueloDTO> buscarVueloIda(String aeropuertoDestino, String aeropuertoOrigen, String fechaIda, int asientos) throws RemoteException;
	public List<VueloDTO> getAllVuelos() throws RemoteException;
	public List<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException;
	
	/** Con un email te devuelve la lista de Reservas de ese usuario
	 * @param email
	 * @return
	 */
	public List<ReservaDTO> getReservasByUser(String email);
	public UsuarioDTO getUserInfo(String email);
	public VueloDTO getVueloInfo(String codVuelo) throws RemoteException;
}
