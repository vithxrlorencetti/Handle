package Controller;

import DAO.ClienteDAO;
import Model.Cliente;


import java.util.List;

public class ClienteController {
    ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrarCliente(Cliente cliente){
        clienteDAO.cadastrarCliente(cliente);
    }
    public List<Cliente> listarClientes(){
        return clienteDAO.listarClientes();
    }
    public void removerCliente (Long idCliente){
        clienteDAO.removerCliente(idCliente);
    }
    public Cliente selecionarCliente(long idCliente){
        return clienteDAO.selecionarCliente(idCliente);
    }
    public void editarCliente(Cliente cliente){
        clienteDAO.editarCliente(cliente);
    }

}