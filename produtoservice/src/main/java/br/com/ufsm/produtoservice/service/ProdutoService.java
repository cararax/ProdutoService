package br.com.ufsm.produtoservice.service;

import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.exception.ProdutoNotFoundException;
import br.com.ufsm.produtoservice.model.Produto;
import br.com.ufsm.produtoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(produto -> new ProdutoDTO(produto.getNomeProduto(), produto.getValor(), produto.getQuantidadeDisponivel()))
                .collect(Collectors.toList());
    }

    public ProdutoDTO detalhar(Long id) {
        return new ProdutoDTO(procuraProduto(id));
/*        return repository.findAll().stream()
                .map(produto -> new ProdutoDTO(produto.getNomeProduto(), produto.getValor(), produto.getQuantidadeDisponivel()))
                .collect(Collectors.toList());*/
    }

    @Transactional
    public ProdutoDTO cadastrar(ProdutoDTO produto) {
        Produto novoProduto = new Produto(produto);
        Produto produtoSalvo = repository.saveAndFlush(novoProduto);
        return new ProdutoDTO(produtoSalvo);
    }

    @Transactional
    public ProdutoDTO atualizar(Long id, ProdutoDTO novoProduto) {
        Produto produto = new Produto(procuraProduto(id));
        /*produto.setNomeProduto(novoProduto.getNomeProduto());
        produto.setValor(novoProduto.getValor());
        produto.setQuantidadeDisponivel(novoProduto.getQuantidadeDisponivel());*/
        return new ProdutoDTO(produto);
    }

    @Transactional
    public void remover(Long id) {
        Produto produto = procuraProduto(id);
        repository.delete(produto);
    }

    private Produto procuraProduto(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));
    }

}
