package pl.sda.springbootbank.service;

import pl.sda.springbootbank.model.Client;
import pl.sda.springbootbank.model.ClientAccount;

import java.util.ArrayList;
import java.util.List;


public interface ClientService {

    List<Client> getAll();

    void addAccount(ClientAccount clientAccount);




}
