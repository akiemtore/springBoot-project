package ma.ensate.projectpatientjpa.Security.Service;

import ma.ensate.projectpatientjpa.Security.Entities.appRole;
import ma.ensate.projectpatientjpa.Security.Entities.appUser;

public interface securityService {

     appUser saveNewUser(String username,String password,String rePassword);

    appRole saveNewRole(String rolename, String description);

     void addRoleToUser(String username, String rolename);

     void removeRoleFromUser(String username, String rolename);

     appUser loadUserByUserName(String username);
}
