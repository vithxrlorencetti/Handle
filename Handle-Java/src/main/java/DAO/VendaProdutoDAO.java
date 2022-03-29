package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendaProdutoDAO {

    private Connection connection;

    public void criarTabelaVendasProdutos(){

        String sql = "CREATE TABLE IF NOT EXISTS vendasProdutos (" +
                "idVendaProduto BIGSERIAL PRIMARY KEY," +
                "idVenda BIGINT," +
                "CONSTRAINT idVenda FOREIGN KEY (idVenda)" +
                "REFERENCES vendas(idVenda)" +
                "idProduto BIGINT," +
                "CONSTRAINT idProduto FOREIGN KEY (idProduto)" +
                "REFERENCES produtos(idProduto)" +
                ");";

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Tabela VendasProdutos criada com sucesso!");

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

}
