package br.com.ufsm.produtoservice.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;
import java.util.Locale;

@RestControllerAdvice
public class ProdutoExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> erroValidacaoHandler(MethodArgumentNotValidException exception) {
        return new ResponseEntity<String>("Entrada inválida", HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> erroTipoValidacaoHandler(MethodArgumentTypeMismatchException exception) {
        return new ResponseEntity<String>("Entrada inválida.", HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<String> requestSemCorpoHandler(HttpMessageNotReadableException httpMessageNotReadableException) {
        return new ResponseEntity<String>("Impossível realizar operação sem os dados do produto.", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<String> handleCustomException() throws IOException {
        return new ResponseEntity<String>("Produto não encontrado.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException() throws IOException {
        return new ResponseEntity<String>("Alguma coisa deu errado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
