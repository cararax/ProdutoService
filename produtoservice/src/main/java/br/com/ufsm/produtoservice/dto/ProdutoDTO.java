package br.com.ufsm.produtoservice.dto;

import br.com.ufsm.produtoservice.model.Produto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class ProdutoDTO {

    @NotEmpty(message = "Insira um nome para o produto.")
    private String nomeProduto;

    @NotNull(message = "Insira o valor do produto.")
    @Positive(message = "O valor do produto deve ser positivo.")
    private Double valor;

    @NotNull(message = "Insira a quantidade disponível do produto.")
    @PositiveOrZero(message = "A quantidade do produto deve ser zero ou valor positivo.")
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
