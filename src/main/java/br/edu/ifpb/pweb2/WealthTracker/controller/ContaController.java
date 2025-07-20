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
import br.edu.ifpb.pweb2.WealthTracker.model.Correntista;
import br.edu.ifpb.pweb2.WealthTracker.service.ContaService;
import br.edu.ifpb.pweb2.WealthTracker.service.CorrentistaService;

@Controller
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private CorrentistaService correntistaService;

    @GetMapping("/form")
    public ModelAndView getForm(ModelAndView model) {
        model.setViewName("contas/form");
        model.addObject("conta", new Conta(new Correntista()));
        return model;
    }

    @ModelAttribute("correntistaItems")
    public List<Correntista> getCorrentistas() {
        return correntistaService.findAll();
    }

    @PostMapping
    public ModelAndView save(Conta conta, ModelAndView model, RedirectAttributes attr) {
        contaService.save(conta);
        attr.addFlashAttribute("mensagem", "Conta inserida com sucesso!");
        model.setViewName("redirect:/contas");
        return model;
    }

    @GetMapping
    public ModelAndView liste(ModelAndView model) {
        model.setViewName("contas/list");
        model.addObject("contas", contaService.findAll());
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getCorrentistaById(@PathVariable(value = "id") Integer id, ModelAndView model) {
        model.addObject("conta", contaService.findById(id));
        model.setViewName("contas/form");
        return model;
    }
}
