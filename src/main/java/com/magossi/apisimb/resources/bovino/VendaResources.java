package com.magossi.apisimb.resources.bovino;

import com.magossi.apisimb.domain.bovino.Venda;
import com.magossi.apisimb.service.bovino.VendaService;
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
@RequestMapping("/venda")
public class VendaResources {
    @Autowired
    VendaService vendaService;

    @RequestMapping(value = "/listar/vendidos/{busca}/{tipoBusca}", method = RequestMethod.GET)
    public ResponseEntity<List<Venda>> listar(@PathVariable("busca")String busca, @PathVariable("tipoBusca")String tipoBusca){
        List<Venda> vendas = null;

        if("todos".equals(busca)){
            vendas = vendaService.buscarTodos();
        }else if ("nomeBovino".equals(tipoBusca)) {
            vendas = vendaService.buscarPorBovino("%"+busca);
        }else if ("dataVenda".equals(tipoBusca)) {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {

                Date data1 = formato.parse(busca);
                Date data2 = formato.parse(busca);
                data2.setHours(23);
                data2.setMinutes(59);
                data2.setSeconds(59);


                vendas = vendaService.buscarPorData(data1, data2);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }



        return ResponseEntity.status(HttpStatus.OK).body(vendas);
    }

}
