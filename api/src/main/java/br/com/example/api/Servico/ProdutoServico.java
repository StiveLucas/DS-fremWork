package br.com.example.api.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.example.api.Modelo.ProdutoModelo;
import br.com.example.api.Modelo.RespostaModelo;
import br.com.example.api.Repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    //Método Listar.
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    //Método cadastrar
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if (pm.getNome().isEmpty()) {
            rm.setMensagem("O nome do produto é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
            
        }else if (pm.getMarca().equals("")) {
            rm.setMensagem("O nome da marca não pode ser vazio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
            
        }else if (acao.equals("cadastrtar")) {
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);

        }
    }
    
}
