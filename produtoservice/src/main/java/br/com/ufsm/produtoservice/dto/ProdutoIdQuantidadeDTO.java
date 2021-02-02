package br.com.ufsm.produtoservice.dto;

import br.com.ufsm.produtoservice.model.Produto;

public class ProdutoIdQuantidadeDTO {

    private Long id;
    private Double valorTotal;
    private Integer quantidade;
    private Boolean disponivel;

    public ProdutoIdQuantidadeDTO(Long id, Double valor, Integer quantidade) {
        this.id = id;
        this.valorTotal = valor;
        this.quantidade = quantidade;
    }

    public ProdutoIdQuantidadeDTO(Produto produto) {
        this.id = produto.getId();
        this.valorTotal = produto.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
