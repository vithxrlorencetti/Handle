package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRespository extends JpaRepository<Fornecedor,Long> {
}
