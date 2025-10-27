package todo_list.api.controllers.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import todo_list.domain.enums.ProblemDetailCustomPropertiesEnum;
import todo_list.domain.enums.ProblemDetailTypeEnum;
import todo_list.domain.exceptions.NotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Erro de validação");
        problemDetail.setDetail("Um ou mais campos inválidos.");
        problemDetail.setType(ProblemDetailTypeEnum.VALIDATION.getUri());


        Map<String, List<String>> errors = exception.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));

        problemDetail.setProperty(ProblemDetailCustomPropertiesEnum.ERRORS.getProperty(), errors);

        return problemDetail;
    }

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setType(exception.getProblemDetailType().getUri());

        return problemDetail;
    }

}
