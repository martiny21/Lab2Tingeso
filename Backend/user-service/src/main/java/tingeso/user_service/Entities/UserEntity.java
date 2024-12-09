package tingeso.user_service.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String rut;
    private LocalDate birthDate;
    private long salary;
    //Variable to indicate if the profile is everything ready
    private boolean ready;

    //Is the user identity document valid
    @Column(nullable = false)
    private boolean itIsDocumentIdentity;

    @Column(nullable = false)
    //Is the user income document valid
    private boolean itIsDocumentIncome;
}
