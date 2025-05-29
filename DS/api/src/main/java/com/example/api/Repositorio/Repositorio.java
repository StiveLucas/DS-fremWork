package com.example.api.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api.Modelos.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{
    List<Pessoa> findAll();
    
    Pessoa findByCodigo(int codigo);
}
