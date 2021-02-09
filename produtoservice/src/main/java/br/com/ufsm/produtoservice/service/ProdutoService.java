package br.com.ufsm.produtoservice.service;

import br.com.ufsm.produtoservice.ProdutoserviceApplication;
import br.com.ufsm.produtoservice.dto.PrecoDisponibilidadeDTO;
import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import br.com.ufsm.produtoservice.dto.ProdutoIdQuantidadeDTO;
import br.com.ufsm.produtoservice.exception.ProdutoIndisponivelException;
import br.com.ufsm.produtoservice.exception.ProdutoNotFoundException;
import br.com.ufsm.produtoservice.model.Produto;
import br.com.ufsm.produtoservice.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.status;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    private static final Logger LOGGER= LoggerFactory.getLogger(ProdutoService.class);

    public List<ProdutoDTO> listarTodos() {
        LOGGER.info("Response get listar Todos");
        return repository.findAll().stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());

    }

    public ResponseEntity<ProdutoDTO> detalhar(Long id) {
        ProdutoDTO produtoDTO = new ProdutoDTO(procuraProduto(id));
        LOGGER.info("Response get detalhar");

        return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ProdutoDTO> cadastrar(ProdutoDTO produto, UriComponentsBuilder uriBuilder) {
        Produto novoProduto = new Produto(produto);
        Produto produtoSalvo = repository.saveAndFlush(novoProduto);
        LOGGER.info("cadastrar: produto cadastrado");
        URI uri = uriBuilder.path("/api/produtos/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
        LOGGER.info("Response produto cadastrado");
        return ResponseEntity.created(uri).body(new ProdutoDTO(produtoSalvo));
    }

    @Transactional
    public ResponseEntity<String> atualizar(Long id, ProdutoDTO novoProduto) {
        Produto produto = new Produto(procuraProduto(id));
        LOGGER.info("Response put atualizar");
        return new ResponseEntity<String>("Produto atualizado com sucesso", HttpStatus.ACCEPTED);

    }

    @Transactional
    public ResponseEntity<String> remover(Long id) {
        repository.delete(procuraProduto(id));
        LOGGER.info("Response delete remover");
        return new ResponseEntity<String>("Produto removido com sucesso", HttpStatus.ACCEPTED);
    }

    private Produto procuraProduto(Long id) {
        Produto produtoEncontrado = repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado"));
        LOGGER.info("Produto foi encontrado");
        return produtoEncontrado;
    }

    public ResponseEntity<PrecoDisponibilidadeDTO> precoDisponibilidade(Long id, int quantidade) {
        Produto produto = procuraProduto(id);
        PrecoDisponibilidadeDTO precoDisponibilidade = new PrecoDisponibilidadeDTO(produto.getValor() * quantidade, produto.getQuantidadeDisponivel() >= quantidade);
        LOGGER.info("Response get preçoDisponibilidade");
        return ResponseEntity.ok(precoDisponibilidade);
    }

    public List<ProdutoIdQuantidadeDTO> verificaPrecoTotalDisponibilidade(List<ProdutoIdQuantidadeDTO> listaProdutos) {

        for(ProdutoIdQuantidadeDTO verificavel : listaProdutos){
            Produto produto = procuraProduto(verificavel.getId());
            PrecoDisponibilidadeDTO precoDisponibilidade = new PrecoDisponibilidadeDTO(produto.getValor() * verificavel.getQuantidade(), produto.getQuantidadeDisponivel() >= verificavel.getQuantidade());

            verificavel.setValorTotal(precoDisponibilidade.getPreco());
            verificavel.setDisponivel(precoDisponibilidade.getDisponibilidade());
            if(!verificavel.getDisponivel()){
                throw new ProdutoIndisponivelException("Produto de id "+verificavel.getId()+ " está indisponível para a quantiadade informada e a operação foi encerrada.");
            }
        }
        LOGGER.info("Response post verificaPrecoTotalDisponibilidade");

        return listaProdutos;

    }

}
