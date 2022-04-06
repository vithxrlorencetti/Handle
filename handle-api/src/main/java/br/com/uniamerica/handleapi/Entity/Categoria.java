package br.com.uniamerica.handleapi.Entity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias", schema = "public")
public class Categoria extends AbstractEntity{

    private String nome;

}