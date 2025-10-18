package ma.soufiane.bankaccountservice.service;

import lombok.AllArgsConstructor;
import ma.soufiane.bankaccountservice.dto.BankAccountRequest;
import ma.soufiane.bankaccountservice.dto.BankAccountResponse;
import ma.soufiane.bankaccountservice.entity.BankAccount;
import ma.soufiane.bankaccountservice.mapper.BankAccountMapper;
import ma.soufiane.bankaccountservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public Optional<BankAccountResponse> getBankAccountById(String id) {
        return bankAccountRepository.findById(id)
                .map(BankAccountMapper::toResponse);
    }

    public List<BankAccountResponse> getAllBankAccounts() {
        return bankAccountRepository.findAll().stream().map(BankAccountMapper::toResponse).toList();
    }

    public BankAccountResponse saveBankAccount(BankAccountRequest bankAccount) {
        BankAccount bankAccountEntity = BankAccountMapper.toEntity(bankAccount);
        bankAccountEntity.setCreatedAt(LocalDateTime.now());
        return BankAccountMapper.toResponse(bankAccountRepository.save(bankAccountEntity));
    }

    public BankAccountResponse updateBankAccount(String id, BankAccountRequest bankAccount) {
        BankAccount acc = bankAccountRepository.findById(id).orElseThrow();
        if (acc.getBalance() != null) {
            acc.setBalance(bankAccount.getBalance());
        }
        if (acc.getCurrency() != null) {
            acc.setCurrency(bankAccount.getCurrency());
        }
        if (acc.getType() != null) {
            acc.setType(bankAccount.getType());
        }
        return BankAccountMapper.toResponse(bankAccountRepository.save(acc));
    }

    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
