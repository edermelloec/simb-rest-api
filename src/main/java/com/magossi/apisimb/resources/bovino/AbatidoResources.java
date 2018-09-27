package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Abatido;
import com.magossi.apisimb.service.bovino.AbatidoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/abatido")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class AbatidoResources {
    @Autowired
    AbatidoService abatidoService;

    @RequestMapping(value = "/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Abatido>> listar(@PathVariable("busca")String busca, @PathVariable("tipoBusca")String tipoBusca){
        List<Abatido> abatidos = null;

        if("todos".equals(busca)){
            abatidos = abatidoService.buscarTodos();
        }else if ("nomeBovino".equals(tipoBusca)) {
            abatidos = abatidoService.buscarPorBovino("%"+busca);
        }else if ("dataAbate".equals(tipoBusca)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                abatidos = abatidoService.buscarPorData(data1, data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }



        return ResponseEntity.status(HttpStatus.OK).body(abatidos);
    }

}
