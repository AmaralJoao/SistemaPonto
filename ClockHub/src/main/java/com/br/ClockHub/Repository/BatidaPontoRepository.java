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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public Optional<LocalTime> verUltimoPonto(int cdUsuario) {
		
		String sql = "SELECT horaDoPonto FROM ponto WHERE cdUsuario = ? ORDER BY diaDoPonto DESC, horaDoPonto DESC LIMIT 1;";

		try (Connection conn = Conexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
				
			stmt.setInt(1, cdUsuario);
			
			try(ResultSet rs = stmt.executeQuery()) {
				
				if (rs.next()) {
					return Optional.ofNullable(rs.getObject("horaDoPonto", LocalTime.class));
				}
				
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar o último ponto registrado: " + e.getMessage(), e);
		}

		return Optional.empty(); 
	}

	public List<PontoModel> verTodasAsBatidas(int cdUsuario) {
		
		String sql = "SELECT diaDoPonto ,horaDoPonto FROM ponto WHERE cdUsuario = ? ORDER BY diaDoPonto DESC;";
		List<PontoModel> listaPontos = new ArrayList<PontoModel>();
		
		try(Connection conn = Conexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, cdUsuario);
			
			try(ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					PontoModel ponto = new PontoModel();
					ponto.setDiaDoPonto(rs.getDate("diaDoPonto").toLocalDate());
					ponto.setHoraDoPonto(rs.getTime("horaDoPonto").toLocalTime());
					listaPontos.add(ponto);	
				}
			} 
			
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return listaPontos;

	}

}