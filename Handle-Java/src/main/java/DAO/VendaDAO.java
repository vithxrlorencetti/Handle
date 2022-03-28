package DAO;


import Model.*;
import java.sql.*;

public class VendaDAO {

    private Connection connection;

    VendaProduto vendaProduto = new VendaProduto();
    Cliente cliente = new Cliente();
    Funcionario funcionario = new Funcionario();

    public void criarTabelaVendas() {

        String sql = "CREATE TABLE IF NOT EXISTS vendas (" +
                "idVenda INT PRIMARY KEY AUTO_INCREMENT," +
                "dataVenda DATE," +
                "idVendaProduto INT," +
                "CONSTRAINT idVendaProduto FOREIGN KEY (idVendaProduto)" +
                "REFERENCES vendasProdutos(idVendaProduto)" +
                "idCliente INT," +
                "CONSTRAINT idCliente FOREIGN KEY (idCLiente)" +
                "REFERENCES clientes(idCliente)" +
                "idFuncionario INT," +
                "CONSTRAINT idFuncionario FOREIGN KEY (idFuncionario)" +
                "REFERENCES funcionarios(idFuncionario)" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Tabela de Produtos foi criada!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void cadastrarVenda(Venda venda){

        String sql = "INSERT INTO vendas(dataVenda, idVendaProduto, idCliente, idFuncionario) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setDate(1, (Date) Date.from(venda.getDataVenda()));
            preparedStatement.setLong(2, vendaProduto.getIdVendaProduto());
            preparedStatement.setLong(3, cliente.getIdCliente());
            preparedStatement.setLong(4, funcionario.getIdFuncionario());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                venda.setIdVenda(resultSet.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void editarVenda(Venda venda) {
        String sql = "UPDATE vendas SET dataVenda = ?, idVendaProduto = ?, idCliente = ?, idFuncionario = ? WHERE idVenda = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDate(1, (Date) Date.from(venda.getDataVenda()));
            preparedStatement.setLong(2, vendaProduto.getIdVendaProduto());
            preparedStatement.setLong(3, cliente.getIdCliente());
            preparedStatement.setLong(4, funcionario.getIdFuncionario());
            preparedStatement.setLong(5, venda.getIdVenda());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nVenda editada: ID: " + venda.getIdVenda() +
                    " | ID do Cliente: " + cliente.getIdCliente() +
                    " | ID do Funcionário: " + funcionario.getIdFuncionario());

            System.out.println();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public Venda selecionarVenda(Long idVenda) {
        String sql = "SELECT * FROM vendas WHERE idVenda = ?";
        Venda venda = new Venda();
        VendaProduto vendaProduto = new VendaProduto();
        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idVenda);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venda.setIdVenda(resultSet.getLong("idVenda"));
                venda.setDataVenda(resultSet.getDate("dataVenda").toInstant());
                vendaProduto.setIdVendaProduto(resultSet.getLong("idVendaProduto"));
                cliente.setIdCliente(resultSet.getInt("idCliente"));
                funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return venda;
    }

    public void removerVenda(Long idVenda) {
        String sql = "DELETE FROM vendas WHERE idVenda = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idVenda);
            Venda venda = selecionarVenda(idVenda);
            System.out.println("Removendo a venda " + venda.getIdVenda() + "...");
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Venda removida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

