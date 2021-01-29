package br.com.ufsm.produtoservice.service;

import br.com.ufsm.produtoservice.dto.PrecoDisponibilidadeDTO;
import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.exception.ProdutoNotFoundException;
import br.com.ufsm.produtoservice.model.Produto;
import br.com.ufsm.produtoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseEntity<ProdutoDTO> detalhar(Long id) {
        ProdutoDTO produtoDTO = new ProdutoDTO(procuraProduto(id));
        return ResponseEntity.ok(produtoDTO);
    }

    @Transactional
    public ResponseEntity<ProdutoDTO> cadastrar(ProdutoDTO produto, UriComponentsBuilder uriBuilder) {
        Produto novoProduto = new Produto(produto);
        Produto produtoSalvo = repository.saveAndFlush(novoProduto);
        URI uri = uriBuilder.path("/api/produtos/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDTO(produtoSalvo));

    }

    @Transactional
    public ResponseEntity<Object> atualizar(Long id, ProdutoDTO novoProduto) {
        Produto produto = new Produto(procuraProduto(id));
        return ResponseEntity.noContent().build();

    }

    @Transactional
    public ResponseEntity<Object> remover(Long id) {
        Produto produto = procuraProduto(id);
        repository.delete(produto);
        return ResponseEntity.ok().build();
    }

    private Produto procuraProduto(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));
    }

    public ResponseEntity<PrecoDisponibilidadeDTO> precoDisponibilidade(Long id, int quantidade) {
        Produto produto = procuraProduto(id);
        PrecoDisponibilidadeDTO precoDisponibilidade = new PrecoDisponibilidadeDTO(produto.getValor() * quantidade, produto.getQuantidadeDisponivel() >= quantidade);
        return ResponseEntity.ok(precoDisponibilidade);
    }
}
