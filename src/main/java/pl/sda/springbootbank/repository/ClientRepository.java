package pl.sda.springbootbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springbootbank.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
