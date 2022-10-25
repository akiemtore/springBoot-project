package ma.ensate.projectpatientjpa.Repositories;

import ma.ensate.projectpatientjpa.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface patientDao extends JpaRepository <Patient, Long> {

     List<Patient> findByMalade(boolean m);
     Page<Patient> findByMalade(boolean m , Pageable pageable);

    List<Patient> findByMaladeAndScoreLessThan(boolean m , int score);

    List<Patient> findByMaladeIsTrueAndScoreLessThan( int score);

    @Query("select p from Patient p where p.nom LIKE :x and p.score<:y")
    List<Patient> chercherPatients( @Param("x") String mc , @Param("y")int scoreMin);
}
