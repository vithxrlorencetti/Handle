package br.com.uniamerica.handleapi.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "produtos", schema = "public")
public class Produto extends AbstractEntity {

    private String nome;
    private long codigoDeBarras;
    private Double valorCusto;
    private Double valorVenda;

}
