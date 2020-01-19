package gateways;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dto.UsuarioDTO;
import data.dto.VueloDTO;

public interface IGatewayAerolinea extends Remote {
//TODO Aerolinea Gateways method
	
	/**
	 * @param vuelo Vuelo que se quiere reservar
	 * @param nombre Nombre del usuario que quiere reservar el vuelo
	 * @return True si se ha reservado con exito, false si no
	 */
	public boolean reservarVuelo(String codVuelo, String nombre, int plazas) throws RemoteException;
	
	public List<VueloDTO> getAllVuelos() throws RemoteException;
	public VueloDTO getVuelo(String codVuelo) throws RemoteException;
	
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos) throws RemoteException;
	public List<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException;

	


}
