package delgadomiguel.gestao_estoque.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DomainException extends RuntimeException{

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Gestao Estoque internal server error");
        return pb;
    }

}
