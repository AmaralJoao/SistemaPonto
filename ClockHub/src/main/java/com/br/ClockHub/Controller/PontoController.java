package com.br.ClockHub.Controller;

import com.br.ClockHub.Model.PontoModel;
import com.br.ClockHub.Service.PontoService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Time;

@SessionScoped
@Named("pontoBean")
public class PontoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private PontoService pontoService = new PontoService();
	@Inject
	private SessaoUsuarioController sessaoUsuario;
	

	private String usuario;
	private PontoModel pontoModel;
	private String horarioAtual;

	@PostConstruct
	public void init() {
		atualizarHorario();
	}

	public void baterPonto() throws SQLException {
		String login = sessaoUsuario.getLoginUsuario();
		pontoService.registrarBatidaPonto(login);
	}

	public void atualizarHorario() {
		horarioAtual = pontoService.obterHorarioAtual();
	}

	// Getters e Setters

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public PontoModel getPontoModel() {
		return pontoModel;
	}

	public void setPontoModel(PontoModel pontoModel) {
		this.pontoModel = pontoModel;
	}

	public String getHorarioAtual() {
		return horarioAtual;
	}

	public void setHorarioAtual(String horarioAtual) {
		this.horarioAtual = horarioAtual;
	}

}
