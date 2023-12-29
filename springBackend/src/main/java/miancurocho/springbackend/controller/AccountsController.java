package miancurocho.springbackend.controller;

import lombok.RequiredArgsConstructor;
import miancurocho.springbackend.entities.Accounts;
import miancurocho.springbackend.service.AccountsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/accounts")
public class AccountsController {
    private final AccountsService accountsService;

    @GetMapping(path="/all")
    public List<Accounts> displayAccounts(){return accountsService.getAllAccounts();}

    @GetMapping(path="/{employeeId}")
    public Accounts getAccount(@PathVariable Long employeeId){return accountsService.getAccount(employeeId);}

    @PostMapping(path= "/add")
    public @ResponseBody Accounts addAccount(@RequestBody Accounts accountToAdd){
        return accountsService.addAccount(accountToAdd);
    }

    @PostMapping(path="/delete/{employeeId}")
    public void deleteAccountById(@PathVariable Long employeeId){accountsService.deleteAccountById(employeeId);}

    @PostMapping(path="/update")
    public @ResponseBody Accounts updateAccount(@RequestBody Accounts accountToUpdate){
        return accountsService.updateAccount(accountToUpdate);
    }

    @GetMapping(path="/getId")
    public @ResponseBody Long getEmployeeIdByEmailAndPassword(@RequestBody Accounts accountToGet) {
        return accountsService.getEmployeeIdByEmailAndPassword(accountToGet);
    }
}
