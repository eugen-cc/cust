package cc.eugen.ph.customer.model.converter;

import cc.eugen.ph.customer.model.Customer;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Customer.Status,String> {

    @Override
    public String convertToDatabaseColumn(Customer.Status status) {
        return status.getValue();
    }

    @Override
    public Customer.Status convertToEntityAttribute(String s) {
        return Customer.Status.fromValue(s);
    }
}
