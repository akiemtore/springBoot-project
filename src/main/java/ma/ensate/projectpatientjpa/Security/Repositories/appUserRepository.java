package ma.ensate.projectpatientjpa.Security.Repositories;

import ma.ensate.projectpatientjpa.Security.Entities.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appUserRepository  extends JpaRepository<appUser, String> {

    public appUser findByUsername( String username);
}
