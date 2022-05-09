package br.com.uniamerica.handleapi.service;

import br.com.uniamerica.handleapi.Entity.Cliente;
import br.com.uniamerica.handleapi.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;

public class FornecedorService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Optional<Cliente> findById(Long id){
        return this.clienteRepository.findById(id);
    }

    public Page<Cliente> listAll(Pageable pageable){
        return this.clienteRepository.findAll(pageable);
    }

    @Transactional
    public void update (Long id, Cliente cliente){
        if (id == cliente.getId()){
            this.clienteRepository.save(cliente);
        }
        else{
            throw new RuntimeException();
        }
    }
    @Transactional
    public void insert(Cliente cliente){
        this.clienteRepository.save(cliente);
    }
    @Transactional
    public void updateStatus(Long id, Cliente cliente){
        if (id == cliente.getId()){
            this.clienteRepository.updateStatus(Cliente.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
