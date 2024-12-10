package ma.projet.graph.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data // Lombok annotation for getters, setters, etc.
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant; // Amount

    @Temporal(TemporalType.DATE)
    private Date date; // Date

    @Enumerated(EnumType.STRING)
    private TypeTransaction type; // Type (DEPOT or RETRAIT)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compte_id")
    private Compte compte; // Linked account
}

