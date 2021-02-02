package br.com.ufsm.produtoservice.exception;

public class ProdutoIndisponivelException extends RuntimeException{
    private String mensagem;

    public ProdutoIndisponivelException(String mensagem) {
        this.mensagem = mensagem;
    }

    public ProdutoIndisponivelException() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
