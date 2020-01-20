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
import java.util.List;

import data.dto.VueloDTO;
import gateways.IGatewayAerolinea;

public class IberiaAirlineGateway implements IGatewayAerolinea {
	
	static String IP = "127.0.0.1";
	static int Puerto = 1024;
	static String ServiceName = "Aerolinea_Iberia";
	private Socket socket;
	
	public IberiaAirlineGateway() {
		 try (Socket tcpSocket = new Socket(IP, Puerto)){
			 
		} catch (UnknownHostException e) {
			System.err.println("# TCPSocketClient: Socket error: " + e.getMessage());
		} catch (EOFException e) {
			System.err.println("# TCPSocketClient: EOF error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("# TCPSocketClient: IO error: " + e.getMessage());
		}
	}

	@Override
	public boolean reservarVuelo(String codVuelo, String nombre, int plazas) throws RemoteException {
		String parametros = codVuelo + ";" + nombre + ";" + plazas;
		boolean r = false;
		
		try {
			System.out.println(IP+":"+Puerto);
			socket = new Socket(IP, Puerto);
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

	@Override
	public List<VueloDTO> getAllVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<VueloDTO> r = new ArrayList<>();;

		try (Socket tcpSocket = new Socket(IP, Puerto);
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
		return r;	}

	@Override
	public VueloDTO getVuelo(String codVuelo) throws RemoteException {
		
		VueloDTO v = null;
		String parametros = codVuelo;;

		try (Socket tcpSocket = new Socket(IP, Puerto);
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
			e.printStackTrace();
		}
return v;
		
	}

	@Override
	public VueloDTO buscarVuelo(String aeropuertoDestino, String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		VueloDTO v = null;
		String parametros = aeropuertoDestino + ";" + aeropuertoOrigen + ";" + fecha +";" +asientos;

		try (Socket tcpSocket = new Socket(IP, Puerto);
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
			e.printStackTrace();
		}
return v;
	}

	@Override
	public List<VueloDTO> buscarVuelosDesdeOrigen(String aeropuertoOrigen, String fecha, int asientos)
			throws RemoteException {
		String parametros = aeropuertoOrigen + ";" +  fecha + ";" + asientos;
		System.out.println(parametros);
		ArrayList<VueloDTO> r = new ArrayList<>();

		try (Socket tcpSocket = new Socket(IP, Puerto);
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
			e.printStackTrace();
		}
		return r;
	}

}