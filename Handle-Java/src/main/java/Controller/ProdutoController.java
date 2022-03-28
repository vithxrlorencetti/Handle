package Controller;

import DAO.ProdutoDAO;
import Model.Produto;

import java.util.List;

public class ProdutoController {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public void cadastrarProduto(Produto produto) {
        produtoDAO.cadastrarProduto(produto);
    }
    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }
    public List<Produto> listarProdutosPorCategoria(Long idCategoria) {
        return produtoDAO.listarProdutosPorCategoria(idCategoria);
    }
    public List<Produto> listarProdutosPorFornecedor(Long idFornecedor){
        return produtoDAO.listarProdutosPorFornecedor(idFornecedor);
    }
    public void removerProduto(Long idProduto) {
        produtoDAO.removerProduto(idProduto);
    }
    public Produto selecionarProduto(long idProduto) {
        return produtoDAO.selecionarProduto(idProduto);
    }
    public void editarProduto(Produto produto){
        produtoDAO.editarProduto(produto);
    }
}