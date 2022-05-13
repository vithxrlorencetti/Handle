package br.com.uniamerica.handleapi.controller;


import br.com.uniamerica.handleapi.entity.Funcionario;
import br.com.uniamerica.handleapi.repository.FuncionarioRepository;
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
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listAllFuncionario(){
        return new ResponseEntity<>(funcionarioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody List<Funcionario> funcionario){
        funcionarioRepository.saveAll(funcionario);
        return new ResponseEntity<>("Funcionario Cadastrado", HttpStatus.OK);
    }
}
