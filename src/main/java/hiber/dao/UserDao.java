package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
   User findByUserEmail(String email);
   void addUser(User user);

   User getUser(long id);

   List<User> listUsers();

   void update(User user);

   void remove(long id);
}
