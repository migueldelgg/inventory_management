package delgadomiguel.gestao_estoque.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DuplicateKeyException extends DomainException  {

    private final String fieldName;
    private final String fieldValue;

    public DuplicateKeyException(String fieldName, String fieldValue) {
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
    }

    @Override
    public ProblemDetail toProblemDetail() {
      var pb = ProblemDetail.forStatus(HttpStatus.CONFLICT);
      pb.setTitle("Duplicate value");
      pb.setDetail("Field '" + fieldName + "' with value '" + fieldValue + "' already exists.");
      return pb;
    }
}
