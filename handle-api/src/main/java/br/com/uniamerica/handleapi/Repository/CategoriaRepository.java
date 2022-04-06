package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
