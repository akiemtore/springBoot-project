package ma.ensate.projectpatientjpa;

import ma.ensate.projectpatientjpa.Entities.*;
import ma.ensate.projectpatientjpa.Repositories.*;
import ma.ensate.projectpatientjpa.Security.Service.securityService;
import ma.ensate.projectpatientjpa.Services.IHopitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjectPatientJpaApplication  {

    public static void main(String[] args) {

        SpringApplication.run(ProjectPatientJpaApplication.class, args);
    }
            //@Bean
       CommandLineRunner start(securityService securityService ){

            return args -> {
               securityService.saveNewUser("Amed" ,"1234","1234");
                securityService.saveNewUser("Gerald" ,"1234","1234");
                securityService.saveNewUser("Shella" ,"1234","1234");
                securityService.saveNewUser("Aurelie" ,"1234","1234");

                securityService.saveNewRole("USER" ,"");
                securityService.saveNewRole("ADMIN" ,"");

                securityService.addRoleToUser("Amed" ,"ADMIN");
                securityService.addRoleToUser("Shella" ,"ADMIN");
                securityService.addRoleToUser("Gerald" ,"USER");
                securityService.addRoleToUser("Aurelie" ,"USER");

            } ;
            }
    }

