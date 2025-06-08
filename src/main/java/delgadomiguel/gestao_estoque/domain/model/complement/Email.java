package delgadomiguel.gestao_estoque.domain.model.complement;

import delgadomiguel.gestao_estoque.domain.exception.EmailBadFormat;
import org.apache.commons.validator.routines.EmailValidator;

public class Email {

    private final String email;

    public Email(String email) {
        isValid(email);
        this.email = email;
    }

    public void isValid(String email) {
        boolean valid = EmailValidator.getInstance().isValid(email);
        if(!valid) {
            throw new EmailBadFormat();
        }
    }

    public String get() {
        return email;
    }
}
