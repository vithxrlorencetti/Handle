package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.repository.FornecedorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;
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
            this.fornecedorRepository.updateStatus(fornecedor.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
