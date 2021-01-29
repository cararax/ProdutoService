package br.com.ufsm.produtoservice.exception;

public class ProdutoNotFoundException extends RuntimeException {
    private String mensagem;

    public ProdutoNotFoundException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
