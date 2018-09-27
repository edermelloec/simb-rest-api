package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Morto;
import com.magossi.apisimb.service.bovino.MortoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SuppressWarnings("ALL")
@RestController
@RequestMapping("/morto")
public class MortoResources {

    @Autowired
    MortoService mortoService;

    @RequestMapping(value = "/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Morto>> listar(@PathVariable("busca")String busca, @PathVariable("tipoBusca")String tipoBusca){

        List<Morto> mortos =null;

        if("todos".equals(busca)){
            mortos = mortoService.buscarTodos();
        }else if ("nomeBovino".equals(tipoBusca)){
            mortos = mortoService.buscarPorBovino("%"+busca+"%");
        }else if ("dataMorte".equals(tipoBusca)){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                mortos = mortoService.buscarPorDataMorte(data1,data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("causa".equals(tipoBusca)){
            mortos = mortoService.buscarPorCausa("%"+busca+"%");
        }

        return ResponseEntity.status(HttpStatus.OK).body(mortos);
    }
}
