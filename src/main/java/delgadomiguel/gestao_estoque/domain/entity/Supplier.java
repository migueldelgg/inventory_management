package delgadomiguel.gestao_estoque.domain.entity;

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

}
