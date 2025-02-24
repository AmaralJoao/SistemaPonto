package com.br.ClockHub.Model;

import java.io.Serializable;

public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int cdUsuario;
	private String username;
	private String password;

	public UsuarioModel() {
	}

	public UsuarioModel(int id, String username, String password) {
		this.cdUsuario = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return cdUsuario;
	}

	public void setId(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
