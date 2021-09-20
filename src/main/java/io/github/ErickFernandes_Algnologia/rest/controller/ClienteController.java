package io.github.ErickFernandes_Algnologia.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.ErickFernandes_Algnologia.domain.entity.Cliente;

@Controller
//@RequestMapping("/api/clientes")
public class ClienteController {

    @RequestMapping(
        value = {"/api/clientes/hello/{nome}", "/api/hello"},
        method = RequestMethod.GET,
        consumes = { "application/json", "application/xml "},
        produces = { "application/json", "application/xml"}
        )
    @ResponseBody
    public String helloCliente(
        @PathVariable("nome") String nomeCliente,
        @RequestBody Cliente Cliente
        ) {
        return String.format("Hello %s ", nomeCliente);
    }

    /*
    * @RequestMapping --:>
    *
    *
    * */

}
