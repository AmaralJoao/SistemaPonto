package com.br.ClockHub.Service;

import java.util.Objects;

import com.br.ClockHub.Model.UsuarioModel;
import com.br.ClockHub.Repository.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	public Boolean autenticar(String login, String senha) {
		 UsuarioModel usuario = usuarioRepository.localizarPorLogin(login);
	     return usuario != null && Objects.equals(usuario.getPassword(), senha);
	}

}
