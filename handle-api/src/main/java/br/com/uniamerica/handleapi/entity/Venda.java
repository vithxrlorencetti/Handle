package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "vendas", schema = "public")
public class Venda  extends AbstractEntity{

    @Getter @Setter
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Getter @Setter
    @Column(name = "recebido", nullable = false, precision = 5, scale = 5)
    private BigDecimal recebido;

    @Getter @Setter
    @Column(name = "total", nullable = false, precision = 5, scale = 5)
    private BigDecimal total;

    @Getter @Setter
    @Column(name = "troco", precision = 5, scale = 5)
    private BigDecimal troco;

    @Getter @Setter
    @Column(name = "desconto", precision = 5, scale = 5)
    private BigDecimal desconto;

    @Getter @Setter
    @ManyToOne
    private Cliente cliente;

    @Getter @Setter
    @ManyToOne
    private Funcionario funcionario;

}