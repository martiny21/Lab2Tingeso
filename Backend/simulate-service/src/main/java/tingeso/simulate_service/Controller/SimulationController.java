package tingeso.simulate_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tingeso.simulate_service.Entities.SimulationEntity;
import tingeso.simulate_service.Services.SimulationService;

@RestController
@RequestMapping("/simulations")
public class SimulationController {

    @Autowired
    SimulationService simulationService;

    @PostMapping("/simulateLoan")
    public ResponseEntity<SimulationEntity> simulateLoan(@RequestParam int loanAmount,
                                                         @RequestParam float annualInterestRate,
                                                         @RequestParam int years){
        try {
            SimulationEntity simulation = simulationService.simulateLoan(loanAmount, annualInterestRate, years);
            return ResponseEntity.ok(simulation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
