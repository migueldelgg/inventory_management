package delgadomiguel.gestao_estoque.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CnpjBadFormatException extends DomainException{

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Cnpj invalid.");
        pb.setDetail("Cnpj in bad format. Try another Cnpj.");

        return pb;
    }

}
