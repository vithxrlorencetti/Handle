package Model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {

    private long idFornecedor;
    private String nomeFornecedor;
    private String telefoneFornecedor;
    private List<Produto> produtosFornecedor = new ArrayList<Produto>();


    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor, String telefoneFornecedor, List<Produto> produtosFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
        this.produtosFornecedor = produtosFornecedor;
    }


    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public List<Produto> getProdutosFornecedor() {
        return produtosFornecedor;
    }

    public void setProdutosFornecedor(List<Produto> produtosFornecedor) {
        this.produtosFornecedor = produtosFornecedor;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                ", telefoneFornecedor=" + telefoneFornecedor +
                ", produtosFornecedor=" + produtosFornecedor +
                '}';
    }
}
