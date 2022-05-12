package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    @Modifying
    @Query("UPDATE Funcionario funcionario " +
            "SET funcionario.excluido = :excluido " +
            "WHERE funcionario.id = :funcionario")
    public void updateStatus(@Param("funcionario") Long idFuncionario);

}
