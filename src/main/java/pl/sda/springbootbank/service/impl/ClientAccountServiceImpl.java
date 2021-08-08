package pl.sda.springbootbank.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.springbootbank.exceptions.ClientAccountNotFoundException;
import pl.sda.springbootbank.exceptions.InsufficientBalanceException;
import pl.sda.springbootbank.model.ClientAccount;
import pl.sda.springbootbank.repository.ClientAccountRepository;
import pl.sda.springbootbank.service.ClientAccountService;

import java.math.BigDecimal;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    private final ClientAccountRepository accountRepository;

    public ClientAccountServiceImpl(ClientAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ClientAccount getById(Integer id) {
        return accountRepository.getById(id);
    }

    @Override
    public ClientAccount getBuNumber(String number) throws ClientAccountNotFoundException {
        ClientAccount account = accountRepository.findByNumber(number);

        if (account == null) {
            throw new ClientAccountNotFoundException("nie znaleziono klienta " + number);
        }
        return account;
    }

    @Override
    public void transfer(Integer srcId, String destNumber, BigDecimal amount) throws ClientAccountNotFoundException, InsufficientBalanceException {

        ClientAccount srcAccount = accountRepository.getById(srcId);

        if (srcAccount.getBalance().compareTo(amount) < 0){
            throw new InsufficientBalanceException(" za malo sreodkow do wykonania przelewu na kwote " + amount);
        }

        ClientAccount destAccount = getBuNumber(destNumber);

        srcAccount.setBalance(srcAccount.getBalance().subtract(amount));
        destAccount.setBalance(destAccount.getBalance().add(amount));

        accountRepository.save(srcAccount);
        accountRepository.save(destAccount);


        //TODO zapis historii
    }
}
