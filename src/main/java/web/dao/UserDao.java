package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    User getUser(long id);
    List<User> getAllUsers();
    List<User> getUsers(int count);
    void delete(long id);
}
