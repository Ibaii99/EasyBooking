package data.dto;

import java.util.ArrayList;
import java.util.List;

import data.Usuario;

public class UsuarioAssembler {

	private static UsuarioAssembler instance;
	
	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}
		return instance;
	}
	
	public UsuarioDTO entityToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNombre(usuario.getNombre());
		dto.setEmail(usuario.getEmail());
		
		return dto;
	}
	
	public List<UsuarioDTO> entityToDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			dtos.add(this.entityToDTO(usuario));
		}
		
		System.out.println("* Assembling users ...");
		
		return dtos;
	}
}
