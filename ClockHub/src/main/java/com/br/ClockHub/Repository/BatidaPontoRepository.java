package com.br.ClockHub.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

import com.br.ClockHub.Model.BatidaPontoModel;

public class BatidaPontoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BatidaPontoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Insere uma nova batida de ponto na base de dados.
     *
     * @param batidaPonto Objeto BatidaPonto a ser salvo.
     * @return BatidaPonto inserida com sucesso.
     */
    public BatidaPontoModel save(BatidaPontoModel batidaPonto) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(batidaPonto);
            transaction.commit();
            return batidaPonto;
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Erro ao salvar a batida de ponto: " + e.getMessage(), e);
        }
    }

    /**
     * Busca uma batida de ponto por ID.
     *
     * @param id ID da batida de ponto.
     * @return Um Optional contendo a batida de ponto encontrada, ou vazio caso não exista.
     */
    public Optional<BatidaPontoModel> findById(Integer usuario) {
        return Optional.ofNullable(entityManager.find(BatidaPontoModel.class, usuario));
    }
}