package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Bovino;
import com.magossi.apisimb.domain.bovino.Desmama;
import com.magossi.apisimb.service.bovino.DesmamaService;
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
@RequestMapping("/desmama")
public class DesmamaResources {
    @Autowired
    DesmamaService desmamaService;

    @RequestMapping(value = "/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Desmama>> listar(@PathVariable("busca")String busca, @PathVariable("tipoBusca")String tipoBusca){

        List<Desmama> desmamas = null;

        if("todos".equals(busca)){
            desmamas = desmamaService.buscarTodos();
        }else if ("nomeBovino".equals(tipoBusca)){
            desmamas = desmamaService.buscarPorBovino("%"+busca+"%");
        }else if ("nomeMatriz".equals(tipoBusca)){
           // desmamas = desmamaService.buscarPorMatriz("%"+busca+"%");
        }else if ("dataDesmama".equals(tipoBusca)){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);



                desmamas = desmamaService.buscarPorData(data1, data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }



        return ResponseEntity.status(HttpStatus.OK).body(desmamas);
    }
}
