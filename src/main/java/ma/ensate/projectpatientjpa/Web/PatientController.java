package ma.ensate.projectpatientjpa.Web;

import ma.ensate.projectpatientjpa.Entities.Patient;
import ma.ensate.projectpatientjpa.Repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
  private patientRepository patientRepository ;


    @GetMapping(path = "/")
    public String allPatients(Model model ,
                              @RequestParam(name = "page" ,defaultValue = "0") int page ,
                              @RequestParam(name="size", defaultValue = "4") int size ,
                              @RequestParam(name="motCle" ,defaultValue = "") String motCle)
    {
        Page<Patient> pagePatients= patientRepository.findByNomContains(motCle,PageRequest.of(page,size));
        model.addAttribute("pagePatients" ,pagePatients);
        model.addAttribute("currentPage" ,page);
        model.addAttribute("size" ,size);
        model.addAttribute("motCle" ,motCle);
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        return "patients";
    }
    @GetMapping(path = "/patients")
    public String TousPatients(Model model ,
                              @RequestParam(name = "page" ,defaultValue = "0") int page ,
                              @RequestParam(name="size", defaultValue = "4") int size ,
                              @RequestParam(name="motCle" ,defaultValue = "") String motCle)
    {
        Page<Patient> pagePatients= patientRepository.findByNomContains(motCle,PageRequest.of(page,size));
        model.addAttribute("pagePatients" ,pagePatients);
        model.addAttribute("currentPage" ,page);
        model.addAttribute("size" ,size);
        model.addAttribute("motCle" ,motCle);
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        return "patients";
    }

    @GetMapping(path = "/delete")
    public String deletePatient(@RequestParam(name ="id") Long id , int page, int size ,String motCle){
        patientRepository.deleteById(id);

        return "redirect:/patients?page="+page+"&size="+size+"&motCle="+motCle;
    }

    @GetMapping(path = "/formPatient")
    public String EditPatient(Model model){
        model.addAttribute("patient" ,new Patient());
        return "formPatient";
    }

    @PostMapping(path = "/save")

    public String savePatient(Model model , @Valid Patient patient , BindingResult bindingResult , @RequestParam(name = "page" ,defaultValue = "0") int page
             ,@RequestParam(name="motCle" ,defaultValue = "")String motCle){
        if(bindingResult.hasErrors()) return "formPatient";
         patientRepository.save(patient);
        return "redirect:patients?page="+page+"&motCle="+motCle;
    }

    @GetMapping(path = "/modifierPatient")
    public String deletePatient(Model model ,@RequestParam(name ="id") Long id ,int page,String motCle){
        Patient founded = patientRepository.findById(id).orElse(null);
        if (founded != null) {
            model.addAttribute("patient", founded);
            model.addAttribute("motCle", motCle);
            model.addAttribute("page", page);
        }
        else{
            new RuntimeException("Patient not founed");
        }
        return "modifPatient";
    }
}
