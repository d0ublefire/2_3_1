package hiber.dao;

import hiber.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<Role> getRoles();

    void addRole(Role role);

//    List<Role> getRoleByName();
}
