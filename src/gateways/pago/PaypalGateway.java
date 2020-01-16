package gateways.pago;

import gateways.IGatewayPago;

public class PaypalGateway implements IGatewayPago{

	static String IP = "127.0.0.1";
	static String Puerto = "";
	static String Service = "";
	
	public PaypalGateway() {
		// TODO conectar
	}
	
	@Override
	public boolean realizarPago(int precio, String email) {
		
		return false;
	}

}
