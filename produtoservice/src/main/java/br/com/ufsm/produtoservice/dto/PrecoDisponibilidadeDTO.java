package br.com.ufsm.produtoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrecoDisponibilidadeDTO {

    private Double preco;
    private Boolean disponibilidade;

}
