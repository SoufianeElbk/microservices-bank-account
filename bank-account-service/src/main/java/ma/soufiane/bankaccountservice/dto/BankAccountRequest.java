package ma.soufiane.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soufiane.bankaccountservice.entity.AccountType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequest {
    private Double balance;
    private String currency;
    private AccountType type;
}
