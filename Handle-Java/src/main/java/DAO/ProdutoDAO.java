package DAO;

import Factory.ConnectionFactory;
import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "idProduto BIGSERIAL PRIMARY KEY," +
                "nomeProduto VARCHAR(50)," +
                "quantProduto INT," +
                "valorCusto DECIMAL(10, 2)," +
                "valorVenda DECIMAL(10, 2)," +
                "codigoDeBarras INT," +
                "idCategoria BIGINT NOT NULL," +
                    "CONSTRAINT fk_idCategoria FOREIGN KEY (idCategoria)" +
                    "REFERENCES categorias(idCategoria)" +
                    "ON DELETE CASCADE," +
                "idFornecedor BIGINT NOT NULL," +
                    "CONSTRAINT fk_idFornecedor FOREIGN KEY (idFornecedor)" +
                    "REFERENCES fornecedores(idFornecedor)" +
                    "ON DELETE CASCADE " +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("\nVoce ja cadastrou uma Categoria ou um Fornecedor? Se não, crie-os e depois cadastre um produtos\n");
            throw new RuntimeException(e);
        }
    }

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produtos(nomeProduto, quantProduto, valorCusto, valorVenda, codigoDeBarras,idCategoria,idFornecedor) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setLong(2, produto.getQuantProduto());
            preparedStatement.setDouble(3, produto.getValorCusto());
            preparedStatement.setDouble(4, produto.getValorVenda());
            preparedStatement.setLong(5, produto.getCodigoDeBarras());
            preparedStatement.setLong(6, produto.getIdCategoria());
            preparedStatement.setLong(7, produto.getIdFornecedor());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                produto.setIdProduto(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void editarProduto(Produto produto) {
        String sql = "UPDATE produtos SET nomeProduto = ?, quantProduto = ?, codigoDeBarras = ?, valorCusto = ?, valorVenda = ? WHERE idProduto = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setLong(2, produto.getQuantProduto());
            preparedStatement.setLong(3, produto.getCodigoDeBarras());
            preparedStatement.setDouble(4, produto.getValorCusto());
            preparedStatement.setDouble(5, produto.getValorVenda());
            preparedStatement.setLong(6, produto.getIdProduto());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nProduto editado: ID: " + produto.getIdProduto() +
                    " | Nome do produto: " + produto.getNomeProduto() +
                    " | Quantidade: " + produto.getQuantProduto() +
                    " | Codigo de Barras: " + produto.getCodigoDeBarras() +
                    " | Valor de Custo: R$" + produto.getValorCusto() +
                    " | Valor de Venda: R$" + produto.getValorVenda());

            System.out.println();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Produto selecionarProduto(Long idProduto) {
        String sql = "SELECT * FROM produtos WHERE idProduto = ?";
        Produto produto = new Produto();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idProduto);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setQuantProduto(resultSet.getInt("quantProduto"));
                produto.setValorCusto(resultSet.getDouble("valorCusto"));
                produto.setValorVenda(resultSet.getDouble("valorVenda"));
                produto.setCodigoDeBarras(resultSet.getInt("codigoDeBarras"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produto;
    }

    public void removerProduto(Long idProduto) {
        String sql = "DELETE FROM produtos WHERE idProduto = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idProduto);
            Produto produto = selecionarProduto(idProduto);
            System.out.println("Removendo o produto " + produto.getNomeProduto() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> listarProdutosPorCategoria(Long idCategoria){
        String sql = "SELECT produtos.nomeProduto, categorias.idCategoria " +
                "FROM produtos " +
                "INNER JOIN categorias " +
                "ON produtos.idCategoria = categorias.idCategoria " +
                "WHERE categorias.idCategoria = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            preparedStatement.setLong(1,idCategoria);
            categoriaDAO.selecionarCategoria(idCategoria);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Produto> listarProdutosPorCategoria = new ArrayList<>();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setIdCategoria(resultSet.getInt("idCategoria"));

                listarProdutosPorCategoria.add(produto);
            }
            return listarProdutosPorCategoria;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Produto> listarProdutosPorFornecedor(Long idFornecedor){
        String sql = "SELECT produtos.nomeProduto, fornecedores.idFornecedor " +
                "FROM produtos " +
                "INNER JOIN fornecedores " +
                "ON produtos.idFornecedor = fornecedores.idFornecedor " +
                "WHERE fornecedores.idFornecedor = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            preparedStatement.setLong(1, idFornecedor);
            fornecedorDAO.selecionarFornecedor(idFornecedor);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Produto> listarProdutosPorFornecedor = new ArrayList<>();

            while (resultSet.next()){
                Produto produto = new Produto();
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setIdFornecedor(resultSet.getInt("idFornecedor"));

                listarProdutosPorFornecedor.add(produto);
            }
            return listarProdutosPorFornecedor;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Produto> produtos = new ArrayList<>();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(resultSet.getInt("idProduto"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setQuantProduto(resultSet.getInt("quantProduto"));
                produto.setValorCusto(resultSet.getDouble("valorCusto"));
                produto.setValorVenda(resultSet.getDouble("valorVenda"));
                produto.setCodigoDeBarras(resultSet.getInt("codigoDeBarras"));

                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}