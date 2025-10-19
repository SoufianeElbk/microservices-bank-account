package ma.soufiane.bankaccountservice.mapper;

import ma.soufiane.bankaccountservice.dto.BankAccountRequest;
import ma.soufiane.bankaccountservice.dto.BankAccountResponse;
import ma.soufiane.bankaccountservice.entity.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public static BankAccount toEntity(BankAccountRequest bankAccount){
        BankAccount bankAccountEntity = new BankAccount();
        bankAccountEntity.setBalance(bankAccount.getBalance());
        bankAccountEntity.setCurrency(bankAccount.getCurrency());
        bankAccountEntity.setType(bankAccount.getType());
        return bankAccountEntity;
    }

    public static BankAccount toEntity(BankAccountResponse bankAccount){
        BankAccount bankAccountEntity = new BankAccount();
        bankAccountEntity.setId(bankAccount.getId());
        bankAccountEntity.setCreatedAt(bankAccount.getCreatedAt());
        bankAccountEntity.setBalance(bankAccount.getBalance());
        bankAccountEntity.setCurrency(bankAccount.getCurrency());
        bankAccountEntity.setType(bankAccount.getType());
        return bankAccountEntity;
    }

    public static BankAccountRequest toRequest(BankAccount bankAccount){
        BankAccountRequest bankAccountRequest = new BankAccountRequest();
        bankAccountRequest.setBalance(bankAccount.getBalance());
        bankAccountRequest.setCurrency(bankAccount.getCurrency());
        bankAccountRequest.setType(bankAccount.getType());
        return bankAccountRequest;
    }

    public static BankAccountResponse toResponse(BankAccount bankAccount){
        BankAccountResponse bankAccountResponse = new BankAccountResponse();
        bankAccountResponse.setId(bankAccount.getId());
        bankAccountResponse.setCreatedAt(bankAccount.getCreatedAt());
        bankAccountResponse.setBalance(bankAccount.getBalance());
        bankAccountResponse.setCurrency(bankAccount.getCurrency());
        bankAccountResponse.setType(bankAccount.getType());
        bankAccountResponse.setCustomer(bankAccount.getCustomer());
        return bankAccountResponse;
    }
}
