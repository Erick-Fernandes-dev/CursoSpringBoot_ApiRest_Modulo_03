package io.github.ErickFernandes_Algnologia.rest.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.ErickFernandes_Algnologia.domain.entity.Cliente;
import io.github.ErickFernandes_Algnologia.domain.repository.Clientes;

@Controller
// @RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    /*
     * @RequestMapping( value = {"/api/clientes/hello/{nome}", "/api/hello"}, method
     * = RequestMethod.GET, consumes = { "application/json", "application/xml "},
     * produces = { "application/json", "application/xml"} )
     */
    @GetMapping("/api/clientes/{id}")
    @ResponseBody // Vai transformar esse retorno em um objeto do tipo Json
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {

        Optional<Cliente> cliente = clientes.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());//200
        }

        return ResponseEntity.notFound().build();//retorna o erro 404
    }

    /*
     * @RequestMapping --:> 
     * responseEntity --> e um objeto que ele representa o corpo da resposta
     *
     */

}
