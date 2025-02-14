package com.br.ClockHub.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class PontoModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer cdUsuario;
	private LocalTime horaDoPonto;
	private LocalDate diaDoPonto;

	public PontoModel() {}

	public PontoModel(Integer usuarioId, String nomeUsuario, LocalTime horaDoPonto, LocalDate diaDoPonto) {
	        this.cdUsuario = usuarioId;
	        this.horaDoPonto = horaDoPonto;
	        this.diaDoPonto = diaDoPonto;
	    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuarioId() {
		return cdUsuario;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.cdUsuario = usuarioId;
	}

	public LocalTime getHoraDoPonto() {
		return horaDoPonto;
	}

	public void setHoraDoPonto(LocalTime horaDoPonto) {
		this.horaDoPonto = horaDoPonto;
	}

	public LocalDate getDiaDoPonto() {
		return diaDoPonto;
	}

	public void setDiaDoPonto(LocalDate diaDoPonto) {
		this.diaDoPonto = diaDoPonto;
	}

}
