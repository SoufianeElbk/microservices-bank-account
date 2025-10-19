package ma.soufiane.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soufiane.bankaccountservice.entity.AccountType;
import ma.soufiane.bankaccountservice.entity.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequest {
    private Double balance;
    private String currency;
    private AccountType type;
    private Long customerId;
}
