package com.example.api.Controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Modelos.Pessoa;
import com.example.api.Repositorio.Repositorio;

@RestController
public class Controle {
    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    //Lista tudo da tabela.
    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    //Traz
    @GetMapping("/api{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
        return acao.save(obj);
    }

    @DeleteMapping("/api{codigo}")
    public void remover(@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    @GetMapping("")
    public String mensagem(){
        return "OLá Mundo";
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Bem Vindo Mano!";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo "+nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
    
}
