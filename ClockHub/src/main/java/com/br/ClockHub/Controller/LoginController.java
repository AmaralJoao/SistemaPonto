package com.br.ClockHub.Controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.ClockHub.Service.UsuarioService;

@SessionScoped
@Named("loginBean")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;
	
	private UsuarioService usuarioService =  new UsuarioService();
	/*private SessaoUsuarioController sessaoUsuario = new SessaoUsuarioController();*/
	@Inject
	private SessaoUsuarioController sessaoUsuario;

	
	
	public String logar() {
		if (usuarioService.autenticar(login, senha)) {
			sessaoUsuario.setLoginUsuario(login);
			return "ponto?faces-redirect=true";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro, Usuario ou senha incorreto.!","erro"));
			return null;
		}
	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        sessaoUsuario.encerrarSessao();
        return "login?faces-redirect=true";
    }
	
	public String getUsername() {
        return login;
    }

    public void setUsername(String username) {
        this.login = username;
    }

    public String getPassword() {
        return senha;
    }

    public void setPassword(String password) {
        this.senha = password;
    }

}
