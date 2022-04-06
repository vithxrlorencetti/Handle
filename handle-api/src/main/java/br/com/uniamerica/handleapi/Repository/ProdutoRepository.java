package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
