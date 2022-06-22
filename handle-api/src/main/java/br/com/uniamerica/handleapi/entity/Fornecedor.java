package br.com.uniamerica.handleapi.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@ToString
@Audited
@Table(name = "fornecedores", schema = "public")
@AuditTable(value = "fornecedor_audit", schema = "handle_audit")
public class Fornecedor extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Getter @Setter
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

}
