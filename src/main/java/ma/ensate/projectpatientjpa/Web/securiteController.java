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

@Controller
public class securiteController {

    @GetMapping(path = "/403")
    public String notAuthaurize(){
        return "403";
    }

    }

