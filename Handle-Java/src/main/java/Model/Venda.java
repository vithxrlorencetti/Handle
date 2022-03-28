package Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Long idVenda;
    private Cliente clienteVenda;
    private Funcionario funcionarioVenda;
    private List<Produto> produtosVenda = new ArrayList<>();
    private Instant dataVenda;
    private Double recebidoVenda;
    private Double totalVenda;
    private Double trocoVenda;
    private Double descontoVenda;

    public Venda() {
    }

    public Venda(Cliente clienteVenda, Funcionario funcionarioVenda, List<Produto> produtosVenda, Instant dataVenda, Double recebidoVenda, Double totalVenda, Double trocoVenda, Double descontoVenda) {
        this.clienteVenda = clienteVenda;
        this.funcionarioVenda = funcionarioVenda;
        this.produtosVenda = produtosVenda;
        this.dataVenda = dataVenda;
        this.recebidoVenda = recebidoVenda;
        this.totalVenda = totalVenda;
        this.trocoVenda = trocoVenda;
        this.descontoVenda = descontoVenda;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getClienteVenda() {
        return clienteVenda;
    }

    public void setClienteVenda(Cliente clienteVenda) {
        this.clienteVenda = clienteVenda;
    }

    public Funcionario getFuncionarioVenda() {
        return funcionarioVenda;
    }

    public void setFuncionarioVenda(Funcionario funcionarioVenda) {
        this.funcionarioVenda = funcionarioVenda;
    }

    public List<Produto> getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(List<Produto> produtosVenda) {
        this.produtosVenda = produtosVenda;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getRecebidoVenda() {
        return recebidoVenda;
    }

    public void setRecebidoVenda(Double recebidoVenda) {
        this.recebidoVenda = recebidoVenda;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Double getTrocoVenda() {
        return trocoVenda;
    }

    public void setTrocoVenda(Double trocoVenda) {
        this.trocoVenda = trocoVenda;
    }

    public Double getDescontoVenda() {
        return descontoVenda;
    }

    public void setDescontoVenda(Double descontoVenda) {
        this.descontoVenda = descontoVenda;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idVenda=" + idVenda +
                ", clienteVenda=" + clienteVenda +
                ", funcionarioVenda=" + funcionarioVenda +
                ", produtosVenda=" + produtosVenda +
                ", dataVenda='" + dataVenda + '\'' +
                ", recebidoVenda=" + recebidoVenda +
                ", totalVenda=" + totalVenda +
                ", trocoVenda=" + trocoVenda +
                ", descontoVenda=" + descontoVenda +
                '}';
    }
}