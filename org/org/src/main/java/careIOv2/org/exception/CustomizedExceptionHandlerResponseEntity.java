package careIOv2.org.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandlerResponseEntity extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails>
	handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails error=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails>
	handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ErrorDetails error=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
			
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
		}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails error=new ErrorDetails(LocalDateTime.now(),"Total Error: "+ex.getErrorCount()+", First Error:"+ex.getFieldError().getDefaultMessage(),request.getDescription(false));
		
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
			}

}
