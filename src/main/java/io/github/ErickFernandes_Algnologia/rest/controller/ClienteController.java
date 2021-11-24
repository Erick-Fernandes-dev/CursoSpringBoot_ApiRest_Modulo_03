package io.github.ErickFernandes_Algnologia.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.github.ErickFernandes_Algnologia.domain.entity.Cliente;
import io.github.ErickFernandes_Algnologia.domain.repository.Clientes;
import org.springframework.web.server.ResponseStatusException;

@RestController// Serve para n ter que usar o ResponseBody nos Metodos
@RequestMapping("/api/clientes")
//@RequestMapping("/api/clientes")
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
    @GetMapping("{id}")
    //@ResponseBody // Vai transformar esse retorno em um objeto do tipo Json
    public Cliente ClientegetClienteById(@PathVariable Integer id) {

        return this.clientes
                        .findById(id)
                        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente nao encontrado") );

    }

    @PostMapping//serve para quando for salvar um recurso no servidor, ou seja, enviar informações que não existem lá no servidor, utiliza-se o Post.
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente) {

        return this.clientes.save(cliente);

    };

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        clientes.
                findById(id)
                .map( cliente -> {

                    clientes.delete(cliente);
                    return cliente;

                }).orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"
        ));

    }

    @PutMapping("{id}")// o put ele é usado para atualizar integralmente
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
        @PathVariable Integer id, 
        @RequestBody Cliente  cliente) {

        clientes
        .findById(id)
        .map( clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            clientes.save(cliente);
            return clienteExistente;
        }).orElseThrow( () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"
        ));

    }


    @GetMapping
    public List<Cliente> find(Cliente filtro) {

        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                            ExampleMatcher.StringMatcher.CONTAINING
                                    );

        Example example = Example.of(filtro, matcher);

        return this.clientes.findAll(example);
    }

    /*
     * @RequestMapping --> Anotação para mapear solicitações da web em métodos em classes 
     * de tratamento de solicitações com assinaturas de método flexíveis.
     * 
     * responseEntity --> e um objeto que ele representa o corpo da resposta
     * 
     * @RequestBody --> é quando a gente recebe uma requisição, ou seja, o que vai receber
     * 
     * @ResonseBody --> é quando a gente retorna uma resposta, ou seja, o que vai retornar
     * 
     * noContent --> é quando vai retornar nada no corpo da requisição
     * 
     * ResponseEntity --> Significa representar toda a resposta HTTP
     * 
     * @PathVariable --> a anotação pode ser usada para manipular variáveis ​​de modelo no 
     * mapeamento de URI de solicitação e defini-las como parâmetros de método.
     *
     */

}