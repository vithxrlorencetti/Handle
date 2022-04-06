package br.com.uniamerica.handleapi.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornecedores", schema = "public")
public class Fornecedor extends AbstractEntity {

    private String nome;
    private String telefone;

}
