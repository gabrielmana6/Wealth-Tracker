package br.edu.ifpb.pweb2.WealthTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.WealthTracker.model.Correntista;
import br.edu.ifpb.pweb2.WealthTracker.repository.CorrentistaRepository;
import br.edu.ifpb.pweb2.WealthTracker.util.PasswordUtil;

@Component
public class CorrentistaService implements Service<Correntista, Integer> {
    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Override
    public List<Correntista> findAll() {
        return correntistaRepository.findAll();
    }

    @Override
    public Correntista findById(Integer id) {
        return correntistaRepository.findById(id).orElse(null);
    }

    @Override
    public Correntista save(Correntista c) {
        c.setSenha(PasswordUtil.hashPassword(c.getSenha()));
       return correntistaRepository.save(c);
    }
}
