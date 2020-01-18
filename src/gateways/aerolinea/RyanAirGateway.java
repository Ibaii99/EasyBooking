package gateways.aerolinea;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Ryanair.IAerolineaRyanair;
import Ryanair.VueloRyanair;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;
import server.remote.IServidorAutorizacion;

public class RyanAirGateway implements IGatewayAerolinea{
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String ServiceName = "Aerolinea_Ryanair";
	
	private IAerolineaRyanair server;
	
	public RyanAirGateway() {
		// TODO Auto-generated constructor stub
		try {
			server = (IAerolineaRyanair) java.rmi.Naming.lookup(ServiceName);
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
		}
	}
	
	@Override
	public ArrayList<VueloDTO> getAllVuelos() throws RemoteException {
		ArrayList<VueloDTO> a = new ArrayList<VueloDTO>();
		
		for(Ryanair.VueloDTO vr : server.getAllVuelos()) {
			VueloDTO v = new VueloDTO();
			v.setAeropuertoDestino(vr.getAeropuertoDestino());
			v.setAeropuertoOrigen(vr.getAeropuertoOrigen());
			v.setFecha(vr.getFecha());
			v.setNomAerolinea(vr.getNomAerolinea());
			v.setNumAsientos(vr.getNumAsientos());
			v.setNumVuelo(vr.getNumVuelo());
			a.add(v);
				
		}
		return a;
	}
	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean reservarVuelo(VueloDTO vuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	


}
