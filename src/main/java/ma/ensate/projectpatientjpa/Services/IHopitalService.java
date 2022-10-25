package ma.ensate.projectpatientjpa.Services;

import ma.ensate.projectpatientjpa.Entities.Consultation;
import ma.ensate.projectpatientjpa.Entities.Medecin;
import ma.ensate.projectpatientjpa.Entities.Patient;
import ma.ensate.projectpatientjpa.Entities.RendezVous;

public interface IHopitalService {

    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    Consultation saveConsultation(Consultation consultation);

    RendezVous saveRendezVous(RendezVous rendezVous);
}
