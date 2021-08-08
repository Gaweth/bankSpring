package pl.sda.springbootbank.service;


import pl.sda.springbootbank.exceptions.ClientAccountNotFoundException;
import pl.sda.springbootbank.exceptions.InsufficientBalanceException;
import pl.sda.springbootbank.model.ClientAccount;

import java.math.BigDecimal;

public interface ClientAccountService {

    ClientAccount getById(Integer id);

    ClientAccount getBuNumber(String number) throws ClientAccountNotFoundException;

    void transfer(Integer srcId, String destNumber, BigDecimal amount)
            throws ClientAccountNotFoundException, InsufficientBalanceException;




}
