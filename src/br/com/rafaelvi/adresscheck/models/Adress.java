package br.com.rafaelvi.adresscheck.models;

public class Adress {
    private String cep;
    private String street;
    private String neighborhood;
    private String city;
    private String state;

    public Adress(CEP cep) {
        this.cep = cep.cep();
        this.street = cep.logradouro();
        this.neighborhood = cep.bairro();
        this.city = cep.localidade();
        this.state = cep.uf();
    }

    @Override
    public String toString() {
        return "Adress{" +
                "cep='" + cep + '\'' +
                "street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
