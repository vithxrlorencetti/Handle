package View;

import Controller.ProdutoController;
import Model.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoView {

    ProdutoController produtoController = new ProdutoController();
    Scanner input = new Scanner(System.in);
    CategoriaView categoriaView = new CategoriaView();
    FornecedorView fornecedorView = new FornecedorView();

    public void cadastrarProduto() {
        Produto produto = new Produto();

        Scanner input = new Scanner(System.in);
        System.out.print("Nome do produto: ");
        produto.setNomeProduto(input.nextLine());
        System.out.print("Quantidade do Produto: ");
        produto.setQuantProduto(Long.parseLong(input.nextLine()));
        System.out.print("Codigo de Barras: ");
        produto.setCodigoDeBarras(Long.parseLong(input.nextLine()));
        System.out.print("Valor de custo: R$");
        produto.setValorCusto(Double.parseDouble(input.nextLine()));
        System.out.print("Valor de venda: R$");
        produto.setValorVenda(Double.parseDouble(input.nextLine()));

        categoriaView.listarCategorias();
        System.out.print("ID da Categoria para este Produto: ");
        produto.setIdCategoria(Long.parseLong(input.nextLine()));
        System.out.println("\nProduto adicionado a Categoria Escolhida.");

        fornecedorView.listarFornecedores();
        System.out.print("ID do Fornecedor para este Produto: ");
        produto.setIdFornecedor(Long.parseLong(input.nextLine()));
        System.out.println("\nProduto adicionado o Fornecedor Escolhido.");

        produtoController.cadastrarProduto(produto);
        System.out.println("\n" + produto);

    }

    public void editarProduto(){

        this.listarProdutos();
        System.out.println("Pressione ENTER caso não queira mudar o campo pedido.");
        System.out.print("Escolha o produto a ser editado a partir do ID: ");
        Produto produtoSelecionado = produtoController.selecionarProduto(Long.parseLong(input.nextLine()));

        String aux;

        System.out.print("Novo nome do produto: ");
        aux = input.nextLine();
        if (aux != "") {
            produtoSelecionado.setNomeProduto(aux);
        }

        System.out.print("Nova quantidade do produto: ");
        aux = input.nextLine();
        if (aux != "") {
            produtoSelecionado.setQuantProduto(Long.parseLong(aux));
        }

        System.out.print("Novo codigo de Barras: ");
        aux = input.nextLine();
        if (aux != "") {
            produtoSelecionado.setCodigoDeBarras(Long.parseLong(aux));
        }

        System.out.print("Novo valor de custo: R$");
        aux = input.nextLine();
        if (aux != "") {
            produtoSelecionado.setValorCusto(Double.parseDouble(aux));
        }

        System.out.print("Novo valor de venda: R$");
        aux = input.nextLine();
        if (aux != "") {
            produtoSelecionado.setValorVenda(Double.parseDouble(aux));
        }

        produtoController.editarProduto(produtoSelecionado);

    }

    public void removerProduto() {
        this.listarProdutos();
        System.out.print("Escolha o produto a ser removido a partir do ID: ");
        Long idProduto = Long.parseLong(input.nextLine());
        produtoController.removerProduto(idProduto);
        System.out.println("Produto removido com sucesso!");
    }


    public void listarProdutosPorCategoria(){
        categoriaView.listarCategorias();
        System.out.print("Digite o ID da categoria que deseja listar os produtos: ");
        Long idCategoria = input.nextLong();

        List<Produto> produtos = produtoController.listarProdutosPorCategoria(idCategoria);
        System.out.println();
        System.out.println("-------Produtos da Categoria " + idCategoria +"--------");
        System.out.println();
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("Nome do Produto: " + produtos.get(i).getNomeProduto()); ;
        }
        System.out.println();
    }

    public void listarProdutosPorFornecedor(){
        fornecedorView.listarFornecedores();
        System.out.print("Digite o ID do Fornecedor que deseja listar os produtos: ");
        Long idFornecedor = input.nextLong();

        List<Produto> produtos = produtoController.listarProdutosPorFornecedor(idFornecedor);
        System.out.println();
        System.out.println("-------Produtos do Fornecedor " + idFornecedor + "--------");
        System.out.println();
        for (int i = 0; i < produtos.size(); i++){
            System.out.println("Nome do Produto: " + produtos.get(i).getNomeProduto());
        }
        System.out.println();
    }

    public void listarProdutos() {

        List<Produto> produtos = produtoController.listarProdutos();
        System.out.println();
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("ID: " + produtos.get(i).getIdProduto() + " | Nome do produto: " + produtos.get(i).getNomeProduto() + " | Quantidade: "
                    + produtos.get(i).getQuantProduto() + " | Codigo de Barras: " + produtos.get(i).getCodigoDeBarras() +
                    " | Valor de Custo: R$" + produtos.get(i).getValorCusto() + " | Valor de Venda: R$"
                    + produtos.get(i).getValorVenda());
        }
        System.out.println();
    }
}
