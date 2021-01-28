package br.com.ufsm.produtoservice.repository;

import br.com.ufsm.produtoservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
