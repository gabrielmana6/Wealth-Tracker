package br.edu.ifpb.pweb2.WealthTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.WealthTracker.model.Correntista;
import br.edu.ifpb.pweb2.WealthTracker.repository.CorrentistaRepository;
import br.edu.ifpb.pweb2.WealthTracker.util.PasswordUtil;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CorrentistaRepository correntistaRepo;

    @GetMapping
    public ModelAndView getForm(ModelAndView model) {
        model.setViewName("auth/login");
        model.addObject("usuario", new Correntista());
        return model;
    }

    @PostMapping
    public ModelAndView valide(Correntista correntista, HttpSession session, ModelAndView model,
            RedirectAttributes redirectAttts) {
        if ((correntista = this.isValido(correntista)) != null) {
            session.setAttribute("usuario", correntista);
            model.setViewName("redirect:/home");
        } else {
            redirectAttts.addFlashAttribute("mensagem", "Login e/ou senha inválidos!");
            model.setViewName("redirect:/auth");
        }
        return model;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView mav, HttpSession session) {
        session.invalidate();
        mav.setViewName("redirect:/auth");
        return mav;
    }

    private Correntista isValido(Correntista correntista) {
        Correntista correntistaBD = correntistaRepo.findByEmail(correntista.getEmail());
        boolean valido = false;
        if (correntistaBD != null) {
            if (PasswordUtil.checkPass(correntista.getSenha(), correntistaBD.getSenha())) {
                valido = true;
            }
        }
        return valido ? correntistaBD : null;
    }
}

