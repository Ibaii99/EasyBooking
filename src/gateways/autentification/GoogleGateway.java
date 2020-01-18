package gateways.autentification;

import java.rmi.RemoteException;

import gateways.IGatewayAutorizacion;
import server.remote.IServidorAutorizacion;

public class GoogleGateway implements IGatewayAutorizacion{

	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String ServiceName = "ServidorAutorizacion";
	
	private IServidorAutorizacion server;
	
	public GoogleGateway() {
		try {
			server = (IServidorAutorizacion) java.rmi.Naming.lookup(ServiceName);
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
		}
	}
	
	@Override
	public void registrar(String email, String password) throws RemoteException {
		server.registrar(email, password);
	}

	@Override
	public boolean login(String email, String password) throws RemoteException {
		return server.login(email, password);
	}

}
