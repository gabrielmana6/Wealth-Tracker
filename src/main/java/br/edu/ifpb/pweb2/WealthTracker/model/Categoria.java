package br.edu.ifpb.pweb2.WealthTracker.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.edu.ifpb.pweb2.WealthTracker.enums.NaturezaCategoria;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Boolean ativa = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NaturezaCategoria natureza;

    @Column(nullable = false)
    private Integer ordem;

    @Column(nullable = false)
    private Boolean predefinida = false;

    public Categoria(String nome, NaturezaCategoria natureza, Integer ordem, Boolean predefinida) {
        this.nome = nome;
        this.natureza = natureza;
        this.ordem = ordem;
        this.predefinida = predefinida;
        this.ativa = true;
    }
}