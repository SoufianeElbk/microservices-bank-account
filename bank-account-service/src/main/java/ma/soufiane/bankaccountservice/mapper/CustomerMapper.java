package ma.soufiane.bankaccountservice.mapper;

import ma.soufiane.bankaccountservice.dto.BankAccountRequest;
import ma.soufiane.bankaccountservice.dto.BankAccountResponse;
import ma.soufiane.bankaccountservice.dto.CustomerRequest;
import ma.soufiane.bankaccountservice.dto.CustomerResponse;
import ma.soufiane.bankaccountservice.entity.BankAccount;
import ma.soufiane.bankaccountservice.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public static Customer toEntity(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        return customer;
    }

    public static Customer toEntity(CustomerResponse customerResponse){
        Customer customer = new Customer();
        customer.setId(customerResponse.getId());
        customer.setName(customerResponse.getName());
        customer.setBankAccounts(customerResponse.getBankAccounts());
        return customer;
    }

    public static CustomerRequest toRequest(Customer customer){
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setName(customer.getName());
        return customerRequest;
    }

    public static CustomerResponse toResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setBankAccounts(customer.getBankAccounts());
        return customerResponse;
    }
}
