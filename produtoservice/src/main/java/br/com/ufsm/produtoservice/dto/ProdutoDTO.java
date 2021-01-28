package br.com.ufsm.produtoservice.dto;

import br.com.ufsm.produtoservice.model.Produto;

import javax.persistence.Column;

public class ProdutoDTO {

    private String nomeProduto;
    private Double valor;
    private Integer quantidadeDisponivel;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeProduto, Double valor, Integer quantidadeDisponivel) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public ProdutoDTO(Produto produto) {
        this.nomeProduto = produto.getNomeProduto();
        this.valor = produto.getValor();
        this.quantidadeDisponivel = produto.getQuantidadeDisponivel();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
