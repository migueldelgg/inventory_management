package delgadomiguel.gestao_estoque.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ProductValidationException extends DomainException {
    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Expired product.");
        pb.setDetail("It is not possible to register expired products. Do you want to cause food poisoning?");

        return pb;
    }}
