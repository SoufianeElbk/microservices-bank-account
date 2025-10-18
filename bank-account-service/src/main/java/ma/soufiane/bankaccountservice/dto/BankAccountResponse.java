package ma.soufiane.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soufiane.bankaccountservice.entity.AccountType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountResponse {
    private String id;
    private LocalDateTime createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
