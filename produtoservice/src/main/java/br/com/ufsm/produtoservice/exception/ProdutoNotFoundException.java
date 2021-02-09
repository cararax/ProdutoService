package br.com.ufsm.produtoservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProdutoNotFoundException extends RuntimeException {

    private String mensagem;

}
