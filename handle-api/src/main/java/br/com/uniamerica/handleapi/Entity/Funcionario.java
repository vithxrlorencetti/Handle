package br.com.uniamerica.handleapi.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "funcionarios", schema = "public")
public class Funcionario extends AbstractEntity {

    private String nome;
    private String identidade;
    private String telefone;
    private Double salario;

}
