package br.com.uniamerica.handleapi.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "cadastro", nullable = false)
    private LocalDateTime cadastro;

    @Getter @Setter
    @Column(name = "atualizado")
    private LocalDateTime atualizado;

    @Getter @Setter
    @Column(name = "excluido")
    private LocalDateTime excluido;

    @PrePersist
    public void dataCadastro(){
        this.setCadastro(LocalDateTime.now());
    }

}
