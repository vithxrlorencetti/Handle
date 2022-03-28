package Model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private long idCategoria;
    private String nomeCategoria;
    private List<Produto> produtosCategoria = new ArrayList<Produto>();


    public Categoria() {
    }

    public Categoria(String nomeCategoria, List<Produto> produtosCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.produtosCategoria = produtosCategoria;
    }

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Produto> getProdutosCategoria() {
        return produtosCategoria;
    }

    public void setProdutosCategoria(List<Produto> produtosCategoria) {
        this.produtosCategoria = produtosCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                ", produtosCategoria=" + produtosCategoria +
                '}';
    }
}