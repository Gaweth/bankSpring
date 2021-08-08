package pl.sda.springbootbank.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.springbootbank.model.Client;
import pl.sda.springbootbank.model.ClientAccount;
import pl.sda.springbootbank.repository.ClientRepository;
import pl.sda.springbootbank.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void addAccount(ClientAccount clientAccount) {

    }
}
