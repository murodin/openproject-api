package tug.it.openprojectapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApiAdvice {

    @ResponseBody
    @ExceptionHandler(ProjectNotFoundException.class)
    public final ResponseEntity<ApiError> projectNotFoundExceptionResponseEntity(ProjectNotFoundException e) {
        ApiError response = ApiError.builder().message(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
