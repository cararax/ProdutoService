package br.com.ufsm.produtoservice.dto;

public class PrecoDisponibilidadeDTO {

    private Double preco;
    private Boolean disponibilidade;

    public PrecoDisponibilidadeDTO(Double preco, Boolean disponibilidade) {
        this.preco = preco;
        this.disponibilidade = disponibilidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
