package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.VendaProduto;
import br.com.uniamerica.handleapi.repository.VendaProdutoRepository;
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
@RequestMapping("/api/vendas_produtos")
public class VendaProdutoController {

    @Autowired
    public VendaProdutoRepository vendaProdutoRepository;

    @GetMapping
    public ResponseEntity<List<VendaProduto>> listAllVendaProduto(){
        return new ResponseEntity<>(vendaProdutoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<VendaProduto> vendaProduto){
        vendaProdutoRepository.saveAll(vendaProduto);
        return new ResponseEntity<>("VendaProduto Cadastrado com sucesso", HttpStatus.OK);
    }

}
