package br.edu.ifpb.pweb2.WealthTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.WealthTracker.model.Conta;
import br.edu.ifpb.pweb2.WealthTracker.model.Transacao;
import br.edu.ifpb.pweb2.WealthTracker.repository.ContaRepository;
import br.edu.ifpb.pweb2.WealthTracker.repository.TransacaoRepository;

@Component
public class TransacaoService implements Service<Transacao, Integer> {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao findById(Integer id) {
        return transacaoRepository.findById(id);
    }
    
    @Override
    public Transacao save(Transacao transacao) {
        Conta conta = contaRepository.findById(transacao.getConta().getId());
        transacao.setConta(conta);
        return transacaoRepository.save(transacao);
    }
}
