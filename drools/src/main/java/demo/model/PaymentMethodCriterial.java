package demo.model;

import lombok.Data;

@Data
public class PaymentMethodCriterial {
    private String country;
    private String currency;
    private String name;
    private String[] allowedAsserts;
    private Boolean exp;

    public PaymentMethodCriterial(String country, String currency, String name, String allowedAsserts[], Boolean exp) {
        this.country = country;
        this.currency = currency;
        this.name = name;
        this.allowedAsserts = allowedAsserts;
        this.exp = exp;
    }
}
