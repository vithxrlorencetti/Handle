package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
