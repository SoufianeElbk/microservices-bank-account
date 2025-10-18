package ma.soufiane.bankaccountservice.controller;


import lombok.AllArgsConstructor;
import ma.soufiane.bankaccountservice.dto.BankAccountRequest;
import ma.soufiane.bankaccountservice.dto.BankAccountResponse;
import ma.soufiane.bankaccountservice.entity.BankAccount;
import ma.soufiane.bankaccountservice.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bankAccounts")
@AllArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccountResponse> getAllBankAccounts(){
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("{id}")
    public ResponseEntity<BankAccountResponse> getBankAccountById(@PathVariable String id){
        return ResponseEntity.ok(bankAccountService.getBankAccountById(id).orElseThrow(
                () -> new RuntimeException("Bank account not found")
        ));
    }

    @PostMapping
    public ResponseEntity<BankAccountResponse> createBankAccount(@RequestBody BankAccountRequest bankAccount){
        return ResponseEntity.ok(bankAccountService.saveBankAccount(bankAccount));
    }

    @PutMapping("{id}")
    public ResponseEntity<BankAccountResponse> updateBankAccount(@PathVariable String id, @RequestBody BankAccountRequest bankAccount){
        return ResponseEntity.ok(bankAccountService.updateBankAccount(id, bankAccount));
    }

    @DeleteMapping("{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
    }
}
