package com.example.BackEndAEP.Controller;

import com.example.BackEndAEP.Model.Reclamacao;
import com.example.BackEndAEP.Repository.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReclamacaoController {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("reclamacao", new Reclamacao());
        return "form";
    }

    @PostMapping("/registrar")
    public String registerReclamacao(Reclamacao reclamacao, RedirectAttributes redirectAttributes) {
        reclamacaoRepository.save(reclamacao);
        redirectAttributes.addFlashAttribute("mensagem", "Reclamação registrada com sucesso!");
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listReclamacoes(Model model) {
        model.addAttribute("reclamacoes", reclamacaoRepository.findAll());
        return "list";
    }
}