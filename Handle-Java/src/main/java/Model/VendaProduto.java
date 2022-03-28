package Model;

public class VendaProduto {

    private Long idVendaProduto;
    private Long idVenda;
    private Long idProduto;
    private Long quantidade;

    public VendaProduto() {
    }

    public VendaProduto(Long idVenda, Long idProduto, Long quantidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getIdVendaProduto() {
        return idVendaProduto;
    }

    public void setIdVendaProduto(Long idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "VendaProduto{" +
                "idVendaProduto=" + idVendaProduto +
                ", idVenda=" + idVenda +
                ", idProduto=" + idProduto +
                '}';
    }
}
