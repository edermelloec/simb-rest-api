package com.magossi.apisimb.gestao;


import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Desmama;
import com.magossi.apisimb.domain.bovino.Morto;
import com.magossi.apisimb.domain.matriz.FichaMatriz;
import com.magossi.apisimb.domain.matriz.FichaTouro;
import com.magossi.apisimb.repository.bovino.BovinoRepository;
import com.magossi.apisimb.repository.matriz.FichaMatrizRepository;
import com.magossi.apisimb.repository.matriz.FichaToutroRepository;
import com.magossi.apisimb.repository.matriz.PartoRepository;
import com.magossi.apisimb.repository.matriz.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestaoRespositoryBanco {


    Float taxa;

    String sql;
    String json = null;

    Connection conexao = ConexaoFactory.criarConexaoa();

    public String prenhezTodos() {

        try {



            sql = "select (select count(*) from resultado r where r.resultado = 'Cheia' ),count(*) from resultado";


            PreparedStatement prepareStatement;


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();

            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }
            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String prenhezNovilha() {
        taxa = 0.0f;

        try {
            PreparedStatement prepareStatement;

            sql = "select id_ficha_matriz from ficha_matriz where status = true order by id_ficha_matriz";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            List<Integer> idMatrizAtivas = new ArrayList<>();
            while (result.next()) {
                idMatrizAtivas.add(result.getInt(1));
            }

            float qtdNovilha = 0;
            float qtdCheia = 0;

            for (int i = 0; i < idMatrizAtivas.size(); i++) {


                sql = "select id_ficha_matriz,resultado from resultado where id_ficha_matriz = " + idMatrizAtivas.get(i) + " order by id_resultado";
                prepareStatement = conexao.prepareStatement(sql);
                result = prepareStatement.executeQuery();

                if (result.next()) {
                    qtdNovilha++;
                    if ("Cheia".equals(result.getString(2))) {
                        qtdCheia++;
                    }
                }
            }


            if (qtdNovilha != 0) {
                taxa = (qtdCheia / qtdNovilha) * 100;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;
    }

    public String prenhezPrimi() {
        taxa = 0.0f;

        try {
            PreparedStatement prepareStatement;

            sql = "select id_ficha_matriz from ficha_matriz where status = true order by id_ficha_matriz";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            List<Integer> idMatrizAtivas = new ArrayList<>();
            while (result.next()) {
                idMatrizAtivas.add(result.getInt(1));
            }

            float qtdPrimiparas = 0;
            float qtdCheia = 0;

            for (int i = 0; i < idMatrizAtivas.size(); i++) {
                sql = "select id_ficha_matriz,status from parto where id_ficha_matriz = " + idMatrizAtivas.get(i) + "order by id_parto";
                prepareStatement = conexao.prepareStatement(sql);
                result = prepareStatement.executeQuery();


                if (result.next()) {

                    sql = "select id_ficha_matriz,resultado from resultado where id_ficha_matriz = " + idMatrizAtivas.get(i) + " order by id_resultado";
                    prepareStatement = conexao.prepareStatement(sql);
                    result = prepareStatement.executeQuery();


                    if (result.next()) {
                        if ("Cheia".equals(result.getString(2))) {
                            if (result.next()) {
                                qtdPrimiparas++;
                                if ("Cheia".equals(result.getString(2))) {
                                    qtdCheia++;
                                }
                            }
                        }
                    }
                }
            }




            if (qtdPrimiparas != 0) {
                taxa = (qtdCheia / qtdPrimiparas) * 100;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;
    }


    public String prenhezMult() {
        taxa = 0.0f;
        try {
            PreparedStatement prepareStatement;

            sql = "select id_ficha_matriz from ficha_matriz where status = true order by id_ficha_matriz";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            List<Integer> idMatrizAtivas = new ArrayList<>();
            while (result.next()) {
                idMatrizAtivas.add(result.getInt(1));
            }

            float qtdMultiparas = 0;
            float qtdCheia = 0;

            for (int i = 0; i < idMatrizAtivas.size(); i++) {
                sql = "select id_ficha_matriz,status from parto where id_ficha_matriz = " + idMatrizAtivas.get(i) + "order by id_parto";
                prepareStatement = conexao.prepareStatement(sql);
                result = prepareStatement.executeQuery();


                if (result.next()) {
                    if (result.next()) {
                        sql = "select id_ficha_matriz,resultado from resultado where id_ficha_matriz = " + idMatrizAtivas.get(i) + " order by id_resultado";
                        prepareStatement = conexao.prepareStatement(sql);
                        result = prepareStatement.executeQuery();

                        if (result.next()) {
                            if ("Cheia".equals(result.getString(2))) {
                                if (result.next()) {
                                    if ("Cheia".equals(result.getString(2))) {
                                        if (result.next()) {
                                            qtdMultiparas++;
                                            if ("Cheia".equals(result.getString(2))) {
                                                qtdCheia++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


            if (qtdMultiparas != 0) {
                taxa = (qtdCheia / qtdMultiparas) * 100;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;
    }

    public String natalidadeTodos() {
        taxa = 0.0f;
        try {


            sql = "select count(*),(select count(*) from parto p where p.status = 'Vivo') from parto";


            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(1) != 0) {
                taxa = result.getFloat(2);
                taxa = ((taxa / result.getFloat(1)) * 100);
            } else {
                taxa = 0.0f;
            }
            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String natalidadeNovilha() {
        taxa = 0.0f;
        try {
            PreparedStatement prepareStatement;

            sql = "select id_ficha_matriz from ficha_matriz where status = true order by id_ficha_matriz";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            List<Integer> idMatrizAtivas = new ArrayList<>();
            while (result.next()) {
                idMatrizAtivas.add(result.getInt(1));
            }

            float novilha = 0;
            float qtdVivo = 0;


            for (int i = 0; i < idMatrizAtivas.size(); i++) {
                sql = "select id_ficha_matriz,resultado from resultado where id_ficha_matriz = " + idMatrizAtivas.get(i) + " order by id_resultado";
                prepareStatement = conexao.prepareStatement(sql);
                result = prepareStatement.executeQuery();
                if (result.next()) {
                    novilha++;
                    if ("Cheia".equals(result.getString(2))) {

                        sql = "select id_ficha_matriz,status from parto where id_ficha_matriz = " + idMatrizAtivas.get(i) + "order by id_parto";

                        prepareStatement = conexao.prepareStatement(sql);
                        result = prepareStatement.executeQuery();

                        if (result.next()) {

                            if ("Vivo".equals(result.getString(2))) {
                                qtdVivo++;
                            }
                        }

                    }
                }
            }


            if (novilha != 0) {
                taxa = (qtdVivo / novilha) * 100;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;


    }

    public String natalidadePrimi() {
        taxa = 0.0f;

        try {
            PreparedStatement prepareStatement;

            sql = "select id_ficha_matriz from ficha_matriz where status = true order by id_ficha_matriz";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            List<Integer> idMatrizAtivas = new ArrayList<>();
            while (result.next()) {
                idMatrizAtivas.add(result.getInt(1));
            }

            float qtdPrimiparas = 0;
            float qtdVivo = 0;

            for (int i = 0; i < idMatrizAtivas.size(); i++) {
                sql = "select id_ficha_matriz,resultado from resultado where id_ficha_matriz = " + idMatrizAtivas.get(i) + " order by id_resultado";
                prepareStatement = conexao.prepareStatement(sql);
                result = prepareStatement.executeQuery();
                if (result.next()) {
                    if ("Cheia".equals(result.getString(2))) {
                        qtdPrimiparas++;
                        if (result.next()) {
                            if ("Cheia".equals(result.getString(2))) {

                                sql = "select id_ficha_matriz,status from parto where id_ficha_matriz = " + idMatrizAtivas.get(i) + "order by id_parto";

                                prepareStatement = conexao.prepareStatement(sql);
                                result = prepareStatement.executeQuery();

                                if (result.next()) {
                                    if (result.next()) {

                                        if ("Vivo".equals(result.getString(2))) {
                                            qtdVivo++;
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }


            if (qtdPrimiparas != 0) {
                taxa = (qtdVivo / qtdPrimiparas) * 100;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;


    }

    public String natalidadeMult() {
        taxa = 0.0f;
        try {
            PreparedStatement prepareStatement;

            sql = "select id_ficha_matriz from ficha_matriz where status = true order by id_ficha_matriz";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            List<Integer> idMatrizAtivas = new ArrayList<>();
            while (result.next()) {
                idMatrizAtivas.add(result.getInt(1));
            }

            float qtdMultiparas = 0;
            float qtdVivo = 0;

            for (int i = 0; i < idMatrizAtivas.size(); i++) {
                sql = "select id_ficha_matriz,resultado from resultado where id_ficha_matriz = " + idMatrizAtivas.get(i) + " order by id_resultado";
                prepareStatement = conexao.prepareStatement(sql);
                result = prepareStatement.executeQuery();
                if (result.next()) {
                    if ("Cheia".equals(result.getString(2))) {
                        if (result.next()) {
                            if ("Cheia".equals(result.getString(2))) {
                                qtdMultiparas++;
                                if (result.next()) {
                                    if ("Cheia".equals(result.getString(2))) {

                                        sql = "select id_ficha_matriz,status from parto where id_ficha_matriz = " + idMatrizAtivas.get(i) + "order by id_parto";

                                        prepareStatement = conexao.prepareStatement(sql);
                                        result = prepareStatement.executeQuery();

                                        if (result.next()) {
                                            if (result.next()) {
                                                if (result.next()) {

                                                    if ("Vivo".equals(result.getString(2))) {
                                                        qtdVivo++;

                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }


            if (qtdMultiparas != 0) {
                taxa = (qtdVivo / qtdMultiparas) * 100;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;


    }

    public String mediaPesoDesmama() {
        taxa = 0.0f;
        try {
            PreparedStatement prepareStatement;

            sql = "select peso from desmama";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            Float qtd = 0f;
            Float pesoTotal = 0f;
            while (result.next()) {
                qtd++;
                pesoTotal = pesoTotal + result.getFloat(1);
            }
            if (qtd != 0f) {
                taxa = pesoTotal / qtd;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;


    }

    public String mediaIdadeDesmama() {
        taxa = 0.0f;
        try {

            PreparedStatement prepareStatement;

            sql = "select ((DATE(d.data_desmama)-DATE(b.data_nascimento))/30) from desmama d\n" +
                    "                    inner join bovino b on b.id_bovino=d.id_bovino";


            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();

            Float qtd = 0f;
            Float pesoTotal = 0f;
            while (result.next()) {
                qtd++;
                pesoTotal = pesoTotal + result.getFloat(1);
            }

            if (qtd != 0f) {
                taxa = pesoTotal / qtd;
            } else {
                taxa = 0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return json;


    }

    public String idadePrimeiraCria(String bovino) {

        try {


            sql = "SELECT min((DATE(p.data_parto)-DATE(b.data_nascimento))/30) AS DIASDECORRIDOS FROM bovino b\n" +
                    "\t\tinner join parto p on p.id_ficha_matriz=b.ficha_matriz_id_ficha_matriz\n" +
                    "\t\twhere upper(b.nome_bovino) like upper(" + "'%" + bovino + "')";

            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            taxa = result.getFloat(1);

            json = "[{\"nome\": \"" + bovino + "\",\"fertilidade\": " + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String idadeDesmama(String bovino) {

        try {


            sql = "select ((DATE(d.data_desmama)-DATE(b.data_nascimento))/30) from desmama d\n" +
                    "\t\t\tinner join bovino b on b.id_bovino=d.id_bovino\n" +
                    "\t\t\twhere upper(b.nome_bovino) like upper(" + "'%" + bovino + "')";
            //upper(b.nome_bovino) like upper('%12')

            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            if (result.next()) {
                taxa = result.getFloat(1);
            } else {
                taxa = 0f;
            }
            json = "[{\"nome\": \"" + bovino + "\",\"fertilidade\": " + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String mortalidadeTotal() {
        try {


            sql = "select count(*), (select count(*) from bovino where status = 't')from bovino where situacao='Morto'\n";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();

            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);

            } else {
                taxa = 0.0f;
            }


            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String mortalidadePreParto() {
        try {


            sql = "select count(*),(select count(*) from bovino where status = 't') as dias from bovino b where b.situacao = 'Morto' and  (DATE(data_falecimento) - DATE (data_nascimento)) ='0'";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();

            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String mortalideAdulto() {
        try {


            sql = "select count(*),(select count(*) from bovino where status = 't') as dias from bovino b where b.situacao = 'Morto' and  (DATE(data_falecimento) - DATE (data_nascimento)) > '730'";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String mortalideJovens() {
        try {


            sql = "select count(*),(select count(*) from bovino where status = 't') as dias from bovino b where b.situacao = 'Morto' and  (DATE(data_falecimento) - DATE (data_nascimento)) >= '365' and  (DATE(data_falecimento) - DATE (data_nascimento)) <= '730'";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }

            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String mortalideAteDesmama() {
        try {

            sql = "select count(*),(select count(*) from bovino where status = 't') as dias from bovino b where b.situacao = 'Morto' and  (DATE(data_falecimento) - DATE (data_nascimento)) > '0' and  (DATE(data_falecimento) - DATE (data_nascimento)) < '365'";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }
            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String taxaDesmama() {
        try {

            sql = "select (select count(*) from desmama),count(*) from resultado";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }
            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String taxaAbate() {
        try {

            sql = "select (select count(*) from bovino where situacao = 'Abatido'),count(*) from bovino where status = 't'";
            PreparedStatement prepareStatement;

            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(2) != 0) {
                taxa = result.getFloat(1);
                taxa = ((taxa / result.getFloat(2)) * 100);
            } else {
                taxa = 0.0f;
            }
            json = "[{\"fertilidade\":" + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String taxaDesfrute(String dataInicial, String dataFinal) {


        try {
            sql = "select (select count(*) as inicial from bovino b where DATE(data_inclusao) <= '" + dataInicial + "' )\n" +
                    "\t,count(*) as dois,(select count(*) as vendido from bovino where situacao = 'Vendido' and DATE(data_inclusao) >= '" + dataInicial + "' and DATE(data_inclusao) <= '" + dataFinal + "')\n" +
                    "\t\tfrom bovino where DATE(data_inclusao) >= '" + dataInicial + "' and DATE(data_inclusao) <= '" + dataFinal + "'";


            PreparedStatement prepareStatement;
            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();
            if (result.getFloat(1) != 0) {


                taxa = (result.getFloat(2) + (result.getFloat(3)));
                taxa = taxa / result.getFloat(1);
                taxa = taxa * 100;
            } else {
                taxa = 0.0f;
            }


            json = "[{\"nome\": \"" + dataInicial + "\",\"fertilidade\": " + taxa + "}]";
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public String taxaTouroVaca() {


        try {

            sql = "select (select count(*) as touro from ficha_touro where status=true),count(*) as vaca from ficha_matriz where status=true";
            PreparedStatement prepareStatement;
            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();

            json = "[{\"nome\": \"" + result.getInt(1) + " : " + result.getInt(2) + "\",\"fertilidade\": " + taxa + "}]";


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return json;


    }

    public void alterarBovino(Integer a) {


        try {

            sql = "UPDATE bovino SET situacao = 'Vivo' WHERE id_bovino =" + a;
            PreparedStatement prepareStatement;
            prepareStatement = conexao.prepareStatement(sql);
            prepareStatement.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public Bovino salvarBovino(Bovino bovino) {
        String foto = null;
        if (bovino.getGenero()) {
            foto = "http://comprerural.com.s3-us-west-2.amazonaws.com/wp-content/uploads/2015/11/20202430/boi_touro_backup_.jpg";
        } else {
            foto = "http://www.colonialagropecuaria.com.br/_upload/_original/023c2bc3a26004145cec3db2373e8ca7.jpg";
        }

        try {

            sql = "insert into bovino(id_bovino,data_inclusao,data_nascimento,genero,mae,nome_bovino,pai,status,tag,url_foto,fazenda_id_fazenda,pelagem_id_pelagem,proprietario_id_proprietario,raca_id_raca,situacao) \n" +
                    "\tvalues (default,'" + bovino.getDataInclusao() + "','" + bovino.getDataNascimento() + "','" + bovino.getGenero() + "','" + bovino.getMae() + "','" + bovino.getNomeBovino() + "','" + bovino.getPai() + "','" + bovino.getStatus() + "','" + bovino.getTag() + "','" + foto + "'," + bovino.getFazenda().getIdFazenda() + "," + bovino.getPelagem().getIdPelagem() + "," + bovino.getProprietario().getIdProprietario() + "," + bovino.getRaca().getIdRaca() + ",'Vivo'" + ")";


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bovino;

    }


    public Bovino alterarBovino(Bovino bovino) {


        try {

            sql = "update bovino set data_nascimento = '" + bovino.getDataNascimento() + "',genero =" + bovino.getGenero() + ",status =" + bovino.getStatus() + ",mae = '" + bovino.getMae() + "',nome_bovino = '" + bovino.getNomeBovino() + "',pai='" + bovino.getPai() + "',fazenda_id_fazenda = " + bovino.getFazenda().getIdFazenda() + ",pelagem_id_pelagem = " + bovino.getPelagem().getIdPelagem() + ",proprietario_id_proprietario=" + bovino.getProprietario().getIdProprietario() + ",raca_id_raca= " + bovino.getRaca().getIdRaca() + "where id_bovino =" + bovino.getIdBovino();


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bovino;

    }

    public Morto salvarMorte(Morto morto) {


        try {

            sql = "insert into morto (id_morte, causa, data_morte, id_bovino, status)\n" +
                    "\tvalues (default, '" + morto.getCausa() + "', '" + morto.getDataMorte() + "'," + morto.getIdBovino() + ", " + true + ")";


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();
            sql = "UPDATE bovino set status = false, situacao = 'Morto', data_falecimento = '" + morto.getDataMorte() + "' where id_bovino = " + morto.getIdBovino();
            ps = conexao.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return morto;

    }

    public Long salvarVendido(Long id) {


        try {

            sql = "UPDATE bovino SET situacao = 'Vendido', status = false where id_bovino = " + id;


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return id;

    }

    public Long salvarAbatido(Long id) {


        try {

            sql = "UPDATE bovino SET situacao = 'Abatido', status = false where id_bovino = " + id;


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return id;

    }

    public Desmama salvarDesmama(Desmama desmama) {


        try {

            sql = " insert into desmama(id_desmama,data_desmama,status,id_bovino,id_ficha_matriz,peso)\n" +
                    "\tvalues (default,'" + desmama.getDataDesmama() + "','True','" + desmama.getIdBovino() + "','" + desmama.getIdFichaMatriz() + "','" + desmama.getPeso() + "')";


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return desmama;

    }


    public List<Bovino> listarMatriz() {
        List<Bovino> bovinos = new ArrayList<>();

        try {

            sql = "select id_bovino,nome_bovino from bovino where ficha_matriz_id_ficha_matriz is not null and status = true order by ficha_matriz_id_ficha_matriz";


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            Bovino bovino;
            while (result.next()) {
                bovino = new Bovino();
                bovino.setIdBovino(result.getLong(1));
                bovino.setNomeBovino(result.getString(2));
                bovinos.add(bovino);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bovinos;

    }

    public Bovino buscarNomeMatriz(Integer id) {
        Bovino bovino = null;

        try {

            sql = "select nome_bovino from bovino where ficha_matriz_id_ficha_matriz =" + id;


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            bovino = new Bovino();
            result.next();
            bovino.setNomeBovino(result.getString(1));


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bovino;

    }

    public List<Bovino> listarTouro() {
        List<Bovino> bovinos = new ArrayList<>();

        try {
            sql = "select id_bovino,nome_bovino from bovino where genero = true and status = true order by nome_bovino";


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            Bovino bovino;
            while (result.next()) {
                bovino = new Bovino();
                bovino.setIdBovino(result.getLong(1));
                bovino.setNomeBovino(result.getString(2));
                bovinos.add(bovino);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bovinos;

    }

//    public List<Bovino> listarFemea() {
//        List<Bovino> bovinos = new ArrayList<>();
//
//        try {
//            sql = "select id_bovino,nome_bovino from bovino where genero = false and status = true and ficha_matriz_idfichamatriz is null order by nome_bovino";
//
//
//            PreparedStatement ps;
//
//            ps = conexao.prepareStatement(sql);
//            ResultSet result = ps.executeQuery();
//            Bovino bovino;
//            while (result.next()) {
//                bovino = new Bovino();
//                bovino.setIdBovino(result.getLong(1));
//                bovino.setNomeBovino(result.getString(2));
//                bovinos.add(bovino);
//            }
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return bovinos;
//
//    }


    public void salvarQtdParto(Integer id) {
        Integer qtdParto = 0;
        try {

            sql = "select quant_parto from ficha_matriz where id_ficha_matriz = " + id;
            PreparedStatement prepareStatement;
            prepareStatement = conexao.prepareStatement(sql);
            ResultSet result = prepareStatement.executeQuery();


            result.next();

            qtdParto = result.getInt(1);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            if (qtdParto == 0) {
                sql = "update ficha_matriz set quant_parto = 1 where id_ficha_matriz = " + id;
            } else {
                sql = "update ficha_matriz set quant_parto = (quant_parto + 1) where id_ficha_matriz = " + id;
            }

            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public FichaTouro salvarTouro(FichaTouro touro) {


        try {

            sql = "insert into ficha_touro (id_ficha_touro, data_inclusao, id_bovino, status)\n" +
                    "\tvalues (default, '" + touro.getDataInclusao() + "', " + touro.getIdBovino() + "," + touro.getStatus() + ")";


            PreparedStatement ps;

            ps = conexao.prepareStatement(sql);


            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }


        return touro;
    }


}
