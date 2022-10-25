package ma.ensate.projectpatientjpa.Security.Repositories;

import ma.ensate.projectpatientjpa.Security.Entities.appRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appRoleRepository extends JpaRepository<appRole, String> {

    public appRole findByRoleName(String rolename);
}
