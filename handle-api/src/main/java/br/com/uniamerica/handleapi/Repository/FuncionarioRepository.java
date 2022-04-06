package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
