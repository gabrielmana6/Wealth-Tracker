package br.edu.ifpb.pweb2.WealthTracker.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String numero;
    private String descricao;
    private TipoConta tipo;
    public enum TipoConta {
        CORRENTE, CARTAO
    }
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private Set<Transacao> transacoes = new HashSet<Transacao>();

    private Correntista correntista;

    public Conta() {} // ← Adicionar construtor vazio também
    
    public Conta(Correntista correntista) {
        this.correntista = correntista;
    }
}
