package br.edu.ifpb.pweb2.WealthTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.WealthTracker.model.Conta;
import br.edu.ifpb.pweb2.WealthTracker.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
    Transacao findByConta(Conta conta);

    @Query("select t from Transacao t where t.id = :id")
    Transacao findTransacaoById(Integer id);

    @Query("select t from Transacao t where t.conta.numero = :nuConta")
    Transacao findTransacaoByNuConta(String nuConta);
}
