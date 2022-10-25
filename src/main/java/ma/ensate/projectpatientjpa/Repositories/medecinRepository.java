package ma.ensate.projectpatientjpa.Repositories;

import ma.ensate.projectpatientjpa.Entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medecinRepository extends JpaRepository<Medecin, Long> {

    Medecin findByNom(String nom);
}
