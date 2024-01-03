package hiber.dao;

import hiber.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(long id) {
      return entityManager.find(User.class, id);
   }


   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }

//   @Override
//   public void remove(long id) {
//      entityManager.remove(entityManager.find(User.class, id));
//   }

   @Override
   public void remove(long id) {
      entityManager.remove(getUser(id));
   }

}
