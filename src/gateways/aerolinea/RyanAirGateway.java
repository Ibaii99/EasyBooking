package gateways.aerolinea;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Ryanair.IAerolineaRyanair;
import Ryanair.VueloRyanair;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class RyanAirGateway implements IGatewayAerolinea{
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String Service = "Aerolinea_Ryanair";
	private IAerolineaRyanair server;
	
	 public RyanAirGateway() {
		// TODO Auto-generated constructor stub
		try {
			server = (IAerolineaRyanair) java.rmi.Naming.lookup(Service);
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
		}
}

	@Override
	public ArrayList<VueloRyanair> getAllVuelos() throws RemoteException {
		server.getAllVuelos();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VueloRyanair buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		
		// TODO Auto-generated method stub
		return server.buscarVuelo(aeropuertoDestino, aeropuertoOrigen, fecha, asientos);
	}

	@Override
	public ArrayList<VueloRyanair> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		
		// TODO Auto-generated method stub
		return server.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos);
	}

	@Override
	public boolean reservarVuelo(VueloRyanair vuelo, String nombre, int plazas) throws RemoteException {
		
		// TODO Auto-generated method stub
		return server.reservarVuelo(vuelo, nombre, plazas);
	}
	
	 
	
	
	


}
