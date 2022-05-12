package br.com.uniamerica.handleapi.controller;


import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.repository.CategoriaRepository;
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
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    public CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> listAllCategoria(){
        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<Categoria> categoria){
        categoriaRepository.saveAll(categoria);
        return new ResponseEntity<>("Categoria Cadastrado", HttpStatus.OK);
    }
}
