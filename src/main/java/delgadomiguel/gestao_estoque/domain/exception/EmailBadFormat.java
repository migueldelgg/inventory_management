package delgadomiguel.gestao_estoque.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class EmailBadFormat extends DomainException{

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Email invalid.");
        pb.setDetail("Email in bad format. Try another email.");

        return pb;
    }

}
