package tingeso.simulate_service.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationEntity {
    private int loanAmount;
    float mensualInterestRate;
    int totalPayments;
    double monthlyPayment;
}
