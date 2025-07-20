package br.edu.ifpb.pweb2.WealthTracker.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    private String nome;
    
    private boolean ativa;
    
    private Natureza natureza;
    
    private Integer ordem;
    
    public enum Natureza {
        ENTRADA("E"), 
        SAIDA("S"), 
        INVESTIMENTO("I");
        
        private String codigo;
        
        private Natureza(String codigo) {
            this.codigo = codigo;
        }
        
        public String getCodigo() {
            return codigo;
        }
        
        public static Natureza fromCodigo(String codigo) {
            for (Natureza natureza : values()) {
                if (natureza.codigo.equals(codigo)) {
                    return natureza;
                }
            }
            throw new IllegalArgumentException("Código de natureza inválido: " + codigo);
        }
    }
    
    public Categoria() {
        this.ativa = true;
    }
    
    public Categoria(String nome, Natureza natureza, Integer ordem) {
        this();
        this.nome = nome;
        this.natureza = natureza;
        this.ordem = ordem;
    }
}