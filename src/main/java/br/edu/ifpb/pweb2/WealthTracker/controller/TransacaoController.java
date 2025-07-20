package br.edu.ifpb.pweb2.WealthTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.WealthTracker.model.Conta;
import br.edu.ifpb.pweb2.WealthTracker.model.Transacao;
import br.edu.ifpb.pweb2.WealthTracker.service.ContaService;
import br.edu.ifpb.pweb2.WealthTracker.service.TransacaoService;

@Controller
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    
    @Autowired
    private ContaService contaService;

    @GetMapping("/form")
    public ModelAndView getForm(ModelAndView model) {
        model.setViewName("transacoes/form");
        model.addObject("transacao", new Transacao(new Conta()));
        return model;
    }

    @ModelAttribute("contaItems")
    public List<Conta> getContas() {
        return contaService.findAll();
    }

    @PostMapping
    public ModelAndView save(Transacao transacao, ModelAndView model, RedirectAttributes attr) {
        transacaoService.save(transacao);
        attr.addFlashAttribute("mensagem", "Transação inserida com sucesso!");
        model.setViewName("redirect:/transacoes");
        return model;
    }

    @GetMapping
    public ModelAndView liste(ModelAndView model) {
        model.setViewName("transacoes/list");
        model.addObject("transacoes", transacaoService.findAll());
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getTransacaoById(@PathVariable(value = "id") Integer id, ModelAndView model) {
        model.addObject("transacao", transacaoService.findById(id));
        model.setViewName("transacoes/form");
        return model;
    }

}