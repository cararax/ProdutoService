package br.com.ufsm.produtoservice.model;

import br.com.ufsm.produtoservice.dto.ProdutoDTO;
import lombok.*;

import javax.persistence.*;
@Data

@Entity
@Table(name = "produtos")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nomeProduto")
    private String nomeProduto;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "quantidadeDisponivel")
    private Integer quantidadeDisponivel;

    public Produto(Produto produto) {
        this.id = produto.getId();
        this.nomeProduto = produto.getNomeProduto();
        this.valor = produto.getValor();
        this.quantidadeDisponivel = produto.getQuantidadeDisponivel();
    }

    public Produto(ProdutoDTO produto) {
        this.nomeProduto = produto.getNomeProduto();
        this.valor = produto.getValor();
        this.quantidadeDisponivel = produto.getQuantidadeDisponivel();
    }

    //Sem esse construtor dá erro na classe ProdutoserviceApplication
    public Produto(String nomeProduto, Double valor, Integer quantidadeDisponivel) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
