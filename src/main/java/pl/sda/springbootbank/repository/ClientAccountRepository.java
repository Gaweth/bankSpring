package pl.sda.springbootbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootbank.model.ClientAccount;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, Integer> {

    ClientAccount findByNumber(String number);


}
