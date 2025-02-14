package com.br.ClockHub.Repository;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.br.ClockHub.Model.PontoModel;
import com.br.ClockHub.Model.UsuarioModel;

public class BatidaPontoRepository {
	
	
	 public void baterPonto(Integer cdUsuario) {
	        String sql = "INSERT INTO ponto (cdUsuario, horaDoPonto, diadoPonto) VALUES (?, ?, ?)";
	        
	        try (Connection conn = Conexao.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
	            
	            stmt.setInt(1, cdUsuario);
	            stmt.setTime(2, Time.valueOf(LocalTime.now()));
	            stmt.setDate(3, Date.valueOf(LocalDate.now()));
	            
	            stmt.executeUpdate();
	            //conn.commit();
	            
	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao salvar batida de ponto: " + e.getMessage(), e);
	        }
	    }

	public PontoModel verUltimoPonto(int cdUsuario) {
		String sql = "SELECT horaDoPonto FROM BatidaPonto WHERE diaDoPonto = CURDATE() ORDER BY horaDoPonto DESC LIMIT 1";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			if (rs.next()) {
				return new PontoModel(null, null, rs.getObject("horaDoPonto", LocalTime.class), null);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar o último ponto registrado: " + e.getMessage(), e);
		}

		return null; 
	}

	/* public void PontoModel verTodasAsBatidas(int id) {

	}*/

}