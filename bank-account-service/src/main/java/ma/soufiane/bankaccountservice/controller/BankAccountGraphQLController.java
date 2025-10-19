package ma.soufiane.bankaccountservice.controller;

import lombok.AllArgsConstructor;
import ma.soufiane.bankaccountservice.dto.BankAccountRequest;
import ma.soufiane.bankaccountservice.dto.BankAccountResponse;
import ma.soufiane.bankaccountservice.service.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccountResponse> accountList() {
        return bankAccountService.getAllBankAccounts();
    }

    @QueryMapping
    public BankAccountResponse accountById(@Argument String id) {
        return bankAccountService.getBankAccountById(id).orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    @MutationMapping
    public BankAccountResponse createAccount(@Argument BankAccountRequest bankAccount) {
        return bankAccountService.saveBankAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponse updateAccount(@Argument String id,@Argument BankAccountRequest bankAccount) {
        return bankAccountService.updateBankAccount(id, bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id) {
        bankAccountService.deleteBankAccount(id);
    }


}
