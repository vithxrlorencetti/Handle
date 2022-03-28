package View;

import Controller.FornecedorController;
import Model.Fornecedor;

import java.util.List;
import java.util.Scanner;


public class FornecedorView {

    Scanner input = new Scanner(System.in);
    FornecedorController fornecedorController = new FornecedorController();

    public void cadastrarFornecedor(){
        Fornecedor fornecedor = new Fornecedor();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do Fornecedor: ");
        fornecedor.setNomeFornecedor(input.nextLine());
        System.out.print("Numero de Telefone do Fornecedor: ");
        fornecedor.setTelefoneFornecedor(input.nextLine());

        fornecedorController.cadastrarFornecedor(fornecedor);
        System.out.println("\n" + fornecedor);
    }

    public void editarFornecedor(){
        this.listarFornecedores();
        System.out.println("Pressione ENTER caso não queira mudar o campo pedido.");
        System.out.print("Escolha o Fornecedor a ser editado a partir do ID: ");
        Fornecedor fornecedorSelecionado = fornecedorController.selecionarFornecedor(Long.parseLong(input.nextLine()));

        String aux;

        System.out.print("Novo nome do fornecedor: ");
        aux = input.nextLine();
        if (aux != "") {
            fornecedorSelecionado.setNomeFornecedor(aux);
        }

        System.out.print("Novo numero de telefone do fornecedor: ");
        aux = input.nextLine();
        if (aux != "") {
            fornecedorSelecionado.setTelefoneFornecedor(aux);
        }

        fornecedorController.editarFornecedor(fornecedorSelecionado);
    }

    public void removerFornecedor(){
        this.listarFornecedores();
        System.out.print("Escolha o Fornecedor a ser removido a partir do ID: ");
        Long idFornecedor = Long.parseLong(input.nextLine());
        fornecedorController.removerFornecedor(idFornecedor);
        System.out.println("Fornecedor removido com sucesso!");
    }


    public void listarFornecedores(){
        List<Fornecedor> fornecedores = fornecedorController.listarFornecedor();
        System.out.println();
        for (int i = 0; i < fornecedores.size(); i++){
            System.out.println("ID: " + fornecedores.get(i).getIdFornecedor() +
                    " | Nome do Fornecedor: " + fornecedores.get(i).getNomeFornecedor() +
                    " | Numero de Telefone do Fornecedor: " + fornecedores.get(i).getTelefoneFornecedor());
        }
        System.out.println();
    }

}
