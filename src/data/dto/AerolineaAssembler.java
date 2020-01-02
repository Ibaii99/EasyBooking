package data.dto;

import java.util.ArrayList;
import java.util.List;

import data.Aerolinea;

public class AerolineaAssembler {
	
	private static AerolineaAssembler instance;
	
	private AerolineaAssembler() { }
	
	public static AerolineaAssembler getInstance() {
		if (instance == null) {
			instance = new AerolineaAssembler();
		}
		return instance;
	}
	
	public AerolineaDTO entityToDTO(Aerolinea aerolinea) {
		AerolineaDTO dto = new AerolineaDTO();
		
		dto.setCodAerolinea(aerolinea.getCodAerolinea());
		dto.setNombre(aerolinea.getNombre());
		
		return dto;
	}
	
	public List<AerolineaDTO> entityToDTO(List<Aerolinea> aerolineas) {
		List<AerolineaDTO> dtos = new ArrayList<>();
		
		for (Aerolinea aerolinea : aerolineas) {
			dtos.add(this.entityToDTO(aerolinea));
		}
		
		System.out.println("* Assembling airlines ...");
		
		return dtos;
	}
}
