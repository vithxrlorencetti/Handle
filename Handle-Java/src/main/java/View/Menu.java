package View;
import DAO.*;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public void menuPrincipal() {

        while (true) {

            System.out.println("-------------Menu Principal-------------");
            System.out.println("-           1 > Produtos               -");
            System.out.println("-           2 > Funcionários           -");
            System.out.println("-           3 > Fornecedores           -");
            System.out.println("-           4 > Clientes               -");
            System.out.println("-           5 > Categorias             -");
            System.out.println("----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuFuncionarios();
                    break;
                case 3:
                    menuFornecedor();
                    break;
                case 4:
                    menuClientes();
                    break;
                case 5:
                    menuCategorias();
                    break;
            }
        }
    }

    public int menuProdutos() {

        ProdutoView produtoView = new ProdutoView();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.criarTabelaProdutos();

        while (true) {
            System.out.println("\n-------------Menu Produtos----------------");
            System.out.println("-      1 > Cadastrar Produto               -");
            System.out.println("-      2 > Editar Produto                  -");
            System.out.println("-      3 > Remover Produto                 -");
            System.out.println("-      4 > Listar Produtos Por Categoria   -");
            System.out.println("-      5 > Listar Produtos Por Fornecedor  -");
            System.out.println("-      6 > Listar Produtos                 -");
            System.out.println("-      7 > Voltar                          -");
            System.out.println("--------------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    produtoView.cadastrarProduto();
                    break;
                case 2:
                    produtoView.editarProduto();
                    break;
                case 3:
                    produtoView.removerProduto();
                    break;
                case 4:
                    produtoView.listarProdutosPorCategoria();
                    break;
                case 5:
                    produtoView.listarProdutosPorFornecedor();
                    break;
                case 6:
                    produtoView.listarProdutos();
                    break;
                case 7:
                    return -1;

            }
        }
    }
    public int menuFuncionarios(){
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.criarTabelaFuncionario();
        while (true){
            System.out.println();
            System.out.println("\n------------Menu Funcionários-------------");
            System.out.println("-       1 > Cadastrar Funcionário          -");
            System.out.println("-       2 > Editar Funcionário             -");
            System.out.println("-       3 > Remover Funcionário            -");
            System.out.println("-       4 > Listar Funcionários            -");
            System.out.println("-       5 > Voltar                         -");
            System.out.println("--------------------------------------------");

            int escolha = input.nextInt();
            switch (escolha){
                case 1:
                    funcionarioView.cadastrarFuncionario();
                    break;
                case 2:
                    funcionarioView.editarFuncionario();
                    break;
                case 3:
                    funcionarioView.removerFuncionario();
                    break;
                case 4:
                    funcionarioView.listarFuncionarios();
                    break;
                case 5:
                    return -1;
            }
        }
    }


    public int menuFornecedor(){

        FornecedorView fornecedorView = new FornecedorView();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.criaTabelaFornecedor();

        while(true){
            System.out.println("\n-------------Menu Fornecedor-------------");
            System.out.println("-       1 > Cadastrar Fornecedor          -");
            System.out.println("-       2 > Editar Fornecedor             -");
            System.out.println("-       3 > Remover Fornecedor            -");
            System.out.println("-       4 > Listar Fornecedores           -");
            System.out.println("-       5 > Voltar                        -");
            System.out.println("-------------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    fornecedorView.cadastrarFornecedor();
                    break;
                case 2:
                    fornecedorView.editarFornecedor();
                    break;
                case 3:
                    fornecedorView.removerFornecedor();
                    break;
                case 4:
                    fornecedorView.listarFornecedores();
                    break;
                case 5:
                    return -1;
            }
        }
    }

    public int menuClientes() {

        ClienteView clienteView = new ClienteView();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.criarTabelaClientes();
        while (true) {
            System.out.println("\n-------------Menu Clientes-------------");
            System.out.println("-       1 > Cadastrar Cliente           -");
            System.out.println("-       2 > Editar Cliente              -");
            System.out.println("-       3 > Remover Cliente             -");
            System.out.println("-       4 > Listar Clientes             -");
            System.out.println("-       5 > Voltar                      -");
            System.out.println("-----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    clienteView.cadastrarCliente();
                    break;
                case 2:
                    clienteView.editarCliente();
                    break;
                case 3:
                    clienteView.removerCliente();
                    break;
                case 4:
                    clienteView.listarClientes();
                    break;
                case 5:
                    return  -1;
            }
        }
    }

    public int menuCategorias(){
        CategoriaView categoriaView = new CategoriaView();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.criarTabelaCategorias();
        while (true){
            System.out.println("------------Menu Categorias-------------");
            System.out.println("-       1 > Cadastrar Categoria        -");
            System.out.println("-       2 > Editar Categoria           -");
            System.out.println("-       3 > Remover Categoria          -");
            System.out.println("-       4 > Listar Categorias          -");
            System.out.println("-       5 > Voltar                     -");
            System.out.println("----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha){
                case 1:
                    categoriaView.cadastrarCategoria();
                    break;
                case 2:
                    categoriaView.editarCategoria();
                    break;
                case 3:
                    categoriaView.removerCategoria();
                    break;
                case 4:
                    categoriaView.listarCategorias();
                    break;
                case 5:
                    return -1;
            }
        }
    }
}