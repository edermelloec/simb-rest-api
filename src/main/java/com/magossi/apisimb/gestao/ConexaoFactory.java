package com.magossi.apisimb.gestao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection criarConexaoa() {

        //Crie uma conexao com o Banco

            //carrega o Driver na memoria
        try {
            Class.forName("org.postgresql.Driver");


            String dbUrl = "jdbc:postgresql://" + "ec2-54-217-250-0.eu-west-1.compute.amazonaws.com" + ':' + "5432" + "/dbsru71cfngle8?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

            //Retorna conection
            return DriverManager.getConnection(dbUrl,"mogwyaquxdnbzj","cf034bb87e5629d90f4a6c58ced2735c74df1f10194cb9f93cb076a518e5bb05");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
