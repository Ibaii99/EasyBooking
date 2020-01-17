package gateways.pago;

import java.rmi.RemoteException;

import gateways.IGatewayPago;
import server.remote.IServidorPago;

public class PaypalGateway implements IGatewayPago{

	static String IP = "127.0.0.1";
	static String Puerto = "1009";
	static String ServiceName = "ServidorPago";
	
	private IServidorPago server;
	
	public PaypalGateway() {
		try {
			server = (IServidorPago) java.rmi.Naming.lookup(ServiceName);
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
		}
	}
	
	@Override
	public boolean realizarPago(int precio, String email, String contrasenya) throws RemoteException {
		return server.realizarPago(precio, email, contrasenya);
	}

}
