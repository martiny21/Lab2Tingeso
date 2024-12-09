package tingeso.simulate_service.Services;

import org.springframework.stereotype.Service;
import tingeso.simulate_service.Entities.SimulationEntity;

@Service
public class SimulationService {
    public SimulationEntity simulateLoan(int loanAmount, float AnnualInterestRate, int years){
        float mensualInterestRate = AnnualInterestRate / 12 / 100;
        int totalPayments = years * 12;
        double monthlyPayment = (loanAmount * mensualInterestRate) / (1 - Math.pow(1 + mensualInterestRate, -totalPayments));
        return new SimulationEntity(loanAmount, mensualInterestRate, totalPayments, monthlyPayment);
    }
}
