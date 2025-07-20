package br.edu.ifpb.pweb2.WealthTracker.config;

import br.edu.ifpb.pweb2.WealthTracker.model.Correntista;
import br.edu.ifpb.pweb2.WealthTracker.repository.CorrentistaRepository;
import br.edu.ifpb.pweb2.WealthTracker.util.PasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorCorrentista implements ApplicationRunner {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (correntistaRepository.findByEmail("admin@wealthtracker.com") == null) {
            Correntista correntista = new Correntista();
            correntista.setNome("Administrador");
            correntista.setEmail("admin@wealthtracker.com");
            correntista.setSenha(PasswordUtil.hashPassword("123")); 
            correntista.setAdmin(true);

            correntistaRepository.save(correntista);
            System.out.println("Correntista admin inserido com sucesso.");
        } else {
            System.out.println("Correntista admin já existe.");
        }
    }
}

