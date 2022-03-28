package Controller;

import DAO.FuncionarioDAO;
import Model.Funcionario;

import java.util.List;

public class FuncionarioController {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void cadastrarFuncionario(Funcionario funcionario){
        funcionarioDAO.cadastrarFuncionario(funcionario);
    }
    public List<Funcionario> listarFuncionarios(){
        return funcionarioDAO.listarFuncionarios();
    }
    public Funcionario selecionarFuncionario(Long idFuncionario){
        return funcionarioDAO.selecionarFuncionario(idFuncionario);
    }
    public void editarFuncionario(Funcionario funcionario){
        funcionarioDAO.editarFuncionario(funcionario);
    }
    public void removerFuncionario(Long idFuncionario){
        funcionarioDAO.removerFuncionario(idFuncionario);
    }
}