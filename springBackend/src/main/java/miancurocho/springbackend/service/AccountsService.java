package miancurocho.springbackend.service;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Accounts;
import miancurocho.springbackend.repository.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountsService {
    private final AccountsRepository accountsRepository;

    public List<Accounts> getAllAccounts(){return accountsRepository.findAll();}

    public Accounts getAccount(Long employeeId){return accountsRepository.findByEmployeeId(employeeId);}

    public Accounts addAccount(Accounts accountToAdd){return accountsRepository.save(accountToAdd);}
    public void deleteAccountById(Long employeeId){accountsRepository.deleteById(employeeId);}

    public Accounts updateAccount(Accounts accountToUpdate){
        Optional<Accounts> optionalExistingAccount = accountsRepository.findById(accountToUpdate.getEmployeeId());

        if(optionalExistingAccount.isPresent()){
            Accounts existingAccount = optionalExistingAccount.get();

            if(accountToUpdate.getEmail() != null){
                existingAccount.setEmail(accountToUpdate.getEmail());
            }
            if(accountToUpdate.getPassword() != null) {
                existingAccount.setPassword(accountToUpdate.getPassword());
            }

            return accountsRepository.save(existingAccount);
        }
        return null;
    }

    public List<Map<String, Object>> getEmployeeIdAndTypeByEmailAndPassword(String email, String password) {
        return accountsRepository.findIdANDEmployeeTypeByEmailAndPassword(email, password);
    }
}
