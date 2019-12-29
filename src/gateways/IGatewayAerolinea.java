package gateways;



import java.util.Date;

import data.Vuelo;

public interface IGatewayAerolinea {
//TODO Aerolinea Gateways method

	public void connect();
	public void getConnection();
	public void getAllVuelos();
	public void buscarVuelosIdayVuelta(String aeropuerto, Date fechaIda, Date fechaVuelta, int asientos);
	public void buscarVuelos(String aeropuerto, Date fecha, int asientos);
	public void reservarVuelo(Vuelo vuelo);

}
