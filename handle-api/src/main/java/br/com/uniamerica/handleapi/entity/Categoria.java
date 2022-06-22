package br.com.uniamerica.handleapi.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@NoArgsConstructor
@ToString
@Audited
@Table(name = "categorias", schema = "public")
@AuditTable(value = "categorias_audit", schema = "handle_audit")
public class Categoria extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", unique = true, length = 50)
    private String nome;

}