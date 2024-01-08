package hiber.dao;

import hiber.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public User findByUserEmail(String email) {
      String query = "Select user from User user left join fetch user.roles where user.email=:email";
      User user = entityManager.createQuery(query, User.class).setParameter("email", email).getSingleResult();
      if (user == null) {
         throw new UsernameNotFoundException("User " + email + " not found");
      }
      return user;
   }

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(long id) {
      return entityManager.find(User.class, id);
   }


   @Override
   public List<User> listUsers() {
      System.out.println(entityManager.createQuery("FROM User", User.class).getResultList());
      return entityManager.createQuery("FROM User", User.class).getResultList();
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }


   @Override
   public void remove(long id) {
      entityManager.remove(getUser(id));
   }

}
