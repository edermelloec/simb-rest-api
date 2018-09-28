package com.magossi.apisimb.gestao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection criarConexao() {

        //Crie uma conexao com o Banco
        try {
            //carrega o Driver na memoria
            Class.forName("org.postgresql.Driver");

            //Crie um conexao com o banco
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simb-heroku","postgres","postgres");

            //Retorna conection
            return connection;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
