package br.com.ufsm.produtoservice.controller;

import br.com.ufsm.produtoservice.dto.PrecoDisponibilidadeDTO;
import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.service.ProdutoService;
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

    @GetMapping
    public List<ProdutoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> detalhar(@PathVariable Long id) {
        return service.detalhar(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrar(@Valid @RequestBody ProdutoDTO produtoDTO, UriComponentsBuilder uriBuilder) {
        return service.cadastrar(produtoDTO, uriBuilder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        return service.remover(id);
    }

    @GetMapping("/{id}/{quantidade}")
    ResponseEntity<PrecoDisponibilidadeDTO> precoDisponibilidade(@PathVariable Long id, @PathVariable int quantidade){
        return service.precoDisponibilidade(id, quantidade);
    }


}