package hiber.service;

import hiber.dao.RoleDao;
import hiber.dao.UserDao;
import hiber.model.Role;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   private final UserDao userDao;
   private final RoleDao roleDao;
   private final PasswordEncoder passwordEncoder;
   @Autowired
   public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
       this.userDao = userDao;
       this.roleDao = roleDao;
       this.passwordEncoder = passwordEncoder;
   }


   @Transactional
   @Override
   public User findByUserEmail(String email){
      return userDao.findByUserEmail(email);
   }
   @Transactional
   @Override
   public void addUser(User user) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRoles(roleDao.getRoles());
      userDao.addUser(user);
   }

   @Transactional
   @Override
   public User getUser(long id) {
      return userDao.getUser(id);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.update(user);
   }

   @Transactional
   @Override
   public void removeUser(long id) {
      userDao.remove(id);
   }

   @Transactional (readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


//   @PostConstruct
//   public void addTestUsers() {
//      roleDao.addRole(new Role(1L, "ROLE_ADMIN"));
//      roleDao.addRole(new Role(2L, "ROLE_USER"));
//      User newAdmin = new User("admin", "admin", "admin@admin", roleDao.getRoles());
//      addUser(newAdmin);
//      User newUser = new User("user", "user", "user@user", roleDao.getRoles());
//      addUser(newUser);
//   }

}
