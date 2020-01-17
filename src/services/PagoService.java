package services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import gateways.IGatewayPago;
import gateways.pago.PaypalGateway;

public class PagoService {

	private List<IGatewayPago> pagos;
	
	public PagoService() {
		pagos = new ArrayList<IGatewayPago>();
		PaypalGateway paypal = new PaypalGateway();
		pagos.add(paypal);
	}
	
	public boolean pagar(int precio, String email, String contrasenya) throws RemoteException {
		return pagos.get(0).realizarPago(precio, email, contrasenya);
	}
	
}
