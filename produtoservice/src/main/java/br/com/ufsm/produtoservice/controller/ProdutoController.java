package br.com.ufsm.produtoservice.controller;

import br.com.ufsm.produtoservice.dto.PrecoDisponibilidadeDTO;
import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.dto.ProdutoIdQuantidadeDTO;
import br.com.ufsm.produtoservice.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> listarTodos() {
        log.info("Request get listarTodos");
        return service.listarTodos();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) {
        log.info("Request get detalhar");
        return service.detalhar(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        log.info("Request post cadastrar");
        return service.cadastrar(produtoDTO, uriBuilder);
    }

    @PutMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        log.info("Request put atualizar");
        return service.atualizar(id, dto);
    }

    @DeleteMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> remover(@PathVariable Long id) {
        log.info("Request delete remover");

        return service.remover(id);
    }

    @GetMapping(path = "/{id}/{quantidade}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PrecoDisponibilidadeDTO> precoDisponibilidade(@PathVariable Long id, @PathVariable int quantidade){
        log.info("Request get preçoDisponibilidade");
        return service.precoDisponibilidade(id, quantidade);
    }

    @PostMapping(path="/verificaDisponibilidade", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProdutoIdQuantidadeDTO>> verificaPrecoTotalDisponibilidade(@RequestBody List<ProdutoIdQuantidadeDTO> listaProdutos){
        log.info("Request post verificaPrecoTotalDisponibilidade");
        return ResponseEntity.ok(service.verificaPrecoTotalDisponibilidade(listaProdutos));
    }

}