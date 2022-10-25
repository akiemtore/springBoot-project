package ma.ensate.projectpatientjpa.Repositories;

import ma.ensate.projectpatientjpa.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<Patient, Long> {

    public Page<Patient> findByNomContains(String nom , Pageable pageable);
}
