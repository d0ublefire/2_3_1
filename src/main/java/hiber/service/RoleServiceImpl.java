package hiber.service;

import hiber.dao.RoleDao;
import hiber.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addUser(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

//    public List<Role> getRoleByName(){
//        return roleDao.getRoleByName()
//    }

    @Override
    public Role getRolesByEmail(String email) {
        return null;
    }
}
