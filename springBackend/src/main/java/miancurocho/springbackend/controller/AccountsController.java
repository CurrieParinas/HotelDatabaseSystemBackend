package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Accounts;
import miancurocho.springbackend.service.AccountsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountsController {
    private final AccountsService accountsService;

    @GetMapping(path="/allAccounts")
    public List<Accounts> displayAccounts(){return accountsService.getAllAccounts();}

    @GetMapping(path="/getAccount/{employeeId}")
    public Accounts getAccount(@PathVariable Long employeeId){return accountsService.getAccount(employeeId);}

    @PostMapping(path= "/addAccount")
    public @ResponseBody Accounts addAccount(@RequestBody Accounts accountToAdd){
        return accountsService.addAccount(accountToAdd);
    }

    @PostMapping(path="/deleteAccountById/{employeeId}")
    public void deleteAccountById(@PathVariable Long employeeId){accountsService.deleteAccountById(employeeId);}

    @PostMapping(path="/updateAccount")
    public @ResponseBody Accounts updateAccount(@RequestBody Accounts accountToUpdate){
        return accountsService.updateAccount(accountToUpdate);
    }
}
