package delgadomiguel.gestao_estoque.domain.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductValidationException.class)
    public ResponseEntity<ProblemDetail> handleProductValidationException(ProductValidationException ex) {
        ProblemDetail problem = ex.toProblemDetail();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpectedExceptions(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unexpected error: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgumentException(IllegalArgumentException ex) {
        if (ex.getMessage() != null && ex.getMessage().startsWith("Invalid UUID string")) {
            var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
            problem.setTitle("Invalid UUID format");
            problem.setDetail("Expected UUID format is xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
            return problem;
        }

        var problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problem.setTitle("Unexpected error");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetail> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Throwable root = ex.getRootCause();

        if (root != null && root.getMessage() != null && root.getMessage().contains("duplicate key")) {
            // Pega o campo e valor do erro (de forma simplificada)
            String detail = root.getMessage(); // Exemplo: "Key (bar_code)=(7891234567890) already exists."
            String fieldName = "unknown";
            String fieldValue = "unknown";

            var matcher = java.util.regex.Pattern
                    .compile("Key \\((.*?)\\)=\\((.*?)\\)")
                    .matcher(detail);
            if (matcher.find()) {
                fieldName = matcher.group(1);
                fieldValue = matcher.group(2);
            }

            var duplicateEx = new DuplicateKeyException(fieldName, fieldValue);
            var problem = duplicateEx.toProblemDetail();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
        }

        // Se não for erro de chave duplicada, trata como erro genérico
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected DB error"));
    }
}
