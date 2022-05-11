package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.Entity.Cliente;
import br.com.uniamerica.handleapi.Entity.Funcionario;
import br.com.uniamerica.handleapi.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public Optional<Funcionario> findById(Long id){
        return this.funcionarioRepository.findById(id);
    }

    public Page<Cliente> listAll(Pageable pageable){
        return this.funcionarioRepository.findAll(pageable);
    }

    @Transactional
    public void update (Long id, Funcionario funcionario){
        if (id == funcionario.getId()){
            this.funcionarioRepository.save(funcionario);
        }
        else{
            throw new RuntimeException();
        }
    }
    @Transactional
    public void insert(Funcionario funcionario){
        this.funcionarioRepository.save(funcionario);
    }
    @Transactional
    public void updateStatus(Long id, Funcionario funcionario){
        if (id == funcionario.getId()){
            this.funcionarioRepository.updateStatus(Funcionario.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
