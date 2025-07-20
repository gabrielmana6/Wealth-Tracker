package br.edu.ifpb.pweb2.WealthTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.WealthTracker.model.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
    
    Correntista findByEmail(String email);
    
}