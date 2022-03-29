package DAO;

import Factory.ConnectionFactory;
import Model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO() {
        try {
            this.connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaCategorias() {
        String sql = "CREATE TABLE IF NOT EXISTS categorias (" +
                "idCategoria BIGSERIAL PRIMARY KEY," +
                "nomeCategoria VARCHAR(50)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cadastrarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nomeCategoria) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, categoria.getNomeCategoria());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                categoria.setIdCategoria(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET nomeCategoria = ? WHERE idCategoria = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getNomeCategoria());
            preparedStatement.setLong(2, categoria.getIdCategoria());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nCategoria editada: ID: " + categoria.getIdCategoria() +
                    " | Nome do produto: " + categoria.getNomeCategoria());
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Categoria selecionarCategoria(Long idCategoria) {
        String sql = "SELECT * FROM categorias WHERE idCategoria = ?";
        Categoria categoria = new Categoria();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idCategoria);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNomeCategoria(resultSet.getString("nomeCategoria"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

    public void removerCategoria(Long idCategoria) {
        String sql = "DELETE FROM categorias WHERE idCategoria = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idCategoria);
            Categoria categoria = selecionarCategoria(idCategoria);
            System.out.println("Removendo a categoria " + categoria.getNomeCategoria() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listarCategorias() {
        String sql = "SELECT * FROM categorias";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Categoria> categorias = new ArrayList<>();

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNomeCategoria(resultSet.getString("nomeCategoria"));
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

