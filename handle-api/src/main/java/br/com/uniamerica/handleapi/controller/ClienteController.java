package br.com.uniamerica.handleapi.controller;


import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.repository.ClienteRepository;
import br.com.uniamerica.handleapi.repository.FornecedorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> listAllCliente(){
        return new ResponseEntity<>(clienteRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<Cliente> cliente){
        clienteRepository.saveAll(cliente);
        return new ResponseEntity<>("Cliente Cadastrado", HttpStatus.OK);
    }
}
