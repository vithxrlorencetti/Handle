package DAO;

import Factory.ConnectionFactory;
import Model.Fornecedor;
import Model.Funcionario;
import Model.Produto;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO {

    private Connection connection;

    public FornecedorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaFornecedor() {

        String sql = "CREATE TABLE IF NOT EXISTS fornecedores (" +
                "idFornecedor BIGSERIAL PRIMARY KEY," +
                "nomeFornecedor VARCHAR(50) NOT NULL ," +
                "telefoneFornecedor VARCHAR(50) NOT NULL" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedores(nomeFornecedor, telefoneFornecedor) VALUE (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fornecedor.getNomeFornecedor());
            preparedStatement.setString(2, fornecedor.getTelefoneFornecedor());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                fornecedor.setIdFornecedor(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarFornecedor(Fornecedor fornecedor){
        String sql = "UPDATE fornecedores SET nomeFornecedor = ?, telefoneFornecedor = ? WHERE idFornecedor = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fornecedor.getNomeFornecedor());
            preparedStatement.setString(2, fornecedor.getTelefoneFornecedor());
            preparedStatement.setLong(3, fornecedor.getIdFornecedor());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nFornecedor editado: ID: " + fornecedor.getIdFornecedor() +
                    " | Nome do Fornecedor: " + fornecedor.getNomeFornecedor() +
                    " | Telefone do Fornecedor: " + fornecedor.getTelefoneFornecedor());
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public Fornecedor selecionarFornecedor(Long idFornecedor) {
        String sql = "SELECT * FROM fornecedores WHERE idFornecedor = ?";
        Fornecedor fornecedor = new Fornecedor();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idFornecedor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
                fornecedor.setTelefoneFornecedor(resultSet.getString("telefoneFornecedor"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return fornecedor;
    }

    public void removerFornecedor(Long idFornecedor) {
        String sql = "DELETE FROM fornecedores WHERE idFornecedor = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idFornecedor);
            Fornecedor fornecedor = selecionarFornecedor(idFornecedor);
            System.out.println("Removendo o(a) fornecedor(a) " + fornecedor.getNomeFornecedor() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Fornecedor> listarFornecedores() {
        String sql = "SELECT * FROM fornecedores";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Fornecedor> fornecedores = new ArrayList<>();

            while (resultSet.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
                fornecedor.setTelefoneFornecedor(resultSet.getString("telefoneFornecedor"));
                fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
