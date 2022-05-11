package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {


    @Modifying
    @Query("UPDATE Produto produto " +
            "SET produto.excluido = :excluido " +
            "WHERE produto.id = :produto")
    public void updateStatus(@Param("excluido") LocalDateTime excluido, @Param("produto") Long idProduto);



}
