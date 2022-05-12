package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
