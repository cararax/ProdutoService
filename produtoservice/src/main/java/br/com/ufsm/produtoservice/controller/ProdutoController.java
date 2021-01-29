package br.com.ufsm.produtoservice.controller;

import br.com.ufsm.produtoservice.ProdutoserviceApplication;
import br.com.ufsm.produtoservice.dto.PrecoDisponibilidadeDTO;
import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    private static final Logger LOGGER= LoggerFactory.getLogger(ProdutoserviceApplication.class);

    @GetMapping
    public List<ProdutoDTO> listarTodos() {
        LOGGER.info("Request get listarTodos");
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) {
        LOGGER.info("Request get detalhar");
        return service.detalhar(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        LOGGER.info("Request post cadastrar");
        return service.cadastrar(produtoDTO, uriBuilder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        LOGGER.info("Request put atualizar");
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id) {
        LOGGER.info("Request delete remover");

        return service.remover(id);
    }

    @GetMapping("/{id}/{quantidade}")
    ResponseEntity<PrecoDisponibilidadeDTO> precoDisponibilidade(@PathVariable Long id, @PathVariable int quantidade){
        LOGGER.info("Request get preçoDisponibilidade");

        return service.precoDisponibilidade(id, quantidade);
    }


}