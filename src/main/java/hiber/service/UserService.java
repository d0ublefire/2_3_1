package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User getUser(long id);

    List<User> listUsers();

    void update(User user);

    void remove(long id);
}
