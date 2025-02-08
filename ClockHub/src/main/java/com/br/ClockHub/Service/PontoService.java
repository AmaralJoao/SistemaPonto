package com.br.ClockHub.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.br.ClockHub.Model.BatidaPontoModel;
import com.br.ClockHub.Repository.BatidaPontoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PontoService {

    // Formatter para formatar o horário no formato HH:mm:ss
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    // Formatter para formatar a data no formato yyyy-MM-dd
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private BatidaPontoRepository repository;

    public PontoService() {
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
            this.repository = new BatidaPontoRepository(entityManager);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao configurar o EntityManager: " + e.getMessage());
        }
    }

    public String obterHorarioAtual() {
        LocalTime horarioAtual = LocalTime.now();
        return horarioAtual.format(TIME_FORMATTER);
    }

    /**
     * Obtém a data atual no formato yyyy-MM-dd.
     * 
     * @return String representando a data atual formatada.
     */
    public String obterDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.format(DATE_FORMATTER);
    }

    public BatidaPontoModel registrarBatidaPonto(BatidaPontoModel batidaPonto) {
        if (batidaPonto == null) {
            throw new IllegalArgumentException("O objeto batidaPonto não pode ser nulo.");
        }
        try {
            return repository.save(batidaPonto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao registrar a batida de ponto: " + e.getMessage());
        }
    }
}
