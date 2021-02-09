package br.com.ufsm.produtoservice.dto;

import br.com.ufsm.produtoservice.model.Produto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ProdutoDTO {

    @NotEmpty(message = "Insira um nome para o produto.")
    private String nomeProduto;

    @NotNull(message = "Insira o valor do produto.")
    @Positive(message = "O valor do produto deve ser positivo.")
    private Double valor;

    @NotNull(message = "Insira a quantidade disponível do produto.")
    @PositiveOrZero(message = "A quantidade do produto deve ser zero ou valor positivo.")
    private Integer quantidadeDisponivel;

    public ProdutoDTO(Produto produto) {
        this.nomeProduto = produto.getNomeProduto();
        this.valor = produto.getValor();
        this.quantidadeDisponivel = produto.getQuantidadeDisponivel();
    }

}
