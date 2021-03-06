package br.com.ufsm.produtoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

@RestControllerAdvice
public class ProdutoExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> erroValidacaoHandler(MethodArgumentNotValidException exception) {
        return new ResponseEntity<String>("Entrada inválida", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> erroTipoValidacaoHandler(MethodArgumentTypeMismatchException exception) {
        return new ResponseEntity<String>("Entrada inválida.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<String> requestSemCorpoHandler(HttpMessageNotReadableException httpMessageNotReadableException) {
        return new ResponseEntity<String>("Impossível realizar operação sem os dados do produto.", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ProdutoIndisponivelException.class)
    public ResponseEntity<String> produtoIndisponivelHandler(ProdutoIndisponivelException exception) throws IOException {
        return new ResponseEntity<String>(exception.getMensagem(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<String> produtoNotFoundhandler() throws IOException {
        return new ResponseEntity<String>("Produto não encontrado.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException() throws IOException {
        return new ResponseEntity<String>("Alguma coisa deu errado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
