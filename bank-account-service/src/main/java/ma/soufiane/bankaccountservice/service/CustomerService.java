package ma.soufiane.bankaccountservice.service;

import lombok.AllArgsConstructor;
import ma.soufiane.bankaccountservice.dto.BankAccountRequest;
import ma.soufiane.bankaccountservice.dto.BankAccountResponse;
import ma.soufiane.bankaccountservice.dto.CustomerRequest;
import ma.soufiane.bankaccountservice.dto.CustomerResponse;
import ma.soufiane.bankaccountservice.entity.BankAccount;
import ma.soufiane.bankaccountservice.entity.Customer;
import ma.soufiane.bankaccountservice.mapper.BankAccountMapper;
import ma.soufiane.bankaccountservice.mapper.CustomerMapper;
import ma.soufiane.bankaccountservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<CustomerResponse> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::toResponse);
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::toResponse).toList();
    }

    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerMapper.toEntity(customerRequest);
        return CustomerMapper.toResponse(customerRepository.save(customer));
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        if (customerRequest.getName() != null) {
            customer.setName(customerRequest.getName());
        }
        return CustomerMapper.toResponse(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
