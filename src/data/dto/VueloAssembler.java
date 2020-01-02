package data.dto;

import java.util.ArrayList;
import java.util.List;

import data.Vuelo;

public class VueloAssembler {

	private static VueloAssembler instance;
	
	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}
		return instance;
	}
	
	public VueloDTO entityToDTO(Vuelo vuelo) {
		VueloDTO dto = new VueloDTO();
		
		dto.setAeropuertoOrigen(vuelo.getAeropuertoOrigen());
		dto.setAeropuertoDestino(vuelo.getAeropuertoDestino());
		dto.setFecha(vuelo.getFecha());
		
		return dto;
	}
	
	public List<VueloDTO> entityToDTO(List<Vuelo> vuelos) {
		List<VueloDTO> dtos = new ArrayList<>();
		
		for (Vuelo vuelo : vuelos) {
			dtos.add(this.entityToDTO(vuelo));
		}
		
		System.out.println("* Assembling flights ...");
		
		return dtos;
	}
}
