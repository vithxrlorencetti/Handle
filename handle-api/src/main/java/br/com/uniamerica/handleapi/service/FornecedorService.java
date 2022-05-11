package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.Entity.Fornecedor;
import br.com.uniamerica.handleapi.Repository.FornecedorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;

public class FornecedorService {

    @Autowired
    private FornecedorRespository fornecedorRepository;


    public Optional<Fornecedor> findById(Long id){
        return this.fornecedorRepository.findById(id);
    }

    public Page<Fornecedor> listAll(Pageable pageable){
        return this.fornecedorRepository.findAll(pageable);
    }

    @Transactional
    public void update (Long id, Fornecedor fornecedor){
        if (id == fornecedor.getId()){
            this.fornecedorRepository.save(fornecedor);
        }
        else{
            throw new RuntimeException();
        }
    }
    @Transactional
    public void insert(Fornecedor fornecedor){
        this.fornecedorRepository.save(fornecedor);
    }
    @Transactional
    public void updateStatus(Long id, Fornecedor fornecedor){
        if (id == fornecedor.getId()){
            this.fornecedorRepository.updateStatus(Fornecedor.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
