package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.Entity.Produto;
import br.com.uniamerica.handleapi.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
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
            this.produtoRepository.updateStatus(Produto.getId());
        }else {
            throw new RuntimeException();
        }
    }









}
