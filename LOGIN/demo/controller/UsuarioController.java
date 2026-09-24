package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String senha, Model model) {
        Usuario usuario = usuarioService.login(email, senha);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "home";
        }

        model.addAttribute("erro", "E-mail ou senha incorretos");
        return "login";
    }

    @GetMapping("/cadastro")
    public String telaCadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Usuario usuario) {
        usuarioService.cadastrar(usuario);
        return "redirect:/login";
    }
}
