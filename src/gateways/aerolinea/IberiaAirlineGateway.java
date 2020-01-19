package gateways.aerolinea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import Ryanair.VueloRyanair;
import data.Vuelo;
import data.dto.UsuarioDTO;
import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;
import server.data.VueloIberia;
import server.remote.IAerolineaIberia;

public class IberiaAirlineGateway implements IGatewayAerolinea {
	
	static String IP = "127.0.0.1";
	static int Puerto = 1099;
	static String ServiceName = "Aerolinea_Iberia";
	private Socket socket;
	
	 public IberiaAirlineGateway() {
		// TODO Auto-generated constructor stub
			
		 
	}
	 
	 
	 

	 

	@Override
	public ArrayList<VueloDTO> getAllVuelos() throws RemoteException {
		// TODO Auto-generated method stub

		ArrayList<VueloDTO> r = new ArrayList<>();;
		
		try (Socket tcpSocket = new Socket(this.IP, this.Puerto);
			    ObjectInputStream in = new ObjectInputStream(tcpSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			

			ArrayList<VueloDTO> vueloIberia =new ArrayList<VueloDTO>();
			vueloIberia =  (ArrayList<VueloDTO>) in.readObject(); 
			
			VueloDTO v = new VueloDTO();
			for(int i = 0; i< vueloIberia.size(); i++) {
				v.setNumVuelo(vueloIberia.get(i).getNumVuelo());
				v.setNumAsientos(vueloIberia.get(i).getNumAsientos());
				v.setAeropuertoDestino(vueloIberia.get(i).getAeropuertoDestino());
				v.setAeropuertoOrigen(vueloIberia.get(i).getAeropuertoOrigen());
				v.setFecha(vueloIberia.get(i).getFecha());
				v.setNomAerolinea(vueloIberia.get(i).getNomAerolinea());		
				r.add(v);
			}
			
			
		}catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return r;
		
		
		
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
			VueloDTO v = null;
				String parametros = aeropuertoDestino + ";" + aeropuertoOrigen + ";" + fecha +";" +asientos;
				
				
				try (Socket tcpSocket = new Socket(this.IP, this.Puerto);
					    ObjectInputStream in = new ObjectInputStream(tcpSocket.getInputStream());
						DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
					
					out.writeUTF(parametros);
					VueloDTO vueloIberia =new VueloDTO();
					vueloIberia =  (VueloDTO) in.readObject(); 
					
					 v = new VueloDTO();
					
					v.setNumVuelo(vueloIberia.getNumVuelo());
					v.setNumAsientos(vueloIberia.getNumAsientos());
					v.setAeropuertoDestino(vueloIberia.getAeropuertoDestino());
					v.setAeropuertoOrigen(vueloIberia.getAeropuertoOrigen());
					v.setFecha(vueloIberia.getFecha());
					v.setNomAerolinea(vueloIberia.getNomAerolinea());		
					
					
					
					
					
				}catch (UnknownHostException e) {
					System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
				} catch (EOFException e) {
					System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
				} catch (IOException e) {
					System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated m
		
		
		return v;
	}

	@Override
	public ArrayList<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		String parametros = aeropuertoOrigen + ";" +  fecha + ";" + asientos;
		System.out.println(parametros);
		ArrayList<VueloDTO> r = new ArrayList<>();;
		
		try (Socket tcpSocket = new Socket(this.IP, this.Puerto);
			    ObjectInputStream in = new ObjectInputStream(tcpSocket.getInputStream());
				DataOutputStream out = new DataOutputStream(tcpSocket.getOutputStream())){
			
			out.writeUTF(parametros);
			ArrayList<VueloDTO> vueloIberia =new ArrayList<VueloDTO>();
			vueloIberia =  (ArrayList<VueloDTO>) in.readObject(); 
			
			VueloDTO v = new VueloDTO();
			for(int i = 0; i< vueloIberia.size(); i++) {
				v.setNumVuelo(vueloIberia.get(i).getNumVuelo());
				v.setNumAsientos(vueloIberia.get(i).getNumAsientos());
				v.setAeropuertoDestino(vueloIberia.get(i).getAeropuertoDestino());
				v.setAeropuertoOrigen(vueloIberia.get(i).getAeropuertoOrigen());
				v.setFecha(vueloIberia.get(i).getFecha());
				v.setNomAerolinea(vueloIberia.get(i).getNomAerolinea());		
				r.add(v);
			}
			
			
		}catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public boolean reservarVuelo(VueloDTO vuelo, String nombre, int plazas) throws RemoteException {
		// TODO Auto-generated method stub
		String parametros = vuelo + ";" + nombre + ";" + plazas;
		boolean r = false;
		
		try {
			System.out.println(IP+":"+Puerto);
			socket = new Socket(this.IP, this.Puerto);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(parametros);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			r = Boolean.parseBoolean(in.readUTF());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return r;
	}

	
	
	
	


}
