package ma.soufiane.bankaccountservice.controller;

import lombok.AllArgsConstructor;
import ma.soufiane.bankaccountservice.dto.CustomerRequest;
import ma.soufiane.bankaccountservice.dto.CustomerResponse;
import ma.soufiane.bankaccountservice.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {
    private final CustomerService customerService;

    @QueryMapping
    public List<CustomerResponse> customerList() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public CustomerResponse customerById(@Argument Long id) {
        return customerService.getCustomerById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @MutationMapping
    public CustomerResponse createCustomer(@Argument CustomerRequest customer) {
        return customerService.saveCustomer(customer);
    }

    @MutationMapping
    public CustomerResponse updateCustomer(@Argument Long id,@Argument CustomerRequest customer) {
        return customerService.updateCustomer(id, customer);
    }

    @MutationMapping
    public void deleteCustomer(@Argument Long id) {
        customerService.deleteCustomer(id);
    }
}
