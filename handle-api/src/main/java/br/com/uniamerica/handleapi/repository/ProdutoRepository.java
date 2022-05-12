package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(collectionResourceRel = "produtos", path= "produtos")
public interface ProdutoRepository extends JpaRepository<Produto,Long> {


    @Modifying
    @Query("UPDATE Produto produto " +
            "SET produto.excluido = :excluido " +
            "WHERE produto.id = :produto")
    public void updateStatus(@Param("produto") Long idProduto);



}