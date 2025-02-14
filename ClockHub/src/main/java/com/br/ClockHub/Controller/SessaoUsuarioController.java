package com.br.ClockHub.Controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("sessaoUsuarioBean")
@SessionScoped
public class SessaoUsuarioController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String loginUsuario;
	
	
	public String getLoginUsuario() { // O método agora corresponde ao nome usado no XHTML
        return loginUsuario;
    }

    public void setLoginUsuario(String sessaoUsuario) {
        this.loginUsuario = sessaoUsuario;
    }

    public void encerrarSessao() {
    	loginUsuario = null;
    }    
    
}
