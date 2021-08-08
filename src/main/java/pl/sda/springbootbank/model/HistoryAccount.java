package pl.sda.springbootbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoryAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 26)
    private String number;

    @Column(nullable = false, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime transferDate;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private ClientAccount clientAccount;
}
