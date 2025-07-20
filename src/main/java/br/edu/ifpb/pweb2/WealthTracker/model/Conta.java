package br.edu.ifpb.pweb2.WealthTracker.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifpb.pweb2.WealthTracker.enums.TipoConta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Correntista correntista;

    @Enumerated(EnumType.STRING)
    private TipoConta tipo;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private Set<Transacao> transacoes = new HashSet<Transacao>();

    public Conta(Correntista correntista) {
        this.correntista = correntista;
    }

    public void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
        transacao.setConta(this);
    }
}
