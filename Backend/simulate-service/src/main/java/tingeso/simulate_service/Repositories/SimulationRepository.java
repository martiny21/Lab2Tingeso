package tingeso.simulate_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingeso.simulate_service.Entities.SimulationEntity;

import java.util.List;

@Repository
public interface SimulationRepository extends JpaRepository<SimulationEntity, Long> {
    public List<SimulationEntity> findByUserId(Long userId);
}
