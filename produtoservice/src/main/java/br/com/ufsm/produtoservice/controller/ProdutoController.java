package br.com.ufsm.produtoservice.controller;

import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ProdutoDTO cadastrar(@RequestBody ProdutoDTO dto) {
        return service.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}