package ma.ensate.projectpatientjpa.Security.Service;

import lombok.extern.slf4j.Slf4j;
import ma.ensate.projectpatientjpa.Security.Entities.appRole;
import ma.ensate.projectpatientjpa.Security.Entities.appUser;
import ma.ensate.projectpatientjpa.Security.Repositories.appRoleRepository;
import ma.ensate.projectpatientjpa.Security.Repositories.appUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@Transactional
public class securityServiceImpl implements  securityService{

    private appUserRepository appUserRepository;
     private PasswordEncoder passwordEncoder;
    private appRoleRepository appRoleRepository;

    public securityServiceImpl(appUserRepository appUserRepository ,appRoleRepository appRoleRepository ,PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository= appRoleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public appUser saveNewUser(String username, String password, String rePassword) {
        if(password != rePassword) new RuntimeException("Password not match");
        String hashedpass= this.passwordEncoder.encode(password);
        appUser appUser= new appUser();
        appUser.setUserID(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hashedpass);
        appUser.setActive(true);
        appUser savedAppUser=this.appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public appRole saveNewRole(String rolename, String description) {
        appRole AppRole = new appRole();
        appRole testAppRole = this.appRoleRepository.findByRoleName(rolename);
        if(testAppRole != null) new RuntimeException("Role existe");
            AppRole.setRoleName(rolename);
            AppRole.setDescription(description);
            appRole savedAppRole= this.appRoleRepository.save(AppRole);
            return savedAppRole;

    }

    @Override
    public void addRoleToUser(String username, String rolename) {

        appUser  retrieveAppUser= this.appUserRepository.findByUsername(username);
        if(retrieveAppUser == null) new RuntimeException("User n'existe pas");
        appRole retrieveAppRole = this.appRoleRepository.findByRoleName(rolename);
        if(retrieveAppRole == null) new RuntimeException("Role n'existe pas");
        retrieveAppUser.getApproles().add(retrieveAppRole);
    }

    @Override
    public void removeRoleFromUser(String username, String rolename) {

    }

    @Override
    public appUser loadUserByUserName(String username) {
        return this.appUserRepository.findByUsername(username);
    }
}
