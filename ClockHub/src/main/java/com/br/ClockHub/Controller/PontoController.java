package com.br.ClockHub.Controller;

import com.br.ClockHub.Model.PontoModel;
import com.br.ClockHub.Service.PontoService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

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
	private transient Optional<LocalTime> ultimoRegistro = Optional.empty();


	@PostConstruct
	public void init() throws SQLException {
		atualizarHorario();
		buscarUltimoPonto();
	}

	public void baterPonto() throws SQLException {
		String login = sessaoUsuario.getLoginUsuario();
		pontoService.registrarBatidaPonto(login);
		buscarUltimoPonto(); // Atualiza o último ponto após bater o ponto
	}

	public void atualizarHorario() {
		horarioAtual = pontoService.obterHorarioAtual();
	}

	public void redirecionarParaRegistrosAnteriores() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("registrosAnteriores.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarUltimoPonto() throws SQLException {
		String login = sessaoUsuario.getLoginUsuario();
		ultimoRegistro = pontoService.obterUltimoPonto(login);
	}

	// Retorna apenas a hora formatada para exibição no XHTML
	public String getUltimoRegistroFormatado() {
		return ultimoRegistro.map(time -> time.format(DateTimeFormatter.ofPattern("HH:mm:ss"))).orElse("--:--:--");
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

	public Optional<LocalTime> getUltimoRegistro() {
		return ultimoRegistro;
	}

	// Ajustado para receber LocalTime em vez de String
	public void setUltimoRegistro(LocalTime ultimoRegistro) {
		this.ultimoRegistro = Optional.ofNullable(ultimoRegistro);
	}

}
