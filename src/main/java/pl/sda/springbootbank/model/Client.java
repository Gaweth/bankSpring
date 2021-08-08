package pl.sda.springbootbank.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String surname;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 11, unique = true)
    private String pesel;

    @OneToMany(mappedBy = "client")
    List<ClientAccount> accounts = new ArrayList<>();


}
