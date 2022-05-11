package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.Entity.Categoria;
import br.com.uniamerica.handleapi.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Optional<Categoria> findById(Long id){
        return this.categoriaRepository.findById(id);
    }

    public Page<Categoria> listAll(Pageable pageable){
        return this.categoriaRepository.findAll(pageable);
    }

    @Transactional
    public void update (Long id, Categoria categoria){
        if (id == categoria.getId()){
            this.categoriaRepository.save(categoria);
        }
        else{
            throw new RuntimeException();
        }
    }
    @Transactional
    public void insert(Categoria categoria){
        this.categoriaRepository.save(categoria);
    }
    @Transactional
    public void updateStatus(Long id, Categoria categoria){
        if (id == categoria.getId()){
            this.categoriaRepository.updateStatus(Categoria.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
