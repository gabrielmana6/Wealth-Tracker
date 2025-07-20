package br.edu.ifpb.pweb2.WealthTracker.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.WealthTracker.model.Transacao;

@Component
public class TransacaoRepository {
    private Map<Integer, Transacao> repositorio = new HashMap<Integer, Transacao>();

    public Transacao findById(Integer id) {
        return repositorio.get(id);
    }

    public Transacao save(Transacao transacao) {
        Integer id = null;
        id = (transacao.getId() == null) ? this.getMaxId() : transacao.getId();
        transacao.setId(id);
        repositorio.put(id, transacao);
        return transacao;
    }

    public List<Transacao> findAll() {
        List<Transacao> transacoes = repositorio.values().stream().collect(Collectors.toList());
        return transacoes;
    }

    public Integer getMaxId() {
        List<Transacao> transacoes = findAll();
        if (transacoes == null || transacoes.isEmpty())
            return 1;
        Transacao transacaoMaxId = transacoes
                .stream()
                .max(Comparator.comparing(Transacao::getId))
                .orElseThrow(NoSuchElementException::new);
        return transacaoMaxId.getId() == null ? 1 : transacaoMaxId.getId() + 1;
    }
}
