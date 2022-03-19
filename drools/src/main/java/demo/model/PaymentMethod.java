package demo.model;

import lombok.Data;

@Data
public class PaymentMethod {
    private String name;
    private Boolean disabled;

    public PaymentMethod(String name, Boolean disabled) {
        this.name = name;
        this.disabled = disabled;
    }
}
