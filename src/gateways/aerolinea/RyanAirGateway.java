package gateways.aerolinea;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;
import server.remote.IAerolineaRyanair;

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
		for(server.data.dto.VueloDTO vr : server.getAllVuelos()) {
			a.add(convertToLocalVueloDTO(vr));	
		}
		return a;
	}
	

	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos) throws RemoteException {
		ArrayList<VueloDTO> a = new ArrayList<VueloDTO>();
		for(server.data.dto.VueloDTO v : server.buscarVuelosDesdeOrigen(aeropuertoOrigen, fecha, asientos)) {
			a.add(convertToLocalVueloDTO(v));
		}
		return a;
	}
	
	@Override
	public boolean reservarVuelo(String codVuelo, String nombre, int plazas) throws RemoteException {
		return server.reservarVuelo(codVuelo, nombre, plazas);
	}

	@Override
	public VueloDTO getVuelo(String codVuelo) throws RemoteException {
		if(server.getVuelo(codVuelo)== null) return null;
		
		return convertToLocalVueloDTO(server.getVuelo(codVuelo));	
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos) 
			throws RemoteException {
		return convertToLocalVueloDTO(server.buscarVuelo(aeropuertoDestino, aeropuertoOrigen, fecha, asientos));
	}
	

	private VueloDTO convertToLocalVueloDTO(server.data.dto.VueloDTO vr) {
		VueloDTO v = new VueloDTO();
		v.setAeropuertoDestino(vr.getAeropuertoDestino());
		v.setAeropuertoOrigen(vr.getAeropuertoOrigen());
		v.setFecha(vr.getFecha());
		v.setNomAerolinea(vr.getNomAerolinea());
		v.setNumAsientos(vr.getNumAsientos());
		v.setNumVuelo(vr.getNumVuelo());
		v.setPrecioporPlaza(vr.getPrecio());
		return v;
	}
	


}
