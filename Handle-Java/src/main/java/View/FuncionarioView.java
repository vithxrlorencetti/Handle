package View;

import Controller.FuncionarioController;
import Model.Funcionario;

import java.util.List;
import java.util.Scanner;

public class FuncionarioView {

    Scanner input = new Scanner(System.in);
    FuncionarioController funcionarioController = new FuncionarioController();

    public void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do Funcionário: ");
        funcionario.setNomeFuncionario(input.nextLine());
        System.out.print("Número de Identidade do Funcionário: ");
        funcionario.setNumIdentidadeFuncionario(input.nextLine());
        System.out.print("Numero de Telefone do Funcionário: ");
        funcionario.setTelefoneFuncionario(input.nextLine());
        System.out.print("Sálario do Funcionário: R$");
        funcionario.setSalarioFuncionario(Double.parseDouble(input.nextLine()));

        funcionarioController.cadastrarFuncionario(funcionario);
        System.out.print("\n" + funcionario);
    }

    public void editarFuncionario(){
        this.listarFuncionarios();

        System.out.println("Pressione ENTER caso não queira mudar o campo pedido.");
        System.out.print("Escolha o Funcionario a ser editado a partir do ID: ");
        Funcionario funcionarioSelecionado = funcionarioController.selecionarFuncionario(Long.parseLong(input.nextLine()));

        String aux;

        System.out.print("Novo nome do funcionario: ");
        aux = input.nextLine();
        if (aux != "") {
            funcionarioSelecionado.setNomeFuncionario(aux);
        }
        System.out.print("Novo numero de indentidade do funcionario: ");
        aux = input.nextLine();
        if (aux != "") {
            funcionarioSelecionado.setNumIdentidadeFuncionario(aux);
        }
        System.out.print("Novo numero de telefone do funcionario: ");
        aux = input.nextLine();
        if (aux != "") {
            funcionarioSelecionado.setTelefoneFuncionario(aux);
        }
        System.out.print("Novo salario do funcionario: R$");
        aux = input.nextLine();
        if (aux != "") {
            funcionarioSelecionado.setSalarioFuncionario(Double.parseDouble(aux));
        }

        funcionarioController.editarFuncionario(funcionarioSelecionado);
    }


    public void removerFuncionario(){
        this.listarFuncionarios();
        System.out.print("Escolha o Funcionario a ser removido a partir do ID: ");
        Long idEscolhido = Long.parseLong(input.nextLine());
        funcionarioController.removerFuncionario(idEscolhido);
        System.out.println("Funcionario removido com sucesso!");
    }


    public void listarFuncionarios(){
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        System.out.println();
        for (int i = 0; i < funcionarios.size(); i++){
            System.out.println("ID: " + funcionarios.get(i).getIdFuncionario() + " | Nome do Funcionario: "
                    + funcionarios.get(i).getNomeFuncionario() + " | Numerco de Identidade do Funcionario: " +
                    funcionarios.get(i).getNumIdentidadeFuncionario() + " | Numero de Telefone do Funcionario: "
                    + funcionarios.get(i).getTelefoneFuncionario() + " | Salario do Funcionario: R$" +
                    funcionarios.get(i).getSalarioFuncionario());
        }
        System.out.println();
    }


}