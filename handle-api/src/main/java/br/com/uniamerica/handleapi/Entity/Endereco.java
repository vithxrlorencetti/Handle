package br.com.uniamerica.handleapi.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "enderecos", schema = "public")
public class Endereco extends AbstractEntity{

    @Getter @Setter
    @Column(name = "rua", length = 50)
    private String rua;

    @Getter @Setter
    @Column(name = "numero", length = 5)
    private String numero;

    @Getter @Setter
    @Column(name = "bairro", length = 20)
    private String bairro;

    @Getter @Setter
    @Column(name = "complemento", length = 50)
    private String complemento;

    @Getter @Setter
    @Column(name = "cidade", length = 50)
    private String cidade;

    @Getter @Setter
    @Column(name = "estado", length = 20)
    private String estado;

    @Getter @Setter
    @Column(name = "pais", length = 20)
    private String pais;

}
