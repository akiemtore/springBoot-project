package ma.ensate.projectpatientjpa.Repositories;

import ma.ensate.projectpatientjpa.Entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface consultationRepository extends JpaRepository<Consultation, Long> {
}
