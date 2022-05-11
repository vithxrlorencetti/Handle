package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface FornecedorRespository extends JpaRepository<Fornecedor,Long> {

    @Modifying
    @Query("UPDATE Fornecedor fornecedor " +
            "SET fornecedor.excluido = :excluido " +
            "WHERE fornecedor.id = :fornecedor")
    public void updateStatus(@Param("excluido") LocalDateTime excluido, @Param("fornecedor") Long idFornecedor);

}
