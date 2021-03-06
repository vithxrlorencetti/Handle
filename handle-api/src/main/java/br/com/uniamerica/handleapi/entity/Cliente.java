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
@Table(name = "clientes", schema = "public")
@AuditTable(value = "cliente_audit", schema = "handle_audit")
public class Cliente extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", length = 50)
    private String nome;

    @Getter @Setter
    @Column(name = "cpf", unique = true, length = 15)
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone", unique = true, length = 18)
    private String telefone;

}
