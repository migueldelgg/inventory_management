package delgadomiguel.gestao_estoque.domain.model;

import delgadomiguel.gestao_estoque.domain.model.complement.Cnpj;
import delgadomiguel.gestao_estoque.domain.model.complement.Email;

public class Supplier {

    private String companyName;
    private Cnpj cnpj;
    private String address;
    private String phone;
    private Email email;
    private String mainContact;

    public Supplier(String address, String cnpj,
                    String companyName, String email,
                    String mainContact, String phone) {
        this.address = address;
        this.cnpj = new Cnpj(cnpj);
        this.companyName = companyName;
        this.email = new Email(email);
        this.mainContact = mainContact;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCnpj() {
        return cnpj.getValue();
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getMainContact() {
        return mainContact;
    }

    public String getPhone() {
        return phone;
    }
}
