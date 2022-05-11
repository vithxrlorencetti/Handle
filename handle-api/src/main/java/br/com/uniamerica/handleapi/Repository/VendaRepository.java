package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface VendaRepository extends JpaRepository<Venda,Long> {

    @Modifying
    @Query("UPDATE Venda venda " +
            "SET venda.excluido = :excluido " +
            "WHERE venda.id = :venda")
    public void updateStatus(@Param("excluido") LocalDateTime excluido, @Param("venda") Long idVenda);

}
