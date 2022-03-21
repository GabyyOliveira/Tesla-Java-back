package cyberdyne.empresa3.controllers.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cyberdyne.empresa3.services.exceptions.DataIntegrityViolationException;
import cyberdyne.empresa3.services.exceptions.ObjectNotFoundException;

@ControllerAdvice //ESTA CLASSE IRA CONTROLAR OS ERROS QUE LANÇAREMOS
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	//      //RETORNO                      //NOME DO MÉTODO        //PASSA POR PARAMETRO A CLASSE DO SERVICE E O SERVLET
	private ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		//INSTACIA UM OBJETO
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	                                      //NOME DO MÉTODO
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

}
