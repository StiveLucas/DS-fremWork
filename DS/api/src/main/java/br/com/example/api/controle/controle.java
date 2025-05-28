package br.com.example.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.api.Modelo.Pessoa;
import br.com.example.api.repositorio.Repositorio;

//Define a primeira letra.
@RestController
public class controle {

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }
    @GetMapping("")
    public String mensagem(){
        return "Olá, Mundo!";
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem Vindo mano!";
    }

    
    @GetMapping("/boasVindas/ {nome}")
    public String boasVindas(@PathVariable String nome){
        return "Bem Vindo mano!"+nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}
