package com.br.ClockHub.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3306/DbClockHub?useSSL=false&serverTimezone=UTC";
	private static final String USUARIO = "root";
	private static final String SENHA = "Marioviado1@";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao carregar driver MySQL", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, SENHA);
	}
}
