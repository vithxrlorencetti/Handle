package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
