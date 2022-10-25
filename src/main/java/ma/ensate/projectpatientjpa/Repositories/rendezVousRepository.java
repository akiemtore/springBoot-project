package ma.ensate.projectpatientjpa.Repositories;


import ma.ensate.projectpatientjpa.Entities.Patient;
import ma.ensate.projectpatientjpa.Entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rendezVousRepository extends JpaRepository<RendezVous, String> {

    RendezVous findByPatient(Patient patient);
}
