package br.com.uniamerica.handleapi.Repository;
import br.com.uniamerica.handleapi.Entity.Categoria;
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
    public void updateStatus(@Param("excluido") LocalDateTime excluido, @Param("categoria") Long idCategoria);

}
