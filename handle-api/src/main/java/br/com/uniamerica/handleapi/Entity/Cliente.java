package br.com.uniamerica.handleapi.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes", schema = "public")
public class Cliente extends AbstractEntity {

    private String nome;
    private String cpf;
    private String telefone;

}
