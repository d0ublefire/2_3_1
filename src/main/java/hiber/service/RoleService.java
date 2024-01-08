package hiber.service;

import hiber.model.Role;
import hiber.model.User;

import java.util.List;

public interface RoleService {
    void addUser(Role role);
    List<Role> getRoles();

    Role getRolesByEmail(String email) ;
}
