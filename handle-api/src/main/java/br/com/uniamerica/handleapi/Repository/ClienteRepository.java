package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Modifying
    @Query("UPDATE Cliente cliente " +
            "SET cliente.excluido = :excluido " +
            "WHERE cliente.id = :cliente")
    public void updateStatus(@Param("excluido") LocalDateTime excluido, @Param("cliente") Long idCliente);

}
