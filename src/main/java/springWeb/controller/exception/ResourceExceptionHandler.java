package springWeb.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springWeb.service.exception.ResourceNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice//intercepta as exceptions que acontecerem, para o obj excultar um possivel tratamento
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)//meu metodo vai intercepta qualquer exception do tipo que foi lancada e ira fazer o tratamento
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
