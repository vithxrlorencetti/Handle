package DAO;

import Factory.ConnectionFactory;
import Model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {

    Connection connection;

    public FuncionarioDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaFuncionario(){
        String sql = "CREATE TABLE IF NOT EXISTS funcionarios(" +
                "idFuncionario INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeFuncionario VARCHAR(50) NOT NULL," +
                "numIdentidadeFuncionario VARCHAR(50) NOT NULL," +
                "telefoneFuncionario VARCHAR(50) NOT NULL," +
                "salarioFuncionario DOUBLE)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionarios(nomeFuncionario, numIdentidadeFuncionario, telefoneFuncionario, salarioFuncionario) VALUE (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,funcionario.getNomeFuncionario());
            preparedStatement.setString(2, funcionario.getNumIdentidadeFuncionario());
            preparedStatement.setString(3, funcionario.getTelefoneFuncionario());
            preparedStatement.setDouble(4, funcionario.getSalarioFuncionario());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                funcionario.setIdFuncionario(resultSet.getInt(1));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nomeFuncionario = ?, numIdentidadeFuncionario = ?, telefoneFuncionario = ?, salarioFuncionario = ? WHERE idFuncionario = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getNomeFuncionario());
            preparedStatement.setString(2, funcionario.getNumIdentidadeFuncionario());
            preparedStatement.setString(3, funcionario.getTelefoneFuncionario());
            preparedStatement.setDouble(4, funcionario.getSalarioFuncionario());
            preparedStatement.setLong(5, funcionario.getIdFuncionario());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nFuncionario editado: ID: " + funcionario.getIdFuncionario() +
                    " | Nome do Funcionario: " + funcionario.getNomeFuncionario() +
                    " | Numero de Identidade do Funcionario: " + funcionario.getNumIdentidadeFuncionario() +
                    " | Numero de Telefone do Funcionario: " + funcionario.getTelefoneFuncionario() +
                    " | Salario do Funcionario: R$" + funcionario.getSalarioFuncionario());
            System.out.println();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


    public Funcionario selecionarFuncionario(Long idFuncionario){
        String sql = "SELECT * FROM funcionarios WHERE idFuncionario = ?";
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idFuncionario);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
                funcionario.setNumIdentidadeFuncionario(resultSet.getString("numIdentidadeFuncionario"));
                funcionario.setTelefoneFuncionario(resultSet.getString("telefoneFuncionario"));
                funcionario.setSalarioFuncionario(resultSet.getDouble("salarioFuncionario"));
            }
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return funcionario;
    }

    public void removerFuncionario(Long idFuncionario){
        String sql = "DELETE FROM funcionarios WHERE idFuncionario = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,idFuncionario);
            Funcionario funcionario = selecionarFuncionario(idFuncionario);
            System.out.println("Removendo o(a) funcionario(a) " + funcionario.getNomeFuncionario() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> listarFuncionarios(){
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Funcionario> funcionarios = new ArrayList<>();

            while (resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(resultSet.getLong("idFuncionario"));
                funcionario.setNomeFuncionario(resultSet.getString("nomeFuncionario"));
                funcionario.setNumIdentidadeFuncionario(resultSet.getString("numIdentidadeFuncionario"));
                funcionario.setTelefoneFuncionario(resultSet.getString("telefoneFuncionario"));
                funcionario.setSalarioFuncionario(resultSet.getDouble("salarioFuncionario"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}