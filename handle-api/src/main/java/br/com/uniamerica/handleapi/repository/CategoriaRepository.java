package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Modifying
    @Query("UPDATE Categoria categoria " +
            "SET categoria.excluido = :excluido " +
            "WHERE categoria.id = :categoria")
    public void updateStatus(@Param("categoria") Long idCategoria);

}