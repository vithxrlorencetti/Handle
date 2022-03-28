package Controller;

import DAO.FornecedorDAO;
import Model.Fornecedor;

import java.util.List;

public class FornecedorController {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public void cadastrarFornecedor(Fornecedor fornecedor) {fornecedorDAO.cadastrarFornecedor(fornecedor);}
    public List<Fornecedor> listarFornecedor(){return fornecedorDAO.listarFornecedores();}
    public void removerFornecedor(Long idFornecedor){fornecedorDAO.removerFornecedor(idFornecedor);}
    public Fornecedor selecionarFornecedor(Long idFornecedor){return fornecedorDAO.selecionarFornecedor(idFornecedor);}
    public void editarFornecedor(Fornecedor fornecedor){fornecedorDAO.editarFornecedor(fornecedor);}



}
