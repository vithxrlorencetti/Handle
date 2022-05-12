package br.com.uniamerica.handleapi.controller;
import br.com.uniamerica.handleapi.entity.Fornecedor;
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
@RequestMapping("/api/fornecedores")


public class FornecedorController {

    @Autowired
    public FornecedorRespository fornecedorRespository;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listAllFornecedor(){
        return new ResponseEntity<>(fornecedorRespository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<Fornecedor> fornecedor){
        fornecedorRespository.saveAll(fornecedor);
        return new ResponseEntity<>("Fornecedor Cadastrado", HttpStatus.OK);
    }
}
