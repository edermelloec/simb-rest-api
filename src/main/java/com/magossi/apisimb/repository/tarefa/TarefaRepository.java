package com.magossi.apisimb.repository.tarefa;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.tarefa.Tarefa;
import com.magossi.apisimb.domain.tarefa.TipoTarefaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by RafaelMq on 16/11/2016.
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByImei(String tag);
    List<Tarefa> findByImeiContainingAndStatusDaTarefa(String tag,Boolean statusDaTarefa);
    List<Tarefa> findByStatusDaTarefaAndStatus(Boolean statusDaTarefa, Boolean status);
    List<Tarefa> findByStatusDaTarefaAndStatusOrderByDataInclusaoAsc(Boolean statusDaTarefa, Boolean status);
    List<Tarefa> findByDataInclusaoContainingAndStatusDaTarefaAndStatusOrderByDataInclusaoAsc(Date dataInclusao, Boolean statusDaTarefa, Boolean status);
    List<Tarefa> findByBovinoMatriz(Bovino bovinoMatriz);

    @Query("select t from Tarefa t where t.bovinoMatriz = ?1  and t.status = true and t.statusDaTarefa = ?2")
    List<Tarefa> buscarPorBovino(Bovino bovino,Boolean t);

    @Query("select t from Tarefa t where t.tipoTarefa = ?1  and t.status = true and t.statusDaTarefa = ?2")
    List<Tarefa> buscarPorTipoTarefa(TipoTarefaEnum tarefaEnum,Boolean t);

    @Query("select t from Tarefa t where t.dataInclusao between ?1 and ?2  and t.status = true and t.statusDaTarefa = ?3")
    List<Tarefa> buscarPorData(Date data1, Date data2,Boolean t);

}
