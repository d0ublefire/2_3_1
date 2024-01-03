package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }
   private final UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public User getUser(long id) {
      return userDao.getUser(id);
   }
   @Transactional
   @Override
   public void update(User user) {
      userDao.update(user);
   }

   @Transactional
   @Override
   public void remove(long id) {
      userDao.remove(id);
   }

   @Transactional (readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
