package br.com.ufsm.produtoservice.dto;

import br.com.ufsm.produtoservice.model.Produto;
import lombok.Data;

@Data
public class ProdutoIdQuantidadeDTO {

    private Long id;
    private Double valorTotal;
    private Integer quantidade;
    private Boolean disponivel;

    public ProdutoIdQuantidadeDTO(Produto produto) {
        this.id = produto.getId();
        this.valorTotal = produto.getValor();
    }

}
