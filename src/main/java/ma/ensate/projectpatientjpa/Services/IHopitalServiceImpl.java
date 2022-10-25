package ma.ensate.projectpatientjpa.Services;

import ma.ensate.projectpatientjpa.Entities.Consultation;
import ma.ensate.projectpatientjpa.Entities.Medecin;
import ma.ensate.projectpatientjpa.Entities.Patient;
import ma.ensate.projectpatientjpa.Entities.RendezVous;
import ma.ensate.projectpatientjpa.Repositories.consultationRepository;
import ma.ensate.projectpatientjpa.Repositories.medecinRepository;
import ma.ensate.projectpatientjpa.Repositories.patientRepository;
import ma.ensate.projectpatientjpa.Repositories.rendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional

public class IHopitalServiceImpl implements IHopitalService{

    private patientRepository patientRepository;

    private medecinRepository medecinRepository;

    private consultationRepository consultationRepository;

    private rendezVousRepository rendezVousRepository;

    public IHopitalServiceImpl(patientRepository patientRepository, medecinRepository medecinRepository ,consultationRepository consultationRepository ,rendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository=medecinRepository;
        this.rendezVousRepository=rendezVousRepository;
        this.consultationRepository=consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {

        return this.patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return this.medecinRepository.save(medecin);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return this.consultationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
            rendezVous.setId(UUID.randomUUID().toString());
        return this.rendezVousRepository.save(rendezVous);
    }
}
