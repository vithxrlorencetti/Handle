package DAO;

import Factory.ConnectionFactory;
import Model.Cliente;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    Connection connection;

    public ClienteDAO(){
        try {
            connection = new ConnectionFactory().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabelaClientes(){
        String sql = "CREATE TABLE IF NOT EXISTS clientes(" +
                "idCliente BIGSERIAL PRIMARY KEY," +
                "nomeCliente VARCHAR(50)NOT NULL," +
                "telefoneCliente VARCHAR(50)NOT NULL)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes(nomeCliente, telefoneCliente) VALUES(?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,cliente.getNomeCliente());
            preparedStatement.setString(2,cliente.getTelefoneCliente());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                cliente.setIdCliente(resultSet.getInt(1));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarCliente (Cliente cliente) {
        String sql = "UPDATE clientes SET nomeCliente = ?, telefoneCliente = ? WHERE idCliente = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setString(2, cliente.getTelefoneCliente());
            preparedStatement.setLong(3, cliente.getIdCliente());

            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("\nCliente editado: ID: " + cliente.getIdCliente() +
                    " | Nome do Cliente: " + cliente.getNomeCliente() +
                      " | Telefone do Cliente: " + cliente.getTelefoneCliente());
            System.out.println();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public Cliente selecionarCliente(Long idCliente){
        String sql = "SELECT * FROM clientes WHERE idCliente = ?";
        Cliente cliente = new Cliente();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,idCliente);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                cliente.setNomeCliente(resultSet.getString("nomeCliente"));
                cliente.setTelefoneCliente(resultSet.getString("telefoneCliente"));
            }
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public void removerCliente(Long idCliente){
        String sql = "DELETE FROM  clientes WHERE idCliente = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,idCliente);
            Cliente cliente = selecionarCliente(idCliente);
            System.out.println("Removendo o(a) cliente(a) " + cliente.getNomeCliente() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarClientes(){
        String sql = "SELECT * FROM clientes";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong("idCliente"));
                cliente.setNomeCliente(resultSet.getString("nomeCliente"));
                cliente.setTelefoneCliente(resultSet.getString("telefoneCliente"));

                clientes.add(cliente);
            }
            return clientes;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}