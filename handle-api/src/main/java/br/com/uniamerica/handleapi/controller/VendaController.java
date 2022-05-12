package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Funcionario;
import br.com.uniamerica.handleapi.entity.Venda;
import br.com.uniamerica.handleapi.repository.CategoriaRepository;
import br.com.uniamerica.handleapi.repository.FuncionarioRepository;
import br.com.uniamerica.handleapi.repository.VendaRepository;
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
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    public VendaRepository vendaRepository;

    @GetMapping
    public ResponseEntity<List<Venda>> listAllVenda(){
        return new ResponseEntity<>(vendaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<Venda> venda){
        vendaRepository.saveAll(venda);
        return new ResponseEntity<>("Venda Cadastrado com sucesso", HttpStatus.OK);
    }

}
