package gateways.aerolinea;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import Ryanair.VueloRyanair;
import data.Vuelo;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class IberiaAirlineGateway implements IGatewayAerolinea {
	static String IP = "127.0.0.1";
	static String Puerto = "";
	static String Service = "";
	
	
	
	
	@Override
	public ArrayList<VueloRyanair> getAllVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public VueloRyanair buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<VueloRyanair> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean reservarVuelo(VueloRyanair vuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	


}
