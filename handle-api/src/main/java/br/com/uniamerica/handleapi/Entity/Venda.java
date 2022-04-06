package br.com.uniamerica.handleapi.Entity;

import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Venda  extends AbstractEntity{

    private List<Produto> produtos = new ArrayList<>();
    private Instant data;
    private Double recebido;
    private Double total;
    private Double troco;
    private Double desconto;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;

}