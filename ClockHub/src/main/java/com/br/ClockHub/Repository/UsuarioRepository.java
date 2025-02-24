package com.br.ClockHub.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.ClockHub.Model.UsuarioModel;

public class UsuarioRepository {
    
    public UsuarioModel localizarPorLogin(String nome) {
        UsuarioModel usuario = null;

        String sql = "SELECT cdUsuario, username, password from usuario WHERE username = ?;";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioModel(
                        rs.getInt("cdUsuario"),
                        rs.getString("username"),
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    public Integer LocalizaCdUsuarioPorUsername(String username) throws SQLException {
        String sql = "SELECT cdUsuario FROM usuario WHERE username = ?";
        try (Connection conn = Conexao.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
					return rs.getInt("cdUsuario");
				}else {
					return null;
				}
            }
        }catch (SQLException e) {
        	throw new RuntimeException("Erro ao salvar localizad cdUsuario: " + e.getMessage(), e);
		}
    }
 
}
