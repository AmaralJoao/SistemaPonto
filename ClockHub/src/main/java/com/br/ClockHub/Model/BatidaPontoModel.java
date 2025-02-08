package com.br.ClockHub.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "batidaPonto")
public class BatidaPontoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdBatidaPonto")
	private Integer id;

	@Column(name = "cdUsuario", nullable = false)
	private Integer usuarioId;

	@Column(name = "nmUsuario", nullable = false, length = 15)
	private String nomeUsuario;

	@Column(name = "horaDoPonto", nullable = false)
	private LocalTime horaDoPonto;

	@Column(name = "diaDoPonto", nullable = false)
	private LocalDate diaDoPonto;

	public BatidaPontoModel() {}

	public BatidaPontoModel(Integer usuarioId, String nomeUsuario, LocalTime horaDoPonto, LocalDate diaDoPonto) {
	        this.usuarioId = usuarioId;
	        this.nomeUsuario = nomeUsuario;
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
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
