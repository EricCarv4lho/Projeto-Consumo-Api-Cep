package com.example.demo.service.impl;

import com.example.demo.model.Cliente;
import com.example.demo.model.ClienteRepository;
import com.example.demo.model.Endereco;
import com.example.demo.model.EnderecoRepository;
import com.example.demo.service.ClienteService;
import com.example.demo.service.ViaCepService;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente com id "+id+" nao encontrado."));
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
        return cliente;

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Cliente clienteParaAtualizar = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com ID " + id + " não encontrado."));
            clienteParaAtualizar.setNome(cliente.getNome());
            clienteParaAtualizar.setEndereco(cliente.getEndereco());
            salvarClienteComCep(cliente);


    }

    public void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente com ID " + id + " não encontrado.");
        }
        clienteRepository.deleteById(id);


    }
}
