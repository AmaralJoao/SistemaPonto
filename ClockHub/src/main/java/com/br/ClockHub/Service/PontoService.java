package com.br.ClockHub.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.br.ClockHub.Model.PontoModel;
import com.br.ClockHub.Model.UsuarioModel;
import com.br.ClockHub.Repository.BatidaPontoRepository;
import com.br.ClockHub.Repository.UsuarioRepository;


public class PontoService {

   
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    BatidaPontoRepository batidaRepository = new BatidaPontoRepository();

    public String obterHorarioAtual() {
        LocalTime horarioAtual = LocalTime.now();
        return horarioAtual.format(TIME_FORMATTER);
    }

    public void registrarBatidaPonto(String username) throws SQLException {
    	UsuarioRepository usuarioRepository = new UsuarioRepository();
    	
    	Integer cdUsuario = usuarioRepository.LocalizaCdUsuarioPorUsername(username);
    	
    	if (cdUsuario == null) {
			throw new RuntimeException("Usuario não encotrado para registrar ponto");
		}else {
			batidaRepository.baterPonto(cdUsuario);
		}
        
    }
    
    public Optional<LocalTime> obterUltimoPonto(String username) throws SQLException{
    	UsuarioRepository usuarioRepository = new UsuarioRepository();
    	
    	Integer cdUsuario = usuarioRepository.LocalizaCdUsuarioPorUsername(username);
        
        if (cdUsuario == null) {
            throw new RuntimeException("Usuário não encontrado para localizar ponto");
        }else {
        	return batidaRepository.verUltimoPonto(cdUsuario);
		}

        
    }
}
