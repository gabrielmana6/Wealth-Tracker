package br.edu.ifpb.pweb2.WealthTracker.model;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private String descricao;
    private BigDecimal valor;
    private TipoMovimento movimento;

    public enum TipoMovimento {
        CREDITO, DEBITO
    }

    private Conta conta;
    // private Comentarios comentarios;
    // private Categoria categoria;

    public Transacao() {
    }

    public Transacao(Conta conta) {
        this.conta = conta;
    }   
}