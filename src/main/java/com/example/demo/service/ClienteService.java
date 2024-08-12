package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    Cliente inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);


}
