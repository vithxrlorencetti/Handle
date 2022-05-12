package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Produto;
import br.com.uniamerica.handleapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> listAllProdutos(){
        return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<Produto> produto){
        produtoRepository.saveAll(produto);
        return new ResponseEntity<>("Produto Cadastrado", HttpStatus.OK);
    }

}
