package br.edu.ifpb.pweb2.WealthTracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.WealthTracker.service.CategoriaService;

@Component
public class InicializadorCategoria implements CommandLineRunner {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public void run(String... args) throws Exception {
        // Inicializa as categorias predefinidas se não existirem
        categoriaService.inicializarCategoriasPredefinidas();
    }
}