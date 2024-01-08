package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    User findByUserEmail(String email);

    void addUser(User user);

    User getUser(long id);

    List<User> listUsers();

    void updateUser(User user);

    void removeUser(long id);
}
