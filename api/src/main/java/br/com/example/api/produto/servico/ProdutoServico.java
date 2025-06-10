package br.com.example.api.produto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.example.api.produto.modelo.ProdutoModelo;
import br.com.example.api.produto.modelo.RespostaModelo;
import br.com.example.api.produto.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    //Metodo Cadastrar
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if (pm.getNome().equals("")) {
            rm.setMensagem("O nome é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

        }else if (pm.getMarca().equals("")) {
            rm.setMensagem("A marca é obrigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
            
        }else if (acao.equals("cadastrar")) {
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);

        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
        }
    }

    //Metodo Listar
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }


    
}
