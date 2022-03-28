package View;

import Controller.ClienteController;
import Model.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteView {

    ClienteController clienteController = new ClienteController();
    Scanner input = new Scanner(System.in);

    public void cadastrarCliente() {
        Cliente cliente = new Cliente();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do cliente: ");
        cliente.setNomeCliente(input.nextLine());
        System.out.print("Numero de Telefone do cliente: ");
        cliente.setTelefoneCliente(input.nextLine());

        clienteController.cadastrarCliente(cliente);
        System.out.println("\n" + cliente);
    }


    public void editarCliente() {
        this.listarClientes();
        System.out.println("Pressione ENTER caso não queira mudar o campo pedido.");
        System.out.print("Escolha o cliente a ser editado a partir do ID: ");
        Cliente clienteSelecionado = clienteController.selecionarCliente(Long.parseLong(input.nextLine()));

        String aux;

        System.out.print("Novo nome do cliente: ");
        aux = input.nextLine();
        if (aux != ""){
            clienteSelecionado.setNomeCliente(aux);
        }

        System.out.print("Novo numero de telefone do cliente: ");
        aux = input.nextLine();
        if (aux != ""){
            clienteSelecionado.setTelefoneCliente(aux);
        }

        clienteController.editarCliente(clienteSelecionado);
    }

    public void removerCliente(){
        this.listarClientes();
        System.out.print("Escolha o cliente a ser removido a partir do ID: ");
        Long idCliente = Long.valueOf(input.nextLine());
        clienteController.removerCliente(idCliente);
        System.out.println("Cliente removido com sucesso!");
    }

    public void listarClientes(){
        List<Cliente> clientes = clienteController.listarClientes();
        System.out.println();
        for (int i = 0; i <clientes.size(); i++){
            System.out.println("ID do Cliente: " + clientes.get(i).getIdCliente() +
                    " | Nome do cliente: " + clientes.get(i).getNomeCliente() +
                    " | Telefone do cliente: " + clientes.get(i).getTelefoneCliente());
        }
        System.out.println();
    }
}