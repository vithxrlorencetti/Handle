package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Produto;
import br.com.uniamerica.handleapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;
import java.util.Optional;

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> findById(Long id){
        return this.produtoRepository.findById(id);
    }

    public Page<Produto> listAll(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    @Transactional
    public void update (Long id, Produto produto){
        if (id == produto.getId()){
            this.produtoRepository.save(produto);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void insert(Produto produto){
        this.produtoRepository.save(produto);
    }

    @Transactional
    public void updateStatus(Long id, Produto produto){
        if (id == produto.getId()){
            this.produtoRepository.updateStatus(produto.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
