package br.com.ufsm.produtoservice.model;

import br.com.ufsm.produtoservice.dto.ProdutoDTO;

import javax.persistence.*;

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

    public Produto() {
    }

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

    public Produto(String nomeProduto, Double valor, Integer quantidadeDisponivel) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Produto(Long id, String nomeProduto, Double valor, Integer quantidadeDisponivel) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
