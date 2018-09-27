package com.magossi.apisimb.repository.bovino;

import com.magossi.apisimb.domain.bovino.*;
import com.magossi.apisimb.domain.matriz.FichaMatriz;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 15/05/2016.
 */
public interface BovinoRepository extends JpaRepository<Bovino, Long>{

        Bovino findByTag(String tag);


        default List<Bovino> findAllOrOrderByNomeBovino() {

                return null;
        }


        //Bovino findByNomeBovino(String nome);
        @Query("select b from Bovino b where upper(b.nomeBovino) like upper(?1)")
        List<Bovino> buscaComLike(String bovino);

        @Query("select b from Bovino b where b.raca = ?1 and b.status = true")
        List<Bovino> buscaPorRaca(Raca raca);

        @Query("select b from Bovino b where b.fazenda = ?1 and b.status=true")
        List<Bovino> buscarPorFazenda(Fazenda fazenda);

        @Query("select b from Bovino b where  (b.dataNascimento) = ?1 ")
        List<Bovino> buscarPorData(Date data);

        @Query("select b from Bovino b where upper(b.nomeBovino) like upper(?1) and b.fichaMatriz is not null")
        List<Bovino> buscarPorMatriz(String idMatriz);

        @Query("select b from Bovino b where b.status=true and b.fichaMatriz is not null order by b.fichaMatriz")
        List<Bovino> buscarMatrizInseminada();


        @Query("select b from Bovino b where b.fichaMatriz =?1 ")
        Bovino buscarPorIdMatriz(FichaMatriz fichaMatriz);

        @Query("select b from Bovino b where b.fichaMatriz is null and b.genero = false and b.status=true order by b.nomeBovino")
        List<Bovino> buscarPorFemea();

        @Query("select b from Bovino b where b.status=true order by b.nomeBovino")
        List<Bovino> buscarOrdenadoNome();

        @Query("select b from Bovino b where b.status=true and b.fichaMatriz is null order by b.nomeBovino")
        List<Bovino> buscarBezerro();

        @Query("select b from Bovino b where upper(b.nomeBovino) like upper(?1) and b.fichaMatriz is not null")
        List<Bovino> buscarPorId(String idMatriz);

        List<Bovino> findByPai(String pai);

        List<Bovino> findByMaeContaining(String mae);
        List<Bovino> findByRaca(Raca raca);
        List<Bovino> findByPelagem(Pelagem pelagem);
        List<Bovino> findByFazenda(Fazenda fazenda);
        List<Bovino> findByProprietario(Proprietario proprietario);
        List<Bovino> findByDataNascimento(Date data);
        Bovino findByPeso(Peso peso);
        Bovino findByEcc(Ecc ecc);
        List<Bovino> findByStatusOrderByNomeBovino(Boolean status);





}