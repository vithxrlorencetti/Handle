package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
